package com.example.compose.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.model.EventModel
import com.example.compose.model.data.imageData
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.Grey

@Composable
fun LazyEventCard(data: EventModel) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(14.dp))
            .background(Grey)
            .padding(all = 5.dp)
            .width(215.dp)


    ) {
        Box(
            modifier = Modifier
                .height(108.dp)
                .width(205.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.event_test_icon),
                contentDescription = null,
                modifier = Modifier
                    .matchParentSize()
            )
            Row(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = data.author_image,
                    contentDescription = null,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                TextZone(text = data.author, size = 12.sp)
            }
        }
        TextZone(text = data.title)
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = imageData[21]),
                contentDescription = null,
                modifier = Modifier
                    .width(10.dp)
                    .height(10.dp)
            )
            Spacer(modifier = Modifier.width(9.dp))
            TextZone(text = data.description, size = 10.sp, color = LightGray)
        }


    }
}

@Preview(showBackground = true)
@Composable
fun LazyEventPreview() {
    ComposeTheme {
        LazyEventCard(
            data = EventModel(
                "title",
                "description",
                "Dana Blu",
                painterResource(id = R.drawable.event_test_icon),
                painterResource(id = R.drawable.avatar_test_icon)
            )
        )
    }
}
