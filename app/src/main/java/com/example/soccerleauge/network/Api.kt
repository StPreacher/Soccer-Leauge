package com.example.soccerleauge.network

import com.example.soccerleauge.model.Teams
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("json/1/lookup_all_teams.php?id=4339")
    suspend fun getTeams() : Response<Teams>

}