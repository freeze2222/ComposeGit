package com.example.compose.ui.screens.authScreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.ui.data.titleData
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.theme.Yellow
import com.example.compose.views.CustomButton
import com.example.compose.views.EditText
import com.example.compose.views.TextZone

@Composable
fun RegisterScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            TextZone(text = titleData[0])
            Spacer(modifier = Modifier.height(50.dp))
            EditText(hint = "Username", false) {}
            Spacer(modifier = Modifier.height(24.dp))
            EditText(hint = "Email Address", false) {}
            Spacer(modifier = Modifier.height(24.dp))
            EditText(hint = "Password", true) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = "Show password",
                        modifier = Modifier
                            .height(12.dp)
                            .width(32.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            CustomButton(
                text = "Create Account",
                painterRes = null,
                onClick = {/*TODO*/ },
                color = Yellow,
                textColor = Color.Black,
                borderColor = Color.Transparent
            )
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}



