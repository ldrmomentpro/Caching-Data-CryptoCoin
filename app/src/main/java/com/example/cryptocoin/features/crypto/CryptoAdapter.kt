package com.example.cryptocoin.features.crypto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cryptocoin.data.Crypto
import com.example.cryptocoin.databinding.CryptoItemBinding

class CryptoAdapter : ListAdapter<Crypto, CryptoAdapter.CryptoViewHolder>(CryptoComparator()) {

    class CryptoViewHolder(private val binding: CryptoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(crypto: Crypto) {
            binding.apply {
                Glide.with(itemView)
                    .load(crypto.logo)
                    .into(logoIv)

                nameTv.text = crypto.coin_name
                acronymTv.text = crypto.acronym
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding = CryptoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class CryptoComparator : DiffUtil.ItemCallback<Crypto>() {
        override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto) =
            oldItem.coin_name == newItem.coin_name

        override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto) =
            oldItem == newItem
    }
}