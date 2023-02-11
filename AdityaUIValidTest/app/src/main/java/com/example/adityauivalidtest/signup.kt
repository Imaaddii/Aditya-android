package com.example.adityauivalidtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import de.hdodenhof.circleimageview.CircleImageView
import java.util.regex.Pattern

class signup : AppCompatActivity() {

     lateinit var imagepicker : CircleImageView
     lateinit var clickimage : ImageView
    lateinit var backtologin: TextView
    lateinit var etname: EditText
    lateinit var tvnameerror: TextView
    lateinit var etusername: EditText
    lateinit var tvusernameerror: TextView
    lateinit var etemail: EditText
    lateinit var tvemailerror: TextView
    lateinit var etnumber: EditText
    lateinit var tvnumbererror: TextView
    lateinit var etpassword: TextInputEditText
    lateinit var tvpassworderror: TextInputLayout
    lateinit var etconfirmpassword: TextInputEditText
    lateinit var tvconfirmpassworderror: TextInputLayout
    lateinit var etbio: TextInputEditText
    lateinit var tvbio: TextInputLayout
    lateinit var submitbtn: Button
    lateinit var checkboxError: TextView
    lateinit var checkboxClick: CheckBox
    val SELECT_IMAGE_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        imagepicker = findViewById(R.id.imagepicker)
        clickimage = findViewById(R.id.clickimage)

        clickimage.setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent,"Title"),SELECT_IMAGE_CODE)
        }

        var backbutton = findViewById<ImageView>(R.id.backclick)
        backbutton.setOnClickListener {
            finish()
        }
        backtologin = findViewById(R.id.backtologin)
        backtologin.setOnClickListener {
            finish()
        }

        etname = findViewById(R.id.etname)
        tvnameerror = findViewById(R.id.tvnameerror)
        etusername = findViewById(R.id.etusername)
        tvusernameerror = findViewById(R.id.tvusernameerror)
        etemail = findViewById(R.id.etemail)
        tvemailerror = findViewById(R.id.tvemailerror)
        etnumber = findViewById(R.id.etnumber)
        tvnumbererror = findViewById(R.id.tvnumbererror)
        etpassword = findViewById(R.id.etpassword)
        tvpassworderror = findViewById(R.id.tvpassworderror)
        etconfirmpassword = findViewById(R.id.etconfirmpassword)
        tvconfirmpassworderror = findViewById(R.id.tvconfirmpassworderror)
        etbio = findViewById(R.id.etbio)
        tvbio = findViewById(R.id.tvbioerror)
        submitbtn = findViewById(R.id.submitbtn)
        checkboxClick = findViewById(R.id.checkboxClick)
        checkboxError = findViewById(R.id.checkboxError)

        submitbtn.setOnClickListener() {
            val name = etname.text.toString().trim()
            val username = etusername.text.toString().trim()
            val email = etemail.text.toString().trim()
            val number = etnumber.text.toString().trim()
            val password = etpassword.text.toString().trim()
            val confrmpsd = etconfirmpassword.text.toString().trim()
            tvnameerror.text = ""
            tvusernameerror.text = ""
            tvemailerror.text=""
            tvnumbererror.text = ""
            tvpassworderror.helperText = ""
            tvconfirmpassworderror.helperText = ""
            tvbio.helperText = ""
            checkboxError.text = ""


            if (name.isEmpty())
            {
                tvnameerror.text = "Please enter your full name"
                etname.requestFocus()
            }
            else if (name.length < 2)
            {
                tvnameerror.text = "Please enter valid name must be 2 character"
                etname.requestFocus()

            }
            else if (!isNameValidFormate(name))
            {
                tvnameerror.text = "Please enter valid name"
                etname.requestFocus()

            }
            else if (username.isEmpty())
            {
                tvusernameerror.text = "Please enter username"
                etusername.requestFocus()

            }
            else if (!isUserNameValidFormate(username)) {
                tvusernameerror.text = "Please enter valid username"
                etusername.requestFocus()

            }
             else if (email.isEmpty())
            {
                tvemailerror.text = "Please enter email ID"
                etemail.requestFocus()

            }
            else if (!checkEmail(email))
            {
                tvemailerror.text = "Please enter valid email"
                etemail.requestFocus()

            }
            else if (number.isEmpty())
            {
                tvnumbererror.text = "Please enter number"
                etnumber.requestFocus()

            }
            else if (!isMobileValidFormate(number))
            {
                tvnumbererror.text = "Please enter valid number"
                etnumber.requestFocus()

            }
            else if (password.isEmpty())
            {
                tvpassworderror.helperText = "Please enter password"
                etpassword.requestFocus()

            }
            else if (!isValidPasswordFormat(password))
            {
                tvpassworderror.helperText = "Password invalid"
                etpassword.requestFocus()

            }
            else if (confrmpsd.isEmpty())
            {
                tvconfirmpassworderror.helperText = "Please enter password"
                etconfirmpassword.requestFocus()

            }
            else if (!confrmpsd.equals(password))
            {
                tvconfirmpassworderror.helperText = "Password does not match"
                etconfirmpassword.requestFocus()

            }
            else if (checkboxClick.isChecked == false)
            {
                checkboxError.text = "*please click the checkbox"

            }
            else {
                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show()


            }
        }
    }

    fun isUserNameValidFormate(name: String): Boolean {
        val nameREGEX = Pattern.compile("^[A-Za-z]+\$");
        return nameREGEX.matcher(name).matches()
    }

    fun isNameValidFormate(name: String): Boolean {
        val nameREGEX = Pattern.compile("^[A-Za-z]+$");
        return nameREGEX.matcher(name).matches()
    }

    fun isMobileValidFormate(name: String): Boolean {
        val nameREGEX = Pattern.compile("[0-9]{10}");
        return nameREGEX.matcher(name).matches()
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

    fun isValidPasswordFormat(password: String): Boolean {
        val passwordREGEX = Pattern.compile(
            "^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 8 characters
                    "$"
        )
        return passwordREGEX.matcher(password).matches()

    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1){
            val uri = data?.data
            imagepicker.setImageURI(uri)
        }
    }
}


