package com.example.compose.presentation.items.oneTimeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.domain.model.data.descriptionData
import com.example.compose.domain.model.data.imageData
import com.example.compose.domain.model.nav_model.Screen
import com.example.compose.ui.theme.Yellow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

data class OnBoardScreen(
    val image: Int,
    val title: String,
)

val OnBoardItem = listOf(
    OnBoardScreen(
        imageData[1],
        descriptionData[8]
    ),
    OnBoardScreen(
        imageData[2],
        descriptionData[9]
    ),
    OnBoardScreen(
        imageData[3],
        descriptionData[10]
    )
)

@ExperimentalPagerApi
@Composable
fun OnBoardScreen(navController: NavController) {
    val pagerstate = rememberPagerState(
        pageCount = OnBoardItem.size,
        initialOffscreenLimit = 3,
        initialPage = 0
    )
    Box(modifier = Modifier.fillMaxSize()) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(55.dp))
            Image(
                painter = painterResource(id = imageData[11]),
                contentDescription = null,
                modifier = Modifier
                    .height(40.dp)
                    .width(147.dp)

            )
            Spacer(modifier = Modifier.height(45.dp))
            HorizontalPager(state = pagerstate) { page ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = OnBoardItem[page].image),
                        contentDescription = null,
                        modifier = Modifier
                            .height(335.dp)
                            .width(253.dp)
                    )
                    Spacer(modifier = Modifier.height(55.dp))
                    Text(
                        text = OnBoardItem[page].title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            HorizontalPagerIndicator(
                pagerState = pagerstate,
                activeColor = Yellow,
                inactiveColor = Color.DarkGray,
                indicatorWidth = 20.dp,
                indicatorHeight = 5.dp,
                indicatorShape = RoundedCornerShape(5.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            if (pagerstate.currentPage == 2) {
                Button(
                    onClick = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(Screen.OnBoardingScreen.route) {
                                inclusive = true
                            }
                        }
                    },
                    modifier = Modifier
                        .height(64.dp)
                        .width(327.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Yellow),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "Start Experience")
                }
            }
        }
    }
}
