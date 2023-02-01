package z.nova.rifmobolgame.screen.multilevl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import z.nova.rifmobolgame.data.GameRepository
import z.nova.rifmobolgame.data.model.RoundInfo
import z.nova.rifmobolgame.data.model.multi.RoundMultiMusic
import javax.inject.Inject

@HiltViewModel
class MultiLevelViewModel @Inject constructor(private val gameRepository: GameRepository): ViewModel() {


    private var _roundInfoLiveData: MutableLiveData<RoundInfo> = MutableLiveData()
    val roundInfoLiveData: LiveData<RoundInfo> = _roundInfoLiveData

    private var _roundMusicLiveData: MutableLiveData<RoundMultiMusic> = MutableLiveData()
    val roundMusicLivedata: LiveData<RoundMultiMusic> = _roundMusicLiveData

    private var _scoreP1: MutableLiveData<Int> = MutableLiveData()
    val scoreP1: LiveData<Int> = _scoreP1

    private var _scoreP2: MutableLiveData<Int> = MutableLiveData()
    val scoreP2: LiveData<Int> = _scoreP2

    fun getScore(scoreP1: Int, scoreP2: Int){
        _scoreP1.value = scoreP1
        _scoreP2.value = scoreP2
    }

    fun getRoundMusic(idLvl: Int){
        viewModelScope.launch{
            _roundMusicLiveData.value = gameRepository.getMultiMusicInfo(idLvl)
        }
    }


    fun getRoundInfo(idLvl: Int, numberRound: Int){
        viewModelScope.launch {
            _roundInfoLiveData.value = gameRepository.getMultiRoundInfo(idLvl, numberRound)
        }
    }


}