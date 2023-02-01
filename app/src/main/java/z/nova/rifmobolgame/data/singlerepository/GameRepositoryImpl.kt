package z.nova.rifmobolgame.data.singlerepository

import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.data.local.GameData.leftBottomButtonList
import z.nova.rifmobolgame.data.local.GameData.leftUpButtonList
import z.nova.rifmobolgame.data.local.GameData.listBackground
import z.nova.rifmobolgame.data.local.GameData.listBackgroundButtonAnswer
import z.nova.rifmobolgame.data.local.GameData.listBackgroundButtonRightAnswer
import z.nova.rifmobolgame.data.local.GameData.listListTextLevel
import z.nova.rifmobolgame.data.local.GameData.listTextLevel
import z.nova.rifmobolgame.data.local.GameData.listCouplet
import z.nova.rifmobolgame.data.local.GameData.listMusic1
import z.nova.rifmobolgame.data.local.GameData.listMusic2
import z.nova.rifmobolgame.data.local.GameData.rightBottomButtonList
import z.nova.rifmobolgame.data.local.GameData.rightUpButtonList
import z.nova.rifmobolgame.data.model.OneButtonInfo
import z.nova.rifmobolgame.data.model.RoundInfo
import z.nova.rifmobolgame.data.model.RoundMusic

@Suppress("IMPLICIT_CAST_TO_ANY")
class GameRepositoryImpl: GameRepo {

    override fun getTextLvlInfo() = listListTextLevel

