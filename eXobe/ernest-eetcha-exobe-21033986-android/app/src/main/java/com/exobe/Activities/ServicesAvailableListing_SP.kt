package com.exobe.Activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.ServicesAvaliableAdapter
import com.exobe.ModelClass.Services_Available
import com.exobe.R
import com.exobe.customClicks.CustomeClick

class ServicesAvailableListing_SP : AppCompatActivity(), CustomeClick {
    lateinit var service_provider_RecyclerView:RecyclerView
    lateinit var Adapter: ServicesAvaliableAdapter
    lateinit var ServicesAvailable_Back : ImageView
    lateinit var AllProvidersList_TV : TextView
    lateinit var AllServices_TV : TextView
    var data=ArrayList<Services_Available>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services_available_listing_sp)
        service_provider_RecyclerView=findViewById(R.id.service_provider_RecyclerView)
        ServicesAvailable_Back=findViewById(R.id.ServicesAvailable_Back)
        AllProvidersList_TV=findViewById(R.id.AllProvidersList_TextView)
        AllServices_TV=findViewById(R.id.AllServices_TextView)

        AllProvidersList_TV.setOnClickListener {
            AllServices_TV.setTextColor(Color.parseColor("#000000"))
            AllProvidersList_TV.setTextColor(Color.parseColor("#BF1E2E"))

//            CustomerRecyclerView.visibility = View.GONE
//            wholesellersRecyclerView.visibility = View.VISIBLE

        }
        AllServices_TV.setOnClickListener {
            AllServices_TV.setTextColor(Color.parseColor("#BF1E2E"))
            AllProvidersList_TV.setTextColor(Color.parseColor("#000000"))

//            CustomerRecyclerView.visibility = View.VISIBLE
//            wholesellersRecyclerView.visibility = View.GONE
        }


        ServicesAvailable_Back.setOnClickListener {
            finish()
        }

        data=ArrayList<Services_Available>()
        data.add(Services_Available(R.drawable.services_img!!, "House Cleaning Service", "7+ years in business","New Delhi,Delhi"))
        data.add(Services_Available(R.drawable.services_img!!, "House Cleaning Service", "7+ years in business","New Delhi,Delhi"))
        data.add(Services_Available(R.drawable.services_img!!, "House Cleaning Service", "7+ years in business","New Delhi,Delhi"))
        data.add(Services_Available(R.drawable.services_img!!, "House Cleaning Service", "7+ years in business","New Delhi,Delhi"))
        data.add(Services_Available(R.drawable.services_img!!, "House Cleaning Service", "7+ years in business","New Delhi,Delhi"))
        data.add(Services_Available(R.drawable.services_img!!, "House Cleaning Service", "7+ years in business","New Delhi,Delhi"))

        service_provider_RecyclerView.layoutManager = LinearLayoutManager(this)
        service_provider_RecyclerView.adapter = ServicesAvaliableAdapter(data,this,this)
    }

    override fun click(_id: String?) {
        var intent= Intent(this,ServiceDetailPage_SP::class.java)
        startActivity(intent)

    }


}