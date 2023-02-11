package com.exobe.Adaptor


import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.exobe.customClicks.DealsForCustomer
import com.exobe.entity.Response.customerdealsDocs
import com.exobe.util.DateFormat

class dealsforcustomerAdaptor (
    val context: Context,
    val itemList: ArrayList<customerdealsDocs>,
    var flag: String,
    var dealsForCustomer: DealsForCustomer,
    ): RecyclerView.Adapter<dealsforcustomerAdaptor.ViewHolder>() {

        var flag1 = false
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dealsforcustomerAdaptor.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.deal_for_customer_modallayout,parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: dealsforcustomerAdaptor.ViewHolder, position: Int) {
            val userData = itemList[position]
            holder.itemValue3.text = "$"+"${userData.dealPrice}"+".00"
            holder.date.text = DateFormat.dealsdate(userData.dealEndTime)
            holder.productname.text = userData.dealName
        holder.EXPTime.text =DateFormat.dealstime(userData.dealEndTime)
            Glide.with(context).load(userData.dealImage).into(holder.itemImage)
            if(SavedPrefManager.getStringPreferences(context, SavedPrefManager.priceTag).equals("Customer")) {
                holder.priceTag.setText("M.R.P: ")
            } else {
                holder.priceTag.setText("W.S.P: ")
            }
            holder.cardView.setOnClickListener {
            }
            holder.viewButton.setOnClickListener {
                dealsForCustomer.click("",false, userData._id!!)

            }

            holder.itemValue1.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG


            holder.heartFill.setOnClickListener {

                holder.heartFill.visibility = View.GONE
                holder.heartOutline.visibility = View.VISIBLE

            }
            holder.heartOutline.setOnClickListener {

                holder.heartFill.visibility = View.VISIBLE
                holder.heartOutline.visibility = View.GONE

            }

        }



        override fun getItemCount(): Int {
            return itemList.size
        }

        class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            var itemImage:ImageView
            var itemValue1:TextView
            var itemValue2:TextView
            var itemValue3:TextView
            var EXPTime:TextView
            var priceTag:TextView
            var EXPTimeIn:TextView
            var productname:TextView
            var date:TextView
            var cardView:CardView
            var heartFill:ImageView
            var heartOutline:ImageView
            var viewButton: LinearLayout

            init {
                itemImage=itemView.findViewById(R.id.item_image)
                itemValue1=itemView.findViewById(R.id.itemValue1)
                itemValue2=itemView.findViewById(R.id.itemValue2)
                date=itemView.findViewById(R.id.date)
                cardView = itemView.findViewById(R.id.dealForCustomerCardView)
                heartFill = itemView.findViewById(R.id.heartFill)
                heartOutline = itemView.findViewById(R.id.heartOutline)
                viewButton = itemView.findViewById(R.id.viewButton)
                itemValue3 = itemView.findViewById(R.id.itemValue3)
                EXPTime = itemView.findViewById(R.id.EXPTime)
                EXPTimeIn = itemView.findViewById(R.id.EXPTimeIn)
                priceTag =  itemView.findViewById(R.id.priceTag)
                productname =  itemView.findViewById(R.id.productname)


            }
        }
}