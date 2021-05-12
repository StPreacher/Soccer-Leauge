package com.example.soccerleauge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.soccerleauge.R
import com.example.soccerleauge.ui.viewmodel.TeamListViewModel
import com.example.soccerleauge.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewmodel : TeamListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel.getTeamData()

        viewmodel.team.observe(this, Observer {
            when(it.status){

                Status.LOADING -> {
                    Log.e("PictureData","Loading")
                }

                Status.SUCCESS -> {
                    Log.e("PictureData","Success")
                    Log.e("PictureData", it.data.toString())
                }

                Status.ERROR -> {
                    Log.e("PictureData","Error")
                }

            }
        })

    }
}