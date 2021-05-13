package com.example.soccerleauge.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.soccerleauge.model.TeamResponse

@Dao
interface Dao {

    @Insert
    fun insertTeam(teamInfo : List<TeamResponse>)

    @Query("SELECT * FROM team_info")
    fun getAllTeams() : List<TeamResponse>


}