package com.example.compose.ui.screens.appScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose.R
import com.example.compose.model.StreamModel
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.data.ValueModel
import com.example.compose.model.data.regularFont
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.EditText
import com.example.compose.ui.views.LazyStreamCard
import com.example.compose.ui.views.TextZone

@Composable
fun WatchScreen(navController: NavHostController, viewModel: MainViewModel) {
    val query = ValueModel()
    Surface(
        color = Violet,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.padding(start = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                EditText(hint = "Search Streams", isPassword = false, valueModel = query, 250.dp)
                ClickableText(
                    text = AnnotatedString("Cancel"),
                    onClick = {},
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
                val data = StreamModel(null, painterResource(id = R.drawable.preview_test), "10k", "Test", null)
                var list by remember {
                    mutableStateOf(mutableListOf(data, data))
                }
                LazyColumn (modifier = Modifier.fillMaxSize()){
                    items(items = list) { item ->
                        LazyStreamCard(data = item)
                    }
                }
            }
        }
    }
}