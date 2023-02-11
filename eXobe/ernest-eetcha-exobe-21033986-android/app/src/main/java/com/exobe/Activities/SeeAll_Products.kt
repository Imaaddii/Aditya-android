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
import com.exobe.Adapter.CategoryItemAdapter
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.ProductListDocs
import com.exobe.entity.Response.ProductList_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder

class SeeAll_Products : Fragment(), CustomeClick ,ApiResponseListener<ProductList_response>{

    lateinit var ItemCategory:RecyclerView
    lateinit var adpter: CategoryItemAdapter
    lateinit var imageView2: ImageView

    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout

    var data : ArrayList<ProductListDocs> = ArrayList()
    lateinit var mContext :Context


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_see_all_products, container, false)
        mContext = activity?.applicationContext!!
        setToolbar()
        ItemCategory= view.findViewById(R.id.ItemCategory)
        imageView2= view.findViewById(R.id.imageView_back)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE

        imageView2.setOnClickListener {
//            finish()
        }


        filter.setOnClickListener {

            val popupMenu = PopupMenu(requireContext(), filter)

            popupMenu.getMenuInflater().inflate(R.menu.filter_menu, popupMenu.getMenu())
            popupMenu.setOnMenuItemClickListener { menuItem -> // Toast message on menu item clicked
                Toast.makeText(
                    requireContext(),
                    "You Clicked " + menuItem.getTitle(),
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            popupMenu.show()
        }

        cart.setOnClickListener{
            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, MyCartActivity(""),"addCart")?.addToBackStack(null)
                ?.commit()
        }

        back.setOnClickListener{
            fragmentManager?.popBackStack()
        }


        ItemCategory.layoutManager = GridLayoutManager(mContext, 2)
        adpter = CategoryItemAdapter(mContext, data, this)
        ItemCategory.adapter = adpter

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
        cart.visibility = View.VISIBLE
        filter.visibility = View.VISIBLE
        back.visibility = View.VISIBLE

        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("Products")

    }

    override fun click(_id: String?) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, Product_View(),"productView")?.addToBackStack(null)?.commit()
    }
    fun setAdapater(data:ArrayList<ProductListDocs>) {

        ItemCategory.layoutManager = GridLayoutManager(mContext, 2)
        adpter = CategoryItemAdapter(mContext, data, this)
        ItemCategory.adapter = adpter

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



}