package com.example.cryptocoin.api

import com.example.cryptocoin.data.Crypto
import retrofit2.http.GET

interface CryptoApi {
    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("crypto_coin/random_crypto_coin?size=20")
    suspend fun getCryptoCoins(): List<Crypto>
}