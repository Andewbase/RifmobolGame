package com.example.rifmobol2.screen.single.game

import androidx.activity.compose.BackHandler
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rifmobol2.R
import com.example.rifmobol2.navigation.RifmobolScreen
import com.example.rifmobol2.ui.theme.Rifmobol2Theme

@Composable
fun SingleGameScreen(
    state: SingleGameState,
    send: (SingleGameEvent) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
){

    LifecycleEventEffect(event = Lifecycle.Event.ON_START) {
        send(SingleGameEvent.Resume)
    }

    LifecycleEventEffect(event = Lifecycle.Event.ON_PAUSE) {
        send(SingleGameEvent.Pause)
    }

    BackHandler { navController.navigate(route = RifmobolScreen.SingleMenu.name) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = state.roundInfo!!.backgroundImage),
                contentScale = ContentScale.FillWidth
            ),
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.Start
        ) {
                OutlinedButton(
                    onClick = { navController.navigate(route = RifmobolScreen.SingleMenu.name) },
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        color = colorResource(id = R.color.medium_spring_green)
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.back),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
        }

        Row {
                Text(
                    text = stringResource(id = state.roundInfo.numberRound),
                )
        }

        Row(
            modifier = modifier
                .fillMaxWidth(0.8f)
                .padding(top = 50.dp),
        ) {
            Text(
                text = stringResource(id = state.roundInfo.couplet)
            )
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

           SingleGameButton(
               onClick = {send(SingleGameEvent.UpLeftButtonClick(navController))},
               background = state.upLeftButtonColor,
               text = state.roundInfo.upLeftButton.name,
               modifier
           )

            SingleGameButton(
                onClick = {send(SingleGameEvent.UpRightButtonClick(navController))},
                background = state.upRightButtonColor,
                text = state.roundInfo.upRightButton.name,
                modifier
            )
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            SingleGameButton(
                onClick = {send(SingleGameEvent.BottomLeftButtonCLick(navController))},
                background = state.bottomLeftButtonColor,
                text = state.roundInfo.bottomLeftButton.name,
                modifier
            )

            SingleGameButton(
                onClick = {send(SingleGameEvent.BottomRightButtonClick(navController))},
                background = state.bottomRightButtonColor,
                text = state.roundInfo.bottomRightButton.name,
                modifier
            )
        }



    }

}

@Composable
private fun SingleGameButton(
    onClick: () -> Unit,
    @ColorRes background: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
){
    OutlinedButton(
        modifier = modifier.width(200.dp),
        onClick = { onClick() },
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(
            width = 2.dp,
            color = colorResource(id = R.color.white)
        ),
        colors = ButtonColors(
            containerColor = colorResource(id = background),
            contentColor = Color.White,
            disabledContainerColor = Color.Black,
            Color.White
        )
    ) {
        Text(
            text = stringResource(id = text),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(
    showSystemUi = true,
    device = "spec:width=480dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape"
)
@Composable
fun SingleGamePreview() {
    Rifmobol2Theme {
        SingleGameScreen(
            state = SingleGameState(),
            send = {},
            navController =  rememberNavController()
        )
    }
}