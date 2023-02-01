package z.nova.rifmobolgame.data.singlerepository

import z.nova.rifmobolgame.data.model.RoundInfo
import z.nova.rifmobolgame.data.model.RoundMusic
import z.nova.rifmobolgame.data.model.TextLevel

interface GameRepo {
    fun getTextLvlInfo(): List<TextLevel>

    fun getMusicRound(idLvl: Int): RoundMusic

    fun getRoundInfo(idLvl: Int): RoundInfo

}