    override fun getMusicRound(idLvl: Int): RoundMusic {

        val resulMusic1 = when(idLvl){
            1 -> listMusic1[0]
            2 -> listMusic1[1]
            3 -> listMusic1[2]
            4 -> listMusic1[3]
            5 -> listMusic1[4]
            6 -> listMusic1[5]
            7 -> listMusic1[6]
            8 -> listMusic1[7]
            9 -> listMusic1[8]
            10 -> listMusic1[9]
            11 -> listMusic1[10]
            12 -> listMusic1[11]
            13 -> listMusic1[12]
            14 -> listMusic1[13]
            15 -> listMusic1[14]
            16 -> listMusic1[15]
            17 -> listMusic1[16]
            18 -> listMusic1[17]
            19 -> listMusic1[18]
            20 -> listMusic1[19]
            21 -> listMusic1[20]
            22 -> listMusic1[21]
            23 -> listMusic1[22]
            24 -> listMusic1[23]
            25 -> listMusic1[24]
            26 -> listMusic1[25]
            27 -> listMusic1[26]
            28 -> listMusic1[27]
            29 -> listMusic1[28]
            30 -> listMusic1[29]
            31 -> listMusic1[30]
            32 -> listMusic1[31]
            33 -> listMusic1[32]
            34 -> listMusic1[33]
            35 -> listMusic1[34]
            else -> R.raw.eggs1
        }

        val resulMusic2 = when(idLvl){
            1 -> listMusic2[0]
            2 -> listMusic2[1]
            3 -> listMusic2[2]
            4 -> listMusic2[3]
            5 -> listMusic2[4]
            6 -> listMusic2[5]
            7 -> listMusic2[6]
            8 -> listMusic2[7]
            9 -> listMusic2[8]
            10 -> listMusic2[9]
            11 -> listMusic2[10]
            12 -> listMusic2[11]
            13 -> listMusic2[12]
            14 -> listMusic2[13]
            15 -> listMusic2[14]
            16 -> listMusic2[15]
            17 -> listMusic2[16]
            18 -> listMusic2[17]
            19 -> listMusic2[18]
            20 -> listMusic2[19]
            21 -> listMusic2[20]
            22 -> listMusic2[21]
            23 -> listMusic2[22]
            24 -> listMusic2[23]
            25 -> listMusic2[24]
            26 -> listMusic2[25]
            27 -> listMusic2[26]
            28 -> listMusic2[27]
            29 -> listMusic2[28]
            30 -> listMusic2[29]
            31 -> listMusic2[30]
            32 -> listMusic2[31]
            33 -> listMusic2[32]
            34 -> listMusic2[33]
            35 -> listMusic2[34]
            else -> R.raw.eggs2
        }

        val resultLeftUpButton = when(idLvl){
            1 -> leftUpButtonList[0]
            2 -> leftUpButtonList[1]
            3 -> leftUpButtonList[2]
            4 -> leftUpButtonList[3]
            5 -> leftUpButtonList[4]
            6 -> leftUpButtonList[5]
            7 -> leftUpButtonList[6]
            8 -> leftUpButtonList[7]
            9 -> leftUpButtonList[8]
            10 -> leftUpButtonList[9]
            11 -> leftUpButtonList[10]
            12 -> leftUpButtonList[11]
            13 -> leftUpButtonList[12]
            14 -> leftUpButtonList[13]
            15 -> leftUpButtonList[14]
            16 -> leftUpButtonList[15]
            17 -> leftUpButtonList[16]
            18 -> leftUpButtonList[17]
            19 -> leftUpButtonList[18]
            20 -> leftUpButtonList[19]
            21 -> leftUpButtonList[20]
            22 -> leftUpButtonList[21]
            23 -> leftUpButtonList[22]
            24 -> leftUpButtonList[23]
            25 -> leftUpButtonList[24]
            26 -> leftUpButtonList[25]
            27 -> leftUpButtonList[26]
            28 -> leftUpButtonList[27]
            29 -> leftUpButtonList[28]
            30 -> leftUpButtonList[29]
            31 -> leftUpButtonList[30]
            32 -> leftUpButtonList[31]
            33 -> leftUpButtonList[32]
            34 -> leftUpButtonList[33]
            35 -> leftUpButtonList[34]
            else -> R.string.eror
        }

        val resultRightUpButton = when(idLvl){
            1 -> rightUpButtonList[0]
            2 -> rightUpButtonList[1]
            3 -> rightUpButtonList[2]
            4 -> rightUpButtonList[3]
            5 -> rightUpButtonList[4]
            6 -> rightUpButtonList[5]
            7 -> rightUpButtonList[6]
            8 -> rightUpButtonList[7]
            9 -> rightUpButtonList[8]
            10 -> rightUpButtonList[9]
            11 -> rightUpButtonList[10]
            12 -> rightUpButtonList[11]
            13 -> rightUpButtonList[12]
            14 -> rightUpButtonList[13]
            15 -> rightUpButtonList[14]
            16 -> rightUpButtonList[15]
            17 -> rightUpButtonList[16]
            18 -> rightUpButtonList[17]
            19 -> rightUpButtonList[18]
            20 -> rightUpButtonList[19]
            21 -> rightUpButtonList[20]
            22 -> rightUpButtonList[21]
            23 -> rightUpButtonList[22]
            24 -> rightUpButtonList[23]
            25 -> rightUpButtonList[24]
            26 -> rightUpButtonList[25]
            27 -> rightUpButtonList[26]
            28 -> rightUpButtonList[27]
            29 -> rightUpButtonList[28]
            30 -> rightUpButtonList[29]
            31 -> rightUpButtonList[30]
            32 -> rightUpButtonList[31]
            33 -> rightUpButtonList[32]
            34 -> rightUpButtonList[33]
            35 -> rightUpButtonList[34]
            else -> R.string.eror
        }

        val resultLeftBottomButton = when(idLvl){
            1 -> leftBottomButtonList[0]
            2 -> leftBottomButtonList[1]
            3 -> leftBottomButtonList[2]
            4 -> leftBottomButtonList[3]
            5 -> leftBottomButtonList[4]
            6 -> leftBottomButtonList[5]
            7 -> leftBottomButtonList[6]
            8 -> leftBottomButtonList[7]
            9 -> leftBottomButtonList[8]
            10 -> leftBottomButtonList[9]
            11 -> leftBottomButtonList[10]
            12 -> leftBottomButtonList[11]
            13 -> leftBottomButtonList[12]
            14 -> leftBottomButtonList[13]
            15 -> leftBottomButtonList[14]
            16 -> leftBottomButtonList[15]
            17 -> leftBottomButtonList[16]
            18 -> leftBottomButtonList[17]
            19 -> leftBottomButtonList[18]
            20 -> leftBottomButtonList[19]
            21 -> leftBottomButtonList[20]
            22 -> leftBottomButtonList[21]
            23 -> leftBottomButtonList[22]
            24 -> leftBottomButtonList[23]
            25 -> leftBottomButtonList[24]
            26 -> leftBottomButtonList[25]
            27 -> leftBottomButtonList[26]
            28 -> leftBottomButtonList[27]
            29 -> leftBottomButtonList[28]
            30 -> leftBottomButtonList[29]
            31 -> leftBottomButtonList[30]
            32 -> leftBottomButtonList[31]
            33 -> leftBottomButtonList[32]
            34 -> leftBottomButtonList[33]
            35 -> leftBottomButtonList[34]
            else -> R.string.eror
        }

        val resultRightBottomButton = when(idLvl){
            1 -> rightBottomButtonList[0]
            2 -> rightBottomButtonList[1]
            3 -> rightBottomButtonList[2]
            4 -> rightBottomButtonList[3]
            5 -> rightBottomButtonList[4]
            6 -> rightBottomButtonList[5]
            7 -> rightBottomButtonList[6]
            8 -> rightBottomButtonList[7]
            9 -> rightBottomButtonList[8]
            10 -> rightBottomButtonList[9]
            11 -> rightBottomButtonList[10]
            12 -> rightBottomButtonList[11]
            13 -> rightBottomButtonList[12]
            14 -> rightBottomButtonList[13]
            15 -> rightBottomButtonList[14]
            16 -> rightBottomButtonList[15]
            17 -> rightBottomButtonList[16]
            18 -> rightBottomButtonList[17]
            19 -> rightBottomButtonList[18]
            20 -> rightBottomButtonList[19]
            21 -> rightBottomButtonList[20]
            22 -> rightBottomButtonList[21]
            23 -> rightBottomButtonList[22]
            24 -> rightBottomButtonList[23]
            25 -> rightBottomButtonList[24]
            26 -> rightBottomButtonList[25]
            27 -> rightBottomButtonList[26]
            28 -> rightBottomButtonList[27]
            29 -> rightBottomButtonList[28]
            30 -> rightBottomButtonList[29]
            31 -> rightBottomButtonList[30]
            32 -> rightBottomButtonList[31]
            33 -> rightBottomButtonList[32]
            34 -> rightBottomButtonList[33]
            35 -> rightBottomButtonList[34]
            else -> R.string.eror
        }

        val resultBackgroundButtonRightAnswer = listBackgroundButtonRightAnswer
        val resultBackgroundButtonAnswer = listBackgroundButtonAnswer

        return RoundMusic(
            backgroundButtonAnswer = resultBackgroundButtonAnswer,
            backgroundButtonRightAnswer = resultBackgroundButtonRightAnswer,
            music1 = resulMusic1,
            music2 = resulMusic2,
            leftUpButton = resultLeftUpButton as OneButtonInfo,
            rightUpButton = resultRightUpButton as OneButtonInfo,
            leftBottomButton = resultLeftBottomButton as OneButtonInfo,
            rightBottomButton = resultRightBottomButton as OneButtonInfo
        )
    }

