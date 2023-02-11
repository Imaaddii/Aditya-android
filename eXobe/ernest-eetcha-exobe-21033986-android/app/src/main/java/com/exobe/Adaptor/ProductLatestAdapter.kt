package com.exobe.Adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Activities.MyCartActivity
import com.exobe.AddedProductDescription
import com.exobe.Model.ProductLatestModel
import com.exobe.R

class ProductLatestAdapter(val context: Context, val itemList: ArrayList<ProductLatestModel>) :
    RecyclerView.Adapter<ProductLatestAdapter.ProductLatestViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductLatestViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.latest_product_model_layout, parent, false)
        return ProductLatestViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductLatestViewHolder, position: Int) {
        val orderData = itemList[position]

        holder.txtItem.text = orderData.itemName
        holder.productListImage1.setImageResource(orderData.Image)


        holder.touch_LL.setOnClickListener {
            Intent(context, AddedProductDescription::class.java ).also{
                context.startActivity(it)
            }
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ProductLatestViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var productListImage1: ImageView
        var touch_LL: LinearLayout
        var txtItem: TextView

        init {
            productListImage1 = itemView.findViewById(R.id.productListImage)
            txtItem = itemView.findViewById(R.id.productListText)
            touch_LL = itemView.findViewById(R.id.touch_LinearLayout)


        }

    }

}