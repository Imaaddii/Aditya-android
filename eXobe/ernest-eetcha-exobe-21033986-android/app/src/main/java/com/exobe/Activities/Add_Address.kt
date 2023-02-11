package com.exobe.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.validationpractice.utlis.FormValidation
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.AddAddressResponse
import com.exobe.entity.Response.update_profile_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject

class Add_Address(var editflag: String) : Fragment() {
    //    lateinit var title: TextView
    lateinit var backButton: ImageView
    lateinit var save_button: Button
    lateinit var update_button: Button
    lateinit var cancel_button: Button
    lateinit var mContext: Context

    lateinit var et_firstname: EditText
    lateinit var et_lastname: EditText

    lateinit var et_address: EditText
    lateinit var et_transport: EditText
    lateinit var EmailEt: EditText
    lateinit var CityEt: EditText
    lateinit var et_contactnumber: EditText

    val Name = "^[A-Za-z]+R"

    lateinit var tv_firstname: TextView
    lateinit var tv_lastname: TextView
    lateinit var tv_contactnumber: TextView
    lateinit var tv_gst: TextView
    lateinit var tv_postcode: TextView
    lateinit var tv_address: TextView
    lateinit var tv_transport: TextView
    lateinit var Address1: TextView
    lateinit var CityTV: TextView
    lateinit var Country: TextView
    lateinit var firstname: String
    lateinit var lastname: String
    lateinit var contactnumber: String

    lateinit var address: String
    lateinit var transport: String
    //var editflag=""

    lateinit var title: TextView
    lateinit var emailTV: TextView
    lateinit var mainHeader: RelativeLayout
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_retailer_homepage, container, false)

        var view = inflater.inflate(R.layout.activity_add_address, container, false)
        setToolbar()
//        title=view.findViewById(R.id.title)
        backButton = view.findViewById(R.id.backButton)
        save_button = view.findViewById(R.id.save_button)
        update_button = view.findViewById(R.id.update_button)
        cancel_button = view.findViewById(R.id.cancel_button)
        tv_firstname = view.findViewById(R.id.tv_firstname)
        et_firstname = view.findViewById(R.id.et_firstname)
        et_lastname = view.findViewById(R.id.et_lastname)
        mContext = activity?.applicationContext!!

        emailTV = view.findViewById(R.id.emailTV)
        et_contactnumber = view.findViewById(R.id.et_contactnumber)
        et_address = view.findViewById(R.id.et_address)
        et_transport = view.findViewById(R.id.et_transport)
        tv_lastname = view.findViewById(R.id.tv_lastname)
        tv_contactnumber = view.findViewById(R.id.tv_contactnumber)
        tv_gst = view.findViewById(R.id.tv_gst)
        tv_postcode = view.findViewById(R.id.tv_postcode)
        CityEt = view.findViewById(R.id.CityEt)
        Address1 = view.findViewById(R.id.Address1)
        CityTV = view.findViewById(R.id.CityTV)
        Country                                                                                                                                                                                                                                                                                                                                                                                                               = view.findViewById(R.id.Country)
        EmailEt = view.findViewById(R.id.EmailEt)
        title = activity?.findViewById(R.id.PreLoginTitle_TextView2)!!

        firstname = et_firstname.text.toString()
        lastname = et_lastname.text.toString()
        address = et_address.text.toString()
        transport = et_transport.text.toString()

        save_button.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        update_button.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        cancel_button.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE


        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }
