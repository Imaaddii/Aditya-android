package com.exobe.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.exobe.customClicks.CustomeClick
import com.exobe.entity.Response.productListByCategoryResult

class CategoryProductItemAdapter(
    val context: Context,
    var data: ArrayList<productListByCategoryResult>,
    var  customeClick: CustomeClick
):RecyclerView.Adapter<CategoryProductItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.product_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val orderData = data[position]

        Glide.with(context).load(orderData.productImage?.get(0)).into(holder.ImageCategory)

        holder.itemTitle1.setText(orderData.productName)
//        holder.Price.text=orderData.subCategory?.get(position).
//        holder.Price.text=orderData.price.toString()+".00"

        if(SavedPrefManager.getStringPreferences(context, SavedPrefManager.priceTag).equals("Customer")) {
            holder.priceTag.setText("M.R.P: ")
        } else {
            holder.priceTag.setText("W.S.P: ")
        }
//        holder.Price.text = orderData.Price
        holder.CategoryCV.setOnClickListener {
//            var intent = Intent(context,Product_View::class.java)
//            context.startActivity(intent)
//            supportFragmentManager?.beginTransaction()
//                ?.replace(R.id.FrameLayout, Product_View())?.commit()
            customeClick.click(orderData._id)

        }
        holder.red_heartFill.setOnClickListener {
            holder.red_heartFill.visibility = View.GONE
            holder.heartOutline.visibility = View.VISIBLE
        }

        holder.heartOutline.setOnClickListener {
            holder.heartOutline.visibility = View.GONE
            holder.red_heartFill.visibility = View.VISIBLE
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


            var ImageCategory:ImageView =itemView.findViewById(R.id.item_image)
            var itemTitle1:TextView =itemView.findViewById(R.id.itemTitle1)
            var Price:TextView =itemView.findViewById(R.id.itemValue2)
            var heartOutline:ImageView =itemView.findViewById(R.id.heart)
            var red_heartFill:ImageView =itemView.findViewById(R.id.heartfill)
            var CategoryCV:LinearLayout =itemView.findViewById(R.id.CategoryCV)
        var priceTag : TextView =  itemView.findViewById(R.id.priceTag)



    }



}