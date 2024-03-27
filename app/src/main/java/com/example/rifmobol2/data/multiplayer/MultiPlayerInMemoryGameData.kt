package com.example.rifmobol2.data.multiplayer

import com.example.rifmobol2.R
import com.example.rifmobol2.data.entity.GameButton
import com.example.rifmobol2.data.entity.RoundInfo
import kotlinx.coroutines.flow.asFlow

object MultiPlayerInMemoryGameData {

   private val multiPlayerRoundInfoOne = listOf(
        RoundInfo(
            id = 1,
            numberRound = R.string.level1,
            backgroundImage = R.drawable.level1_background,
            couplet = R.string.lvlcouplet1,
            upLeftButton = GameButton(
                name = R.string.lvl1textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl1texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl1textthree,
                isChecked = true
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl1textfour,
                isChecked = false
            ),
            musicOne = R.raw.watchman1,
            musicTwo = R.raw.watchman2
        ),

        RoundInfo(
            id = 2,
            numberRound = R.string.level2,
            backgroundImage = R.drawable.level2_background,
            couplet = R.string.lvlcouplet2,
            upLeftButton = GameButton(
                name = R.string.lvl2textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl2texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl2textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl2textfour,
                isChecked = true
            ),
            musicOne = R.raw.animals1,
            musicTwo = R.raw.animals2
        ),

        RoundInfo(
            id = 3,
            numberRound = R.string.level3,
            backgroundImage = R.drawable.level3_background,
            couplet = R.string.lvlcouplet3,
            upLeftButton = GameButton(
                name = R.string.lvl3textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl3texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl3textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl3textfour,
                isChecked = false
            ),
            musicOne = R.raw.animalstwo1,
            musicTwo = R.raw.animalstwo2
        ),

        RoundInfo(
            id = 4,
            numberRound = R.string.level4,
            backgroundImage = R.drawable.level4_background,
            couplet = R.string.lvlcouplet4,
            upLeftButton = GameButton(
                name = R.string.lvl4textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl4texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl4textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl4textfour,
                isChecked = false
            ),
            musicOne = R.raw.chaty1,
            musicTwo = R.raw.chaty2
        ),

        RoundInfo(
            id = 5,
            numberRound = R.string.level5,
            backgroundImage = R.drawable.level5_background,
            couplet = R.string.lvlcouplet5,
            upLeftButton = GameButton(
                name = R.string.lvl5textone,
                isChecked = true
            ),
            upRightButton = GameButton(
                name = R.string.lvl5texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl5textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl5textfour,
                isChecked = false
            ),
            musicOne = R.raw.cucumber1,
            musicTwo = R.raw.cucumber2
        )
    ).asFlow()

    private val multiPlayerRoundInfoTwo = listOf(
        RoundInfo(
            id = 1,
            numberRound = R.string.level6,
            backgroundImage = R.drawable.level6_background,
            couplet = R.string.lvlcouplet6,
            upLeftButton = GameButton(
                name = R.string.lvl6textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl6texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl6textthree,
                isChecked = true
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl6textfour,
                isChecked = false
            ),
            musicOne = R.raw.cute1,
            musicTwo = R.raw.cute2
        ),

        RoundInfo(
            id = 2,
            numberRound = R.string.level7,
            backgroundImage = R.drawable.level7_background,
            couplet = R.string.lvlcouplet7,
            upLeftButton = GameButton(
                name = R.string.lvl7textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl7texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl7textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl7textfour,
                isChecked = false
            ),
            musicOne = R.raw.dad1,
            musicTwo = R.raw.dad2
        ),

        RoundInfo(
            id = 3,
            numberRound = R.string.level8,
            backgroundImage = R.drawable.level8_background,
            couplet = R.string.lvlcouplet8,
            upLeftButton = GameButton(
                name = R.string.lvl8textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl8texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl8textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl8textfour,
                isChecked = false
            ),
            musicOne = R.raw.dead_end1,
            musicTwo = R.raw.dead_end2
        ),

        RoundInfo(
            id = 4,
            numberRound = R.string.level9,
            backgroundImage = R.drawable.level9_background,
            couplet = R.string.lvlcouplet9,
            upLeftButton = GameButton(
                name = R.string.lvl9textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl9texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl9textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl9textfour,
                isChecked = true
            ),
            musicOne = R.raw.disco1,
            musicTwo = R.raw.disco2
        ),

        RoundInfo(
            id = 5,
            numberRound = R.string.level10,
            backgroundImage = R.drawable.level10_background,
            couplet = R.string.lvlcouplet10,
            upLeftButton = GameButton(
                name = R.string.lvl10textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl10texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl10textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl10textfour,
                isChecked = true
            ),
            musicOne = R.raw.discotwo1,
            musicTwo = R.raw.discotwo2
        ),
    ).asFlow()

