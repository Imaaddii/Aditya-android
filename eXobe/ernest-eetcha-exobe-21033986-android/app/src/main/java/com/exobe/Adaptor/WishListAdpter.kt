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
import com.bumptech.glide.Glide
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.wishlistcustomclick
import com.exobe.entity.Response.WishlistResult

class WishListAdpter(
    var context: Context,
    var data: ArrayList<WishlistResult>,
    var customeClick: CustomeClick,
    var flag: String,
    var resources: Resources,
    var wishlist: wishlistcustomclick

):RecyclerView.Adapter<WishListAdpter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mInflater = LayoutInflater.from(context)
        val view: View = mInflater.inflate(R.layout.product_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var Data = data[position]

        try {
            Glide.with(context).load(Data.productId?.productImage?.get(0)).into(holder.ImageCategory)
            holder.itemTitle1.text=Data.productId?.productName
            holder.price.text= "${Data.productId?.price!!}.00"

        } catch (e : Exception) {
            e.printStackTrace()
        }




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
//            context.supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, ReviewProductList())
//                .commit()
            customeClick.click(Data._id)
        }
        holder.heart.setOnClickListener {

            holder.heart.visibility = View.GONE
            holder.heartfill.visibility = View.VISIBLE
        }

        holder.heartfill.setOnClickListener {
            wishlist.wishlist(Data._id)
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


    }

}