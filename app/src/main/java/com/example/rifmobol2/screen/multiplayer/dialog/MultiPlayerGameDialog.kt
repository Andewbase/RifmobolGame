package com.example.rifmobol2.screen.multiplayer.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rifmobol2.Constant
import com.example.rifmobol2.R
import com.example.rifmobol2.navigation.RifmobolScreen
import com.example.rifmobol2.ui.theme.Rifmobol2Theme

@Composable
fun MultiPlayerGameDialog(
    state: MultiPlayerDialogState,
    navController: NavController,
    modifier: Modifier = Modifier
){


    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(
                width = 2.dp,
                color = colorResource(id = R.color.white)
            ),
            modifier = modifier
                .fillMaxWidth(0.8f)
        ) {

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .paint(
                        painter = painterResource(id = R.drawable.previewrulesbackground),
                        contentScale = ContentScale.FillWidth
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row() {
                    Text(
                        color = colorResource(id = R.color.blue),
                        text = stringResource(id = R.string.player1),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        color = colorResource(id = R.color.blue),
                        text = stringResource(id = R.string.colon),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(start = 10.dp)
                    )

                    Text(
                        color = colorResource(id = R.color.blue),
                        text = "0",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(start = 10.dp)
                    )
                    Text(
                        color = colorResource(id = R.color.red),
                        text = stringResource(id = R.string.player2),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(start = 100.dp)
                    )

                    Text(
                        color = colorResource(id = R.color.red),
                        text = stringResource(id = R.string.colon),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(start = 10.dp)
                    )

                    Text(
                        color = colorResource(id = R.color.red),
                        text = "0",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(start = 10.dp)
                    )
                }

                Row(modifier = modifier.padding(top = 50.dp)) {
                    Button(
                        onClick = { navController.navigate(
                            RifmobolScreen.MultiPlayer.name
                                    +
                                    "?${Constant.ID_ARGUMENT}={${state.id}}&${Constant.SCORE_P1}={${state.scoreP1}}&${Constant.SCORE_P2}={${state.scoreP2}}"
                        )},
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(
                            width = 2.dp,
                            color = colorResource(id = R.color.medium_spring_green)
                        ),
                        colors = ButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.White,
                            disabledContainerColor = Color.Transparent,
                            disabledContentColor =  Color.White
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.lvl1continue2),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }





        }
    }

}



@Preview(
    showSystemUi = true,
    device = "spec:width=480dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape"
)
@Composable
fun MultiPlayerDialogPreview() {
    Rifmobol2Theme {
        MultiPlayerGameDialog(
            state = MultiPlayerDialogState(),
            navController = rememberNavController()
        )
    }
}