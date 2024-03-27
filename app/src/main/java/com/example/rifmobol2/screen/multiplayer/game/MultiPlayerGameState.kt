package com.example.rifmobol2.screen.multiplayer.game

import androidx.annotation.ColorRes
import com.example.rifmobol2.R
import com.example.rifmobol2.data.entity.RoundInfo

data class MultiPlayerGameState(
    val roundInfo: RoundInfo? = null,
    val scoreP1: Int = 0,
    val scoreP2: Int = 0,
    @ColorRes val upLeftButtonColorP1: Int = R.color.black,
    @ColorRes val upRightButtonColorP1: Int = R.color.black,
    @ColorRes val bottomLeftButtonColorP1: Int = R.color.black,
    @ColorRes val bottomRightButtonColorP1: Int = R.color.black,
    @ColorRes val upLeftButtonColorP2: Int = R.color.black,
    @ColorRes val upRightButtonColorP2: Int = R.color.black,
    @ColorRes val bottomLeftButtonColorP2: Int = R.color.black,
    @ColorRes val bottomRightButtonColorP2: Int = R.color.black,
    val enabledButtonsP1: Boolean = true,
    val enabledButtonsP2: Boolean = true
)
