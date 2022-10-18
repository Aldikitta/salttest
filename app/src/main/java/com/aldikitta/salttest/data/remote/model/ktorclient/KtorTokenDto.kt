package com.aldikitta.salttest.data.remote.model.ktorclient

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class KtorTokenDto(@SerialName("accessToken") val accessTokenVerify: String)
