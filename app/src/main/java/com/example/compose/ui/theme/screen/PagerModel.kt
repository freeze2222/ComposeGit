package com.example.compose.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

data class PagerModel(
    val image: Int,
    val title: String,
)
val OnBoardItem = listOf(
    PagerModel(
        R.drawable.img1,
        "Lasted Feature in Streaming  Your Favourite Channel"
    ),
    PagerModel(
        R.drawable.img2,
        "Feel The Beat as You are involved in the game"
    ),
    PagerModel(
        R.drawable.img3,
        "Share Your Awesome Experience with family & Friends"
    )
)

@ExperimentalPagerApi
@Composable
fun OnBoardScreen() {
    val context = LocalContext.current
    val pagerstate = rememberPagerState(
        pageCount = OnBoardItem.size,
        initialOffscreenLimit = 3,
        initialPage = 0
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerstate) { page ->
                Column(
                    modifier = Modifier.padding(top = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = OnBoardItem[page].image),
                        contentDescription = null,
                        modifier = Modifier.size(250.dp)
                    )
                    Text(
                        text = OnBoardItem[page].title,
                        modifier = Modifier.padding(20.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }
            HorizontalPagerIndicator(pagerState = pagerstate)


            if (pagerstate.currentPage == 2) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Start Experience")
                }
            } else {
                Button(onClick = { /*TODO*/}) {
                    Text(text = "Next")
                }
            }

        }
    }
}
