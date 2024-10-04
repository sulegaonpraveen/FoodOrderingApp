package com.example.foodorderingapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.foodorderingapp.ui.theme.FoodOrderingAppTheme

class HistoryScreen : ComponentActivity() {
}

@Composable
fun HistoryScreenComponent(navController : NavController,modifier: Modifier = Modifier) {
    val viewModel: HistoryScreenViewModel = HistoryScreenViewModel()

    val movieListResponse by viewModel.movieListResponse.observeAsState(listOf())

    MovieList(movieListResponse)
    viewModel.getMoviesList()
   // viewModel.movieListResponse =  List<Movie>(1){Movie("Hi","","Hello","How are you")}

//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .background(Color(0xFFF6F9FA)),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "This is History page")
//
//    }
}

@Composable
fun MovieList(movieList: List<Movie>){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(0.dp, 50.dp, 0.dp, 0.dp)
        .background(Color(0xFFF6F9FA))) {
        itemsIndexed(items = movieList){ index, item ->
            MovieItem(movie = item)
        }
    }
}

@Composable
fun MovieItem(movie : Movie){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(110.dp), shape = RoundedCornerShape(8.dp)) {
    Surface {
        Row(modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()) {
            Image(painter = rememberImagePainter(data = movie.imageUrl,
                builder = {
                scale(Scale.FILL)
                    placeholder(R.drawable.ic_launcher_background)
                    transformations(CircleCropTransformation())
                }),
                contentDescription = movie.desc, modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.2f))
        }
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier
            .padding(4.dp)
            .fillMaxHeight()
            .weight(0.8f)
        ) {
                Text(text = movie.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold)

            Text(text = movie.category,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(4.dp))

            Text(text = movie.desc,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(4.dp))
        }
    }
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryScreenComponentPreview() {
    val navController = rememberNavController()
    FoodOrderingAppTheme {
        HistoryScreenComponent(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    val movie = Movie("Developer Says","", "Hi Guys!! Please like and Subscribe","Special Category")
    FoodOrderingAppTheme {
        MovieItem(movie)
    }
}