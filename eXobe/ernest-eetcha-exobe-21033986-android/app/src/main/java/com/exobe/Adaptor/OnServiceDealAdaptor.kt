package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.R
import com.exobe.customClicks.subserviceClick

class OnServiceDealAdaptor(var Context: Context, var subserviceClick: subserviceClick, var flag: String) : RecyclerView.Adapter<OnServiceDealAdaptor.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnServiceDealAdaptor.MyViewHolder {
        val mInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = mInflater.inflate(R.layout.deals_on_service_customer, parent, false)


        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnServiceDealAdaptor.MyViewHolder, position: Int) {
        holder.productName.setText("Electrician")

        holder.view_subservice.setOnClickListener {
            subserviceClick.subservice(flag)
        }
    }



    override fun getItemCount(): Int {
        return 3
    }

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var productName = item.findViewById<TextView>(R.id.productName)
        var view_subservice = item.findViewById<CardView>(R.id.view_subservice)

    }

}