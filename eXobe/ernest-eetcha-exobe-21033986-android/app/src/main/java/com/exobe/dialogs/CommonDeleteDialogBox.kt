package com.exobe.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.exobe.R

class CommonDeleteDialogBox : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view= inflater.inflate(R.layout.delete_address_popup, container, false)
        val title = view.findViewById<TextView>(R.id.title)
        val no_btn = view.findViewById<Button>(R.id.no_button)
        val yes_btn = view.findViewById<Button>(R.id.yes_button)
        title.setText(R.string.delete_order)
//        val bodyTitle = dialog.findViewById<TextView>(R.id.TextView1)
//        bodyTitle.text = title
        no_btn.setOnClickListener {
            dismiss()
        }
        yes_btn.setOnClickListener {
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