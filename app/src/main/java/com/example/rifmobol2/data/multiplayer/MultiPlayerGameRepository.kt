package com.example.rifmobol2.data.multiplayer

import com.example.rifmobol2.data.multiplayer.MultiPlayerInMemoryGameData.listRoundInfo
import com.example.rifmobol2.data.entity.RoundInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import javax.inject.Inject
import javax.inject.Singleton

interface MultiPlayerGameRepository {

    fun getRoundInfo(id: Int): Flow<RoundInfo>

    @Singleton
    class Base @Inject constructor(): MultiPlayerGameRepository{
        override fun getRoundInfo(id: Int): Flow<RoundInfo> {
            val roundInfo = listRoundInfo.random()

            return roundInfo.filter { roundInfo ->
                roundInfo.id == id
            }
        }

    }

}