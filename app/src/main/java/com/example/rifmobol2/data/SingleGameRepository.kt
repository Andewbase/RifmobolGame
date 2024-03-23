package com.example.rifmobol2.data

import com.example.rifmobol2.data.InMemoryGameData.singleLevels
import com.example.rifmobol2.data.InMemoryGameData.singleRoundInfo
import com.example.rifmobol2.data.entity.RoundInfo
import com.example.rifmobol2.data.entity.TextLevel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import javax.inject.Inject
import javax.inject.Singleton

interface SingleGameRepository {

    fun getRoundInfo(id: Int): Flow<RoundInfo>

    fun getTextLevels(): Flow<List<TextLevel>>

    @Singleton
    class Base @Inject constructor(): SingleGameRepository{
        override fun getRoundInfo(id: Int): Flow<RoundInfo> {
            return singleRoundInfo.filter { roundInfo ->
                roundInfo.id == id
            }
        }

        override fun getTextLevels(): Flow<List<TextLevel>> {
            return singleLevels
        }

    }

}