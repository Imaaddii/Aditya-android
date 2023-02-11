package com.exobe.Fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.viewpager2.widget.ViewPager2
import com.exobe.Adaptor.ImageSliderAdaptor
import com.exobe.R
import com.exobe.customClicks.CustomeClick4
import me.relex.circleindicator.CircleIndicator3

class AddproductSearch_details : Fragment(), CustomeClick4 {

    lateinit var multi_image: ViewPager2
    lateinit var imageAdaptor:ImageSliderAdaptor
    lateinit var indicator3: CircleIndicator3
    private val sliderHandler: Handler = Handler()
    var images = ArrayList<Int>()
    lateinit var viewAddDealsBack:ImageView
    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var addDealsField: LinearLayout
    lateinit var save: Button
    lateinit var productCategory_spinner: Spinner
    lateinit var cancel_button:Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_addproduct_search_details, container, false)
        setToolbar()
        indicator3 = view.findViewById(R.id.indicator)
        multi_image = view.findViewById(R.id.multi_image)
        viewAddDealsBack = view.findViewById(R.id.viewAddDealsBack)
        productCategory_spinner = view.findViewById(R.id.productCategory_spinner)
        cancel_button = view.findViewById(R.id.cancel_button)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.GONE

        viewAddDealsBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }


        images.add(R.drawable.sofa_img)
        images.add(R.drawable.sofa_img)
        images.add(R.drawable.sofa_img)
        val sliderRunnable =
            Runnable { multi_image.setCurrentItem(multi_image.getCurrentItem() + 1) }




        val Product_category: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(), android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.select_product_category)
        )


        productCategory_spinner.setAdapter(Product_category)

        cancel_button.setOnClickListener{
            fragmentManager?.popBackStack()
        }




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
//        setImageAdaptor(images)
        return view
    }
//    fun setImageAdaptor(imageList: ArrayList<Int>) {
//        imageAdaptor = ImageSliderAdaptor(imageList, requireContext(),this,"viewdeals")
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
    }


}