package com.example.rifmobol2.screen.menu

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rifmobol2.R
import com.example.rifmobol2.ui.theme.Rifmobol2Theme

@Composable
fun MenuScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.menu_background),
                contentScale = ContentScale.FillWidth
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {


        MenuButton(
            text = R.string.play,
            onClick = { navController }
        )
        MenuButton(
            text = R.string.multiplayer,
            onClick = { navController },
            paddingTop = 20.dp
        )
        MenuButton(
            text = R.string.rules,
            onClick = { navController },
            paddingTop = 20.dp
        )

    }

}

@Composable
fun MenuButton(
    @StringRes text: Int,
    onClick: () -> Unit,
    paddingTop: Dp = 0.dp,
    modifier: Modifier = Modifier
){

    val color = remember {
        mutableIntStateOf(0)
    }


    OutlinedButton(
        modifier = modifier
            .padding(top = paddingTop)
            .width(200.dp),
        shape = RoundedCornerShape(20.dp),
      /*  colors = ButtonColors(
            containerColor = colorResource(id = color.intValue),
            contentColor = colorResource(id = color.intValue),
            disabledContainerColor = colorResource(id = color.intValue),
            disabledContentColor = colorResource(id = color.intValue)
        ),*/
        border = BorderStroke(
            width = 2.dp,
            color = colorResource(id = R.color.medium_spring_green)
        ),
        onClick = {
            color.intValue = R.color.light_sea_green
            onClick
                  },
    ) {
        Text(
            color = colorResource(id = R.color.light_yellow),
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
fun SplashPreview() {
    Rifmobol2Theme {
        MenuScreen(
            rememberNavController()
        )
    }
}