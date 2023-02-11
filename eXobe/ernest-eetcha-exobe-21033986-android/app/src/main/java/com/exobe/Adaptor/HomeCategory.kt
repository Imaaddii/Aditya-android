package com.exobe.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exobe.R
import com.exobe.customClicks.CustomeClick3
import com.exobe.entity.Response.CategoryDetails
import com.mikhaellopez.circularimageview.CircularImageView

class HomeCategory(
    var context: Context,
    var data: ArrayList<CategoryDetails>,
    var customeClick: CustomeClick3

) : RecyclerView.Adapter<HomeCategory.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mInflater = LayoutInflater.from(context)
        val view: View = mInflater.inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Data = data[position]
//        holder.ImageCategory=Data.categoryDetails[0].categoryImage
        Glide.with(context).load(Data.categoryImage).into(holder.ImageCategory)
        holder.Description.text=Data.categoryName

        holder.ImageCategory.setOnClickListener {
            customeClick.click3(Data._id,Data.categoryName)
        }
    }


    override fun getItemCount(): Int {

        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ImageCategory: CircularImageView
        var Description: TextView

        init {
            ImageCategory = itemView.findViewById(R.id.ImageCategory)
            Description = itemView.findViewById(R.id.Description)
        }
    }

}