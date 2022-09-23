package com.example.compose.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.ui.theme.Grey
import com.example.compose.ui.theme.LightGrey
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

@Composable
fun EditText(hint: String,isPassword: Boolean, trailingIcon: @Composable () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf("")
        }
        var focusState by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Grey,
                textColor = Color.White,
                focusedLabelColor = Color.Transparent,
                focusedBorderColor = Yellow,
                unfocusedBorderColor = Color.Transparent,

            ),
            shape = RoundedCornerShape(15.dp),
            placeholder = {
                Text(
                    text = if (focusState) "" else hint,
                    color = LightGrey,
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Normal
                )
            },
            modifier = Modifier
                .height(56.dp)
                .width(327.dp)
                .onFocusChanged { focus ->
                focusState = focus.isFocused
            },
            trailingIcon = trailingIcon,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else  VisualTransformation.None
        )
    }
}

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