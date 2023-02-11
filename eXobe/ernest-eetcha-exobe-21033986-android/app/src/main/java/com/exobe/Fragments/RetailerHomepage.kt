package com.exobe.Fragments

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.exobe.Activities.*
import com.exobe.Adapter.HomeCategory
import com.exobe.Adapter.ProductAdpter
import com.exobe.Adaptor.ImageSliderAdaptorbanner
import com.exobe.Adaptor.home_services_adapter
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.*
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.*
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.gson.GsonBuilder
import me.relex.circleindicator.CircleIndicator3

class RetailerHomepage(var setTitles: SetTitles, var flag: String) : Fragment(), CustomeClick,
    CustomeClick2, CustomeClick3, CustomeClick4, ApiResponseListener<Home_response>,wishlistcustomclick{
    var data: ArrayList<CategoryDetails> = ArrayList()
    var Productdata: ArrayList<ProductDetails> = ArrayList()
    lateinit var CategoryRecycler: RecyclerView
    lateinit var services_recycler: RecyclerView
    lateinit var ProductsRecyclerview: RecyclerView
    lateinit var adapter: HomeCategory
    lateinit var SeeAllCategories_TV: TextView
    lateinit var SeeAllProducts_TV: TextView
    lateinit var seeAllServices_TV: TextView
    lateinit var productAdpter: ProductAdpter
    lateinit var imageAdaptor: ImageSliderAdaptorbanner
    lateinit var mContext: Context
    lateinit var multi_image: ViewPager2
    lateinit var indicator3: CircleIndicator3
    var images = ArrayList<RetailerHomePageDealDetails>()
    private val sliderHandler: Handler = Handler()
    var Services: ArrayList<ServiceDetails> = ArrayList()
    lateinit var home_services_adapter: home_services_adapter

    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var services: LinearLayout
    lateinit var search: RelativeLayout

    lateinit var textViewHome: TextView
    lateinit var textViewServices: TextView
    lateinit var textViewCategory: TextView
    lateinit var textViewWishlist: TextView
    lateinit var textViewSetting: TextView
    lateinit var textViewOrder: TextView
    lateinit var textViewProduct: TextView
    lateinit var mShimmerViewContainer: ShimmerFrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_retailer_homepage, container, false)
        mContext = activity?.applicationContext!!


        textViewHome = activity?.findViewById(R.id.TVhome)!!
        textViewServices = activity?.findViewById(R.id.TVservices)!!
        textViewCategory = activity?.findViewById(R.id.TVcategory)!!
        textViewWishlist = activity?.findViewById(R.id.TVwishlist)!!
        textViewSetting = activity?.findViewById(R.id.TVsettings)!!
        textViewOrder = activity?.findViewById(R.id.TVorder)!!
        textViewProduct = activity?.findViewById(R.id.TVproduct)!!

        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container)!!

        CategoryRecycler = view.findViewById(R.id.CategoryRecycler)
        ProductsRecyclerview = view.findViewById(R.id.ProductsRecyclerview)
        multi_image = view.findViewById(R.id.multi_image)
        SeeAllCategories_TV = view.findViewById(R.id.SeeAllCategories_TextView)
        SeeAllProducts_TV = view.findViewById(R.id.SeeAllProducts_TextView)
        seeAllServices_TV = view.findViewById(R.id.seeAllServices_TextView)
        indicator3 = view.findViewById(R.id.indicator)
        services_recycler = view.findViewById(R.id.services_recycler)
        services = view.findViewById(R.id.services)
        search = view.findViewById(R.id.search)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE



        //according to retailer
        if (flag.equals("Retailer")) {
            services.visibility = View.GONE
            RetailerHOmeApi()

        } else if (flag.equals("Customer")) {
            services.visibility = View.VISIBLE
            CustomerHOmeApi()
        } else {

        }
        search.setOnClickListener {
            val intent = Intent(context, search_homeactivity::class.java)
            startActivity(intent)
        }

        SeeAllCategories_TV.setOnClickListener {


            textViewHome.setTextColor(Color.parseColor("#AAAAAA"))
            textViewSetting.setTextColor(Color.parseColor("#AAAAAA"))
            textViewWishlist.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#BF1E2E"))
            textViewServices.setTextColor(Color.parseColor("#AAAAAA"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, Category(setTitles), "category")?.addToBackStack(null)
                ?.commit()
        }

        SeeAllProducts_TV.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, SeeAll_Products(), "seeAllProduct")
                ?.addToBackStack(null)?.commit()

        }

        seeAllServices_TV.setOnClickListener {
            textViewHome.setTextColor(Color.parseColor("#AAAAAA"))
            textViewSetting.setTextColor(Color.parseColor("#AAAAAA"))
            textViewWishlist.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#AAAAAA"))
            textViewServices.setTextColor(Color.parseColor("#BF1E2E"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, ServiceAvailable(setTitles), "serviceAvailable")
                ?.addToBackStack(null)?.commit()
        }

        data.clear()
        Productdata.clear()
        images.clear()



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
        setToolbar()
//        CustomerHOmeApi()





        return view

    }

    fun setImageAdaptor(imageList: ArrayList<RetailerHomePageDealDetails>) {
        imageAdaptor = ImageSliderAdaptorbanner(imageList, mContext, this, "")
        multi_image.adapter = imageAdaptor
        indicator3.setViewPager(multi_image)

    }

    override fun click(_id: String?) {
        val bundle = Bundle()
        bundle.putString("productId2",_id)
        val fragobj = Product_View()
        fragobj.setArguments(bundle)
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, fragobj, "productView")?.addToBackStack(null)
            ?.commit()

    }


    override fun click2() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, ServicesAvailableListing(), "serviceAvailable")
            ?.addToBackStack(null)?.commit()
    }


    override fun click4() {
        if (flag.equals("Customer")) {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, Customers_Deals("" ,"",
                    "",
                    "Deals on products",
                    "Deals to customer"), "customerDeals")
                ?.addToBackStack(null)?.commit()
        } else {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, Services_DealsScreen(""), "retailerDeals")
                ?.addToBackStack(null)?.commit()
        }
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

        MenuClick.visibility = View.VISIBLE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.VISIBLE
        greyBellImageView.visibility = View.VISIBLE
        title.setText("Home")
    }

    fun CustomerHOmeApi() {
        if (androidextention.isOnline(mContext)) {
            mShimmerViewContainer.startShimmerAnimation();
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<Home_response> =
                ApiCallBack<Home_response>(this, "CustomerHOmeApi", mContext)
            try {
                serviceManager.HomeApi(callBack)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }

    }

    override fun onApiSuccess(response: Home_response, apiName: String?) {
    mShimmerViewContainer.stopShimmerAnimation();
        if (response.responseCode==200){
            data= response.Homeresult?.categoryDetails!!
            Productdata= response.Homeresult.productDetails!!
            var bannerData = response.Homeresult.dealDetails
            var Services = response.Homeresult.serviceDetails
            categoryAdapter(data)
            productAdapter(Productdata)
            if (bannerData != null) {
                setImageAdaptor(bannerData)
            }
            if (Services != null) {
                services(Services)
            }
        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
        mShimmerViewContainer.stopShimmerAnimation();
//        mShimmerViewContainer.setVisibility(View.GONE);

    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
        mShimmerViewContainer.stopShimmerAnimation();



    }
    fun categoryAdapter(data: ArrayList<CategoryDetails>) {
        CategoryRecycler.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        adapter = HomeCategory(mContext, data, this)
        CategoryRecycler.adapter = adapter
    }

    fun productAdapter(Productdata:ArrayList<ProductDetails>){
        ProductsRecyclerview.layoutManager = GridLayoutManager(mContext, 2)
        productAdpter = ProductAdpter(mContext, Productdata, this, flag,mContext.resources,this)
        ProductsRecyclerview.adapter = productAdpter
    }
    fun services(Services:ArrayList<ServiceDetails>){
        services_recycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        home_services_adapter = home_services_adapter(mContext, Services, this)
        services_recycler.adapter = home_services_adapter


    }

    override fun onResume() {
        super.onResume()
        if (androidextention.isOnline(mContext)) {
           // mShimmerViewContainer.stopShimmerAnimation();
        }
        else {

            diasplay_toast("Please check your internet connection!")
        }

    }

    override fun onPause() {
        super.onPause()
        mShimmerViewContainer.stopShimmerAnimation();

    }

    override fun click3(_id: String?, categoryName: String?) {
        val bundle = Bundle()
        bundle.putString("id",_id)
        bundle.putString("name",categoryName)
        val fragobj = CategoryItem()
        fragobj.setArguments(bundle)
        fragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, fragobj, "categoryItem")?.addToBackStack(null)
            ?.commit()
    }

//    override fun click5(_id: String?) {
//        val bundle = Bundle()
//        bundle.putString("id",_id)
//        val fragobj = Product_View()
//        fragobj.setArguments(bundle)
//        fragmentManager?.beginTransaction()
//            ?.replace(R.id.FrameLayout, fragobj, "productItem")?.addToBackStack(null)
//            ?.commit()
//    }

    fun RetailerHOmeApi() {
        if (androidextention.isOnline(mContext)) {
            mShimmerViewContainer.startShimmerAnimation();

//            mShimmerViewContainer.setVisibility(View.VISIBLE);
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<Home_response> =
                ApiCallBack<Home_response>(this, "RetailerHOmeApi", mContext)
            try {
                serviceManager.HomeRetailerApi(callBack)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            diasplay_toast("Please check your internet connection!")
        }

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
                            CustomerHOmeApi()
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

    override fun wishlist(_id: String?) {
        Addtowishlist(_id!!)
    }


}

