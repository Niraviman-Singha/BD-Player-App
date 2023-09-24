package com.example.bdplayerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Player2Adapter(private val player2List:List<Player2Model>, private val clickListener:(Player2Model)->Unit):
    RecyclerView.Adapter<MyViewHolder2>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder2 {
        val layoutInflater = LayoutInflater.from(parent.context)
        val player2Item = layoutInflater.inflate(R.layout.player2_item, parent, false)
        return MyViewHolder2(player2Item)
    }

    override fun getItemCount(): Int {
        return player2List.size
    }

    override fun onBindViewHolder(holder: MyViewHolder2, position: Int) {
        val player2 = player2List[position]
        holder.bind(player2,clickListener)
    }
}

class MyViewHolder2(val view: View):RecyclerView.ViewHolder(view) {
    fun bind(player2:Player2Model, clickListener: (Player2Model) -> Unit){
        val title = view.findViewById<TextView>(R.id.playerTitle)
        val details = view.findViewById<TextView>(R.id.playerDetails)
        val img = view.findViewById<ImageView>(R.id.playerImg)

        title.text = player2.title
        details.text = player2.details
        img.setImageResource(player2.img)

        view.setOnClickListener {
            clickListener(player2)
        }
    }

}