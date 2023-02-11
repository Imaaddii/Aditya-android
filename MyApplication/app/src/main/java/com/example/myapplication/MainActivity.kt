package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var txtForget :TextView
    lateinit var signUP : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtForget = findViewById(R.id.txtForget)
        txtForget.setOnClickListener {
            Intent(this, forget::class.java).also {
                startActivity(it)
            }
        signUP = findViewById(R.id.signUP)
        signUP.setOnClickListener {
            Intent(this, signup::class.java).also {
                startActivity(it)
            }
        }
        }
    }
}