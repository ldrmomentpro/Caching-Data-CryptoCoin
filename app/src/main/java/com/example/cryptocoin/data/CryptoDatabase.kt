package com.example.cryptocoin.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Crypto::class], version = 1)
abstract class CryptoDatabase : RoomDatabase() {

    abstract fun cryptoDao(): CryptoDao
}