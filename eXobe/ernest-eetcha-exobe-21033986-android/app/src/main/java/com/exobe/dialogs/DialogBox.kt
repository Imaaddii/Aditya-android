package com.exobe.dialogs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.exobe.Activities.Add_Address
import com.exobe.Activities.Payment
import com.exobe.R

class DialogBoxPayment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//            getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner);
        var view = inflater.inflate(R.layout.order_review_confirmation, container, false)
        val yesBtn = view.findViewById<Button>(R.id.Continue_button_popup)
        val popup_cross = view.findViewById<ImageView>(R.id.popup_cross)
//        val bodyTitle = dialog.findViewById<TextView>(R.id.TextView1)
//        bodyTitle.text = title
        yesBtn.setOnClickListener {
            dismiss()
            fragmentManager?.popBackStack("productView", FragmentManager.POP_BACK_STACK_INCLUSIVE)


        }
        popup_cross.setOnClickListener {
            dismiss()
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

