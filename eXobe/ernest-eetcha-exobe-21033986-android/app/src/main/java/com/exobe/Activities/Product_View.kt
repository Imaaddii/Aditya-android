package com.exobe.Activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.exobe.Adapter.ProductDescAdapter
import com.exobe.Adaptor.DetailViewReview
import com.exobe.Adaptor.ImageSliderAdaptor
import com.exobe.ModelClass.ReviewModel
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick4
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.ViewProductResponse
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.exobe.modalClass.ProductDescModelClass
import com.google.gson.GsonBuilder
import me.relex.circleindicator.CircleIndicator3

class Product_View : Fragment(),CustomeClick4{


    lateinit var backProductDesc: ImageView
    var images = ArrayList<String>()

    lateinit var decrement: ImageView
    lateinit var increment: ImageView
    lateinit var quantity: TextView
    var count = 0
    lateinit var multi_image: ViewPager2
    lateinit var imageAdaptor: ImageSliderAdaptor
    lateinit var txtDescription: TextView
    lateinit var txtMaterials: TextView
    lateinit var txtReview: TextView
    lateinit var AddToCart_BTN: Button
    lateinit var indicator3: CircleIndicator3

    lateinit var productName: TextView
    lateinit var priceTag: TextView
    lateinit var txtDescriptionDetails: TextView

    lateinit var My_RecyclerView: RecyclerView
    lateinit var reviewClick: LinearLayout
    lateinit var Adapter: ProductDescAdapter
    var array: ArrayList<ProductDescModelClass> = ArrayList()

    lateinit var SimilarPRo: TextView
    lateinit var MaterialText: TextView
    lateinit var review: LinearLayout
    lateinit var mainHeader: RelativeLayout

    lateinit var heart: ImageView
    lateinit var solidHeart: ImageView
    lateinit var share: ImageView

    //    lateinit var backProductDesc: ImageView
    lateinit var mContext: Context
    private val sliderHandler: Handler = Handler()
    var isLike = false

    lateinit var reviewAdaptor: DetailViewReview
    var data = ArrayList<ReviewModel>()
    lateinit var reviewRV: RecyclerView
    lateinit var SeeAll: TextView

    var productId2 = ""


//    lateinit var ratingBar: RatingBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_retailer_homepage, container, false)

        var view = inflater.inflate(R.layout.activity_product_description, container, false)
        mContext = activity?.applicationContext!!
        SimilarPRo = view.findViewById(R.id.SimilarPRo)
        MaterialText = view.findViewById(R.id.MaterialText)
        review = view.findViewById(R.id.Review)
        backProductDesc = view.findViewById(R.id.backProductDesc)
        decrement = view.findViewById(R.id.decrement)
        increment = view.findViewById(R.id.increment)
        quantity = view.findViewById(R.id.quantity)
        priceTag = view.findViewById(R.id.priceTag)
//        ratingBar = findViewById(R.id.ratingBar)
        My_RecyclerView = view.findViewById(R.id.recyclerViewProductDescription)

        // setting tabs changing focus functionality
        txtDescription = view.findViewById(R.id.txtDescription)
        txtMaterials = view.findViewById(R.id.txtMaterials)
        txtReview = view.findViewById(R.id.txtReview)
        txtDescriptionDetails = view.findViewById(R.id.txtDescriptionDetails)
        AddToCart_BTN = view.findViewById(R.id.AddToCart_BTN)
        heart = view.findViewById(R.id.AddToCart_ImageView)
        solidHeart = view.findViewById(R.id.AddToCart_fill)
        reviewClick = view.findViewById(R.id.reviewClick)
        share = view.findViewById(R.id.share)
        reviewRV = view.findViewById(R.id.reviewRV)
        SeeAll = view.findViewById(R.id.SeeAll)
        indicator3 = view.findViewById(R.id.indicator)
        multi_image = view.findViewById(R.id.multi_image)

        productName = view.findViewById(R.id.productName)
        priceTag = view.findViewById(R.id.priceTag)
        txtDescriptionDetails = view.findViewById(R.id.txtDescriptionDetails)

        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
//        viewAddDealsImage = view.findViewById(R.id.backProductDesc)!!
        mainHeader.visibility = View.GONE

        if (requireArguments().getString("productId2") != null) {
            productId2 = requireArguments().getString("productId2").toString()
        }

        if (SavedPrefManager.getStringPreferences(context, SavedPrefManager.priceTag)
                .equals("Customer")
        ) {
            priceTag.setText("M.R.P  : R 599.00")
        } else {
            priceTag.setText("W.S.P  : R 599.00 ")
        }

        heart.setOnClickListener {
            if (isLike) {
                solidHeart.visibility = View.GONE
                isLike = false
            } else {
                solidHeart.visibility = View.VISIBLE
                isLike = true
            }
        }

