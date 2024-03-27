package com.example.rifmobol2.screen.multiplayer.game

import androidx.navigation.NavController
import com.example.rifmobol2.screen.single.game.SingleGameEvent

sealed interface MultiPlayerGameEvent {

    data class UpLeftButtonClickP1(val navController: NavController): MultiPlayerGameEvent
    data class UpRightButtonClickP1(val navController: NavController): MultiPlayerGameEvent
    data class BottomLeftButtonCLickP1(val navController: NavController): MultiPlayerGameEvent
    data class BottomRightButtonClickP1(val navController: NavController): MultiPlayerGameEvent
    data class UpLeftButtonClickP2(val navController: NavController): MultiPlayerGameEvent
    data class UpRightButtonClickP2(val navController: NavController): MultiPlayerGameEvent
    data class BottomLeftButtonCLickP2(val navController: NavController): MultiPlayerGameEvent
    data class BottomRightButtonClickP2(val navController: NavController): MultiPlayerGameEvent
    data object PlayMusic: MultiPlayerGameEvent
    data object Resume: MultiPlayerGameEvent
    data object Pause : MultiPlayerGameEvent
}