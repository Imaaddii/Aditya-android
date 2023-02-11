package com.exobe.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.forgotpassword_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject

class ForgotPassword : AppCompatActivity() ,ApiResponseListener<forgotpassword_response>{

    lateinit var Forgotback:LinearLayout
    lateinit var ForgotSubmit: Button
    lateinit var EmailAddress_et: EditText
    lateinit var PhoneNumberTV: TextView
    lateinit var EmailAddress: LinearLayout
    lateinit var mContext: Context
    val emailPattern =
        "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    lateinit var email:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        mContext = this?.applicationContext!!
        Forgotback = findViewById(R.id.Forgotback)
        ForgotSubmit = findViewById(R.id.ForgotSubmit)
        EmailAddress_et = findViewById(R.id.EmailAddress_et)
        PhoneNumberTV = findViewById(R.id.PhoneNumberTV)
        EmailAddress = findViewById(R.id.EmailAddress)


        Forgotback.setOnClickListener {
            finish()
        }

        ForgotSubmit.setOnClickListener {

            PhoneNumberTV.text=""
            EmailAddress.setBackgroundResource(R.drawable.white_border)
            if(EmailAddress_et.text.isEmpty()){
                PhoneNumberTV.text= "*Please enter email address"
                EmailAddress.setBackgroundResource(R.drawable.input_error)
            } else  if(!EmailAddress_et.text.matches(Regex(emailPattern))){
                PhoneNumberTV.text= "*Enter valid email address"
                EmailAddress.setBackgroundResource(R.drawable.input_error)
            }

            else{
                PhoneNumberTV.text= ""

                email=EmailAddress_et.text.toString()
                ForgotPasswordAPI(email)
            }

        }

    }

    fun ForgotPasswordAPI(email: String) {

        if (androidextention.isOnline(this)) {
            androidextention.showProgressDialog(this)

            val serviceManager = ServiceManager(this)
            val callBack: ApiCallBack<forgotpassword_response> =
                ApiCallBack<forgotpassword_response>(this, "ForgotPasswordAPI", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("email",email)


            try {
                serviceManager.forgotpasswordApi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }

    override fun onApiSuccess(response: forgotpassword_response, apiName: String?) {
        androidextention.disMissProgressDialog(this)
        if (response.responseCode==200){
            val intent = Intent(this, OtpVerification::class.java)
            intent.putExtra("email", email)
            intent.putExtra("flag", "ForgotPassword")
            intent.putExtra("flag1", "forgortpassword")
            startActivity(intent)
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

}