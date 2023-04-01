package com.example.compose.ui.screens.appScreens

import android.content.pm.ActivityInfo
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
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.data.ValueModel
import com.example.compose.model.data.regularFont
import com.example.compose.model.nav_model.Screen
import com.example.compose.repository.changeOrientation
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.EditText
import com.example.compose.ui.views.LazyMediaCard
import com.example.compose.ui.views.TextZone

@Composable
fun SearchStreamsScreen(viewModel: MainViewModel) {
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
                            viewModel.updateAll(query.value)
                            isReady = false
                            viewModel.navController.navigate(Screen.SearchStreams.route) {
                                popUpTo(Screen.SearchStreams.route) {
                                    inclusive = true
                                }
                            }
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
                        items(items = viewModel.streamsList) { item ->
                            LazyMediaCard(data = item, viewModel)
                        }
                    }
                }
            }
        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
                LaunchedEffect(Unit){
                    viewModel.updateAll(query.value).invokeOnCompletion {
                        isReady = true
                    }
                }
            }
        }
    }

}