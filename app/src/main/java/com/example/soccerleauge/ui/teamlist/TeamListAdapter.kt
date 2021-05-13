package com.example.soccerleauge.ui.teamlist


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerleauge.R
import com.example.soccerleauge.databinding.ItemTeamBinding
import com.example.soccerleauge.model.TeamResponse
import com.example.soccerleauge.util.getProgressDrawable
import com.example.soccerleauge.util.loadImage

class TeamListAdapter(val teamList : List<TeamResponse>) :
    RecyclerView.Adapter<TeamListAdapter.TeamVH>() {

    inner class TeamVH(var view : ItemTeamBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamVH {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemTeamBinding>(inflater, R.layout.item_team,parent,false)

        return TeamVH(view)
    }

    override fun onBindViewHolder(holder: TeamVH, position: Int) {

        holder.view.team = teamList[position]
        holder.view.teamLogo.loadImage(
            teamList[position]
                .strTeamBadge,
            getProgressDrawable(holder
                .view
                .teamLogo
                .context))

    }

    override fun getItemCount() = teamList.size


}