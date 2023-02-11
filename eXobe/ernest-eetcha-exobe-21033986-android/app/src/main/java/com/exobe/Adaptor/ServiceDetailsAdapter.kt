package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.ModelClass.cat
import com.exobe.R

class ServiceDetailsAdapter(
    val context: Context,
    val itemList: ArrayList<cat>
): RecyclerView.Adapter<ServiceDetailsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.service_detail_description,parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userData = itemList[position]


        holder.CategoryName.text= userData.name

        holder.NestedRecyclerView.layoutManager = LinearLayoutManager(context)
        holder.NestedRecyclerView.adapter =
            itemList.get(position).subCat?.let { ServiceDetailsAdapterSubCategory(context, it) }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        var CategoryName:TextView
        var NestedRecyclerView:RecyclerView
         init {

             CategoryName=itemView.findViewById(R.id.CategoryName)
             NestedRecyclerView=itemView.findViewById(R.id.NestedRecyclerView)

         }

    }




}