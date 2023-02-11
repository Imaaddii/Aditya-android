package com.exobe.Fragments.retailr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.exobe.Adaptor.ImageSliderAdaptor
import com.exobe.R
import com.exobe.customClicks.CustomeClick4
import me.relex.circleindicator.CircleIndicator3

class ProductDetails : Fragment(), CustomeClick4 {
    lateinit var imageAdaptor: ImageSliderAdaptor
    lateinit var multi_image: ViewPager2
    lateinit var indicator3: CircleIndicator3

    var images = ArrayList<Int>()
    var flag = ""

    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_product_details, container, false)
        multi_image = view.findViewById(R.id.multi_image)
        indicator3 = view.findViewById(R.id.indicator)


        if (requireArguments().getString("flag") != null) {
            flag = requireArguments().getString("flag").toString()
        }

        setToolbar()
        back.setOnClickListener{
            fragmentManager?.popBackStack()
        }

        images.add(R.drawable.sofa_img)
        images.add(R.drawable.sofa_img)
        images.add(R.drawable.sofa_img)

//        setImageAdaptor(images)

        return view
    }

//    fun setImageAdaptor(imageList: ArrayList<Int>) {
//        imageAdaptor = ImageSliderAdaptor(imageList, requireContext(), this, "")
//        multi_image.adapter = imageAdaptor
//        indicator3.setViewPager(multi_image)
//
//    }

    override fun click4() {

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
        title.setText(flag)
    }

}