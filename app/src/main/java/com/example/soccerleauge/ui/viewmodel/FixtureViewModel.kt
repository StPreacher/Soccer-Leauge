package com.example.soccerleauge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerleauge.repo.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FixtureViewModel @Inject constructor(private val repository: TeamRepository) : ViewModel(){

    val teamList = MutableLiveData<List<String>>()

    fun getAllTeamNames(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.getTeamsFromLocal().let {
                    teamList.postValue(it)
            }

            }
        }
    }

}