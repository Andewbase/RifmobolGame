package z.nova.rifmobolgame.data.singlerepository.dialog

import z.nova.rifmobolgame.data.model.DialogText

interface SingleDialogRepo {

    fun getTextDialogLose(): DialogText

    fun getTextDialogWin(): DialogText

}