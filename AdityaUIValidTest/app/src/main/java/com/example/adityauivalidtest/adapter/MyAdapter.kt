package com.example.adityauivalidtest.adapter

import android.content.Context
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adityauivalidtest.R
import com.example.adityauivalidtest.model.ModelClass

class MyAdapter(val context : Context, val itemList: ArrayList<ModelClass>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val itemtext : TextView = view.findViewById(R.id.txt_btn)
        val itemName : TextView = view.findViewById(R.id.itemTitle)
        val itemCategory : TextView = view.findViewById(R.id.itemCategory)
        val itemLocaion : TextView = view.findViewById(R.id.itemLocation)
        val itemImage : ImageView = view.findViewById(R.id.itemImage)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout , parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val userData = itemList[position]

        holder.itemtext.text = userData.text
        holder.itemName.text  = userData.title
        holder.itemCategory.text  = userData.category
        holder.itemLocaion.text  = userData.location
        Glide.with(context).load(userData.image).into(holder.itemImage)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}