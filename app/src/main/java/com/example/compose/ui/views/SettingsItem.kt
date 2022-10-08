package com.example.compose.ui.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.model.data.imageData
import com.example.compose.ui.theme.Grey
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Yellow

@Composable
fun SettingsItem(
    text: String,
    painter: Painter,
    isSwitch: Boolean = false,
    isBordered: Boolean = true
) {
    var switched by remember {
        mutableStateOf(true)
    }
    Row(
        modifier =
        if(isBordered) Modifier
            .fillMaxWidth()
            .height(75.dp)
            .drawBehind {
                val strokeWidth = density
                val y = size.height - strokeWidth / 2

                drawLine(
                    Grey,
                    Offset(0f, y),
                    Offset(size.width, y),
                    strokeWidth
                )
            }
    else Modifier.fillMaxWidth().height(75.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Spacer(modifier = Modifier.width(24.dp))
        Icon(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .width(24.dp)
                .height(24.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(20.dp))
        TextZone(text = text, size = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        if (isSwitch) {
            Switch(
                checked = switched,
                colors = SwitchDefaults.colors(
                    checkedTrackColor = Color.Yellow,
                    checkedThumbColor = Color.White
                ),
                onCheckedChange = { switched = it })
            Spacer(modifier = Modifier.width(24.dp))
        } else {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = imageData[18]),
                    contentDescription = null,
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp),
                    tint = Color.Unspecified
                )
            }
        }
    }
}