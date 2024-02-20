package com.carlacampo.booksphere.di

import com.carlacampo.booksphere.api.CatsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    //Interceptor with okhttp
    @Provides
    fun providesLoggerInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }
    @Provides
    fun providesOkhttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        return client
    }
    @Provides
    fun providesCatsService(client: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://cat-fact.herokuapp.com")
            //.addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit
    }
    @Provides
    fun providesCatApi(retrofit: Retrofit) = retrofit.create(CatsApi::class.java)

}
