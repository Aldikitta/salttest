package com.aldikitta.salttest.data.remote.model.ktorclient

import kotlinx.serialization.SerialName

//data class LoginDto(
//    @SerializedName("email") val email: String,
//    @SerializedName("password") val password: String
//)

@kotlinx.serialization.Serializable
data class KtorLoginDto(
    @SerialName("email") val email: String,
    @SerialName("password") val password: String
)