        share.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plain"
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
            share.putExtra(Intent.EXTRA_SUBJECT, "Exobe share links....")
            startActivity(Intent.createChooser(share, "eXobe content"))


        }



        AddToCart_BTN.setOnClickListener {
//            val intent = Intent(mContext, MyCartActivity::class.java)
//            startActivity(intent)
            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, MyCartActivity(""), "addCart")?.addToBackStack(null)
                ?.commit()
        }

        reviewClick.setOnClickListener {

            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, Review(), "review")?.addToBackStack(null)
                ?.commit()
        }



        SeeAll.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, Review(), "review")?.addToBackStack(null)
                ?.commit()
        }



        txtDescription.setOnClickListener {
            txtDescription.setBackgroundResource(R.drawable.deal_id_background)
            txtDescription.setTextAppearance(mContext, R.style.boldText)
//            txtDescription.setTextColor(Color.RED)
            txtMaterials.setBackgroundResource(0)
            txtMaterials.setTextAppearance(mContext, R.style.normalText)
//            txtMaterials.setTextColor(Color.GRAY)
            txtReview.setBackgroundResource(0)
            txtReview.setTextAppearance(mContext, R.style.normalText)
//            txtReview.setTextColor(Color.GRAY)

            MaterialText.visibility = View.GONE
            review.visibility = View.GONE
            txtDescriptionDetails.visibility = View.VISIBLE
            My_RecyclerView.visibility = View.VISIBLE
            SimilarPRo.visibility = View.VISIBLE

        }

        txtMaterials.setOnClickListener {
            txtDescription.setBackgroundResource(0)
            txtDescription.setTextAppearance(mContext, R.style.normalText)
//            txtDescription.setTextColor(Color.GRAY)
            txtMaterials.setBackgroundResource(R.drawable.deal_id_background)
            txtMaterials.setTextAppearance(mContext, R.style.boldText)
//            txtMaterials.setTextColor(Color.RED)
            txtReview.setBackgroundResource(0)
            txtReview.setTextAppearance(mContext, R.style.normalText)
//            txtReview.setTextColor(Color.GRAY)


            MaterialText.visibility = View.VISIBLE
            review.visibility = View.GONE
            txtDescriptionDetails.visibility = View.GONE
            My_RecyclerView.visibility = View.GONE
            SimilarPRo.visibility = View.GONE

        }

        txtReview.setOnClickListener {
            txtDescription.setBackgroundResource(0)
            txtDescription.setTextAppearance(mContext, R.style.normalText)
//            txtDescription.setTextColor(Color.GRAY)
            txtMaterials.setBackgroundResource(0)
            txtMaterials.setTextAppearance(mContext, R.style.normalText)
//            txtMaterials.setTextColor(Color.GRAY)
            txtReview.setBackgroundResource(R.drawable.deal_id_background)
            txtReview.setTextAppearance(mContext, R.style.boldText)
//            txtReview.setTextColor(Color.RED)

            review.visibility = View.VISIBLE
            txtDescriptionDetails.visibility = View.GONE
            My_RecyclerView.visibility = View.GONE
            SimilarPRo.visibility = View.GONE
            MaterialText.visibility = View.GONE

        }

        decrement.setOnClickListener {
            if (count > 0) {
                count--
            }
            quantity.text = count.toString()
        }
        increment.setOnClickListener {
            count++
            quantity.text = count.toString()
        }


        backProductDesc.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        var data1 = ProductDescModelClass(
            R.drawable.background_white,
            R.drawable.chair_img,
            "Sverom chair", "R400.00"
        )

        var data2 = ProductDescModelClass(
            R.drawable.background_pink,
            R.drawable.chair_img,
            "Prolite Headphone", "R999.00"
        )

        var data3 = ProductDescModelClass(
            R.drawable.background_grey,
            R.drawable.chair_img,
            "Samsumg M21", "R599.00"
        )

        var data4 = ProductDescModelClass(
            R.drawable.background_white,
            R.drawable.chair_img,
            "Jan Sflanaganavik sofa", "R599.00"
        )
        var data5 = ProductDescModelClass(
            R.drawable.background_white,
            R.drawable.chair_img,
            "Sverom chair", "R400.00"
        )

        var data6 = ProductDescModelClass(
            R.drawable.background_pink,
            R.drawable.chair_img,
            "Prolite Headphone", "R999.00"
        )

        var data7 = ProductDescModelClass(
            R.drawable.background_grey,
            R.drawable.chair_img,
            "Samsumg M21", "R599.00"
        )

        var data8 = ProductDescModelClass(
            R.drawable.background_white,
            R.drawable.chair_img,
            "Jan Sflanaganavik sofa", "R599.00"
        )

        array.add(data1)
        array.add(data2)
        array.add(data3)
        array.add(data4)
        array.add(data5)
        array.add(data6)
        array.add(data7)
        array.add(data8)


        reviews()


        My_RecyclerView.layoutManager =
            LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        Adapter = ProductDescAdapter(mContext, array, this)
        My_RecyclerView.adapter = Adapter



        setAdaptor()
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

        setImageAdaptor(images)
        viewProductApi()
        return view

    }

    fun setImageAdaptor(imageList: ArrayList<String>) {
        imageAdaptor = ImageSliderAdaptor(imageList, requireContext(), this, "viewproduct")
        multi_image.adapter = imageAdaptor
        indicator3.setViewPager(multi_image)

    }

