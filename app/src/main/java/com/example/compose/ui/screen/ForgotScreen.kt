package com.example.compose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.ui.theme.Grey
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.theme.Yellow

@Composable
fun ForgotScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Image(
                painter = painterResource(id = R.drawable.forgot_password),
                contentDescription = null,
                modifier = Modifier
                    .height(29.dp)
                    .width(189.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                textAlign = TextAlign.Center,
                text = "Enter email address associated with your account and we’ll send an email with instructions to reset your password",
                color = LightGrey,
                modifier = Modifier.height(63.dp).width(315.dp)
            )
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