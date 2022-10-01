package com.example.compose.ui.screens.authScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.data.descriptionData
import com.example.compose.ui.data.regularFont
import com.example.compose.ui.data.titleData
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.theme.Yellow
import com.example.compose.views.CustomButton
import com.example.compose.views.EditText
import com.example.compose.views.TextZone

@Composable
fun ForgotScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            TextZone(text = titleData[2])
            Spacer(modifier = Modifier.height(15.dp))
            TextZone(text = descriptionData[1], fontFamily = regularFont, size = 16.sp, color = LightGrey)
            Spacer(modifier = Modifier.height(50.dp))
            EditText(hint = "Email", false) {}
            Spacer(modifier = Modifier.height(106.dp))
            CustomButton(
                text = "Send Link",
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
fun ForgotScreenPreview() {
    ForgotScreen()
}