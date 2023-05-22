package com.cestevez.parcial_00120218.repositories

import com.cestevez.parcial_00120218.data.model.BallModel
import com.cestevez.parcial_00120218.data.model.balls


class BallRepository (private val ball:MutableList<BallModel>){

    fun getBalls() = balls

    fun addBalls(ball:BallModel) = balls.add(ball)

}