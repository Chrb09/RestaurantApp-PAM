package com.example.restaurantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restaurantapp.data.Datasource
import com.example.restaurantapp.model.Dish
import com.example.restaurantapp.ui.theme.RestaurantAppTheme



@Composable
fun aaaaaa() {
    val layoutDirection = LocalLayoutDirection.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
    ) {
        Column{
            Text(
                text = stringResource(R.string.greeting),
                style = TextStyle(
                    fontSize = 20.sp,
                    color = colorResource(R.color.teal_900)
                ),
                modifier = Modifier.padding(24.dp, 32.dp, 16.dp, 0.dp)
            )
            Text(
                text = stringResource(R.string.user_name),
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.teal_600)
                ),
                modifier = Modifier.padding(24.dp, 0.dp, 16.dp, 8.dp)
            )

            Text(
                text = stringResource(R.string.dishlist1),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.teal_900)
                ),
                modifier = Modifier.padding(24.dp,8.dp, 16.dp, 0.dp)
            )
        }

    }
}

@Preview
@Composable
private fun AppPreview() {
    RestaurantAppTheme(darkTheme = false, dynamicColor = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.gray_100))
        ) {
            RestaurantApp()
        }
    }
}

@Composable
fun DishCarda(dish: Dish, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .background(colorResource(R.color.white))
            .shadow(
                elevation = 7.dp,
                ambientColor = colorResource(R.color.teal_900),
                spotColor = colorResource(R.color.teal_900),
                shape = RoundedCornerShape(20.dp),
            )
            .size(width = 200.dp, height = 265.dp),

        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(colorResource(R.color.white)),
        elevation = CardDefaults.cardElevation(10.dp),
        content = {
            Column {
                Image(
                    painter = painterResource(dish.imageResourceId),
                    contentDescription = stringResource(dish.nameResourceId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp,0.dp, 12.dp, 0.dp)
                        .height(170.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = LocalContext.current.getString(dish.nameResourceId),
                    modifier = Modifier.padding(16.dp,0.dp, 16.dp, 0.dp),
                    style = TextStyle(
                            lineBreak = LineBreak.Simple,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W400,
                            color = colorResource(R.color.teal_900)
                        )
                    )
                Text(
                    text = LocalContext.current.getString(dish.priceResourceId),
                    modifier = Modifier.padding(16.dp,4.dp, 16.dp, 16.dp),
                    style = TextStyle(
                        lineBreak = LineBreak.Simple,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W800,
                        color = colorResource(R.color.teal_600)
                    )
                    )

            }
        }
       )



}

@Composable
fun DishesLista(dishesList: List<Dish>, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier.padding(16.dp,0.dp, 0.dp, 0.dp)) {
        items(dishesList) { dish ->
            DishCard(
                dish = dish,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}