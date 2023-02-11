package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.R
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.CustomeClick2


class ProductManagement_Adapter(
    val context: Context,
    var customeClick: CustomeClick,
    var customeClick2: CustomeClick2,
//    var data:ArrayList<ProductListDocs>,
    var flag: String
) :
    RecyclerView.Adapter<ProductManagement_Adapter.ProductLatestViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductLatestViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.productmanagement_modellayout, parent, false)
        return ProductLatestViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductLatestViewHolder, position: Int) {
//        val Data = data[position]

        if(flag.equals("deals")) {
            holder.retailer_details.visibility = View.VISIBLE
        }

        else {


            holder.retailer_details.visibility = View.GONE
        }

//        holder.productId.text=Data.pro
//        holder.productname.text=Data.productName
//        holder.product_category.text=Data
        holder.cardview_Product.setOnClickListener {
            customeClick2.click2()
        }

        holder.editProduct.setOnClickListener{
            customeClick.click("")
        }


    }

    override fun getItemCount(): Int {
     return  10
    }

    class ProductLatestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cardview_Product = view.findViewById<CardView>(R.id.ProductManagement_cardview)
        var editProduct = view.findViewById<ImageView>(R.id.edit_product)
        var retailer_details = view.findViewById<LinearLayout>(R.id.retailer_details_field)
        var productId = view.findViewById<TextView>(R.id.productId)
        var productname = view.findViewById<TextView>(R.id.productname)
        var product_category = view.findViewById<TextView>(R.id.product_category)
        var quantity = view.findViewById<TextView>(R.id.quantity)
        var price = view.findViewById<TextView>(R.id.price)
        var discount = view.findViewById<TextView>(R.id.discount)


    }

}

