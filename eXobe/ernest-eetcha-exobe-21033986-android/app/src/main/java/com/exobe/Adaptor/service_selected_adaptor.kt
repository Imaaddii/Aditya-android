package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.ModelClass.cat
import com.exobe.ModelClass.service_request
import com.exobe.R

class service_selected_adaptor (
    val context: Context,
    val itemList: ArrayList<service_request>
    ): RecyclerView.Adapter<service_selected_adaptor.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.selected_service,parent, false)
            return ViewHolder(view)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val userData = itemList[position]
            holder.CategoryName.text= userData.name
            holder.pricetext.text= userData.price
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

            var CategoryName: TextView
            var pricetext: TextView
            init {

                CategoryName=itemView.findViewById(R.id.CategoryName)
                pricetext=itemView.findViewById(R.id.pricetext)

            }

        }




    }
