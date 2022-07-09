package com.randhir.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.randhir.movieapp.model.Movie
import com.randhir.movieapp.model.getMovies
import com.randhir.movieapp.navigation.MovieScreens
import com.randhir.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController){

    Scaffold(topBar = { TopAppBar(backgroundColor = Color.DarkGray,
        elevation = 5.dp) {
        Text(text = "Movies" , color = Color.White , fontWeight = FontWeight.Bold)
    }
    }) {
        MainContent(navController = navController)
    }

}

@Composable
fun MainContent(navController: NavController , movieList: List<Movie> = getMovies()){

    Column(modifier = Modifier.padding(12.dp)) {
        // LazyColumn - to create recyclerview using jetpack
        LazyColumn{
            items(items = movieList){
                MovieRow(movie = it){movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                   // Log.d("TAG", "MainContent: $movie")
                }
            }
        }
    }



}
