package com.cestevez.parcial_00120218.ui.ball.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.cestevez.parcial_00120218.data.model.BallModel
import com.cestevez.parcial_00120218.databinding.BallItemBinding


class BallRecyclerViewHolder (private val binding: BallItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(ball: BallModel, clickListener: (BallModel) -> Unit){
        binding.typeTextView.text = ball.type
        binding.colorTextView.text = ball.color

        binding.movieItemCardView.setOnClickListener{
            clickListener(ball)
        }
    }
}