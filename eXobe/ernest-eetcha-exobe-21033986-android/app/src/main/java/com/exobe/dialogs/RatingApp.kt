package com.exobe.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.util.rangeTo
import androidx.fragment.app.DialogFragment
import com.exobe.R

class RatingApp : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view= inflater.inflate(R.layout.rate_this_app, container, false)
        val no_btn = view.findViewById<Button>(R.id.btnCancel)
        val yes_btn = view.findViewById<Button>(R.id.btnSave)
        val RatingBar = view.findViewById<RatingBar>(R.id.ratingBar)
        val RAtingAppTV = view.findViewById<TextView>(R.id.RAtingAppTV)

        var rating = RatingBar.rating.toString()
        println("hello$rating")
//        val bodyTitle = dialog.findViewById<TextView>(R.id.TextView1)

//        bodyTitle.text = title
        no_btn.setOnClickListener {
            dismiss()
        }
        yes_btn.setOnClickListener {
            RAtingAppTV.text = rating
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