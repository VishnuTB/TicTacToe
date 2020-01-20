package com.area51.tictactoe.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.area51.tictactoe.R
import kotlinx.android.synthetic.main.fragment_player_names.*

/**
 * Player names are inserted from here
 */
class PlayerNamesFragment : Fragment() {

    private var startGameButton: AppCompatButton? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player_names, container, false)
        startGameButton = view.findViewById(R.id.buttonStartGame)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        buttonStartGame.setOnClickListener {
            val player1 = if (editTextPlayer1Name.text.isNullOrEmpty()) {
                "Player1"
            } else {
                editTextPlayer1Name.text.toString()
            }
            val player2 = if (editTextPlayer2Name.text.isNullOrEmpty()) {
                "Player1"
            } else {
                editTextPlayer2Name.text.toString()
            }
            val extras = FragmentNavigatorExtras(
                textViewAppName to "appName",
                editTextPlayer1Name to "player1Name",
                editTextPlayer2Name to "player2Name"
            )
            val playerNamesBundle = bundleOf("PLAYER1" to player1, "PLAYER2" to player2)
            findNavController().navigate(
                R.id.action_playerNamesFragment_to_gameBoardFragment,
                playerNamesBundle,
                null,
                extras
            )

        }

    }

}
