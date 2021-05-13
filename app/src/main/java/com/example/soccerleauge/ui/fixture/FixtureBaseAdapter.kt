package com.example.soccerleauge.ui.fixture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerleauge.R
import kotlinx.android.synthetic.main.fragment_fixture.view.*
import kotlinx.android.synthetic.main.item_fixture_base.view.*

class FixtureBaseAdapter(var fixtureList: MutableList<Array<Array<String>>>) :
    RecyclerView.Adapter<FixtureBaseAdapter.BaseViewHolder>() {

    private val childAdapter = FixtureChildAdapter(arrayOf())

    inner class BaseViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fixture_base,parent,false)


        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        childAdapter.fixtureChildList = fixtureList[position]
        holder.view.weekText.text = "Week - ${position+1}"

        holder.view.childRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = childAdapter
        }
    }

    override fun getItemCount() = fixtureList.size
}