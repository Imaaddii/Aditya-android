package com.exobe.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.exobe.R

class AfterRequestedServiceDetails : AppCompatActivity() {
    lateinit var backReqService : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_requested_service_details)

        backReqService = findViewById(R.id.backReqService)
        backReqService.setOnClickListener(){
            onBackPressed()
        }
    }
}