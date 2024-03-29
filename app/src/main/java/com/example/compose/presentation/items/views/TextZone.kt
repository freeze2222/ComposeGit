package com.example.compose.presentation.items.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.compose.domain.model.data.boldFont

@Composable
fun TextZone(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.White,
    fontFamily: FontFamily = boldFont,
    size: TextUnit = 28.sp,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        text = text,
        color = color,
        fontSize = size,
        fontFamily = fontFamily,
        textAlign = textAlign,
        modifier = modifier
    )
}