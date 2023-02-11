package com.fram.farmserv.Activities.UserFlow

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.fram.farmserv.Activities.BaseActivity.BaseActivity
import com.fram.farmserv.Activities.FragmentContainerActivity
import com.fram.farmserv.R

class LetsSignInActivity : BaseActivity(), View.OnClickListener {
    private lateinit var back_button: ImageView
    private lateinit var get_otp: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setcontent_View())
        Initialize_id()
        initializedControl()
        setOnClickListener()

    }

    override fun setcontent_View(): Int {
        return R.layout.activity_lets_sign_in
    }

    override fun setOnClickListener() {
        back_button.setOnClickListener(this)
        get_otp.setOnClickListener(this)
    }

    override fun Initialize_id() {
        back_button = findViewById(R.id.header_back_button)
        get_otp = findViewById(R.id.get_otp)
    }

    override fun initializedControl() {

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.header_back_button -> {
                finish()
            }

            R.id.get_otp -> {
                val intent = Intent(this, SuccessDeliveryPartnerActivity::class.java)
                startActivity(intent)



            }

        }
    }
}