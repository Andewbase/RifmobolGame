package z.nova.rifmobolgame.model.round.singl

class GetRoundInfo(val roundRepo: RoundRepo) {
    fun execut(): RoundInfo {
        return roundRepo.getRoundInf()
    }
}