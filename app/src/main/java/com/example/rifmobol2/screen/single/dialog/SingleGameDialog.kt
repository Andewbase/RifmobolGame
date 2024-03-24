package com.example.rifmobol2.screen.single.dialog


import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rifmobol2.Constant.ID_ARGUMENT
import com.example.rifmobol2.R
import com.example.rifmobol2.navigation.RifmobolScreen
import com.example.rifmobol2.ui.theme.Rifmobol2Theme


@Composable
fun SingleGameDialog(
    idNext: Int,
    idReplay: Int,
    answer: Boolean,
    navController: NavController,
    modifier: Modifier = Modifier
){

    if (answer){
        SingleDialogWin(
            idNext = idNext,
            navController = navController,
            modifier = modifier
        )
    }else{
        SingleDialogLose(
            idNext = idNext,
            idReplay = idReplay,
            navController = navController,
            modifier = modifier
            )
    }
}

@Composable
private fun SingleDialogWin(
    idNext: Int,
    navController: NavController,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .paint(
                painter = painterResource(id = R.drawable.previewrulesbackground),
                contentScale = ContentScale.FillWidth
            )
    ) {

        Row(
            modifier
                .fillMaxWidth(0.9f)
                .padding(top = 30.dp, end = 30.dp)
            ,
            horizontalArrangement = Arrangement.End,
        ) {
            Icon(
                Icons.Filled.Clear,
                contentDescription = "Clear Dialog",
                tint = Color.White,
                modifier = modifier
                    .size(
                        height = 40.dp,
                        width = 40.dp
                    )
                    .clickable {
                        navController.navigate(RifmobolScreen.SingleMenu.name)
                    }
            )
        }

        Column(
            modifier = modifier
                .fillMaxWidth(0.7f)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = stringResource(id = R.string.dialogwins1))
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            NextSingleDialogButton(
                id = idNext,
                navController = navController,
                text = R.string.lvl1continue2
            )
        }

    }
}

@Composable
private fun SingleDialogLose(
    idNext: Int,
    idReplay: Int,
    navController: NavController,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .paint(
                painter = painterResource(id = R.drawable.previewrulesbackground),
                contentScale = ContentScale.FillWidth
            )
    ) {

        Row(
            modifier
                .fillMaxWidth(0.9f)
                .padding(top = 30.dp, end = 30.dp)
            ,
            horizontalArrangement = Arrangement.End,
        ) {
            Icon(
                Icons.Filled.Clear,
                contentDescription = "Clear Dialog",
                tint = Color.White,
                modifier = modifier
                    .size(
                        height = 40.dp,
                        width = 40.dp
                    )
                    .clickable {
                        navController.navigate(RifmobolScreen.SingleMenu.name)
                    }
            )
        }

        Column(
            modifier = modifier
                .fillMaxWidth(0.7f)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = stringResource(id = R.string.dialoglose1))
        }

        Row(
            modifier = modifier
                .fillMaxWidth(0.7f)
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            OutlinedButton(
                onClick = { navController.navigate(RifmobolScreen.SingleGame.name + "?$ID_ARGUMENT=${idReplay}") },
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(
                    width = 2.dp,
                    color = colorResource(id = R.color.medium_spring_green)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.lvl1continue1),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            NextSingleDialogButton(
                id = idNext,
                navController = navController,
                text = R.string.lvl1continue2
            )
            
        }

    }
}

@Composable
private fun NextSingleDialogButton(
    id: Int,
    navController: NavController,
    @StringRes text: Int
){

    OutlinedButton(
        onClick = { navController.navigate(RifmobolScreen.SingleGame.name + "?$ID_ARGUMENT=${id}") },
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(
            width = 2.dp,
            color = colorResource(id = R.color.medium_spring_green)
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
fun SingleGameDialogPreview() {
    Rifmobol2Theme {
        SingleGameDialog(
            idNext = 0,
            idReplay= 0,
            answer = false,
            navController = rememberNavController()
        )
    }
}