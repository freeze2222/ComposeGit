package com.example.compose.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose.domain.model.data.imageData

@Composable
fun GameCategoryItem(itemId : Int, action: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxHeight()
        .clickable {action.invoke()}
        .width(64.dp)) {
        Image(painter = painterResource(id = imageData[itemId]), contentDescription = null, modifier = Modifier.width(72.dp).height(84.dp))
    }
}