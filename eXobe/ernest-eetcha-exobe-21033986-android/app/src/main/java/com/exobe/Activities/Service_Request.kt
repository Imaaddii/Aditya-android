package com.exobe.Activities

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.service_selected_adaptor
import com.exobe.ModelClass.cat
import com.exobe.ModelClass.service_request
import com.exobe.ModelClass.subCat
import com.exobe.R
import java.util.*

class Service_Request : Fragment() {
    lateinit var selectdate: LinearLayout
    lateinit var selecttime: LinearLayout
    lateinit var dateselectTV: TextView
    lateinit var selecttimeTV: Spinner
    lateinit var requestforservice: Button
    lateinit var backProductDesc: ImageView
    lateinit var mContext: Context
    lateinit var mainHeader: RelativeLayout
    lateinit var tv_edit_address: TextView
    lateinit var tv_add_address: TextView
    lateinit var detail_screen: RecyclerView
    lateinit var tv_selecttime: TextView
    lateinit var tv_selectdate: TextView
    var listSpinnertime=""

    var itemList = ArrayList<service_request>()

    var yearset = 0
    var monthset = 0
    var day = 0
    val c = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.activity_service_request, container, false)
        mContext = activity?.applicationContext!!
        selectdate = view.findViewById(R.id.selectdate)
        selecttime = view.findViewById(R.id.selecttime)
        dateselectTV = view.findViewById(R.id.dateselectTV)
        selecttimeTV = view.findViewById(R.id.selecttimeTV)
        tv_selectdate = view.findViewById(R.id.tv_selectdate)
        tv_selecttime = view.findViewById(R.id.tv_selecttime)
        requestforservice = view.findViewById(R.id.requestforservice)
        backProductDesc = view.findViewById(R.id.backProductDesc)
        tv_edit_address = view.findViewById(R.id.tv_edit_address)
        tv_add_address = view.findViewById(R.id.tv_add_address)
        detail_screen = view.findViewById(R.id.detail_screen)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.GONE
        itemList.clear()


        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val date = calendar.get(Calendar.DAY_OF_MONTH)

//        dateselectTV.text = "Rdate-R{month + 1}-Ryear"

        itemList.add(service_request("Window AC Service","R299.00"))
        itemList.add(service_request("Split AC Service","R399.00"))



        tv_edit_address.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.FrameLayout,
                Add_Address("Edit"), "addAddress"
            )?.addToBackStack(null)?.commit()
        }
        tv_add_address.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.FrameLayout,
                Add_Address(""), "addAddress"
            )?.addToBackStack(null)?.commit()
        }

        selecttimeTV.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                listSpinnertime = parent.getItemAtPosition(pos).toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        selectdate.setOnClickListener {


                val datePickerDialog = DatePickerDialog(requireContext(),R.style.DatePickerTheme, DatePickerDialog.OnDateSetListener
                { view, year, monthOfYear, dayOfMonth ->

                    dateselectTV.text = "$dayOfMonth-${monthOfYear + 1}-$year"
                    val Product_category: ArrayAdapter<String> = ArrayAdapter<String>(
                        requireContext(), android.R.layout.simple_spinner_item,
                        resources.getStringArray(R.array.time_slots)
                    )
                    Product_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


                    selecttimeTV.setAdapter(Product_category)


                }, year, month, date)

                datePickerDialog.getDatePicker().minDate=c.timeInMillis

                datePickerDialog.show()
            }

            backProductDesc.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        detail_screen.layoutManager = LinearLayoutManager(activity)
        detail_screen.adapter = service_selected_adaptor(requireContext(),itemList)


        requestforservice.setOnClickListener {

            if(dateselectTV.text.equals("")){
                tv_selectdate.setText("*Please select date first")
            }
            else if(listSpinnertime.equals("")|| listSpinnertime.equals("Select Time Slots")){
                tv_selecttime.setText("*Select time slots")
            }
            else{
                val bundle = Bundle()
                bundle.putString("flag", "servicerequest")
                val fragobj = Payment()
                fragobj.setArguments(bundle)
                fragmentManager?.beginTransaction()?.replace(
                    R.id.FrameLayout,
                    fragobj, "Payment"
                )?.addToBackStack(null)?.commit()
            }
        }
        return view
    }

}


