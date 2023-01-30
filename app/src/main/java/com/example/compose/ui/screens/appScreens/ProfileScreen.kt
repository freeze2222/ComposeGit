package com.example.compose.ui.screens.appScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.model.data.*
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.CustomButton
import com.example.compose.ui.views.EditText
import com.example.compose.ui.views.TextZone


@Composable
fun ProfileScreen() {
    val nameModel = ValueModel()
    val emailModel = ValueModel()
    val passwordModel = ValueModel()
    Surface(modifier = Modifier.fillMaxSize(), color = Violet) {
        Column(
            modifier = Modifier
                .padding(start = 22.dp, end = 22.dp)
                .fillMaxSize(),

            ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.height(50.dp), verticalAlignment = Alignment.CenterVertically) {
                TextZone(text = titleData[5])
                Spacer(modifier = Modifier.width(145.dp))
                Image(
                    painter = painterResource(id = imageData[9]),
                    contentDescription = null,
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                )

            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = imageData[10]),
                    contentDescription = null,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .clip(
                            CircleShape
                        )
                )
                Spacer(modifier = Modifier.width(25.dp))
                Column(
                    Modifier
                        .height(100.dp),
                ) {
                    TextZone(text = titleData[4])
                    Spacer(modifier = Modifier.height(4.dp))
                    TextZone(
                        text = descriptionData[3],
                        color = Color.White,
                        fontFamily = regularFont,
                        size = 16.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    TextZone(
                        text = descriptionData[4],
                        fontFamily = regularFont,
                        size = 16.sp,
                        color = LightGrey
                    )
                }
            }
            Spacer(modifier = Modifier.height(48.dp))
            TextZone(
                text = descriptionData[5],
                fontFamily = boldFont,
                size = 16.sp,
                color = LightGrey,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(16.dp))
            EditText(hint = "Name", isPassword = false,nameModel)
            Spacer(modifier = Modifier.height(24.dp))
            TextZone(
                text = descriptionData[6],
                fontFamily = boldFont,
                size = 16.sp,
                color = LightGrey,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(16.dp))
            EditText(hint = "Email", isPassword = false,emailModel)
            Spacer(modifier = Modifier.height(24.dp))
            TextZone(
                text = descriptionData[7],
                fontFamily = boldFont,
                size = 16.sp,
                color = LightGrey,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(16.dp))
            EditText(hint = "Password", isPassword = true,passwordModel)
            Spacer(modifier = Modifier.height(87.dp))
            CustomButton(
                text = "Save Changes",
                onClick = { /*TODO*/ }
            )
        }
    }
}
