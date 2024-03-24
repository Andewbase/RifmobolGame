package com.example.rifmobol2.screen.menu

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
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
            onClick = { navController.navigate(route = RifmobolScreen.SingleMenu.name) },
            modifier = modifier
        )
        MenuButton(
            text = R.string.multiplayer,
            onClick = { navController.navigate(route = RifmobolScreen.Multiplayer.name) },
            paddingTop = 20.dp,
            modifier = modifier
        )
        MenuButton(
            text = R.string.rules,
            onClick = { navController.navigate(route = RifmobolScreen.Rules.name) },
            paddingTop = 20.dp,
            modifier = modifier
        )


    }

}

@Composable
private fun MenuButton(
    @StringRes text: Int,
    onClick: () -> Unit,
    paddingTop: Dp = 0.dp,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){

    OutlinedButton(
        modifier = modifier
            .padding(top = paddingTop)
            .width(200.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(
            width = 2.dp,
            color = colorResource(id = R.color.medium_spring_green)
        ),
        onClick = { onClick() },
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
fun MenuPreview() {
    Rifmobol2Theme {
        MenuScreen(
            rememberNavController()
        )
    }
}