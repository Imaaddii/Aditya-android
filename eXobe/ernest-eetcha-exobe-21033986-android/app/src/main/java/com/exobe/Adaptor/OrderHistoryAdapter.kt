package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exobe.Activities.OrderHistory
import com.exobe.Model.OrderHistoryModel
import com.exobe.R
import com.exobe.customClicks.OrderHistoryCustomClick
import com.exobe.customClicks.delete
import com.exobe.entity.Response.PendingOrderRetailerDocs

class OrderHistoryAdapter(
    val context: Context,
    val itemList: ArrayList<PendingOrderRetailerDocs>,
    var  orderHistoryCustomClick: OrderHistoryCustomClick
) : RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryViewModel>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHistoryViewModel {
        val view = LayoutInflater.from(context).inflate(R.layout.order_history_items, parent, false)
        return OrderHistoryViewModel(view)
    }

    override fun onBindViewHolder(holder: OrderHistoryViewModel, position: Int) {
        val orderData = itemList[position]

        holder.item_name.text = orderData.productDetails?.product?.productName
        holder.price.text = "R ${orderData.orderPrice.toString()}.00"
        holder.txtOrderID.text = orderData.orderId
        holder.image
        holder.txtStatus.text = orderData.deliveryStatus
        holder.qty.text = "Qty:${orderData.productDetails?.quantity}"

        if(orderData.productDetails?.productImage?.size != 0) {
            Glide.with(context).load(orderData.productDetails?.product?.productImage?.get(0)).into(holder.image)
        } else {
            Glide.with(context).load("").placeholder(R.drawable.chair_img).into(holder.image)

        }
        holder.delete.setOnClickListener{
            orderHistoryCustomClick.delete()
        }

        if (orderData.deliveryStatus.equals("PENDING")){
            holder.btnReOrder.visibility=View.GONE
        }

       holder.btnReOrder.setOnClickListener{
            orderHistoryCustomClick.reOrder()
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class OrderHistoryViewModel(view : View) : RecyclerView.ViewHolder(view) {

        var item_name:TextView
        var price:TextView
        var txtOrderID:TextView
        var txtStatus:TextView
        var txtDeliveryDate:TextView
        var delete:ImageView
        var btnReOrder:TextView
        var qty:TextView
        var image:ImageView


        init {
            item_name= itemView.findViewById(R.id.item_name)
            price= itemView.findViewById(R.id.price)
            txtOrderID= itemView.findViewById(R.id.txtOrderID)
            txtStatus= itemView.findViewById(R.id.txtStatus)
            txtDeliveryDate= itemView.findViewById(R.id.txtDeliveryDate)
            delete= itemView.findViewById(R.id.cross_button)
            btnReOrder= itemView.findViewById(R.id.btnReOrder)
            qty= itemView.findViewById(R.id.qty)
            image= itemView.findViewById(R.id.image)


        }

    }

}