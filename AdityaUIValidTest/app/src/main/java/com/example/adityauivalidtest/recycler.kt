package com.example.adityauivalidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adityauivalidtest.adapter.MyAdapter
import com.example.adityauivalidtest.model.ModelClass

class recycler : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var adapter : MyAdapter

    val itemList :ArrayList<ModelClass> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recyclerView = findViewById(R.id.recyclerView)


        val data1 = ModelClass("Strawberry","Cabinet","Weather","Okhla phase 1", "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/24627ca5-7c0a-442b-821d-e90f1849545f.png")
        val data2 = ModelClass("Chocolate","Cabinet","Event","Lajpat", "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/97eea924-ab5f-4c0a-bb47-dff6ef8932cf.png")
        val data3 = ModelClass("Jelly","Cabinet","Crime","Okhla phase 2", "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/2fd442a3-b630-4958-9d7c-cb4326dfe509.png")
        val data4 = ModelClass("Banana","Cabinet","Traffic","Saket", "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/5d8df8b7-5d7c-40df-836e-beefedf8af04.png")
        val data5 = ModelClass("Apple","Cabinet","Weather","Okhla phase 1", "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/24627ca5-7c0a-442b-821d-e90f1849545f.png")
        val data6 = ModelClass("Orange","Cabinet","Crime","Gorakhpur", "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/97eea924-ab5f-4c0a-bb47-dff6ef8932cf.png")
        val data7 = ModelClass("fruits","Cabinet","Crime","Gorakhpur", "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/2fd442a3-b630-4958-9d7c-cb4326dfe509.png")
        val data8 = ModelClass("Sdsdsd","Cabinet","Crime","Gorakhpur", "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/5d8df8b7-5d7c-40df-836e-beefedf8af04.png")



        itemList.add(data1)
        itemList.add(data2)
        itemList.add(data3)
        itemList.add(data4)
        itemList.add(data5)
        itemList.add(data6)
        itemList.add(data7)
        itemList.add(data8)





        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = MyAdapter(this, itemList)
        recyclerView.adapter = adapter
    }
}