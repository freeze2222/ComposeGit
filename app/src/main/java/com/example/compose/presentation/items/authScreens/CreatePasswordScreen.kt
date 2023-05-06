package com.example.compose.presentation.items.authScreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.presentation.screen.value.ValueModel
import com.example.compose.domain.model.data.titleData
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.CustomButton
import com.example.compose.ui.views.EditText
import com.example.compose.presentation.items.views.TextZone

@Composable
fun CreatePasswordScreen() {
    val oldPassword = ValueModel()
    val newPassword = ValueModel()
    Surface(color = Violet, modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            TextZone(text = titleData[3])
            Spacer(modifier = Modifier.height(50.dp))
            EditText(hint = "Old Password", isPassword = true, oldPassword)
            Spacer(modifier = Modifier.height(24.dp))
            EditText(hint = "Confirm New Password", isPassword = true, newPassword)
            Spacer(modifier = Modifier.height(104.dp))
            CustomButton(
                text = "Send Link",
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Preview
@Composable
fun CreatePasswordScreenPreview() {
    CreatePasswordScreen()
}