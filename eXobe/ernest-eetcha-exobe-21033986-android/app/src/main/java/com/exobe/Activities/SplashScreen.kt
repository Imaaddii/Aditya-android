package com.exobe.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.exobe.R
import com.exobe.Utils.SavedPrefManager

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            if(SavedPrefManager.getBooleanPreferences(this, SavedPrefManager.TutorialFlag) == true) {
                val intent = Intent(this, Services::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, TutorialScreen::class.java)
                startActivity(intent)
                finish()
            }
        }, 2000) // 3000 is the delayed time in milliseconds.


    }
}