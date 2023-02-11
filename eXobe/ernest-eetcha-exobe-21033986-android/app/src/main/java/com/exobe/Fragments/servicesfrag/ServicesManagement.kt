package com.exobe.Fragments.servicesfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.exobe.Adaptor.servicesAdaptor.ServicesTabAdapter
import com.exobe.R
import com.exobe.customClicks.ServicesClick
import com.exobe.customClicks.servicedeleteclick
import com.exobe.customClicks.viewserviceclick
import com.google.android.material.tabs.TabLayout

class ServicesManagement : Fragment() , ServicesClick, viewserviceclick
{
    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var back : ImageView
    var MenuClick : ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =  inflater.inflate(R.layout.fragment_services_management, container, false)



        tabLayout = view.findViewById(R.id.tablayout)
        back = activity?.findViewById(R.id.back)!!
        title = activity?.findViewById(R.id.title)!!
        viewPager = view.findViewById(R.id.viewPager)
        MenuClick = activity?.findViewById(R.id.MenuClick)!!
        back.visibility = View.GONE
        MenuClick!!.visibility = View.VISIBLE

        title.setText("Services")
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Pending"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Completed"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL


        val adapter = ServicesTabAdapter(requireContext(), childFragmentManager,tabLayout!!.tabCount,this, this)
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


    override fun click(flag : String) {
        val bundle = Bundle()
        bundle.putString("flag", flag)
        val fragobj = ServiceViewFragment()
        fragobj.setArguments(bundle)
        fragmentManager?.beginTransaction()?.replace(
            R.id.service_main_container, fragobj,"service_view"
        )?.addToBackStack(null)
            ?.commit()
    }

    override fun viewservice() {
        val bundle = Bundle()
        bundle.putString("flag", "pending")
        val fragobj = ServiceViewFragment()
        fragobj.setArguments(bundle)
        fragmentManager?.beginTransaction()?.replace(
            R.id.service_main_container,  fragobj, "ServiceView"
        )?.addToBackStack(null)
            ?.commit()

    }

}