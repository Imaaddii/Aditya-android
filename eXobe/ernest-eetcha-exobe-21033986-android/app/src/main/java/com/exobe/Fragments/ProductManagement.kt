package com.exobe.Fragments

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
import com.exobe.Adaptor.ProductManagement_Adapter
import com.exobe.Fragments.retailr.ProductDetails
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.CustomeClick2
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.ProductListDocs
import com.exobe.entity.Response.ProductList_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder


class ProductManagement : Fragment() , CustomeClick, CustomeClick2,ApiResponseListener<ProductList_response>{
    lateinit var recyclerView: RecyclerView
    lateinit var addProduct: TextView
    lateinit var mContext:Context
    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var deals: TextView
    lateinit var mainHeader: RelativeLayout
    var data : ArrayList<ProductListDocs> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_product_management, container, false)
        setToolbar()
        recyclerView = view.findViewById(R.id.ProductManagement_recycler)
        addProduct = view.findViewById(R.id.add_product)
        deals = view.findViewById(R.id.deals)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE
        mContext=activity?.applicationContext!!




        deals.setOnClickListener{

            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, DealsManagement("") , "dealManagement")?.addToBackStack(null)
                ?.commit()
        }

        addProduct.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("flag", "Add Product")
            val fragobj = add_products()
            fragobj.setArguments(bundle)

            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, fragobj , "addProducts")?.addToBackStack(null)
                ?.commit()
        }

        seeallproductsApi()
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
        back.visibility = View.GONE

        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("Product Management")
    }

    override fun click(_id: String?) {
        val bundle = Bundle()
        bundle.putString("flag", "Edit Product")
        val fragobj = add_products()
        fragobj.setArguments(bundle)

        fragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, fragobj , "addProducts")?.addToBackStack(null)
            ?.commit()
    }

    override fun click2() {
        val bundle = Bundle()
        bundle.putString("flag", "Product Details")
        val fragobj = ProductDetails()
        fragobj.setArguments(bundle)

        fragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, fragobj , "productView")?.addToBackStack(null)
            ?.commit()

    }
    fun seeallproductsApi() {
        if (androidextention.isOnline(mContext)) {
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<ProductList_response> =
                ApiCallBack<ProductList_response>(
                    this,
                    "seeallproductsApi",
                    mContext
                )

            try {
                serviceManager.ProductListApi(callBack)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }

    }

    override fun onApiSuccess(response: ProductList_response, apiName: String?) {
        if (response.responseCode==200){
            data = response.result!!.docs as ArrayList<ProductListDocs>
            setAdapater(data)
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

    fun setAdapater(data:ArrayList<ProductListDocs>) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        var adapter = ProductManagement_Adapter(activity as Context, this, this,"product")
        recyclerView.adapter = adapter
    }
}