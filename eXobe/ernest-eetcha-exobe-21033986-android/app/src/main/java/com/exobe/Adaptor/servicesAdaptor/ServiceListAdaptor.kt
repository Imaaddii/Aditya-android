package com.exobe.Adaptor.servicesAdaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exobe.R

class ServiceListAdaptor : RecyclerView.Adapter<ServiceListAdaptor.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ServiceListAdaptor.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_details_items, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceListAdaptor.MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 2
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

}