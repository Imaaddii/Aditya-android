package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exobe.Activities.Review
import com.exobe.Adapter.CategoryAdpter
import com.exobe.ModelClass.ReviewModel
import com.exobe.R
import com.mikhaellopez.circularimageview.CircularImageView

class ReviewAdaptor(var context: Context, var data: ArrayList<ReviewModel>) :
    RecyclerView.Adapter<ReviewAdaptor.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewAdaptor.MyViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.review_item, parent, false)
//        val view = LayoutInflater.from(context)
//            .inflate(R.layout.review_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
//        Glide.with(context).load(data.get(position).image).into(holder.image)
        holder.name.setText(data.get(position).name)
        holder.date.setText(data.get(position).date)
        holder.review.setText(data.get(position).review)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.user_image)
        var name: TextView = itemView.findViewById(R.id.user_name)
        var date: TextView = itemView.findViewById(R.id.user_date)
        var review: TextView = itemView.findViewById(R.id.user_review)

    }
}