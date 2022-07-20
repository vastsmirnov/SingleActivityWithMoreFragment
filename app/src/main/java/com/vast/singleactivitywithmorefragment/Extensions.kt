package com.vast.singleactivitywithmorefragment

import androidx.fragment.app.Fragment

inline fun <reified T> Fragment.requireExtra(key: String): Lazy<T> {
    return lazy { requireArguments().get(key) as T }
}