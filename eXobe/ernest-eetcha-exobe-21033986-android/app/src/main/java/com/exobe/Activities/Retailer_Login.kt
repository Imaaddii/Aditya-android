package com.exobe.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.example.validationpractice.utlis.FormValidation
import com.exobe.R

class Retailer_Login : AppCompatActivity() {

    lateinit var Register: TextView
    lateinit var retailerPass_TV: TextView
    lateinit var retailerId_TV: TextView
    lateinit var Pass_ET: EditText
    lateinit var Id_ET: EditText
    lateinit var Login_btn: Button
    lateinit var Id_LL: LinearLayout
    lateinit var Pass_LL: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retailer_login)


        Register = findViewById(R.id.Register)
        retailerId_TV = findViewById(R.id.retailerId_TextView)
        retailerPass_TV = findViewById(R.id.retailerPass_TextView)
        Id_LL = findViewById(R.id.retailerId_LinearLayout)
        Pass_LL = findViewById(R.id.retailerPass_LinearLayout)
        Id_ET = findViewById(R.id.retailerId_EditText)
        Pass_ET = findViewById(R.id.retailerPass_EditText)
        Login_btn = findViewById(R.id.Login_btn)


//        Login_btn.setOnClickListener {
//            val Id = Id_ET.text.toString().trim()
//            val Pass = Pass_ET.text.toString().trim()
//
//            FormValidation.editaddress(Id,Id_ET,Pass,Pass_ET,retailerId_TV,retailerPass_TV,Id_LL,Pass_LL)
//
//            if (!Id.equals("") && !Pass.equals(""))
//            {
////                finish()
//                val intent = Intent(this, RetailerRegistration::class.java)
//                startActivity(intent)
//            }
//        }


//        Register.setOnClickListener {
//            val intent = Intent(this, RetailerRegistration::class.java)
//            startActivity(intent)
//        }
    }
}