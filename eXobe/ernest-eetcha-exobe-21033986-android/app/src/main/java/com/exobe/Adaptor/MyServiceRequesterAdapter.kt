package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.ModelClass.MyServicerequestModelClass
import com.exobe.R
import com.exobe.androidextention


class MyServiceRequesterAdapter(var context: Context, var data: ArrayList<MyServicerequestModelClass>) :
    RecyclerView.Adapter<MyServiceRequesterAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var clientNotification = view.findViewById<TextView>(R.id.clientNotification)
        var serviceNotification = view.findViewById<TextView>(R.id.serviceNotification)
        var addressNotification = view.findViewById<TextView>(R.id.addressNotification)
        var btnAccept = view.findViewById<Button>(R.id.btnAccept)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.notification_recycler, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userData = data[position]

        holder.clientNotification.text = userData.clientNotification
        holder.serviceNotification.text = userData.serviceNotification
        holder.addressNotification.text = userData.addressNotification
        holder.btnAccept.setOnClickListener {

//            androidextention.notificationbox(context)
            androidextention.notificationserviceproviderDialog(context)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}




