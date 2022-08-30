package com.example.a02180201041_finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var menuButton = findViewById<Button>(R.id.menuButton)

        menuButton.setOnClickListener {
            val acilirmenu = PopupMenu(this, menuButton)
            acilirmenu.menuInflater.inflate(R.menu.popupmenu,acilirmenu.menu)
            acilirmenu.setOnMenuItemClickListener { i->
                when(i.itemId){
                    R.id.home->{
                        fragmentCagir(homeFragment())
                        true}
                    R.id.colors->{
                        fragmentCagir(colorsFragment())
                        true}
                    R.id.move->{
                        fragmentCagir(moveFragment())
                        true}
                    R.id.visible_invisible->{
                        fragmentCagir(visibleFragment())
                        true}
                    R.id.message->{
                        fragmentCagir(messageFragment())
                        true}
                    else -> false
                }
            }
            acilirmenu.show()
        }
    }

    fun fragmentCagir(fragment: Fragment){
        var gecis = supportFragmentManager.beginTransaction()
        gecis.replace(R.id.fragmentContainerView, fragment)
        gecis.commit()
    }
}