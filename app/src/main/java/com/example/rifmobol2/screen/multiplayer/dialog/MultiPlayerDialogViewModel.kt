package com.example.rifmobol2.screen.multiplayer.dialog

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.rifmobol2.Constant
import com.example.rifmobol2.Constant.ID_ARGUMENT
import com.example.rifmobol2.Constant.SCORE_P1
import com.example.rifmobol2.Constant.SCORE_P2
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MultiPlayerDialogViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var state: MultiPlayerDialogState by mutableStateOf(MultiPlayerDialogState())

    init {

        val scoreP1: Int = savedStateHandle[SCORE_P1] ?: 0
        val scoreP2: Int = savedStateHandle[SCORE_P2] ?: 0

        val id: Int = savedStateHandle[ID_ARGUMENT] ?: 1

        state = state.copy(id = id, scoreP1 = scoreP1, scoreP2 = scoreP2)

    }

}