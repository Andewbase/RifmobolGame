package z.nova.rifmobolgame.screen.singlevel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import z.nova.rifmobolgame.data.GameRepository
import z.nova.rifmobolgame.data.model.RoundInfo
import z.nova.rifmobolgame.data.model.RoundMusic
import javax.inject.Inject

@HiltViewModel
class SingLevelViewModel @Inject constructor(private val gameRepository: GameRepository): ViewModel() {

    private var _roundInfoLiveData: MutableLiveData<RoundInfo> = MutableLiveData()
    val roundInfoLiveData: LiveData<RoundInfo> = _roundInfoLiveData

    private var _roundMusicLiveData: MutableLiveData<RoundMusic> = MutableLiveData()
    val roundMusicLivedata: LiveData<RoundMusic> = _roundMusicLiveData

    fun getRoundMusic(idLvl: Int){
        viewModelScope.launch{
            _roundMusicLiveData.value = gameRepository.getMusicInfo(idLvl)
        }
    }


    fun getRoundInfo(idLvl: Int){
        viewModelScope.launch {
            _roundInfoLiveData.value = gameRepository.getRoundInfo(idLvl)
        }
    }

}