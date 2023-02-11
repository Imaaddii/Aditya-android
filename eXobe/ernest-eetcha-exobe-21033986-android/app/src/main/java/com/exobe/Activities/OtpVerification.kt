package com.exobe.Activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.bottomsheet.CustomerBottomSheet
import com.exobe.dialogs.CustomerRating
import com.exobe.dialogs.productDialog
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.ResendOtp
import com.exobe.entity.Response.otpverfication_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject


class OtpVerification : AppCompatActivity(), ApiResponseListener<otpverfication_response> {

    lateinit var et1: EditText
    lateinit var et2: EditText
    lateinit var et3: EditText
    lateinit var et4: EditText
    lateinit var textView: TextView
    lateinit var title: TextView
    lateinit var submit: Button
    lateinit var Back: LinearLayout
    lateinit var ResendCode: TextView
    lateinit var OTP: TextView
    lateinit var OtpScreen: LinearLayout
    var flag = ""
    lateinit var mContext: Context
    var email=""
    var flag1=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)

        mContext = this?.applicationContext!!

        et1 = findViewById(R.id.et_1)
        et2 = findViewById(R.id.et_2)
        et3 = findViewById(R.id.et_3)
        et4 = findViewById(R.id.et_4)
        textView = findViewById(R.id.textView)
        Back = findViewById(R.id.Back)
        submit = findViewById(R.id.submit)
        title = findViewById(R.id.title)
        ResendCode = findViewById(R.id.ResendCode)
        OTP = findViewById(R.id.OTP)
        OtpScreen = findViewById(R.id.OtpScreen)
        GET_INTENT()



        Back.setOnClickListener {
            finish()
        }


        et1.addTextChangedListener(GenericTextWatcher(et1, et2))
        et2.addTextChangedListener(GenericTextWatcher(et2, et3))
        et3.addTextChangedListener(GenericTextWatcher(et3, et4))
        et4.addTextChangedListener(GenericTextWatcher(et4, null))


        et1.setOnKeyListener(GenericKeyEvent(et1, null))
        et2.setOnKeyListener(GenericKeyEvent(et2, et1))
        et3.setOnKeyListener(GenericKeyEvent(et3, et2))
        et4.setOnKeyListener(GenericKeyEvent(et4, et3))


        submit.setOnClickListener {

            if (flag.equals("ServiceManagement")) {
                CustomerRating(this).show(supportFragmentManager, "MyCustomFragment")
            } else {
                OTP.text = ""
                OTP.visibility = View.GONE

                if (et1.text.isEmpty()) {
                    OTP.visibility = View.VISIBLE
                    OTP.text = "*please enter otp"

                } else if (et2.text.isEmpty()) {
                    OTP.visibility = View.VISIBLE
                    OTP.text = "*please enter valid otp"
                } else if (et3.text.isEmpty()) {
                    OTP.visibility = View.VISIBLE
                    OTP.text = "*please enter valid otp"
                } else if (et4.text.isEmpty()) {
                    OTP.visibility = View.VISIBLE
                    OTP.text = "*please enter valid otp"
                } else {
                    var et1=et1.text.toString()
                    var et2=et2.text.toString()
                    var et3=et3.text.toString()
                    var et4=et4.text.toString()

                    var otp = "${et1}${et2}${et3}${et4}"


                    otpverfication(otp,email)
                }

            }

        }



        ResendCode.setOnClickListener {
            var et1=et1.text.toString()
            var et2=et2.text.toString()
            var et3=et3.text.toString()
            var et4=et4.text.toString()

            var otp = "${et1}${et2}${et3}${et4}"
            ResendOtpAPI(otp,email)
            supportFragmentManager?.let {
                productDialog(
                    "OTP Resent \nSuccessfully",
                    "OPPRESSED"
                ).show(it, "MyCustomFragment")
            }
            countdown()
        }

        if (flag.equals("ServiceManagement")) {
            title.setText("A SMS Sent To Customer Phone Number Please Enter OTP")
        }



        countdown()


    }

    fun GET_INTENT(){
        if (intent != null) {
            if(intent?.getStringExtra("email") != null) {
                email = intent?.getStringExtra("email")!!
            }
            if(intent?.getStringExtra("flag") != null) {
                flag = intent?.getStringExtra("flag")!!
            }

            if(intent?.getStringExtra("flag1") != null) {
                flag1 = intent?.getStringExtra("flag1")!!
            }


        }
    }
    fun countdown() {

        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                ResendCode.isEnabled = false
                textView.setText("00:" + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                textView.setText("00:00")
                ResendCode.isEnabled = true
            }
        }.start()

    }


    fun otpverfication(otp: String ,email :String) {

        if (androidextention.isOnline(this)) {
            androidextention.showProgressDialog(this)

            val serviceManager = ServiceManager(this)
            val callBack: ApiCallBack<otpverfication_response> =
                ApiCallBack<otpverfication_response>(this, "otpverfication", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("otp", otp)
            jsonObject.addProperty("email", email)


            try {
                serviceManager.otpverficationApi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }

    override fun onApiSuccess(response: otpverfication_response, apiName: String?) {
        androidextention.disMissProgressDialog(this)
        if (response.responseCode==200) {

            if (flag1.equals("register")){
                val intent = Intent(this, Services::class.java)
                startActivity(intent)
            }
            else if(flag1.equals("login")){
                CustomerBottomSheet("Customer", this).show(
                    supportFragmentManager,
                    "ModalBottomSheet")

            }

            else{
                val intent = Intent(this, ResetPassword::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
            }

        }

    }

    override fun onApiErrorBody(response: String, apiName: String?) {
        androidextention.disMissProgressDialog(this)
        val gson = GsonBuilder().create()
        var pojo = response_modal_class()

        try {
            pojo = gson.fromJson(response, pojo::class.java)
            androidextention.alertBox(pojo.responseMessage,this)

        } catch (e: Exception) {
            // handle failure at error parse
        }
    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
        androidextention.disMissProgressDialog(this)
    }

    fun ResendOtpAPI(otp: String ,email: String) {

        if (androidextention.isOnline(this)) {
            androidextention.showProgressDialog(this)

            val serviceManager = ServiceManager(this)
            val callBack: ApiCallBack<ResendOtp> =
                ApiCallBack<ResendOtp>(object : ApiResponseListener<ResendOtp>{
                    override fun onApiSuccess(response: ResendOtp, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)
                        if (response.responseCode==200){
                            val intent = Intent(mContext, OtpVerification::class.java)
                            intent.putExtra("email", email)
                            intent.putExtra("flag", "ForgotPassword")
                            startActivity(intent)
                        }
                    }

                    override fun onApiErrorBody(response: String, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)
                    }

                    override fun onApiFailure(failureMessage: String?, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)
                    }
                }, "ResendOtpAPI", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("email",email)


            try {
                serviceManager.ResendOtpApi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }

}