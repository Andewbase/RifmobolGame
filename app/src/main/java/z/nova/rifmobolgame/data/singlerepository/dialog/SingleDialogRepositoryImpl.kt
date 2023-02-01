package z.nova.rifmobolgame.data.singlerepository.dialog

import z.nova.rifmobolgame.data.local.GameData.listTextDialogLose
import z.nova.rifmobolgame.data.local.GameData.listTextDialogWin
import z.nova.rifmobolgame.data.model.DialogText

class SingleDialogRepositoryImpl: SingleDialogRepo {

    override fun getTextDialogLose(): DialogText {
        val resultLoseRandom = listTextDialogLose.random()
        return DialogText(textDialog = resultLoseRandom)
    }

    override fun getTextDialogWin(): DialogText {
        val resulWinRandom = listTextDialogWin.random()
        return DialogText(textDialog = resulWinRandom)
    }


}