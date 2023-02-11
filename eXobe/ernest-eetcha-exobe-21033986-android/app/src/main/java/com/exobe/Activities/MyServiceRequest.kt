package com.exobe.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.MyServiceRequesterAdapter
import com.exobe.ModelClass.MyServicerequestModelClass
import com.exobe.R

class MyServiceRequest : AppCompatActivity() {

    lateinit var MyServicerequestRecycler: RecyclerView
    lateinit var MyServiceRequesterAdapter: MyServiceRequesterAdapter
    lateinit var notificationBackBtn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_service_request)

        var array: ArrayList<MyServicerequestModelClass> = ArrayList()

        MyServicerequestRecycler = findViewById(R.id.MyServicerequestRecycler)
        notificationBackBtn = findViewById(R.id.notificationBackBtn)
        notificationBackBtn.setOnClickListener { finish() }


        var data1 = MyServicerequestModelClass("Client_name",
            "09/08/22",
            ""
        )

        var data2 = MyServicerequestModelClass("client_name",
            "09/08/22",
            ""
        )

        var data3 = MyServicerequestModelClass("client_name",
            "09/08/22",
            ""
        )
        var data4 = MyServicerequestModelClass("client_name",
            "09/08/22",
            "Address :"
        )
        var data5 = MyServicerequestModelClass("client_name",
            "09/08/22",
            ""
        )
        var data6 = MyServicerequestModelClass("client_name",
            "09/08/22",
            ""
        )


        array.add(data1)
        array.add(data2)
        array.add(data3)
        array.add(data4)
        array.add(data5)
        array.add(data6)



        MyServicerequestRecycler.layoutManager = LinearLayoutManager(this)

        MyServiceRequesterAdapter = MyServiceRequesterAdapter(this, array)

        // Setting the Adapter with the recyclerview
        MyServicerequestRecycler.adapter = MyServiceRequesterAdapter
    }



}
