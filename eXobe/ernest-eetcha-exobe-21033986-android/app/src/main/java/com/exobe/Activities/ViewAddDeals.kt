package com.exobe.Activities

import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.exobe.Adaptor.ImageSliderAdaptor
import com.exobe.Adaptor.dealviewimage_adaptor
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick4
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.viewdealsResult
import com.exobe.entity.Response.viewdeals_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import me.relex.circleindicator.CircleIndicator3

class ViewAddDeals : Fragment(), CustomeClick4 ,ApiResponseListener<viewdeals_response>{

    lateinit var offerValue1: TextView
    lateinit var Back: ImageView
    var images = ArrayList<viewdealsResult>()
    lateinit var viewAddDealsSubmit: Button
    lateinit var multi_image: ViewPager2
    lateinit var imageAdaptor: dealviewimage_adaptor
    lateinit var priceTag: TextView
    lateinit var deal_productname: TextView
    lateinit var viewAddDealsOfferValue1: TextView
    lateinit var price: TextView
    lateinit var tvDealID: TextView
    lateinit var tvDescription: TextView
    lateinit var tv_starttime: TextView
    lateinit var tv_endtime: TextView
    lateinit var indicator3: CircleIndicator3
    private val sliderHandler: Handler = Handler()
    var flag = ""
    var flag1 = ""
    var id = ""
    var WholeSellerFlag = ""
    lateinit var mainHeader: RelativeLayout

    lateinit var mContext: Context
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.activity_view_add_deals, container, false)
        mContext = activity?.applicationContext!!
        indicator3 = view.findViewById(R.id.indicator)
        multi_image = view.findViewById(R.id.multi_image)
        priceTag = view.findViewById(R.id.priceTag)
        deal_productname = view.findViewById(R.id.deal_productname)
        viewAddDealsOfferValue1 = view.findViewById(R.id.viewAddDealsOfferValue1)
        price = view.findViewById(R.id.price)
        tvDealID = view.findViewById(R.id.tvDealID)
        tvDescription = view.findViewById(R.id.tvDescription)
        tv_starttime = view.findViewById(R.id.tv_starttime)
        tv_endtime = view.findViewById(R.id.tv_endtime)
        offerValue1 = view.findViewById(R.id.viewAddDealsOfferValue1)
        Back = view.findViewById(R.id.viewAddDealsBack)
        viewAddDealsSubmit = view.findViewById(R.id.viewAddDealsSubmit)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.GONE


        offerValue1.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        if (requireArguments().getString("flag") != null || requireArguments().getString("flag1") != null) {
            flag = requireArguments().getString("flag").toString()
            flag1 = requireArguments().getBoolean("flag1").toString()
            WholeSellerFlag = requireArguments().getBoolean("WholeSeller").toString()
            if (flag.equals("Customer")) {
                viewAddDealsSubmit.setText("Add to cart")


            } else if (flag.equals("Retailer")) {
                viewAddDealsSubmit.setText("Delete")
            } else {

            }

            if (WholeSellerFlag.equals("WholeSeller")) {
                viewAddDealsSubmit.setText("Request For OFFER")
            }
        }

        if(SavedPrefManager.getStringPreferences(context, SavedPrefManager.priceTag).equals("Customer")) {
            priceTag.setText("M.R.P (51% off)")
        } else {
            priceTag.setText("W.S.P (51% off) ")
        }

//        if (intent != null) {
//
//            flag = intent.getStringExtra("flag").toString()
//            flag1 = intent.getStringExtra("WholeSeller").toString()
//
//
//        }
        Back.setOnClickListener {
            fragmentManager?.popBackStack()

        }
        viewAddDealsSubmit.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, MyCartActivity(""), "addCart")
                ?.addToBackStack(null)
                ?.commit()
        }
        val sliderRunnable =
            Runnable { multi_image.setCurrentItem(multi_image.getCurrentItem() + 1) }

        val callback: ViewPager2.OnPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
                if (position == 3) {

                }
            }
        }
        multi_image.registerOnPageChangeCallback(callback)
//                sharePostLink(position)
        setImageAdaptor(images)

        CustomerdealViewApi(id)
            return view
        }
    fun setImageAdaptor(imageList: ArrayList<viewdealsResult>) {
        imageAdaptor = dealviewimage_adaptor(imageList, requireContext(),this,"viewdeals")
        multi_image.adapter = imageAdaptor
        indicator3.setViewPager(multi_image)

    }

    override fun click4() {
        TODO("Not yet implemented")
    }

    fun CustomerdealViewApi(id:String) {
        if (androidextention.isOnline(mContext)) {
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<viewdeals_response> =
                ApiCallBack<viewdeals_response>(this, "CustomerdealViewApi", mContext)
            try {
                serviceManager.customerdealsViewApi(callBack,id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            diasplay_toast("Please check your internet connection!")
        }

    }

    override fun onApiSuccess(response: viewdeals_response, apiName: String?) {
        if (response.responseCode==200){
            images= response.result!! as ArrayList<viewdealsResult>
            setImageAdaptor(images)
            deal_productname.text=response.result.dealName
            price.text=response.result.dealPrice.toString()
            tvDescription.text=response.result.description
            tv_starttime.text=response.result.dealStartTime
            tv_endtime.text=response.result.dealEndTime

        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {

    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
    }

}



