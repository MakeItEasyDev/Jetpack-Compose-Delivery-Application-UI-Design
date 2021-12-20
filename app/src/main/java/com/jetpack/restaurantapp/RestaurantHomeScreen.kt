package com.jetpack.restaurantapp

import android.text.Html
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.jetpack.restaurantapp.ui.theme.CategoryBackgroundColor
import com.jetpack.restaurantapp.ui.theme.FoodBackgroundColor
import com.jetpack.restaurantapp.ui.theme.FoodColor
import com.jetpack.restaurantapp.ui.theme.ViewAllColor


@ExperimentalMaterialApi
@Composable
fun RestaurantHomeScreen() {
    val poppinsLight = Font(R.font.poppins_light)
    val poppinsBold = Font(R.font.poppins_bold)

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 0.dp,
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Outlined.LocationOn,
                            contentDescription = "Location",
                            tint = FoodColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Pick Location",
                            fontFamily = FontFamily(poppinsBold),
                            fontSize = 16.sp
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            Icons.Outlined.Person,
                            contentDescription = "Profile"
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.four_dot),
                            contentDescription = "Navigation Menu",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                shape = RoundedCornerShape(50),
                backgroundColor = FoodColor,
                modifier = Modifier.size(60.dp)
            ) {
                Icon(Icons.Filled.Search, tint = Color.White, contentDescription = "Search")
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.White,
                cutoutShape = RoundedCornerShape(50),
                elevation = 0.dp,
                content = {
                    BottomNavigation(
                        backgroundColor = Color.White,
                        elevation = 0.dp
                    ) {
                        BottomNavigationItem(
                            selected = true,
                            onClick = { },
                            icon = {
                                Icon(
                                    Icons.Outlined.Home,
                                    contentDescription = "Home"
                                )
                            },
                            selectedContentColor = FoodColor,
                            unselectedContentColor = Color.LightGray
                        )
                        BottomNavigationItem(
                            selected = false,
                            onClick = { },
                            icon = {
                                Icon(
                                    Icons.Outlined.FavoriteBorder,
                                    contentDescription = "Favorite"
                                )
                            },
                            selectedContentColor = FoodColor,
                            unselectedContentColor = Color.LightGray
                        )
                        Spacer(modifier = Modifier.weight(1f, true))
                        BottomNavigationItem(
                            selected = false,
                            onClick = { },
                            icon = {
                                Icon(
                                    Icons.Outlined.Notifications,
                                    contentDescription = "Notifications"
                                )
                            },
                            selectedContentColor = FoodColor,
                            unselectedContentColor = Color.LightGray
                        )
                        BottomNavigationItem(
                            selected = false,
                            onClick = { },
                            icon = {
                                BadgeBox(
                                    backgroundColor = FoodColor,
                                    badgeContent = {
                                        Text(
                                            text = "5",
                                            color = Color.White,
                                            fontFamily = FontFamily(poppinsLight)
                                        )
                                    }
                                ) {
                                    Icon(
                                        Icons.Outlined.ShoppingCart,
                                        contentDescription = "Cart"
                                    )
                                }
                            },
                            selectedContentColor = FoodColor,
                            unselectedContentColor = Color.LightGray
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Card(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(end = 25.dp),
                backgroundColor = FoodBackgroundColor,
                shape = RoundedCornerShape(15.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.4f)
                            .fillMaxWidth()
                    ) {
                        AndroidView(
                            factory = { context ->
                                TextView(context).apply {
                                    text = Html.fromHtml("<string><big><b><span style = \"color:#000000\">The Fastest In Delivery </span><span style = \"color:#F54748\">Food</span></b></big></string>")
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .width(100.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            colors = ButtonDefaults.buttonColors(FoodColor)
                        ) {
                            Text(
                                text = "Order Now",
                                fontFamily = FontFamily(poppinsBold),
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(0.6f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.delivery_image),
                            contentDescription = "Delivery Image",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Categories",
                fontFamily = FontFamily(poppinsBold),
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(25.dp))
            LazyRow {
                items(10) { index ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(
                                if (index == 0) FoodColor else CategoryBackgroundColor
                            )
                            .wrapContentWidth()
                            .padding(end = 15.dp, start = 15.dp, top = 10.dp, bottom = 10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.White),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(
                                    id = when(index) {
                                        0 -> R.drawable.burger
                                        1 -> R.drawable.pizza
                                        else -> R.drawable.burger
                                    }
                                ),
                                contentDescription = "Category Image",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(25.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = when(index) {
                                0 -> "Burger"
                                1 -> "Pizza"
                                2 -> "Sandwich"
                                else -> "Toast"
                            },
                            fontFamily = FontFamily(poppinsLight),
                            color = if (index == 0) Color.White else Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier.padding(end = 25.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Popular Now",
                        fontFamily = FontFamily(poppinsBold),
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.End)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "View All",
                                fontFamily = FontFamily(poppinsLight),
                                color = ViewAllColor,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_arrow_circle_right_24),
                                contentDescription = "view all Image",
                                modifier = Modifier.size(20.dp),
                                colorFilter = ColorFilter.tint(ViewAllColor)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow{
                items(10) { index ->
                    Card(
                        modifier = Modifier
                            .width(180.dp)
                            .wrapContentHeight()
                            .padding(start = 5.dp),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 20.dp)
                        ) {
                            Image(
                                painter = painterResource(
                                    id = if (index % 2 == 0) {
                                        R.drawable.burger
                                    } else {
                                        R.drawable.double_burger
                                    }
                                ),
                                contentDescription = "Category Image",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(120.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = when(index) {
                                    0 -> "Beef Burger"
                                    1 -> "Double Burger"
                                    else -> "Cheese Burger"
                                },
                                fontFamily = FontFamily(poppinsBold),
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = when(index) {
                                        0 -> "Cheesy"
                                        1 -> "Beef"
                                        else -> "Chilli"
                                    },
                                    fontFamily = FontFamily(poppinsLight),
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Image(
                                    painter = painterResource(
                                        id = if (index % 2 == 0) {
                                            R.drawable.cheese
                                        } else {
                                            R.drawable.beef
                                        }
                                    ),
                                    contentDescription = "Category Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clip(CircleShape)
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            AndroidView(
                                factory = { context ->
                                    TextView(context).apply {
                                        text = if (index % 2 == 0) {
                                            Html.fromHtml("<string><b><span style = \"color:#F54748\"><big>$ </big></span><span style = \"color:#000000\"><big><big>14.10</big></big></span></b></string>")
                                        } else {
                                            Html.fromHtml("<string><b><span style = \"color:#F54748\"><big>$ </big></span><span style = \"color:#000000\"><big><big>8.35</big></big></span></b></string>")
                                        }
                                    }
                                }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
    }
}