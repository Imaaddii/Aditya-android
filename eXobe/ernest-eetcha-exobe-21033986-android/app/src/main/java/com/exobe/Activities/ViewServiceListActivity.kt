package com.exobe.Activity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adapter.ViewServiceList
import com.exobe.ModelClass.ViewServiceList_modelclass
import com.exobe.R
import java.util.*

class ViewServiceListActivity(var flagSide: String) : Fragment() {

    lateinit var txtFromDate: TextView
    lateinit var fromDateRL: RelativeLayout
    lateinit var toDateRL: RelativeLayout
    lateinit var from_date_ImageView: ImageView
    lateinit var txtToDate: TextView
    lateinit var to_date_ImageView: ImageView
    lateinit var reqServiceListBack: ImageView
    lateinit var adapter: ViewServiceList
    lateinit var RecyclerLayout : RecyclerView
    var yearset=0
    var monthset=0
    var day=0
    val c = Calendar.getInstance()
    val itemList : ArrayList<ViewServiceList_modelclass> = ArrayList()
    var flag=""
    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout

    lateinit var CalenderClickFrom: RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_view_service_list, container, false)

        setToolbar()
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE

        txtFromDate = view.findViewById(R.id.from_date_Text)
        from_date_ImageView = view.findViewById(R.id.from_date_ImageView)
        txtToDate = view.findViewById(R.id.to_date_Text)
        to_date_ImageView = view.findViewById(R.id.to_date_ImageView)
        toDateRL = view.findViewById(R.id.CalenderClickTo)



        RecyclerLayout = view.findViewById(R.id.RecyclerLayout)

        CalenderClickFrom = view.findViewById(R.id.CalenderClickFrom)


        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        if (flagSide.equals("SideMenu")) {
            back.visibility = View.GONE
            MenuClick.visibility = View.VISIBLE
        } else {
            MenuClick.visibility = View.GONE
            back.visibility = View.VISIBLE
        }


        itemList.add(ViewServiceList_modelclass("Accepted","Meilleur Services", "4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi"))
        itemList.add(ViewServiceList_modelclass("Pending","Meilleur Services", "4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi"))
        itemList.add(ViewServiceList_modelclass("Accepted","Meilleur Services", "4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi"))
        itemList.add(ViewServiceList_modelclass("Pending", "Meilleur Services","4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi"))
        itemList.add(ViewServiceList_modelclass("Accepted", "Meilleur Services","4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi"))
        itemList.add(ViewServiceList_modelclass("Pending", "Meilleur Services","4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi"))

        RecyclerLayout.layoutManager = LinearLayoutManager(requireContext())

        adapter = ViewServiceList(requireContext(), itemList)

        RecyclerLayout.adapter = adapter






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

            datePickerDialog.getDatePicker().minDate=c.timeInMillis

            datePickerDialog.show()
        }





        c.set(year, month+1, date)

        toDateRL.setOnClickListener {

            val datePickerDialog = DatePickerDialog(requireContext(),R.style.DatePickerTheme, DatePickerDialog.OnDateSetListener
            { view, year, monthOfYear, dayOfMonth ->

                txtToDate.text = "$dayOfMonth-${monthOfYear + 1}-$year"

            }, year, month, date)

            datePickerDialog.getDatePicker().minDate=c.timeInMillis

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
        title.setText("Request Service List")
    }


}
