package com.template.nanamare.ext

import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.template.nanamare.presentation.base.ui.SimpleRecyclerView

@Suppress("UNCHECKED_CAST")
@BindingAdapter("replaceAll")
fun RecyclerView.replaceAll(list: List<Any>?) {
    (this.adapter as? SimpleRecyclerView.Adapter<Any, *>)?.run {
        replaceAll(list)
    }
}

@BindingAdapter("adapter")
fun RecyclerView.bindRecyclerViewAdapter(adapter: SimpleRecyclerView.Adapter<*, out ViewDataBinding>) {
    this.adapter = adapter
}
