package com.exobe.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.AcceptedAdapter
import com.exobe.Model.AcceptedModelClass
import com.exobe.R

class Accepted_Services : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AcceptedAdapter
    lateinit var AcceptServiceBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accepted_services)

        var array: ArrayList<AcceptedModelClass> = ArrayList()

        recyclerView = findViewById(R.id.acceptedRecycler)
        AcceptServiceBack = findViewById(R.id.AcceptServiceBack)
        AcceptServiceBack.setOnClickListener { finish() }

        var data1 = AcceptedModelClass("client_name",
            "Service required Date & Time : 09/08/22",
            "Address :"
        )

        var data2 = AcceptedModelClass("client_name",
            "Service required Date & Time : 09/08/22",
            "Address :"
        )

        var data3 = AcceptedModelClass("client_name",
            "Service required Date & Time : 09/08/22",
            "Address :"
        )

        array.add(data1)
        array.add(data2)
        array.add(data3)
        array.add(data3)
        array.add(data3)
        array.add(data3)
        array.add(data3)


        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = AcceptedAdapter(this, array)

        // Setting the Adapter with the recyclerview
        recyclerView.adapter = adapter



//        var dynTime = findViewById<TextView>(R.id.dynTime)
//
//        object : CountDownTimer(180000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                var seconds = (millisUntilFinished / 1000).toInt()
//                val hours = seconds / (60 * 60)
//                val tempMint = seconds - hours * 60 * 60
//                val minutes = tempMint - minutes * 60
//                dynTime.setText(
//                    String.format("%02d", minutes) + ":" + String.format("%02d", seconds)
//                )
//            }
//
//            override fun onFinish() {
//                dynTime.SetText("Session Expired")
//            }

//        }



//        RecyclerView.layoutManager = LinearLayoutManager(this)
//
//        adapter = AcceptedAdapter(this, itemList)
//
//        RecyclerView.adapter = adapter
    }







}