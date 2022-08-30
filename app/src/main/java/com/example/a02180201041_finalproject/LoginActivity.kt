package com.example.a02180201041_finalproject

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

val dosyayolu = "com.example.a02180201041_finalproject"
val anahtar   = "1"
val anahtarname = "Bunyamin Goymen"
val anahtarnumber = "02180201041"

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var correctName = "Bunyamin GOYMEN"
        var correctNumber = "02180201041"

        var loginButton = findViewById<Button>(R.id.loginButton)

        var name = findViewById<EditText>(R.id.namePlainText)
        var number = findViewById<EditText>(R.id.schoolNumberNumberText)

        var remember_me = findViewById<Switch>(R.id.remember)

        var preferences = getSharedPreferences(dosyayolu, Context.MODE_PRIVATE)
        var editor = preferences.edit()

        if(preferences.getString(anahtar,"1").equals("1")){
            name.setText(preferences.getString(anahtarname,"Bunyamin GOYMEN"))
            number.setText(preferences.getString(anahtarnumber,"02180201041"))
            remember_me.isChecked = true;
        }else{
            remember_me.isChecked = false;
        }

        remember_me.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                editor.putString(anahtar,"1")
                editor.apply()
            }else{
                editor.putString(anahtar,"0")
                editor.apply()
            }
        }

        loginButton.setOnClickListener {

            if( remember_me.isChecked){
                editor.putString(anahtarname,name.text.toString())
                editor.putString(anahtarnumber,number.text.toString())
                editor.apply()
            }else{
                editor.putString(anahtarname,"")
                editor.putString(anahtarnumber,"")
                editor.apply()
            }


            if(name.text.toString().equals("") || number.text.toString().equals("")){
                val alert = AlertDialog.Builder(this)
                alert.setTitle("Hata")
                alert.setMessage("Alanlar Boş Bırakılamaz")
                alert.show()
            }else if(!name.text.toString().equals(correctName) || !number.text.toString().equals(correctNumber)){
                val alert = AlertDialog.Builder(this)
                alert.setTitle("Hata")
                alert.setMessage("İsim veya Numara Bilgisi Yanlış")
                    .setCancelable(false)
                    .setNeutralButton("Yeniden Dene", DialogInterface.OnClickListener { dialog, id ->
                        name.setText("")
                        number.setText("")
                    })
                    .setPositiveButton("Çık", DialogInterface.OnClickListener { dialog, id ->
                        finish()
                    })


                alert.show()
            }else{
                val correctLogin =layoutInflater.inflate(R.layout.correct_login_alert, null)
                val alert = AlertDialog.Builder(this)
                alert.setView(correctLogin)

                val sayac = correctLogin.findViewById<TextView>(R.id.sayac)

                var gerisay = object  : CountDownTimer(4000, 1000){
                    override fun onTick(time: Long) {
                        sayac.text = (time/1000).toString();
                    }
                    override fun onFinish() {
                        val gecis = Intent(applicationContext, MainActivity::class.java)
                        startActivity(gecis)
                        finish()
                    }

                }
                alert.create().show()
                gerisay.start()
            }
        }


    }
}