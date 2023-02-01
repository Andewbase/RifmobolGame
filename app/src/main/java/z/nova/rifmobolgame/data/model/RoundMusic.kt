package z.nova.rifmobolgame.data.model

import androidx.annotation.DrawableRes

data class RoundMusic(
    @DrawableRes val backgroundButtonRightAnswer: Int,
    @DrawableRes val backgroundButtonAnswer: Int,
    val music1: Int,
    val music2: Int,
    val leftUpButton: OneButtonInfo,
    val rightUpButton: OneButtonInfo,
    val leftBottomButton: OneButtonInfo,
    val rightBottomButton: OneButtonInfo,
    var rightAnswer: Int? = null
){
    fun checkingTheResponse(){
        if (leftUpButton.isChecked){
            rightAnswer = 1
        }
        if (rightUpButton.isChecked){
            rightAnswer = 2
        }
        if (leftBottomButton.isChecked){
            rightAnswer = 3
        }
        if (rightBottomButton.isChecked){
            rightAnswer = 4
        }
    }

}