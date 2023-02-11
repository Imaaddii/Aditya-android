package com.fram.farmserv.Activities.UserFlow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.fram.farmserv.Activities.BaseActivity.BaseActivity
import com.fram.farmserv.Activities.FragmentContainerActivity
import com.fram.farmserv.R

class ErrorDeliveryPartnerActivity :  BaseActivity() , View.OnClickListener {
   private lateinit var not_now :LinearLayout
    private lateinit var back_button: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setcontent_View())
        Initialize_id()
        initializedControl()
        setOnClickListener()
    }


    override fun setcontent_View(): Int {
       return R.layout.activity_error_delivery_partner
    }

    override fun setOnClickListener() {
        not_now.setOnClickListener(this)
        back_button.setOnClickListener(this)
    }

    override fun Initialize_id() {
        not_now = findViewById(R.id.not_now)
        back_button = findViewById(R.id.header_back_button)
    }

    override fun initializedControl() {

    }


    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.not_now -> {
                val intent = Intent(this, FragmentContainerActivity::class.java)
                startActivity(intent)
            }
            R.id.header_back_button -> {
                finish()
            }
        }
    }
}