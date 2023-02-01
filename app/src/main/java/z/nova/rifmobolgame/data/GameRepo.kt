package z.nova.rifmobolgame.data

import z.nova.rifmobolgame.data.model.DialogText
import z.nova.rifmobolgame.data.model.RoundInfo
import z.nova.rifmobolgame.data.model.RoundMusic
import z.nova.rifmobolgame.data.model.TextLevel
import z.nova.rifmobolgame.data.model.multi.DialogMultiText
import z.nova.rifmobolgame.data.model.multi.RoundMultiMusic

interface GameRepo {

    fun getTextLvlInfo(): List<TextLevel>

    fun getMusicRound(idLvl: Int): RoundMusic

    fun getMultiMusicRound(idLvl: Int): RoundMultiMusic

    fun getRoundInfo(idLvl: Int): RoundInfo

    fun getMultiRoundInfo(idLvl: Int, numberRound: Int): RoundInfo

    fun getTextDialogLose(): DialogText

    fun getTextDialogWin(): DialogText

    fun getMultiDialog(scoreP1: Int, scoreP2: Int): DialogMultiText
}