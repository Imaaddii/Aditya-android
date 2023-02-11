package com.exobe.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.PendingAdapter
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.PendingOrderRetailerDocs
import com.exobe.entity.Response.PendingOrderRetailerResponse
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject


class PendingOrder(var customeClick: CustomeClick) : Fragment(), CustomeClick {
    lateinit var recyclerView: RecyclerView
    lateinit var mContext: Context
    var usertype = ""
    var status = ""
    var data: ArrayList<PendingOrderRetailerDocs> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_pending_order, container, false)
        mContext = activity?.applicationContext!!
        recyclerView = view.findViewById(R.id.PendingRecycler)

        usertype = "RETAILER"
        status = "PENDING"

        PendingOrderAPI()
        return view
    }

    override fun click(_id: String?) {
        customeClick.click("")
    }

    fun setadapter(data: ArrayList<PendingOrderRetailerDocs>) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        var adapter = PendingAdapter(activity as Context, this,data)
        recyclerView.adapter = adapter
    }

    fun PendingOrderAPI() {

        if (androidextention.isOnline(mContext)) {
            androidextention.showProgressDialog(mContext)
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
                            data = response.result?.docs as ArrayList<PendingOrderRetailerDocs>
                            setadapter(data)
                        }

                    }

                    override fun onApiErrorBody(response: String, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)

                        val gson = GsonBuilder().create()
                        var pojo = response_modal_class()

                        try {
                            pojo = gson.fromJson(response, pojo::class.java)
                            androidextention.alertBox(pojo.responseMessage, mContext)

                        } catch (e: Exception) {
                            // handle failure at error parse
                        }
                    }

                    override fun onApiFailure(failureMessage: String?, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)
                    }

                }, "PendingOrder", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("userType", usertype)
            jsonObject.addProperty("statusType", status)


            try {
                serviceManager.orderListapi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }


}