    private val multiPlayerRoundInfoThree = listOf(
        RoundInfo(
            id = 1,
            numberRound = R.string.level11,
            backgroundImage = R.drawable.level1_background,
            couplet = R.string.lvlcouplet11,
            upLeftButton = GameButton(
                name = R.string.lvl11textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl11texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl11textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl11textfour,
                isChecked = false
            ),
            musicOne = R.raw.dj1,
            musicTwo = R.raw.dj2
        ),

        RoundInfo(
            id = 2,
            numberRound = R.string.level12,
            backgroundImage = R.drawable.level2_background,
            couplet = R.string.lvlcouplet12,
            upLeftButton = GameButton(
                name = R.string.lvl12textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl12texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl12textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl12textfour,
                isChecked = true
            ),
            musicOne = R.raw.dress1,
            musicTwo = R.raw.dres2
        ),

        RoundInfo(
            id = 3,
            numberRound = R.string.level13,
            backgroundImage = R.drawable.level3_background,
            couplet = R.string.lvlcouplet13,
            upLeftButton = GameButton(
                name = R.string.lvl13textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl13texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl13textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl13textfour,
                isChecked = false
            ),
            musicOne = R.raw.funfurek1,
            musicTwo = R.raw.funfurek2
        ),

        RoundInfo(
            id = 4,
            numberRound = R.string.level14,
            backgroundImage = R.drawable.level4_background,
            couplet = R.string.lvlcouplet14,
            upLeftButton = GameButton(
                name = R.string.lvl14textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl14texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl14textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl14textfour,
                isChecked = false
            ),
            musicOne = R.raw.gamlet1,
            musicTwo = R.raw.gamlet2
        ),

        RoundInfo(
            id = 5,
            numberRound = R.string.level15,
            backgroundImage = R.drawable.level5_background,
            couplet = R.string.lvlcouplet15,
            upLeftButton = GameButton(
                name = R.string.lvl15textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl15texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl15textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl15textfour,
                isChecked = true
            ),
            musicOne = R.raw.grope1,
            musicTwo = R.raw.grope2
        ),
    ).asFlow()

    private val multiPlayerRoundInfoFour = listOf(
        RoundInfo(
            id = 1,
            numberRound = R.string.level16,
            backgroundImage = R.drawable.level6_background,
            couplet = R.string.lvlcouplet16,
            upLeftButton = GameButton(
                name = R.string.lvl16textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl16texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl16textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl16textfour,
                isChecked = true
            ),
            musicOne = R.raw.ilove1,
            musicTwo = R.raw.ilove2
        ),

        RoundInfo(
            id = 2,
            numberRound = R.string.level17,
            backgroundImage = R.drawable.level7_background,
            couplet = R.string.lvlcouplet17,
            upLeftButton = GameButton(
                name = R.string.lvl17textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl17texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl17textthree,
                isChecked = true
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl17textfour,
                isChecked = false
            ),
            musicOne = R.raw.iron1,
            musicTwo = R.raw.iron2
        ),

        RoundInfo(
            id = 3,
            numberRound = R.string.level18,
            backgroundImage = R.drawable.level8_background,
            couplet = R.string.lvlcouplet18,
            upLeftButton = GameButton(
                name = R.string.lvl18textone,
                isChecked = true
            ),
            upRightButton = GameButton(
                name = R.string.lvl18texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl18textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl18textfour,
                isChecked = false
            ),
            musicOne = R.raw.jam1,
            musicTwo = R.raw.jam2
        ),

        RoundInfo(
            id = 4,
            numberRound = R.string.level19,
            backgroundImage = R.drawable.level9_background,
            couplet = R.string.lvlcouplet19,
            upLeftButton = GameButton(
                name = R.string.lvl19textone,
                isChecked = true
            ),
            upRightButton = GameButton(
                name = R.string.lvl19texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl19textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl19textfour,
                isChecked = false
            ),
            musicOne = R.raw.jesby1,
            musicTwo = R.raw.jesby2
        ),

        RoundInfo(
            id = 5,
            numberRound = R.string.level20,
            backgroundImage = R.drawable.level10_background,
            couplet = R.string.lvlcouplet20,
            upLeftButton = GameButton(
                name = R.string.lvl20textone,
                isChecked = true
            ),
            upRightButton = GameButton(
                name = R.string.lvl20texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl20textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl20textfour,
                isChecked = false
            ),
            musicOne = R.raw.lilies1,
            musicTwo = R.raw.lilies2
        ),
    ).asFlow()

