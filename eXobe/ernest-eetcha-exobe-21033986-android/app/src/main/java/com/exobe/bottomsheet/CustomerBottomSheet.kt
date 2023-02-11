package com.exobe.bottomsheet

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import com.example.validationpractice.utlis.FormValidation
import com.exobe.Activities.*
import com.exobe.Activities.services.ServicesMainActivity
import com.exobe.Activities.services.filldetails_service_provider
import com.exobe.Fragments.RetailerHomepage
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.exobe.androidextention
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.login_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject

class CustomerBottomSheet(var flag: String, var mContext: Context) : BottomSheetDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), theme).apply {
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            behavior.peekHeight = ViewGroup.LayoutParams.MATCH_PARENT
        }
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.login_bottom_sheet, null)

        var passwordNotVisible = 0

        var customer = view.findViewById<LinearLayout>(R.id.Customer_login)
        var retailer = view.findViewById<LinearLayout>(R.id.Retailer_login)
        var register = view.findViewById<LinearLayout>(R.id.Register)
        var forgotPassword = view.findViewById<TextView>(R.id.ForgotPassword)
        var PasswordEditText = view.findViewById<EditText>(R.id.PasswordEditText)
        var LogINClick = view.findViewById<Button>(R.id.LogINClick)
        var cross_eye = view.findViewById<ImageView>(R.id.cross_eye_bottomsheet)
        var cross = view.findViewById<LinearLayout>(R.id.cross)
        var RetailerET = view.findViewById<EditText>(R.id.RetailerET)
        var Retailer_TV = view.findViewById<TextView>(R.id.Retailer_TV)

//        CustomerIDs

        var PhoneLinear = view.findViewById<LinearLayout>(R.id.PhoneLinear)
        var PaswordLL = view.findViewById<LinearLayout>(R.id.PaswordLL)
        var emailEditText = view.findViewById<EditText>(R.id.PhoneEditText)
        var TV = view.findViewById<TextView>(R.id.TV)
        var TVPassword = view.findViewById<TextView>(R.id.TVPassword)
        var RetalierLinear = view.findViewById<LinearLayout>(R.id.RetalierLinear)

        cross.setOnClickListener {
            dismiss()
        }


        cross_eye.setOnClickListener {
            if (passwordNotVisible == 0) {
                PasswordEditText.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
                PasswordEditText.setSelection(PasswordEditText.length())
                passwordNotVisible = 1

            } else if (passwordNotVisible == 1) {
                PasswordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash_solid))
                PasswordEditText.setSelection(PasswordEditText.length())
                passwordNotVisible = 0
            } else {
                PasswordEditText.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
                PasswordEditText.setSelection(PasswordEditText.length())
                passwordNotVisible = 1
            }
        }


        if (flag.equals("Customer")) {
            customer.visibility = View.VISIBLE
            retailer.visibility = View.GONE

            LogINClick.setOnClickListener {
                FormValidation.CustomerLogin(

                    PasswordEditText,
                    TVPassword,
                    emailEditText,
                    TV, PhoneLinear, PaswordLL
                )
                if (TVPassword.text.equals("") && TV.text.equals("")
                ) {

                    var email = emailEditText.text.toString()
                    var password = PasswordEditText.text.toString()
                    LoginCustomerAPI(email, password)
                }
            }

        } else if (flag.equals("Retailer")) {
            customer.visibility = View.GONE
            retailer.visibility = View.VISIBLE


            LogINClick.setOnClickListener {
                FormValidation.RetailerLogin(

                    PasswordEditText,
                    TVPassword,
                    RetailerET,
                    Retailer_TV, RetalierLinear, PaswordLL
                )
                if (TVPassword.text.equals("") && Retailer_TV.text.equals("")
                ) {
                    SavedPrefManager.saveStringPreferences(
                        mContext,
                        SavedPrefManager.isLogin,
                        "true"
                    )

                    var email = RetailerET.text.toString()
                    var password = PasswordEditText.text.toString()
                    LoginCustomerAPI(email, password)


                }
            }

        } else if (flag.equals("Service_Provider")) {
            customer.visibility = View.VISIBLE
            retailer.visibility = View.GONE

            LogINClick.setOnClickListener {
                FormValidation.CustomerLogin(

                    PasswordEditText,
                    TVPassword,
                    emailEditText,
                    TV, PhoneLinear, PaswordLL
                )
                if (TVPassword.text.equals("") && TV.text.equals("")
                ) {
                    dismiss()
                    val intent = Intent(mContext, filldetails_service_provider::class.java)
                    startActivity(intent)
                }
            }
        }
        register.setOnClickListener {
            if (flag.equals("Customer")) {
                startActivity(Intent(mContext, RegisterActivity::class.java))

            } else if (flag.equals("Retailer")) {
                startActivity(Intent(mContext, Register_retailer::class.java))
            } else {
                startActivity(Intent(mContext, Registration_serviceprovider::class.java))
            }
        }

        forgotPassword.setOnClickListener {
            startActivity(Intent(mContext, ForgotPassword::class.java))
        }

        return view
    }

    fun LoginCustomerAPI(email: String, password: String) {

        if (androidextention.isOnline(mContext)) {
            androidextention.showProgressDialog(mContext)
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<login_response> =
                ApiCallBack<login_response>(object : ApiResponseListener<login_response> {
                    override fun onApiSuccess(response: login_response, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)
                        if (response.responseCode == 200) {
                            if (flag.equals("Customer")) {
                                if (response.result!!.otpVerification == true) {

                                    SavedPrefManager.saveStringPreferences(
                                        mContext,
                                        SavedPrefManager.TOKEN,
                                        response.result!!.token
                                    )
                                    SavedPrefManager.saveStringPreferences(
                                        mContext,
                                        SavedPrefManager.USER_TYPE,
                                        response.result.userType
                                    )

                                    SavedPrefManager.saveStringPreferences(
                                        mContext,
                                        SavedPrefManager.isLogin,
                                        "true"
                                    )
                                    val intent = Intent(mContext, MainActivity::class.java)
                                    intent.putExtra("flag", "Customer")
                                    startActivity(intent)
                                } else {
                                    val intent = Intent(mContext, OtpVerification::class.java)
                                    intent.putExtra("email", email)
                                    intent.putExtra("flag1", "login")
                                    startActivity(intent)

                                }
                            } else if (flag.equals("Retailer")) {
                                SavedPrefManager.saveStringPreferences(
                                    mContext,
                                    SavedPrefManager.TOKEN,
                                    response.result!!.token
                                )
                                SavedPrefManager.saveStringPreferences(
                                    mContext,
                                    SavedPrefManager.USER_TYPE,
                                    response.result?.userType
                                )

                                SavedPrefManager.saveStringPreferences(
                                    mContext,
                                    SavedPrefManager.isLogin,
                                    "true"
                                )
                                val intent = Intent(mContext, MainActivity::class.java)
                                intent.putExtra("flag", "Retailer")
                                startActivity(intent)
//                                val intent = Intent(mContext, fillDetails_retailer::class.java)
//                                startActivity(intent)
                            } else {
                                SavedPrefManager.saveStringPreferences(
                                    mContext,
                                    SavedPrefManager.isLogin,
                                    "true"
                                )
                                val intent =
                                    Intent(mContext, filldetails_service_provider::class.java)
                                startActivity(intent)
                            }


                        }
                    }

                    override fun onApiErrorBody(response: String, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)

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
                        androidextention.disMissProgressDialog(mContext)
                    }

                }, "LoginCustomer", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("emailNumberId", email)
            jsonObject.addProperty("password", password)


            try {
                serviceManager.LoginApi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }


}