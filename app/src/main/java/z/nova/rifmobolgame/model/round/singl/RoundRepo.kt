package z.nova.rifmobolgame.model.round.singl

import z.nova.rifmobolgame.model.round.singl.RoundInfo

interface RoundRepo {

    fun  getRoundInf(): RoundInfo

}