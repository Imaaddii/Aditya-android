package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exobe.R
import com.exobe.customClicks.CustomeClick
import com.exobe.entity.Response.PendingOrderRetailerDocs


class PendingAdapter(val context: Context,
                     var click: CustomeClick,
                     var data:ArrayList<PendingOrderRetailerDocs>) :
        RecyclerView.Adapter<com.exobe.Adaptor.PendingAdapter.ProductLatestViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductLatestViewHolder {
            val view = LayoutInflater.from(context)
                .inflate(R.layout.pendinglayout, parent, false)
            return ProductLatestViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProductLatestViewHolder, position: Int) {
            val Data = data[position]
            holder.cardview_Product.setOnClickListener {
                click.click("")
            }

            holder.customername.text=Data.userDetails?.firstName
            holder.orderid.text = Data.orderId
            holder.orderdate.text=Data.createdAt
            holder.paymentstatus.text=Data.paymentStatus
            holder.address.text="${Data.shippingAddressDetails?.address} ${Data.shippingAddressDetails?.city} ${Data.shippingAddressDetails?.state}"
            holder.Total_amount.text="R${Data.orderPrice.toString()}"
            if(Data.productDetails?.productImage?.size != 0) {
                Glide.with(context).load(Data.productDetails?.product?.productImage?.get(0)).into(holder.image)
            } else {
                Glide.with(context).load("").placeholder(R.drawable.chair_img).into(holder.image)

            }

//

        }

        override fun getItemCount(): Int {
            return data.size
        }

          class ProductLatestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var cardview_Product = view.findViewById<CardView>(R.id.Pending_cardview)
            var address = view.findViewById<TextView>(R.id.address)
            var paymentstatus = view.findViewById<TextView>(R.id.paymentstatus)
            var Total_amount = view.findViewById<TextView>(R.id.Total_amount)
            var orderdate = view.findViewById<TextView>(R.id.orderdate)
            var orderid = view.findViewById<TextView>(R.id.orderid)
            var customername = view.findViewById<TextView>(R.id.customername)
            var image = view.findViewById<ImageView>(R.id.image)

        }

    }

