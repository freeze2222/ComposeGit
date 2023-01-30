package com.example.compose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.model.data.ValueModel
import com.example.compose.model.data.imageData
import com.example.compose.ui.theme.Grey
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Yellow

@Composable
fun EditText(hint: String, isPassword: Boolean, valueModel: ValueModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf("")
        }
        valueModel.value = text
        var focusState by remember { mutableStateOf(false) }
        var visualTransformation by remember { mutableStateOf(if (isPassword) PasswordVisualTransformation() else VisualTransformation.None) }

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
            trailingIcon = if (isPassword) {
                {
                    IconButton(onClick = {
                        visualTransformation =
                            if (visualTransformation == PasswordVisualTransformation()) VisualTransformation.None else PasswordVisualTransformation()
                    }) {
                        Icon(
                            painter = painterResource(id = imageData[0]),
                            contentDescription = "Show password",
                            modifier = Modifier
                                .height(12.dp)
                                .width(32.dp),
                            tint = LightGrey
                        )
                    }
                }
            } else {
                null
            },
            visualTransformation = visualTransformation
        )
    }
}