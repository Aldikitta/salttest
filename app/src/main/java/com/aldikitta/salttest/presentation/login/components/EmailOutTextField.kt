package com.aldikitta.salttest.presentation.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailOutTextField(
    textValue: String,
    onValueChange: (String) -> Unit,
    onClickButton: () -> Unit,
    onNext: (KeyboardActionScope.() -> Unit)
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth(),
//            .padding(start = 20.dp, end = 20.dp),
        label = { Text(text = "Email") },
        placeholder = { Text(text = "email@mail.com") },
        trailingIcon = {
            IconButton(
                onClick = onClickButton
            ) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "Icon Clear"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = onNext
        ),
    )
}