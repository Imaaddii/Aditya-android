package com.fram.farmserv.Activities.UserFlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fram.farmserv.Activities.BaseActivity.BaseActivity
import com.fram.farmserv.R

class OtpActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setcontent_View())
    }

    override fun setcontent_View(): Int {
        return R.layout.activity_otp
    }

    override fun setOnClickListener() {

    }

    override fun Initialize_id() {

    }

    override fun initializedControl() {

    }
}