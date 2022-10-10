package com.example.compose.ui.screens.appScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.model.data.descriptionData
import com.example.compose.model.data.imageData
import com.example.compose.model.data.titleData
import com.example.compose.ui.theme.Grey
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.TextZone

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
                Column(modifier = Modifier
                    .height(150.dp)
                    .width(90.dp)
                    .border(2.dp, Grey, RoundedCornerShape(16.dp))
                    .drawBehind {
                        drawLine(
                            Grey,
                            Offset(40.0F, size.height/2),
                            Offset(size.width - 40.0F, size.height/2),
                            4.0F
                        )
                    }
                ) {

                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}