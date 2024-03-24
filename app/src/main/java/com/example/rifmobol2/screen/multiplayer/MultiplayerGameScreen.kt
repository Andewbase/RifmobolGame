package com.example.rifmobol2.screen.multiplayer

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rifmobol2.ui.theme.Rifmobol2Theme

@Composable
fun MultiplayerGameScreen(
    navController: NavController
){



}



@Preview(
    showSystemUi = true,
    device = "spec:width=480dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape"
)
@Composable
fun MultiplayerGamePreview() {
    Rifmobol2Theme {
        MultiplayerGameScreen(
            navController = rememberNavController()
        )
    }
}