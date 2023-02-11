package com.exobe.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.*
import com.example.validationpractice.utlis.FormValidation
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.resetpassword_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject

class ResetPassword : AppCompatActivity(),ApiResponseListener<resetpassword_response>{
    lateinit var PasswordET: EditText
    lateinit var ConfirmPasswordET: EditText
    lateinit var PasswordTV: TextView
    lateinit var ConfirmPasswordTv: TextView
    lateinit var cross_eye: ImageView
    lateinit var cross_eye2: ImageView
    lateinit var PasswordLL: LinearLayout
    lateinit var ConfirmPasswordLL: LinearLayout
    lateinit var ResetSubmit: Button
    private var passwordNotVisible = 0
    lateinit var backReset: ImageView
    lateinit var mContext: Context
    var email= ""
    var password= ""
    var flag=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        mContext = this?.applicationContext!!

        backReset = findViewById(R.id.backReset)
        PasswordET = findViewById(R.id.PasswordET)
        ConfirmPasswordLL = findViewById(R.id.ConfirmPasswordLL)
        ConfirmPasswordET = findViewById(R.id.ConfirmPasswordET)
        PasswordTV = findViewById(R.id.PasswordTV)
        ConfirmPasswordTv = findViewById(R.id.ConfirmPasswordTv)
        cross_eye = findViewById(R.id.cross_eye)
        cross_eye2 = findViewById(R.id.cross_eye2)
        PasswordLL = findViewById(R.id.PasswordLL)
        ResetSubmit = findViewById(R.id.ResetSubmit)

        GET_INTENT()

        backReset.setOnClickListener {
            finish()
        }

        ResetSubmit.setOnClickListener {
            if (FormValidation.ResetPasswordValidations(
                    PasswordET,
                    PasswordTV,
                    ConfirmPasswordET,
                    ConfirmPasswordTv,
                    PasswordLL,
                    ConfirmPasswordLL
                )
            ) {
                password=PasswordET.text.toString()
                resetPasswordApi(email,password)
            }
        }

        passwordShow()

    }
    fun GET_INTENT(){
        if (intent != null) {
            if(intent?.getStringExtra("email") != null) {
                email = intent?.getStringExtra("email")!!
            }

        }
    }


    //     ShowPassword
    private fun passwordShow() {
        cross_eye.setOnClickListener {
            if (passwordNotVisible == 0) {
                PasswordET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
                PasswordET.setSelection(PasswordET.length())
                passwordNotVisible = 1


            } else if (passwordNotVisible == 1) {
                PasswordET.transformationMethod = PasswordTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash_solid))
                PasswordET.setSelection(PasswordET.length())
                passwordNotVisible = 0
            } else {
                PasswordET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
                PasswordET.setSelection(PasswordET.length())
                passwordNotVisible = 1
            }
        }
        cross_eye2.setOnClickListener {
            if (passwordNotVisible == 0) {
                ConfirmPasswordET.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                cross_eye2.setImageDrawable(resources.getDrawable(R.drawable.eye))
                ConfirmPasswordET.setSelection(ConfirmPasswordET.length())
                passwordNotVisible = 1


            } else if (passwordNotVisible == 1) {
                ConfirmPasswordET.transformationMethod = PasswordTransformationMethod.getInstance()
                cross_eye2.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash_solid))
                ConfirmPasswordET.setSelection(ConfirmPasswordET.length())
                passwordNotVisible = 0
            } else {
                ConfirmPasswordET.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                cross_eye2.setImageDrawable(resources.getDrawable(R.drawable.eye))
                ConfirmPasswordET.setSelection(ConfirmPasswordET.length())
                passwordNotVisible = 1
            }
        }
    }

    fun resetPasswordApi(email: String,password :String) {

        if (androidextention.isOnline(this)) {
            androidextention.showProgressDialog(this)

            val serviceManager = ServiceManager(this)
            val callBack: ApiCallBack<resetpassword_response> =
                ApiCallBack<resetpassword_response>(this, "resetPasswordApi", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("email", email)
            jsonObject.addProperty("newPassword", password)


            try {
                serviceManager.ResetPasswordApi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }

    override fun onApiSuccess(response: resetpassword_response, apiName: String?) {
        androidextention.disMissProgressDialog(this)
        if (response.responseCode==200){
            val intent = Intent(this, MainActivity::class.java)
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