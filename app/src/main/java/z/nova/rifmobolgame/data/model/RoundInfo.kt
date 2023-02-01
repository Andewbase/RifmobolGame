package z.nova.rifmobolgame.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RoundInfo(
    @StringRes val textLvl: Int,
    @DrawableRes val backgroundRound: Int,
    @StringRes val textCouplet: Int
)
