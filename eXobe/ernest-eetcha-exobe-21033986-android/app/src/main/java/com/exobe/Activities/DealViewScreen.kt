package com.exobe.Activities

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.exobe.R

class DealViewScreen : AppCompatActivity() {


    lateinit var offerValue1: TextView
    lateinit var Back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deal_view_screen)

        offerValue1 =findViewById(R.id.dealViewOfferValue1)
        Back =findViewById(R.id.dealViewBack)

        offerValue1.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

        Back.setOnClickListener{
            onBackPressed()

        }

        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

    }

    override fun onBackPressed() {
        finish()
    }
}