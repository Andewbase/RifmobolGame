package com.example.rifmobol2.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rifmobol2.Constant.ANSWER_ARGUMENT
import com.example.rifmobol2.Constant.ID_ARGUMENT
import com.example.rifmobol2.Constant.SCORE_P1
import com.example.rifmobol2.Constant.SCORE_P2
import com.example.rifmobol2.navigation.RifmobolScreen
import com.example.rifmobol2.screen.menu.MenuScreen
import com.example.rifmobol2.screen.multiplayer.dialog.MultiPlayerDialogViewModel
import com.example.rifmobol2.screen.multiplayer.dialog.MultiPlayerGameDialog
import com.example.rifmobol2.screen.multiplayer.game.MultiPlayerGameViewModel
import com.example.rifmobol2.screen.multiplayer.game.MultiplayerGameScreen
import com.example.rifmobol2.screen.rules.RulesScreen
import com.example.rifmobol2.screen.single.dialog.SingleDialogViewModel
import com.example.rifmobol2.screen.single.dialog.SingleGameDialog
import com.example.rifmobol2.screen.single.game.SingleGameScreen
import com.example.rifmobol2.screen.single.game.SingleGameViewModel
import com.example.rifmobol2.screen.single.menu.SingleMenuScreen
import com.example.rifmobol2.screen.single.menu.SingleMenuViewModel
import com.example.rifmobol2.screen.splash.SplashScreen
import com.example.rifmobol2.ui.theme.Rifmobol2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rifmobol2Theme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = RifmobolScreen.Splash.name
                ){
                    composable(route = RifmobolScreen.Splash.name){ SplashScreen(navController = navController)}
                    composable(route = RifmobolScreen.Menu.name){ MenuScreen(navController = navController)}
                    composable(route = RifmobolScreen.Rules.name){ RulesScreen(navController = navController)}
                    composable(route = RifmobolScreen.SingleMenu.name){
                        val viewModel = hiltViewModel<SingleMenuViewModel>()
                        val levels by viewModel.textLevels.collectAsState(initial = emptyList())
                        SingleMenuScreen(
                        levels = levels,
                        navController = navController
                    ) }
                    composable(route = singleGameRoute(), arguments = singleGameArgument()){
                        val viewModel = hiltViewModel<SingleGameViewModel>()
                        val state = viewModel.state
                        val send = viewModel::send
                        SingleGameScreen(
                            state = state,
                            send = send,
                            navController = navController)
                    }
                    dialog(route = singleDialogRoute(), arguments = singleDialogArgument()){
                        val viewModel = hiltViewModel<SingleDialogViewModel>()
                        val state = viewModel.state
                        SingleGameDialog(
                            state = state,
                            navController = navController
                        )
                    }
                    composable(route = multiPlayerGameRoute(), arguments = multiPlayerGameArgument()){
                        val viewModel = hiltViewModel<MultiPlayerGameViewModel>()
                        val state = viewModel.state
                        val send = viewModel::send

                        MultiplayerGameScreen(
                            state = state,
                            send = send,
                            navController = navController
                        )
                    }
                    dialog(route = multiPlayerDialogRoute(), arguments = multiPlayerDialogArgument()){
                        val viewModel = hiltViewModel<MultiPlayerDialogViewModel>()
                        val state = viewModel.state

                        MultiPlayerGameDialog(state = state, navController = navController)
                    }
                }

            }
        }
    }


    private fun singleGameRoute() = RifmobolScreen.SingleGame.name + "?$ID_ARGUMENT={$ID_ARGUMENT}"

    private fun singleDialogRoute() =
        RifmobolScreen.SingleDialog.name + "$ID_ARGUMENT={$ID_ARGUMENT}&$ANSWER_ARGUMENT={$ANSWER_ARGUMENT}"

    private fun multiPlayerGameRoute() =
        RifmobolScreen.MultiPlayer.name + "?$ID_ARGUMENT={$ID_ARGUMENT}&$SCORE_P1={$SCORE_P1}&$SCORE_P2={$SCORE_P2}"

    private fun multiPlayerDialogRoute() =
        RifmobolScreen.MultiPlayerDialog.name + "?$ID_ARGUMENT={$ID_ARGUMENT}&$SCORE_P1={$SCORE_P1}&$SCORE_P2={$SCORE_P2}"

    private fun singleGameArgument(): List<NamedNavArgument>{
        return  listOf(
            navArgument(ID_ARGUMENT){
                type = NavType.IntType
                defaultValue = 0
            }
        )
    }

    private fun singleDialogArgument(): List<NamedNavArgument>{
        return listOf(
            navArgument(ID_ARGUMENT){
                type = NavType.IntType
                defaultValue = 0
            },
            navArgument(ANSWER_ARGUMENT){
                type = NavType.BoolType
                defaultValue = false
            }
        )
    }

    private fun multiPlayerGameArgument(): List<NamedNavArgument>{
        return listOf(
            navArgument(ID_ARGUMENT){
                type = NavType.IntType
                defaultValue = 1
            },
            navArgument(SCORE_P1){
                type = NavType.IntType
                defaultValue = 0
            },
            navArgument(SCORE_P2){
                type = NavType.IntType
                defaultValue = 0
            }
        )
    }

    private fun multiPlayerDialogArgument(): List<NamedNavArgument>{
        return listOf(
            navArgument(ID_ARGUMENT){
                type = NavType.IntType
                defaultValue = 1
            },
            navArgument(SCORE_P1){
                type = NavType.IntType
                defaultValue = 0
            },
            navArgument(SCORE_P2){
                type = NavType.IntType
                defaultValue = 0
            }
        )
    }

}

