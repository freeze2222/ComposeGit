package com.example.compose.presentation.items.authScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.domain.model.data.descriptionData
import com.example.compose.domain.model.data.regularFont
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.theme.Yellow
import com.example.compose.ui.views.CustomButton
import com.example.compose.ui.views.NumberField
import com.example.compose.ui.views.TextZone

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
            TextZone(text = descriptionData[2], color = Color.White, fontFamily = regularFont, size = 16.sp)
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