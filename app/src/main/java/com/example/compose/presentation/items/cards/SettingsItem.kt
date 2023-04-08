package com.example.compose.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
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
import com.example.compose.domain.model.data.imageData
import com.example.compose.ui.theme.Grey

@Composable
fun SettingsItem(
    text: String,
    painter: Painter?,
    isSwitch: Boolean = false,
    isBordered: Boolean = true,
    onClick: () -> Unit = {}
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
            }.clickable {onClick()}
    else Modifier.fillMaxWidth().height(75.dp).clickable {onClick()},
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Spacer(modifier = Modifier.width(24.dp))
        painter?.let {
            Icon(
                painter = it,
                contentDescription = null,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp),
                tint = Color.Unspecified
            )
        }
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