package com.example.rifmobol2.screen.multiplayer.game

import android.annotation.SuppressLint
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rifmobol2.R
import com.example.rifmobol2.navigation.RifmobolScreen
import com.example.rifmobol2.ui.theme.Rifmobol2Theme

@Composable
fun MultiplayerGameScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.level1_background), //TODO #1
                contentScale = ContentScale.FillWidth
            ),
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 10.dp),
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
            MultiPlayerGameText(text = R.string.raund1) //TODO #2
        }

        Row(
            modifier = modifier
                .fillMaxWidth(0.8f)
                .padding(top = 10.dp)
        ) {
            MultiPlayerGameText(text = R.string.lvlcouplet1) //TODO #3
        }

        Row(
            modifier = modifier
                .padding(top = 10.dp)
        ) {
            
            MultiPlayerScorePlayerOneText(
                R.string.player1,
                modifier = modifier
            )
            
            MultiPlayerScorePlayerOneText(
                text = R.string.colon,
                startDp = 10.dp,
                modifier = modifier
            )
            
            Text(
                modifier = modifier.padding(start = 10.dp),
                text = "0", //TODO #4
                color = colorResource(id = R.color.blue)
            )

            MultiPlayerScorePlayerTwoText(
                text = R.string.player2,
                startDp = 150.dp,
                modifier = modifier
            )
            MultiPlayerScorePlayerTwoText(
                text = R.string.colon,
                startDp = 10.dp,
                modifier = modifier
            )

            Text(
                modifier = modifier.padding(start = 10.dp),
                text = "0", //TODO #5
                color = colorResource(id = R.color.red)
            )

        }

        Row(
            modifier = modifier
                .padding(top = 10.dp, start = 70.dp)
                .fillMaxWidth()
        ) {

            Column {
                Row {
                    MultiPlayerGameButton(
                        onClick = { /*TODO*/ },
                        background = R.color.black,
                        text = R.string.lvl1textone, //TODO #6
                        enabled = true,
                        modifier = modifier
                    )

                    MultiPlayerGameButton(
                        onClick = { /*TODO*/ },
                        background = R.color.black,
                        text = R.string.lvl1texttwo, //TODO #7
                        enabled = true,
                        modifier = modifier
                    )
                }
                Row {
                    MultiPlayerGameButton(
                        onClick = { /*TODO*/ },
                        background = R.color.black,
                        text = R.string.lvl1textthree, //TODO #8
                        enabled = true
                    )

                    MultiPlayerGameButton(
                        onClick = { /*TODO*/ },
                        background = R.color.black,
                        text = R.string.lvl1textfour, //TODO #9
                        enabled = true,
                        modifier = modifier
                    )
                }
            }

            Column(modifier = modifier.padding(start = 50.dp)) {
                Row {
                    MultiPlayerGameButton(
                        onClick = { /*TODO*/ },
                        background = R.color.black,
                        text = R.string.lvl1textone, //TODO #10
                        enabled = true,
                        modifier = modifier
                    )

                    MultiPlayerGameButton(
                        onClick = { /*TODO*/ },
                        background = R.color.black,
                        text = R.string.lvl1texttwo, //TODO #11
                        enabled = true,
                        modifier = modifier
                    )
                }
                Row {
                    MultiPlayerGameButton(
                        onClick = { /*TODO*/ },
                        background = R.color.black,
                        text = R.string.lvl1textthree, //TODO #12
                        enabled = true,
                        modifier = modifier
                    )

                    MultiPlayerGameButton(
                        onClick = { /*TODO*/ },
                        background = R.color.black,
                        text = R.string.lvl1textfour, //TODO #12
                        enabled = true,
                        modifier = modifier
                    )
                }
            }
        }

    }


}

@Composable
private fun MultiPlayerGameText(
    @StringRes text: Int
){
    Text(
        text = stringResource(id = text),
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun MultiPlayerScorePlayerOneText(
    @StringRes text: Int,
    startDp: Dp = 0.dp,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){
    Text(
        modifier =  modifier
            .padding(start = startDp),
        text = stringResource(id = text),
        color = colorResource(id = R.color.blue),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold 
    )
}

@Composable
private fun MultiPlayerScorePlayerTwoText(
    @StringRes text: Int,
    startDp: Dp = 0.dp,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){
    Text(
        modifier =  modifier
            .padding(start = startDp),
        text = stringResource(id = text),
        color = colorResource(id = R.color.red),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun MultiPlayerGameButton(
    onClick: () -> Unit,
    @ColorRes background: Int,
    @StringRes text: Int,
    enabled: Boolean,
    startDp: Dp = 0.dp,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){

    OutlinedButton(
        modifier = modifier
            .width(165.dp)
            .padding(start = startDp),
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
        ),
        enabled = enabled
    ) {
        Text(
            text = stringResource(id = text),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }

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