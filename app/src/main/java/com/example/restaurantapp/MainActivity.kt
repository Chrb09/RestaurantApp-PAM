package com.example.restaurantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.restaurantapp.model.Dish
import com.example.restaurantapp.ui.theme.RestaurantAppTheme
import androidx.compose.material3.Card
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import groovyjarjarpicocli.CommandLine.Help.Column

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestaurantAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RestaurantApp()
                }
            }
        }
    }
}

@Composable
fun RestaurantApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        Modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
    ) {
        Column{
            AffirmationsList(
                affirmationList = Datasource().loadDishes1(),
            )
            AffirmationsList(
                affirmationList = Datasource().loadDishes2(),
            )
        }

    }
}

@Preview
@Composable
private fun DishCardPreview() {
    DishCard(Dish(R.string.dishname1, R.string.dishprice1, R.drawable.dish1))
}

@Composable
fun DishCard(dish: Dish, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(dish.imageResourceId),
                contentDescription = stringResource(dish.nameResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(300.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = LocalContext.current.getString(dish.nameResourceId),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = LocalContext.current.getString(dish.priceResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.labelLarge
            )

        }
    }
}

@Composable
fun DishesList(DishesList: List<Dish>, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier) {
        items(DishesList) { dish ->
            DishCard(
                dish = dish,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}