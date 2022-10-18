package com.aldikitta.salttest.data.repository

import com.aldikitta.salttest.data.remote.KtorApiCall
import com.aldikitta.salttest.data.remote.KtorApiCall.Companion.POSTS_URL
import com.aldikitta.salttest.data.remote.model.ktorclient.KtorLoginDto
import com.aldikitta.salttest.data.remote.model.ktorclient.KtorTokenDto
import com.aldikitta.salttest.domain.repository.AuthRepository
import io.ktor.client.request.*
import io.ktor.http.*

class AuthRepositoryImpl(
    private val ktorApiCall: KtorApiCall
) : AuthRepository {

    override suspend fun getToken(loginDto: KtorLoginDto): KtorTokenDto {
        return ktorApiCall.ktorHttpClient.post {
            url(POSTS_URL)
            contentType(ContentType.Application.Json)
            body = loginDto
        }
    }
}