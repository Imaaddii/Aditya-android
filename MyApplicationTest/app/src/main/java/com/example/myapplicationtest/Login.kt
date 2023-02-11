package com.example.myapplicationtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Login : AppCompatActivity() {
    lateinit var signUp:TextView
    lateinit var Forget:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        signUp = findViewById(R.id.signUp)
        signUp.setOnClickListener {
            var sign = signUp.text.toString()
            var intent = Intent(this,SignIn::class.java)
            startActivity(intent)
        }
        Forget = findViewById(R.id.Forget)
        Forget.setOnClickListener {
            var Forget = Forget.text.toString()
            var intent = Intent(this, forget::class.java)
            startActivity(intent)
        }
    }
}