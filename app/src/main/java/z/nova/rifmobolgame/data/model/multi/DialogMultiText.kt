package z.nova.rifmobolgame.data.model.multi

import androidx.annotation.ColorRes
import androidx.annotation.StringRes

data class DialogMultiText(
    @StringRes val textDialog: Int,
    @ColorRes val colorText: Int,
    val scoreP1: Int,
    val scoreP2: Int
)
