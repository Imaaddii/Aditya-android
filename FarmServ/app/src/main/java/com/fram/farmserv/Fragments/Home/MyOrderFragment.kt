package com.fram.farmserv.Fragments.Home

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fram.farmserv.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*

class MandiPriceFragment : Fragment() {

    lateinit var lineList: ArrayList<BarEntry>
    lateinit var lineDataSet: LineDataSet
    lateinit var lineData: LineData
    lateinit var lineChart: LineChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_mandi_price, container, false)

        lineChart = view.findViewById(R.id.lineChart)

        // added bar chart static data
        lineList = ArrayList()
        lineList.add(BarEntry(1f, 0f))
        lineList.add(BarEntry(2f, 0f))
        lineList.add(BarEntry(3f, 0f))
        lineList.add(BarEntry(4f, 100f))
        lineList.add(BarEntry(5f, 700f))
        lineList.add(BarEntry(6f, 800f))
        lineList.add(BarEntry(7f, 400f))
        lineList.add(BarEntry(8f, 0f))
        lineList.add(BarEntry(9f, 0f))
        lineList.add(BarEntry(10f, 0f))

        val xAxis1: XAxis = lineChart.getXAxis()
        xAxis1.position = XAxis.XAxisPosition.BOTTOM
        xAxis1.granularity = 1f
        xAxis1.isGranularityEnabled = true

//        lineDataSet = lineDataSet(lineList, "Static Data Entry")
//        lineData = lineData(lineDataSet)
        lineChart.data = lineData

//        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS, 250)
        lineDataSet.setColors(Color.LTGRAY, Color.LTGRAY, Color.LTGRAY, Color.rgb(199, 70, 55), Color.rgb(3, 59, 2), Color.rgb(253, 24, 19), Color.rgb(0, 100, 62), Color.LTGRAY, Color.LTGRAY, Color.LTGRAY)
        lineDataSet.valueTextColor = Color.BLACK
        lineDataSet.valueTextSize = 15f
        // adding delay
        lineChart.animateY(3000)

        return view
    }
}

//class MyOrderFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_my_order, container, false)
//    }
//
//}

//class MyFarmerListFragment : Fragment() {
//
//    lateinit var recyclerMyFarmerList: RecyclerView
//    lateinit var adapter: MyFarmerListAdapter
//
//    val itemList :ArrayList<MyFarmerListModelClass> = ArrayList()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val view = inflater.inflate(R.layout.fragment_my_farmer_list, container, false)
//
//        recyclerMyFarmerList = view.findViewById(R.id.recyclerMyFarmerList)
//
//        val data1 = MyFarmerListModelClass(1, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
//        val data2 = MyFarmerListModelClass(2, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
//        val data3 = MyFarmerListModelClass(3, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
//        val data4 = MyFarmerListModelClass(4, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
//        val data5 = MyFarmerListModelClass(5, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
//        val data6 = MyFarmerListModelClass(6, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
//        val data7 = MyFarmerListModelClass(7, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
//        val data8 = MyFarmerListModelClass(8, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
//        val data9 = MyFarmerListModelClass(9, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
//        val data10 = MyFarmerListModelClass(10, "Mr. Rajkumar", "Nashik, Maharashtra, 420003", "Mobile 99801 98765", "6 Purchases")
//
//        itemList.add(data1)
//        itemList.add(data2)
//        itemList.add(data3)
//        itemList.add(data4)
//        itemList.add(data5)
//        itemList.add(data6)
//        itemList.add(data7)
//        itemList.add(data8)
//        itemList.add(data9)
//        itemList.add(data10)
//
//        setupRecyclerView()
//
//        return view
//    }
//
//    fun setupRecyclerView(){
//
//        recyclerMyFarmerList.layoutManager = LinearLayoutManager(context)
//        adapter = MyFarmerListAdapter(activity as Context,itemList)
//        recyclerMyFarmerList.adapter = adapter
//    }
//
//}