package com.example.compose.presentation.items.appScreens

import android.content.pm.ActivityInfo
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.domain.model.api_model.Media
import com.example.compose.domain.model.data.regularFont
import com.example.compose.presentation.items.ErrorItem
import com.example.compose.presentation.items.LoadItem
import com.example.compose.presentation.items.views.TextZone
import com.example.compose.presentation.screen.main.MainScreenEvent
import com.example.compose.presentation.screen.main.MainViewModel
import com.example.compose.presentation.screen.value.ValueModel
import com.example.compose.repository.changeOrientation
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.EditText
import com.example.compose.ui.views.LazyMediaCard

@Composable
fun SearchVideosScreen(navHostController: NavController) {

    val viewModel = hiltViewModel<MainViewModel>()

    val state by viewModel.state.collectAsState()

    when {
        state.isLoading -> {
            Log.d("checkData", "Loading...")
            LoadItem()
        }
        state.data.isNotEmpty() -> {
            Log.d("checkData", "data size: ${state.data.size}")
            SearchVideosScreenContent(navHostController, state.data)
        }
        state.error != null -> {
            Log.d("checkData", "Error ${state.error}")
            ErrorItem(state.error) {
                viewModel.sendEvent(MainScreenEvent.LoadingData)
            }
        }
    }
}

@Composable
fun SearchVideosScreenContent(navHostController: NavController, data: List<Media>) {
    changeOrientation(LocalContext.current, ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    var isReady by remember { mutableStateOf(false) }
    val query by remember {
        mutableStateOf(ValueModel())
    }

    Surface(
        color = Violet,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isReady) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.padding(start = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    EditText(
                        hint = "Search Streams",
                        isPassword = false,
                        valueModel = query,
                        250.dp
                    )
                    ClickableText(
                        text = AnnotatedString("Search"),
                        onClick = {
                            //TODO
                        },
                        style = TextStyle.Default.copy(
                            color = LightGrey,
                            fontSize = 24.sp,
                            fontFamily = regularFont
                        ),
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                ) {
                    TextZone(
                        text = "Recent Keywords",
                        size = 12.sp,
                        modifier = Modifier.weight(2f),
                        color = LightGrey,
                        textAlign = TextAlign.Start,
                    )
                    ClickableText(
                        text = AnnotatedString("Clear All"),
                        onClick = {},
                        style = TextStyle.Default.copy(
                            color = Color.White,
                            fontSize = 10.sp,
                            fontFamily = regularFont,
                            textAlign = TextAlign.End
                        ),
                        modifier = Modifier.weight(1f),
                    )
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(items = data) { item ->
                            LazyMediaCard(data = item, navHostController)
                        }
                    }
                }
            }
        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
                LaunchedEffect(Unit){
                    //TODO
                }
            }
        }
    }

}