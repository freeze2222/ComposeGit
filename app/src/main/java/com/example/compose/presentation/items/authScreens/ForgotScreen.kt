package com.example.compose.presentation.items.authScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose.domain.model.data.descriptionData
import com.example.compose.domain.model.data.regularFont
import com.example.compose.domain.model.data.titleData
import com.example.compose.presentation.items.views.TextZone
import com.example.compose.presentation.screen.value.ValueModel
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.CustomButton
import com.example.compose.ui.views.EditText

@Composable
fun ForgotScreen(navController: NavHostController) {
    val email = ValueModel()
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            TextZone(text = titleData[2])
            Spacer(modifier = Modifier.height(15.dp))
            TextZone(text = descriptionData[1], fontFamily = regularFont, size = 16.sp, color = LightGrey)
            Spacer(modifier = Modifier.height(50.dp))
            EditText(hint = "Email", false, email)
            Spacer(modifier = Modifier.height(106.dp))
            CustomButton(
                text = "Send Link",
                onClick = { /*TODO*/ }
            )
        }
    }
}