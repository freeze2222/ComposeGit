package com.example.compose.ui.screens.authScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.data.descriptionData
import com.example.compose.ui.data.imageData
import com.example.compose.ui.data.regularFont
import com.example.compose.ui.data.titleData
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.views.EditText
import com.example.compose.views.TextZone


@Composable
fun ProfileScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier
                .padding(start = 22.dp, end = 22.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Row(modifier = Modifier.height(50.dp), verticalAlignment = Alignment.CenterVertically) {
                TextZone(text = "My Profile")
                Spacer(modifier = Modifier.width(145.dp))
                Image(
                    painter = painterResource(id = imageData[9]),
                    contentDescription = null,
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                )

            }
            Spacer(modifier = Modifier.height(60.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = imageData[10]),
                    contentDescription = null,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .clip(
                            CircleShape
                        )
                )
                Spacer(modifier = Modifier.width(25.dp))
                Column(
                    Modifier
                        .height(100.dp),
                ) {
                    TextZone(text = titleData[4])
                    Spacer(modifier = Modifier.height(4.dp))
                    TextZone(
                        text = descriptionData[3],
                        color = Color.White,
                        fontFamily = regularFont,
                        size = 16.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    TextZone(
                        text = descriptionData[4],
                        fontFamily = regularFont,
                        size = 16.sp,
                        color = LightGrey
                    )
                }
            }
            TextZone(
                text = descriptionData[5],
                fontFamily = regularFont,
                size = 16.sp,
                color = LightGrey,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(16.dp))
            EditText(hint = "Name", isPassword = false) {}
            Spacer(modifier = Modifier.height(24.dp))
            TextZone(
                text = descriptionData[6],
                fontFamily = regularFont,
                size = 16.sp,
                color = LightGrey,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(16.dp))
            EditText(hint = "email", isPassword = false) {
                
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}