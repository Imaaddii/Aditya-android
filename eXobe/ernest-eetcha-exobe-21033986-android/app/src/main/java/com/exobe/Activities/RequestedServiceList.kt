package com.exobe.Activities

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.ViewServiceList_Adaptor
import com.exobe.ModelClass.ViewServiceList_modelclass
import com.exobe.R
import java.util.*

class RequestedServiceList : AppCompatActivity() {

    lateinit var txtFromDate: TextView
    lateinit var fromDateRL: RelativeLayout
    lateinit var toDateRL: RelativeLayout
    lateinit var from_date_ImageView: ImageView
    lateinit var txtToDate: TextView
    lateinit var to_date_ImageView: ImageView
    lateinit var reqServiceListBack: ImageView
    lateinit var adapter: ViewServiceList_Adaptor
    lateinit var RecyclerLayout : RecyclerView
    var yearset=0
    var monthset=0
    var day=0
    val c = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_requested_service_list)



        val itemList : ArrayList<ViewServiceList_modelclass> = ArrayList()

        RecyclerLayout = findViewById(R.id.RecyclerLayout)

        val data1 =ViewServiceList_modelclass("Accepted","Meilleur Services", "4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi")
        val data2 = ViewServiceList_modelclass("Accepted", "Meilleur Services","4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi")
        val data3 = ViewServiceList_modelclass("Pending", "Meilleur Services","4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi")
        val data4 = ViewServiceList_modelclass("Accepted", "Meilleur Services","4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi")
        val data5 =ViewServiceList_modelclass("Pending", "Meilleur Services","4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi")
        val data6 = ViewServiceList_modelclass("Accepted", "Meilleur Services","4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi")
        val data7 =ViewServiceList_modelclass("Pending", "Meilleur Services","4.6", "House Cleaning Service","7+ years in business","New Delhi,Delhi")

        itemList.add(data1)
        itemList.add(data2)
        itemList.add(data3)
        itemList.add(data4)
        itemList.add(data5)
        itemList.add(data6)
        itemList.add(data7)

        RecyclerLayout.layoutManager = LinearLayoutManager(this)

        adapter = ViewServiceList_Adaptor(this, itemList)

        RecyclerLayout.adapter = adapter



        txtFromDate = findViewById(R.id.txtFromDate)
        from_date_ImageView = findViewById(R.id.from_date_ImageView)
        txtToDate = findViewById(R.id.txtToDate)
        to_date_ImageView = findViewById(R.id.to_date_ImageView)
        reqServiceListBack = findViewById(R.id.reqServiceListBack)
        fromDateRL = findViewById(R.id.fromDateRL)
        toDateRL = findViewById(R.id.toDateRL)


        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val date = calendar.get(Calendar.DAY_OF_MONTH)
//
//        txtFromDate.text = "Rdate-R{month + 1}-Ryear"
//
//        txtToDate.text = "Rdate-R{month + 1}-Ryear"


        fromDateRL.setOnClickListener {

            val datePickerDialog = DatePickerDialog(this,R.style.DatePickerTheme, DatePickerDialog.OnDateSetListener
            { view, year, monthOfYear, dayOfMonth ->
                c.set(year, monthOfYear+1, dayOfMonth)

                txtFromDate.text = "$dayOfMonth-${monthOfYear + 1}-$year"
                yearset=year
                monthset=monthOfYear+1
                day=dayOfMonth


            }, year, month, date)

            datePickerDialog.show()
        }





        c.set(year, month+1, date)

        toDateRL.setOnClickListener {

            val datePickerDialog = DatePickerDialog(this,R.style.DatePickerTheme, DatePickerDialog.OnDateSetListener
            { view, year, monthOfYear, dayOfMonth ->

                txtToDate.text = "$dayOfMonth-${monthOfYear + 1}-$year"

            }, year, month, date)

            datePickerDialog.getDatePicker().minDate=c.timeInMillis

            datePickerDialog.show()
        }


        reqServiceListBack.setOnClickListener(){
            onBackPressed()
        }

        return
    }
}
