package com.area51.tictactoe.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.area51.tictactoe.R
import com.area51.tictactoe.models.GameBoardViewModel
import kotlinx.android.synthetic.main.fragment_player_names.*

/**
 * Player names are inserted from here
 */
class PlayerNamesFragment : Fragment() {

    private var startGameButton: AppCompatButton? = null

    private lateinit var gameBoardViewModel: GameBoardViewModel

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

        gameBoardViewModel = ViewModelProviders.of(this).get(GameBoardViewModel::class.java)

        editTextPlayer1Name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                gameBoardViewModel.player1Name.postValue(editTextPlayer1Name.text.toString())
            }
        })
        editTextPlayer2Name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                gameBoardViewModel.player2Name.postValue(editTextPlayer2Name.text.toString())
            }
        })

        buttonStartGame.setOnClickListener {
            if (!gameBoardViewModel.player1Name.value.isNullOrEmpty()
                && !gameBoardViewModel.player2Name.value.isNullOrEmpty()
            ) {
                val extras = FragmentNavigatorExtras(
                    textViewAppName to "appName",
                    editTextPlayer1Name to "player1Name",
                    editTextPlayer2Name to "player2Name"
                )
                findNavController().navigate(
                    R.id.action_playerNamesFragment_to_gameBoardFragment,
                    null,
                    null,
                    extras
                )

            }

        }
    }

}
