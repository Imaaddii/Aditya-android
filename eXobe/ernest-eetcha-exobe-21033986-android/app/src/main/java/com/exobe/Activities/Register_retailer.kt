package com.exobe.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.validationpractice.utlis.FormValidation
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.bottomsheet.CustomerBottomSheet
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Request.SignupRequest
import com.exobe.entity.Response.RetailerRegisterResponse
import com.exobe.entity.Response.SignupResponse
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject

class Register_retailer : AppCompatActivity(),ApiResponseListener<SignupResponse> {
    lateinit var retailer_register : Button
    lateinit var back : ImageView
    lateinit var title : TextView
    lateinit var firstname_et: EditText
    lateinit var first_name: TextView
    lateinit var LastName_et: EditText
    lateinit var surname_tv: TextView
    lateinit var  email_et:EditText
    lateinit var email_tv:TextView
    lateinit var mobile_editText:EditText
    lateinit var mobile_tv:TextView
    lateinit var password_et:EditText
    lateinit var password_tv:TextView
    lateinit var confirmpassword_et:EditText
    lateinit var confirmpassword_tv:TextView
    lateinit var country:LinearLayout
    lateinit var address:EditText
    lateinit var address_tv:TextView
    lateinit var city:EditText
    lateinit var city_tv:TextView
    lateinit var zipcode:EditText
    lateinit var zipcode_tv:TextView
    lateinit var country1:EditText
    lateinit var address2:EditText
    lateinit var country_tv:TextView
    lateinit var mContext:Context
    var type = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_retailer)
        mContext = this?.applicationContext!!

        retailer_register = findViewById(R.id.retailer_register)
        firstname_et = findViewById(R.id.firstname_et)
        first_name= findViewById(R.id.first_nametv)
        LastName_et= findViewById(R.id.LastName_et)
        surname_tv= findViewById(R.id.surname_tv)
        email_et= findViewById(R.id.email_et)
        email_tv= findViewById(R.id.email_tv)
        mobile_editText= findViewById(R.id.mobile_editText)
        mobile_tv= findViewById(R.id.mobile_tv)
        password_et= findViewById(R.id.password_et)
        password_tv= findViewById(R.id.password_tv)
        confirmpassword_et= findViewById(R.id.confirmpassword_et)
        confirmpassword_tv= findViewById(R.id.confirmpassword_tv)

        country= findViewById(R.id.country)
        address= findViewById(R.id.address)
        address_tv= findViewById(R.id.address_tv)
        city= findViewById(R.id.city)
        city_tv= findViewById(R.id.city_tv)
        zipcode_tv= findViewById(R.id.zipcode_tv)
        zipcode= findViewById(R.id.zipcode)
        country1= findViewById(R.id.country1)
        address2= findViewById(R.id.address2)
        country_tv= findViewById(R.id.country_tv)
        country= findViewById(R.id.country)
        back=findViewById(R.id.back)
        title=findViewById(R.id.title)
        type = "RETAILER"

        title.setText("Register")
        retailer_register.setOnClickListener {
            FormValidation.Retailer_Registration(

                firstname_et,
                first_name,
                LastName_et,
                surname_tv,
                email_et,
                email_tv,
                mobile_editText,
                mobile_tv,country,
                address,
                address_tv,
                city,
                city_tv,
                zipcode,
                zipcode_tv,
                country1,
                country_tv,
                password_et,
                password_tv,
                confirmpassword_et,
                confirmpassword_tv,
            )
            if (first_name.text.equals("") && surname_tv.text.equals("") &&  email_tv.text.equals("") &&  mobile_tv.text.equals("") && password_tv.text.equals("") &&  confirmpassword_tv.text.equals("")
                && address_tv.text.equals("") &&  city_tv.text.equals("")&&  zipcode_tv.text.equals("")&& country_tv.text.equals(""))
            {
                signupRetailer()
            }
        }

        back.setOnClickListener {
            finish()
        }




    }

    fun signupRetailer() {
        if (androidextention.isOnline(this)) {
            androidextention.showProgressDialog(this)
            val serviceManager = ServiceManager(this)
            val callBack: ApiCallBack<SignupResponse> =
                ApiCallBack<SignupResponse>(this, "signupRetailer", mContext)

            val RegisterRequest = SignupRequest()
            RegisterRequest.userType = type
            RegisterRequest.firstName =firstname_et.text.toString()
            RegisterRequest.lastName=LastName_et.text.toString()
            RegisterRequest.email=email_et.text.toString()
            RegisterRequest.countryCode="+27"
            RegisterRequest.mobileNumber=mobile_editText.text.toString()
            RegisterRequest.password=password_et.text.toString()
            RegisterRequest.addressLine1=address.text.toString()
            RegisterRequest.addressLine2=address2.text.toString()
            RegisterRequest.city=city.text.toString()
            RegisterRequest.zipCode=zipcode.text.toString()
            RegisterRequest.country=country1.text.toString()

            RegisterRequest.govtDocument?.frontImage=""
            try {
                serviceManager.SignupApi(callBack, RegisterRequest)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }

    override fun onApiSuccess(response: SignupResponse, apiName: String?) {
        androidextention.disMissProgressDialog(this)
        if (response!!.responseCode == 200) {

            supportFragmentManager?.let { it1 ->
                CustomerBottomSheet("Retailer", mContext).show(
                    it1,
                    "ModalBottomSheet")
            }
        }

    }

    override fun onApiErrorBody(response: String, apiName: String?) {
        androidextention.disMissProgressDialog(this)
        val gson = GsonBuilder().create()
        var pojo = response_modal_class()

        try {
            pojo = gson.fromJson(response, pojo::class.java)
            androidextention.alertBox(pojo.responseMessage, this)

        } catch (e: Exception) {
            // handle failure at error parse
        }
    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
        androidextention.disMissProgressDialog(this)
    }

}