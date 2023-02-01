package z.nova.rifmobolgame.screen.singllist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import z.nova.rifmobolgame.data.GameRepository
import z.nova.rifmobolgame.data.model.TextLevel
import javax.inject.Inject

@HiltViewModel
class SingleListViewModel @Inject constructor(private val gameRepository: GameRepository): ViewModel() {

    private var _textLvlLiveData: MutableLiveData<List<TextLevel>> = MutableLiveData()
    val textLvlLiveData: LiveData<List<TextLevel>> = _textLvlLiveData

    init {
        getTextLvl()
    }

    private fun getTextLvl(){
        viewModelScope.launch {

            _textLvlLiveData.value = gameRepository.getListTextLvl()

        }
    }


}