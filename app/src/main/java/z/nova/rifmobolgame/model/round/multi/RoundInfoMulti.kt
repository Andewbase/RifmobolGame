package z.nova.rifmobolgame.model.round.multi

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RoundInfoMulti (
    @StringRes val textRoundMulti: Int,
    @DrawableRes val backgroundRound: Int,
    @StringRes val textCouplet: Int,
    @StringRes val nameBtnone: Int,
    @StringRes val nameBtntwo: Int,
    @StringRes val nameBtnthree: Int,
    @StringRes val nameBtnfour: Int,
    @StringRes val textDialogWin: Int,
    @StringRes val textDialogLose: Int,
    val music1: Int,
    val music2: Int
        )