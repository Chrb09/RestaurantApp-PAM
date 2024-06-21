package com.example.restaurantapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaurantapp.ui.theme.RestaurantAppTheme

@Composable
fun Screen2(navController: NavController){
    RestaurantAppTheme(darkTheme = false, dynamicColor = false) {
        val layoutDirection = LocalLayoutDirection.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.gray_100))
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
                modifier = Modifier.padding(28.dp,8.dp, 28.dp, 48.dp)
                    .fillMaxWidth(),
                onClick = {
                    navController.navigate(Routes.screen1)
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.teal_600)),
                contentPadding = PaddingValues(0.dp,18.dp, 0.dp, 18.dp),
                shape = RoundedCornerShape(20.dp),
            ) {
                Icon(
                    Icons.Rounded.List,
                    contentDescription = stringResource(R.string.menu),
                    modifier = Modifier.size(34.dp)
                )

                Text(
                    modifier = Modifier.padding(24.dp,0.dp, 24.dp, 0.dp),
                    text = stringResource(R.string.menu),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,

                        ),
                )
            }
        }


    }
}

@Composable
fun RestaurantApp2() {

    Column {
        Image(
            painter = painterResource(R.drawable.dish3),
            contentDescription = stringResource(R.string.dishname3),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 18.dp)
    ,
            contentScale = ContentScale.Crop
        )
        Text(
            text = LocalContext.current.getString(R.string.dishname3),
            modifier = Modifier.padding(16.dp,0.dp, 16.dp, 0.dp),
            style = TextStyle(
                lineBreak = LineBreak.Simple,
                fontSize = 36.sp,
                fontWeight = FontWeight.W700,
                color = colorResource(R.color.teal_900)
            )
        )
        Text(
            text = LocalContext.current.getString(R.string.dishprice3),
            modifier = Modifier.padding(16.dp,8.dp, 16.dp, 8.dp),
            style = TextStyle(
                lineBreak = LineBreak.Simple,
                fontSize = 28.sp,
                fontWeight = FontWeight.W600,
                color = colorResource(R.color.teal_600)
            )
        )


        Text(
            text = LocalContext.current.getString(R.string.dishdescription3),
            modifier = Modifier.padding(16.dp,8.dp, 16.dp, 8.dp),
            style = TextStyle(
                lineBreak = LineBreak.Simple,
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                color = colorResource(R.color.gray_400)
            )
        )

        Text(
            text = LocalContext.current.getString(R.string.ingredients),
            modifier = Modifier.padding(16.dp,8.dp, 16.dp, 0.dp),
            style = TextStyle(
                lineBreak = LineBreak.Simple,
                fontSize = 28.sp,
                fontWeight = FontWeight.W600,
                color = colorResource(R.color.teal_900)
            )
        )

        Text(
            text = LocalContext.current.getString(R.string.dishingredients3),
            modifier = Modifier.padding(16.dp,8.dp, 16.dp, 8.dp),
            style = TextStyle(
                lineBreak = LineBreak.Simple,
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                color = colorResource(R.color.gray_400)
            )
        )

    }
}