package com.exobe.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.ModelClass.doc
import com.exobe.R
import com.exobe.customClicks.quantityCounter

class OrderReviewAdapter(
    var context: Context,
    var itemList: ArrayList<doc>,

    var quantityCounter: quantityCounter
) : RecyclerView.Adapter<OrderReviewAdapter.ViewHolder>() {
    var count = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderReviewAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.order_review_items_modallayout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderReviewAdapter.ViewHolder, position: Int) {
        val userData = itemList[position]
        holder.itemImage.setImageResource(userData.images!!)
        holder.ItemName.text = userData.productname
        holder.Price.text = userData.price
        holder.Quantity.text = userData.quantity.toString()
        count=userData.quantity!!

        holder.Decrement.setOnClickListener {
            if (count > 0) {
                count--
            }
            holder.Quantity.text = count.toString()
            quantityCounter.decrement(position, userData.price)

        }
        holder.Increment.setOnClickListener {
            count++
            holder.Quantity.text = count.toString()
            quantityCounter.increment(position, userData.price)

        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var ItemName: TextView
        var Price: TextView
        var Increment: RelativeLayout
        var Decrement: RelativeLayout
        var Quantity: TextView


        init {
            itemImage = itemView.findViewById(R.id.image)
            ItemName = itemView.findViewById(R.id.item_name)
            Price = itemView.findViewById(R.id.price)
            Increment = itemView.findViewById(R.id.increment)
            Decrement = itemView.findViewById(R.id.decrement)
            Quantity = itemView.findViewById(R.id.quantity)


        }
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

}



