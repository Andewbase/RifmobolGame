package com.example.rifmobol2.data.entity

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes

data class RoundInfo(
    val id: Int,
    @StringRes val numberRound: Int,
    @DrawableRes val backgroundImage: Int,
    @StringRes val couplet: Int,
    val upLeftButton: GameButton,
    val upRightButton: GameButton,
    val bottomLeftButton: GameButton,
    val bottomRightButton: GameButton,
    @RawRes val musicOne: Int,
    @RawRes val musicTwo: Int
)