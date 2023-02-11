package com.exobe.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.R

class search_homeactivity : AppCompatActivity() {

    lateinit var recyclerview :RecyclerView
//    lateinit var back :ImageView
//    lateinit var title :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_homeactivity)
        recyclerview=findViewById(R.id.recyclerview)
//        back=findViewById(R.id.back)
//        title=findViewById(R.id.title)

    }


}