package com.example.rifmobol2.screen.single

import androidx.navigation.NavController

sealed interface SingleGameEvent {

    data class UpLeftButtonClick(val navController: NavController): SingleGameEvent
    data class UpRightButtonClick(val navController: NavController): SingleGameEvent
    data class BottomLeftButtonCLick(val navController: NavController): SingleGameEvent
    data class BottomRightButtonClick(val navController: NavController): SingleGameEvent
    data object Resume: SingleGameEvent
    data object Pause : SingleGameEvent

}