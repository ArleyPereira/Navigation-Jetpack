package com.example.navigationcomponentapp.extensions

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.navigationcomponentapp.R

private val navToptions = NavOptions.Builder()
    .setEnterAnim(R.anim.slide_in_right)
    .setExitAnim(R.anim.slide_out_left)
    .setPopEnterAnim(R.anim.slide_in_left)
    .setPopEnterAnim(R.anim.slide_out_right)
    .build()

fun NavController.navigateWithAnimations(destinationId: Int){
    this.navigate(destinationId, null, navToptions)
}