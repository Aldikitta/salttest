package com.aldikitta.salttest.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.aldikitta.salttest.R
import com.aldikitta.salttest.presentation.login.components.*

@Composable
fun Login(
    modifier: Modifier = Modifier,
    loadingProgressBar: Boolean,
    onclickLogin: (email: String, password: String) -> Unit,
    imageError: Boolean
) {
    var email by rememberSaveable { mutableStateOf(value = "") }
    var password by rememberSaveable { mutableStateOf(value = "") }
    val isValidate by derivedStateOf { email.isNotBlank() && password.isNotBlank() }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .clip(
                    shape = RoundedCornerShape(
                        bottomStart = 25.dp,
                        bottomEnd = 25.dp
                    )
                )
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFFB42B93),
                            Color(0xFF000000)
                        ),
                        radius = 415f
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
//            Image(
//                modifier = Modifier
//                    .size(280.dp)
//                    .offset(y = ((-20).dp)),
//                painter = painterResource(id = R.drawable.coloredtorus),
//                contentDescription = "Background Image"
//            )
        }
        Card(
            modifier = Modifier
                .offset(y = -20.dp)
                .padding(horizontal = 32.dp),
//            shape = RoundedCornerShape(25.dp),
//            elevation = 15.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .padding(top = 30.dp, bottom = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                EmailOutTextField(
                    textValue = email,
                    onValueChange = { email = it },
                    onClickButton = { email = "" },
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                )
                Spacer(modifier = modifier.height(16.dp))
                PasswordOutTextField(
                    textValue = password,
                    onValueChange = { password = it },
                    onDone = {
                        focusManager.clearFocus()
                    }
                )
            }
        }

        Spacer(modifier = modifier.height(35.dp))

        ButtonLogin(
            onclick = { onclickLogin(email, password) },
            enabled = isValidate
        )

        Spacer(modifier = modifier.height(20.dp))
    }

    ErrorImageAuth(isImageValidate = imageError)

    ProgressBarLoading(isLoading = loadingProgressBar)
}
