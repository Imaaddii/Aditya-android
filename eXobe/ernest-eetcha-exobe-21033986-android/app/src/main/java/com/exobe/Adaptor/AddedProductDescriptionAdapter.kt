package com.exobe.Adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.CustomerOrderView
import com.exobe.ModelClass.AddedProductDescriptionModelClass
import com.exobe.R

class AddedProductDescriptionAdapter (val context: Context, val itemList: ArrayList<AddedProductDescriptionModelClass>): RecyclerView.Adapter<AddedProductDescriptionAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.added_product_description_modellayout,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userData = itemList[position]
        holder.customerName.text = userData.customerName
        holder.orderDate.text = userData.orderDate
        holder.phoneNumber.text = userData.phoneNumber
        holder.button.text = userData.button

        holder.button.setOnClickListener {

            val intent = Intent(context, CustomerOrderView::class.java)
            context.startActivity(intent)

//            Intent(context, CustomerOrderView::class.java ).also{
//                context.startActivity(it)
//            }
        }




    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var customerName: TextView
        var orderDate: TextView
        var phoneNumber: TextView
        var button: TextView





        init {
            customerName=itemView.findViewById(R.id.customerName)
            orderDate=itemView.findViewById(R.id.orderDate)
            phoneNumber=itemView.findViewById(R.id.phoneNumber)
            button=itemView.findViewById(R.id.button)



        }
    }


}