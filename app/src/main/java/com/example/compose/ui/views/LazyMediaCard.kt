package com.example.compose.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.compose.model.api_model.Media
import com.example.compose.model.data.*
import com.example.compose.repository.watch
import com.example.compose.ui.theme.LightGrey

@Composable
fun LazyMediaCard(data: Media, viewModel: MainViewModel, isStream: Boolean = false) {
    Surface(
        modifier = Modifier
            .padding(top = 10.dp)
            .height(190.dp)
            .width(327.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                if (!viewModel.isClicked) {
                    watch(data, viewModel)
                }
            }
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    rememberAsyncImagePainter(data.thumbnail_url),
                    contentScale = ContentScale.FillWidth
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
                    .weight(1f)
                    .fillMaxWidth(), verticalAlignment = Alignment.Top
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .alpha(0.8f)
                        .background(Color.Red)
                        .padding(start = 7.dp, top = 7.dp, end = 7.dp, bottom = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (isStream) {
                        TextZone(text = descriptionData[21], size = 14.sp)
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .alpha(0.8f)
                        .background(LightGrey)
                        .padding(start = 7.dp, top = 7.dp, end = 7.dp, bottom = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = imageData[22]),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp)
                    )
                    TextZone(text = data.view_count.toString(), size = 14.sp)
                }
            }
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 10.dp)
                    .weight(1f)
                    .fillMaxWidth(), verticalAlignment = Alignment.Bottom
            ) {
                Image(
                    painter = painterResource(id = imageData[23]),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(
                            CircleShape
                        )
                )
                Spacer(modifier = Modifier.width(5.dp))
                Column {
                    TextZone(text = data.title, fontFamily = boldFont, size = 14.sp)
                    Spacer(modifier = Modifier.height(5.dp))
                    TextZone(text = data.user_name, fontFamily = monoFont, size = 10.sp)
                }
            }
        }
    }
}