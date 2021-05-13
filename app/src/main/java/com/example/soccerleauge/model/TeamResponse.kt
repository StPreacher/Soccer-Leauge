package com.example.soccerleauge.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "team_info")
data class TeamResponse(
    @ColumnInfo(name = "team_name")
    val strTeam : String? = null,
    @ColumnInfo(name = "team_image")
    val strTeamBadge : String? = null,
    @PrimaryKey(autoGenerate = true)
    var primaryKey : Int
) : Serializable
