package com.example.compose.presentation.items.authScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose.domain.model.data.titleData
import com.example.compose.presentation.items.views.TextZone
import com.example.compose.presentation.screen.value.ValueModel
import com.example.compose.repository.createAccount
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.theme.Yellow
import com.example.compose.ui.views.CustomButton
import com.example.compose.ui.views.EditText

@Composable
fun RegisterScreen(navController: NavHostController) {
    val usernameModel = ValueModel()
    val emailModel = ValueModel()
    val passwordModel = ValueModel()
    val context = LocalContext.current
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            TextZone(text = titleData[0])
            Spacer(modifier = Modifier.height(50.dp))
            EditText(hint = "Username", false, usernameModel)
            Spacer(modifier = Modifier.height(24.dp))
            EditText(hint = "Email Address", false, emailModel)
            Spacer(modifier = Modifier.height(24.dp))
            EditText(hint = "Password", true, passwordModel)
            Spacer(modifier = Modifier.height(32.dp))
            CustomButton(
                text = "Create Account",
                painterRes = null,
                onClick = {
                    createAccount(
                        navController,
                        usernameModel.value,
                        emailModel.value,
                        passwordModel.value,
                        context
                    )
                },
                color = Yellow,
                textColor = Color.Black,
                borderColor = Color.Transparent
            )
        }
    }
}