//    override fun click(_id: String?) {
////        startActivity(Intent(mContext,Product_View::class.java))
//        activity?.supportFragmentManager?.beginTransaction()
//            ?.replace(R.id.FrameLayout, Product_View(), "productView")?.addToBackStack(null)
//            ?.commit()
//    }

    fun reviews() {
        data.add(
            ReviewModel(
                R.drawable.product,
                "Karan sharma",
                "20/02/2022",
                "So if you’re not using text messages to generate Google reviews, you’re leaving a lot of valuable social proof potential on the table. Google reviews are probably the most important type of reviews that you can earn for your business.\n" +
                        "\n" +
                        "Where do business owners struggle? Brainstorming how to ask for the review in the text. There’s a valid fear of not knowing what to say. At the very least, you could simply say, “Review us on Google.” You don’t want to come off as scripted or formal, and it can be tricky to determine an appropriate tone for your customers to ask for feedback."
            )
        )
        data.add(
            ReviewModel(
                R.drawable.product,
                "Kavita rawat",
                "20/02/2022",
                "So if you’re not using text messages to generate Google reviews, you’re leaving a lot of valuable social proof potential on the table. Google reviews are probably the most important type of reviews that you can earn for your business.\n" +
                        "\n" +
                        "Where do business owners struggle? Brainstorming how to ask for the review in the text. There’s a valid fear of not knowing what to say. At the very least, you could simply say, “Review us on Google.” You don’t want to come off as scripted or formal, and it can be tricky to determine an appropriate tone for your customers to ask for feedback."
            )
        )
        data.add(
            ReviewModel(
                R.drawable.product,
                "Avinash awasthi",
                "20/02/2022",
                "So if you’re not using text messages to generate Google reviews, you’re leaving a lot of valuable social proof potential on the table. Google reviews are probably the most important type of reviews that you can earn for your business.\n" +
                        "\n" +
                        "Where do business owners struggle? Brainstorming how to ask for the review in the text. There’s a valid fear of not knowing what to say. At the very least, you could simply say, “Review us on Google.” You don’t want to come off as scripted or formal, and it can be tricky to determine an appropriate tone for your customers to ask for feedback."
            )
        )

        data.add(
            ReviewModel(
                R.drawable.product,
                "Nishita sharma",
                "20/02/2022",
                "So if you’re not using text messages to generate Google reviews, you’re leaving a lot of valuable social proof potential on the table. Google reviews are probably the most important type of reviews that you can earn for your business.\n" +
                        "\n" +
                        "Where do business owners struggle? Brainstorming how to ask for the review in the text. There’s a valid fear of not knowing what to say. At the very least, you could simply say, “Review us on Google.” You don’t want to come off as scripted or formal, and it can be tricky to determine an appropriate tone for your customers to ask for feedback."
            )
        )

    }

    fun setAdaptor() {
        reviewRV.layoutManager = LinearLayoutManager(mContext)
        reviewAdaptor = DetailViewReview(mContext, data)
        reviewRV.adapter = reviewAdaptor
    }

    override fun click4() {
        TODO("Not yet implemented")
    }

    fun viewProductApi() {

        if (androidextention.isOnline(mContext)) {
            androidextention.showProgressDialog(activity)
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<ViewProductResponse> =
                ApiCallBack<ViewProductResponse>(object :
                    ApiResponseListener<ViewProductResponse> {
                    override fun onApiSuccess(response: ViewProductResponse, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)
                        if (response.responseCode == 200) {
//                            Toast.makeText(requireContext(), "0", Toast.LENGTH_SHORT).show()
                            productName.text = response.result?.productName
                            priceTag.text = response.result?.price.toString()
                            txtDescriptionDetails.text = response.result?.description
                            MaterialText.text = response.result?.description
                            images = response.result?.productImage!!
                            setImageAdaptor(images)
                        }

                    }

                    override fun onApiErrorBody(response: String, apiName: String?) {
                        androidextention.disMissProgressDialog(activity)

//                        Toast.makeText(requireContext(),"2", Toast.LENGTH_SHORT).show()

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
                        androidextention.disMissProgressDialog(activity)

//                        Toast.makeText(requireContext(), "1", Toast.LENGTH_SHORT).show()
                    }

                }, "viewProductApi", mContext)


            try {
                serviceManager.viewProductApi(callBack, productId2)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }


}

