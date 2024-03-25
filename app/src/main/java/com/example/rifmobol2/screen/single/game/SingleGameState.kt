package com.example.rifmobol2.screen.single.game

import androidx.annotation.ColorRes
import com.example.rifmobol2.R
import com.example.rifmobol2.data.entity.RoundInfo

data class SingleGameState(
    val idRound: Int? = null,
    val roundInfo: RoundInfo? = null,
    @ColorRes val upLeftButtonColor: Int = R.color.black,
    @ColorRes val upRightButtonColor: Int = R.color.black,
    @ColorRes val bottomLeftButtonColor: Int = R.color.black,
    @ColorRes val bottomRightButtonColor: Int = R.color.black,
    val enabledButtons: Boolean = true
)
