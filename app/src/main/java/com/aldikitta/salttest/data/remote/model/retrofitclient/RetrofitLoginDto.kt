package com.aldikitta.salttest.data.remote.model.retrofitclient

import com.google.gson.annotations.SerializedName

data class RetrofitLoginDto(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)
