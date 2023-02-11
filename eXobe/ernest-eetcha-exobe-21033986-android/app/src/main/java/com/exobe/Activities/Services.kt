package com.exobe.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.DisplayMetrics
import android.view.View
import android.widget.*
import com.example.validationpractice.utlis.FormValidation
import com.exobe.Activities.services.filldetails_service_provider
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.exobe.bottomsheet.CustomerBottomSheet
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class Services : AppCompatActivity() {

    lateinit var CustomerLogin:ImageView
    lateinit var RetailerLogin:ImageView
    lateinit var ServiceProvider:ImageView
    var passwordNotVisible = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)


        CustomerLogin= findViewById(R.id.CustomerLogin)
        RetailerLogin= findViewById(R.id.RetailerLogin)
        ServiceProvider= findViewById(R.id.ServiceProvider_TextView)
        ServiceProvider= findViewById(R.id.ServiceProvider_TextView)

        CustomerLogin.setOnClickListener {
            SavedPrefManager.saveStringPreferences(
                this,
                SavedPrefManager.USER_TYPE,
                "CUSTOMER"
            )
            SavedPrefManager.saveStringPreferences(this, SavedPrefManager.priceTag, "Customer")
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtra("flag", "Customer")
            startActivity(intent)
        }


        RetailerLogin.setOnClickListener {
            SavedPrefManager.saveStringPreferences(
                this,
                SavedPrefManager.USER_TYPE,
                "RETAILER"
            )
            SavedPrefManager.saveStringPreferences(this, SavedPrefManager.priceTag, "Retailer")
            CustomerBottomSheet("Retailer", this).show(
                supportFragmentManager,
                "ModalBottomSheet"
            )

        }

        ServiceProvider.setOnClickListener {
                CustomerBottomSheet("Service_Provider", this).show(
                    supportFragmentManager,
                    "ModalBottomSheet"
                )
            }
//            user_type_login("Service_Provider")
        }

    }

//    private fun user_type_login(flag: String) {
//
//        // on below line we are creating a new bottom sheet dialog.
//        val dialog = BottomSheetDialog(this)
//
//        // on below line we are inflating a layout file which we have created.
//        val view = layoutInflater.inflate(R.layout.login_bottom_sheet, null)
//        val metrics = DisplayMetrics()
//        windowManager?.defaultDisplay?.getMetrics(metrics)
//        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
//        dialog.behavior.peekHeight = metrics.heightPixels
//
//
//        var customer = view.findViewById<LinearLayout>(R.id.Customer_login)
//        var retailer = view.findViewById<LinearLayout>(R.id.Retailer_login)
//
//
//        var register = view.findViewById<LinearLayout>(R.id.Register)
//        var forgotPassword = view.findViewById<TextView>(R.id.ForgotPassword)
//        var PhoneEditText = view.findViewById<EditText>(R.id.PhoneEditText)
//        var PhoneTV = view.findViewById<TextView>(R.id.PhoneTV)
//        var PasswordEditText = view.findViewById<EditText>(R.id.PasswordEditText)
//        var PasswordTextView = view.findViewById<TextView>(R.id.PasswordTextView)
//        var LogINClick = view.findViewById<Button>(R.id.LogINClick)
//        var PhoneLinear = view.findViewById<LinearLayout>(R.id.PhoneLinear)
//        var PaswordLL = view.findViewById<LinearLayout>(R.id.PaswordLL)
//        var cross_eye = view.findViewById<ImageView>(R.id.cross_eye_bottomsheet)
//        var RetalierLinear = view.findViewById<LinearLayout>(R.id.RetalierLinear)
//        var Retalierid = view.findViewById<LinearLayout>(R.id.Retalierid)
//        var cross = view.findViewById<LinearLayout>(R.id.cross)
//        var RetailerET = view.findViewById<EditText>(R.id.RetailerET)
//        var Retailer_TV = view.findViewById<TextView>(R.id.Retailer_TV)
////        var ServiceProvider = view.findViewById<LinearLayout>(R.id.ServiceProvider_LinearLayout)
//
//        var emailEditText = view.findViewById<EditText>(R.id.PhoneEditText)
//        var TV = view.findViewById<TextView>(R.id.TV)
//        var TVPassword = view.findViewById<TextView>(R.id.TVPassword)
//
//        cross.setOnClickListener {
//            dialog.dismiss()
//        }
//
//
//        if (flag.equals("Retailer")) {
//            retailer.visibility = View.VISIBLE
//            customer.visibility = View.GONE
//        } else {
//            customer.visibility = View.VISIBLE
//            retailer.visibility = View.GONE
//        }
////            customer.visibility = View.GONE
////            retailer.visibility = View.VISIBLE
////            ServiceProvider.visibility = View.GONE
//
//        cross_eye.setOnClickListener {
//            if (passwordNotVisible == 0) {
//                PasswordEditText.transformationMethod =
//                    HideReturnsTransformationMethod.getInstance()
//                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
//                PasswordEditText.setSelection(PasswordEditText.length())
//                passwordNotVisible = 1
//
//            } else if (passwordNotVisible == 1) {
//                PasswordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
//                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash_solid))
//                PasswordEditText.setSelection(PasswordEditText.length())
//                passwordNotVisible = 0
//            } else {
//                PasswordEditText.transformationMethod =
//                    HideReturnsTransformationMethod.getInstance()
//                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
//                PasswordEditText.setSelection(PasswordEditText.length())
//                passwordNotVisible = 1
//            }
//        }
//
//
//
//        LogINClick.setOnClickListener {
//            if (flag.equals("Retailer")) {
//                FormValidation.RetailerLogin(
//
//                    PasswordEditText,
//                    TVPassword,
//                    RetailerET,
//                    Retailer_TV, RetalierLinear, PaswordLL
//                )
//                if (TVPassword.text.equals("") && Retailer_TV.text.equals("")
//                ) {
//                    dialog.dismiss()
//                    SavedPrefManager.saveStringPreferences(
//                        this,
//                        SavedPrefManager.isLogin,
//                        "true"
//                    )
//
//                    val intent = Intent(this, fillDetails_retailer::class.java)
//                    startActivity(intent)
//
//                }
//            } else {
//                FormValidation.CustomerLogin(
//
//                    PasswordEditText,
//                    TVPassword,
//                    emailEditText,
//                    TV, PhoneLinear, PaswordLL
//                )
//                if (TVPassword.text.equals("") && TV.text.equals("")
//                ) {
//                    dialog.dismiss()
//                    val intent = Intent(this, filldetails_service_provider::class.java)
//                    startActivity(intent)
//                }
//            }
//        }
//
//
//
//            register.setOnClickListener {
//                if (flag.equals("Retailer")) {
//                    startActivity(Intent(this, Register_retailer::class.java))
//                } else {
//                    startActivity(Intent(this, Registration_serviceprovider::class.java))
//
//                }
//
//            }
//
//            forgotPassword.setOnClickListener {
//                startActivity(Intent(this, ForgotPassword::class.java))
//            }
//
//            dialog.setCancelable(true)
//
//            dialog.setContentView(view)
//
//            dialog.show()
//        }
//

