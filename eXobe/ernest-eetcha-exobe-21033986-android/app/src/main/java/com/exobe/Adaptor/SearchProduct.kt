package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.R
import com.exobe.customClicks.CustomeClick2

class SearchProduct(var context: Context, var click: CustomeClick2):RecyclerView.Adapter<SearchProduct.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.serach_product,parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.ProductDetails.setOnClickListener {
            click.click2()
        }

    }

    override fun getItemCount(): Int {
        return 30
    }


    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        var ProductDetails: LinearLayout


        init {
            ProductDetails= view.findViewById(R.id.ProductDetails)
        }

    }

}