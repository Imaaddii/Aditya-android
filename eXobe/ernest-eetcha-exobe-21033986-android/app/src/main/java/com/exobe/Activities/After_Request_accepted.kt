package com.exobe.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.exobe.R

class After_Request_accepted : AppCompatActivity() {

    lateinit var backAfterAccepted : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_request_accepted)

        backAfterAccepted = findViewById(R.id.backAfterAccepted)

        backAfterAccepted.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        finish()
    }
}