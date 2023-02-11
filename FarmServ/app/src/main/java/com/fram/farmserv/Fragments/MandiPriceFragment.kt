package com.fram.farmserv.Fragments

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

//    lateinit var lineList: ArrayList<Entry>
//    lateinit var lineDataSet: LineDataSet
//    lateinit var lineData: LineData
//    lateinit var lineChart: LineChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_mandi_price, container, false)

//        lineChart = view.findViewById(R.id.lineChart)
//
//        // added bar chart static data
//        lineList = ArrayList()
//        lineList.add(Entry(1f, 0f))
//        lineList.add(Entry(2f, 0f))
//        lineList.add(Entry(3f, 0f))
//        lineList.add(Entry(4f, 100f))
//        lineList.add(Entry(5f, 700f))
//        lineList.add(Entry(6f, 800f))
//        lineList.add(Entry(7f, 400f))
//        lineList.add(Entry(8f, 0f))
//        lineList.add(Entry(9f, 0f))
//        lineList.add(Entry(10f, 0f))
//
//        val xAxis1: XAxis = lineChart.getXAxis()
//        xAxis1.position = XAxis.XAxisPosition.BOTTOM
//        xAxis1.granularity = 1f
//        xAxis1.isGranularityEnabled = true
//
//        lineDataSet = lineDataSet(lineList, "Static Data Entry")
//        lineData = lineData(lineDataSet)
//        lineChart.data = lineData
//
////        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS, 250)
//        lineDataSet.setColors(Color.LTGRAY, Color.LTGRAY, Color.LTGRAY, Color.rgb(199, 70, 55), Color.rgb(3, 59, 2), Color.rgb(253, 24, 19), Color.rgb(0, 100, 62), Color.LTGRAY, Color.LTGRAY, Color.LTGRAY)
//        lineDataSet.valueTextColor = Color.BLACK
//        lineDataSet.valueTextSize = 15f
//        // adding delay
//        lineChart.animateY(3000)

        return view
    }
}