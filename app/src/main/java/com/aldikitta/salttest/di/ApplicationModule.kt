package com.aldikitta.salttest.di

import com.aldikitta.salttest.data.remote.KtorApiCall
import com.aldikitta.salttest.data.repository.AuthRepositoryImpl
import com.aldikitta.salttest.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

//    @Provides
//    fun providePostsApi(client: KtorApiCall): AuthRepository = AuthRepositoryImpl(client)

    @Provides
    fun provideAuthRepository(client: KtorApiCall): AuthRepository {
        return AuthRepositoryImpl(client)
    }
//    @Provides
//    @Singleton
//    fun providePostsApiRetrofit(client: KtorApiCall): AuthRepository = AuthRepositoryImpl(client)

}