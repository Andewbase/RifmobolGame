package com.example.rifmobol2.screen.single.game

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
import com.example.rifmobol2.Constant.ANSWER_ARGUMENT
import com.example.rifmobol2.Constant.ID_ARGUMENT
import com.example.rifmobol2.R
import com.example.rifmobol2.data.single.SingleGameRepository
import com.example.rifmobol2.navigation.RifmobolScreen
import com.example.rifmobol2.screen.single.game.SingleGameEvent.BottomLeftButtonCLick
import com.example.rifmobol2.screen.single.game.SingleGameEvent.BottomRightButtonClick
import com.example.rifmobol2.screen.single.game.SingleGameEvent.PlayMusic
import com.example.rifmobol2.screen.single.game.SingleGameEvent.UpLeftButtonClick
import com.example.rifmobol2.screen.single.game.SingleGameEvent.UpRightButtonClick
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleGameViewModel @Inject constructor(
    private  val repository: SingleGameRepository.Base,
    private val player: Player,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var state: SingleGameState by mutableStateOf(SingleGameState())
        private set

    init {
        val id: Int = savedStateHandle[ID_ARGUMENT] ?: 1
        state = state.copy(idRound = id)

        viewModelScope.launch {
            repository.getRoundInfo(id).collect{ roundInfo ->
                state = state.copy(roundInfo = roundInfo)
            }
            send(PlayMusic)
        }
    }

    fun send(event: SingleGameEvent){
        when (event){

            is PlayMusic -> playMusic()

            is UpLeftButtonClick -> {
                turnOffTheButtons()
                state = state.copy(upLeftButtonColor = R.color.blue)


                playMusic2()

                player.addListener(object : Player.Listener {
                    override fun onPlaybackStateChanged(playbackState: Int) {
                        super.onPlaybackStateChanged(playbackState)
                        when (playbackState) {
                            Player.STATE_ENDED -> {

                                checkingTheResponse()

                                player.release()
                                event.navController.navigate(route = singleDialogRoute(state.roundInfo!!.upLeftButton.isChecked))
                            }
                        }
                    }
                })

            }
            is UpRightButtonClick -> {
                turnOffTheButtons()
                state = state.copy(upRightButtonColor = R.color.blue)

                playMusic2()

                player.addListener(object : Player.Listener {
                    override fun onPlaybackStateChanged(playbackState: Int) {
                        super.onPlaybackStateChanged(playbackState)
                        when (playbackState) {
                            Player.STATE_ENDED -> {

                                checkingTheResponse()

                                player.release()
                                event.navController.navigate(route = singleDialogRoute(state.roundInfo!!.upRightButton.isChecked))
                            }
                        }
                    }
                })

            }
            is BottomLeftButtonCLick -> {
                turnOffTheButtons()
                state = state.copy(bottomLeftButtonColor = R.color.blue)

                playMusic2()

                player.addListener(object : Player.Listener {
                    override fun onPlaybackStateChanged(playbackState: Int) {
                        super.onPlaybackStateChanged(playbackState)
                        when (playbackState) {
                            Player.STATE_ENDED -> {

                                checkingTheResponse()

                                player.release()
                                event.navController.navigate(route = singleDialogRoute(state.roundInfo!!.bottomLeftButton.isChecked))
                            }
                        }
                    }
                })

            }
            is BottomRightButtonClick -> {
                turnOffTheButtons()
                state = state.copy(bottomRightButtonColor = R.color.blue)

                playMusic2()

                player.addListener(object : Player.Listener {
                    override fun onPlaybackStateChanged(playbackState: Int) {
                        super.onPlaybackStateChanged(playbackState)
                        when (playbackState) {
                            Player.STATE_ENDED -> {

                                checkingTheResponse()

                                player.release()
                                event.navController.navigate(route = singleDialogRoute(state.roundInfo!!.bottomRightButton.isChecked))
                            }
                        }
                    }
                })

            }
            is SingleGameEvent.Resume -> player.play()
            is SingleGameEvent.Pause -> player.pause()
        }
    }

    override fun onCleared() {
        super.onCleared()
        player.release()
    }

    private fun singleDialogRoute(answer: Boolean) =
        RifmobolScreen.SingleDialog.name + "$ID_ARGUMENT=${state.idRound}&$ANSWER_ARGUMENT=${answer}"

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

    private fun checkingTheResponse() {
        with(state.roundInfo!!){
            if (upLeftButton.isChecked) state = state.copy(upLeftButtonColor = R.color.green)
            if (upRightButton.isChecked) state = state.copy(upRightButtonColor = R.color.green)
            if (bottomLeftButton.isChecked) state = state.copy(bottomLeftButtonColor = R.color.green)
            if (bottomRightButton.isChecked) state = state.copy(bottomRightButtonColor = R.color.green)
        }
    }

    private fun turnOffTheButtons(){
        state = state.copy(enabledButtons = false)
    }

}