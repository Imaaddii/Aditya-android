package com.exobe.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.DeleveredAdapter
import com.exobe.R
import com.exobe.customClicks.CustomeClick


class DeleveredOrder(var customeClick: CustomeClick) : Fragment(), CustomeClick {
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_delevered_order, container, false)

        recyclerView = view.findViewById(R.id.Order_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        var adapter = DeleveredAdapter(activity as Context, this)
        recyclerView.adapter = adapter
        return view
    }

    override fun click(_id: String?) {
        customeClick.click("")

    }


}