package com.exobe.Activities

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.exobe.R
import java.util.*

class AddDeals : AppCompatActivity() {

    lateinit var FromdateTextView: TextView
    lateinit var TodateTextView: TextView
    lateinit var selectCategory: TextView

    lateinit var addDealsSubmit: Button

    lateinit var dealName: EditText
    lateinit var dealDescription: EditText
    lateinit var offerPrice: EditText

    lateinit var FromdateImageView: ImageView
    lateinit var TodateImageView: ImageView
    lateinit var addDealsBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_deals)

        FromdateTextView = findViewById(R.id.from_date_Text)
        TodateTextView = findViewById(R.id.to_date_Text)

        FromdateImageView = findViewById(R.id.from_date_ImageView)
        TodateImageView = findViewById(R.id.to_date_ImageView)
        addDealsBack = findViewById(R.id.addDealsBack)

        selectCategory = findViewById(R.id.selectCategory)
        addDealsSubmit = findViewById(R.id.addDealsSubmit)
        dealName = findViewById(R.id.dealName)
        dealDescription = findViewById(R.id.dealDescription)
        offerPrice = findViewById(R.id.offerPrice)


        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val date = calendar.get(Calendar.DAY_OF_MONTH)


        addDealsBack.setOnClickListener{
            onBackPressed()
        }

        FromdateTextView.text = "$date-${month + 1}-$year"

        TodateTextView.text = "$date-${month + 1}-$year"

        FromdateImageView.setOnClickListener {

            val datePickerDialog = this?.let { it1 ->
                DatePickerDialog(
                    it1, R.style.DatePickerTheme, DatePickerDialog.OnDateSetListener
                    { view, year, monthOfYear, dayOfMonth ->
                        FromdateTextView.text = "$dayOfMonth-${monthOfYear + 1}-$year"

                    }, year, month, date
                )
            }

            datePickerDialog?.show()
        }

        TodateImageView.setOnClickListener {

            val datePickerDialog = this?.let { it1 ->
                DatePickerDialog(
                    it1, R.style.DatePickerTheme, DatePickerDialog.OnDateSetListener
                    { view, year, monthOfYear, dayOfMonth ->
                        TodateTextView.text = "$dayOfMonth-${monthOfYear + 1}-$year"

                    }, year, month, date
                )
            }

            datePickerDialog?.show()
        }



    }

    override fun onBackPressed() {
        finish()
    }
}