package com.example.soccerleauge.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.soccerleauge.model.Teams

@Dao
interface Dao {

    @Insert
    fun insertTeam(teams: Teams)

    @Query("SELECT * FROM teams")
    fun getAllTeams() : Teams


}