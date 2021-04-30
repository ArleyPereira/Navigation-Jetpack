package com.example.navigationcomponentapp.extensions

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.dissmissError() {
    this.error = null
    this.isErrorEnabled = false
}