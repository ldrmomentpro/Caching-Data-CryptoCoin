package com.example.cryptocoin.data

import androidx.room.withTransaction
import com.example.cryptocoin.api.CryptoApi
import com.example.cryptocoin.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class CryptoRepository @Inject constructor(
    private val api: CryptoApi,
    private val db: CryptoDatabase
) {
    private val cryptoDao = db.cryptoDao()

    fun getCryptoCoins() = networkBoundResource(
        query = { cryptoDao.getAllCryptoCoins() },
        fetch = {
            delay(2000)
            api.getCryptoCoins()
        },
        saveFetchResult = { cryptos ->
            db.withTransaction {
                cryptoDao.deleteAllCryptoCoins()
                cryptoDao.insertCryptos(cryptos)
            }
        }
    )
}