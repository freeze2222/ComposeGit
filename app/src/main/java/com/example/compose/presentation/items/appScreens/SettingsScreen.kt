package com.example.compose.presentation.items.appScreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.domain.model.data.*
import com.example.compose.presentation.items.oneTimeScreens.Img
import com.example.compose.presentation.items.views.TextZone
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.SettingsItem

@Composable
fun SettingsScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(24.dp))
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Img(id = imageData[12], height = 60.dp, width = 60.dp)
                }
                Spacer(modifier = Modifier.width(70.dp))
                TextZone(text = titleData[6], fontFamily = boldFont)
            }
            Spacer(
                modifier = Modifier
                    .height(40.dp)
                    .width(25.dp)
            )
            TextZone(
                modifier = Modifier.padding(start = 25.dp),
                text = descriptionData[11],
                fontFamily = regularFont,
                size = 16.sp,
                color = LightGrey,
            )
            Spacer(modifier = Modifier.height(25.dp))
            SettingsItem(text = descriptionData[12], painter = painterResource(id = imageData[13]), isSwitch = true)
            SettingsItem(text = descriptionData[13], painter = painterResource(id = imageData[14]))
            SettingsItem(text = descriptionData[14], painter = painterResource(id = imageData[15]))
            SettingsItem(text = descriptionData[15], painter = painterResource(id = imageData[16]))
            SettingsItem(text = descriptionData[16], painter = painterResource(id = imageData[17]), isBordered = false)
        }
    }
}
