package com.exobe.Activities

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.OnServiceDealAdaptor
import com.exobe.Adaptor.subservice_adaptor
import com.exobe.ModelClass.DealForCustomerModelClass
import com.exobe.R

class subservices_fragment(var flag: String) : Fragment() {

    lateinit var DealsRecycler: RecyclerView
    lateinit var adapter1: subservice_adaptor
    val itemList: ArrayList<DealForCustomerModelClass> = ArrayList()
    lateinit var mContext: Context
    var title: TextView? = null
    var cart: ImageView? = null
    var filter: ImageView? = null
    var back: ImageView? = null
    var ProductImageView: ImageView? = null
    var DealsImageView: ImageView? = null
    var greyBellImageView: ImageView? = null
    var MenuClick: ImageView? = null
    var mainHeader: RelativeLayout? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_subservices_fragment, container, false)
        DealsRecycler=view.findViewById(R.id.recyclerview)
        mContext = activity?.applicationContext!!
         if(!flag.equals("service")){
             setToolbar()
         }

        itemList.add(
            DealForCustomerModelClass(
                "R899.00",
                "R400.00",
                "10/05/2022",
                R.drawable.img_15,
                "12:50:00",
                "02:00:00 hr"
            )
        )


        DealsRecycler.layoutManager = GridLayoutManager(mContext, 2)
        adapter1 = subservice_adaptor(mContext, itemList, "",this)
        DealsRecycler.adapter = adapter1


        return view
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
        cart!!.visibility = View.GONE
        filter!!.visibility = View.GONE
        MenuClick!!.visibility = View.GONE
        back!!.visibility = View.VISIBLE
        ProductImageView!!.visibility = View.GONE
        DealsImageView!!.visibility = View.GONE
        greyBellImageView!!.visibility = View.GONE
        title!!.setText("Deals on electrician")
    }


}