package com.example.rifmobol2.screen.single.menu

import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import com.example.rifmobol2.Constant.ID_ARGUMENT
import com.example.rifmobol2.R
import com.example.rifmobol2.data.entity.TextLevel
import com.example.rifmobol2.navigation.RifmobolScreen
import com.example.rifmobol2.ui.theme.Rifmobol2Theme

@Composable
fun SingleMenuScreen(
    levels: List<TextLevel>,
    navController: NavController,
    modifier: Modifier = Modifier
){

    BackHandler { navController.navigate(route = RifmobolScreen.Menu.name) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.playgame_background),
                contentScale = ContentScale.FillWidth
            ),

    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 20.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            SingleMenuButton(
                text = R.string.back,
                onClick = {navController.navigate(route = RifmobolScreen.Menu.name)}
            )
        }

        Row (
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Text(text = "Baner")
        }

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LazyVerticalGrid(
                modifier = modifier
                    .width(400.dp)
                    .padding( bottom = 10.dp),
                columns = GridCells.Fixed(5)
            ) {
                items(
                    items = levels,
                    /*key = {levels -> levels.id}*/
                ){ item ->
                    Item(
                        text = item.id.toString(),
                        onClick = { navController.navigate(RifmobolScreen.SingleGame.name + "?$ID_ARGUMENT=${item.id}") }
                    )
                }

            }
        }

    }




}




@Composable
private fun Item(
    text: String,
    onClick: () -> Unit,
){
   OutlinedButton(
       modifier = Modifier
           .padding(start = 20.dp, top = 20.dp),
       onClick = { onClick() },
       shape = RoundedCornerShape(20.dp),
       border = BorderStroke(
           width = 2.dp,
           color = colorResource(id = R.color.medium_spring_green)
       ),
   ) {
       Text(
           text = text,
           fontSize = 24.sp,
           fontWeight = FontWeight.Bold
       )
   }
}


@Composable
private fun SingleMenuButton(
    @StringRes text: Int,
    onClick: () -> Unit,
){

    OutlinedButton(
        onClick = { onClick() },
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(
            width = 2.dp,
            color = colorResource(id = R.color.medium_spring_green)
        ),
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
fun SingleMenuPreview() {
    Rifmobol2Theme {
        SingleMenuScreen(
            levels = List(35){
                TextLevel(1)
            },
            navController = rememberNavController()
        )
    }
}