package com.example.compose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.theme.Yellow

@Composable
fun CreatePasswordScreen() {
    Surface(color = Violet, modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Image(
                painter = painterResource(id = R.drawable.create_new_password),
                contentDescription = null,
                modifier = Modifier
                    .height(29.dp)
                    .width(253.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            EditText(hint = "Old Password", isPassword = true) {}
            Spacer(modifier = Modifier.height(24.dp))
            EditText(hint = "Confirm New Password", isPassword = true) {
                Icon(
                    painter = painterResource(id = R.drawable.eye),
                    contentDescription = "Show password",
                    modifier = Modifier
                        .height(12.dp)
                        .width(32.dp),
                    tint = LightGrey
                )
            }
            Spacer(modifier = Modifier.height(104.dp))
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
fun CreatePasswordScreenPreview() {
    CreatePasswordScreen()
}