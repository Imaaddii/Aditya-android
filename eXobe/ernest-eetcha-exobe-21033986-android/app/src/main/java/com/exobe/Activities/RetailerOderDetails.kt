package com.exobe.Fragments.retailr

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.CategoryAdpter
import com.exobe.Adaptor.ProductDetailsAdapter
import com.exobe.R
import java.util.*

class RetailerOderDetails : Fragment() {

    lateinit var OderDetails: RecyclerView
    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var CalenderClickFrom: RelativeLayout
    var yearset=0
    var monthset=0
    var day=0
    val c = Calendar.getInstance()
    lateinit var txtFromDate: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_retailer_oder_details, container, false)
        setToolbar()
        OderDetails = view.findViewById(R.id.OderDetails)
        txtFromDate = view.findViewById(R.id.from_date_Text)
        CalenderClickFrom = view.findViewById(R.id.CalenderClickFrom)

        OderDetails.layoutManager = LinearLayoutManager(context)

        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        var productDetailsAdapter = ProductDetailsAdapter(requireContext())
        OderDetails.adapter = productDetailsAdapter


        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val date = calendar.get(Calendar.DAY_OF_MONTH)


        CalenderClickFrom.setOnClickListener {

            val datePickerDialog = DatePickerDialog(requireContext(),R.style.DatePickerTheme, DatePickerDialog.OnDateSetListener
            { view, year, monthOfYear, dayOfMonth ->
                c.set(year, monthOfYear+1, dayOfMonth)

                txtFromDate.text = "$dayOfMonth-${monthOfYear + 1}-$year"
                yearset=year
                monthset=monthOfYear+1
                day=dayOfMonth


            }, year, month, date)

            datePickerDialog.show()
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
        title.setText("Order Details")
    }

}