package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exobe.R
import com.exobe.customClicks.CustomeClick
import com.exobe.entity.Response.ServiceListDocs

class ServicesAdapter(val context: Context, val itemList: ArrayList<ServiceListDocs>, var click: CustomeClick) :
    RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.services_model_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val orderData = itemList[position]

        holder.itemText.text = orderData.categoryId?.categoryName
        Glide.with(context).load(orderData.categoryId?.categoryImage).into(holder.itemImage)
        holder.itemImage.setOnClickListener {
            click.click("")
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var itemImage: ImageView
        var itemText: TextView

        init {
            itemImage = itemView.findViewById(R.id.serviceImage)
            itemText = itemView.findViewById(R.id.serviceAvailableItem)


        }
    }
}
