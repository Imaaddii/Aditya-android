package com.fram.farmserv.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.fram.farmserv.Activities.BaseActivity.BaseActivity
import com.fram.farmserv.Activities.UserFlow.LetsSignInActivity
import com.fram.farmserv.R
import com.fram.farmserv.utils.androidextention
import com.fram.farmserv.utils.androidextention.activityIntent

class MainActivity : BaseActivity(), View.OnClickListener {
    private lateinit var get_started : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setcontent_View())
        Initialize_id()
        initializedControl()
        setOnClickListener()
    }

    override fun setcontent_View(): Int {
        return R.layout.activity_main
    }

    override fun setOnClickListener() {
        get_started.setOnClickListener(this)
    }

    override fun Initialize_id() {
        get_started = findViewById(R.id.get_started)
    }

    override fun initializedControl() {

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.get_started -> {
                val intent = Intent(this, LetsSignInActivity::class.java)
                startActivity(intent)
            }
        }
    }

}