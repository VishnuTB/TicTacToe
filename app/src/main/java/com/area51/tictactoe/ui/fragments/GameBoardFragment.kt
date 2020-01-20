package com.area51.tictactoe.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.transition.TransitionInflater
import com.area51.tictactoe.R
import com.area51.tictactoe.models.GameBoardViewModel
import kotlinx.android.synthetic.main.fragment_game_board.*

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

        val player1 = arguments?.getString("PLAYER1")
        val player2 = arguments?.getString("PLAYER2")

        player1?.let {
            gameBoardViewModel.setPlayer1Name(it)
        }
        player2?.let {
            gameBoardViewModel.setPlayer2Name(it)
        }

        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        gameBoardViewModel.player1Name.observe(this, Observer { player1Name ->
            textViewPlayer1Name.text = player1Name
        })
        gameBoardViewModel.player2Name.observe(this, Observer { player2Name ->
            textViewPlayer2Name.text = player2Name
        })

    }


}
