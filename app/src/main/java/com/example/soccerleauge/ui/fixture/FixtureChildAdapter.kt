package com.example.soccerleauge.ui.fixture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerleauge.R
import kotlinx.android.synthetic.main.item_fixture_child.view.*
import java.util.*

class FixtureChildAdapter(var fixtureChildList : Array<Array<String>>) :
    RecyclerView.Adapter<FixtureChildAdapter.ChildViewHolder>() {

    inner class ChildViewHolder (val view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fixture_child,parent,false)
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.view.firstTeam.text = fixtureChildList[position][0]
        holder.view.secondTeam.text = fixtureChildList[position][1]
    }

    override fun getItemCount() = fixtureChildList.size
}