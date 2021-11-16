package com.example.cryptocoin.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.cryptocoin.databinding.ActivityCryptoBinding
import com.example.cryptocoin.features.crypto.CryptoAdapter
import com.example.cryptocoin.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoActivity : AppCompatActivity() {

    private val viewModel: CryptoViewModel by viewModels()
    private lateinit var binding: ActivityCryptoBinding
    private val cryptoAdapter = CryptoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdapter()
        setupViewModels()
    }

    private fun setupAdapter() {
        binding.apply {
            cryptoRv.apply {
                adapter = cryptoAdapter
            }
        }
    }

    private fun setupViewModels() {
        viewModel.cryptoCoins.observe(this) { result ->
            cryptoAdapter.submitList(result.data)

            binding.apply {
                progressBar.isVisible = result is Resource.Loading<*> && result.data.isNullOrEmpty()
                errorTv.isVisible = result is Resource.Error<*> && result.data.isNullOrEmpty()
                errorTv.text = result.error?.localizedMessage
            }
        }
    }
}
