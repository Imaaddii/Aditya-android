package com.exobe.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import com.exobe.R

class ServiceDetailPage_SP : AppCompatActivity() {

    lateinit var back_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_service_available_sp)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        back_btn = findViewById(R.id.ServiceDetailPageSP_Back)
        back_btn.setOnClickListener {
            finish()
        }

    }
}