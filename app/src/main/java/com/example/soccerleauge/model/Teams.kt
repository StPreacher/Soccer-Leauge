package com.example.soccerleauge.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.io.Serializable

@Entity(tableName = "teams")
data class Teams(
    @ColumnInfo(name = "teams_column")
    val teams : List<TeamInfo>
)

data class TeamInfo(
    val strTeam : String? = null,
    val strTeamBadge : String? = null
) : Serializable
