package com.fram.farmserv.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.fram.farmserv.Activities.BaseActivity.BaseActivity
import com.fram.farmserv.R

class SplashActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setcontent_View())
        Initialize_id()
        initializedControl()
        setOnClickListener()
    }

    override fun setcontent_View(): Int {
        return R.layout.activity_splash
    }

    override fun setOnClickListener() {

    }

    override fun Initialize_id() {

    }

    override fun initializedControl() {
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}