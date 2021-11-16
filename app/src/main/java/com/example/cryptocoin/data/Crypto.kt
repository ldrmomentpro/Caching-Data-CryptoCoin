package com.example.cryptocoin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cryptoTable")
data class Crypto(
    @PrimaryKey val coin_name: String,
    val acronym: String,
    val logo: String
)
