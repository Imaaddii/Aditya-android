package com.exobe.Adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exobe.Activities.Customers_Deals
import com.exobe.Activities.DealViewScreen
import com.exobe.Activities.Services_DealsScreen
import com.exobe.Fragments.RetailerHomepage
import com.exobe.R
import com.exobe.customClicks.CustomeClick4
import com.exobe.entity.Response.viewdealsResult

class dealviewimage_adaptor(
    var imageList: ArrayList<viewdealsResult>,
    var context: Context,
    var click: CustomeClick4,
    var flag: String


) : RecyclerView.Adapter<dealviewimage_adaptor.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        var view : View? =  LayoutInflater.from(parent.context).inflate(R.layout.slider_image, null)
        view?.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)!!
        return dealviewimage_adaptor.MyViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: dealviewimage_adaptor.MyViewHolder, position: Int) {
        val userData = imageList[position]

        Glide.with(context).load(userData.dealImage).into(holder.image)

        Glide.with(context).load(imageList.get(position)).into(holder.image)
        if (flag.equals("viewdeals")){

        }else{

            holder.image.setOnClickListener {
                click.click4()
            }
        }
    }
    override fun getItemCount(): Int {
        return imageList.size
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.img)

    }
}