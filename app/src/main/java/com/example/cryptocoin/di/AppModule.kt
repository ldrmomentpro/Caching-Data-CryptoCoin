package com.example.cryptocoin.di

import android.app.Application
import androidx.room.Room
import com.example.cryptocoin.api.CryptoApi
import com.example.cryptocoin.api.CryptoApi.Companion.BASE_URL
import com.example.cryptocoin.data.CryptoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideCryptoApi(retrofit: Retrofit): CryptoApi =
        retrofit.create(CryptoApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): CryptoDatabase =
        Room.databaseBuilder(app, CryptoDatabase::class.java, "crypto_database").build()
}