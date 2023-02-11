package com.exobe.Fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Activities.AddYourServices
import com.exobe.Adaptor.ServicesAdapter_SP
import com.exobe.ModelClass.ServicesModelClass
import com.exobe.R
import com.exobe.androidextention
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.ServiceListDocs
import com.exobe.entity.Response.ServiceList_Response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast

class ServicesFragment_SP : Fragment(),ApiResponseListener<ServiceList_Response> {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter : ServicesAdapter_SP
    lateinit var ServicesFragment_BTN : Button
    lateinit var mContext: Context

    var itemList : ArrayList<ServiceListDocs> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.servicesfragment_sp, container, false)
        mContext = activity?.applicationContext!!

        recyclerView = view.findViewById(R.id.serviceAvailableRecycler_SP)
        ServicesFragment_BTN = view.findViewById(R.id.ServicesFragment_BTN)

        ServicesFragment_BTN.setOnClickListener {
            val intent = Intent(context, AddYourServices::class.java)
            startActivity(intent)
        }

        ServiceListApi()


        return view
    }
    fun setAdpater(itemList:ArrayList<ServiceListDocs>){
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        adapter = ServicesAdapter_SP(activity as Context, itemList)
        recyclerView.adapter = adapter

    }
    fun ServiceListApi() {
        if (androidextention.isOnline(mContext)) {
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<ServiceList_Response> =
                ApiCallBack<ServiceList_Response>(this, "ServiceListApi", mContext)
            try {
                serviceManager.serviceListApi(callBack)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }

    }

    override fun onApiSuccess(response: ServiceList_Response, apiName: String?) {
//        mShimmerViewContainer.stopShimmerAnimation();
        if (response.responseCode == 200) {
            itemList = response.result!!.docs as ArrayList<ServiceListDocs>
            setAdpater(itemList)
        }
    }
    override fun onApiErrorBody(response: String, apiName: String?) {
    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
    }


}