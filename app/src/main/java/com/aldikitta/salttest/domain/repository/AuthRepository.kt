package com.aldikitta.salttest.domain.repository

import com.aldikitta.salttest.data.remote.model.ktorclient.KtorLoginDto
import com.aldikitta.salttest.data.remote.model.ktorclient.KtorTokenDto

interface AuthRepository {
    suspend fun getToken(loginDto: KtorLoginDto): KtorTokenDto
}