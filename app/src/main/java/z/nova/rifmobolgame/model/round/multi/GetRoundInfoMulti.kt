package z.nova.rifmobolgame.model.round.multi


class GetRoundInfoMulti(val roundRepoMulti: RoundRepoMulti) {

    fun execut(): RoundInfoMulti {
        return roundRepoMulti.getRoundInfMulti()
    }

}