package com.area51.tictactoe.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameBoardViewModel : ViewModel() {

    val player1Name: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val player2Name: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

}