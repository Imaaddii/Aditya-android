package com.exobe.Adaptor.servicesAdaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.R
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.serviceselectedclick


class PendingServicesAdapter(val context: Context, var serviceclick: serviceselectedclick, var data : Int) :
    RecyclerView.Adapter<PendingServicesAdapter.ProductLatestViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductLatestViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.services_pending_list, parent, false)
        return ProductLatestViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductLatestViewHolder, position: Int) {
        holder.cardview_Product.setOnClickListener {

            serviceclick.pendingclick(
                position
            )
        }


    }

    override fun getItemCount(): Int {
        return data
    }

    class ProductLatestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cardview_Product = view.findViewById<CardView>(R.id.Pending_cardview)


    }

}

