package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class forget : AppCompatActivity() {

    lateinit var otpValid : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget)

        otpValid = findViewById(R.id.otpValid)
        otpValid.setOnClickListener{
            Intent(this, otp:: class.java).also {
                startActivity(it)
            }
        }
    }
}