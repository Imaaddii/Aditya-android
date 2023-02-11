package com.exobe.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.NotificationAdapter
import com.exobe.ModelClass.NotificationModel
import com.exobe.R
import com.exobe.customClicks.delete
import com.exobe.dialogs.CommonDeleteDialogBox
import com.exobe.dialogs.productDialog

class Notification : Fragment(), delete {

    lateinit var My_RecyclerView: RecyclerView
    lateinit var Adapter: NotificationAdapter
    lateinit var back: ImageView
    var array: ArrayList<NotificationModel> = ArrayList()
    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var clearAll:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_notification, container, false)
        setToolbar()
        My_RecyclerView = view.findViewById(R.id.notification_recycler)
        clearAll = view.findViewById(R.id.clearAll)




        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )
        array.add(
            NotificationModel(
                "May 1st 2019",
                "Hi Max, your friend tony is facing some problem please help him."
            )
        )




        My_RecyclerView.layoutManager = LinearLayoutManager(requireContext())
        Adapter = NotificationAdapter(requireContext(), array, this)
        My_RecyclerView.adapter = Adapter


        clearAll.setOnClickListener{
            fragmentManager?.let {
                productDialog("Are you sure you want to \ndelete all the notifications", "Notification").show(
                    it,
                    "MyCustomFragment"
                )
            }
        }


        return view
    }

    override fun delete() {
        fragmentManager?.let { CommonDeleteDialogBox().show(it, "MyCustomFragment") }
    }


    fun setToolbar() {
        title = activity?.findViewById(R.id.PreLoginTitle_TextView2)!!
        cart = activity?.findViewById(R.id.cart_icon)!!
        filter = activity?.findViewById(R.id.filter_icon)!!
        back = activity?.findViewById(R.id.imageView_back)!!
        MenuClick = activity?.findViewById(R.id.MenuClick)!!
        ProductImageView = activity?.findViewById(R.id.Product_ImageView)!!
        DealsImageView = activity?.findViewById(R.id.Deals_ImageView)!!
        greyBellImageView = activity?.findViewById(R.id.greyBell_ImageView)!!

        back.visibility = View.VISIBLE

        cart.visibility = View.GONE
        filter.visibility = View.GONE
        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("Notifications")
    }

}
