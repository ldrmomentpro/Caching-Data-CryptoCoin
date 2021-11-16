package com.example.cryptocoin.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.cryptocoin.data.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    repository: CryptoRepository
) : ViewModel() {

    val cryptoCoins = repository.getCryptoCoins().asLiveData()
}