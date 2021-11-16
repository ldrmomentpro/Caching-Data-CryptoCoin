package com.example.cryptocoin.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoDao {

    @Query("SELECT * FROM cryptoTable")
    fun getAllCryptoCoins(): Flow<List<Crypto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCryptos(cryptoCoins: List<Crypto>)

    @Query("DELETE FROM cryptoTable")
    suspend fun deleteAllCryptoCoins()
}