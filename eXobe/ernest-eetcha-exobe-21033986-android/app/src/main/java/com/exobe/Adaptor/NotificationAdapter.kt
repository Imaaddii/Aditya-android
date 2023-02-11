package com.exobe.Adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.exobe.ModelClass.NotificationModel
import com.exobe.R
import com.exobe.customClicks.delete
import com.exobe.dialogs.CommonDeleteDialogBox

class NotificationAdapter (
    var context: Context,
    var data: ArrayList<NotificationModel>,
    var Deletee: delete
): RecyclerView.Adapter<NotificationAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Define click listener for the ViewHolder's View.
        var txt1 = view.findViewById<TextView>(R.id.txt1)
        var txt2 = view.findViewById<TextView>(R.id.txt2)
        var cross= view.findViewById<ImageView>(R.id.cross)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.notification_modallayout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationAdapter.ViewHolder, position: Int) {
        var userData = data[position]

        holder.txt1.text = userData.txt1
        holder.txt2.text = userData.txt2


        holder.cross.setOnClickListener {
            Deletee.delete()
        }

       // Glide.with(context).load(userData.image).into(holder.image);
    }

    override fun getItemCount(): Int {
        return data.size
    }
}