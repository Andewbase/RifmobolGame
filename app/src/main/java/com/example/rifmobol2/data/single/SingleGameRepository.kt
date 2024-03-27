package com.example.rifmobol2.data.single

import com.example.rifmobol2.data.single.SingleInMemoryGameData.singleLevels
import com.example.rifmobol2.data.single.SingleInMemoryGameData.roundInfo
import com.example.rifmobol2.data.single.SingleInMemoryGameData.singleTextDialogLose
import com.example.rifmobol2.data.single.SingleInMemoryGameData.singleTextDialogWin
import com.example.rifmobol2.data.single.entity.SingleDialogText
import com.example.rifmobol2.data.entity.RoundInfo
import com.example.rifmobol2.data.single.entity.TextLevel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

interface SingleGameRepository {

    fun getRoundInfo(id: Int): Flow<RoundInfo>

    fun getTextLevels(): Flow<List<TextLevel>>

    fun getTextDialog(answer: Boolean): Flow<SingleDialogText>

    @Singleton
    class Base @Inject constructor(): SingleGameRepository {
        override fun getRoundInfo(id: Int): Flow<RoundInfo> {
            return roundInfo.filter { roundInfo ->
                roundInfo.id == id
            }
        }

        override fun getTextLevels(): Flow<List<TextLevel>> {
            return singleLevels
        }

        override fun getTextDialog(answer: Boolean): Flow<SingleDialogText> {
            val id: Int = Random.nextInt(1,6)
            return if (answer){
                singleTextDialogWin.filter {
                    it.id == id
                }
            }else{
                singleTextDialogLose.filter {
                    it.id == id
                }
            }
        }

    }

}