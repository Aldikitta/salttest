package com.aldikitta.salttest.presentation.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aldikitta.salttest.R
import com.aldikitta.salttest.navigation.Destination
import com.aldikitta.salttest.presentation.MainViewModel
import com.aldikitta.salttest.ui.theme.spacing
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun Home(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
//    val viewModel: MainViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val listColorBackground = listOf(
        Color(33, 150, 243, 255),
        Color(3, 169, 244, 255),
        Color(0, 188, 212, 255),
    )

    val day = SimpleDateFormat("h:mm a")
    val month = SimpleDateFormat("EEE, MMM d")

    val dayOfMonth = month.format(Date())
    var dayOfWeek by remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        while (true) {
            var getCurrentTime = day.format(Date())
            dayOfWeek = getCurrentTime
            delay(1000)
        }
    }

    val currentHour by remember {
        mutableStateOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
    }
    var greeting by remember {
        mutableStateOf("")
    }
    LaunchedEffect(currentHour) {
        when (currentHour) {
            in 0..11 -> {
                greeting = "Good Morning"
                Log.d("TAG", greeting)
            }
            in 12..15 -> {
                greeting = "Good Afternoon"
                Log.d("TAG", greeting)
            }
            in 16..20 -> {
                greeting = "Good Evening"
                Log.d("TAG", greeting)
            }
            in 21..23 -> {
                greeting = "Good Night"
                Log.d("TAG", greeting)
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listColorBackground
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = MaterialTheme.spacing.small)
                        .wrapContentWidth(),
                    text = greeting,
//                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .padding(start = MaterialTheme.spacing.small)
                        .wrapContentWidth(),
                    text = "$dayOfWeek,\r\n$dayOfMonth",
//                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .padding(start = MaterialTheme.spacing.small)
                        .wrapContentWidth(),
                    text = "${viewModel.tokenString} see logcat",
//                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.titleLarge,
//                    fontWeight = FontWeight.Bold
                )
            }

        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = {
//            navController.popBackStack()
            viewModel.isSuccessLoading.value = false
            navController.navigate(route = Destination.Login.route)
        }) {
            Text(text = "Logout")
        }
    }

}