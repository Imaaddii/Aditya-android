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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Activities.CategoryItem
import com.exobe.Adapter.CategoryAdpter
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.SetTitles
import com.exobe.customClicks.categorynameclick
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.CategoryList_response
import com.exobe.entity.Response.Docs
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast


class Category(var setTitles: SetTitles) : Fragment(), categorynameclick,
    ApiResponseListener<CategoryList_response> {

    lateinit var recyclerViewProduct: RecyclerView
    lateinit var ProductLatestAdapter: CategoryAdpter
    lateinit var mContext: Context
    var latestProductList: ArrayList<Docs> = ArrayList()

    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
//    lateinit var mShimmerViewContainer: ShimmerFrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        setToolbar()
        recyclerViewProduct = view.findViewById(R.id.recyclerViewProduct)
//        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container)!!

        mContext = activity?.applicationContext!!
        setTitles.title("Category")


        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE
        CategoryListApi()
        return view
    }

    override fun categoryname(_id: String?,categoryname: String) {

        val bundle = Bundle()
        bundle.putString("id",_id)
        bundle.putString("name",categoryname)
        val fragobj = CategoryItem()
        fragobj.setArguments(bundle)
        fragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, fragobj, "categoryItem")?.addToBackStack(null)
            ?.commit()
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
        greyBellImageView.visibility = View.VISIBLE
        title.setText("Category")

    }

    fun setAdaptor(latestProductList: ArrayList<Docs>) {

        recyclerViewProduct.layoutManager = GridLayoutManager(context, 4)
        ProductLatestAdapter = CategoryAdpter(activity as Context, latestProductList, this)
        recyclerViewProduct.adapter = ProductLatestAdapter

    }

    fun CategoryListApi() {
        if (androidextention.isOnline(mContext)) {
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<CategoryList_response> =
                ApiCallBack<CategoryList_response>(this, "CategoryListApi", mContext)
            try {
                serviceManager.listCategoryApi(callBack)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }

    }

    override fun onApiSuccess(response: CategoryList_response, apiName: String?) {
//        mShimmerViewContainer.stopShimmerAnimation();
        if(response.responseCode==200){
            latestProductList= response.result!!.docs!!
            setAdaptor(latestProductList)

        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
//        mShimmerViewContainer.stopShimmerAnimation();
    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
//        mShimmerViewContainer.stopShimmerAnimation();
    }

    override fun onResume() {
        super.onResume()
//        mShimmerViewContainer.startShimmerAnimation();

    }

    override fun onPause() {
        super.onPause()
//        mShimmerViewContainer.stopShimmerAnimation();

    }


}