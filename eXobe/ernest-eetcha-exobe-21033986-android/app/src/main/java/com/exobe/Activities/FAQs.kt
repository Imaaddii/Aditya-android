package com.exobe.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.faqsAdapter
import com.exobe.Model.faqsModel
import com.exobe.R

class FAQs : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: faqsAdapter
    lateinit var ivgroup: TextView
    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    var array: ArrayList<faqsModel> = ArrayList()
    var flag = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_faqs, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewFAQs)


        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))
        array.add(faqsModel("What is Mobile App and the Mobile Website?"))


        if (requireArguments().getString("flag") != null) {
            flag = requireArguments().getString("flag").toString()

        }

        if (flag.equals("services")) {

            title = activity?.findViewById(R.id.title)!!
            back = activity?.findViewById(R.id.back)!!
            title!!.setText("FAQ")
            back!!.visibility = View.VISIBLE
            back!!.setOnClickListener {
                fragmentManager?.popBackStack()
            }
        } else {
            setToolbar()
            mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
            mainHeader.visibility = View.VISIBLE


            back.setOnClickListener {
                fragmentManager?.popBackStack()
            }


        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = faqsAdapter(requireContext(), array)
        recyclerView.adapter = adapter


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
        title.setText("FAQ")
    }

}