package com.exobe.dialogs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.exobe.Activities.OtpVerification
import com.exobe.Activities.services.ServicesMainActivity
import com.exobe.R

class CustomerRating(context: Context) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view= inflater.inflate(R.layout.rate_this_customer, container, false)
        val no_btn = view.findViewById<Button>(R.id.btnCancel)
        val yes_btn = view.findViewById<Button>(R.id.btnSave)
//        val bodyTitle = dialog.findViewById<TextView>(R.id.TextView1)
//        bodyTitle.text = title
        no_btn.setOnClickListener {
            dismiss()
        }
        yes_btn.setOnClickListener {
            Toast.makeText(context, "Feedback sent successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, ServicesMainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        return view
    }
    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}