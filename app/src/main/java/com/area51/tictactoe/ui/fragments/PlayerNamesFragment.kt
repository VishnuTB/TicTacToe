package com.area51.tictactoe.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.area51.tictactoe.R
import kotlinx.android.synthetic.main.fragment_player_names.*

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

        val extras = FragmentNavigatorExtras(
            textViewAppName to "appName"
        )
        buttonStartGame.setOnClickListener {
            findNavController().navigate(
                R.id.action_playerNamesFragment_to_gameBoardFragment,
                null,
                null,
                extras
            )
        }
    }

}
