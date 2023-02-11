package com.exobe.Activities

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.SearchProduct
import com.exobe.Fragments.AddproductSearch_details
import com.exobe.R
import com.exobe.customClicks.CustomeClick2

class search_composer : Fragment(), CustomeClick2 {

    lateinit var RecyclerOfSearch:RecyclerView
    lateinit var adpter: SearchProduct
    lateinit var UMsearch:EditText

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




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_search_composer, container, false)
        setToolbar()
        RecyclerOfSearch= view!!.findViewById(R.id.RecyclerOfSearch)
        UMsearch= view.findViewById(R.id.UMsearch)

        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE
        RecyclerOfSearch.visibility = View.VISIBLE

        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }




        RecyclerOfSearch.layoutManager = GridLayoutManager(context, 2)
        adpter = SearchProduct(requireContext(),this)
        RecyclerOfSearch.adapter = adpter


//        UMsearch.addTextChangedListener(object : TextWatcher {
//
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
//            override fun afterTextChanged(s: Editable) {
//
//                var gettext= UMsearch.text.toString()
//                if (gettext.length >= 3){
//
//
//                }else{
//                    RecyclerOfSearch.visibility = View.GONE
//
//                }
//
//            }
//        })



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
        title.setText("Product")
    }

    override fun click2() {
//        showKeyboard(requireActivity())
        requireFragmentManager().beginTransaction()
            .replace(R.id.FrameLayout,AddproductSearch_details(),"AddproductSearchdetails")?.addToBackStack("AddproductSearchdetails")
            .commit()
    }


//    fun showKeyboard(activity: Activity) {
//        val imm: InputMethodManager =
//            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
//    }
}