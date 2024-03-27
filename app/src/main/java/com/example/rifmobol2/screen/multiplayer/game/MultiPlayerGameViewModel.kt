package com.example.rifmobol2.screen.multiplayer.game

import android.content.ContentResolver
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import com.example.rifmobol2.Constant.SCORE_P1
import com.example.rifmobol2.Constant.SCORE_P2
import com.example.rifmobol2.R
import com.example.rifmobol2.data.multiplayer.MultiPlayerGameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MultiPlayerGameViewModel @Inject constructor(
    private val repository: MultiPlayerGameRepository.Base,
    private val player: Player,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var state: MultiPlayerGameState by mutableStateOf(MultiPlayerGameState())
        private set

    init {
        val scoreP1: Int = savedStateHandle[SCORE_P1] ?: 0
        val scoreP2: Int = savedStateHandle[SCORE_P2] ?: 0

        viewModelScope.launch {

            send(MultiPlayerGameEvent.PlayMusic)
        }
    }

    fun send(event: MultiPlayerGameEvent){
        when(event){
            is MultiPlayerGameEvent.UpLeftButtonClickP1->{
                turnOffTheButtonsP1()
                state = state.copy(upLeftButtonColorP1 = R.color.blue)
                checkingClickP1AndP2()

                player.addListener(object : Player.Listener {
                    override fun onPlaybackStateChanged(playbackState: Int) {
                        super.onPlaybackStateChanged(playbackState)
                        when (playbackState) {
                            Player.STATE_ENDED -> {

                                checkingTheResponse()

                                with(state){
                                    if (upLeftButtonColorP1 == R.color.green) state = state.copy(scoreP1 = scoreP1+1)
                                    if (upLeftButtonColorP2 == R.color.green) state = state.copy(scoreP2 = scoreP2+1)
                                }

                                player.release()
                                /*event.navController.navigate(route = singleDialogRoute(state.singleRoundInfo!!.upLeftButton.isChecked))*/
                            }
                        }
                    }
                })
            }
            is MultiPlayerGameEvent.UpRightButtonClickP1 -> {
                turnOffTheButtonsP1()
                state = state.copy(upRightButtonColorP1 = R.color.blue)
                checkingClickP1AndP2()
            }
            is MultiPlayerGameEvent.BottomLeftButtonCLickP1 -> {
                turnOffTheButtonsP1()
                state = state.copy(bottomLeftButtonColorP1 = R.color.blue)
                checkingClickP1AndP2()
            }
            is MultiPlayerGameEvent.BottomRightButtonClickP1 -> {
                turnOffTheButtonsP1()
                state = state.copy(bottomRightButtonColorP1 = R.color.blue)
                checkingClickP1AndP2()
            }
            is MultiPlayerGameEvent.UpLeftButtonClickP2 -> {
                turnOffTheButtonsP2()
                state = state.copy(upLeftButtonColorP2 = R.color.blue)
                checkingClickP1AndP2()
            }
            is MultiPlayerGameEvent.UpRightButtonClickP2 -> {
                turnOffTheButtonsP2()
                state = state.copy(upRightButtonColorP2 = R.color.blue)
                checkingClickP1AndP2()
            }
            is MultiPlayerGameEvent.BottomLeftButtonCLickP2 -> {
                turnOffTheButtonsP2()
                state = state.copy(bottomLeftButtonColorP2 = R.color.blue)
                checkingClickP1AndP2()
            }
            is MultiPlayerGameEvent.BottomRightButtonClickP2 -> {
                turnOffTheButtonsP2()
                state = state.copy(bottomRightButtonColorP2 = R.color.blue)
                checkingClickP1AndP2()
            }
            MultiPlayerGameEvent.PlayMusic -> playMusic()
            MultiPlayerGameEvent.Pause -> player.pause()
            MultiPlayerGameEvent.Resume -> player.play()
        }
    }

    override fun onCleared() {
        super.onCleared()
        player.release()
    }

    private fun playMusic(){
        val file = Uri.Builder()
            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            .path(state.roundInfo!!.musicOne.toString())
            .build()

        player.addMediaItem(MediaItem.fromUri(file))
        player.prepare()
        player.play()
    }

    private fun playMusic2(){
        val file2 = Uri.Builder()
            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            .path(state.roundInfo!!.musicTwo.toString())
            .build()
        player.setMediaItem(
            MediaItem.fromUri(file2)
        )
        player.prepare()
        player.play()
    }

    private fun checkingClickP1AndP2(){
        if (!state.enabledButtonsP1 && !state.enabledButtonsP2) playMusic2()
    }

    private fun checkingTheResponse() {
        with(state.roundInfo!!){
            if (upLeftButton.isChecked){
                state = state.copy(upLeftButtonColorP1 = R.color.green)
                state = state.copy(upLeftButtonColorP2 = R.color.green)
            }
            if (upRightButton.isChecked){
                state = state.copy(upRightButtonColorP1 = R.color.green)
                state = state.copy(upRightButtonColorP2 = R.color.green)
            }
            if (bottomLeftButton.isChecked){
                state = state.copy(bottomLeftButtonColorP1 = R.color.green)
                state = state.copy(bottomLeftButtonColorP2 = R.color.green)
            }
            if (bottomRightButton.isChecked){
                state = state.copy(bottomRightButtonColorP1 = R.color.green)
                state = state.copy(bottomRightButtonColorP2 = R.color.green)
            }
        }
    }


    private fun turnOffTheButtonsP1(){
        state = state.copy(enabledButtonsP1 = false)
    }

    private fun turnOffTheButtonsP2(){
        state = state.copy(enabledButtonsP2 = false)
    }

}