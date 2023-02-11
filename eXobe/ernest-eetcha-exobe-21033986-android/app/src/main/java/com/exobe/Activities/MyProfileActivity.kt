package com.exobe.Activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.exobe.Fragments.profile_serviceprovider
import com.exobe.R
import com.exobe.androidextention
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.getprofile_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast

class MyProfileActivity : Fragment(),ApiResponseListener<getprofile_response> {

    lateinit var backButtonMyProfile: ImageView
    lateinit var btnEditProfile: Button
    lateinit var mContext: Context

    lateinit var title : TextView
    lateinit var FirstName_TextView : TextView
    lateinit var lastName_TextView : TextView
    lateinit var ContactNumber_TextView : TextView
    lateinit var PostCode_TextView : TextView
    lateinit var Address_tv : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    var flag = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_my_profile, container, false)
        mContext = activity?.applicationContext!!
        btnEditProfile= view.findViewById(R.id.btnEditProfile)
        FirstName_TextView= view.findViewById(R.id.FirstName_TextView)
        lastName_TextView= view.findViewById(R.id.lastName_TextView)
        ContactNumber_TextView= view.findViewById(R.id.ContactNumber_TextView)
        Address_tv= view.findViewById(R.id.Address_tv)
        PostCode_TextView= view.findViewById(R.id.PostCode_TextView)
        if (requireArguments().getString("flag") != null) {
            flag = requireArguments().getString("flag").toString()

        }
        if(flag.equals("services")) {

            title = activity?.findViewById(R.id.title)!!
            back = activity?.findViewById(R.id.back)!!
            title!!.setText("My profile")
            back!!.visibility = View.VISIBLE
            back!!.setOnClickListener {
                fragmentManager?.popBackStack()
            }

            btnEditProfile.setOnClickListener {
                fragmentManager?.beginTransaction()?.replace(R.id.service_main_container, profile_serviceprovider(),"profile_service_provider")?.addToBackStack("profile_service_provider")?.commit()

            }
        } else {
            setToolbar()
            mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
            mainHeader.visibility = View.VISIBLE

            btnEditProfile.setOnClickListener {
                startActivity(Intent(requireContext(), EditProfileActivity::class.java))

            }


            back.setOnClickListener {
                fragmentManager?.popBackStack()
            }
        }
        myprofileApi()
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
        title.setText("My profile")
    }



    fun myprofileApi() {
        if (androidextention.isOnline(mContext)) {
            androidextention.showProgressDialog(activity)
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<getprofile_response> =
                ApiCallBack<getprofile_response>(this, "myprofileApi", mContext)
            try {
                serviceManager.profileApi(callBack)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }

    }

    override fun onApiSuccess(response: getprofile_response, apiName: String?) {
        androidextention.disMissProgressDialog(activity)

        if (response.responseCode==200){
             FirstName_TextView.text=response.result?.firstName
            lastName_TextView.text=response.result?.lastName
            ContactNumber_TextView.text=response.result?.mobileNumber.toString()
           PostCode_TextView.text=response.result?.zipCode
        Address_tv.text=response.result?.address


        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
        androidextention.disMissProgressDialog(activity)

    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
        androidextention.disMissProgressDialog(activity)

    }


}