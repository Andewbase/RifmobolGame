package z.nova.rifmobolgame.data.multirepository

import z.nova.rifmobolgame.data.model.RoundInfo
import z.nova.rifmobolgame.data.model.multi.DialogMultiText
import z.nova.rifmobolgame.data.model.multi.RoundMultiMusic

interface GameRepoMulti {

    fun getMultiMusicRound(idLvl: Int): RoundMultiMusic

    fun getMultiRoundInfo(idLvl: Int, numberRound: Int): RoundInfo

    fun getMultiDialog(scoreP1: Int, scoreP2: Int): DialogMultiText
}