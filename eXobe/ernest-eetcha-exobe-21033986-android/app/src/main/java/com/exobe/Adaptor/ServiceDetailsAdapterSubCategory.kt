package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.ModelClass.subCat
import com.exobe.R

class ServiceDetailsAdapterSubCategory(
    val context: Context,
    val itemList: ArrayList<subCat>
): RecyclerView.Adapter<ServiceDetailsAdapterSubCategory.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.subcategory_list,parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userData = itemList[position]

        holder.subCategory.text=userData.name
        holder.price.text=userData.price
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        var subCategory:CheckBox
        var price: TextView
         init {

             subCategory=itemView.findViewById(R.id.subCategory)
             price=itemView.findViewById(R.id.price)
         }

    }




}