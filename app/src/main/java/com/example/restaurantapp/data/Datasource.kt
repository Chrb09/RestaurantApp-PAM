package com.example.restaurantapp.data
import com.example.restaurantapp.R
import com.example.restaurantapp.model.Dish

class Datasource {
    fun loadDishes(): List<Dish> {
        return listOf<Dish>(
            Dish(R.string.dishname1, R.string.dishprice1, R.drawable.dish1),
            Dish(R.string.dishname2, R.string.dishprice2, R.drawable.dish2),
        )
    }
}