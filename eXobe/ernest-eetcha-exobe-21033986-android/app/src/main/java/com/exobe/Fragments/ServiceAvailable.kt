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
import com.exobe.Activities.ServicesAvailableListing
import com.exobe.Adaptor.ServicesAdapter
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.SetTitles
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.ServiceListDocs
import com.exobe.entity.Response.ServiceList_Response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.facebook.shimmer.ShimmerFrameLayout

class ServiceAvailable(var setTitles: SetTitles) : Fragment(),CustomeClick,ApiResponseListener<ServiceList_Response> {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter : ServicesAdapter
    var itemList : ArrayList<ServiceListDocs> = ArrayList()
    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var mContext: Context
    lateinit var mShimmerViewContainer: ShimmerFrameLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_service_available, container, false)

        mContext = activity?.applicationContext!!
        recyclerView = view.findViewById(R.id.serviceAvailableRecycler)
        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container)!!

        setToolbar()
        setTitles.title("Services")




        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE

        ServiceListApi()
        return view


    }

    override fun click(_id: String?) {
        fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, ServicesAvailableListing(),"ServicesAvailableListing")
        ?.addToBackStack(null)?.commit()
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
        title.setText("Services")

    }

    fun ServiceListApi() {
        if (androidextention.isOnline(mContext)) {
            mShimmerViewContainer.startShimmerAnimation();
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
        mShimmerViewContainer.stopShimmerAnimation();
        if (response.responseCode == 200) {
            itemList = response.result?.docs as ArrayList<ServiceListDocs>
            setAdpater(itemList)
        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
        mShimmerViewContainer.stopShimmerAnimation();

    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
        mShimmerViewContainer.stopShimmerAnimation();

    }
    fun setAdpater(itemList:ArrayList<ServiceListDocs>){
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        adapter = ServicesAdapter(requireContext(), itemList,this)
        recyclerView.adapter = adapter

    }
    override fun onResume() {
        super.onResume()
        mShimmerViewContainer.startShimmerAnimation();

    }

    override fun onPause() {
        super.onPause()
        mShimmerViewContainer.stopShimmerAnimation();

    }

}