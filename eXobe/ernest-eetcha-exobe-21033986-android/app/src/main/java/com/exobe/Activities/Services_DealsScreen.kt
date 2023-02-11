package com.exobe.Activities

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.dealForServiceAdapter
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.DealsForCustomer
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.customerdealsDocs
import com.exobe.entity.Response.customerdeals_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast

class Services_DealsScreen(var flagSide: String) : Fragment(), DealsForCustomer, CustomeClick,
    ApiResponseListener<customerdeals_response> {

    lateinit var adapter1: dealForServiceAdapter
    lateinit var CustomerRecyclerView: RecyclerView
    lateinit var wholesellersRecyclerView: RecyclerView
    lateinit var addDealsButton: Button

    lateinit var AddDeals_ll: LinearLayout
    lateinit var BackServices:ImageView
    var itemList: ArrayList<customerdealsDocs> = ArrayList()
    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var mContext : Context





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_deals_for_customer_screen, container, false)

        mContext = activity?.applicationContext!!
        setToolbar()

        CustomerRecyclerView =view.findViewById(R.id.CustomerRecycler)
        addDealsButton = view.findViewById(R.id.addDealsButton)

        AddDeals_ll = view.findViewById(R.id.AddDeals_ll)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE
        if (flagSide.equals("SideMenu")) {
            back.visibility = View.GONE
            MenuClick.visibility = View.VISIBLE
        } else {
            MenuClick.visibility = View.GONE
            back.visibility = View.VISIBLE
        }

        CustomerDealApi(







        )

        return view


    }

    fun setadapter(data: ArrayList<customerdealsDocs>) {
        CustomerRecyclerView.layoutManager = GridLayoutManager(mContext, 2)
        adapter1 = dealForServiceAdapter(mContext, itemList, "", this)
        CustomerRecyclerView.adapter = adapter1

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

        MenuClick.visibility = View.VISIBLE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("Deals")
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

    override fun click(_id: String?) {

        val bundle = Bundle()
        bundle.putString("WholeSeller", "WholeSeller")
        val fragobj = ViewAddDeals()
        fragobj.setArguments(bundle)

        fragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, fragobj, "viewAddDeals")?.addToBackStack(null)
            ?.commit()
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