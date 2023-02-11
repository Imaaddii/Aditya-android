package com.exobe.Adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Activities.AfterRequestedServiceDetails
import com.exobe.Activities.After_Request_accepted
import com.exobe.ModelClass.ViewServiceList_modelclass
import com.exobe.R


class ViewServiceList_Adaptor (val context: Context, val itemList: ArrayList<ViewServiceList_modelclass>)
    : RecyclerView.Adapter<ViewServiceList_Adaptor.ViewHolder>() {

    var flag1 = false

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewServiceList_Adaptor.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_service_list, parent, false)
        return ViewServiceList_Adaptor.ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewServiceList_Adaptor.ViewHolder, position: Int) {
        val userData =itemList[position]
        holder.statusApproved.text = userData.statusApproved
        holder.meilleurService.text = userData.meilleurService
        holder.rate_tv.text = userData.rate_tv
        holder.houseCleaning.text = userData.houseCleaning
        holder.yearsBuisness.text = userData.yearsBuisness
        holder.newDelhi.text = userData.newDelhi

        if(holder.statusApproved.text == "Accepted"){

            holder.llLayout.setOnClickListener{
                Intent(context, After_Request_accepted::class.java).also {
                    context.startActivity(it)
                }
            }

        }


        if (holder.statusApproved.text == "Pending") {
            holder.statusApproved.setTextColor(context.resources.getColor(R.color.red))

            holder.llLayout.setOnClickListener{
                Intent(context, AfterRequestedServiceDetails::class.java).also {
                    context.startActivity(it)
                }
            }
        }



        }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var meilleurService: TextView
        var rate_tv: TextView
        var houseCleaning: TextView
        var yearsBuisness: TextView
        var newDelhi: TextView
        var statusApproved: TextView
        var llLayout: LinearLayout

        init {
            meilleurService = itemView.findViewById(R.id.meilleurService)
            rate_tv = itemView.findViewById(R.id.rate_tv)
            houseCleaning = itemView.findViewById(R.id.houseCleaning)
            yearsBuisness = itemView.findViewById(R.id.yearsBuisness)
            newDelhi = itemView.findViewById(R.id.newDelhi)
            statusApproved = itemView.findViewById(R.id.statusApproved)
            llLayout = itemView.findViewById(R.id.llLayout)






        }
    }
}