package com.area51.tictactoe.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameBoardViewModel(application: Application) : AndroidViewModel(application) {

    internal val player1Name: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    internal val player2Name: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun setPlayer1Name(playerName: String) {
        player1Name.postValue(playerName)
    }

    fun setPlayer2Name(playerName: String) {
        player2Name.postValue(playerName)
    }

}