package com.exobe.Activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.OrderReviewAdapter
import com.exobe.ModelClass.doc
import com.exobe.R
import com.exobe.customClicks.quantityCounter


class OrderReview : Fragment(), quantityCounter {
    lateinit var RecyclerLayout: RecyclerView
    lateinit var Adapter: OrderReviewAdapter
    lateinit var continue_order: Button
    lateinit var edit: ImageView
    lateinit var Add: TextView
    lateinit var data: ArrayList<doc>

    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_retailer_homepage, container, false)

        var view = inflater.inflate(R.layout.activity_order_review, container, false)
        mContext = activity?.applicationContext!!
        setToolbar()
        RecyclerLayout = view.findViewById(R.id.orderReview_recyclerview)
        continue_order = view.findViewById(R.id.continue_order)
        edit = view.findViewById(R.id.edit)
        Add = view.findViewById(R.id.Add)

        data = ArrayList<doc>()
        data.add(doc(R.drawable.order_review_item!!, "Jan Sflanaganvik sofa", "R599.00", 1))
        data.add(doc(R.drawable.order_review_item, "Headphone", "R400.00", 1))

        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        continue_order.setOnClickListener {
//            fragmentManager?.let { it1 -> DialogBox().show(it1, "MyCustomFragment") }

            val bundle = Bundle()
            bundle.putString("flag", "")
            val fragobj = Payment()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(
                R.id.FrameLayout,
                fragobj, "Payment"
            )?.addToBackStack(null)?.commit()

        }




        RecyclerLayout.layoutManager = LinearLayoutManager(mContext)
        RecyclerLayout.adapter = OrderReviewAdapter(mContext, data, this)

        edit.setOnClickListener {
//            fragmentManager?.beginTransaction()?.replace(
//                R.id.FrameLayout,
//                Add_Address("Edit")
//            )?.commit()
//            startActivity(Intent(mContext, Add_Address::class.java).putExtra("flag", "Edit"))
            fragmentManager?.beginTransaction()?.replace(
                R.id.FrameLayout,
                Add_Address(""), "addAddress"
            )?.addToBackStack(null)?.commit()
        }

        Add.setOnClickListener {
//            fragmentManager?.beginTransaction()?.replace(
//                R.id.FrameLayout,
//                Add_Address("Add")
//            )?.commit()
//            startActivity(Intent(mContext, Add_Address::class.java).putExtra("flag", "Add"))
            fragmentManager?.beginTransaction()?.replace(
                R.id.FrameLayout,
                Add_Address(""), "addAddress"
            )?.addToBackStack(null)?.commit()


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
        title.setText("Order Review")
    }


    override fun decrement(position: Int, price: String?) {

    }

    override fun increment(position: Int, price: String?) {

    }

}
