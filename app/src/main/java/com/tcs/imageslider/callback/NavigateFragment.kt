package com.tcs.imageslider.callback

import androidx.fragment.app.Fragment

interface NavigateFragment {
    fun onShowFragment(
        fragment: Fragment, name: String, addTobackStack: Boolean,
        clearToBackStack: Boolean, showAnimation: Boolean
    )


}