package com.example.compose.ui.screens.appScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.model.data.descriptionData
import com.example.compose.model.data.imageData
import com.example.compose.model.data.regularFont
import com.example.compose.model.data.titleData
import com.example.compose.ui.theme.Grey
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.GameCategoryItem
import com.example.compose.ui.views.TextZone
import com.example.compose.ui.views.VideoPlayer

@Composable
fun MainScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
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
                VideoPlayer("TODO")
            }
            Spacer(modifier = Modifier.height(28.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(86.dp)
            ) {
                GameCategoryItem(itemId = 5)
                Spacer(modifier = Modifier.width(30.dp))
                GameCategoryItem(itemId = 6)
                Spacer(modifier = Modifier.width(30.dp))
                GameCategoryItem(itemId = 7)
                Spacer(modifier = Modifier.width(30.dp))
                GameCategoryItem(itemId = 8)
            }
            Spacer(modifier = Modifier.height(28.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            ) {
                TextZone(text = descriptionData[20], size = 16.sp)
                Spacer(modifier = Modifier.width(170.dp))
                ClickableText(
                    text = AnnotatedString(descriptionData[21]),
                    onClick = {/*TODO*/ },
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = regularFont,
                        fontSize = 12.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}