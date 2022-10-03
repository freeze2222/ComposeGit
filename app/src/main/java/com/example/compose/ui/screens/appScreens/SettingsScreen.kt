package com.example.compose.ui.screens.appScreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.model.data.*
import com.example.compose.ui.screens.oneTimeScreens.Img
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.TextZone

@Composable
fun SettingsScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(24.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Img(id = imageData[12], height = 60.dp, width = 60.dp)
                }
                Spacer(modifier = Modifier.width(80.dp))
                TextZone(text = titleData[6], fontFamily = boldFont)
            }
            Spacer(modifier = Modifier.height(40.dp).width(25.dp))
            TextZone(
                text = descriptionData[11],
                fontFamily = regularFont,
                size = 16.sp,
                color = LightGrey,
            )
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}