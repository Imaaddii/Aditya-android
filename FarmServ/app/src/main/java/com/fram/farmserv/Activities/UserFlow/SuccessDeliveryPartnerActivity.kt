package com.fram.farmserv.Activities.UserFlow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.fram.farmserv.Activities.BaseActivity.BaseActivity
import com.fram.farmserv.R

class SuccessDeliveryPartnerActivity : BaseActivity() , View.OnClickListener{
    private lateinit var select_and_continue : LinearLayout
    private lateinit var back_button: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setcontent_View())
        Initialize_id()
        initializedControl()
        setOnClickListener()
    }

    override fun setcontent_View(): Int {
        return R.layout.activity_success_delivery_partner
    }

    override fun setOnClickListener() {
        select_and_continue.setOnClickListener(this)
        back_button.setOnClickListener(this)
    }

    override fun Initialize_id() {
        select_and_continue = findViewById(R.id.select_and_continue)
        back_button = findViewById(R.id.header_back_button)
    }

    override fun initializedControl() {

    }

    override fun onClick(v: View?) {
        when(v?.id){

            R.id.header_back_button -> {
                finish()
            }

            R.id.select_and_continue -> {
                val intent = Intent(this, ErrorDeliveryPartnerActivity::class.java)
                startActivity(intent)
            }
        }
    }


}