package com.example.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class signup : AppCompatActivity() {
    private lateinit var EtdatePicker:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        EtdatePicker = findViewById(R.id.EtdatePicker)



            EtdatePicker.setOnClickListener {

                val currentDate = Calendar.getInstance()
                val year=currentDate.get(Calendar.YEAR)
                val month=currentDate.get(Calendar.MONTH)
                val date=currentDate.get(Calendar.DATE)
                val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    // Display Selected date in textbox
                    EtdatePicker.text = "$dayOfMonth-${monthOfYear+1}-$year"
                }, year, month, date)

                dpd.show()
            }
        }


}