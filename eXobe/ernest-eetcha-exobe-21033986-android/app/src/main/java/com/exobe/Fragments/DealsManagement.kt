package com.exobe.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.ProductManagement_Adapter
import com.exobe.Fragments.retailr.ProductDetails
import com.exobe.R
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.CustomeClick2


class DealsManagement(var flagSide: String) : Fragment() , CustomeClick, CustomeClick2{
    lateinit var recyclerView: RecyclerView
    lateinit var addProduct: TextView

    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var deals: TextView
//    lateinit var mainHeader: RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_deals_management, container, false)
        setToolbar()
        recyclerView = view.findViewById(R.id.ProductManagement_recycler)
        addProduct = view.findViewById(R.id.add_product)
        deals = view.findViewById(R.id.deals)
        if (flagSide.equals("SideMenu")) {
            back.visibility = View.GONE
            MenuClick.visibility = View.VISIBLE
        } else {
            MenuClick.visibility = View.GONE
            back.visibility = View.VISIBLE
        }

        back.setOnClickListener{
            fragmentManager?.popBackStack()
        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        var adapter = ProductManagement_Adapter(activity as Context, this, this, "deals")
        recyclerView.adapter = adapter
        deals.setOnClickListener{
            addProduct.visibility = View.GONE
        }


        addProduct.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("flag", "Add Deal")
            val fragobj = add_products()
            fragobj.setArguments(bundle)

            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, fragobj , "addProducts")?.addToBackStack(null)
                ?.commit()
        }


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
        title.setText("Deals to customers")
    }

    override fun click(_id: String?) {
        val bundle = Bundle()
        bundle.putString("flag", "Edit Deal")
        val fragobj = add_products()
        fragobj.setArguments(bundle)

        fragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, fragobj , "addProducts")?.addToBackStack(null)
            ?.commit()
    }

    override fun click2() {
        val bundle = Bundle()
        bundle.putString("flag", "Deal Details")
        val fragobj = ProductDetails()
        fragobj.setArguments(bundle)

        fragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, fragobj , "productView")?.addToBackStack(null)
            ?.commit()

    }


}