    private val multiPlayerRoundInfoFive = listOf(
        RoundInfo(
            id = 1,
            numberRound = R.string.level21,
            backgroundImage = R.drawable.level1_background,
            couplet = R.string.lvlcouplet21,
            upLeftButton = GameButton(
                name = R.string.lvl21textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl21texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl21textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl21textfour,
                isChecked = false
            ),
            musicOne = R.raw.mammoths1,
            musicTwo = R.raw.mammoths2
        ),

        RoundInfo(
            id = 2,
            numberRound = R.string.level22,
            backgroundImage = R.drawable.level2_background,
            couplet = R.string.lvlcouplet22,
            upLeftButton = GameButton(
                name = R.string.lvl22textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl22texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl22textthree,
                isChecked = true
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl22textfour,
                isChecked = false
            ),
            musicOne = R.raw.men1,
            musicTwo = R.raw.men2
        ),

        RoundInfo(
            id = 3,
            numberRound = R.string.level23,
            backgroundImage = R.drawable.level3_background,
            couplet = R.string.lvlcouplet23,
            upLeftButton = GameButton(
                name = R.string.lvl23textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl23texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl23textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl23textfour,
                isChecked = false
            ),
            musicOne = R.raw.mosquitoes1,
            musicTwo = R.raw.mosquitoes2
        ),

        RoundInfo(
            id = 4,
            numberRound = R.string.level24,
            backgroundImage = R.drawable.level4_background,
            couplet = R.string.lvlcouplet24,
            upLeftButton = GameButton(
                name = R.string.lvl24textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl24texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl24textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl24textfour,
                isChecked = false
            ),
            musicOne = R.raw.mustang1,
            musicTwo = R.raw.mustang2
        ),

        RoundInfo(
            id = 5,
            numberRound = R.string.level25,
            backgroundImage = R.drawable.level5_background,
            couplet = R.string.lvlcouplet25,
            upLeftButton = GameButton(
                name = R.string.lvl25textone,
                isChecked = true
            ),
            upRightButton = GameButton(
                name = R.string.lvl25texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl25textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl25textfour,
                isChecked = false
            ),
            musicOne = R.raw.olesia1,
            musicTwo = R.raw.olesia2
        ),
    ).asFlow()

