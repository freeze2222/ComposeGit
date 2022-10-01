package com.example.compose.ui.screens.authScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.R
import com.example.compose.ui.data.descriptionData
import com.example.compose.ui.data.imageData
import com.example.compose.ui.data.regularFont
import com.example.compose.ui.data.titleData
import com.example.compose.ui.screens.nav.Screen
import com.example.compose.ui.theme.BorderGrey
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.theme.Yellow
import com.example.compose.views.*

@Composable
fun LoginScreen(navController:NavController) {
    Surface(color = Violet, modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            TextZone(text = titleData[1])
            Spacer(modifier = Modifier.height(15.dp))
            TextZone(text = descriptionData[0], fontFamily = regularFont, size = 16.sp, color = LightGrey)
            Spacer(modifier = Modifier.height(50.dp))
            EditText(hint = "Email Address", false) {}
            Spacer(modifier = Modifier.height(24.dp))
            EditText(hint = "Password", true) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(imageData[0]),
                        contentDescription = "Show password",
                        modifier = Modifier
                            .height(12.dp)
                            .width(32.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .padding(end = 44.dp)
                    .align(Alignment.End)
            ) {
                ClickableText(
                    text = AnnotatedString("Forgot Password"),
                    onClick = {
                        navController.navigate(Screen.Forgot.route){
                            popUpTo(Screen.Register.route){
                                inclusive=true
                            }
                        }
                    }, style = TextStyle.Default.copy(color = Color.Yellow)
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            CustomButton(
                text = "Login Now",
                painterRes = null,
                onClick = {/*TODO*/ },
                color = Yellow,
                textColor = Color.Black,
                borderColor = Color.Transparent
            )
            Spacer(modifier = Modifier.height(24.dp))
            CustomButton(
                text = "Sign in with Google",
                painterRes = painterResource(id = imageData[4]),
                onClick = {/*TODO*/ },
                color = Color.Transparent,
                textColor = Color.White,
                borderColor = BorderGrey
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Don't have an account? ", color = LightGrey)
                ClickableText(
                    text = AnnotatedString("Create one"),
                    onClick = {
                        navController.navigate(Screen.Register.route){
                            popUpTo(Screen.Register.route){
                                inclusive=true
                            }
                        }
                    },
                    style = TextStyle.Default.copy(
                    color = Color.Yellow, fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = NavController(LocalContext.current))
}