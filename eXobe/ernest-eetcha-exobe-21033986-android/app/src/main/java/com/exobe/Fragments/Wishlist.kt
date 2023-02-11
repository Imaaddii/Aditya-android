package com.exobe.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Activities.Product_View
import com.exobe.Adapter.WishListAdpter
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.wishlistcustomclick
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.*
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder


class Wishlist(var flag: String) : Fragment(), CustomeClick, wishlistcustomclick {

    lateinit var Wishlist_Recyclerview: RecyclerView
    lateinit var mContext: Context
    var Productdata: ArrayList<WishlistResult> = ArrayList()
    lateinit var productAdpter: WishListAdpter

    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_wishlist, container, false)
        mContext = activity?.applicationContext!!
        setToolbar()
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE
        Wishlist_Recyclerview = view.findViewById(R.id.Wishlist_Recyclerview)


        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE
        wishListApi()
        return view
    }

    override fun click(_id: String?) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, Product_View(),"productView")?.addToBackStack(null)?.commit()
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

        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("Wishlist")

    }
    fun wishListApi() {

        if (androidextention.isOnline(mContext)) {
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<WishlistResponse> =
                ApiCallBack<WishlistResponse>(object :
                    ApiResponseListener<WishlistResponse> {
                    override fun onApiSuccess(
                        response: WishlistResponse,
                        apiName: String?
                    ) {
                        if (response.responseCode == 200) {
                           var data = response.result as ArrayList<WishlistResult>
                            setApapter(data)
                        }

                    }

                    override fun onApiErrorBody(response: String, apiName: String?) {

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
                    }

                }, "WishlistApi", mContext)



            try {
                serviceManager.WishListApi(callBack)

            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }

    fun setApapter(Productdata:ArrayList<WishlistResult>){
        Wishlist_Recyclerview.layoutManager = GridLayoutManager(activity, 2)
        productAdpter = WishListAdpter(requireContext(), Productdata, this,flag,resources,this)
        Wishlist_Recyclerview.adapter = productAdpter

    }

    override fun wishlist(_id: String?) {
        Addtowishlist(_id!!)
    }
    fun Addtowishlist(productId:String) {

        if (androidextention.isOnline(mContext)) {
            androidextention.showProgressDialog(mContext)
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<WishlistResponse> =
                ApiCallBack<WishlistResponse>(object : ApiResponseListener<WishlistResponse> {
                    override fun onApiSuccess(response: WishlistResponse, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)
                        if (response.responseCode == 200) {

                            var data = response.result as ArrayList<WishlistResult>
                            setApapter(data)

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

                }, "Addtowishlist", mContext)


            try {
                serviceManager.addTowishlistApi(callBack, productId)

            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }

}