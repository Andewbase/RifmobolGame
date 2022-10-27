package z.nova.rifmobolgame.model.round

class GetRoundInfo(val roundRepo: RoundRepo) {
    fun execut(): RoundInfo{
        return roundRepo.getRoundInf()
    }
}