    private val multiPlayerRoundInfoSix = listOf(
        RoundInfo(
            id = 1,
            numberRound = R.string.level26,
            backgroundImage = R.drawable.level6_background,
            couplet = R.string.lvlcouplet26,
            upLeftButton = GameButton(
                name = R.string.lvl26textone,
                isChecked = true
            ),
            upRightButton = GameButton(
                name = R.string.lvl26texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl26textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl26textfour,
                isChecked = false
            ),
            musicOne = R.raw.passive1,
            musicTwo = R.raw.passive2
        ),

        RoundInfo(
            id = 2,
            numberRound = R.string.level27,
            backgroundImage = R.drawable.level7_background,
            couplet = R.string.lvlcouplet27,
            upLeftButton = GameButton(
                name = R.string.lvl27textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl27texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl27textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl27textfour,
                isChecked = false
            ),
            musicOne = R.raw.pistol1,
            musicTwo = R.raw.pistol2
        ),

        RoundInfo(
            id = 3,
            numberRound = R.string.level28,
            backgroundImage = R.drawable.level8_background,
            couplet = R.string.lvlcouplet28,
            upLeftButton = GameButton(
                name = R.string.lvl28textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl28texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl28textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl28textfour,
                isChecked = true
            ),
            musicOne = R.raw.sparrow1,
            musicTwo = R.raw.sparrow2
        ),

        RoundInfo(
            id = 4,
            numberRound = R.string.level29,
            backgroundImage = R.drawable.level9_background,
            couplet = R.string.lvlcouplet29,
            upLeftButton = GameButton(
                name = R.string.lvl29textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl29texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl29textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl29textfour,
                isChecked = false
            ),
            musicOne = R.raw.tearing1,
            musicTwo = R.raw.tearing2
        ),

        RoundInfo(
            id = 5,
            numberRound = R.string.level30,
            backgroundImage = R.drawable.level10_background,
            couplet = R.string.lvlcouplet30,
            upLeftButton = GameButton(
                name = R.string.lvl30textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl30texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl30textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl30textfour,
                isChecked = false
            ),
            musicOne = R.raw.umbertrans1,
            musicTwo = R.raw.umbertrans2
        ),
    ).asFlow()

    private val multiPlayerRoundInfoSeven = listOf(
        RoundInfo(
            id = 1,
            numberRound = R.string.level31,
            backgroundImage = R.drawable.level1_background,
            couplet = R.string.lvlcouplet31,
            upLeftButton = GameButton(
                name = R.string.lvl31textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl31texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl31textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl31textfour,
                isChecked = false
            ),
            musicOne = R.raw.mexican1,
            musicTwo = R.raw.mexican2
        ),

        RoundInfo(
            id = 2,
            numberRound = R.string.level32,
            backgroundImage = R.drawable.level2_background,
            couplet = R.string.lvlcouplet32,
            upLeftButton = GameButton(
                name = R.string.lvl32textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl32texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl32textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl32textfour,
                isChecked = true
            ),
            musicOne = R.raw.mexicantwo1,
            musicTwo = R.raw.mexicantwo2
        ),

        RoundInfo(
            id = 3,
            numberRound = R.string.level33,
            backgroundImage = R.drawable.level3_background,
            couplet = R.string.lvlcouplet33,
            upLeftButton = GameButton(
                name = R.string.lvl33textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl33texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl33textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl33textfour,
                isChecked = false
            ),
            musicOne = R.raw.eggs1,
            musicTwo = R.raw.eggs2
        ),

        RoundInfo(
            id = 4,
            numberRound = R.string.level34,
            backgroundImage = R.drawable.level4_background,
            couplet = R.string.lvlcouplet34,
            upLeftButton = GameButton(
                name = R.string.lvl34textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl34texttwo,
                isChecked = true
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl34textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl34textfour,
                isChecked = false
            ),
            musicOne = R.raw.refrigerator1,
            musicTwo = R.raw.refrigerator1
        ),

        RoundInfo(
            id = 5,
            numberRound = R.string.level35,
            backgroundImage = R.drawable.level5_background,
            couplet = R.string.lvlcouplet35,
            upLeftButton = GameButton(
                name = R.string.lvl35textone,
                isChecked = false
            ),
            upRightButton = GameButton(
                name = R.string.lvl35texttwo,
                isChecked = false
            ),
            bottomLeftButton = GameButton(
                name = R.string.lvl35textthree,
                isChecked = false
            ),
            bottomRightButton = GameButton(
                name = R.string.lvl35textfour,
                isChecked = true
            ),
            musicOne = R.raw.goldrain1,
            musicTwo = R.raw.goldenrain2
        )
    ).asFlow()

    val listRoundInfo = listOf(
        multiPlayerRoundInfoOne,
        multiPlayerRoundInfoTwo,
        multiPlayerRoundInfoThree,
        multiPlayerRoundInfoFour,
        multiPlayerRoundInfoFive,
        multiPlayerRoundInfoSix,
        multiPlayerRoundInfoSeven,
    )

}