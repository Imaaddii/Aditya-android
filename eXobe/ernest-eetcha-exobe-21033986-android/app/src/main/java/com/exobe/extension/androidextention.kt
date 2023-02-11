package com.exobe

import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.CountDownTimer
import android.widget.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.FragmentActivity
import com.exobe.Activities.About_Us
import com.exobe.Activities.GenericKeyEvent
import com.exobe.Activities.GenericTextWatcher
import com.exobe.Activities.Services
import com.exobe.Utils.SavedPrefManager


object androidextention {

    var dialogProgress: ProgressDialog? = null


    fun productAddedCartDialog(title: String, context: Context) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.product_added_successfully_alert_box)
        val yesBtn = dialog.findViewById<ImageView>(R.id.imageCancel)
//            val bodyTitle = dialog.findViewById<TextView>(R.id.txtAlertTitle)
//            bodyTitle.text = title
        yesBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
        val window = dialog.window
        window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }


    fun showDialog(title: String, context: Context) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.product_enquiry_alert_box)
        val yesBtn = dialog.findViewById<ImageView>(R.id.imgCancel)
        val bodyTitle = dialog.findViewById<TextView>(R.id.txtAlertTitle)
        bodyTitle.text = title
        yesBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
        val window = dialog.window
        window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun logOutDialog(context: Context) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.log_out_alert_box)
        val yesBtn = dialog.findViewById<Button>(R.id.btnSave)
        yesBtn.setOnClickListener {
            SavedPrefManager.saveStringPreferences(context, SavedPrefManager.isLogin, "false")
            dialog.dismiss()
            val intent = Intent(context, Services::class.java)
            context.startActivity(intent)
        }
        val noBtn = dialog.findViewById<Button>(R.id.btnCancel)
        noBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
        val window = dialog.window
        window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun serviceRequestSuccessful(context: Context) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.service_req_successfully_alert_box)
        val yesBtn = dialog.findViewById<ImageView>(R.id.imageSerReqCancel)
        yesBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
        val window = dialog.window
        window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun notificationDialog(context: Context) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_acceptservises)
        val yesBtn = dialog.findViewById<Button>(R.id.ForgotSubmit)
//        val bodyTitle = dialog.findViewById<TextView>(R.id.txtAlertTitle)
//        bodyTitle.text = title

        val ResendCode = dialog.findViewById(R.id.ResendCode) as TextView
        val textView = dialog.findViewById(R.id.textView) as TextView
        val et1 = dialog.findViewById(R.id.et_1) as EditText
        val et2 = dialog.findViewById(R.id.et_2) as EditText
        val et3 = dialog.findViewById(R.id.et_3) as EditText
        val et4 = dialog.findViewById(R.id.et_4) as EditText

        et1.addTextChangedListener(GenericTextWatcher(et1, et2))
        et2.addTextChangedListener(GenericTextWatcher(et2, et3))
        et3.addTextChangedListener(GenericTextWatcher(et3, et4))
        et4.addTextChangedListener(GenericTextWatcher(et4, null))


        et1.setOnKeyListener(GenericKeyEvent(et1, null))
        et2.setOnKeyListener(GenericKeyEvent(et2, et1))
        et3.setOnKeyListener(GenericKeyEvent(et3, et2))
        et4.setOnKeyListener(GenericKeyEvent(et4, et3))

        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                textView.setText("00:" + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                textView.setText("00:00")
            }
        }.start()

        yesBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
        val window = dialog.window
        window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
//        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun notificationserviceproviderDialog(context : Context) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_after_accepting)
        val et1 = dialog.findViewById(R.id.namepopup) as TextView
        val et2 = dialog.findViewById(R.id.Contactpopup) as TextView
        val et3 = dialog.findViewById(R.id.mentionchargespopup) as TextView
        val et4 = dialog.findViewById(R.id.descriptionpopup) as EditText
        val SendBtn = dialog.findViewById<Button>(R.id.btnSend)


        et1.addTextChangedListener(GenericTextWatcher(et1, et2))
        et2.addTextChangedListener(GenericTextWatcher(et2, et3))
        et3.addTextChangedListener(GenericTextWatcher(et3, et4))
        et4.addTextChangedListener(GenericTextWatcher(et4, null))

        SendBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
        val window = dialog.window
        window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT)
//        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }





    fun rateThisApp(context: Context) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.rate_this_app)
        val yesBtn = dialog.findViewById<Button>(R.id.btnSave)
//            val bodyTitle = dialog.findViewById<TextView>(R.id.txtAlertTitle)
//            bodyTitle.text = title
        yesBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
        val window = dialog.window
        window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun showProgressDialog(context: Context?) {
        if (context != null) {
            try {
                dialogProgress?.dismiss()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        dialogProgress = ProgressDialog(context, R.style.ProgressDialogStyle)
        if (dialogProgress!!.getWindow() != null) {
            dialogProgress!!.getWindow()!!.setLayout(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
        dialogProgress!!.setMessage("Please wait.")
        if (!dialogProgress!!.isShowing()) {
            try {
                dialogProgress?.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        dialogProgress!!.setCancelable(false)
    }
    fun isOnline(context: Context): Boolean {
        val conMgr = context!!
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo
        return !(netInfo == null || !netInfo.isConnected || !netInfo.isAvailable)
    }
    fun disMissProgressDialog(mContext: Context?) {
        try {
            if (dialogProgress != null) {
                dialogProgress?.dismiss()
                dialogProgress = null
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun alertBox(message: String,context: Context) {
        var alertDialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        builder.setMessage(message)
        builder.setPositiveButton("ok") { dialogInterface, which ->
            alertDialog!!.dismiss()
        }
        alertDialog = builder.create()
        alertDialog!!.setCancelable(false)
        alertDialog!!.show()
    }
}