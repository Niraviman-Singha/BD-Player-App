package com.example.bdplayerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter (private val playerList:List<PlayerModel>, private val clickListener:(PlayerModel)->Unit):
    RecyclerView.Adapter<MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val playerItem = layoutInflater.inflate(R.layout.players_item, parent, false)
        return MyViewHolder(playerItem)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val player = playerList[position]
        holder.bind(player,clickListener)

    }
}
class MyViewHolder(val view: View):RecyclerView.ViewHolder(view) {
    fun bind(player:PlayerModel, clickListener: (PlayerModel) -> Unit){
        val title = view.findViewById<TextView>(R.id.playerTitle)
        val details = view.findViewById<TextView>(R.id.playerDetails)
        val img = view.findViewById<ImageView>(R.id.playerImg)

        title.text = player.title
        details.text = player.details
        img.setImageResource(player.img)

        view.setOnClickListener {
            clickListener(player)
        }
    }

}