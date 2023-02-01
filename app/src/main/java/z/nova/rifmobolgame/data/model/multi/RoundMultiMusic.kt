package z.nova.rifmobolgame.data.model.multi

import androidx.annotation.DrawableRes
import z.nova.rifmobolgame.data.model.OneButtonInfo

data class RoundMultiMusic(
    @DrawableRes val backgroundButtonRightAnswer: Int,
    val music1: Int,
    val music2: Int,
    val p1leftUpButton: OneButtonInfo,
    val p1rightUpButton: OneButtonInfo,
    val p1leftBottomButton: OneButtonInfo,
    val p1rightBottomButton: OneButtonInfo,
    val p2leftUpButton: OneButtonInfo,
    val p2rightUpButton: OneButtonInfo,
    val p2leftBottomButton: OneButtonInfo,
    val p2rightBottomButton: OneButtonInfo,
    var p1rightAnswer: Int? = null,
    var p2rightAnswer: Int? = null
){
    fun checkingMultiTheResponse(){
        if (p1leftUpButton.isChecked){
            p1rightAnswer = 1
        }
        if (p1rightUpButton.isChecked){
            p1rightAnswer = 2
        }
        if (p1leftBottomButton.isChecked){
            p1rightAnswer = 3
        }
        if (p1rightBottomButton.isChecked){
            p1rightAnswer = 4
        }
        if (p2leftUpButton.isChecked){
            p2rightAnswer = 1
        }
        if (p2rightUpButton.isChecked){
            p2rightAnswer = 2
        }
        if (p2leftBottomButton.isChecked){
            p2rightAnswer = 3
        }
        if (p2rightBottomButton.isChecked){
            p2rightAnswer = 4
        }

    }
}
