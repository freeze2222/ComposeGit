package com.example.compose.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.theme.Yellow

lateinit var focusManager: FocusManager
fun moveFocus() {
    focusManager.moveFocus(FocusDirection.Next)
}

@Composable
fun SmsCodeVerificationScreen() {
    focusManager = LocalFocusManager.current
    Surface(color = Violet, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))
            var counter = "01:00"
            Text(
                text = counter,
                modifier = Modifier
                    .height(50.dp)
                    .width(110.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Type the verification code \nwe’ve sent you",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(58.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                NumberField()
                NumberField()
                NumberField()
                NumberField()
            }
            Spacer(modifier = Modifier.height(140.dp))
            CustomButton(
                text = "Submit",
                onClick = { /*TODO*/ },
                painterRes = null,
                color = Color.Yellow,
                textColor = Color.Black,
                borderColor = Color.Transparent
            )
            Spacer(modifier = Modifier.height(60.dp))
            Text(text = "Didn't receive the code?", color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))
            ClickableText(text = AnnotatedString("Send again!"),onClick = {/*TODO*/}, style = TextStyle(color = Yellow))
        }
    }
}

@Preview
@Composable
fun SmsCodeVerificationScreenPreview() {
    SmsCodeVerificationScreen()
}

@Composable
fun NumberField() {
    val state = rememberSaveable { mutableStateOf("") }
    val modifier = Modifier
        .padding(5.dp)
        .width(67.dp)
        .height(70.dp)
        .wrapContentHeight(Alignment.CenterVertically)
    OutlinedTextField(
        modifier = modifier,
        textStyle = TextStyle.Default.copy(fontWeight = FontWeight.SemiBold, fontSize = 32.sp, textAlign = TextAlign.Center),
        colors = if (state.value.isEmpty()) TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Yellow,
            backgroundColor = LightGrey
        ) else TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Yellow,
            backgroundColor = LightGrey,
            unfocusedBorderColor = Yellow
        ),
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        value = state.value,
        onValueChange = {
            val value = { if (it.length > 1 || it.any { !it.isDigit() }) state.value else it }
            state.value = value()
            if (state.value.isNotEmpty()) {
                moveFocus()
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
    )
}