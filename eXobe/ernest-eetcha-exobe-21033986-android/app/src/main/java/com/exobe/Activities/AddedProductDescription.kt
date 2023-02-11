package com.exobe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.AddedProductDescriptionAdapter
import com.exobe.ModelClass.AddedProductDescriptionModelClass

class AddedProductDescription : AppCompatActivity() {

    lateinit var adapter : AddedProductDescriptionAdapter
    lateinit var RecyclerLayout : RecyclerView
    lateinit var back : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_added_product_description)

        val itemList : ArrayList<AddedProductDescriptionModelClass> = ArrayList()

        RecyclerLayout = findViewById(R.id.addedDealProductRecycler)
        back = findViewById(R.id.AddedProductDescription_Back)
        back.setOnClickListener {
            finish()
        }


//        val data1 = AddedProductDescriptionModelClass("Customer Name", "Order \nDate &amp; Time ","phone Number","View")
        val data1 = AddedProductDescriptionModelClass("Customer Name", "22/09/21 \n" +"13:23","9867987698","View")
        val data2 = AddedProductDescriptionModelClass("Ajay", "22/09/21 \n" +"13:23","9867987698","View")
        val data3 = AddedProductDescriptionModelClass("Ajay", "22/09/21 \n" +"13:23","9867987698","View")
        val data4 = AddedProductDescriptionModelClass("Ajay", "22/09/21 \n" +"13:23","9867987698","View")
//        val data5 = AddedProductDescriptionModelClass(" ", " "," "," ")


        itemList.add(data1)
        itemList.add(data2)
        itemList.add(data3)
        itemList.add(data4)
//        itemList.add(data5)

        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        RecyclerLayout.layoutManager = GridLayoutManager(this, 1)

        adapter = AddedProductDescriptionAdapter(this, itemList)

        RecyclerLayout.adapter = adapter

    }
}