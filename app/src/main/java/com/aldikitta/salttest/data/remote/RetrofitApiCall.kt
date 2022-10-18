package com.aldikitta.salttest.data.remote

import com.aldikitta.salttest.data.remote.model.retrofitclient.RetrofitLoginDto
import com.aldikitta.salttest.data.remote.model.retrofitclient.RetrofitTokenDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("login")
    suspend fun getLogin(@Body loginDto: RetrofitLoginDto) : Response<RetrofitTokenDto>
}