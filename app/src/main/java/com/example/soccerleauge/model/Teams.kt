package com.example.soccerleauge.model

import java.io.Serializable

data class Teams(
    val teams : List<TeamInfo>
)

data class TeamInfo(
    val strTeam : String? = null,
    val strTeamBadge : String? = null
) : Serializable
