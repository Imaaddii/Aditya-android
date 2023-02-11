package com.exobe.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.ProductCategoryAdapter
import com.exobe.Adaptor.ProductLatestAdapter
import com.exobe.Model.ProductCategoryModel
import com.exobe.Model.ProductLatestModel
import com.exobe.R
import com.exobe.ReviewProductList


class My_Products : Fragment() {

    lateinit var recyclerViewCategory: RecyclerView
    lateinit var recyclerViewProduct: RecyclerView
    lateinit var Seeall_TV: TextView
    lateinit var ProductLatestAdapter: ProductLatestAdapter
    lateinit var ProductCategoryAdapter: ProductCategoryAdapter

    val latestProductList: ArrayList<ProductLatestModel> = ArrayList()
    val categoryProductList: ArrayList<ProductCategoryModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_products, container, false)

        recyclerViewCategory = view.findViewById(R.id.recyclerViewCategory)
        recyclerViewProduct = view.findViewById(R.id.recyclerViewProduct)
        Seeall_TV = view.findViewById(R.id.Seeall_TextView)

        Seeall_TV.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, ReviewProductList(), "")?.commit()
        }

        val data1 = ProductLatestModel("Furniture", R.drawable.clothes)
        val data2 = ProductCategoryModel("Furniture")

        latestProductList.add(data1)
        latestProductList.add(data1)
        latestProductList.add(data1)
        latestProductList.add(data1)
        latestProductList.add(data1)
        latestProductList.add(data1)
        latestProductList.add(data1)
        latestProductList.add(data1)
        latestProductList.add(data1)
        latestProductList.add(data1)
        latestProductList.add(data1)
        latestProductList.add(data1)

        categoryProductList.add(data2)
        categoryProductList.add(data2)
        categoryProductList.add(data2)
        categoryProductList.add(data2)
        categoryProductList.add(data2)
        categoryProductList.add(data2)
        categoryProductList.add(data2)
        categoryProductList.add(data2)
        categoryProductList.add(data2)
        categoryProductList.add(data2)


        recyclerViewCategory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        ProductCategoryAdapter = ProductCategoryAdapter(activity as Context, categoryProductList)
        recyclerViewCategory.adapter = ProductCategoryAdapter


        recyclerViewProduct.layoutManager = GridLayoutManager(context, 4)
        ProductLatestAdapter = ProductLatestAdapter(activity as Context, latestProductList)
        recyclerViewProduct.adapter = ProductLatestAdapter




        return view
    }
}