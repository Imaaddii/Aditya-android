package com.fram.farmserv.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fram.farmserv.Adapter.MyFarmerListAdapter
import com.fram.farmserv.ModalClass.MyFarmerListModelClass
import com.fram.farmserv.R

class MyFarmerListFragment : Fragment() {

    lateinit var recyclerMyFarmerList: RecyclerView
    lateinit var adapter: MyFarmerListAdapter

    val itemList :ArrayList<MyFarmerListModelClass> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_my_farmer_list, container, false)

        recyclerMyFarmerList = view.findViewById(R.id.recyclerMyFarmerList)

        val data1 = MyFarmerListModelClass(1, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
        val data2 = MyFarmerListModelClass(2, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
        val data3 = MyFarmerListModelClass(3, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
        val data4 = MyFarmerListModelClass(4, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
        val data5 = MyFarmerListModelClass(5, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
        val data6 = MyFarmerListModelClass(6, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
        val data7 = MyFarmerListModelClass(7, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
        val data8 = MyFarmerListModelClass(8, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
        val data9 = MyFarmerListModelClass(9, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
        val data10 = MyFarmerListModelClass(10, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")

        itemList.add(data1)
        itemList.add(data2)
        itemList.add(data3)
        itemList.add(data4)
        itemList.add(data5)
        itemList.add(data6)
        itemList.add(data7)
        itemList.add(data8)
        itemList.add(data9)
        itemList.add(data10)

        setupRecyclerView()

        return view
    }

    fun setupRecyclerView(){

        recyclerMyFarmerList.layoutManager = LinearLayoutManager(context)
        adapter = MyFarmerListAdapter(activity as Context,itemList)
        recyclerMyFarmerList.adapter = adapter
    }

}