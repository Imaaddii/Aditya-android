package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.AcceptedAdapter
import com.exobe.R

class ProductDetailsAdapter(
    var context: Context
): RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.orderdetail_items_retailer, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 2
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }


}