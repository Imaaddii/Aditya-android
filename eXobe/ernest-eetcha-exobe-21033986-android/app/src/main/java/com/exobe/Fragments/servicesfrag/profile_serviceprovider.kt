package com.exobe.Fragments

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.exobe.R
import java.util.*

class profile_serviceprovider : Fragment() {

    lateinit var date_of_birth: TextView
    var datePicker: DatePickerDialog? = null
    lateinit var mContext: Context
    var yearset = 0
    var monthset = 0
    var day = 0
    val c = Calendar.getInstance()
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_profile_serviceprovider, container, false)
        mContext = activity?.applicationContext!!
        date_of_birth = view.findViewById(R.id.date_of_birth)
        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val date = calendar.get(Calendar.DAY_OF_MONTH)
        datePicker = DatePickerDialog(mContext)

        date_of_birth.setOnClickListener {

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                R.style.DatePickerTheme,
                DatePickerDialog.OnDateSetListener
                { view, year, monthOfYear, dayOfMonth ->

                    c.set(year, monthOfYear + 1, dayOfMonth)

                    date_of_birth.text = "$dayOfMonth-${monthOfYear + 1}-$year"
                    yearset = year
                    monthset = monthOfYear + 1
                    day = dayOfMonth


                },
                year,
                month,
                date
            )
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
            datePickerDialog.show()
        }
        return view
    }



}