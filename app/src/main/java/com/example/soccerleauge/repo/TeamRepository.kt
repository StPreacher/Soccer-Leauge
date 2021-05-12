package com.example.soccerleauge.repo

import com.example.soccerleauge.BaseRepository
import com.example.soccerleauge.model.Teams
import com.example.soccerleauge.network.Api
import com.example.soccerleauge.util.Resource
import javax.inject.Inject

class TeamRepository @Inject constructor(private val api: Api) : BaseRepository(){

    suspend fun getTeams() : Resource<Teams>{
        return getResult {
            api.getTeams()
        }
    }

}