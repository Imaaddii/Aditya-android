package com.exobe.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Activities.Add_Address
import com.exobe.Activities.ChooseDeliveryAddress
import com.exobe.Activities.OrderReview
import com.exobe.ModelClass.Name
import com.exobe.R
import com.exobe.customClicks.delete
import com.exobe.entity.Response.AddresslistDocs
import com.exobe.entity.Response.AddresslistResponse
import com.exobe.entity.Response.AddresslistResult
import org.w3c.dom.Text

class ChooseDeliveryAdapter(
    var context: Context,
    var itemList: ArrayList<AddresslistDocs>,
    var delete: delete,
    var fragmentManager: FragmentManager?,
    var flag: String

) : RecyclerView.Adapter<ChooseDeliveryAdapter.ViewHolder>() {
    var count = 0
    var mSelectedItem = -1


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChooseDeliveryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.delivery_address_modallayout, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ChooseDeliveryAdapter.ViewHolder, position: Int) {
        val userData = itemList[position]
        holder.firstname.setText(userData.firstName)
        holder.secondname.setText(userData.lastName)
        holder.address.setText(userData.address)
        holder.phonenumber.setText(userData.mobileNumber.toString())
        holder.pincode.setText(userData.zipCode.toString())
        holder.city.setText(userData.city)

        holder.edit.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.FrameLayout,
                Add_Address("Edit"), "addAddress"
            )?.addToBackStack(null)?.commit()

        }
        holder.radioButton.setChecked(position == mSelectedItem)

        holder.chooseDelivery.setOnClickListener {
            mSelectedItem = position
            notifyDataSetChanged()
            fragmentManager?.beginTransaction()?.replace(
                R.id.FrameLayout,
                OrderReview(), "overView"
            )?.addToBackStack(null)?.commit()
        }


            if(flag.equals("setting_address")){

                holder.radioButton.visibility=  View.GONE
                holder.chooseDelivery.isEnabled= false

            }

              else{
                holder.radioButton.setOnClickListener {
                    mSelectedItem = position
                    notifyDataSetChanged()
                    fragmentManager?.beginTransaction()?.replace(
                        R.id.FrameLayout,
                        OrderReview(), "overView"
                    )?.addToBackStack(null)?.commit()
                }
            }


        holder.delete.setOnClickListener {

            delete.delete()
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var firstname: TextView
        var secondname: TextView
        var edit: ImageView
        var chooseDelivery: LinearLayout
        var radioButton: RadioButton
        var delete: ImageView
        var address: TextView
        var pincode: TextView
        var phonenumber: TextView
        var city: TextView


        init {
            firstname = itemView.findViewById(R.id.firstname)
            secondname = itemView.findViewById(R.id.secondname)
            address = itemView.findViewById(R.id.address)
            pincode = itemView.findViewById(R.id.pincode)
            phonenumber = itemView.findViewById(R.id.phonenumber)
            edit = itemView.findViewById(R.id.editaddress)
            chooseDelivery = itemView.findViewById(R.id.chooseDelivery)
            radioButton = itemView.findViewById(R.id.radioButton)
            delete = itemView.findViewById(R.id.delete)
            city = itemView.findViewById(R.id.city)


        }
    }


    override fun getItemCount(): Int {
        return itemList.size
    }


}