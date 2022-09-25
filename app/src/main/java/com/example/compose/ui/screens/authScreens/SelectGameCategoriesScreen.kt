package com.example.compose.ui.screens.authScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.theme.Yellow

@Composable
fun SelectGameCategoriesScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Image(
                painter = painterResource(id = R.drawable.choose_text),
                contentDescription = null,
                modifier = Modifier
                    .height(21.dp)
                    .width(247.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Select your preferences game category",
                color = LightGrey,
                modifier = Modifier
                    .height(21.dp)
                    .width(247.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(135.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    icon(id = R.drawable.dice, height = 135.dp, width = 100.dp)
                }
                Spacer(modifier = Modifier.width(50.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    icon(id = R.drawable.sword, height = 135.dp, width = 100.dp)
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
                    icon(id = R.drawable.sports, height = 135.dp, width = 100.dp)
                }
                Spacer(modifier = Modifier.width(50.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    icon(id = R.drawable.logic, height = 135.dp, width = 100.dp)
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
fun icon(id: Int, height: Dp, width: Dp) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier = Modifier
            .height(height)
            .width(width)

    )
}