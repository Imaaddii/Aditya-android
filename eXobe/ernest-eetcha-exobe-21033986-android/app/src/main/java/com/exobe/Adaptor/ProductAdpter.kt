package com.exobe.Adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.wishlistcustomclick
import com.exobe.entity.Response.ProductDetails

class ProductAdpter(
    var context: Context,
    var data: ArrayList<ProductDetails>,
    var customeClick: CustomeClick,
    var flag: String,
    var resources: Resources,
    var wishlist: wishlistcustomclick

):RecyclerView.Adapter<ProductAdpter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mInflater = LayoutInflater.from(context)
        val view: View = mInflater.inflate(R.layout.product_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var Data = data[position]
        Glide.with(context).load(Data.productImage?.get(0)).into(holder.ImageCategory)
//        Glide.with(context).load(Data.productImage).into(holder.ImageCategory)
        holder.itemTitle1.text=Data.productName
        holder.price.text= "R${Data.price!!.toString()+".00"}"



        if(SavedPrefManager.getStringPreferences(context,SavedPrefManager.priceTag).equals("Customer")) {
            holder.priceTag.setText("M.R.P: ")
        } else {
            androidextention
            holder.priceTag.setText("W.S.P: ")
        }


        if(flag.equals("wishlist")){
            holder.heart.visibility=View.GONE
            holder.heartfill.visibility=View.VISIBLE
        }
        holder.click.setOnClickListener {
            customeClick.click(Data._id)
        }
        holder.heart.setOnClickListener {
            wishlist.wishlist(Data._id)
            holder.heart.visibility = View.GONE
            holder.heartfill.visibility = View.VISIBLE
        }

        holder.heartfill.setOnClickListener {
            holder.heartfill.visibility = View.GONE
            holder.heart.visibility = View.VISIBLE
        }



    }

    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var ImageCategory:ImageView =itemView.findViewById(R.id.item_image)
        var itemTitle1:TextView =itemView.findViewById(R.id.itemTitle1)
        var price:TextView =itemView.findViewById(R.id.itemValue2)
        var heartOutline:LinearLayout =itemView.findViewById(R.id.heartOutline)
        var heart:ImageView =itemView.findViewById(R.id.heart)
        var heartfill:ImageView =itemView.findViewById(R.id.heartfill)
        var click : LinearLayout =  itemView.findViewById(R.id.CategoryCV)
        var priceTag : TextView =  itemView.findViewById(R.id.priceTag)
        var CategoryCV: LinearLayout = itemView.findViewById(R.id.CategoryCV)

    }

}