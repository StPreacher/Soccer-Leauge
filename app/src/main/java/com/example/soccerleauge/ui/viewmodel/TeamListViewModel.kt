package com.example.soccerleauge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerleauge.model.TeamInfo
import com.example.soccerleauge.repo.TeamRepository
import com.example.soccerleauge.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamListViewModel @Inject constructor(private val repository: TeamRepository) : ViewModel() {

    val team = MutableLiveData<Resource<List<TeamInfo>>>()

    fun getTeamData(){
        viewModelScope.launch {
            team.postValue(Resource.loading())

            repository.getTeams().let {
                team.postValue(Resource.succes(it.data?.teams.orEmpty()))
            }
        }
    }

}