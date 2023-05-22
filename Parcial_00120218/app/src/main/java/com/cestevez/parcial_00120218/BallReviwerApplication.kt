package com.cestevez.parcial_00120218

import android.app.Application
import com.cestevez.parcial_00120218.data.model.balls
import com.cestevez.parcial_00120218.repositories.BallRepository

class BallReviwerApplication : Application(){
    val BallRepository: BallRepository by lazy {
        BallRepository(balls)
    }
}