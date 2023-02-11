package com.exobe.Adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exobe.Activities.ServicesAvailableListing_SP
import com.exobe.ModelClass.ServicesModelClass
import com.exobe.R
import com.exobe.entity.Response.ServiceListDocs

class ServicesAdapter_SP(val context: Context, val itemList: ArrayList<ServiceListDocs>) : RecyclerView.Adapter<ServicesAdapter_SP.ServiceAvailableViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceAvailableViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.services_model_layout, parent, false)
        return ServiceAvailableViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceAvailableViewHolder, position: Int) {
        val orderData = itemList[position]

        holder.itemText.text = orderData.serviceName
        Glide.with(context).load(orderData.serviceImage).into(holder.itemImage)
        holder.itemImage.setOnClickListener {
            val intent = Intent(context, ServicesAvailableListing_SP::class.java)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ServiceAvailableViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        var itemImage: ImageView
        var itemText: TextView

        init {
            itemImage = itemView.findViewById(R.id.serviceImage)
            itemText = itemView.findViewById(R.id.serviceAvailableItem)


        }
    }

}