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
import com.exobe.ModelClass.CartProductModel
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.exobe.customClicks.CustomeClick

class MyCartAdapter2(
    var context: Context,
    var data: ArrayList<CartProductModel>,
    var customeClick: CustomeClick
): RecyclerView.Adapter<MyCartAdapter2.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        // Define click listener for the ViewHolder's View.
        var background = view.findViewById<ImageView>(R.id.backGround)
        var image = view.findViewById<ImageView>(R.id.product_image)
        var name=view.findViewById<TextView>(R.id.productName)
        var price=view.findViewById<TextView>(R.id.productPrice)
        var ProductDetails=view.findViewById<LinearLayout>(R.id.ProductDetails)
        var priceTag = view.findViewById<TextView>(R.id.Price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCartAdapter2.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_description_recycler, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyCartAdapter2.ViewHolder, position: Int) {
        var userData = data[position]
        holder.name.text = userData.name
        holder.price.text = userData.price
        if(SavedPrefManager.getStringPreferences(context, SavedPrefManager.priceTag).equals("Customer")) {
            holder.priceTag.setText("M.R.P: ")
        } else {
            holder.priceTag.setText("W.S.P: ")
        }
        Glide.with(context).load(userData.background).into(holder.background);
        Glide.with(context).load(userData.image).into(holder.image);

        holder.ProductDetails.setOnClickListener {
            customeClick.click("")
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }
}