package com.example.adityauivalidtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text
import java.util.regex.Pattern

class login : AppCompatActivity() {
    lateinit var signin: TextView
    lateinit var emailET: EditText
    lateinit var emailRequiredTv: TextView
    lateinit var psdEt : TextInputEditText
    lateinit var errorTv: TextInputLayout
    lateinit var clickBtn: Button
    lateinit var checkboxError : TextView
    lateinit var checkboxClick : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        signin = findViewById(R.id.signin)
        signin.setOnClickListener {
            var sign = signin.text.toString()
            var intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
        clickBtn = findViewById(R.id.clickBtn)
        emailET = findViewById(R.id.emailET)
        emailRequiredTv = findViewById(R.id.emailRequiredTv)
        errorTv = findViewById(R.id.errorTv)
        psdEt = findViewById(R.id.psdEt)
        checkboxClick = findViewById(R.id.checkboxClick)
        checkboxError = findViewById(R.id.checkboxError)

        clickBtn.setOnClickListener {
            val username = emailET.text.toString()
            val password = psdEt.text.toString()
            emailRequiredTv.text = ""
            errorTv.helperText = ""
            checkboxError.text = ""

            if (username.isEmpty()) {
                emailRequiredTv.text = "Please enter email ID"
            } else if (!checkEmail(username)) {
                emailRequiredTv.text = "Please enter valid email"

            } else if (password.isEmpty()) {
                errorTv.helperText = "Please enter password"
            } else if (password.length <= 7) {
                errorTv.helperText = "Password should be 8 character"
            }

            else {
               // Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, recycler::class.java)
                startActivity(intent)
            }
        }


    }

    private fun checkEmail(email: String): Boolean {

        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }
}
