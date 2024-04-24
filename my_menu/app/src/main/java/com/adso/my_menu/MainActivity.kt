package com.adso.my_menu

import android.app.VoiceInteractor.PickOptionRequest.Option
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adso.my_menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val T1 : TextView = findViewById(R.id.text)
        val T2 : TextView = findViewById(R.id.text2)
        val T3 : TextView = findViewById(R.id.text3)
        registerForContextMenu(T1)
        registerForContextMenu(T2)
        registerForContextMenu(T3)
        /*registerForContextMenu(binding.text)
        registerForContextMenu(binding.text2)
        registerForContextMenu(binding.text3)*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.men, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_seting -> Log.d("Option_Setting", "Click en Setting")

        }
        return true

    }
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.men, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        //val info = item.menuInfo
        return when (item.itemId) {
            R.id.option->{
                Toast.makeText(this@MainActivity,"hola desde option", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.ayuda->{
                Toast.makeText(this@MainActivity,"hola desde ayuda", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onContextItemSelected(item)

        }
    }

}