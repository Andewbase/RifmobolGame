package z.nova.rifmobolgame.data

import z.nova.rifmobolgame.data.model.DialogText
import z.nova.rifmobolgame.data.model.RoundInfo
import z.nova.rifmobolgame.data.model.RoundMusic
import z.nova.rifmobolgame.data.model.TextLevel
import z.nova.rifmobolgame.data.model.multi.DialogMultiText
import z.nova.rifmobolgame.data.model.multi.RoundMultiMusic
import z.nova.rifmobolgame.data.multirepository.GameRepoMulti
import z.nova.rifmobolgame.data.singlerepository.GameRepo
import z.nova.rifmobolgame.data.singlerepository.dialog.SingleDialogRepo
import javax.inject.Inject

class GameRepository @Inject constructor (private val gameRepo: GameRepo, private val gameRepoMulti: GameRepoMulti, private val singleDialogRepo: SingleDialogRepo) {

    fun getListTextLvl() : List<TextLevel> = gameRepo.getTextLvlInfo()

    fun getMusicInfo(id: Int): RoundMusic = gameRepo.getMusicRound(id)

    fun getRoundInfo(id: Int): RoundInfo = gameRepo.getRoundInfo(id)

    fun getMultiMusicInfo(id: Int): RoundMultiMusic = gameRepoMulti.getMultiMusicRound(id)

    fun getMultiRoundInfo(id: Int, numberRound: Int): RoundInfo = gameRepoMulti.getMultiRoundInfo(id, numberRound)

    fun getDialogLose(): DialogText = singleDialogRepo.getTextDialogLose()

    fun getDialogWin(): DialogText = singleDialogRepo.getTextDialogWin()

    fun getMultiDialog(scoreP1: Int, scoreP2: Int): DialogMultiText = gameRepoMulti.getMultiDialog(scoreP1, scoreP2)

}