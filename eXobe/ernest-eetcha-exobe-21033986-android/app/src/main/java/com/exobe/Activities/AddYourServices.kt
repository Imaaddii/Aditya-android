package com.exobe.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import com.exobe.R

class AddYourServices : AppCompatActivity() {

    lateinit var hours_spinner : Spinner
    lateinit var back : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_your_services)

        hours_spinner = findViewById(R.id.hours_spinner)
        back= findViewById(R.id.AddYourServices_Back)


        back.setOnClickListener {
         finish()
        }

    }
}