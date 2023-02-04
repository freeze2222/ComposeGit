package com.example.compose.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.compose.model.StreamModel

@Composable
fun LazyStreamCard(data: StreamModel) {
    Surface(
        modifier = Modifier
            .padding(top = 10.dp)
            .height(190.dp)
            .width(327.dp)
            .clip(RoundedCornerShape(15.dp))
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(data.preview!!, contentScale = ContentScale.FillWidth)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(), verticalAlignment = Alignment.Top
            ) {
                TextZone(text = "Test")
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(), verticalAlignment = Alignment.Bottom
            ) {
                TextZone(text = "Test")
            }
        }
    }
}