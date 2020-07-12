package com.template.nanamare.ext


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replaceFragmentInActivity(
    fragmentClazz: Class<out Fragment>,
    frameId: Int,
    args: Bundle
) {
    supportFragmentManager.transact {
        replace(frameId, fragmentClazz, args, "$fragmentClazz")
    }
}

fun AppCompatActivity.addFragmentInActivity(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact {
        add(frameId, fragment)
    }
}

fun AppCompatActivity.showToast(msg: String) {
    Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
}