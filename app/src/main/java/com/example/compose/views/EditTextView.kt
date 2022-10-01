package com.example.compose.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.Grey
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Yellow

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