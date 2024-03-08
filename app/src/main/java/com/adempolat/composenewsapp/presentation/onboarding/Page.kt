package com.adempolat.composenewsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.adempolat.composenewsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(title = "Haberler","En gnücel haberler burada", image = R.drawable.onboarding1),
    Page(title = "Son Dakika","bize güvenin sdsssfsf", image = R.drawable.onboarding2),
    Page(title = "HaLorer","En gnücdfdfdfdsfdfsdel haberler burada", image = R.drawable.onboarding3)
)
