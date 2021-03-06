package com.template.nanamare.presentation.base.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.template.nanamare.ext.transact
import com.template.nanamare.presentation.base.navigator.BaseNavigator


abstract class BaseDialogFragment<B : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    DialogFragment(), BaseNavigator {

    lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun networkError(errorCode: String) {
        if (isAdded) {
            (activity as? BaseActivity<*>)?.networkError(errorCode)
        }
    }

    override fun showToast(resId: Int, error: Boolean) {
        if (isAdded) {
            context?.let {
                showToast(it.getString(resId))
            }
        }
    }

    override fun showToast(msg: String, error: Boolean) {
        if (isAdded) {
            (activity as? BaseActivity<*>)?.showToast(msg)
        }
    }

    override fun showLoadingPopup() {
        if (isAdded) {
            (activity as? BaseActivity<*>)?.showLoadingPopup()
        }
    }

    override fun hideLoadingPopup() {
        if (isAdded) {
            (activity as? BaseActivity<*>)?.hideLoadingPopup()
        }
    }

    override fun show(manager: FragmentManager, tag: String?) {
        manager.transact {
            add(this@BaseDialogFragment, tag)
        }
    }

    fun show(manager: FragmentManager, clazz: Class<out Fragment>, args: Bundle, tag: String?) {
        manager.transact {
            add(clazz, args, tag)
        }
    }

    override fun logFirebaseEvent(name: String, params: Bundle?) {
        if (isAdded) {
            (activity as? BaseActivity<*>)?.logFirebaseEvent(name, params)
        }
    }

    override fun hideKeyboard() {
        (activity as? BaseActivity<*>)?.hideKeyboard()
    }

    override fun errorHandling(errorCode: String) {
        if (isAdded) {
            (activity as? BaseActivity<*>)?.errorHandling(errorCode)
        }
    }
}
