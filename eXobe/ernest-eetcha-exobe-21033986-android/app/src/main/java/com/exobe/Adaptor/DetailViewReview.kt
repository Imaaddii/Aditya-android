package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.ModelClass.ReviewModel
import com.exobe.R

class DetailViewReview(val context: Context,var data: ArrayList<ReviewModel>): RecyclerView.Adapter<DetailViewReview.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.review_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(data.get(position).name)
        holder.date.setText(data.get(position).date)
        holder.review.setText(data.get(position).review)
    }


    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        var image: ImageView = itemView.findViewById(R.id.user_image)
        var name: TextView = itemView.findViewById(R.id.user_name)
        var date: TextView = itemView.findViewById(R.id.user_date)
        var review: TextView = itemView.findViewById(R.id.user_review)

    }


}