//        backButton.setOnClickListener {
////            finish()
//        }
        if (editflag.equals("Edit")) {
            title.setText("Edit Address")
            update_button.visibility = View.VISIBLE
            save_button.visibility = View.GONE

            save_button.setOnClickListener {
                validations()

            }

        } else {
            title.setText("Add Address")
            update_button.visibility = View.GONE
            save_button.visibility = View.VISIBLE

            save_button.setOnClickListener {

                validations()
//              var firstname
//               var lastname
//               var mobilenumber
//               var countrycode
//               var email
//               var address1
//               var city
//               var postalcode
//               var country
            }
        }


        return view
    }

    fun setToolbar() {

        cart = activity?.findViewById(R.id.cart_icon)!!
        filter = activity?.findViewById(R.id.filter_icon)!!
        back = activity?.findViewById(R.id.imageView_back)!!
        MenuClick = activity?.findViewById(R.id.MenuClick)!!
        ProductImageView = activity?.findViewById(R.id.Product_ImageView)!!
        DealsImageView = activity?.findViewById(R.id.Deals_ImageView)!!
        greyBellImageView = activity?.findViewById(R.id.greyBell_ImageView)!!
        cart.visibility = View.GONE
        filter.visibility = View.GONE
        back.visibility = View.VISIBLE

        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
//        title.setText("Products")
    }

      fun validations(){
          var FName = et_firstname.text
          var lName = et_lastname.text
          var Phone = et_contactnumber.text

          clearFields()

          if (et_firstname.text.isEmpty()){
              et_firstname.requestFocus()
              tv_firstname.visibility=View.VISIBLE
              tv_firstname.text="*please enter first name"
              et_firstname.setBackgroundResource(R.drawable.input_error)
          }else if (FName.length < 2 ){
              et_firstname.requestFocus()
              tv_firstname.visibility=View.VISIBLE
              tv_firstname.text="*please enter a valid first name"
              et_firstname.setBackgroundResource(R.drawable.input_error)
          }else if (et_lastname.text.isEmpty()){
              et_lastname.requestFocus()
              tv_lastname.visibility=View.VISIBLE
              tv_lastname.text="*please enter last name"
              et_lastname.setBackgroundResource(R.drawable.input_error)
          }else if (lName.length < 2 ){
              et_lastname.requestFocus()
              tv_lastname.visibility=View.VISIBLE
              tv_lastname.text="*please enter a valid last name"
              et_lastname.setBackgroundResource(R.drawable.input_error)
          }else if (et_contactnumber.text.isEmpty()){
              et_contactnumber.requestFocus()
              tv_contactnumber.visibility=View.VISIBLE
              tv_contactnumber.text="*please enter phone number"
              et_contactnumber.setBackgroundResource(R.drawable.input_error)
          }else if (Phone.length < 7){
              et_contactnumber.requestFocus()
              tv_contactnumber.visibility=View.VISIBLE
              tv_contactnumber.text="*please enter a valid phone number"
              et_contactnumber.setBackgroundResource(R.drawable.input_error)
          }else if(EmailEt.text.isEmpty()){
              EmailEt.requestFocus()
              emailTV.visibility=View.VISIBLE
              emailTV.text="*please enter email"
              EmailEt.setBackgroundResource(R.drawable.input_error)
          }else if(!(FormValidation.isEmail(EmailEt.text.toString()))){
              EmailEt.requestFocus()
              emailTV.visibility=View.VISIBLE
              emailTV.text="*please enter a valid email"
              EmailEt.setBackgroundResource(R.drawable.input_error)
          }else if (et_address.text.isEmpty()){
              et_address.requestFocus()
              Address1.visibility=View.VISIBLE
              Address1.text="*please enter your address"
              et_address.setBackgroundResource(R.drawable.input_error)
          }else if (CityEt.text.isEmpty()){
              CityEt.requestFocus()
              CityTV.visibility=View.VISIBLE
              CityTV.text="*please enter your city"
              CityEt.setBackgroundResource(R.drawable.input_error)
          }else if (et_transport.text.isEmpty()){
              et_transport.requestFocus()
              Country.visibility=View.VISIBLE
              Country.text="*please enter your country"
              et_transport.setBackgroundResource(R.drawable.input_error)
          }

      }

    private fun clearFields() {

        tv_firstname.visibility=View.GONE
        tv_firstname.text=""
        et_firstname.setBackgroundResource(R.drawable.white_border)


        tv_lastname.visibility=View.GONE
        tv_lastname.text=""
        et_lastname.setBackgroundResource(R.drawable.white_border)

        tv_contactnumber.visibility=View.GONE
        tv_contactnumber.text=""
        et_contactnumber.setBackgroundResource(R.drawable.white_border)


        emailTV.visibility=View.GONE
        emailTV.text=""
        EmailEt.setBackgroundResource(R.drawable.white_border)

        Address1.visibility=View.GONE
        Address1.text=""
        et_address.setBackgroundResource(R.drawable.white_border)


        CityTV.visibility=View.GONE
        CityTV.text=""
        CityEt.setBackgroundResource(R.drawable.white_border)




        Country.visibility=View.GONE
        Country.text=""
        et_transport.setBackgroundResource(R.drawable.white_border)
    }

    fun AddAddressAPI(
        firstname: String,
        lastname: String,
        mobilenumber: String,
        countrycode: String,
        email:String,
        address1:String,
        city:String,
        postalcode: String,
        country: String
    ) {

        if (androidextention.isOnline(mContext)) {
            androidextention.showProgressDialog(activity)
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<AddAddressResponse> =
                ApiCallBack<AddAddressResponse>(object :
                    ApiResponseListener<AddAddressResponse> {
                    override fun onApiSuccess(response: AddAddressResponse, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)
                        if (response.responseCode == 200) {

                        }

                    }

                    override fun onApiErrorBody(response: String, apiName: String?) {
                        androidextention.disMissProgressDialog(activity)

                        val gson = GsonBuilder().create()
                        var pojo = response_modal_class()

                        try {
                            pojo = gson.fromJson(response, pojo::class.java)
                            androidextention.alertBox(pojo.responseMessage, mContext)

                        } catch (e: Exception) {
                            // handle failure at error parse
                        }
                    }

                    override fun onApiFailure(failureMessage: String?, apiName: String?) {
                        androidextention.disMissProgressDialog(activity)
                    }

                }, "AddAddressAPI", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("firstName", firstname)
            jsonObject.addProperty("lastName", lastname)
            jsonObject.addProperty("mobileNumber", mobilenumber)
            jsonObject.addProperty("email", email)
            jsonObject.addProperty("countryCode", countrycode)
            jsonObject.addProperty("address", address1)
            jsonObject.addProperty("zipCode", postalcode)
            jsonObject.addProperty("city", city)
            jsonObject.addProperty("country", country)

            try {
                serviceManager.AddAddressapi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }



}