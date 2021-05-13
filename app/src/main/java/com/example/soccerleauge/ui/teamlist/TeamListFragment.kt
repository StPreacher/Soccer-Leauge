package com.example.soccerleauge.ui.teamlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.soccerleauge.R
import com.example.soccerleauge.db.Database
import com.example.soccerleauge.ui.viewmodel.TeamListViewModel
import com.example.soccerleauge.util.Status
import com.example.soccerleauge.util.hide
import com.example.soccerleauge.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_team_list.*

@AndroidEntryPoint
class TeamListFragment : Fragment() {

    private val teamListAdapter = TeamListAdapter(arrayListOf())
    private lateinit var database : Database

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewmodel : TeamListViewModel by viewModels()
        database =  Room.databaseBuilder(view.context,Database::class.java,"team_info")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        viewmodel.getTeamData(database)

        teamListView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = teamListAdapter
            hasFixedSize()
            layoutManager = GridLayoutManager(view.context,2)
        }

        observeViewModel(viewmodel)

    }

    private fun observeViewModel(viewmodel: TeamListViewModel) {
        viewmodel.team.observe(viewLifecycleOwner, Observer {
            when(it.status){

                Status.LOADING -> progressBar.show()

                Status.SUCCESS -> {
                    progressBar.hide()
                    teamListAdapter.teamList = it.data!!
                    teamListAdapter.notifyDataSetChanged()
                }

                Status.ERROR -> progressBar.hide()


            }
        })
    }

}