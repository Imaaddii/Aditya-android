package com.exobe.Activities

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.CategoryProductItemAdapter
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.CustomeClick
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.productListByCategoryResult
import com.exobe.entity.Response.productListByCategory_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast


class CategoryItem : Fragment(), CustomeClick, ApiResponseListener<productListByCategory_response> {

    lateinit var ItemCategory: RecyclerView
    lateinit var adpter: CategoryProductItemAdapter
    lateinit var imageView2: ImageView
    var data: ArrayList<productListByCategoryResult> = ArrayList()
    lateinit var MenuClick: ImageView
    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var mContext: Context
    var id = ""
    var name = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_category_item, container, false)

        ItemCategory = view.findViewById(R.id.ItemCategory)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mContext = activity?.applicationContext!!

        mainHeader.visibility = View.VISIBLE

        if (requireArguments().getString("id") != null) {
            id = requireArguments().getString("id").toString()
        }

        if (requireArguments().getString("name") != null) {
            name = requireArguments().getString("name").toString()
        }

        setToolbar()
        data.clear()

        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        filter.setOnClickListener {
            val popupMenu = PopupMenu(requireContext(), filter)

            popupMenu.getMenuInflater().inflate(R.menu.filter_menu, popupMenu.getMenu())
            popupMenu.setOnMenuItemClickListener { menuItem -> // Toast message on menu item clicked
                Toast.makeText(
                    requireContext(),
                    "You Clicked " + menuItem.getTitle(),
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            popupMenu.show()
        }

        cart.setOnClickListener {
//            val intent = Intent(requireContext(), MyCartActivity::class.java)
//            startActivity(intent)
            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, MyCartActivity(""), "addCart")?.addToBackStack(null)
                ?.commit()
        }
        productListByCategoryApi()


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
        cart.visibility = View.VISIBLE
        filter.visibility = View.VISIBLE
        back.visibility = View.VISIBLE

        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText(name)

    }


    override fun click(_id: String?) {

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, Product_View(), "productView")?.addToBackStack(null)
            ?.commit()
    }

    fun categoryitem(data:ArrayList<productListByCategoryResult>) {
        ItemCategory.layoutManager = GridLayoutManager(requireContext(), 2)
        adpter = CategoryProductItemAdapter(requireContext(), data, this)
        ItemCategory.adapter = adpter

    }

    fun productListByCategoryApi() {
        if (androidextention.isOnline(mContext)) {
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<productListByCategory_response> =
                ApiCallBack<productListByCategory_response>(
                    this,
                    "productListByCategoryApi",
                    mContext
                )

            try {
                serviceManager.productListByCategoryApi(callBack, id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }

    }

    override fun onApiSuccess(response: productListByCategory_response, apiName: String?) {
        if (response.responseCode == 200) {
            data = response.result as ArrayList<productListByCategoryResult>
            categoryitem(data)

        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
    }

}