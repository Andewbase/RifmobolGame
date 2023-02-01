package z.nova.rifmobolgame.screen.singlevel.dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import z.nova.rifmobolgame.data.GameRepository
import z.nova.rifmobolgame.data.model.DialogText
import javax.inject.Inject

@HiltViewModel
class DialogViewModel @Inject constructor(private val repository: GameRepository) : ViewModel() {

    private var _textDialogLoseLiveData: MutableLiveData<DialogText> = MutableLiveData()
    val textDialogLoseLiveData: LiveData<DialogText> = _textDialogLoseLiveData

    private var _textDialogWinLiveData: MutableLiveData<DialogText> = MutableLiveData()
    val textDialogWinLiveData: LiveData<DialogText> = _textDialogWinLiveData

    init {
        getDialogTextLose()
        getDialogTextWin()
    }

    private  fun getDialogTextLose(){
        viewModelScope.launch {
            _textDialogLoseLiveData.value = repository.getDialogLose()
        }
    }

    private  fun getDialogTextWin(){
        viewModelScope.launch {
            _textDialogWinLiveData.value = repository.getDialogWin()
        }
    }

}