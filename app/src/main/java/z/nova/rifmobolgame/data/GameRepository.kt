package z.nova.rifmobolgame.data

import z.nova.rifmobolgame.data.model.DialogText
import z.nova.rifmobolgame.data.model.RoundInfo
import z.nova.rifmobolgame.data.model.RoundMusic
import z.nova.rifmobolgame.data.model.TextLevel
import z.nova.rifmobolgame.data.model.multi.DialogMultiText
import z.nova.rifmobolgame.data.model.multi.RoundMultiMusic
import javax.inject.Inject

class GameRepository @Inject constructor (private val gameRepo: GameRepo) {

    fun getListTextLvl() : List<TextLevel> = gameRepo.getTextLvlInfo()

    fun getMusicInfo(id: Int): RoundMusic = gameRepo.getMusicRound(id)

    fun getRoundInfo(id: Int): RoundInfo = gameRepo.getRoundInfo(id)

    fun getMultiMusicInfo(id: Int): RoundMultiMusic = gameRepo.getMultiMusicRound(id)

    fun getMultiRoundInfo(id: Int, numberRound: Int): RoundInfo = gameRepo.getMultiRoundInfo(id, numberRound)

    fun getDialogLose(): DialogText = gameRepo.getTextDialogLose()

    fun getDialogWin(): DialogText = gameRepo.getTextDialogWin()

    fun getMultiDialog(scoreP1: Int, scoreP2: Int): DialogMultiText = gameRepo.getMultiDialog(scoreP1, scoreP2)

}