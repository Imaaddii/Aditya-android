package com.exobe.Activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
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
import com.exobe.Adaptor.ReviewAdaptor
import com.exobe.ModelClass.ReviewModel
import com.exobe.R

class Review : Fragment() {

    lateinit var backButton: ImageView
    lateinit var reviewAdaptor: ReviewAdaptor
    lateinit var recyclerView: RecyclerView
    var data = ArrayList<ReviewModel>()
    lateinit var mContext: Context
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

        var view = inflater.inflate(R.layout.activity_review, container, false)
        mContext = activity?.applicationContext!!
        setToolbar()
        backButton = view.findViewById(R.id.back)
        recyclerView = view.findViewById(R.id.review_rv)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE

        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }



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
//        title.setText("Reviews")

        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        setAdaptor()
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
        title.setText("Reviews")
    }
    fun setAdaptor() {
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        reviewAdaptor = ReviewAdaptor(mContext, data)
        recyclerView.adapter = reviewAdaptor
    }

}