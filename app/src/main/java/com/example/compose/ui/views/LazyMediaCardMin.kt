package com.example.compose.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.compose.model.api_model.Stream
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.data.imageData
import com.example.compose.repository.watch

@Composable
fun LazyMediaCardMin(data: Stream, viewModel: MainViewModel) {
    Surface(
        modifier =
        Modifier
            .padding(5.dp)
            .height(198.dp)
            .width(215.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                if (!viewModel.isClicked) {
                    watch(data, viewModel)
                }
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    rememberAsyncImagePainter(data.thumbnail_url),
                    contentScale = ContentScale.FillWidth
                )


        ) {
            Spacer(modifier = Modifier.weight(1f))
            TextZone(text = data.title, size = 8.sp)
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = imageData[21]),
                    contentDescription = null,
                    modifier = Modifier
                        .width(10.dp)
                        .height(10.dp)
                )
                Spacer(modifier = Modifier.width(9.dp))
                TextZone(text = data.user_name, size = 10.sp, color = LightGray)
            }


        }
    }
}

