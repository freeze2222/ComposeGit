package com.example.compose.ui.views

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.screens.authScreens.moveFocus
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.theme.Yellow

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
            val value = fun(): String {
                return if (it.length > 1 || it.any { !it.isDigit() }) it[1].toString() else it
            }
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