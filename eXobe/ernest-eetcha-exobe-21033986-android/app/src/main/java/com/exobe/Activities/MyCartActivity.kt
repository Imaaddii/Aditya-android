package com.exobe.Activities

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.MyCartAdapter
import com.exobe.Adapter.MyCartAdapter2
import com.exobe.ModelClass.CartProductModel
import com.exobe.ModelClass.doc
import com.exobe.R
import com.exobe.customClicks.CustomeClick
import com.exobe.customClicks.CustomeClick2
import com.exobe.dialogs.productDialog
import java.util.*

class MyCartActivity(var flag: String) : Fragment(), CustomeClick , CustomeClick2 {
    lateinit var RecyclerLayout: RecyclerView
    lateinit var RecyclerLayout1: RecyclerView
    lateinit var MyCartAdapter: Adapter
    lateinit var MyCartAdapter2: Adapter

    //    lateinit var backButton: ImageView
    lateinit var MenuClick: ImageView
    lateinit var proceed_button: Button

    //    var flag= ""
    lateinit var mContext: Context

    // lateinit var continue_order: Button
    lateinit var data: ArrayList<doc>

    var array: ArrayList<CartProductModel> = ArrayList()
    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var mainHeader: RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_retailer_homepage, container, false)

        var view = inflater.inflate(R.layout.activity_my_cart, container, false)
        mContext = activity?.applicationContext!!
        setToolbar()
//        backButton=view.findViewById(R.id.backButton)
        MenuClick = activity?.findViewById(R.id.MenuClick)!!
        RecyclerLayout = view.findViewById(R.id.orderReview_recyclerview)
        proceed_button = view.findViewById(R.id.proceed_button)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        back = activity?.findViewById(R.id.imageView_back)!!
        mainHeader.visibility = View.VISIBLE

        if (flag.equals("SideMenu")) {
            back.visibility = View.GONE
            MenuClick.visibility = View.VISIBLE
        } else {
            MenuClick.visibility = View.GONE
            back.visibility = View.VISIBLE
        }

        proceed_button.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "")
            val fragobj = ChooseDeliveryAddress()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, fragobj,"ChooseDeliveryAddress")?.addToBackStack(null)?.commit()

//            fragmentManager?.beginTransaction()?.replace(
//                R.id.FrameLayout,
//                ChooseDeliveryAddress(), "chooseAddress"
//            )?.addToBackStack(null)
//                ?.commit()//            startActivity(Intent(mContext, ChooseDeliveryAddress::class.java))
        }
        RecyclerLayout1 = view.findViewById(R.id.card_recycler)
        //  continue_order = findViewById(R.id.continue_order)
        data = ArrayList<doc>()
        data.add(doc(R.drawable.order_review_item!!, "Jan Sflanaganvik sofa", "R599.00", 1))
        data.add(doc(R.drawable.order_review_item, "Headphone", "R400.00", 1))
        data.add(doc(R.drawable.order_review_item, "Kallax chair", "R199.00", 1))
        data.add(doc(R.drawable.order_review_item!!, "Jan Sflanaganvik sofa", "R599.00", 1))
        data.add(doc(R.drawable.order_review_item, "Headphone", "R400.00", 1))
        data.add(doc(R.drawable.order_review_item, "Kallax chair", "R199.00", 1))


        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        var data1 = CartProductModel(
            R.drawable.white_background,
            R.drawable.sofa_img2,
            "Jan Sflanaganvik sofa", "R1198.00"
        )

        var data2 = CartProductModel(
            R.drawable.white_background, R.drawable.sofa_img2, "Jan Sflanaganvik sofa", "R1198.00"
        )

        var data3 = CartProductModel(
            R.drawable.white_background,
            R.drawable.sofa_img2,
            "Jan Sflanaganvik sofa", "R1198.00"
        )

        var data4 = CartProductModel(
            R.drawable.white_background,
            R.drawable.sofa_img2,
            "Jan Sflanaganavik sofa", "R1998.00"
        )
        var data5 = CartProductModel(
            R.drawable.white_background,
            R.drawable.sofa_img2,
            "Jan Sflanaganvik sofa", "R999.00"
        )

        var data6 = CartProductModel(
            R.drawable.white_background,
            R.drawable.sofa_img2,
            "Jan Sflanaganvik sofa", "R1599.00"
        )

        array.add(data1)
        array.add(data2)
        array.add(data3)
        array.add(data4)
        array.add(data5)
        array.add(data6)
        RecyclerLayout1.layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false )
        RecyclerLayout1.adapter = MyCartAdapter2(mContext, array, this)


        RecyclerLayout.layoutManager = LinearLayoutManager(mContext)
        RecyclerLayout.adapter = MyCartAdapter(mContext, data, this,this)

        return view
    }

    fun setToolbar() {
        title = activity?.findViewById(R.id.PreLoginTitle_TextView2)!!
        cart = activity?.findViewById(R.id.cart_icon)!!
        filter = activity?.findViewById(R.id.filter_icon)!!

        ProductImageView = activity?.findViewById(R.id.Product_ImageView)!!
        DealsImageView = activity?.findViewById(R.id.Deals_ImageView)!!
        greyBellImageView = activity?.findViewById(R.id.greyBell_ImageView)!!
        cart.visibility = View.GONE
        filter.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("My Cart")
    }

    fun decrement(position: Int, price: String?) {

    }

    fun increment(position: Int, price: String?) {

    }

    override fun click(_id: String?) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.FrameLayout, Product_View(),"productView")?.addToBackStack(null)?.commit()
    }

    override fun click2() {
        fragmentManager?.let {
            productDialog("Are you sure you want to \ndelete this item", "DeleteItem").show(
                it,
                "MyCustomFragment"
            )
        }
    }

}