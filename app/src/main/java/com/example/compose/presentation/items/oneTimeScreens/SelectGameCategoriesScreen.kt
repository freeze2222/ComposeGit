package com.example.compose.presentation.items.oneTimeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.domain.model.data.boldFont
import com.example.compose.domain.model.data.imageData
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.theme.Yellow
import com.example.compose.ui.views.CustomButton
import com.example.compose.ui.views.TextZone

@Composable
fun SelectGameCategoriesScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            TextZone(text = "Choose Categories")
            Spacer(modifier = Modifier.height(15.dp))
            TextZone(text = "Select your preferences game category", fontFamily = boldFont, size = 18.sp, color = LightGrey)
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(135.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Img(id = imageData[5], height = 135.dp, width = 100.dp)
                }
                Spacer(modifier = Modifier.width(50.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Img(id = imageData[6], height = 135.dp, width = 100.dp)
                }

            }
            Spacer(modifier = Modifier.height(37.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(135.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Img(id = imageData[7], height = 135.dp, width = 100.dp)
                }
                Spacer(modifier = Modifier.width(50.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Img(id = imageData[8], height = 135.dp, width = 100.dp)
                }
            }
            Spacer(modifier = Modifier.height(80.dp))
            CustomButton(
                text = "Next",
                onClick = { /*TODO*/ },
                painterRes = null,
                color = Yellow,
                textColor = Color.Black,
                borderColor = Color.Transparent
            )
        }
    }
}

@Preview
@Composable
fun SelectGameCategoriesScreenPreview() {
    SelectGameCategoriesScreen()
}

@Composable
fun Img(id: Int, height: Dp, width: Dp) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier = Modifier
            .height(height)
            .width(width)

    )
}