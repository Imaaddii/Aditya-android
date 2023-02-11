package com.exobe.Activities

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.OnServiceDealAdaptor
import com.exobe.Adaptor.dealsforcustomerAdaptor
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.DealsForCustomer
import com.exobe.customClicks.subserviceClick
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.customerdealsDocs
import com.exobe.entity.Response.customerdeals_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast

class Customers_Deals(
    var flag: String,
    var flagDeals: String,
    var s: String,
    var titletag: String,
    var s1: String
) : Fragment(),
    DealsForCustomer, subserviceClick, ApiResponseListener<customerdeals_response> {
    lateinit var DealsRecycler: RecyclerView
    lateinit var OnServiceDealsRecycler: RecyclerView
    lateinit var adapter1: dealsforcustomerAdaptor
    lateinit var onServiceDealAdaptor: OnServiceDealAdaptor
    lateinit var back_customer: ImageView
    var itemList: ArrayList<customerdealsDocs> = ArrayList()
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
//        return inflater.inflate(R.layout.fragment_retailer_homepage, container, false)

        var view = inflater.inflate(R.layout.activity_deals, container, false)
        mContext = activity?.applicationContext!!

        DealsRecycler = view.findViewById(R.id.DealsRecycler)
        OnServiceDealsRecycler = view.findViewById(R.id.OnServiceDealsRecycler)
        back_customer = view.findViewById(R.id.back_customer)
        if (!s.equals("service")) {
            MenuClick = activity?.findViewById(R.id.MenuClick)!!
            mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
            mainHeader!!.visibility = View.VISIBLE
            setToolbar()
            back!!.setOnClickListener {
                fragmentManager?.popBackStack()

            }
            if (flag.equals("Customer")) {
                back!!.visibility = View.VISIBLE
                MenuClick!!.visibility = View.GONE
            } else {
                MenuClick!!.visibility = View.VISIBLE
                back!!.visibility = View.GONE
            }

        }

        if (flagDeals.equals("onService")) {
            DealsRecycler.visibility = View.GONE
            OnServiceDealsRecycler.visibility = View.VISIBLE
            setadapterservice()

        } else {

            DealsRecycler.visibility = View.VISIBLE
            OnServiceDealsRecycler.visibility = View.GONE
            setadapter(itemList)
        }

        CustomerDealApi()


        return view
    }

    fun setadapterservice() {
        OnServiceDealsRecycler.layoutManager = GridLayoutManager(mContext, 2)
        onServiceDealAdaptor = OnServiceDealAdaptor(mContext, this, s)
        OnServiceDealsRecycler.adapter = onServiceDealAdaptor
    }

    fun setadapter(data: ArrayList<customerdealsDocs>) {
        DealsRecycler.layoutManager = GridLayoutManager(mContext, 2)
        adapter1 = dealsforcustomerAdaptor(mContext, data, flag, this)
        DealsRecycler.adapter = adapter1
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

        title!!.setText(titletag)


    }

    override fun click(flag: String, flag1: Boolean, id: String) {
        val bundle = Bundle()
        bundle.putString("flag", flag)
        bundle.putBoolean("flag1", flag1)
        val fragobj = ViewAddDeals()
        fragobj.setArguments(bundle)

        fragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, fragobj, "viewAddDeals")?.addToBackStack(null)
            ?.commit()

    }

    override fun subservice(flag: String) {
        if (flag.equals("service")) {
            fragmentManager?.beginTransaction()
                ?.replace(
                    R.id.service_main_container,
                    subservices_fragment(flag),
                    "subservices_fragment"
                )?.addToBackStack(null)
                ?.commit()
        } else {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, subservices_fragment(flag), "subservices_fragment")
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    fun CustomerDealApi() {
        if (androidextention.isOnline(mContext)) {
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<customerdeals_response> =
                ApiCallBack<customerdeals_response>(this, "CustomerDealApi", mContext)
            try {
                serviceManager.customerdealsListApi(callBack)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            diasplay_toast("Please check your internet connection!")
        }
    }


    override fun onApiSuccess(response: customerdeals_response, apiName: String?) {
        if (response.responseCode == 200) {
            itemList = response.result!!.docs as ArrayList<customerdealsDocs>
            setadapter(itemList)

        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
    }


}