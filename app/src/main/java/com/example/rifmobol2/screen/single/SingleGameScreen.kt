package com.example.rifmobol2.screen.single

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rifmobol2.R
import com.example.rifmobol2.ui.theme.Rifmobol2Theme

@Composable
fun SingleGameScreen(
    state: SingleGameState,
    send: (SingleGameEvent) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                /*painter = painterResource(id = state.roundInfo!!.backgroundImage),*/
                painter = painterResource(id = R.drawable.level1_background),
                contentScale = ContentScale.FillWidth
            ),
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 20.dp)
        ) {
            OutlinedButton(
                onClick = { navController },
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

            /*Text(text = stringResource(id = state.roundInfo!!.numberRound))*/
            Text(
                text = stringResource(id = R.string.level1),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

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