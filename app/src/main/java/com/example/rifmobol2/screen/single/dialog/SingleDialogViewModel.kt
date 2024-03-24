package com.example.rifmobol2.screen.single.dialog

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rifmobol2.Constant.ANSWER_ARGUMENT
import com.example.rifmobol2.Constant.ID_ARGUMENT
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleDialogViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var state: SingleDialogState by mutableStateOf(SingleDialogState())
        private set

    init {
        viewModelScope.launch {
            val id: Int = savedStateHandle[ID_ARGUMENT] ?: 1
            val answer: Boolean = savedStateHandle[ANSWER_ARGUMENT] ?: false

            state = state.copy(idNext = id +1)
            state = state.copy(idReplay = id)
            state = state.copy(answer = answer)
        }
    }

}