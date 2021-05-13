package com.example.soccerleauge.ui.fixture

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerleauge.R
import com.example.soccerleauge.ui.viewmodel.FixtureViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_fixture.*

@AndroidEntryPoint
class FixtureFragment : Fragment() {

    private lateinit var allFixtures : MutableList<Array<Array<String>>>
    private val baseAdapter = FixtureBaseAdapter(arrayListOf())

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

        baseRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = baseAdapter
        }

        observeViewModel(viewmodel)
    }

    private fun observeViewModel(viewmodel: FixtureViewModel) {

        viewmodel.teamList.observe(viewLifecycleOwner, Observer{
                getFixture(it)
        })

    }

    private fun getFixture(teamList: List<String>) {
        var baseTeam : String? = null
        val teams = teamList.toMutableList()
        if (teams.size % 2 != 0){
            teams.add("Pass")
        }
        val shuffTeams = teams.shuffled().toMutableList()

        baseTeam = shuffTeams[0]
        shuffTeams.removeAt(0)

        //Butun fixturleri cektik cift sayi icin
        val fixtures = drawFixture(shuffTeams,baseTeam)

        baseAdapter.fixtureList = fixtures
        baseAdapter.notifyDataSetChanged()

        println("--------- all fixtures -----------")
        for (i in 0 until teams.size-1){
            for (j in 0 until teams.size/2){
                println(fixtures[i][j].toList())
            }
        }
        println("Fixture Size: ${fixtures[0].size}")
    }

    fun drawFixture(shuffTeams: List<String>, baseTeam: String): MutableList<Array<Array<String>>> {

        var array = shuffTeams
        allFixtures = mutableListOf()

        println("------------ base array -----------")
        println(array.toList())

        for (i in array.indices){

            val fixtureMatrix = arrayOf(arrayOf(baseTeam,array[0]))
            val newMatrix = fixtureMatrix.toMutableList()

            for (j in 1 until ((array.size/2)+1)){
                newMatrix.add(j, arrayOf(array[j],array[array.lastIndex-j+1]))
            }
            allFixtures.add(i,newMatrix.toTypedArray())
            newMatrix.clear()
            array = getNewArray(array)

            println("------------ new array -----------")
            println(array.toList())
        }

        return allFixtures
    }

    fun getNewArray(array: List<String>): List<String> {

        val newArray = array.toMutableList()

        newArray.add(0,array[array.lastIndex])
        newArray.removeAt(newArray.lastIndex)

        return newArray.toList()

    }

}