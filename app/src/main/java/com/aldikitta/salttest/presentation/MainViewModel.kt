package com.aldikitta.salttest.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldikitta.salttest.data.remote.RetrofitHelper
import com.aldikitta.salttest.data.remote.model.ktorclient.KtorLoginDto
import com.aldikitta.salttest.data.remote.model.retrofitclient.RetrofitLoginDto
import com.aldikitta.salttest.data.repository.AuthRepositoryImpl
import com.aldikitta.salttest.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
//    private val repository: AuthRepositoryImpl,
//    private val retrofitHelper: RetrofitHelper
) : ViewModel() {

    val isSuccessLoading = MutableStateFlow(false)
//    var successLoading = _isSuccessLoading.asStateFlow()
//    val isSuccessLoading = mutableStateOf(value = false)
    private val _imageErrorAuth = MutableStateFlow(false)
    val imageErrorAuth = _imageErrorAuth.asStateFlow()
    private val _progressBar = MutableStateFlow(false)
    val progressBar = _progressBar.asStateFlow()
    private val loginRequestStateFlow = MutableStateFlow<Boolean>(false)
    private val loginRequestLiveData = MutableLiveData<Boolean>()
    var tokenString = ""
//    val tokenString = _progressBar.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _progressBar.value = true
//                val responseServiceKtor = repository.getToken(KtorLoginDto(email, password))
                 val authService = RetrofitHelper.getAuthService()
                val responseService = authService.getLogin(RetrofitLoginDto(email = email, password = password))

                if (responseService.isSuccessful) {
                    delay(1500L)
                    isSuccessLoading.value = true
                    responseService.body()?.let { tokenDto ->
                        Timber.tag("Logging").d("Response TokenDto: %s", tokenDto)
                        tokenString = tokenDto.toString()
                    }
                } else {
                    responseService.errorBody()?.let { error ->
                        _imageErrorAuth.value = true
                        delay(1500L)
                        _imageErrorAuth.value = false
                        error.close()
                    }
                }

                loginRequestLiveData.postValue(responseService.isSuccessful)
                _progressBar.value = false
            } catch (e: Exception) {
                Timber.tag("Logging").d(e, "Error Authentication")
                _progressBar.value = false
            }
        }
    }
}