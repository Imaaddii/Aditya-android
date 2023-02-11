package com.exobe.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.exobe.Adaptor.MyAdapter
import com.exobe.Fragments.retailr.RetailerOderDetails
import com.exobe.R
import com.exobe.customClicks.CustomeClick
import com.google.android.material.tabs.TabLayout


class OrderManagement : Fragment() , CustomeClick{
    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var mainHeader: RelativeLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view =  inflater.inflate(R.layout.fragment_order_management, container, false)


        setToolbar()
        tabLayout = view.findViewById(R.id.tablayout)

        viewPager = view.findViewById(R.id.viewPager)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Pending"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Delivered"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE



        val adapter = MyAdapter(requireContext(), childFragmentManager,tabLayout!!.tabCount,this)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })


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
        cart.visibility = View.GONE
        filter.visibility = View.GONE
        back.visibility = View.GONE

        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("Order Management")
    }

    override fun click(_id: String?) {
        fragmentManager?.beginTransaction()?.replace(
            R.id.FrameLayout, RetailerOderDetails(),"retailerOrder"
        )?.addToBackStack(null)
            ?.commit()
    }

}