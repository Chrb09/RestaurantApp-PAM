package com.example.restaurantapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaurantapp.data.Datasource
import com.example.restaurantapp.ui.theme.RestaurantAppTheme

@Composable
fun Screen2(navController: NavController){
    RestaurantAppTheme(darkTheme = false, dynamicColor = false) {
        val layoutDirection = LocalLayoutDirection.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.gray_100))
                .statusBarsPadding()
                .padding(
                    start = WindowInsets.safeDrawing
                        .asPaddingValues()
                        .calculateStartPadding(layoutDirection),
                    end = WindowInsets.safeDrawing
                        .asPaddingValues()
                        .calculateEndPadding(layoutDirection),
                )
                .verticalScroll(rememberScrollState()),
        ) {
            RestaurantApp2()
            Button(
                modifier = Modifier.padding(24.dp,8.dp, 24.dp, 48.dp)
                    .fillMaxWidth(),
                onClick = {
                    navController.navigate(Routes.screen1)
                },
            ) {
                Text(
                    text = stringResource(R.string.switchpage),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,

                        ),
                )
            }
        }


    }
}

@Composable
fun RestaurantApp2() {

    Column(
    ){
        Text(
            text = stringResource(R.string.greeting),
            style = TextStyle(
                fontSize = 20.sp,
                color = colorResource(R.color.teal_900)
            ),
            modifier = Modifier.padding(24.dp, 32.dp, 16.dp, 0.dp)
        )
        Text(
            text = "Pagina 2",
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.teal_600)
            ),
            modifier = Modifier.padding(24.dp, 0.dp, 16.dp, 8.dp)
        )

    }
}