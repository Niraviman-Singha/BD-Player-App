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
            PlayerModel("Shakib Al-Hasan", resources.getString(R.string.shakib), R.drawable.shakib),
            PlayerModel("Tamim Iqbal", resources.getString(R.string.tamim), R.drawable.tamim),
            PlayerModel("Mushfiqur Rahman", resources.getString(R.string.mushfiq), R.drawable.mushfiq),
            PlayerModel("Mushfiqur Rahim", resources.getString(R.string.mustafizur), R.drawable.mustafiz),
            PlayerModel("Mehidy Hasan Miraz", resources.getString(R.string.mehidy), R.drawable.miraj),
            PlayerModel("Mahmudullah", resources.getString(R.string.mahmudullah), R.drawable.mahmudullah),
            PlayerModel("Litton Das", resources.getString(R.string.liton), R.drawable.liton),

            )

        binding.playerRecycle.adapter = PlayerAdapter(playerList,){
                selectItem: PlayerModel -> listItemClicked(selectItem)
        }

    }
    private fun listItemClicked(player:PlayerModel){
        var intent = Intent(this@MainActivity, PlayerActivity::class.java)
        intent.putExtra("title", player.title)
        intent.putExtra("details", player.details)
        intent.putExtra("img", player.img)
        startActivity(intent)
    }

}