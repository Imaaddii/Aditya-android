package com.exobe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.ReviewProductListAdapter
import com.exobe.ModelClass.ReviewProductListModelClass


class ReviewProductList : Fragment() {


    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ReviewProductListAdapter
    lateinit var addProductbutton: Button
    val itemList: ArrayList<ReviewProductListModelClass> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_review_product_list, container, false)

        recyclerView = view.findViewById(R.id.reviewProductListRecycler)
        addProductbutton = view.findViewById(R.id.addProductbutton)

        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.order_review_items_))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.shoes))
        itemList.add(ReviewProductListModelClass("Phone", R.drawable.phone))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.clothes))
        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.processors))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.gamepad))
        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.tablet))
        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.order_review_items_))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.shoes))
        itemList.add(ReviewProductListModelClass("Phone", R.drawable.phone))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.clothes))
        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.processors))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.gamepad))
        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.tablet))
        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.order_review_items_))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.shoes))
        itemList.add(ReviewProductListModelClass("Phone", R.drawable.phone))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.clothes))
        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.processors))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.gamepad))
        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.tablet))
        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.order_review_items_))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.shoes))
        itemList.add(ReviewProductListModelClass("Phone", R.drawable.phone))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.clothes))
        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.processors))
        itemList.add(ReviewProductListModelClass("shoes", R.drawable.gamepad))
        itemList.add(ReviewProductListModelClass("Furniture", R.drawable.tablet))


        recyclerView.layoutManager = GridLayoutManager(context, 4)
        adapter = ReviewProductListAdapter(activity as Context, itemList)
        recyclerView.adapter = adapter

        addProductbutton.setOnClickListener {
            startActivity(Intent(activity as Context, AddProduct::class.java))

        }


        return view
    }


}