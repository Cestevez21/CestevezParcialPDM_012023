package com.cestevez.parcial_00120218.ui.ball.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cestevez.parcial_00120218.BallReviwerApplication
import com.cestevez.parcial_00120218.data.model.BallModel
import com.cestevez.parcial_00120218.repositories.BallRepository

class BallViewModel (private val repository: BallRepository) : ViewModel(){
    val type = MutableLiveData("")
    val color = MutableLiveData("")
    val status = MutableLiveData("")
    
    fun getBalls () = repository.getBalls()
    
    private fun addBalls(ball: BallModel)  = repository.addBalls(ball)
    
    fun createBalls(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val ball = BallModel(
            type.value!!,
            color.value!!,
            )
        addBalls(ball)
        clearData()

        status.value = MOVIE_CREATED
    }

    fun setSelectedBalls(ball: BallModel){
        type.value = ball.type
        color.value = ball.color
    }

    private fun validateData(): Boolean{
        when {
            type.value.isNullOrBlank() -> return false
            color.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun clearData(){
        type.value = ""
        color.value = ""
    }
    fun clearStatus(){
        status.value = INACTIVE
    }
    
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val ballRepositoryApp = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BallReviwerApplication).BallRepository

                BallViewModel(ballRepositoryApp)
            }
        }
        const val MOVIE_CREATED = "Ball created"
        const val  WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""

    }
    
}