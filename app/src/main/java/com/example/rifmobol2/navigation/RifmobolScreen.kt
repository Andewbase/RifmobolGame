package com.example.rifmobol2.navigation

import androidx.annotation.StringRes
import com.example.rifmobol2.R

enum class RifmobolScreen(@StringRes val title: Int) {

    Splash(R.string.splash_screen),
    Menu(R.string.menu_screen),
    Rules(R.string.rules_screen),
    SingleMenu(R.string.single_menu_screen),
    SingleGame(R.string.single_game_screen),
    SingleDialog(R.string.single_game_dialog),
    Multiplayer(R.string.multiplayer_screen)

}