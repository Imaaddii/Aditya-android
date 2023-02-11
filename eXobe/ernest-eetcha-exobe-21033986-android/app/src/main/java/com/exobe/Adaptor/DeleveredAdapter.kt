package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.R
import com.exobe.customClicks.CustomeClick


class DeleveredAdapter(val context: Context, var customeClick: CustomeClick) :
    RecyclerView.Adapter<com.exobe.Adaptor.DeleveredAdapter.ProductLatestViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductLatestViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.deleveredlayout, parent, false)
        return ProductLatestViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductLatestViewHolder, position: Int) {
        holder.cardview_Product.setOnClickListener {
            customeClick.click("")
        }


    }

    override fun getItemCount(): Int {
        return 10
    }

    class ProductLatestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cardview_Product = view.findViewById<CardView>(R.id.Delevered_cardview)


    }

}


