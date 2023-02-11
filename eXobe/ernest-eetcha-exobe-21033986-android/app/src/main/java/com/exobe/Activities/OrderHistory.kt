package com.exobe.Activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.OrderHistoryAdapter
import com.exobe.Model.OrderHistoryModel
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.OrderHistoryCustomClick
import com.exobe.customClicks.delete
import com.exobe.dialogs.CommonDeleteDialogBox
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.PendingOrderRetailerDocs
import com.exobe.entity.Response.PendingOrderRetailerResponse
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject

class OrderHistory(var flagSide: String) : Fragment(), OrderHistoryCustomClick {


    // intializations
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : OrderHistoryAdapter
    lateinit var backOH : ImageView
    lateinit var btnReOrder : Button
    var flag=""
    lateinit var ivgroup: TextView
    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    var usertype=""
    lateinit var mContext:Context
    var data: ArrayList<PendingOrderRetailerDocs> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_order_history, container, false)

        recyclerView= view.findViewById(R.id.recyclerViewOH)
        setToolbar()
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE
        usertype="RETAILER"
        mContext=activity?.applicationContext!!


        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }


        if (flagSide.equals("SideMenu")) {
            MenuClick.visibility = View.VISIBLE
            back.visibility = View.GONE
        } else {
            back.visibility = View.VISIBLE
            MenuClick.visibility = View.GONE
        }

        PendingOrderAPI()



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
        back.visibility = View.VISIBLE

        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("Order History")
    }

    override fun delete() {
        fragmentManager?.let { CommonDeleteDialogBox().show(it, "MyCustomFragment") }
    }

    override fun reOrder() {

        fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, MyCartActivity(""),"addCart")
            ?.addToBackStack(null)?.commit()

    }
    fun PendingOrderAPI() {
        if (androidextention.isOnline(mContext)) {
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<PendingOrderRetailerResponse> =
                ApiCallBack<PendingOrderRetailerResponse>(object :
                    ApiResponseListener<PendingOrderRetailerResponse> {
                    override fun onApiSuccess(
                        response: PendingOrderRetailerResponse,
                        apiName: String?
                    ) {
                        androidextention.disMissProgressDialog(mContext)
                        if (response.responseCode == 200) {
                            var data = response.result?.docs as ArrayList<PendingOrderRetailerDocs>
                            setadapter(data)
                        }

                    }

                    override fun onApiErrorBody(response: String, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)

                        val gson = GsonBuilder().create()
                        var pojo = response_modal_class()

                        try {
                            pojo = gson.fromJson(response, pojo::class.java)
                            androidextention.alertBox(pojo.responseMessage, requireContext())

                        } catch (e: Exception) {
                            // handle failure at error parse
                        }
                    }

                    override fun onApiFailure(failureMessage: String?, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)
                    }

                }, "PendingOrderAPI", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("userType", usertype)


            try {
                serviceManager.orderListapi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }
    fun setadapter(data:ArrayList<PendingOrderRetailerDocs>){

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = OrderHistoryAdapter(requireContext(), data, this)
        recyclerView.adapter = adapter


    }

}