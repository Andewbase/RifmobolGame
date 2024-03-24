package com.example.rifmobol2.screen.single.menu

import androidx.lifecycle.ViewModel
import com.example.rifmobol2.data.SingleGameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingleMenuViewModel@Inject constructor(
    private val repository: SingleGameRepository.Base
): ViewModel() {


    val textLevels = repository.getTextLevels()

}