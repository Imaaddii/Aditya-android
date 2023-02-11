package com.fram.farmserv.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fram.farmserv.ModalClass.MyFarmerListModelClass
import com.fram.farmserv.R

class MyFarmerListAdapter (val context: Context, val itemList : ArrayList<MyFarmerListModelClass>):
    RecyclerView.Adapter<MyFarmerListAdapter.MyFarmerListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFarmerListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_my_farmer_list, parent, false)
        return MyFarmerListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyFarmerListViewHolder, position: Int) {

        val userData = itemList[position]

        holder.txtSrNo.text = userData.serial_no.toString()
        holder.txtName.text = userData.name
        holder.txtAddress.text = userData.address
        holder.txtMobileNumber.text = userData.mobile_number
        holder.txtPurchase.text = userData.purchase_quantity
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class MyFarmerListViewHolder(val view : View) : RecyclerView.ViewHolder(view) {

        val txtSrNo = view.findViewById<TextView>(R.id.txtSrNo)
        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtAddress = view.findViewById<TextView>(R.id.txtAddress)
        val txtMobileNumber = view.findViewById<TextView>(R.id.txtMobileNumber)
        val txtPurchase = view.findViewById<TextView>(R.id.txtPurchase)

    }
}