package com.example.soccerleauge.ui.fixture

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.soccerleauge.R
import com.example.soccerleauge.ui.viewmodel.FixtureViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FixtureFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fixture, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewmodel : FixtureViewModel by viewModels()
        viewmodel.getAllTeamNames()

        observeViewModel(viewmodel)



    }

    private fun observeViewModel(viewmodel: FixtureViewModel) {

        viewmodel.teamList.observe(viewLifecycleOwner, Observer{
            Log.d("FixtureTeams","Teams: ${it.toList()}")
        })

    }

}