package com.example.compose.presentation.items.appScreens

import android.content.pm.ActivityInfo
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.domain.model.api_model.Media
import com.example.compose.domain.model.api_model.Stream
import com.example.compose.domain.model.data.descriptionData
import com.example.compose.domain.model.data.imageData
import com.example.compose.domain.model.data.titleData
import com.example.compose.presentation.items.ErrorItem
import com.example.compose.presentation.items.LoadItem
import com.example.compose.presentation.items.views.VideoPlayer
import com.example.compose.presentation.screen.main.MainScreenEvent
import com.example.compose.presentation.screen.main.MainViewModel
import com.example.compose.repository.changeOrientation
import com.example.compose.ui.theme.Grey
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.GameCategoryItem
import com.example.compose.ui.views.LazyMediaCardMin
import com.example.compose.presentation.items.views.TextZone

@RequiresApi(33)
@Composable
fun MainScreen(navHostController: NavController) {

    val viewModel = hiltViewModel<MainViewModel>()

    val state by viewModel.state.collectAsState()

    when {
        state.isLoading -> {
            Log.d("checkData", "Loading...")
            LoadItem()
        }
        state.data.isNotEmpty() -> {
            Log.d("checkData", "data size: ${state.data.size}")
            MainScreenContent(navHostController,state.data)
        }
        state.error != null -> {
            Log.d("checkData", "Error ${state.error}")
            ErrorItem(state.error) {
                viewModel.sendEvent(MainScreenEvent.LoadingData)
            }
        }
    }
}

@RequiresApi(33)
@Composable
fun MainScreenContent(navController: NavController, data: List<Media>) {
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        changeOrientation(
            context = LocalContext.current,
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        )
        Column(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Image(
                    painter = painterResource(id = imageData[19]),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(
                            CircleShape
                        )
                        .width(56.dp)
                        .height(56.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column(modifier = Modifier.height(56.dp)) {
                    TextZone(text = descriptionData[17], color = LightGrey, size = 12.sp)
                    Spacer(modifier = Modifier.height(2.dp))
                    TextZone(text = titleData[4], size = 22.sp)
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = imageData[20]),
                        contentDescription = null,
                        modifier = Modifier
                            .height(56.dp)
                            .width(56.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                Column(
                    modifier = Modifier
                        .height(150.dp)
                        .width(90.dp)
                        .border(2.dp, Grey, RoundedCornerShape(16.dp))
                        .drawBehind {
                            drawLine(
                                Grey,
                                Offset(40.0F, size.height / 2),
                                Offset(size.width - 40.0F, size.height / 2),
                                4.0F
                            )
                        },
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    TextZone(text = descriptionData[18], color = Grey, size = 12.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    TextZone(text = "TODO", size = 12.sp)
                    Spacer(modifier = Modifier.height(40.dp))
                    TextZone(text = descriptionData[19], color = Grey, size = 12.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    TextZone(text = "TODO", size = 12.sp)
                }
                Spacer(modifier = Modifier.width(16.dp))
                VideoPlayer("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
            }
            Spacer(modifier = Modifier.height(28.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(86.dp)
            ) {
                GameCategoryItem(itemId = 5)
                Spacer(modifier = Modifier.width(18.dp))
                GameCategoryItem(itemId = 6)
                Spacer(modifier = Modifier.width(18.dp))
                GameCategoryItem(itemId = 7)
                Spacer(modifier = Modifier.width(18.dp))
                GameCategoryItem(itemId = 8)
            }
            Spacer(modifier = Modifier.height(28.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            ) {
                TextZone(text = descriptionData[20], size = 16.sp)
            }
            Spacer(modifier = Modifier.height(20.dp))

            LazyRow {
                items(items = data) { item ->
                    LazyMediaCardMin(data = item as Stream, navController)
                }
            }
        }
    }
}