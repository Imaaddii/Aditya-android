package com.exobe.Activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.ServicesAvaliableAdapter
import com.exobe.Adaptor.ServicesAvaliableAdapter_SP
import com.exobe.ModelClass.Services_Available
import com.exobe.R
import com.exobe.customClicks.CustomeClick

class ServicesAvailableListing : Fragment(), CustomeClick {
    lateinit var service_provider_RecyclerView: RecyclerView
    lateinit var Adapter: ServicesAvaliableAdapter
    lateinit var MenuClick: ImageView
    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var mainHeader: RelativeLayout
    var data = ArrayList<Services_Available>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_services_available_listing, container, false)
        setToolbar()
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        service_provider_RecyclerView = view.findViewById(R.id.service_provider_RecyclerView)

        mainHeader.visibility =View.VISIBLE


        data = ArrayList<Services_Available>()


        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        data.add(
            Services_Available(
                R.drawable.services_img!!,
                "House Cleaning Service",
                "7+ years in business",
                "New Delhi,Delhi"
            )
        )
        data.add(
            Services_Available(
                R.drawable.services_img!!,
                "House Cleaning Service",
                "7+ years in business",
                "New Delhi,Delhi"
            )
        )
        data.add(
            Services_Available(
                R.drawable.services_img!!,
                "House Cleaning Service",
                "7+ years in business",
                "New Delhi,Delhi"
            )
        )
        data.add(
            Services_Available(
                R.drawable.services_img!!,
                "House Cleaning Service",
                "7+ years in business",
                "New Delhi,Delhi"
            )
        )
        data.add(
            Services_Available(
                R.drawable.services_img!!,
                "House Cleaning Service",
                "7+ years in business",
                "New Delhi,Delhi"
            )
        )
        data.add(
            Services_Available(
                R.drawable.services_img!!,
                "House Cleaning Service",
                "7+ years in business",
                "New Delhi,Delhi"
            )
        )

        service_provider_RecyclerView.layoutManager = LinearLayoutManager(requireContext())
        service_provider_RecyclerView.adapter = ServicesAvaliableAdapter_SP(data, requireContext(), this)

        return view
    }

    override fun click(_id: String?) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, ServiceDetailPage("service"),"ServiceDetailPage")
            ?.addToBackStack(null)?.commit()

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
        back.visibility = View.VISIBLE

        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("Service Available")
    }


}
