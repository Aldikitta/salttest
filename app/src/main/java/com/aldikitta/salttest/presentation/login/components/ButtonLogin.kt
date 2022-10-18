package com.aldikitta.salttest.presentation.login.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonLogin(
    onclick: () -> Unit,
    enabled: Boolean
) {
    Button(
        onClick = onclick,
//        modifier = Modifier.width(200.dp),
        enabled = enabled,
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.titleLarge,
        )
    }
}