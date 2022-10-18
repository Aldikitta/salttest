package com.aldikitta.salttest.data.remote

import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*

class KtorApiCall {

    companion object {
        private const val BASE_URL = "https://reqres.in/api/"
        const val POSTS_URL = "$BASE_URL/login"
    }

    val ktorHttpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

//    suspend fun getTokenKtor(loginDto: KtorLoginDto): TokenDto {
//        return ktorHttpClient.post {
//            url(POSTS_URL)
//            contentType(ContentType.Application.Json)
//            body = loginDto
//        }
//    }
}