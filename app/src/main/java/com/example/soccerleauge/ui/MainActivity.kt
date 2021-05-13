package com.example.soccerleauge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.soccerleauge.R
import com.example.soccerleauge.ui.viewmodel.TeamListViewModel
import com.example.soccerleauge.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        navController = Navigation.findNavController(this,R.id.fragment)
//        NavigationUI.setupActionBarWithNavController(this,navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(navController,null)
//    }


}