package com.example.myapplicationtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class forget : AppCompatActivity() {
    lateinit var Editprofile:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget)
        Editprofile = findViewById(R.id.Editprofile)
        Editprofile.setOnClickListener{
            var Editprofile = Editprofile.text.toString()
            var intent = Intent(this, editprofile::class.java)
            startActivity(intent)
        }
        val signUpback = findViewById<ImageView>(R.id.backbutton)
        signUpback.setOnClickListener{
            finish()
        }
    }
}