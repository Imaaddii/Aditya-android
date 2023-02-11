package com.exobe.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.ModelClass.PaymentStatusModel
import com.exobe.R

class PaymentStatusAdapter (
    var context: Context,
    var data: ArrayList<PaymentStatusModel>
): RecyclerView.Adapter<PaymentStatusAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Define click listener for the ViewHolder's View.
        var txt1 = view.findViewById<TextView>(R.id.txt1)
        var txt2 = view.findViewById<TextView>(R.id.txt2)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentStatusAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.notification_modallayout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentStatusAdapter.ViewHolder, position: Int) {
        var userData = data[position]

        holder.txt1.text = userData.txt1
        holder.txt2.text = userData.txt2

        // Glide.with(context).load(userData.image).into(holder.image);
    }

    override fun getItemCount(): Int {
        return data.size
    }
}