    override fun getRoundInfo(idLvl: Int): RoundInfo {

        val resultTextLvl = when(idLvl){
            1 -> listTextLevel[0]
            2 -> listTextLevel[1]
            3 -> listTextLevel[2]
            4 -> listTextLevel[3]
            5 -> listTextLevel[4]
            6 -> listTextLevel[5]
            7 -> listTextLevel[6]
            8 -> listTextLevel[7]
            9 -> listTextLevel[8]
            10 -> listTextLevel[9]
            11 -> listTextLevel[10]
            12 -> listTextLevel[11]
            13 -> listTextLevel[12]
            14 -> listTextLevel[13]
            15 -> listTextLevel[14]
            16 -> listTextLevel[15]
            17 -> listTextLevel[16]
            18 -> listTextLevel[17]
            19 -> listTextLevel[18]
            20 -> listTextLevel[19]
            21 -> listTextLevel[20]
            22 -> listTextLevel[21]
            23 -> listTextLevel[22]
            24 -> listTextLevel[23]
            25 -> listTextLevel[24]
            26 -> listTextLevel[25]
            27 -> listTextLevel[26]
            28 -> listTextLevel[27]
            29 -> listTextLevel[28]
            30 -> listTextLevel[29]
            31 -> listTextLevel[30]
            32 -> listTextLevel[31]
            33 -> listTextLevel[32]
            34 -> listTextLevel[33]
            35 -> listTextLevel[34]
            else -> R.string.eror
        }

        val resultBackgroundLvl = when(idLvl){
            1 -> listBackground[0]
            2 -> listBackground[1]
            3 -> listBackground[2]
            4 -> listBackground[3]
            5 -> listBackground[4]
            6 -> listBackground[5]
            7 -> listBackground[6]
            8 -> listBackground[7]
            9 -> listBackground[8]
            10 -> listBackground[9]
            11 -> listBackground[0]
            12 -> listBackground[1]
            13 -> listBackground[2]
            14 -> listBackground[3]
            15 -> listBackground[4]
            16 -> listBackground[5]
            17 -> listBackground[6]
            18 -> listBackground[7]
            19 -> listBackground[8]
            20 -> listBackground[9]
            21 -> listBackground[0]
            22 -> listBackground[1]
            23 -> listBackground[2]
            24 -> listBackground[3]
            25 -> listBackground[4]
            26 -> listBackground[5]
            27 -> listBackground[6]
            28 -> listBackground[7]
            29 -> listBackground[8]
            30 -> listBackground[9]
            31 -> listBackground[0]
            32 -> listBackground[1]
            33 -> listBackground[2]
            34 -> listBackground[3]
            35 -> listBackground[4]
            else -> listBackground[0]
        }

        val resultCouplet = when(idLvl){
            1 -> listCouplet [0]
            2 -> listCouplet[1]
            3 -> listCouplet[2]
            4 -> listCouplet[3]
            5 -> listCouplet[4]
            6 -> listCouplet[5]
            7 -> listCouplet[6]
            8 -> listCouplet[7]
            9 -> listCouplet[8]
            10 -> listCouplet[9]
            11 -> listCouplet[10]
            12 -> listCouplet[11]
            13 -> listCouplet[12]
            14 -> listCouplet[13]
            15 -> listCouplet[14]
            16 -> listCouplet[15]
            17 -> listCouplet[16]
            18 -> listCouplet[17]
            19 -> listCouplet[18]
            20 -> listCouplet[19]
            21 -> listCouplet[20]
            22 -> listCouplet[21]
            23 -> listCouplet[22]
            24 -> listCouplet[23]
            25 -> listCouplet[24]
            26 -> listCouplet[25]
            27 -> listCouplet[26]
            28 -> listCouplet[27]
            29 -> listCouplet[28]
            30 -> listCouplet[29]
            31 -> listCouplet[30]
            32 -> listCouplet[31]
            33 -> listCouplet[32]
            34 -> listCouplet[33]
            35 -> listCouplet[34]
            else -> R.string.eror
        }

        return RoundInfo(textLvl = resultTextLvl, backgroundRound = resultBackgroundLvl, textCouplet  = resultCouplet)
    }

}