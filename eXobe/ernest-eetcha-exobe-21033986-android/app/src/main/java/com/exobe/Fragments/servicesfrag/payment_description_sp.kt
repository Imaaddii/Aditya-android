package com.exobe.Fragments.servicesfrag

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.PaymentStatusAdapter
import com.exobe.ModelClass.PaymentStatusModel
import com.exobe.R


class payment_description_sp() : Fragment() {
    lateinit var My_RecyclerView: RecyclerView
    lateinit var Adapter : PaymentStatusAdapter
    var back : ImageView? = null
    var array: ArrayList<PaymentStatusModel> = ArrayList()
    lateinit var mContext : Context
    var MenuClick: ImageView? = null

    var title: TextView? = null
    var cart: ImageView? = null
    var filter: ImageView? = null
    var ProductImageView: ImageView? = null
    var DealsImageView: ImageView? = null
    var greyBellImageView: ImageView? = null
    var mainHeader: RelativeLayout? = null
    var flagSide = ""
    var paymentFlag = ""
    var Subtitle = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_payment_description, container, false)
        mContext = activity?.applicationContext!!

        My_RecyclerView = view.findViewById(R.id.payment_recycler)

        if (requireArguments().getString("paymentFlag") != null) {
            paymentFlag = requireArguments().getString("paymentFlag").toString()
        }
        if (requireArguments().getString("title") != null) {
            Subtitle = requireArguments().getString("title").toString()
        }

        if (requireArguments().getString("flagSide") != null) {
            flagSide = requireArguments().getString("flagSide").toString()

            if (flagSide.equals("retailer")) {
                setToolbar()
            }
            else if (flagSide.equals("onService")) {
                    setToolbar()
            }
        }
        if(paymentFlag.equals("PaymentFromCustomer")) {
            var data1 = PaymentStatusModel(
                "May 1st 2019",
                "Received from Om Prakash Store."
            )
            var data2 = PaymentStatusModel(
                "May 1st 2019",
                "Received from Om Prakash Store."
            )
            var data3 = PaymentStatusModel(
                "May 1st 2019",
                "Received from Om Prakash Store."
            )
            var data4 = PaymentStatusModel(
                "May 1st 2019",
                "Received from Om Prakash Store."
            )
            array.add(data1)
            array.add(data2)
            array.add(data3)
            array.add(data4)
        } else if(paymentFlag.equals("PaymentFromWholesalers")) {
            var data1 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            var data2 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            var data3 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            var data4 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            array.add(data1)
            array.add(data2)
            array.add(data3)
            array.add(data4)
        } else if(paymentFlag.equals("PaymentFromCustomerService")) {
            var data1 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            var data2 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            var data3 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            var data4 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            array.add(data1)
            array.add(data2)
            array.add(data3)
            array.add(data4)
        }else if(paymentFlag.equals("PaymentFromWholesalersService")) {
            var data1 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            var data2 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            var data3 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            var data4 = PaymentStatusModel(
                "May 1st 2019",
                "Paid to Om Prakash Store."
            )
            array.add(data1)
            array.add(data2)
            array.add(data3)
            array.add(data4)
        }else {
            var data1 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data2 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data3 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data4 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data5 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data6 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data7 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data8 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data9 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data10 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data11 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data12 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data13 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data14 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )
            var data15 = PaymentStatusModel(
                "May 1st 2019",
                "Hi Max, $ 300 received from Customer name for Order ID TOY3535."
            )

            array.add(data1)
            array.add(data2)
            array.add(data3)
            array.add(data4)
            array.add(data5)
            array.add(data6)
            array.add(data7)
            array.add(data8)
            array.add(data9)
            array.add(data10)
            array.add(data11)
            array.add(data12)
            array.add(data13)
            array.add(data14)
            array.add(data15)
        }


        My_RecyclerView.layoutManager = LinearLayoutManager(activity)
        Adapter = PaymentStatusAdapter(mContext, array)
        My_RecyclerView.adapter = Adapter




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
        title!!.setText(Subtitle)
        cart!!.visibility = View.GONE
        filter!!.visibility = View.GONE
        back!!.visibility = View.GONE

        MenuClick!!.visibility = View.VISIBLE
        ProductImageView!!.visibility = View.GONE
        DealsImageView!!.visibility = View.GONE
        greyBellImageView!!.visibility = View.GONE
    }
}