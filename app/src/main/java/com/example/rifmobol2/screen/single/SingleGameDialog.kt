package com.example.rifmobol2.screen.single


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rifmobol2.R
import com.example.rifmobol2.ui.theme.Rifmobol2Theme


@Composable
fun SingleGameDialog(
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
                    .fillMaxWidth()
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
                            navController
                        }
                )
            }

            Row(
                modifier = modifier
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = stringResource(id = R.string.dialogwins1))
            }

            Row() {

            }

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
            navController = rememberNavController()
        )
    }
}