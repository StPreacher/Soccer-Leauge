package com.example.soccerleauge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerleauge.db.Database
import com.example.soccerleauge.model.TeamResponse
import com.example.soccerleauge.repo.TeamRepository
import com.example.soccerleauge.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamListViewModel @Inject constructor(private val repository: TeamRepository) : ViewModel() {


    val team = MutableLiveData<Resource<List<TeamResponse>>>()

    fun getTeamData(database: Database) {
        viewModelScope.launch {
            team.postValue(Resource.loading())

            repository.getTeams().let {
                team.postValue(Resource.succes(it.data?.teams.orEmpty()))
                if(database.dao().getAllTeams().isEmpty()) {
                    database.dao().insertTeam(it.data!!.teams)
                }

            }
        }
    }

}