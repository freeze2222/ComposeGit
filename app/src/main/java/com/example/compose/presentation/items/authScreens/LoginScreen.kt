package com.example.compose.presentation.items.authScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.domain.model.data.*
import com.example.compose.domain.model.nav_model.Screen
import com.example.compose.presentation.screen.main.MainViewModel
import com.example.compose.presentation.screen.value.ValueModel
import com.example.compose.repository.login
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.CustomButton
import com.example.compose.ui.views.EditText
import com.example.compose.ui.views.TextZone

@Composable
fun LoginScreen(navController: NavController, viewModel: MainViewModel) {
    val emailModel = ValueModel()
    val passwordModel = ValueModel()
    val context = LocalContext.current
    Surface(color = Violet, modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            TextZone(text = titleData[1])
            Spacer(modifier = Modifier.height(15.dp))
            TextZone(
                text = descriptionData[0],
                fontFamily = regularFont,
                size = 16.sp,
                color = LightGrey
            )
            Spacer(modifier = Modifier.height(50.dp))
            EditText(hint = "Email Address", false, emailModel)
            Spacer(modifier = Modifier.height(24.dp))
            EditText(hint = "Password", true, passwordModel)
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .padding(end = 44.dp)
                    .align(Alignment.End)
            ) {
                ClickableText(
                    text = AnnotatedString("Forgot Password"),
                    onClick = {
                        navController.navigate(Screen.Forgot.route) {
                            popUpTo(Screen.Register.route) {
                                inclusive = true
                            }
                        }
                    }, style = TextStyle.Default.copy(color = Color.Yellow)
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            CustomButton(
                text = "Login Now",
                onClick = {
                    login(
                        viewModel,
                        emailModel.value,
                        passwordModel.value,
                        context
                    )
                }
            )

            Spacer(modifier = Modifier.height(150.dp))
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Don't have an account? ", color = LightGrey)
                ClickableText(
                    text = AnnotatedString("Create one"),
                    onClick = {
                        navController.navigate(Screen.Register.route)
                    },
                    style = TextStyle.Default.copy(
                        color = Color.Yellow, fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }

}
