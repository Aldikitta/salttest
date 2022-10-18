package com.aldikitta.salttest.presentation.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aldikitta.salttest.R

@Composable
fun ErrorImageAuth(
    modifier: Modifier = Modifier,
    isImageValidate: Boolean
) {
    val openDialog = remember { mutableStateOf(true) }
    if (isImageValidate) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                openDialog.value = false
            },
            title = {
                Text(text = "Error Occurred")
            },
            text = {
                Text(text = "Something went wrong")
            },
            confirmButton = {
//                TextButton(
//                    onClick = {
//                        openDialog.value = false
//                    }
//                ) {
//                    Text("Confirm")
//                }
            },
        )
//        Box(
//            modifier = modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_error_imagen),
//                contentDescription = "Image Error",
//                modifier = modifier.size(250.dp)
//
//            )
//        }
    }
}