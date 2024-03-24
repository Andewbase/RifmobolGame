package com.example.rifmobol2.data

import com.example.rifmobol2.R
import com.example.rifmobol2.data.entity.DialogText
import com.example.rifmobol2.data.entity.GameButton
import com.example.rifmobol2.data.entity.RoundInfo
import com.example.rifmobol2.data.entity.TextLevel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow

object InMemoryGameData {

    val singleLevels = flow {
        val listLevel = listOf(
            TextLevel(1),
            TextLevel(2),
            TextLevel(3),
            TextLevel(4),
            TextLevel(5),
            TextLevel(6),
            TextLevel(7),
            TextLevel(8),
            TextLevel(9),
            TextLevel(10),
            TextLevel(11),
            TextLevel(12),
            TextLevel(13),
            TextLevel(14),
            TextLevel(15),
            TextLevel(16),
            TextLevel(17),
            TextLevel(18),
            TextLevel(19),
            TextLevel(20),
            TextLevel(21),
            TextLevel(22),
            TextLevel(23),
            TextLevel(24),
            TextLevel(25),
            TextLevel(26),
            TextLevel(27),
            TextLevel(28),
            TextLevel(29),
            TextLevel(30),
            TextLevel(31),
            TextLevel(32),
            TextLevel(33),
            TextLevel(34),
            TextLevel(35)
        )
        emit(listLevel)
    }

    val singleRoundInfo = listOf(
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
        ),

        RoundInfo(
            id = 6,
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
            id = 7,
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
            id = 8,
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
            id = 9,
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
            id = 10,
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

        RoundInfo(
            id = 11,
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
            id = 12,
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
            id = 13,
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
            id = 14,
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
            id = 15,
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

        RoundInfo(
            id = 16,
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
            id = 17,
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
            id = 18,
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
            id = 19,
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
            id = 20,
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

        RoundInfo(
            id = 21,
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
            id = 22,
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
            id = 23,
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
            id = 24,
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
            id = 25,
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

        RoundInfo(
            id = 26,
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
            id = 27,
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
            id = 28,
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
            id = 29,
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
            id = 30,
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

        RoundInfo(
            id = 31,
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
            id = 32,
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
            id = 33,
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
            id = 34,
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
            id = 35,
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

    val singleTextDialogLose = listOf(
        DialogText(1, R.string.dialoglose1),
        DialogText(2, R.string.dialoglose2),
        DialogText(3, R.string.dialoglose3),
        DialogText(4, R.string.dialoglose4),
        DialogText(5, R.string.dialoglose5),
    ).asFlow()

    val singleTextDialogWin = listOf(
        DialogText(1, R.string.dialogwins1),
        DialogText(2, R.string.dialogwins2),
        DialogText(3, R.string.dialogwins3),
        DialogText(4, R.string.dialogwins4),
        DialogText(5, R.string.dialogwins5),
    ).asFlow()

}