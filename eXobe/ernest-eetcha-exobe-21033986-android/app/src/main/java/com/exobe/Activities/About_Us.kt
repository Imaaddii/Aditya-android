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
import com.exobe.R
import com.exobe.androidextention
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.StaticContentResponse
import com.exobe.entity.Response.StaticContentResult
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast

class About_Us : Fragment() {

    lateinit var ivgroup: TextView
    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var text : TextView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var mContext:Context
    var array:ArrayList<StaticContentResult>?=null
    var flag = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_about_us, container, false)
        mContext=activity?.applicationContext!!
        text=view.findViewById(R.id.text)
        if (requireArguments().getString("flag") != null) {
            flag = requireArguments().getString("flag").toString()

        }
        AboutusApi()

        if (flag.equals("services")) {

            title = activity?.findViewById(R.id.title)!!
            back = activity?.findViewById(R.id.back)!!
            title!!.setText("About Us")
            back!!.visibility = View.VISIBLE
            back!!.setOnClickListener {
                fragmentManager?.popBackStack()
            }
        }else {
            setToolbar()
            mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
            mainHeader.visibility = View.VISIBLE
            back.setOnClickListener {
                fragmentManager?.popBackStack()
            }
        }
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
        title.setText("About Us")
    }

    fun AboutusApi() {
        if (androidextention.isOnline(mContext)) {
            androidextention.showProgressDialog(activity)
            val serviceManager = ServiceManager(activity)
            val callBack: ApiCallBack<StaticContentResponse> =
                ApiCallBack<StaticContentResponse>(object :
                    ApiResponseListener<StaticContentResponse> {
                    override fun onApiSuccess(response: StaticContentResponse, apiName: String?) {
                        androidextention.disMissProgressDialog(activity)



                        if (response!!.responseCode == 200) {

                            text.text=response.result!!.description

                            try {

                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }

                    override fun onApiErrorBody(response: String, apiName: String?) {
                        androidextention.disMissProgressDialog(activity)

                    }

                    override fun onApiFailure(failureMessage: String?, apiName: String?) {
                        androidextention.disMissProgressDialog(activity)

                    }


                }, "AboutusApi", mContext)

            try {
                serviceManager.staticDataApi(callBack,"aboutUs")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            diasplay_toast("Please check your internet connection!")
        }
    }



}