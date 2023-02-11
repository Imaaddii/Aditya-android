package com.exobe.Adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.AddedProductDescription
import com.exobe.ModelClass.ReviewProductListModelClass
import com.exobe.R

class ReviewProductListAdapter (val context: Context, val itemList: ArrayList<ReviewProductListModelClass>): RecyclerView.Adapter<ReviewProductListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_producr_list_modellayout,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userData = itemList[position]

        holder.itemText.text = userData.itemText
        holder.itemImage.setImageResource(userData.itemImage)

        holder.itemImage.setOnClickListener {
            Intent(context, AddedProductDescription::class.java ).also{
                context.startActivity(it)
            }
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemText: TextView

        init {
            itemImage=itemView.findViewById(R.id.productListImage)
            itemText=itemView.findViewById(R.id.productListText)


        }
    }
}