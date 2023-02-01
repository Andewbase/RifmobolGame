package z.nova.rifmobolgame.screen.multilevl.dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import z.nova.rifmobolgame.data.GameRepository
import z.nova.rifmobolgame.data.model.multi.DialogMultiText
import javax.inject.Inject

@HiltViewModel
class DialogMultiViewModel @Inject constructor(private val gameRepository: GameRepository): ViewModel() {

    private var _multiDialogTextLiveData: MutableLiveData<DialogMultiText> = MutableLiveData()
    val multiDialogTextLiveData: LiveData<DialogMultiText> = _multiDialogTextLiveData

    fun getMultiDialogText(scoreP1: Int, scoreP2: Int){
        viewModelScope.launch {
            _multiDialogTextLiveData.value = gameRepository.getMultiDialog(scoreP1, scoreP2)
        }
    }
}