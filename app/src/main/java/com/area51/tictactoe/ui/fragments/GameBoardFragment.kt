package com.area51.tictactoe.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.transition.TransitionInflater
import com.area51.tictactoe.R
import com.area51.tictactoe.models.GameBoardViewModel

/**
 * GameBoard fragment
 */
class GameBoardFragment : Fragment() {

    private lateinit var gameBoardViewModel: GameBoardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_board, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameBoardViewModel = ViewModelProviders.of(this).get(GameBoardViewModel::class.java)

        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)

    }


}
