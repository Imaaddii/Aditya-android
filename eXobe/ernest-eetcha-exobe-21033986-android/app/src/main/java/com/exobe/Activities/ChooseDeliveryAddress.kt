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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.ChooseDeliveryAdapter
import com.exobe.ModelClass.Name
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.delete
import com.exobe.dialogs.DeleteDialog
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.*
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder
import java.util.*

class ChooseDeliveryAddress : Fragment() , delete ,ApiResponseListener<AddresslistResponse>{
    lateinit var chooseDelivery_address:RecyclerView
    lateinit var adapter: ChooseDeliveryAdapter
    lateinit var add: TextView
    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var BackButton:ImageView
    lateinit var mContext : Context
    lateinit var mainHeader : RelativeLayout
    var data: ArrayList<AddresslistDocs> = ArrayList()

    var flag:String=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_retailer_homepage, container, false)

        var view = inflater.inflate(R.layout.activity_choose_delivery_address, container, false)
        mContext = activity?.applicationContext!!
        chooseDelivery_address=view.findViewById(R.id.chooseDelivery_address)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        add=view.findViewById(R.id.add)
        BackButton=view.findViewById(R.id.BackButton)
        setToolbar()

        if (requireArguments().getString("flag") != null) {
            flag = requireArguments().getString("flag").toString()
        }

        if (flag.equals("setting_address")) {
            title!!.setText("Address")
            back!!.visibility = View.VISIBLE
            mainHeader.visibility = View.VISIBLE


        }
        else
        {
            back!!.visibility = View.VISIBLE
            mainHeader.visibility = View.VISIBLE
        }
        BackButton.setOnClickListener {
//            finish()
        }

        add.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.FrameLayout,
                Add_Address(""), "addAddress"
            )?.addToBackStack(null)?.commit()
//            startActivity(Intent(mContext, Add_Address::class.java))

        }

        back.setOnClickListener{
            fragmentManager?.popBackStack();
        }

        choosedeliveryApi(

        )
        return view
    }

    override fun delete() {
        fragmentManager?.let { DeleteDialog().show(it, "MyCustomFragment") }
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
        title.setText("Choose Delivery Address")
    }

    fun setAdapater(data:ArrayList<AddresslistDocs>){
        chooseDelivery_address.layoutManager = LinearLayoutManager(mContext)
        chooseDelivery_address.adapter = ChooseDeliveryAdapter(mContext,data,this, fragmentManager,flag)
    }

    fun choosedeliveryApi() {
        if (androidextention.isOnline(mContext)) {
            androidextention.showProgressDialog(activity)
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<AddresslistResponse> =
                ApiCallBack<AddresslistResponse>(
                    this,
                    "choosedeliveryApi",
                    mContext
                )

            try {
                serviceManager.addressListApi(callBack)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }

    }

    override fun onApiSuccess(response: AddresslistResponse, apiName: String?) {
        androidextention.disMissProgressDialog(activity)
        if (response.responseCode==200){
            data = response.result!!.docs as ArrayList<AddresslistDocs>
            setAdapater(data)
        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
        androidextention.disMissProgressDialog(activity)

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
        androidextention.disMissProgressDialog(activity)

    }


}