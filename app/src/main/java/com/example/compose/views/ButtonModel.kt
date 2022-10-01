package com.example.compose.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    painterRes: Painter?,
    color: Color,
    textColor: Color,
    borderColor: Color
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(64.dp)
            .width(327.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp, borderColor)
    ) {
        if (painterRes != null) {
            Icon(
                painter = painterResource(id = R.drawable.google_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .height(20.dp)
                    .width(20.dp),
                tint = Color.Unspecified
            )
        }
        Text(text = text, fontSize = 17.sp, color = textColor)
    }
}