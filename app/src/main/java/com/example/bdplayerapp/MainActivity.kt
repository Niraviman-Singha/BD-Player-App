package com.example.bdplayerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bdplayerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.playerRecycle.layoutManager = LinearLayoutManager(this)
        val playerList = listOf<PlayerModel>(
            PlayerModel("Mushfiqur Rahman", resources.getString(R.string.player1), R.drawable.mushfiq)
        )
        val player2List = listOf<Player2Model>(
            Player2Model("Tamim Iqbal", resources.getString(R.string.player2), R.drawable.tamim)
        )

        binding.playerRecycle.adapter = PlayerAdapter(playerList,){
                selectItem: PlayerModel -> listItemClicked(selectItem)
        }
        binding.player2Recycle.adapter = Player2Adapter(player2List,){
                selectItem: Player2Model -> listItemClicked(selectItem)
        }

    }
    private fun listItemClicked(player:PlayerModel){
        var intent = Intent(this@MainActivity, PlayerActivity::class.java)
        intent.putExtra("title", player.title)
        intent.putExtra("details", player.details)
        intent.putExtra("img", player.img)
        startActivity(intent)
    }

    private fun listItemClicked(player:Player2Model){
        var intent = Intent(this@MainActivity, Player2Activity::class.java)
        intent.putExtra("title", player.title)
        intent.putExtra("details", player.details)
        intent.putExtra("img", player.img)
        startActivity(intent)
    }
}