package com.aldikitta.salttest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aldikitta.salttest.navigation.Destination
import com.aldikitta.salttest.presentation.MainViewModel
import com.aldikitta.salttest.presentation.home.Home
import kotlinx.coroutines.launch


@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun NavigationScreen(viewModel: MainViewModel = hiltViewModel()) {

    val navController = rememberNavController()
    val loadingProgressBar = viewModel.progressBar.collectAsStateWithLifecycle()
    val imageError = viewModel.imageErrorAuth.collectAsStateWithLifecycle()
    var successLoading = viewModel.isSuccessLoading.collectAsStateWithLifecycle()
    var scope = rememberCoroutineScope()
    NavHost(
        navController = navController,
        startDestination = Destination.getStartDestination()
    ) {
        composable(route = Destination.Login.route) {
            if (successLoading.value) {
                LaunchedEffect(key1 = Unit) {
                    navController.popBackStack()
                    navController.navigate(route = Destination.Home.route) {
//                        popUpTo(route = Destination.Login.route) {
//                            inclusive = true
//
//                        }
//                        launchSingleTop
                    }

                }
            } else {
                com.aldikitta.salttest.presentation.login.Login(
                    loadingProgressBar = loadingProgressBar.value,
                    onclickLogin = viewModel::login,
                    imageError = imageError.value
                )
            }
        }

        composable(route = Destination.Home.route) {
            Home(navController, viewModel)
        }
    }
}