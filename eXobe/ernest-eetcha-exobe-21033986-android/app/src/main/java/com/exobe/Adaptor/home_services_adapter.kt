package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exobe.ModelClass.Services_modalclass
import com.exobe.R
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.CustomeClick2
import com.exobe.entity.Response.ServiceDetails

class home_services_adapter (
    var context: Context,
    var data:ArrayList<ServiceDetails>,
    var customeClick: CustomeClick2
):RecyclerView.Adapter<home_services_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mInflater = LayoutInflater.from(context)
        val view: View = mInflater.inflate(R.layout.services_modal_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Data = data[position]
        Glide.with(context).load(Data.serviceImage).into(holder.image)
        holder.text.text=Data.serviceName
        holder.image.setOnClickListener {

            customeClick.click2()
        }

    }


    override fun getItemCount(): Int {

        return data.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var text: TextView

        init {
            image = itemView.findViewById(R.id.image)
            text = itemView.findViewById(R.id.text)
        }
    }
}
