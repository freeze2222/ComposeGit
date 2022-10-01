package com.example.compose.views

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose.ui.data.regularFont
import com.example.compose.ui.theme.Violet

@Composable
fun KeyboardItem(num: String) {
    Button(onClick = { /*TODO*/ }, modifier = Modifier
        .height(45.dp)
        .width(120.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Violet)) {
        Text(text = num, color = Color.White, fontFamily = regularFont)
    }
}
