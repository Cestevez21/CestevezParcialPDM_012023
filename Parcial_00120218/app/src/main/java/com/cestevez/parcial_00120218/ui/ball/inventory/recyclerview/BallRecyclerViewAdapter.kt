package com.cestevez.parcial_00120218.ui.ball.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cestevez.parcial_00120218.data.model.BallModel
import com.cestevez.parcial_00120218.databinding.BallItemBinding

class BallRecyclerViewAdapter (
    private val clickListener: (BallModel) -> Unit) : RecyclerView.Adapter<BallRecyclerViewHolder>(){
    private val balls = ArrayList<BallModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BallRecyclerViewHolder {
        val binding = BallItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BallRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return balls.size
    }

    override fun onBindViewHolder(holder: BallRecyclerViewHolder, position: Int) {
        val ball = balls[position]
        holder.bind(ball,clickListener)
    }

    fun setData(moviesList: List<BallModel>){
        balls.clear()
        balls.addAll(moviesList)
    }

}