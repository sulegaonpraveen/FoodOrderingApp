package com.example.foodorderingapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodorderingapp.ui.theme.FoodOrderingAppTheme
import kotlinx.coroutines.launch

class HomeScreen : ComponentActivity() {

}
var productList : MutableList<ProductList> = arrayListOf();
@Composable
fun HomeScreenComponent(navController : NavController,modifier: Modifier = Modifier, viewModel: HomeScreenViewModel = HomeScreenViewModel()) {
    val pagerState = rememberPagerState(pageCount = {3})
    val coroutineScope = rememberCoroutineScope()
    val products = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3)

    val MenuItems = productData()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(0.dp, 150.dp, 0.dp, 0.dp)
            .background(Color(0xFFF6F9FA))
    ) {
        HorizontalPager(state = pagerState,
            contentPadding = PaddingValues(horizontal = 20.dp),
            pageSpacing = -20.dp,
            ) {
             index ->
                Column(modifier = Modifier
                    .padding(20.dp)) {
                    Image(
                        painter = painterResource(id = products[index]),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth(1f)
                    )
                }
            LaunchedEffect(pagerState) {
                snapshotFlow { pagerState.currentPage }
                    .collect { currentPage ->
                        pagerState.animateScrollToPage(currentPage)
                    }
            }
        }
            Row(modifier = Modifier.padding(20.dp)){
            Text(text = "Popular", color = colorResource(id = R.color.black), modifier = Modifier.padding(0.dp,12.dp,0.dp,0.dp))
            Spacer(modifier = Modifier.weight(1f))
                Button(colors = ButtonColors(containerColor = colorResource(id = R.color.white),
                contentColor = colorResource(id = R.color.white),
                disabledContentColor = colorResource(id = R.color.white),
                disabledContainerColor = colorResource(id = R.color.white)),

                onClick = {  }) {
                Text(
                    text = "View Menu",
                    color = colorResource(id = R.color.GradientGreen),
                    fontSize = 10.sp
                )
            }
        }

        Column {
            MenuItems.forEachIndexed { index, productList ->

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
                    .background(color = Color.White),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = productList.Image), contentDescription = productList.description, modifier = Modifier.padding(2.dp))
                        Text(text = productList.description)
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "${productList.Amount}", color = colorResource(id = R.color.GradientGreen), fontWeight = FontWeight.Bold)
                        Button(colors = ButtonColors(containerColor = colorResource(id = R.color.GradientGreen),
                            contentColor = colorResource(id = R.color.white),
                            disabledContentColor = colorResource(id = R.color.white),
                            disabledContainerColor = colorResource(id = R.color.white)),
                            modifier = Modifier.padding(0.dp,0.dp,10.dp,0.dp),

                            onClick = { pushToCart(MenuItems[index],viewModel) }) {
                            Text(
                                text = "Add To Cart",
                                color = colorResource(id = R.color.white),
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            }
        }

    }
}

fun pushToCart(productListData: ProductList, viewModel: HomeScreenViewModel){
   val data =  ProductCart(productListData.productId,productListData.Image,productListData.description,productListData.Amount)
    viewModel.addProductKart(data)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    FoodOrderingAppTheme {
        HomeScreenComponent(navController)
    }
}