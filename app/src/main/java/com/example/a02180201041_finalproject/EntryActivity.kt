package com.example.a02180201041_finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.TextView

class EntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        var nameText = findViewById<TextView>(R.id.nameText)

        var sayac = findViewById<TextView>(R.id.timeText);

        var gerisay = object  : CountDownTimer(6000, 1000){
            override fun onTick(time: Long) {
                sayac.text = (time/1000).toString();

                nameText.visibility = View.VISIBLE;
                Handler().postDelayed({
                    nameText.visibility = View.INVISIBLE;
                },500)
            }

            override fun onFinish() {
                val gecis = Intent(applicationContext, LoginActivity::class.java)
                startActivity(gecis)
                finish()
            }

        }

        gerisay.start()



    }
}