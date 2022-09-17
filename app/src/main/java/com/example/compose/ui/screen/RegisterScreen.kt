package com.example.compose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.ui.theme.Grey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.theme.Yellow

@Composable
fun RegisterScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Image(
                painter = painterResource(id = R.drawable.create_text),
                contentDescription = null,
                modifier = Modifier
                    .width(217.dp)
                    .height(29.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            EditText(hint = "Username") {}
            Spacer(modifier = Modifier.height(24.dp))
            EditText(hint = "Email Address") {}
            Spacer(modifier = Modifier.height(24.dp))
            EditText(hint = "Password") {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = "Show password"
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            CustomButton(text = "Create Account") {

            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}

@Composable
fun EditText(hint: String, trailingIcon: @Composable () -> Unit?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf("")
        }
        TextField(
            value = "",
            onValueChange = {
                text = it
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Grey,
                textColor = Color.White
            ),
            shape = RoundedCornerShape(15.dp),
            label = { Text(text = hint, color = Color.White, fontSize = 18.sp, fontStyle = FontStyle.Normal) },
            modifier = Modifier
                .height(56.dp)
                .width(327.dp),
            trailingIcon = {trailingIcon}
        )
    }
}

@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(64.dp)
            .width(327.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Yellow),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text = text, fontSize = 22.sp)
    }
}