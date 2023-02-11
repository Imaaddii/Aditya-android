package com.example.validationpractice.utlis

import android.app.Activity
import android.content.res.ColorStateList
import android.graphics.Color
import android.location.Address
import android.provider.ContactsContract
import android.text.TextUtils.equals
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat.setBackground
import androidx.core.view.ViewCompat.setBackgroundTintList
import androidx.core.view.isVisible
import com.exobe.ModelClass.BrandList
import com.exobe.R
import org.w3c.dom.Text
import java.util.regex.Pattern
import java.util.regex.Pattern.matches


object FormValidation : Activity() {
    val emailPattern =
        "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

    var MobilePattern = "[0-9]{10}"
    val Password = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@\$%^&*-]).{8,}\$"
    val Name = "^[A-Za-z]+$"
    val UserName = "^(?=[a-zA-Z0-9._]{8,20}\$)(?!.*[_.]{2})[^_.].*[^_.]\$"
    var any_Number = "[0-9]"
    var link =
        "(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})"
    var otp_regex = "^[0-9]{6}\$"


    fun registerRetailerValidations(

        CompanyName_ET: EditText,
        Address_ET: EditText,
        Country_ET: EditText,
        State_ET: EditText,
        Town_City_ET: EditText,
        Zipcode_ET: EditText,
        MobileNumber_ET: EditText,
        VATNumber_ET: EditText,
        EORINumber_ET: EditText,
        StoreName_ET: EditText,
        StoreLocation_ET: EditText,
        Brand_ET: EditText,
        WhereDidYou_ET: EditText,
        FirstName_ET: EditText,
        LastName_ET: EditText,
        EmailID_ET: EditText,
        CompanyName_TV: TextView,
        Address_TV: TextView,
        Country_TV: TextView,
        State_TV: TextView,
        Town_City_TV: TextView,
        Zipcode_TV: TextView,
        MobileNumber_TV: TextView,
        VATNumber_TV: TextView,
        EORINumber_TV: TextView,
        StoreName_TV: TextView,
        StoreLocation_TV: TextView,
        Brand_TV: TextView,
        WhereDidYou_TV: TextView,
        FirstName_TV: TextView,
        LastName_TV: TextView,
        Email_TV: TextView,
        checkBox: CheckBox,
        checkBoxTV: TextView


    ): Boolean {

        CompanyName_TV.text = ""
        Address_TV.text = ""
        Country_TV.text = ""
        State_TV.text = ""
        Town_City_TV.text = ""
        Zipcode_TV.text = ""
        MobileNumber_TV.text = ""
        VATNumber_TV.text = ""
        EORINumber_TV.text = ""
        StoreLocation_TV.text = ""
        StoreName_TV.text = ""
        Brand_TV.text = ""
        WhereDidYou_TV.text = ""
        FirstName_TV.text = ""
        LastName_TV.text = ""
        Email_TV.text = ""
        checkBoxTV.text = ""


        CompanyName_ET.setBackgroundResource(R.drawable.white_border)
        Address_ET.setBackgroundResource(R.drawable.white_border)
        Country_ET.setBackgroundResource(R.drawable.white_border)
        State_ET.setBackgroundResource(R.drawable.white_border)
        Town_City_ET.setBackgroundResource(R.drawable.white_border)
        Zipcode_ET.setBackgroundResource(R.drawable.white_border)
        MobileNumber_ET.setBackgroundResource(R.drawable.white_border)
        VATNumber_ET.setBackgroundResource(R.drawable.white_border)
        EORINumber_ET.setBackgroundResource(R.drawable.white_border)
        StoreLocation_ET.setBackgroundResource(R.drawable.white_border)
        StoreName_ET.setBackgroundResource(R.drawable.white_border)
        Brand_ET.setBackgroundResource(R.drawable.white_border)
        WhereDidYou_ET.setBackgroundResource(R.drawable.white_border)
        FirstName_ET.setBackgroundResource(R.drawable.white_border)
        LastName_ET.setBackgroundResource(R.drawable.white_border)
        EmailID_ET.setBackgroundResource(R.drawable.white_border)


        val CompanyName = CompanyName_ET.text.toString().trim()
        val Address = Address_ET.text.toString().trim()
        val Country = Country_ET.text.toString().trim()
        val State = State_ET.text.toString().trim()
        val Town_City = Town_City_ET.text.toString().trim()
        val Zipcode = Zipcode_ET.text.toString().trim()
        val MobileNumber = MobileNumber_ET.text.toString().trim()
        val VATNumber = VATNumber_ET.text.toString().trim()
        val EORINumber = EORINumber_ET.text.toString().trim()
        val StoreName = StoreName_ET.text.toString().trim()
        val StoreLocation = StoreLocation_ET.text.toString().trim()
        val Brand = Brand_ET.text.toString().trim()
        val WhereDidYou = WhereDidYou_ET.text.toString().trim()
        val FirstName = FirstName_ET.text.toString().trim()
        val LastName = LastName_ET.text.toString().trim()
        val EmailID = EmailID_ET.text.toString().trim()


        if (CompanyName.isEmpty()) {
            CompanyName_ET.requestFocus()
            CompanyName_TV.text = "*Please enter company name."
            CompanyName_ET.setBackgroundResource(R.drawable.input_error)

        } else if (Address.isEmpty()) {
            Address_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = "*Please enter address."
            Address_ET.setBackgroundResource(R.drawable.input_error)

        } else if (Country.isEmpty()) {
            Country_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = "*Please enter country name."
            Country_ET.setBackgroundResource(R.drawable.input_error)
        } else if (State.isEmpty()) {
            State_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = "*Please enter state name."
            State_ET.setBackgroundResource(R.drawable.input_error)
        } else if (Town_City.isEmpty()) {
            Town_City_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = "*Please enter city name."
            Town_City_ET.setBackgroundResource(R.drawable.input_error)
        } else if (Zipcode.isEmpty()) {
            Zipcode_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = "*Please enter zipcode."
            Zipcode_ET.setBackgroundResource(R.drawable.input_error)
        } else if (Zipcode.length < 6) {
            Zipcode_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = "*Please enter valid zipcode."
            Zipcode_ET.setBackgroundResource(R.drawable.input_error)
        } else if (MobileNumber.isEmpty()) {
            MobileNumber_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = "*Please enter your phone number."
            MobileNumber_ET.setBackgroundResource(R.drawable.input_error)

        } else if (!isPhone(MobileNumber)) {
            MobileNumber_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = "*Please enter valid phone number."
            MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
        } else if (VATNumber.isEmpty()) {
            VATNumber_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = "*Please enter VAT number."
            VATNumber_ET.setBackgroundResource(R.drawable.input_error)
        } else if (EORINumber.isEmpty()) {
            EORINumber_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            EORINumber_TV.text = "*Please enter EORI number."
            EORINumber_ET.setBackgroundResource(R.drawable.input_error)

        } else if (StoreName.isEmpty()) {
            State_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            EORINumber_TV.text = ""
            StoreName_TV.text = "*Please enter store name."
            StoreName_ET.setBackgroundResource(R.drawable.input_error)
        } else if (StoreLocation.isEmpty()) {
            StoreLocation_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            StoreName_TV.text = ""
            EORINumber_TV.text = ""
            StoreLocation_TV.text = "*Please enter store location."
            StoreLocation_ET.setBackgroundResource(R.drawable.input_error)
        } else if (Brand.isEmpty()) {
            Brand_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            StoreLocation_TV.text = ""
            EORINumber_TV.text = ""
            StoreName_TV.text = ""
            Brand_TV.text = "*Please enter brand name."
            Brand_ET.setBackgroundResource(R.drawable.input_error)
        } else if (WhereDidYou.isEmpty()) {
            WhereDidYou_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            StoreLocation_TV.text = ""
            EORINumber_TV.text = ""
            StoreName_TV.text = ""
            Brand_TV.text = ""
            WhereDidYou_TV.text = "*This field is required."
            WhereDidYou_ET.setBackgroundResource(R.drawable.input_error)
        } else if (FirstName.isEmpty()) {
            FirstName_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            StoreLocation_TV.text = ""
            EORINumber_TV.text = ""
            StoreName_TV.text = ""
            Brand_TV.text = ""
            WhereDidYou_TV.text = ""
            FirstName_TV.text = "*Please enter first name."
            FirstName_ET.setBackgroundResource(R.drawable.input_error)

        } else if (FirstName.length < 2) {
            FirstName_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            StoreLocation_TV.text = ""
            EORINumber_TV.text = ""
            StoreName_TV.text = ""
            Brand_TV.text = ""
            WhereDidYou_TV.text = ""
            FirstName_TV.text = "*Please enter valid first name."
            FirstName_ET.setBackgroundResource(R.drawable.input_error)

        } else if (LastName.isEmpty()) {
            LastName_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            StoreLocation_TV.text = ""
            EORINumber_TV.text = ""
            StoreName_TV.text = ""
            Brand_TV.text = ""
            WhereDidYou_TV.text = ""
            FirstName_TV.text = ""
            LastName_TV.text = "*Please enter last name."
            LastName_ET.setBackgroundResource(R.drawable.input_error)

        } else if (LastName.length < 2) {
            LastName_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            StoreLocation_TV.text = ""
            EORINumber_TV.text = ""
            StoreName_TV.text = ""
            Brand_TV.text = ""
            WhereDidYou_TV.text = ""
            FirstName_TV.text = ""
            LastName_TV.text = "*Please enter valid last name."
            LastName_ET.setBackgroundResource(R.drawable.input_error)

        } else if (EmailID.isEmpty()) {
            EmailID_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            StoreLocation_TV.text = ""
            EORINumber_TV.text = ""
            StoreName_TV.text = ""
            Brand_TV.text = ""
            WhereDidYou_TV.text = ""
            FirstName_TV.text = ""
            LastName_TV.text = ""
            Email_TV.text = "*Please enter your email."
            EmailID_ET.setBackgroundResource(R.drawable.input_error)

        } else if (!(isEmail(EmailID))) {
            EmailID_ET.requestFocus()
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            StoreLocation_TV.text = ""
            EORINumber_TV.text = ""
            StoreName_TV.text = ""
            Brand_TV.text = ""
            WhereDidYou_TV.text = ""
            FirstName_TV.text = ""
            LastName_TV.text = ""
            Email_TV.text = "*Please enter valid email."
            EmailID_ET.setBackgroundResource(R.drawable.input_error)
        } else if (!checkBox.isChecked) {
            checkBoxTV.setText("*Please select terms and conditions.")
        } else {
            CompanyName_TV.text = ""
            Address_TV.text = ""
            Country_TV.text = ""
            State_TV.text = ""
            Town_City_TV.text = ""
            Zipcode_TV.text = ""
            MobileNumber_TV.text = ""
            VATNumber_TV.text = ""
            EORINumber_TV.text = ""
            StoreLocation_TV.text = ""
            StoreName_TV.text = ""
            Brand_TV.text = ""
            WhereDidYou_TV.text = ""
            FirstName_TV.text = ""
            LastName_TV.text = ""
            Email_TV.text = ""
            checkBoxTV.text = ""

            CompanyName_ET.setBackgroundResource(R.drawable.white_border)
            Address_ET.setBackgroundResource(R.drawable.white_border)
            Country_ET.setBackgroundResource(R.drawable.white_border)
            State_ET.setBackgroundResource(R.drawable.white_border)
            Town_City_ET.setBackgroundResource(R.drawable.white_border)
            Zipcode_ET.setBackgroundResource(R.drawable.white_border)
            MobileNumber_ET.setBackgroundResource(R.drawable.white_border)
            VATNumber_ET.setBackgroundResource(R.drawable.white_border)
            EORINumber_ET.setBackgroundResource(R.drawable.white_border)
            StoreLocation_ET.setBackgroundResource(R.drawable.white_border)
            StoreName_ET.setBackgroundResource(R.drawable.white_border)
            Brand_ET.setBackgroundResource(R.drawable.white_border)
            WhereDidYou_ET.setBackgroundResource(R.drawable.white_border)
            FirstName_ET.setBackgroundResource(R.drawable.white_border)
            LastName_ET.setBackgroundResource(R.drawable.white_border)
            EmailID_ET.setBackgroundResource(R.drawable.white_border)



            return true
        }

        return false
    }

    fun forgetPassword(
        PhoneNumberET: EditText,
        PhoneNumberTV: TextView,
        PhoneNumberLL: LinearLayout

    ): Boolean {
        PhoneNumberTV.text = ""

        PhoneNumberLL.setBackgroundResource(R.drawable.white_border)

        if (PhoneNumberET.text.isEmpty()) {
            PhoneNumberET.requestFocus()
            PhoneNumberTV.text = "*Please enter your phone number."
            PhoneNumberLL.setBackgroundResource(R.drawable.input_error)

        } else if (!(PhoneNumberET.text.matches(Regex(MobilePattern)))) {
            PhoneNumberET.requestFocus()
            PhoneNumberTV.text = "*Please enter valid phone number."
            PhoneNumberLL.setBackgroundResource(R.drawable.input_error)

        } else {
            PhoneNumberTV.text = ""
            PhoneNumberLL.setBackgroundResource(R.drawable.white_border)

            return true
        }
        return false
    }

    fun LoginRetailerValidations(
        RetailerET: EditText,
        emailTV: TextView,
        PasswordEditText: EditText,
        passwordTv: TextView,
        RetalierLinear: LinearLayout,
        PaswordLL: LinearLayout
    ): Boolean {

        emailTV.text = ""
        RetalierLinear.setBackgroundResource(R.drawable.white_border)
        passwordTv.text = ""
        PaswordLL.setBackgroundResource(R.drawable.white_border)

        val retailer = RetailerET.text.toString()
        val password = PasswordEditText.text.toString()


        if (retailer.isEmpty()) {
            RetailerET.requestFocus()
            emailTV.text = "*Please enter retailer id."
            RetalierLinear.setBackgroundResource(R.drawable.input_error)

        } else if (password.isEmpty()) {
            passwordTv.isVisible = true
            PasswordEditText.requestFocus()
            passwordTv.text = "*Please enter your password."
            PaswordLL.setBackgroundResource(R.drawable.input_error)

        } else if (password.length < 8) {
            PasswordEditText.requestFocus()
            passwordTv.text = "*Please enter valid password."
            PaswordLL.setBackgroundResource(R.drawable.input_error)
        } else {
            emailTV.text = ""
            RetalierLinear.setBackgroundResource(R.drawable.white_border)
            passwordTv.text = ""
            PaswordLL.setBackgroundResource(R.drawable.white_border)

            return true
        }
        return false

    }

    fun LoginValidations(
        phoneET: EditText,
        phoneTV: TextView,
        passwordET: EditText,
        passwordTv: TextView,
        PhoneLinear: LinearLayout,
        PaswordLL: LinearLayout
    ): Boolean {

        phoneTV.text = ""
        PhoneLinear.setBackgroundResource(R.drawable.white_border)
        passwordTv.text = ""
        PaswordLL.setBackgroundResource(R.drawable.white_border)


        val phone = phoneET.text.toString()
        val password = passwordET.text.toString()

        if (phone.isEmpty()) {
            phoneET.requestFocus()
            phoneTV.text = "*Please enter phone number."
            PhoneLinear.setBackgroundResource(R.drawable.input_error)

        } else if (!isPhone(phone)) {
            phoneET.requestFocus()
            phoneTV.text = "*Please enter valid phone number."
            PhoneLinear.setBackgroundResource(R.drawable.input_error)

        } else if (password.isEmpty()) {
            passwordET.requestFocus()
            passwordTv.isVisible = true
            passwordTv.text = "*Please enter password."
            PaswordLL.setBackgroundResource(R.drawable.input_error)

        } else if (password.length < 8) {
            passwordET.requestFocus()
            passwordTv.text = "*Please enter valid password."
            PaswordLL.setBackgroundResource(R.drawable.input_error)
        } else {
            phoneTV.text = ""
            PhoneLinear.setBackgroundResource(R.drawable.white_border)
            passwordTv.text = ""
            PaswordLL.setBackgroundResource(R.drawable.white_border)

            return true
        }

        return false
    }

    // validations for reset password

    fun ResetPasswordValidations(

        passwordET: EditText,
        passwordTV: TextView,
        confirmPasswordET: EditText,
        confirmPasswordTV: TextView,
        passwordLinear: LinearLayout,
        confrimPasswordLinear: LinearLayout
    ): Boolean {

        ClearFieldsReset(
            passwordTV,
            confirmPasswordTV,
            passwordLinear,
            confrimPasswordLinear
        )

        val password = passwordET.text.toString().trim()
        val confrimPassword = confirmPasswordET.text.toString().trim()

        if (password.isEmpty()) {
            passwordET.requestFocus()
            passwordTV.visibility = View.VISIBLE
            passwordTV.setText("*Please enter password.")
            passwordLinear.setBackgroundResource(R.drawable.input_error)

        } else if (!(isPassword(password))) {
            passwordET.requestFocus()
            passwordTV.visibility = View.VISIBLE
            passwordTV.setText("*Password should have minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter, 1 number and 1 special character.")
            passwordLinear.setBackgroundResource(R.drawable.input_error)

        } else if (confrimPassword.isEmpty()) {
            confirmPasswordET.requestFocus()
            confirmPasswordTV.visibility = View.VISIBLE
            confirmPasswordTV.setText("*Please enter confirm password.")
            confrimPasswordLinear.setBackgroundResource(R.drawable.input_error)

        } else if (!password.equals(confrimPassword)) {
            confirmPasswordET.requestFocus()
            confirmPasswordTV.visibility = View.VISIBLE
            confirmPasswordTV.setText("*Confirm password should be same with \n  the password field.")
            confrimPasswordLinear.setBackgroundResource(R.drawable.input_error)

        } else {

            return true
        }
        return false
    }

    fun ClearFieldsReset(


        passwordTV: TextView,
        confirmPasswordTV: TextView,
        passwordLinear: LinearLayout,
        confrimPasswordLinear: LinearLayout

    ) {

        passwordTV.text = ""
        passwordTV.visibility = View.GONE
        passwordLinear.setBackgroundResource(R.drawable.white_border)

        confirmPasswordTV.visibility = View.GONE
        confirmPasswordTV.text = ""
        confrimPasswordLinear.setBackgroundResource(R.drawable.white_border)


    }


    // validations for consumer register
    fun customerRegistser(
        firstNameET: EditText,
        firstNameTV: TextView,
        lastNameET: EditText,
        lastNameTV: TextView,
        phoneET: EditText,
        phoneTV: TextView,
        emailET: EditText,
        emailTV: TextView,
        passwordET: EditText,
        passwordTV: TextView,
        confirmPasswordET: EditText,
        confirmPasswordTV: TextView,
        CheckBox: CheckBox,
        termsTV: TextView,
        firstNameLinear: LinearLayout,
        lastNameLinear: LinearLayout,
        phoneLinear: LinearLayout,
        emailLinear: LinearLayout,
        passwordLinear: LinearLayout,
        confrimPasswordLinear: LinearLayout
    ): Boolean {

        ClearFields(
            firstNameTV,
            lastNameTV,
            phoneTV,
            emailTV,
            passwordTV,
            confirmPasswordTV,
            termsTV,
            firstNameLinear,
            lastNameLinear,
            phoneLinear,
            emailLinear,
            passwordLinear,
            confrimPasswordLinear
        )

        val firstName = firstNameET.text.toString().trim()
        val lastName = lastNameET.text.toString().trim()
        val phone = phoneET.text.toString().trim()
        val email = emailET.text.toString().trim()
        val password = passwordET.text.toString().trim()
        val confrimPassword = confirmPasswordET.text.toString().trim()

        if (firstName.isEmpty()) {
            firstNameET.requestFocus()
            firstNameTV.visibility = View.VISIBLE
            firstNameTV.text = "*Please enter first name."
            firstNameLinear.setBackgroundResource(R.drawable.input_error)

        } else if (firstName.length < 2) {
            firstNameET.requestFocus()
            firstNameTV.visibility = View.VISIBLE
            firstNameTV.text = "*Please enter valid first name."
            firstNameLinear.setBackgroundResource(R.drawable.input_error)

        } else if (lastName.isEmpty()) {
            lastNameET.requestFocus()
            lastNameTV.visibility = View.VISIBLE
            lastNameTV.text = "*Please enter last name."
            lastNameLinear.setBackgroundResource(R.drawable.input_error)

        } else if (lastName.length < 2) {
            lastNameET.requestFocus()
            lastNameTV.visibility = View.VISIBLE
            lastNameTV.text = "*Please enter valid last name."
            lastNameLinear.setBackgroundResource(R.drawable.input_error)

        } else if (phone.isEmpty()) {
            phoneET.requestFocus()
            phoneTV.visibility = View.VISIBLE
            phoneTV.text = "*Please enter phone number."
            phoneLinear.setBackgroundResource(R.drawable.input_error)

        } else if (phone.length < 7) {
            phoneET.requestFocus()
            phoneTV.visibility = View.VISIBLE
            phoneTV.text = "*Please enter valid phone number."
            phoneLinear.setBackgroundResource(R.drawable.input_error)

        } else if (email.isEmpty()) {
            emailET.requestFocus()
            emailTV.visibility = View.VISIBLE
            emailTV.text = "*Please enter your email."
            emailLinear.setBackgroundResource(R.drawable.input_error)

        } else if (!(isEmail(emailET.text.toString()))) {
            emailET.requestFocus()
            emailTV.visibility = View.VISIBLE
            emailTV.text = "*Please enter valid email."
            emailLinear.setBackgroundResource(R.drawable.input_error)

        } else if (password.isEmpty()) {
            passwordET.requestFocus()
            passwordTV.visibility = View.VISIBLE
            passwordTV.setText("*Please enter password.")
            passwordLinear.setBackgroundResource(R.drawable.input_error)

        } else if (!(isPassword(password))) {
            passwordET.requestFocus()
            passwordTV.visibility = View.VISIBLE
            passwordTV.setText("*Password should have minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter, 1 number and 1 special character.")
            passwordLinear.setBackgroundResource(R.drawable.input_error)

        } else if (confrimPassword.isEmpty()) {
            confirmPasswordET.requestFocus()
            confirmPasswordTV.visibility = View.VISIBLE
            confirmPasswordTV.setText("*Please enter confirm password.")
            confrimPasswordLinear.setBackgroundResource(R.drawable.input_error)

        } else if (!password.equals(confrimPassword)) {
            confirmPasswordET.requestFocus()
            confirmPasswordTV.visibility = View.VISIBLE
            confirmPasswordTV.setText("*Confirm password should be same with \n  the password field.")
            confrimPasswordLinear.setBackgroundResource(R.drawable.input_error)

        } else if (!CheckBox.isChecked) {

            termsTV.visibility = View.VISIBLE
            termsTV.setText("*Please accept terms and conditions.")
        } else {


            return true
        }
        return false
    }

    fun ClearFields(

        firstNameTV: TextView,
        lastNameTV: TextView,
        phoneTV: TextView,
        emailTV: TextView,
        passwordTV: TextView,
        confirmPasswordTV: TextView,
        termsTV: TextView,
        firstNameLinear: LinearLayout,
        lastNameLinear: LinearLayout,
        phoneLinear: LinearLayout,
        emailLinear: LinearLayout,
        passwordLinear: LinearLayout,
        confrimPasswordLinear: LinearLayout

    ) {
        firstNameTV.text = ""
        firstNameTV.visibility = View.GONE
        firstNameLinear.setBackgroundResource(R.drawable.white_border)

        lastNameTV.text = ""
        lastNameTV.visibility = View.GONE
        lastNameLinear.setBackgroundResource(R.drawable.white_border)

        phoneTV.text = ""
        phoneTV.visibility = View.GONE
        phoneLinear.setBackgroundResource(R.drawable.white_border)

        emailTV.text = ""
        emailTV.visibility = View.GONE
        emailLinear.setBackgroundResource(R.drawable.white_border)


        passwordTV.text = ""
        passwordTV.visibility = View.GONE
        passwordLinear.setBackgroundResource(R.drawable.white_border)

        confirmPasswordTV.visibility = View.GONE
        confirmPasswordTV.text = ""
        confrimPasswordLinear.setBackgroundResource(R.drawable.white_border)



        termsTV.text = ""


    }

    fun LoginRetailerValidations(
        retailer: String,
        emailTV: TextView,
        password: String,
        passwordTv: TextView,
        RetalierLinear: LinearLayout,
        PaswordLL: LinearLayout
    ) {

        emailTV.text = ""
        RetalierLinear.setBackgroundResource(R.drawable.white_border)
        passwordTv.text = ""
        PaswordLL.setBackgroundResource(R.drawable.white_border)


        if (retailer.isEmpty()) {
            emailTV.text = "*Please enter retailer id"
            RetalierLinear.setBackgroundResource(R.drawable.input_error)

        } else if (password.isEmpty()) {
            passwordTv.isVisible = true
            passwordTv.text = "*Please enter password"
            PaswordLL.setBackgroundResource(R.drawable.input_error)

        } else if (password.length < 8) {
            passwordTv.text = "*Please enter valid password"
            PaswordLL.setBackgroundResource(R.drawable.input_error)
        } else {
            emailTV.text = ""
            RetalierLinear.setBackgroundResource(R.drawable.white_border)
            passwordTv.text = ""
            PaswordLL.setBackgroundResource(R.drawable.white_border)


        }


    }

    fun LoginValidations(
        email: String,
        emailTV: TextView,
        password: String,
        passwordTv: TextView,
        EmailLinear: LinearLayout,
        PaswordLL: LinearLayout
    ) {

        emailTV.text = ""
        EmailLinear.setBackgroundResource(R.drawable.white_border)
        passwordTv.text = ""
        PaswordLL.setBackgroundResource(R.drawable.white_border)


        if (email.isEmpty()) {
            emailTV.text = "*Please enter email id"
            EmailLinear.setBackgroundResource(R.drawable.input_error)

        } else if (!email.matches(Regex(emailPattern))) {
            emailTV.text = "*Please enter valid email id"
            EmailLinear.setBackgroundResource(R.drawable.input_error)

        } else if (password.isEmpty()) {
            passwordTv.isVisible = true
            passwordTv.text = "*Please enter password"
            PaswordLL.setBackgroundResource(R.drawable.input_error)

        } else if (password.length < 8) {
            passwordTv.text = "*Please enter valid password"
            PaswordLL.setBackgroundResource(R.drawable.input_error)
        } else {
            emailTV.text = ""
            EmailLinear.setBackgroundResource(R.drawable.white_border)
            passwordTv.text = ""
            PaswordLL.setBackgroundResource(R.drawable.white_border)


        }


    }


    fun retailer_Register(
        CompanyName_ET: EditText,
        Address_ET: EditText,
        Country_ET: EditText,
        State_ET: EditText,
        Town_City_ET: EditText,
        Zipcode_ET: EditText,
        MobileNumber_ET: EditText,
        VATNumber_ET: EditText,
        EORINumber_ET: EditText,
        StoreName_ET: EditText,
        StoreLocation_ET: EditText,
        Brand_ET: EditText,
        WhereDidYou_ET: EditText,
        FirstName_ET: EditText,
        LastName_ET: EditText,
        EmailID_ET: EditText,
        CompanyName_TV: TextView,
        Address_TV: TextView,
        Country_TV: TextView,
        State_TV: TextView,
        Town_City_TV: TextView,
        Zipcode_TV: TextView,
        MobileNumber_TV: TextView,
        VATNumber_TV: TextView,
        EORINumber_TV: TextView,
        StoreName_TV: TextView,
        StoreLocation_TV: TextView,
        Brand_TV: TextView,
        WhereDidYou_TV: TextView,
        FirstName_TV: TextView,
        LastName_TV: TextView
    ) {
        Address_ET.setOnFocusChangeListener { view, b ->

            if (b) {
                CompanyName_ET.setBackgroundResource(R.drawable.focus)


                if (CompanyName_ET.text.toString().equals("")) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Company name is required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!CompanyName_ET.text.toString().matches(Regex(Name))) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Only alphabets are required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (CompanyName_ET.text.toString().length < 2) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Please enter valid Company name."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else {
                    Address_ET.requestFocus()
                    CompanyName_TV.text = ""
                }
            }


            Country_ET.setOnFocusChangeListener { view, b ->
                if (b) {
                    CompanyName_ET.setBackgroundResource(R.drawable.focus)
                    Address_ET.setBackgroundResource(R.drawable.focus)

                    if (CompanyName_ET.text.toString().equals("")) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Company name is required."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                    } else if (!CompanyName_ET.text.toString().matches(Regex(Name))
                    ) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Only alphabets are required."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                    } else if (CompanyName_ET.text.toString().length < 2) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Please enter valid Company name."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                    }

                    if (Address_ET.text.toString().equals("")) {
                        Address_ET.requestFocus()
                        Address_TV.text = "Company name is required."
                        Address_ET.setBackgroundResource(R.drawable.input_error)
                    } else if (Address_ET.text.toString().length < 5) {
                        Address_ET.requestFocus()
                        Address_TV.text = "Enter valid company name."
                        Address_ET.setBackgroundResource(R.drawable.input_error)

                    } else {
                        Country_ET.requestFocus()
                        Address_TV.text = ""
                        CompanyName_TV.text = ""

                    }
                }
            }
            State_ET.setOnFocusChangeListener { view, b ->
                if (b) {
                    CompanyName_ET.setBackgroundResource(R.drawable.focus)
                    Address_ET.setBackgroundResource(R.drawable.focus)
                    Country_ET.setBackgroundResource(R.drawable.focus)

                    if (CompanyName_ET.text.toString().equals("")) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Company name is required."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                    } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                    ) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Only alphabets are required."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                    } else if (CompanyName_ET.text.toString().length < 2) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Please enter valid Company name."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                    }

                    if (Address_ET.text.toString().equals("")) {
                        Address_ET.requestFocus()
                        Address_TV.text = "Company name is required."
                        Address_ET.setBackgroundResource(R.drawable.input_error)
                    } else if (Address_ET.text.toString().length < 5) {
                        Address_ET.requestFocus()
                        Address_TV.text = "Enter valid company name."
                        Address_ET.setBackgroundResource(R.drawable.input_error)

                    }
                    if (Country_ET.equals("")) {
                        Country_ET.requestFocus()
                        Country_TV.text = "Country is required."
                        Country_ET.setBackgroundResource(R.drawable.input_error)
                    } else {
                        State_ET.requestFocus()
                        Address_TV.text = ""
                        CompanyName_TV.text = ""
                        Country_TV.text = ""

                    }
                }
            }
            Town_City_ET.setOnFocusChangeListener { view, b ->
                if (b) {
                    CompanyName_ET.setBackgroundResource(R.drawable.focus)
                    Address_ET.setBackgroundResource(R.drawable.focus)
                    Country_ET.setBackgroundResource(R.drawable.focus)
                    State_ET.setBackgroundResource(R.drawable.focus)

                    if (CompanyName_ET.text.toString().equals("")) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Company name is required."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                    } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                    ) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Only alphabets are required."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                    } else if (CompanyName_ET.text.toString().length < 2) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Please enter valid Company name."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                    }

                    if (Address_ET.text.toString().equals("")) {
                        Address_ET.requestFocus()
                        Address_TV.text = "Company name is required."
                        Address_ET.setBackgroundResource(R.drawable.input_error)
                    } else if (Address_ET.text.toString().length < 5) {
                        Address_ET.requestFocus()
                        Address_TV.text = "Enter valid company name."
                        Address_ET.setBackgroundResource(R.drawable.input_error)

                    }
                    if (Country_ET.text.toString().equals("")) {
                        Country_ET.requestFocus()
                        Country_TV.text = "Country is required."
                        Country_ET.setBackgroundResource(R.drawable.input_error)
                    }
                    if (State_ET.text.toString().equals("")) {
                        State_ET.requestFocus()
                        State_TV.text = "State is required."
                        State_ET.setBackgroundResource(R.drawable.input_error)

                    } else {
                        Town_City_ET.requestFocus()
                        Address_TV.text = ""
                        CompanyName_TV.text = ""
                        Country_TV.text = ""
                        State_TV.text = ""
                    }
                }
            }
            Zipcode_ET.setOnFocusChangeListener { view, b ->
                if (b) {
                    CompanyName_ET.setBackgroundResource(R.drawable.focus)
                    Address_ET.setBackgroundResource(R.drawable.focus)
                    Country_ET.setBackgroundResource(R.drawable.focus)
                    State_ET.setBackgroundResource(R.drawable.focus)
                    Town_City_ET.setBackgroundResource(R.drawable.focus)
                    if (CompanyName_ET.text.toString().equals("")) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Company name is required."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                    } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                    ) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Only alphabets are required."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                    } else if (CompanyName_ET.text.toString().length < 2) {
                        CompanyName_ET.requestFocus()
                        CompanyName_TV.text = "*Please enter valid Company name."
                        CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                    }

                    if (Address_ET.text.toString().equals("")) {
                        Address_ET.requestFocus()
                        Address_TV.text = "Company name is required."
                        Address_ET.setBackgroundResource(R.drawable.input_error)
                    } else if (Address_ET.text.toString().length < 5) {
                        Address_ET.requestFocus()
                        Address_TV.text = "Enter valid company name."
                        Address_ET.setBackgroundResource(R.drawable.input_error)

                    }
                    if (Country_ET.text.toString().equals("")) {
                        Country_ET.requestFocus()
                        Country_TV.text = "Country is required."
                        Country_ET.setBackgroundResource(R.drawable.input_error)
                    }
                    if (State_ET.text.toString().equals("")) {
                        State_ET.requestFocus()
                        State_TV.text = "State is required."
                        State_ET.setBackgroundResource(R.drawable.input_error)

                    }
                    if (Town_City_ET.text.toString().equals("")) {
                        Town_City_ET.requestFocus()
                        Town_City_TV.text = "Town_City is required."
                        Town_City_ET.setBackgroundResource(R.drawable.input_error)
                    } else {
                        Zipcode_ET.requestFocus()
                        Address_TV.text = ""
                        CompanyName_TV.text = ""
                        Country_TV.text = ""
                        State_TV.text = ""
                        Town_City_TV.text = ""
                    }
                }
            }
            MobileNumber_ET.setOnFocusChangeListener { view, b ->

                if (b) {

                    CompanyName_ET.setBackgroundResource(R.drawable.focus)
                    Address_ET.setBackgroundResource(R.drawable.focus)
                    Country_ET.setBackgroundResource(R.drawable.focus)
                    State_ET.setBackgroundResource(R.drawable.focus)
                    Town_City_ET.setBackgroundResource(R.drawable.focus)
                    Zipcode_ET.setBackgroundResource(R.drawable.focus)
                }
                if (CompanyName_ET.text.toString().equals("")) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Company name is required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                ) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Only alphabets are required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                } else if (CompanyName_ET.text.toString().length < 2) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Please enter valid Company name."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                }

                if (Address_ET.text.toString().equals("")) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Company name is required."
                    Address_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Address_ET.text.toString().length < 5) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Enter valid company name."
                    Address_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Country_ET.text.toString().equals("")) {
                    Country_ET.requestFocus()
                    Country_TV.text = "Country is required."
                    Country_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (State_ET.text.toString().equals("")) {
                    State_ET.requestFocus()
                    State_TV.text = "State is required."
                    State_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Town_City_ET.text.toString().equals("")) {
                    Town_City_ET.requestFocus()
                    Town_City_TV.text = "Town_City is required."
                    Town_City_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (Zipcode_ET.text.toString().equals("")) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Zipcode is required."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Zipcode_ET.text.toString().length < 6) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Please provide a valid zipcode."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                } else {
                    MobileNumber_ET.requestFocus()
                    Address_TV.text = ""
                    CompanyName_TV.text = ""
                    Country_TV.text = ""
                    State_TV.text = ""
                    Town_City_TV.text = ""
                    Zipcode_TV.text = ""
                }

            }
        }
        VATNumber_ET.setOnFocusChangeListener { view, b ->
            if (b) {

                CompanyName_ET.setBackgroundResource(R.drawable.focus)
                Address_ET.setBackgroundResource(R.drawable.focus)
                Country_ET.setBackgroundResource(R.drawable.focus)
                State_ET.setBackgroundResource(R.drawable.focus)
                Town_City_ET.setBackgroundResource(R.drawable.focus)
                Zipcode_ET.setBackgroundResource(R.drawable.focus)
                MobileNumber_ET.setBackgroundResource(R.drawable.focus)

                if (CompanyName_ET.text.toString().equals("")) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Company name is required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                ) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Only alphabets are required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                } else if (CompanyName_ET.text.toString().length < 2) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Please enter valid Company name."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                }

                if (Address_ET.text.toString().equals("")) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Company name is required."
                    Address_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Address_ET.text.toString().length < 5) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Enter valid company name."
                    Address_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Country_ET.text.toString().equals("")) {
                    Country_ET.requestFocus()
                    Country_TV.text = "Country is required."
                    Country_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (State_ET.text.toString().equals("")) {
                    State_ET.requestFocus()
                    State_TV.text = "State is required."
                    State_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Town_City_ET.text.toString().equals("")) {
                    Town_City_ET.requestFocus()
                    Town_City_TV.text = "Town_City is required."
                    Town_City_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (Zipcode_ET.text.toString().equals("")) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Zipcode is required."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Zipcode_ET.text.toString().length < 6) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Please provide a valid zipcode."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (MobileNumber_ET.text.toString().equals("")) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Mobile number is required."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                } else if (!MobileNumber_ET.text.toString()
                        .matches(Regex(FormValidation.MobilePattern))
                ) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Please enter a valid mobile number."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                } else {
                    VATNumber_ET.requestFocus()
                    Address_TV.text = ""
                    CompanyName_TV.text = ""
                    Country_TV.text = ""
                    State_TV.text = ""
                    Town_City_TV.text = ""
                    Zipcode_TV.text = ""
                    MobileNumber_TV.text = ""
                }

            }
        }
        EORINumber_ET.setOnFocusChangeListener { view, b ->
            if (b) {
                CompanyName_ET.setBackgroundResource(R.drawable.focus)
                Address_ET.setBackgroundResource(R.drawable.focus)
                Country_ET.setBackgroundResource(R.drawable.focus)
                State_ET.setBackgroundResource(R.drawable.focus)
                Town_City_ET.setBackgroundResource(R.drawable.focus)
                Zipcode_ET.setBackgroundResource(R.drawable.focus)
                MobileNumber_ET.setBackgroundResource(R.drawable.focus)
                VATNumber_ET.setBackgroundResource(R.drawable.focus)

                if (CompanyName_ET.text.toString().equals("")) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Company name is required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                ) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Only alphabets are required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                } else if (CompanyName_ET.text.toString().length < 2) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Please enter valid Company name."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                }

                if (Address_ET.text.toString().equals("")) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Company name is required."
                    Address_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Address_ET.text.toString().length < 5) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Enter valid company name."
                    Address_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Country_ET.text.toString().equals("")) {
                    Country_ET.requestFocus()
                    Country_TV.text = "Country is required."
                    Country_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (State_ET.text.toString().equals("")) {
                    State_ET.requestFocus()
                    State_TV.text = "State is required."
                    State_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Town_City_ET.text.toString().equals("")) {
                    Town_City_ET.requestFocus()
                    Town_City_TV.text = "Town_City is required."
                    Town_City_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (Zipcode_ET.text.toString().equals("")) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Zipcode is required."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Zipcode_ET.text.toString().length < 6) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Please provide a valid zipcode."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (MobileNumber_ET.text.toString().equals("")) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Mobile number is required."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                } else if (!MobileNumber_ET.text.toString()
                        .matches(Regex(FormValidation.MobilePattern))
                ) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Please enter a valid mobile number."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (VATNumber_ET.text.toString().equals("")) {
                    VATNumber_ET.requestFocus()
                    VATNumber_TV.text = "VAT number is required."
                    VATNumber_ET.setBackgroundResource(R.drawable.input_error)
                } else {
                    EORINumber_ET.requestFocus()
                    Address_TV.text = ""
                    CompanyName_TV.text = ""
                    Country_TV.text = ""
                    State_TV.text = ""
                    Town_City_TV.text = ""
                    Zipcode_TV.text = ""
                    MobileNumber_TV.text = ""
                    VATNumber_TV.text = ""
                }
            }
        }
        StoreName_ET.setOnFocusChangeListener { view, b ->
            if (b) {
                CompanyName_ET.setBackgroundResource(R.drawable.focus)
                Address_ET.setBackgroundResource(R.drawable.focus)
                Country_ET.setBackgroundResource(R.drawable.focus)
                State_ET.setBackgroundResource(R.drawable.focus)
                Town_City_ET.setBackgroundResource(R.drawable.focus)
                Zipcode_ET.setBackgroundResource(R.drawable.focus)
                MobileNumber_ET.setBackgroundResource(R.drawable.focus)
                VATNumber_ET.setBackgroundResource(R.drawable.focus)
                EORINumber_ET.setBackgroundResource(R.drawable.focus)

                if (CompanyName_ET.text.toString().equals("")) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Company name is required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                ) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Only alphabets are required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                } else if (CompanyName_ET.text.toString().length < 2) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Please enter valid Company name."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                }

                if (Address_ET.text.toString().equals("")) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Company name is required."
                    Address_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Address_ET.text.toString().length < 5) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Enter valid company name."
                    Address_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Country_ET.text.toString().equals("")) {
                    Country_ET.requestFocus()
                    Country_TV.text = "Country is required."
                    Country_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (State_ET.text.toString().equals("")) {
                    State_ET.requestFocus()
                    State_TV.text = "State is required."
                    State_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Town_City_ET.text.toString().equals("")) {
                    Town_City_ET.requestFocus()
                    Town_City_TV.text = "Town_City is required."
                    Town_City_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (Zipcode_ET.text.toString().equals("")) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Zipcode is required."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Zipcode_ET.text.toString().length < 6) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Please provide a valid zipcode."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (MobileNumber_ET.text.toString().equals("")) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Mobile number is required."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                } else if (!MobileNumber_ET.text.toString()
                        .matches(Regex(FormValidation.MobilePattern))
                ) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Please enter a valid mobile number."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (VATNumber_ET.text.toString().equals("")) {
                    VATNumber_ET.requestFocus()
                    VATNumber_TV.text = "VAT number is required."
                    VATNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (EORINumber_ET.text.toString().equals("")) {
                    EORINumber_ET.requestFocus()
                    EORINumber_TV.text = "Store name is required."
                    EORINumber_ET.setBackgroundResource(R.drawable.input_error)
                } else {
                    StoreName_ET.requestFocus()
                    Address_TV.text = ""
                    CompanyName_TV.text = ""
                    Country_TV.text = ""
                    State_TV.text = ""
                    Town_City_TV.text = ""
                    Zipcode_TV.text = ""
                    MobileNumber_TV.text = ""
                    VATNumber_TV.text = ""
                    EORINumber_TV.text = ""
                }

            }

        }
        StoreLocation_ET.setOnFocusChangeListener { view, b ->
            if (b) {
                CompanyName_ET.setBackgroundResource(R.drawable.focus)
                Address_ET.setBackgroundResource(R.drawable.focus)
                Country_ET.setBackgroundResource(R.drawable.focus)
                State_ET.setBackgroundResource(R.drawable.focus)
                Town_City_ET.setBackgroundResource(R.drawable.focus)
                Zipcode_ET.setBackgroundResource(R.drawable.focus)
                MobileNumber_ET.setBackgroundResource(R.drawable.focus)
                VATNumber_ET.setBackgroundResource(R.drawable.focus)
                EORINumber_ET.setBackgroundResource(R.drawable.focus)
                StoreName_ET.setBackgroundResource(R.drawable.focus)

                if (CompanyName_ET.text.toString().equals("")) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Company name is required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                ) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Only alphabets are required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                } else if (CompanyName_ET.text.toString().length < 2) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Please enter valid Company name."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                }

                if (Address_ET.text.toString().equals("")) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Company name is required."
                    Address_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Address_ET.text.toString().length < 5) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Enter valid company name."
                    Address_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Country_ET.text.toString().equals("")) {
                    Country_ET.requestFocus()
                    Country_TV.text = "Country is required."
                    Country_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (State_ET.text.toString().equals("")) {
                    State_ET.requestFocus()
                    State_TV.text = "State is required."
                    State_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Town_City_ET.text.toString().equals("")) {
                    Town_City_ET.requestFocus()
                    Town_City_TV.text = "Town_City is required."
                    Town_City_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (Zipcode_ET.text.toString().equals("")) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Zipcode is required."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Zipcode_ET.text.toString().length < 6) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Please provide a valid zipcode."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (MobileNumber_ET.text.toString().equals("")) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Mobile number is required."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                } else if (!MobileNumber_ET.text.toString()
                        .matches(Regex(FormValidation.MobilePattern))
                ) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Please enter a valid mobile number."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (VATNumber_ET.text.toString().equals("")) {
                    VATNumber_ET.requestFocus()
                    VATNumber_TV.text = "VAT number is required."
                    VATNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (EORINumber_ET.text.toString().equals("")) {
                    EORINumber_ET.requestFocus()
                    EORINumber_TV.text = "Store name is required."
                    EORINumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (StoreName_ET.text.toString().equals("")) {
                    StoreName_ET.requestFocus()
                    StoreName_TV.text = "Store name is required."
                    StoreName_ET.background = resources.getDrawable(R.drawable.input_error)

                } else {
                    StoreLocation_ET.requestFocus()
                    Address_TV.text = ""
                    CompanyName_TV.text = ""
                    Country_TV.text = ""
                    State_TV.text = ""
                    Town_City_TV.text = ""
                    Zipcode_TV.text = ""
                    MobileNumber_TV.text = ""
                    VATNumber_TV.text = ""
                    EORINumber_TV.text = ""
                    StoreName_TV.text = ""
                }

            }
        }

        Brand_ET.setOnFocusChangeListener { view, b ->
            if (b) {
                CompanyName_ET.setBackgroundResource(R.drawable.focus)
                Address_ET.setBackgroundResource(R.drawable.focus)
                Country_ET.setBackgroundResource(R.drawable.focus)
                State_ET.setBackgroundResource(R.drawable.focus)
                Town_City_ET.setBackgroundResource(R.drawable.focus)
                Zipcode_ET.setBackgroundResource(R.drawable.focus)
                MobileNumber_ET.setBackgroundResource(R.drawable.focus)
                VATNumber_ET.setBackgroundResource(R.drawable.focus)
                EORINumber_ET.setBackgroundResource(R.drawable.focus)
                StoreName_ET.setBackgroundResource(R.drawable.focus)
                StoreLocation_ET.setBackgroundResource(R.drawable.focus)

                if (CompanyName_ET.text.toString().equals("")) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Company name is required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                ) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Only alphabets are required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                } else if (CompanyName_ET.text.toString().length < 2) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Please enter valid Company name."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                }

                if (Address_ET.text.toString().equals("")) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Company name is required."
                    Address_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Address_ET.text.toString().length < 5) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Enter valid company name."
                    Address_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Country_ET.text.toString().equals("")) {
                    Country_ET.requestFocus()
                    Country_TV.text = "Country is required."
                    Country_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (State_ET.text.toString().equals("")) {
                    State_ET.requestFocus()
                    State_TV.text = "State is required."
                    State_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Town_City_ET.text.toString().equals("")) {
                    Town_City_ET.requestFocus()
                    Town_City_TV.text = "Town_City is required."
                    Town_City_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (Zipcode_ET.text.toString().equals("")) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Zipcode is required."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Zipcode_ET.text.toString().length < 6) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Please provide a valid zipcode."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (MobileNumber_ET.text.toString().equals("")) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Mobile number is required."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                } else if (!MobileNumber_ET.text.toString()
                        .matches(Regex(FormValidation.MobilePattern))
                ) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Please enter a valid mobile number."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (VATNumber_ET.text.toString().equals("")) {
                    VATNumber_ET.requestFocus()
                    VATNumber_TV.text = "VAT number is required."
                    VATNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (EORINumber_ET.text.toString().equals("")) {
                    EORINumber_ET.requestFocus()
                    EORINumber_TV.text = "Store name is required."
                    EORINumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (StoreName_ET.text.toString().equals("")) {
                    StoreName_ET.requestFocus()
                    StoreName_TV.text = "Store name is required."
                    StoreName_ET.background = resources.getDrawable(R.drawable.input_error)

                }
                if (StoreLocation_ET.text.toString().equals("")) {
                    StoreLocation_ET.requestFocus()
                    StoreLocation_TV.text = "Store location is required."
                    StoreLocation_ET.background = resources.getDrawable(R.drawable.input_error)
                } else {
                    Brand_ET.requestFocus()
                    Address_TV.text = ""
                    CompanyName_TV.text = ""
                    Country_TV.text = ""
                    State_TV.text = ""
                    Town_City_TV.text = ""
                    Zipcode_TV.text = ""
                    MobileNumber_TV.text = ""
                    VATNumber_TV.text = ""
                    EORINumber_TV.text = ""
                    StoreLocation_TV.text = ""
                }

            }
        }

        WhereDidYou_ET.setOnFocusChangeListener { view, b ->
            if (b) {
                CompanyName_ET.setBackgroundResource(R.drawable.focus)
                Address_ET.setBackgroundResource(R.drawable.focus)
                Country_ET.setBackgroundResource(R.drawable.focus)
                State_ET.setBackgroundResource(R.drawable.focus)
                Town_City_ET.setBackgroundResource(R.drawable.focus)
                Zipcode_ET.setBackgroundResource(R.drawable.focus)
                MobileNumber_ET.setBackgroundResource(R.drawable.focus)
                VATNumber_ET.setBackgroundResource(R.drawable.focus)
                EORINumber_ET.setBackgroundResource(R.drawable.focus)
                StoreName_ET.setBackgroundResource(R.drawable.focus)
                StoreLocation_ET.setBackgroundResource(R.drawable.focus)
                Brand_ET.setBackgroundResource(R.drawable.focus)

                if (CompanyName_ET.text.toString().equals("")) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Company name is required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                ) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Only alphabets are required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                } else if (CompanyName_ET.text.toString().length < 2) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Please enter valid Company name."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                }

                if (Address_ET.text.toString().equals("")) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Company name is required."
                    Address_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Address_ET.text.toString().length < 5) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Enter valid company name."
                    Address_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Country_ET.text.toString().equals("")) {
                    Country_ET.requestFocus()
                    Country_TV.text = "Country is required."
                    Country_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (State_ET.text.toString().equals("")) {
                    State_ET.requestFocus()
                    State_TV.text = "State is required."
                    State_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Town_City_ET.text.toString().equals("")) {
                    Town_City_ET.requestFocus()
                    Town_City_TV.text = "Town_City is required."
                    Town_City_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (Zipcode_ET.text.toString().equals("")) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Zipcode is required."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Zipcode_ET.text.toString().length < 6) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Please provide a valid zipcode."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (MobileNumber_ET.text.toString().equals("")) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Mobile number is required."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                } else if (!MobileNumber_ET.text.toString()
                        .matches(Regex(FormValidation.MobilePattern))
                ) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Please enter a valid mobile number."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (VATNumber_ET.text.toString().equals("")) {
                    VATNumber_ET.requestFocus()
                    VATNumber_TV.text = "VAT number is required."
                    VATNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (EORINumber_ET.text.toString().equals("")) {
                    EORINumber_ET.requestFocus()
                    EORINumber_TV.text = "Store name is required."
                    EORINumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (StoreName_ET.text.toString().equals("")) {
                    StoreName_ET.requestFocus()
                    StoreName_TV.text = "Store name is required."
                    StoreName_ET.background = resources.getDrawable(R.drawable.input_error)

                }
                if (StoreLocation_ET.text.toString().equals("")) {
                    StoreLocation_ET.requestFocus()
                    StoreLocation_TV.text = "Store location is required."
                    StoreLocation_ET.background = resources.getDrawable(R.drawable.input_error)
                }

                if (Brand_ET.text.toString().equals("")) {
                    Brand_ET.requestFocus()
                    Brand_TV.text = "Brand is required."
                    Brand_ET.background = resources.getDrawable(R.drawable.input_error)
                } else {
                    WhereDidYou_ET.requestFocus()
                    Address_TV.text = ""
                    CompanyName_TV.text = ""
                    Country_TV.text = ""
                    State_TV.text = ""
                    Town_City_TV.text = ""
                    Zipcode_TV.text = ""
                    MobileNumber_TV.text = ""
                    VATNumber_TV.text = ""
                    EORINumber_TV.text = ""
                    StoreLocation_TV.text = ""
                    Brand_TV.text = ""
                }

            }
        }

        FirstName_ET.setOnFocusChangeListener { view, b ->
            if (b) {
                CompanyName_ET.setBackgroundResource(R.drawable.focus)
                Address_ET.setBackgroundResource(R.drawable.focus)
                Country_ET.setBackgroundResource(R.drawable.focus)
                State_ET.setBackgroundResource(R.drawable.focus)
                Town_City_ET.setBackgroundResource(R.drawable.focus)
                Zipcode_ET.setBackgroundResource(R.drawable.focus)
                MobileNumber_ET.setBackgroundResource(R.drawable.focus)
                VATNumber_ET.setBackgroundResource(R.drawable.focus)
                EORINumber_ET.setBackgroundResource(R.drawable.focus)
                StoreName_ET.setBackgroundResource(R.drawable.focus)
                StoreLocation_ET.setBackgroundResource(R.drawable.focus)
                Brand_ET.setBackgroundResource(R.drawable.focus)
                WhereDidYou_ET.setBackgroundResource(R.drawable.focus)

                if (CompanyName_ET.text.toString().equals("")) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Company name is required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                ) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Only alphabets are required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                } else if (CompanyName_ET.text.toString().length < 2) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Please enter valid Company name."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                }

                if (Address_ET.text.toString().equals("")) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Company name is required."
                    Address_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Address_ET.text.toString().length < 5) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Enter valid company name."
                    Address_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Country_ET.text.toString().equals("")) {
                    Country_ET.requestFocus()
                    Country_TV.text = "Country is required."
                    Country_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (State_ET.text.toString().equals("")) {
                    State_ET.requestFocus()
                    State_TV.text = "State is required."
                    State_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Town_City_ET.text.toString().equals("")) {
                    Town_City_ET.requestFocus()
                    Town_City_TV.text = "Town_City is required."
                    Town_City_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (Zipcode_ET.text.toString().equals("")) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Zipcode is required."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Zipcode_ET.text.toString().length < 6) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Please provide a valid zipcode."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (MobileNumber_ET.text.toString().equals("")) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Mobile number is required."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                } else if (!MobileNumber_ET.text.toString()
                        .matches(Regex(FormValidation.MobilePattern))
                ) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Please enter a valid mobile number."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (VATNumber_ET.text.toString().equals("")) {
                    VATNumber_ET.requestFocus()
                    VATNumber_TV.text = "VAT number is required."
                    VATNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (EORINumber_ET.text.toString().equals("")) {
                    EORINumber_ET.requestFocus()
                    EORINumber_TV.text = "Store name is required."
                    EORINumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (StoreName_ET.text.toString().equals("")) {
                    StoreName_ET.requestFocus()
                    StoreName_TV.text = "Store name is required."
                    StoreName_ET.background = resources.getDrawable(R.drawable.input_error)

                }
                if (StoreLocation_ET.text.toString().equals("")) {
                    StoreLocation_ET.requestFocus()
                    StoreLocation_TV.text = "Store location is required."
                    StoreLocation_ET.background = resources.getDrawable(R.drawable.input_error)
                }

                if (Brand_ET.text.toString().equals("")) {
                    Brand_ET.requestFocus()
                    Brand_TV.text = "Brand is required."
                    Brand_ET.background = resources.getDrawable(R.drawable.input_error)
                }
                if (WhereDidYou_ET.text.toString().equals("")) {
                    WhereDidYou_ET.requestFocus()
                    WhereDidYou_TV.text = "Required."
                    WhereDidYou_ET.background = resources.getDrawable(R.drawable.input_error)
                } else {
                    FirstName_ET.requestFocus()
                    Address_TV.text = ""
                    CompanyName_TV.text = ""
                    Country_TV.text = ""
                    State_TV.text = ""
                    Town_City_TV.text = ""
                    Zipcode_TV.text = ""
                    MobileNumber_TV.text = ""
                    VATNumber_TV.text = ""
                    EORINumber_TV.text = ""
                    StoreLocation_TV.text = ""
                    Brand_TV.text = ""
                    WhereDidYou_TV.text = ""
                }

            }
        }

        LastName_ET.setOnFocusChangeListener { view, b ->
            if (b) {
                CompanyName_ET.setBackgroundResource(R.drawable.focus)
                Address_ET.setBackgroundResource(R.drawable.focus)
                Country_ET.setBackgroundResource(R.drawable.focus)
                State_ET.setBackgroundResource(R.drawable.focus)
                Town_City_ET.setBackgroundResource(R.drawable.focus)
                Zipcode_ET.setBackgroundResource(R.drawable.focus)
                MobileNumber_ET.setBackgroundResource(R.drawable.focus)
                VATNumber_ET.setBackgroundResource(R.drawable.focus)
                EORINumber_ET.setBackgroundResource(R.drawable.focus)
                StoreName_ET.setBackgroundResource(R.drawable.focus)
                StoreLocation_ET.setBackgroundResource(R.drawable.focus)
                Brand_ET.setBackgroundResource(R.drawable.focus)
                WhereDidYou_ET.setBackgroundResource(R.drawable.focus)
                FirstName_ET.setBackgroundResource(R.drawable.focus)

                if (CompanyName_ET.text.toString().equals("")) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Company name is required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                ) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Only alphabets are required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                } else if (CompanyName_ET.text.toString().length < 2) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Please enter valid Company name."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                }

                if (Address_ET.text.toString().equals("")) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Company name is required."
                    Address_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Address_ET.text.toString().length < 5) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Enter valid company name."
                    Address_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Country_ET.text.toString().equals("")) {
                    Country_ET.requestFocus()
                    Country_TV.text = "Country is required."
                    Country_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (State_ET.text.toString().equals("")) {
                    State_ET.requestFocus()
                    State_TV.text = "State is required."
                    State_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Town_City_ET.text.toString().equals("")) {
                    Town_City_ET.requestFocus()
                    Town_City_TV.text = "Town_City is required."
                    Town_City_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (Zipcode_ET.text.toString().equals("")) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Zipcode is required."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Zipcode_ET.text.toString().length < 6) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Please provide a valid zipcode."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (MobileNumber_ET.text.toString().equals("")) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Mobile number is required."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                } else if (!MobileNumber_ET.text.toString()
                        .matches(Regex(FormValidation.MobilePattern))
                ) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Please enter a valid mobile number."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (VATNumber_ET.text.toString().equals("")) {
                    VATNumber_ET.requestFocus()
                    VATNumber_TV.text = "VAT number is required."
                    VATNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (EORINumber_ET.text.toString().equals("")) {
                    EORINumber_ET.requestFocus()
                    EORINumber_TV.text = "Store name is required."
                    EORINumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (StoreName_ET.text.toString().equals("")) {
                    StoreName_ET.requestFocus()
                    StoreName_TV.text = "Store name is required."
                    StoreName_ET.background = resources.getDrawable(R.drawable.input_error)

                }
                if (StoreLocation_ET.text.toString().equals("")) {
                    StoreLocation_ET.requestFocus()
                    StoreLocation_TV.text = "Store location is required."
                    StoreLocation_ET.background = resources.getDrawable(R.drawable.input_error)
                }

                if (Brand_ET.text.toString().equals("")) {
                    Brand_ET.requestFocus()
                    Brand_TV.text = "Brand is required."
                    Brand_ET.background = resources.getDrawable(R.drawable.input_error)
                }
                if (WhereDidYou_ET.text.toString().equals("")) {
                    WhereDidYou_ET.requestFocus()
                    WhereDidYou_TV.text = "Required."
                    WhereDidYou_ET.background = resources.getDrawable(R.drawable.input_error)
                }
                if (FirstName_ET.text.toString().equals("")) {
                    FirstName_ET.requestFocus()
                    FirstName_TV.text = "First name is Required."
                    FirstName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!FirstName_ET.text.toString().matches(Regex(FormValidation.Name))) {
                    FirstName_ET.requestFocus()
                    FirstName_TV.text = "*Only alphabets are required."
                    FirstName_ET.setBackgroundResource(R.drawable.input_error)
                } else {
                    LastName_ET.requestFocus()
                    Address_TV.text = ""
                    CompanyName_TV.text = ""
                    Country_TV.text = ""
                    State_TV.text = ""
                    Town_City_TV.text = ""
                    Zipcode_TV.text = ""
                    MobileNumber_TV.text = ""
                    VATNumber_TV.text = ""
                    EORINumber_TV.text = ""
                    StoreLocation_TV.text = ""
                    Brand_TV.text = ""
                    FirstName_TV.text = ""
                }
            }
        }

        EmailID_ET.setOnFocusChangeListener { view, b ->
            if (b) {
                CompanyName_ET.setBackgroundResource(R.drawable.focus)
                Address_ET.setBackgroundResource(R.drawable.focus)
                Country_ET.setBackgroundResource(R.drawable.focus)
                State_ET.setBackgroundResource(R.drawable.focus)
                Town_City_ET.setBackgroundResource(R.drawable.focus)
                Zipcode_ET.setBackgroundResource(R.drawable.focus)
                MobileNumber_ET.setBackgroundResource(R.drawable.focus)
                VATNumber_ET.setBackgroundResource(R.drawable.focus)
                EORINumber_ET.setBackgroundResource(R.drawable.focus)
                StoreName_ET.setBackgroundResource(R.drawable.focus)
                StoreLocation_ET.setBackgroundResource(R.drawable.focus)
                Brand_ET.setBackgroundResource(R.drawable.focus)
                WhereDidYou_ET.setBackgroundResource(R.drawable.focus)
                FirstName_ET.setBackgroundResource(R.drawable.focus)
                LastName_ET.setBackgroundResource(R.drawable.focus)

                if (CompanyName_ET.text.toString().equals("")) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Company name is required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!CompanyName_ET.text.toString().matches(Regex(FormValidation.Name))
                ) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Only alphabets are required."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                } else if (CompanyName_ET.text.toString().length < 2) {
                    CompanyName_ET.requestFocus()
                    CompanyName_TV.text = "*Please enter valid Company name."
                    CompanyName_ET.setBackgroundResource(R.drawable.input_error)
                }

                if (Address_ET.text.toString().equals("")) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Company name is required."
                    Address_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Address_ET.text.toString().length < 5) {
                    Address_ET.requestFocus()
                    Address_TV.text = "Enter valid company name."
                    Address_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Country_ET.text.toString().equals("")) {
                    Country_ET.requestFocus()
                    Country_TV.text = "Country is required."
                    Country_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (State_ET.text.toString().equals("")) {
                    State_ET.requestFocus()
                    State_TV.text = "State is required."
                    State_ET.setBackgroundResource(R.drawable.input_error)

                }
                if (Town_City_ET.text.toString().equals("")) {
                    Town_City_ET.requestFocus()
                    Town_City_TV.text = "Town_City is required."
                    Town_City_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (Zipcode_ET.text.toString().equals("")) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Zipcode is required."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                } else if (Zipcode_ET.text.toString().length < 6) {
                    Zipcode_ET.requestFocus()
                    Zipcode_TV.text = "Please provide a valid zipcode."
                    Zipcode_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (MobileNumber_ET.text.toString().equals("")) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Mobile number is required."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                } else if (!MobileNumber_ET.text.toString()
                        .matches(Regex(FormValidation.MobilePattern))
                ) {
                    MobileNumber_ET.requestFocus()
                    MobileNumber_TV.text = "Please enter a valid mobile number."
                    MobileNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (VATNumber_ET.text.toString().equals("")) {
                    VATNumber_ET.requestFocus()
                    VATNumber_TV.text = "VAT number is required."
                    VATNumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (EORINumber_ET.text.toString().equals("")) {
                    EORINumber_ET.requestFocus()
                    EORINumber_TV.text = "Store name is required."
                    EORINumber_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (StoreName_ET.text.toString().equals("")) {
                    StoreName_ET.requestFocus()
                    StoreName_TV.text = "Store name is required."
                    StoreName_ET.background = resources.getDrawable(R.drawable.input_error)

                }
                if (StoreLocation_ET.text.toString().equals("")) {
                    StoreLocation_ET.requestFocus()
                    StoreLocation_TV.text = "Store location is required."
                    StoreLocation_ET.background = resources.getDrawable(R.drawable.input_error)
                }

                if (Brand_ET.text.toString().equals("")) {
                    Brand_ET.requestFocus()
                    Brand_TV.text = "Brand is required."
                    Brand_ET.background = resources.getDrawable(R.drawable.input_error)
                }
                if (WhereDidYou_ET.text.toString().equals("")) {
                    WhereDidYou_ET.requestFocus()
                    WhereDidYou_TV.text = "Required."
                    WhereDidYou_ET.background = resources.getDrawable(R.drawable.input_error)
                }
                if (FirstName_ET.text.toString().equals("")) {
                    FirstName_ET.requestFocus()
                    FirstName_TV.text = "First name is Required."
                    FirstName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!FirstName_ET.text.toString().matches(Regex(FormValidation.Name))) {
                    FirstName_ET.requestFocus()
                    FirstName_TV.text = "*Only alphabets are required."
                    FirstName_ET.setBackgroundResource(R.drawable.input_error)
                }
                if (LastName_ET.text.toString().equals("")) {
                    LastName_ET.requestFocus()
                    LastName_TV.text = "Last name is Required."
                    LastName_ET.setBackgroundResource(R.drawable.input_error)

                } else if (!LastName_ET.text.toString().matches(Regex(FormValidation.Name))) {
                    LastName_ET.requestFocus()
                    LastName_TV.text = "*Only alphabets are required."
                    LastName_ET.setBackgroundResource(R.drawable.input_error)
                } else {
                    EmailID_ET.requestFocus()
                    Address_TV.text = ""
                    CompanyName_TV.text = ""
                    Country_TV.text = ""
                    State_TV.text = ""
                    Town_City_TV.text = ""
                    Zipcode_TV.text = ""
                    MobileNumber_TV.text = ""
                    VATNumber_TV.text = ""
                    EORINumber_TV.text = ""
                    StoreLocation_TV.text = ""
                    Brand_TV.text = ""
                    FirstName_TV.text = ""
                }
            }
        }
    }

    fun retailer_login(

        PartnerID: String, PartnerID_ET: EditText, PartnerID_TV: TextView,
        Password: String, Password_ET: EditText, Password_TV: TextView
    ) {
        if (PartnerID.isEmpty()) {
            PartnerID_ET.requestFocus()
            PartnerID_TV.text = "*Partner id is required."

        } else if (Password.isEmpty()) {
            Password_ET.requestFocus()
            PartnerID_TV.text = ""
            Password_TV.text = "*Password is required."

        } else {
            PartnerID_TV.text = ""
            Password_TV.text = ""
        }
    }

    fun influencer_login(
        EmailID: String, EmailID_ET: EditText, EmailID_TV: TextView,
        Password: String, Password_ET: EditText, Password_TV: TextView
    ) {
        if (EmailID.isEmpty()) {
            EmailID_ET.requestFocus()
            EmailID_TV.text = "*Email id is required."

        } else if (!EmailID.matches(Regex(emailPattern))) {
            EmailID_ET.requestFocus()
            EmailID_TV.text = "*Enter valid email id."

        } else if (Password.isEmpty()) {
            Password_ET.requestFocus()
            EmailID_TV.text = ""
            Password_TV.text = "*Password is required."

        } else {
            EmailID_TV.text = ""
            Password_TV.text = ""
        }
    }

    fun consumer_ForgotPass(
        MobileNumber: String, MobileNumber_ET: EditText, MobileNumber_TV: TextView
    ) {
        if (MobileNumber.isEmpty()) {
            MobileNumber_ET.requestFocus()
            MobileNumber_TV.text = "*Email id is required."

        } else if (!MobileNumber.matches(Regex(emailPattern))) {
            MobileNumber_ET.requestFocus()
            MobileNumber_TV.text = "*Enter valid Email id."

        } else {
            MobileNumber_TV.text = ""
        }
    }

    fun retailer_ForgotPass(
        PartnerID: String, PartnerID_ET: EditText, PartnerID_TV: TextView
    ) {
        if (PartnerID.isEmpty()) {
            PartnerID_ET.requestFocus()
            PartnerID_TV.text = "*PartnerID is required."

        } else {
            PartnerID_TV.text = ""
        }
    }

    fun influencer_ForgotPass(
        Email: String, Email_ET: EditText, Email_TV: TextView
    ) {
        if (Email.isEmpty()) {
            Email_ET.requestFocus()
            Email_TV.text = "*Email is required."

        } else if (!Email.matches(Regex(emailPattern))) {
            Email_ET.requestFocus()
            Email_TV.text = "*Enter valid email!"

        } else {
            Email_TV.text = ""
        }
    }


    fun CYC_Valid(
        Event_Name: String, Event_Name_ET: EditText, Event_Name_TV: TextView,
        Date_Picker: String, DatePickerTV1: TextView, DatePickerTV2: TextView,
        Number_Dresses: String, Number_Dresses_ET: EditText, Number_Dresses_TV: TextView
    ) {
        if (Event_Name.isEmpty()) {
            Event_Name_ET.requestFocus()
            Event_Name_TV.text = "*Event name is required."

        } else if (Event_Name.length < 3) {
            Event_Name_ET.requestFocus()
            Event_Name_TV.text = "*Please enter valid event name."

        } else if (Date_Picker.isEmpty()) {
            DatePickerTV1.requestFocus()
            Event_Name_TV.text = ""
            DatePickerTV2.text = "*Date is required."
        } else if (Number_Dresses.equals("")) {
            Number_Dresses_ET.requestFocus()
            Event_Name_TV.text = ""
            DatePickerTV2.text = ""
            Number_Dresses_TV.text = "*Numbers of dresses are required."
        } else if (Number_Dresses.length > 2) {
            Number_Dresses_ET.requestFocus()
            Event_Name_TV.text = ""
            DatePickerTV2.text = ""
            Number_Dresses_TV.text = "*Number Should be less than three digits."

        } else {
            Event_Name_TV.text = ""
            DatePickerTV2.text = ""
            Number_Dresses_TV.text = ""
        }

    }


    fun email(
        email: String, et1: EditText, tv1: TextView, tv2: TextView, v1: View
    ) {
        v1.setBackgroundColor(Color.parseColor("#979797"))

        if (email.isEmpty()) {
            et1.requestFocus()
            tv2.text = "Required!"
            tv2.setTextColor(Color.parseColor("#FF0808"))
            v1.setBackgroundColor(Color.parseColor("#FF0808"))

        } else if (!email.matches(Regex(emailPattern))) {
            et1.requestFocus()
            tv1.text = "Please enter valid email!"
            tv1.setTextColor(Color.parseColor("#FF0808"))
            tv2.text = "EMAIL"
            tv2.setTextColor(Color.parseColor("#FF0808"))
            v1.setBackgroundColor(Color.parseColor("#FF0808"))

        } else {
            tv1.text = ""
            tv2.text = ""
        }
    }


    fun otp(
        email: String, etotp: EditText, tvotp: TextView, votp: View
    ) {
        votp.setBackgroundColor(Color.parseColor("#979797"))

        if (email.isEmpty()) {
            etotp.requestFocus()
            tvotp.text = "Required!"
            tvotp.setTextColor(Color.parseColor("#FF0808"))
            votp.setBackgroundColor(Color.parseColor("#FF0808"))

        } else if (!email.equals("123456")) {
            etotp.requestFocus()
            tvotp.text = "Please enter valid OTP!"
            tvotp.setTextColor(Color.parseColor("#FF0808"))
            votp.setBackgroundColor(Color.parseColor("#FF0808"))

        } else {
            tvotp.text = ""
        }
    }

    fun resetpassword(
        NewPass: String,
        ResetPassword_NewPass_ET: EditText,
        ResetPassword_NewPass_TV: TextView,
        ConfirmPass: String,
        ResetPassword_confirmNewPass_ET: EditText,
        ResetPassword_confirmNewPass_TV: TextView
    ) {
        if (NewPass.isEmpty()) {
            ResetPassword_NewPass_ET.requestFocus()
            ResetPassword_NewPass_TV.text = "*New password is required!"


        } else if (!NewPass.matches(Regex(Password))) {
            ResetPassword_NewPass_ET.requestFocus()
            ResetPassword_NewPass_TV.text = "*Enter valid new password!"

        } else if (ConfirmPass.isEmpty()) {
            ResetPassword_confirmNewPass_ET.requestFocus()
            ResetPassword_NewPass_TV.text = ""
            ResetPassword_confirmNewPass_TV.text = "*Confirm password is required!"


        } else if (!ConfirmPass.equals(NewPass)) {
            ResetPassword_confirmNewPass_ET.requestFocus()
            ResetPassword_NewPass_TV.text = ""
            ResetPassword_confirmNewPass_TV.text = "*Confirm password doesn't match!"

        } else {
            ResetPassword_NewPass_TV.text = ""
            ResetPassword_confirmNewPass_TV.text = ""
        }
    }

    fun createnewpass(
        oldpass: String,
        CreateOldPass_ET: EditText,
        CreateOldPass_TV: TextView,
        newpass: String,
        CreateNewPass_ET: EditText,
        CreateNewPass_TV: TextView,

        ) {
        if (oldpass.isEmpty()) {
            CreateOldPass_ET.requestFocus()
            CreateOldPass_TV.text = "*Old password is required!"


        } else if (!oldpass.matches(Regex(Password))) {
            CreateOldPass_ET.requestFocus()
            CreateOldPass_TV.text = "*Enter valid password!"

        } else if (newpass.isEmpty()) {
            CreateNewPass_ET.requestFocus()
            CreateOldPass_TV.text = ""
            CreateNewPass_TV.text = "*New password is required!"


        } else if (!newpass.matches(Regex(Password))) {
            CreateNewPass_ET.requestFocus()
            CreateOldPass_TV.text = ""
            CreateNewPass_TV.text = "*Enter valid password!"


        } else if (newpass.equals(oldpass)) {
            CreateNewPass_ET.requestFocus()
            CreateOldPass_TV.text = ""
            CreateNewPass_TV.text = "*New password should not be same as old!"

        } else {
            CreateOldPass_TV.text = ""
            CreateNewPass_TV.text = ""
        }
    }

    fun forgetpass(
        consumercode: String,
        email: String,
        Forgot_Code_et: EditText,
        Forgot_email_et: EditText,
        consumercodeTv: TextView,
        emailTV: TextView
    ) {
        if (consumercode.isEmpty()) {
            Forgot_Code_et.requestFocus()
            consumercodeTv.isVisible = true
            consumercodeTv.text = "*Please enter customer code."
            consumercodeTv.setTextColor(Color.parseColor("#FF0808"))

        } else if (consumercode.matches(Regex(any_Number))) {
            Forgot_Code_et.requestFocus()
            consumercodeTv.isVisible = true
            consumercodeTv.text = "*Enter valid customer Code!"
            consumercodeTv.setTextColor(Color.parseColor("#FF0808"))

        } else if (email == "") {
            Forgot_email_et.requestFocus()
            consumercodeTv.text = ""
            emailTV.isVisible = true
            emailTV.text = "*Please enter email."
            emailTV.setTextColor(Color.parseColor("#FF0808"))

        } else if (!email.matches(Regex(emailPattern))) {
            Forgot_email_et.requestFocus()
            consumercodeTv.text = ""
            emailTV.isVisible = true
            emailTV.text = "*Email is not valid."
            emailTV.setTextColor(Color.parseColor("#FF0808"))

        } else {
            consumercodeTv.text = ""
            emailTV.text = ""
        }
    }

//    fun Consumer_Register(
//        FirstName: String,
//        FirstName_ET: EditText,
//        FirstName_TV: TextView,
//        LastName: String,
//        LastName_ET: EditText,
//        LastName_TV: TextView,
//        EmailID: String,
//        EmailID_ET: EditText,
//        EmailID_TV: TextView,
//        Password: String,
//        Password_ET: EditText,
//        Password_TV: TextView,
//        CPassword: String,
//        CPassword_ET: EditText,
//        CPassword_TV: TextView,
//        ContactNumber: String,
//        ContactNumber_ET: EditText,
//        ContactNumber_TV: TextView,
//        Checkbox: CheckBox,
//        CheckboxTV:TextView
//    ){
//        if (FirstName.isEmpty()) {
//            FirstName_ET.requestFocus()
//            FirstName_TV.text = "*First name is required."
//
//        }else if (!FirstName.matches(Regex(Name))) {
//            FirstName_ET.requestFocus()
//            FirstName_TV.text = "*Only alphabets are required."
//
//        } else if (FirstName.length < 2) {
//            FirstName_ET.requestFocus()
//            FirstName_TV.text = "*Please enter valid first name."
//
//        } else if (LastName.isEmpty()) {
//            LastName_ET.requestFocus()
//            FirstName_TV.text = ""
//            LastName_TV.text = "*Last name is required."
//
//        } else if (LastName.length < 2) {
//            LastName_ET.requestFocus()
//            FirstName_TV.text = ""
//            LastName_TV.text = "*Please enter valid last name."
//
//        } else if (EmailID.isEmpty()) {
//            EmailID_ET.requestFocus()
//            FirstName_TV.text = ""
//            LastName_TV.text = ""
//            EmailID_TV.text = "*Email id is required."
//
//        } else if (!EmailID.matches(Regex(emailPattern))) {
//            EmailID_ET.requestFocus()
//            FirstName_TV.text = ""
//            LastName_TV.text = ""
//            EmailID_TV.text = "*Please enter valid email id."
//
//        } else if (Password.isEmpty()) {
//            Password_ET.requestFocus()
//            FirstName_TV.text = ""
//            LastName_TV.text = ""
//            EmailID_TV.text = ""
//            Password_TV.text = "*Password is required."
//
//        }
////        else if (!Password.matches(Regex(FormValidation.Password))) {
////            Password_ET.requestFocus()
////            FirstName_TV.text = ""
////            LastName_TV.text = ""
////            EmailID_TV.text = ""
////            Password_TV.text = "*Password should be alpha nukmeric."
////
////        }
//        else if (CPassword.isEmpty()) {
//            CPassword_ET.requestFocus()
//            FirstName_TV.text = ""
//            LastName_TV.text = ""
//            EmailID_TV.text = ""
//            Password_TV.text = ""
//            CPassword_TV.text = "*Confirm password is required."
//
//        } else if (!CPassword.equals(Password)) {
//            CPassword_ET.requestFocus()
//            FirstName_TV.text = ""
//            LastName_TV.text = ""
//            EmailID_TV.text = ""
//            Password_TV.text = ""
//            CPassword_TV.text = "*Confirm password doesn't match."
//
//
//        } else if (ContactNumber.isEmpty()) {
//            ContactNumber_ET.requestFocus()
//            FirstName_TV.text = ""
//            LastName_TV.text = ""
//            EmailID_TV.text = ""
//            Password_TV.text = ""
//            CPassword_TV.text = ""
//            ContactNumber_TV.text = "*Please enter contact number."
//
//        } else if (!ContactNumber.matches(Regex(MobilePattern))) {
//            ContactNumber_ET.requestFocus()
//            FirstName_TV.text = ""
//            LastName_TV.text = ""
//            EmailID_TV.text = ""
//            Password_TV.text = ""
//            CPassword_TV.text = ""
//            ContactNumber_TV.text = "*Please enter valid contact number."
//
//        }  else if (!Checkbox.isChecked) {
//            FirstName_TV.text = ""
//            LastName_TV.text = ""
//            EmailID_TV.text = ""
//            Password_TV.text = ""
//            CPassword_TV.text = ""
//            CheckboxTV.text = "Please accept terms and conditions."
//
//        } else{
//            FirstName_TV.text = ""
//            LastName_TV.text = ""
//            EmailID_TV.text = ""
//            Password_TV.text = ""
//            CPassword_TV.text = ""
//            ContactNumber_TV.text = ""
//            CheckboxTV.text = ""
//        }
//    }

//    fun retailer_Register(
//        CompanyName:String, CompanyName_ET:EditText, CompanyName_TV:TextView,
//        AddressLine1:String, AddressLine1_ET:EditText, AddressLine1_TV:TextView,
//        AddressLine2:String, AddressLine2_ET:EditText, AddressLine2_TV:TextView,
//        CountryName:String, CountryName_ET:TextView, CountryName_TV:TextView,
//        State:String, State_ET:TextView, State_TV:TextView,
//        TownCity:String, TownCity_ET:EditText, TownCity_TV:TextView,
//        Zipcode:String, Zipcode_ET:EditText, Zipcode_TV:TextView,
//        MobileNumber:String, MobileNumber_ET:EditText, MobileNumber_TV:TextView,
////        VATNumber:String, VATNumber_ET:EditText, VATNumber_TV:TextView,
////        EORINumber:String, EORINumber_ET:EditText, EORINumber_TV:TextView,
//        StoreName:String, StoreName_ET:EditText, StoreName_TV:TextView,
//        StoreLocation:String, StoreLocation_ET:EditText, StoreLocation_TV:TextView,
//        StoreContactNumber:String, StoreContactNumber_ET:EditText, StoreContactNumber_TV:TextView,
//        BrandList:ArrayList<Brand_ModelClass>, enterBrand_ET:EditText, EnterBrand_TV:TextView,
//        hearAbout:String, hearAbout_ET:EditText, hearAbout_TV:TextView,
//        firstName:String, ET_firstName:EditText, TV_firstName:TextView,
//        lastName:String, ET_lastName:EditText, TV_lastName:TextView,
//        EmailID2:String, EmailID2_ET:EditText, EmailID2_TV:TextView,
//        Password2:String, Password2_ET:EditText, Password2_TV:TextView,
//        ConfirmPassword:String, ConfirmPassword_ET:EditText, ConfirmPassword_TV:TextView,
//        Facebook:String, Facebook_ET:EditText, Facebook_TV:TextView,
//        Instagram:String, Instagram_ET:EditText, Instagram_TV:TextView,
//        Twitter:String, Twitter_ET:EditText, Twitter_TV:TextView,
//        Linkedin:String, Linkedin_ET:EditText, Linkedin_TV:TextView,
//        FrontDocLink:String, FrontDocLink_TV:TextView, documentFront_TV:TextView,
//        BackDocLink:String, BackDocLink_TV:TextView, documentBack_TV:TextView,
//        Checkbox: CheckBox,
//        CheckboxTV:TextView
//    ) {
//
//        CompanyName_TV.text = ""
//        AddressLine1_TV.text = ""
//        AddressLine2_TV.text = ""
//        TownCity_TV.text = ""
//        Zipcode_TV.text = ""
//        CountryName_TV.text = ""
//        State_TV.text = ""
//        TownCity_TV.text = ""
//        MobileNumber_TV.text = ""
//        StoreName_TV.text = ""
//        StoreLocation_TV.text = ""
//        StoreContactNumber_TV.text = ""
//        EnterBrand_TV.text = ""
//        hearAbout_TV.text = ""
//        TV_firstName.text = ""
//        TV_lastName.text = ""
//        EmailID2_TV.text = ""
//        TV_firstName.text = ""
//        TV_lastName.text = ""
//        Password2_TV.text = ""
//        ConfirmPassword_TV.text = ""
//        Facebook_TV.text = ""
//        Instagram_TV.text = ""
//        Twitter_TV.text = ""
//        Linkedin_TV.text = ""
//        documentFront_TV.text = ""
//        documentBack_TV.text = ""
//        CheckboxTV.text = ""
//
//
//        if (CompanyName.isEmpty()) {
//            CompanyName_ET.requestFocus()
//            CompanyName_TV.text = "*Company name is required."
//
//        } else if (CompanyName.length < 2) {
//            CompanyName_ET.requestFocus()
//            CompanyName_TV.text = "*Please enter valid company name."
//
//        } else if (AddressLine1.isEmpty()) {
//            AddressLine1_ET.requestFocus()
//            AddressLine1_TV.text = "*Address is required."
//
//        } else if (AddressLine1.length < 2) {
//            AddressLine1_ET.requestFocus()
//            AddressLine1_TV.text = "*Please enter valid address."
//
//        } else if (AddressLine2.isEmpty()) {
//            AddressLine2_ET.requestFocus()
//            AddressLine2_TV.text = "*Address is required."
//
//        } else if (AddressLine2.length < 2) {
//            AddressLine2_ET.requestFocus()
//            AddressLine2_TV.text = "*Please enter valid address."
//
//        } else if (CountryName.isEmpty()) {
//            CountryName_ET.requestFocus()
//            CountryName_TV.text = "*Country name is required."
//
//        } else if (State.isEmpty()) {
//            State_ET.requestFocus()
//            State_TV.text = "*State is required."
//
//        }else if (TownCity.isEmpty()) {
//            TownCity_ET.requestFocus()
//            TownCity_TV.text = "*Town/city is required."
//
//        } else if (TownCity.length < 2) {
//            TownCity_ET.requestFocus()
//            TownCity_TV.text = "*Please enter valid town/city."
//
//        } else if (Zipcode.isEmpty()) {
//            Zipcode_ET.requestFocus()
//            Zipcode_TV.text = "*Zipcode is required."
//
//        } else if (Zipcode.length < 5) {
//            Zipcode_ET.requestFocus()
//            Zipcode_TV.text = "*Please enter valid zipcode."
//
//        }  else if (MobileNumber.isEmpty()) {
//            MobileNumber_ET.requestFocus()
//            MobileNumber_TV.text = "*Mobile number is required."
//
//        } else if (!MobileNumber.matches(Regex(MobilePattern))) {
//            MobileNumber_ET.requestFocus()
//            MobileNumber_TV.text = "*Please enter valid mobile number."
//
//        }else if (StoreName.isEmpty()) {
//            StoreName_ET.requestFocus()
//            StoreName_TV.text = "*StoreName is required."
//
//        }else if (StoreLocation.isEmpty()) {
//            StoreLocation_ET.requestFocus()
//            StoreLocation_TV.text = "*StoreName is required."
//
//        }else if (StoreContactNumber.isEmpty()) {
//            StoreContactNumber_ET.requestFocus()
//            StoreContactNumber_TV.text = "*StoreLocation is required."
//
//        }else if (!StoreContactNumber.matches(Regex(MobilePattern))) {
//            StoreContactNumber_ET.requestFocus()
//            StoreContactNumber_TV.text = "*Please enter valid store contact no."
//
//        }else if (BrandList.isEmpty()) {
//            enterBrand_ET.requestFocus()
//            EnterBrand_TV.text = "*Brand is required."
//
//        }else if (hearAbout.isEmpty()) {
//            hearAbout_ET.requestFocus()
//            hearAbout_TV.text = "*Required."
//
//        } else if (firstName.isEmpty()) {
//            ET_firstName.requestFocus()
//            TV_firstName.text = "*Please enter your first name."
//
//        }else if (!firstName.matches(Regex(Name))) {
//            ET_firstName.requestFocus()
//            TV_firstName.text = "*Only alphabets are required."
//
//        } else if (firstName.length < 2) {
//            ET_firstName.requestFocus()
//            TV_firstName.text = "*Please enter valid first name."
//
//        }
//        else if (lastName.isEmpty()) {
//            ET_lastName.requestFocus()
//            TV_lastName.text = "*Please enter your last name."
//
//        }else if (!lastName.matches(Regex(Name))) {
//            ET_lastName.requestFocus()
//            TV_lastName.text = "*Only alphabets are required."
//
//        }  else if (lastName.length < 2) {
//            ET_lastName.requestFocus()
//            TV_lastName.text = "*Please enter valid last name."
//
//        } else if (EmailID2.isEmpty()) {
//            EmailID2_ET.requestFocus()
//            EmailID2_TV.text = "*Email id is required."
//
//        } else if (!EmailID2.matches(Regex(emailPattern))) {
//            EmailID2_ET.requestFocus()
//            EmailID2_TV.text = "*Please enter valid email id."
//
//        } else if (Password2.isEmpty()) {
//            Password2_ET.requestFocus()
//            Password2_TV.text = "*Password is required."
//
//        }
////        else if (!Password2.matches(Regex(Password))) {
////            Password2_ET.requestFocus()
////            Password2_TV.text = "*Please enter valid password."
////
////        }
//        else if (ConfirmPassword.isEmpty()) {
//            ConfirmPassword_ET.requestFocus()
//            ConfirmPassword_TV.text = "*Confirm password is required."
//
//        } else if (!ConfirmPassword.equals(Password2)) {
//            ConfirmPassword_ET.requestFocus()
//            ConfirmPassword_TV.text = "*Confirm password doesn't match."
//
//        } else if (Facebook.isEmpty()) {
//            Facebook_ET.requestFocus()
//            Facebook_TV.text = "*Facebook url is required."
//
//        } else if (!Facebook.matches(Regex(link))) {
//            Facebook_ET.requestFocus()
//            Facebook_TV.text = "*Please enter valid url."
//
//        }
//        else if (Instagram.isEmpty()) {
//            Instagram_ET.requestFocus()
//            Instagram_TV.text = "*Instagram url is required."
//
//        } else if (!Instagram.matches(Regex(link))) {
//            Instagram_ET.requestFocus()
//            Instagram_TV.text = "*Please enter valid url."
//
//        }else if (Twitter.isEmpty()) {
//            Twitter_ET.requestFocus()
//            Twitter_TV.text = "*Twitter url is required."
//
//        } else if (!Twitter.matches(Regex(link))) {
//            Twitter_ET.requestFocus()
//            Twitter_TV.text = "*Please enter valid url."
//
//        }else if (Linkedin.isEmpty()) {
//            Linkedin_ET.requestFocus()
//            Linkedin_TV.text = "*Linkedin url is required."
//
//        } else if (!Linkedin.matches(Regex(link))) {
//            Linkedin_ET.requestFocus()
//            Linkedin_TV.text = "*Please enter valid url."
//
//        }else if (FrontDocLink.isEmpty()) {
//            FrontDocLink_TV.requestFocus()
//            documentFront_TV.text = "*Doc. is required."
//
//        }else if (BackDocLink.isEmpty()) {
//            BackDocLink_TV.requestFocus()
//            documentBack_TV.text = "*Doc. is required."
//
//        } else if (!Checkbox.isChecked) {
//            CheckboxTV.text = "Please accept terms and conditions."
//
//        }
//    }


//    fun Influencer_Register(
//        FirstName:String, FirstName_ET_I:EditText, FirstName_TV_I:TextView,
//        LastName:String,LastName_ET_I:EditText,LastName_TV_I:TextView,
//        Email:String, Email_ET_I:EditText, Email_TV_I:TextView,
//        AddressLine1:String,AddressLine1_ET_I:EditText,AddressLine1_TV_I:TextView,
//        AddressLine2:String,AddressLine2_ET_I:EditText,AddressLine2_TV_I:TextView,
//        CountryName:String,InfluencerCountryName_ET_I:TextView,CountryName_TV_I:TextView,
//        State:String, InfluencerState_ET_I:TextView, State_TV_I:TextView,
//        City:String, City_ET_I:EditText, City_TV_I:TextView,
//        password:String, Password_ET_I:EditText, Password_TV_I:TextView,
//        ConfirmPassword:String, ConfirmPassword_ET_I:EditText,ConfirmPassword_TV_I:TextView,
//        ZipCode:String,ZipCode_ET_I:EditText,ZipCode_TV_I:TextView,
//        MobileNumber2:String, MobileNumber2_ET_I:EditText, MobileNumber2_TV_I:TextView,
//        Facebook:String, Facebook_ET_I:EditText, Facebook_TV_I:TextView,
//        Instagram:String,Instagram_ET_I:EditText,Instagram_TV_I:TextView,
//        Twitter:String,Twitter_ET_I:EditText,Twitter_TV_I:TextView,
//        Linkedin:String,Linkedin_ET_I:EditText,Linkedin_TV_I:TextView,
//        linkFront:String,linkFront_I:TextView,documentFront_TV_I:TextView,
//        linkback:String,linkback_I:TextView, documentBack_TV_I:TextView,
//        Checkbox: CheckBox,CheckboxTV:TextView
//
//    ) {
//        FirstName_TV_I.text = ""
//        LastName_TV_I.text = ""
//        Email_TV_I.text = ""
//        AddressLine1_TV_I.text = ""
//        AddressLine2_TV_I.text = ""
//        CountryName_TV_I.text = ""
//        State_TV_I.text = ""
//        City_TV_I.text = ""
//        Password_TV_I.text = ""
//        ConfirmPassword_TV_I.text = ""
//        ZipCode_TV_I.text = ""
//        MobileNumber2_TV_I.text = ""
//        Facebook_TV_I.text = ""
//        Instagram_TV_I.text = ""
//        Twitter_TV_I.text = ""
//        Linkedin_TV_I.text = ""
//        documentFront_TV_I.text = ""
//        documentFront_TV_I.text = ""
//        CheckboxTV.text = ""
//
//        if (FirstName.isEmpty()) {
//            FirstName_ET_I.requestFocus()
//            FirstName_TV_I.text = "*FirstName is required."
//
//        } else if (!FirstName.matches(Regex(Name))) {
//            FirstName_ET_I.requestFocus()
//            FirstName_TV_I.text = "*Only alphabets are required."
//
//        }
////        else if (FirstName.length < 2) {
////            FirstName_ET_I.requestFocus()
////            FirstName_TV_I.text = "*Please enter valid first name."
////
////        }
//        else if (LastName.isEmpty()) {
//            LastName_ET_I.requestFocus()
//            LastName_TV_I.text = "*LastName is required."
//
//        } else if (LastName.length < 2) {
//            LastName_ET_I.requestFocus()
//            LastName_TV_I.text = "*Please enter valid last name."
//
//        } else if (Email.isEmpty()) {
//            Email_ET_I.requestFocus()
//            Email_TV_I.text = "*Email id is required."
//
//        } else if (!Email.matches(Regex(emailPattern))) {
//            Email_ET_I.requestFocus()
//            Email_TV_I.text = "*Please enter valid email id."
//
//        } else if (AddressLine1.isEmpty()) {
//            AddressLine1_ET_I.requestFocus()
//            AddressLine1_TV_I.text = "*AddressLine1 is required."
//
//        } else if (AddressLine2.isEmpty()) {
//            AddressLine2_ET_I.requestFocus()
//            AddressLine2_TV_I.text = "*AddressLine2 is required."
//
//        } else if (CountryName.isEmpty()) {
//            InfluencerCountryName_ET_I.requestFocus()
//            CountryName_TV_I.text = "*CountryName is required."
//
//        } else if (State.isEmpty()) {
//            InfluencerState_ET_I.requestFocus()
//            State_TV_I.text = "*State is required."
//
//        } else if (City.isEmpty()) {
//            City_ET_I.requestFocus()
//            City_TV_I.text = "*City is required."
//
//        } else if (password.isEmpty()) {
//            Password_ET_I.requestFocus()
//            Password_TV_I.text = "*Password is required."
//
//        }
////        else if (!password.matches(Regex(Password))) {
////            Password_ET_I.requestFocus()
////            Password_TV_I.text = "*Please enter valid password."
////
////        }
//        else if (ConfirmPassword.isEmpty()) {
//            ConfirmPassword_ET_I.requestFocus()
//            ConfirmPassword_TV_I.text = "*Confirm password is required."
//
//        } else if (!ConfirmPassword.equals(password)) {
//            ConfirmPassword_ET_I.requestFocus()
//            ConfirmPassword_TV_I.text = "*Confirm password doesn't match."
//
//        } else if (ZipCode.isEmpty()) {
//            ZipCode_ET_I.requestFocus()
//            ZipCode_TV_I.text = "*Postalcode is required."
//
//        } else if (ZipCode.length < 5) {
//            ZipCode_ET_I.requestFocus()
//            ZipCode_TV_I.text = "*Please enter valid postalcode."
//
//        } else if (MobileNumber2.isEmpty()) {
//            MobileNumber2_ET_I.requestFocus()
//            MobileNumber2_TV_I.text = "*Mobile number is required."
//
//        } else if (!MobileNumber2.matches(Regex(MobilePattern))) {
//            MobileNumber2_ET_I.requestFocus()
//            MobileNumber2_TV_I.text = "*Please enter valid mobile number."
//
//        } else if (Facebook.isEmpty()) {
//            Facebook_ET_I.requestFocus()
//            Facebook_TV_I.text = "*Facebook url is required."
//
//        } else if (!Facebook.matches(Regex(link))) {
//            Facebook_ET_I.requestFocus()
//            Facebook_TV_I.text = "*Please enter valid url."
//
//        } else if (Instagram.isEmpty()) {
//            Instagram_ET_I.requestFocus()
//            Instagram_TV_I.text = "*Instagram url is required."
//
//        } else if (!Instagram.matches(Regex(link))) {
//            Instagram_ET_I.requestFocus()
//            Instagram_TV_I.text = "*Please enter valid url."
//
//        } else if (Twitter.isEmpty()) {
//            Twitter_ET_I.requestFocus()
//            Twitter_TV_I.text = "*Twitter url is required."
//
//        } else if (!Twitter.matches(Regex(link))) {
//            Twitter_ET_I.requestFocus()
//            Twitter_TV_I.text = "*Please enter valid url."
//
//        } else if (Linkedin.isEmpty()) {
//            Linkedin_ET_I.requestFocus()
//            Linkedin_TV_I.text = "*Linkedin url is required."
//
//        } else if (!Linkedin.matches(Regex(link))) {
//            Linkedin_ET_I.requestFocus()
//            Linkedin_TV_I.text = "*Please enter valid url."
//
//        } else if (linkFront.isEmpty()) {
//            linkFront_I.requestFocus()
//            documentFront_TV_I.text = "*Doc. is required."
//        } else if (linkback.isEmpty()) {
//            linkback_I.requestFocus()
//            documentBack_TV_I.text = "*Doc. is required."
//        } else if (!Checkbox.isChecked) {
//            CheckboxTV.text = "Please accept terms and conditions."
//
//        }
//    }

    fun editaddress(
        Id: String,
        Id_ET: EditText,
        Pass: String,
        Pass_ET: EditText,
        retailerId_TV: TextView,
        retailerPass_TV: TextView,
        Id_LL: LinearLayout,
        Pass_LL: LinearLayout
    ) {
        Id_LL.setBackgroundResource(R.drawable.focus)
        Pass_LL.setBackgroundResource(R.drawable.focus)
        retailerId_TV.text = ""
        retailerPass_TV.text = ""

        if (Id.isEmpty()) {
            Id_ET.requestFocus()
            retailerId_TV.text = "*Retailer id is required."
            Id_LL.setBackgroundResource(R.drawable.input_error)
        } else if (Pass.isEmpty()) {
            Pass_ET.requestFocus()
            retailerPass_TV.text = "*Password is required."
            Pass_LL.setBackgroundResource(R.drawable.input_error)
        }

    }

    fun add_Address(
        First_name: String,
        First_name_et: EditText,
        First_name_tv: TextView,
        Last_name: String,
        Last_name_et: EditText,
        Last_name_tv: TextView,
        Address: String,
        Address_et: EditText,
        Address_tv: TextView,
        City: String,
        City_et: EditText,
        City_tv: TextView,
        State: String,
        State_et: TextView,
        State_tv: TextView,
        Country: String,
        Country_et: TextView,
        Country_tv: TextView,
        Zipcode: String,
        Zipcode_et: EditText,
        Zipcode_tv: TextView,
        Mobile: String,
        Mobile_et: EditText,
        Mobile_tv: TextView
    ) {
        if (First_name.isEmpty()) {
            First_name_et.requestFocus()
            First_name_tv.text = "*First name is required."

        } else if (First_name.length < 2) {
            First_name_et.requestFocus()
            First_name_tv.text = "*Enter valid First name."

        } else if (Last_name.isEmpty()) {
            Last_name_et.requestFocus()
            First_name_tv.text = ""
            Last_name_tv.text = "*Last name is required"

        } else if (Last_name.length < 2) {
            Last_name_et.requestFocus()
            First_name_tv.text = ""
            Last_name_tv.text = "*Enter valid Last name."

        } else if (Address.isEmpty()) {
            Address_et.requestFocus()
            First_name_tv.text = ""
            Last_name_tv.text = ""
            Address_tv.text = "*Address is required."

        } else if (City.isEmpty()) {
            City_et.requestFocus()
            First_name_tv.text = ""
            Last_name_tv.text = ""
            Address_tv.text = ""
            City_tv.text = "*City is required!"

        } else if (State.isEmpty()) {
            State_et.requestFocus()
            First_name_tv.text = ""
            Last_name_tv.text = ""
            Address_tv.text = ""
            City_tv.text = ""
            State_tv.text = "*State is required!"

        } else if (Country.isEmpty()) {
            Country_et.requestFocus()
            First_name_tv.text = ""
            Last_name_tv.text = ""
            Address_tv.text = ""
            City_tv.text = ""
            State_tv.text = ""
            Country_tv.text = "*Country is required."

        } else if (Zipcode.isEmpty()) {
            Zipcode_et.requestFocus()
            First_name_tv.text = ""
            Last_name_tv.text = ""
            Address_tv.text = ""
            City_tv.text = ""
            Country_tv.text = ""
            State_tv.text = ""
            Zipcode_tv.text = "*Zipcode is required."

        } else if (Mobile.isEmpty()) {
            Mobile_et.requestFocus()
            First_name_tv.text = ""
            Last_name_tv.text = ""
            Address_tv.text = ""
            City_tv.text = ""
            Country_tv.text = ""
            Zipcode_tv.text = ""
            State_tv.text = ""
            Mobile_tv.text = "*Mobile is required."

        } else {
            First_name_tv.text = ""
            Last_name_tv.text = ""
            Address_tv.text = ""
            City_tv.text = ""
            Country_tv.text = ""
            Zipcode_tv.text = ""
            Mobile_tv.text = ""
            State_tv.text = ""

        }
    }

    fun editprofile(
        First_name: String, First_name_et: EditText, First_name_tv: TextView,
        Last_name: String, Last_name_et: EditText, Last_name_tv: TextView,
        Email: String, Email_et: EditText, Email_tv: TextView,
        ContactNumber: String, ContactNumber_et: EditText, ContactNumber_tv: TextView

    ) {

        First_name_tv.text = ""
        Last_name_tv.text = ""
        Email_tv.text = ""
        ContactNumber_tv.text = ""


        if (First_name.isEmpty()) {
            First_name_et.requestFocus()
            First_name_tv.text = "*First name is required."

        } else if (First_name.length < 2) {
            First_name_et.requestFocus()
            First_name_tv.text = "*Enter valid first name."

        } else if (Last_name.isEmpty()) {
            Last_name_et.requestFocus()
            Last_name_tv.text = "*Last name is required."

        } else if (Last_name.length < 2) {
            Last_name_et.requestFocus()
            Last_name_tv.text = "*Enter valid last name."

        } else if (Email.isEmpty()) {
            Email_et.requestFocus()
            Email_tv.text = "*Email is required."

        } else if (!Email.matches(Regex(emailPattern))) {
            Email_et.requestFocus()
            Email_tv.text = "*Enter valid email Id."

        } else if (ContactNumber.isEmpty()) {
            ContactNumber_et.requestFocus()
            ContactNumber_tv.text = "*Contact number is required."

        } else if (!ContactNumber.matches(Regex(MobilePattern))) {
            ContactNumber_et.requestFocus()
            ContactNumber_tv.text = "*Enter valid contact number."

        }
    }


    fun isEmail(email: String): Boolean {
        var returnvalue: Boolean
        if (email.matches(Regex(emailPattern))) {
            returnvalue = true
        } else {
            returnvalue = false
        }
        return returnvalue
    }

    fun isPassword(password: String): Boolean {
        var returnvalue: Boolean
        if (password.matches(Regex(Password))) {
            returnvalue = true
        } else {
            returnvalue = false
        }
        return returnvalue
    }

    fun isNameValidFormate(name: String): Boolean {
        val nameREGEX = Pattern.compile("^[A-Za-z]+$");
        return nameREGEX.matcher(name).matches()
    }

    fun isPhone(password: String): Boolean {
        var returnvalue: Boolean
        if (password.matches(Regex(MobilePattern))) {
            returnvalue = true
        } else {
            returnvalue = false
        }
        return returnvalue
    }

    fun isUsername(Username: String): Boolean {
        var returnvalue: Boolean
        if (Username.matches(Regex(UserName))) {
            returnvalue = true
        } else {
            returnvalue = false
        }
        return returnvalue
    }

    fun isany_number(anynum: String): Boolean {
        var returnvalue: Boolean
        if (anynum.matches(Regex(any_Number))) {
            returnvalue = true
        } else {
            returnvalue = false
        }
        return returnvalue
    }


    fun isValidEmailFormat(email: String): Boolean {
        val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})\$"
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
                    ".{8,}" +               //at least 8 characters
                    "$"
        );
        return passwordREGEX.matcher(password).matches()
    }

    fun CustomerLogin(
         password_et: EditText, password_tv: TextView,
         Email_et: EditText, Email_tv: TextView,
         PhoneLinear:LinearLayout,passwordLinear:LinearLayout
    ) {
        if (Email_et.text.isEmpty()){
            Email_et.requestFocus()
            Email_tv.text = "*Please enter your email address."
            PhoneLinear.setBackgroundResource(R.drawable.input_error)
        }
        else if (!Email_et.text.matches(Regex(emailPattern))) {
            Email_et.requestFocus()
            Email_tv.text = "*Enter valid email address."
            PhoneLinear.setBackgroundResource(R.drawable.input_error)

        } else if (password_et.text.isEmpty()) {
            password_et.requestFocus()
            Email_tv.text=""
            password_tv.text = "*Please enter password."
            PhoneLinear.setBackgroundResource(R.drawable.focus)
            passwordLinear.setBackgroundResource(R.drawable.input_error)
        }
        else{
            Email_tv.text=""
            password_tv.text =""
        }

    }
    fun RetailerLogin(
        password_et: EditText, password_tv: TextView,
        Email_et: EditText, Email_tv: TextView,
        PhoneLinear:LinearLayout,passwordLinear:LinearLayout
    ) {
        if (Email_et.text.isEmpty()){
            Email_et.requestFocus()
            Email_tv.text = "*Please enter retailer id."
            PhoneLinear.setBackgroundResource(R.drawable.input_error)
        }
       else if (password_et.text.isEmpty()) {
            password_et.requestFocus()
            Email_tv.text=""
            password_tv.text = "*Please enter password."
            PhoneLinear.setBackgroundResource(R.drawable.focus)
            passwordLinear.setBackgroundResource(R.drawable.input_error)
        }
        else{
            Email_tv.text=""
            password_tv.text =""
        }

    }

    fun Retailer_Registration(
        firstname_et: EditText, first_name: TextView,
        LastName_et: EditText, surname_tv: TextView,
        email_et:EditText,email_tv:TextView,
        mobile_editText:EditText,mobile_tv:TextView,country:LinearLayout,
        address:EditText,address_tv:TextView,
        city:EditText,city_tv:TextView,
        zipcode:EditText,zipcode_tv:TextView,
        country1:EditText,country_tv:TextView,
        password_et:EditText,password_tv:TextView,
        confirmpassword_et:EditText,confirmpassword_tv:TextView
    ){
        if (firstname_et.text.isEmpty()){
            firstname_et.requestFocus()
            first_name.text = "*Please enter your first name."
            firstname_et.setBackgroundResource(R.drawable.input_error)
        }
        else if(firstname_et.text.length <2){
            firstname_et.requestFocus()
            first_name.text = "*Enter valid first name."
            firstname_et.setBackgroundResource(R.drawable.input_error)
        }
        else if(LastName_et.text.isEmpty()){
            surname_tv.requestFocus()
            first_name.text=""
            surname_tv.text = "*Please enter your lastname."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.input_error)
        }

        else if(email_et.text.isEmpty()){
            email_tv.requestFocus()
            first_name.text=""
            surname_tv.text = ""
            email_tv.text = "*Please enter your email address."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.input_error)
        }
        else if(!email_et.text.matches(Regex(emailPattern))){
            email_tv.requestFocus()
            first_name.text=""
            surname_tv.text = ""
            email_tv.text = "*Enter valid email address."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.input_error)
        }

        else if(mobile_editText.text.isEmpty()){
            mobile_tv.requestFocus()
            first_name.text=""
            surname_tv.text = ""
            email_tv.text = ""
            mobile_tv.text = "*Please enter your mobile number."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.focus)
            country.setBackgroundResource(R.drawable.input_error)
        }


        else if (mobile_editText.text.length<8){
            mobile_tv.requestFocus()
            first_name.text=""
            surname_tv.text = ""
            email_tv.text = ""
            mobile_tv.text="Enter valid mobile number."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.focus)
            country.setBackgroundResource(R.drawable.input_error)
        }
        else if(address.text.isEmpty()){
            address.requestFocus()
            first_name.text=""
            surname_tv.text = ""
            email_tv.text = ""
            mobile_tv.text=""
            address_tv.text="*Please enter your address."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.focus)
            country.setBackgroundResource(R.drawable.focus)
            address.setBackgroundResource(R.drawable.input_error)
        }
        else if(city.text.isEmpty()){
            city.requestFocus()
            first_name.text=""
            surname_tv.text = ""
            email_tv.text = ""
            mobile_tv.text=""
            address_tv.text=""
            city_tv.text="*Please enter city."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.focus)
            country.setBackgroundResource(R.drawable.focus)
            address.setBackgroundResource(R.drawable.focus)
            city.setBackgroundResource(R.drawable.input_error)
        }
        else if(zipcode.text.isEmpty()){
            zipcode.requestFocus()
            first_name.text=""
            surname_tv.text = ""
            email_tv.text = ""
            mobile_tv.text=""
            address_tv.text=""
            city_tv.text=""
            zipcode_tv.text="*Please enter zipcode."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.focus)
            country.setBackgroundResource(R.drawable.focus)
            address.setBackgroundResource(R.drawable.focus)
            city.setBackgroundResource(R.drawable.focus)
            zipcode.setBackgroundResource(R.drawable.input_error)
        }
        else if(zipcode.text.length<5){
            zipcode.requestFocus()
            first_name.text=""
            surname_tv.text = ""
            email_tv.text = ""
            mobile_tv.text=""
            address_tv.text=""
            city_tv.text=""
            zipcode_tv.text="*Enter valid zipcode."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.focus)
            country.setBackgroundResource(R.drawable.focus)
            address.setBackgroundResource(R.drawable.focus)
            city.setBackgroundResource(R.drawable.focus)
            zipcode.setBackgroundResource(R.drawable.input_error)

        }
        else if(country1.text.isEmpty()){
            country_tv.requestFocus()
            first_name.text=""
            surname_tv.text = ""
            email_tv.text = ""
            mobile_tv.text=""
            address_tv.text=""
            city_tv.text=""
            zipcode_tv.text=""
            country_tv.text="*Please enter country."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.focus)
            country.setBackgroundResource(R.drawable.focus)
            address.setBackgroundResource(R.drawable.focus)
            city.setBackgroundResource(R.drawable.focus)
            zipcode.setBackgroundResource(R.drawable.focus)
            country1.setBackgroundResource(R.drawable.input_error)
        }
        else if(password_et.text.isEmpty()){
            password_tv.requestFocus()
            first_name.text=""
            surname_tv.text = ""
            email_tv.text = ""
            mobile_tv.text=""
            address_tv.text=""
            city_tv.text=""
            country_tv.text=""
            zipcode_tv.text=""
            password_tv.text = "*Please enter password."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.focus)
            country.setBackgroundResource(R.drawable.focus)
            address.setBackgroundResource(R.drawable.focus)
            city.setBackgroundResource(R.drawable.focus)
            zipcode.setBackgroundResource(R.drawable.focus)
            country1.setBackgroundResource(R.drawable.focus)
            password_et.setBackgroundResource(R.drawable.input_error)
        }
        else if(confirmpassword_et.text.isEmpty()){
            confirmpassword_tv.requestFocus()
            first_name.text=""
            password_tv.text = ""
            surname_tv.text = ""
            email_tv.text = ""
            mobile_tv.text=""
            country_tv.text=""
            zipcode_tv.text=""
            address_tv.text=""
            city_tv.text=""
            confirmpassword_tv.text = "*Please enter confirm password."
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.focus)
            country.setBackgroundResource(R.drawable.focus)
            address.setBackgroundResource(R.drawable.focus)
            city.setBackgroundResource(R.drawable.focus)
            zipcode.setBackgroundResource(R.drawable.focus)
            country1.setBackgroundResource(R.drawable.focus)
            password_et.setBackgroundResource(R.drawable.focus)
            confirmpassword_et.setBackgroundResource(R.drawable.input_error)
        }
        else if(!confirmpassword_et.text.toString().equals(password_et.text.toString())){
            confirmpassword_tv.requestFocus()
            first_name.text=""
            password_tv.text = ""
            surname_tv.text = ""
            email_tv.text = ""
            mobile_tv.text=""
            country_tv.text=""
            zipcode_tv.text=""
            address_tv.text=""
            city_tv.text=""
            confirmpassword_tv.text = "*Confirm password doesn't matched"
            firstname_et.setBackgroundResource(R.drawable.focus)
            LastName_et.setBackgroundResource(R.drawable.focus)
            email_et.setBackgroundResource(R.drawable.focus)
            country.setBackgroundResource(R.drawable.focus)
            address.setBackgroundResource(R.drawable.focus)
            city.setBackgroundResource(R.drawable.focus)
            zipcode.setBackgroundResource(R.drawable.focus)
            country1.setBackgroundResource(R.drawable.focus)
            password_et.setBackgroundResource(R.drawable.focus)
            password_et.setBackgroundResource(R.drawable.focus)
            confirmpassword_et.setBackgroundResource(R.drawable.input_error)
        }
        else{
            first_name.text=""
            password_tv.text = ""
            surname_tv.text = ""
            email_tv.text = ""
            mobile_tv.text=""
            country_tv.text=""
            zipcode_tv.text=""
            address_tv.text=""
            city_tv.text=""
            confirmpassword_tv.text =""
        }




    }
    fun Retailer_fillform(
        first_name: EditText,
        first_nametv: TextView,
        lastname: EditText,
        lastname_tv: TextView,
        emailaddress: EditText,
        email_tv: TextView,
        unique_product: EditText,
        uniqueproduct_tv: TextView,
        BrandList: ArrayList<BrandList>,
        list_brands_tv: TextView,
        companyname: EditText,
        companyname_tv: TextView,
        registration_number: EditText,
        registration_tv: TextView,
        category: EditText,
        category_tv: TextView,
        bankname: EditText,
        bankname_tv: TextView,
        brachname: EditText,
        Branchname_tv: TextView,
        branchcode: EditText,
        Branchcode_tv: TextView,
        swiftcode: EditText,
        SWIFTcode_tv: TextView,
        accountType: EditText,
        accounttype_tv: TextView,
        accountname: EditText,
        accountname_tv: TextView,
        accountnumber: EditText,
        accountnumber_tv: TextView,

    ){
        if (first_name.text.isEmpty()){
            first_name.requestFocus()
            first_nametv.text = "*Enter first name."
        }
        else if(lastname.text.isEmpty()){
            lastname.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = "*Enter last name."
        }
        else if(emailaddress.text.isEmpty()){
            emailaddress.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = "*Enter email address."
        }
        else if(!emailaddress.text.matches(Regex(emailPattern))){
            emailaddress.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = "*Enter valid email address."
        }
        else if(unique_product.text.isEmpty()){
            unique_product.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = "*Enter number of unique products."
        }
        else if (BrandList.size==0){
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            list_brands_tv.visibility=View.VISIBLE
        }

        else if(companyname.text.isEmpty()){
            companyname.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            companyname_tv.text = "*Enter company name."
            list_brands_tv.visibility=View.GONE

        }
        else if(registration_number.text.isEmpty()){
            registration_number.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            companyname_tv.text = ""
            registration_tv.text = "*Enter business registration number."
            list_brands_tv.visibility=View.GONE

        }
        else if(category.text.isEmpty()){
            category.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            companyname_tv.text = ""
            registration_tv.text = ""
            category_tv.text = "*Enter Category."
            list_brands_tv.visibility=View.GONE

        }
        else if(bankname.text.isEmpty()){
            bankname.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            companyname_tv.text = ""
            registration_tv.text = ""
            category_tv.text = ""
            bankname_tv.text = "*Enter Bank Name."
            list_brands_tv.visibility=View.GONE

        }
        else if(brachname.text.isEmpty()){
            brachname.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            companyname_tv.text = ""
            registration_tv.text = ""
            category_tv.text = ""
            bankname_tv.text = ""
            Branchname_tv.text = "*Enter Branch Name."
            list_brands_tv.visibility=View.GONE

        }
        else if(branchcode.text.isEmpty()){
            branchcode.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            companyname_tv.text = ""
            registration_tv.text = ""
            category_tv.text = ""
            bankname_tv.text = ""
            Branchname_tv.text = ""
            Branchcode_tv.text = "*Enter Branch code"
            list_brands_tv.visibility=View.GONE

        }
         else if(swiftcode.text.isEmpty()){
            swiftcode.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            companyname_tv.text = ""
            registration_tv.text = ""
            category_tv.text = ""
            bankname_tv.text = ""
            Branchname_tv.text = ""
            Branchcode_tv.text = ""
            SWIFTcode_tv.text = "*Enter SWIFT code"
            list_brands_tv.visibility=View.GONE

        }
        else if(accountType.text.isEmpty()){
            accountType.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            companyname_tv.text = ""
            registration_tv.text = ""
            category_tv.text = ""
            bankname_tv.text = ""
            Branchname_tv.text = ""
            Branchcode_tv.text = ""
            SWIFTcode_tv.text = ""
            accounttype_tv.text = "*Enter Account Type."
            list_brands_tv.visibility=View.GONE

        }
        else if(accountname.text.isEmpty()){
            accountname.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            companyname_tv.text = ""
            registration_tv.text = ""
            category_tv.text = ""
            bankname_tv.text = ""
            accounttype_tv.text = ""
            Branchname_tv.text = ""
            Branchcode_tv.text = ""
            SWIFTcode_tv.text = ""
            accountname_tv.text = "*Enter Account Name."
            list_brands_tv.visibility=View.GONE

        }
        else if(accountnumber.text.isEmpty()){
            accountnumber.requestFocus()
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            companyname_tv.text = ""
            registration_tv.text = ""
            category_tv.text = ""
            bankname_tv.text = ""
            accounttype_tv.text = ""
            accountname_tv.text = ""
            Branchname_tv.text = ""
            Branchcode_tv.text = ""
            SWIFTcode_tv.text = ""
            list_brands_tv.visibility=View.GONE
            accountnumber_tv.text = "*Enter Account Number."
        }

        else{
            first_nametv.text = ""
            lastname_tv.text = ""
            email_tv.text = ""
            uniqueproduct_tv.text = ""
            companyname_tv.text = ""
            registration_tv.text = ""
            category_tv.text = ""
            bankname_tv.text = ""
            accounttype_tv.text = ""
            accountname_tv.text = ""
            Branchname_tv.text = ""
            Branchcode_tv.text = ""
            SWIFTcode_tv.text = ""
            accountnumber_tv.text = ""
            list_brands_tv.visibility=View.GONE
        }
    }



    fun editprofile(firstname: EditText, errorTvEditFirstName: TextView,
        lastname: EditText, errorTvEditLastName: TextView,
        MobileNumber_EditText:EditText,errorTvEditContactNumber:TextView,
        postalcode:EditText,errorTvEditPostCode:TextView,
        address:EditText,errorTvEditAddress:TextView) {

        if (firstname.text.isEmpty()){
            firstname.requestFocus()
            errorTvEditFirstName.text = "*Please enter your first name."
        }
        else if(firstname.text.length<2){
            firstname.requestFocus()
            errorTvEditFirstName.text = "*Please enter valid first name."

        }
       else if (lastname.text.isEmpty()){
            lastname.requestFocus()
            errorTvEditFirstName.text = ""
            errorTvEditLastName.text = "*Please enter your last name."
        }
        else if(lastname.text.length<2){
            lastname.requestFocus()
            errorTvEditFirstName.text = ""
            errorTvEditLastName.text = "*Please enter valid last name."

        }
        else if (MobileNumber_EditText.text.isEmpty()){
            MobileNumber_EditText.requestFocus()
            errorTvEditLastName.text = ""
            errorTvEditFirstName.text = ""
            errorTvEditContactNumber.text = "*Please enter your mobile number."
        }
        else if(MobileNumber_EditText.text.length<8){
            MobileNumber_EditText.requestFocus()
            errorTvEditLastName.text = ""
            errorTvEditFirstName.text = ""
            errorTvEditContactNumber.text = "*Please enter valid mobile number."

        }
        else if(postalcode.text.isEmpty()){
            postalcode.requestFocus()
            errorTvEditLastName.text = ""
            errorTvEditFirstName.text = ""
            errorTvEditContactNumber.text = ""
            errorTvEditPostCode.text = "*Please enter your postal code."
        }
          else if(postalcode.text.length<5){
            postalcode.requestFocus()
            errorTvEditLastName.text = ""
            errorTvEditFirstName.text = ""
            errorTvEditContactNumber.text = ""
            errorTvEditPostCode.text = "*Please enter valid postal code."
        }
        else if(address.text.isEmpty()){
            address.requestFocus()
            errorTvEditLastName.text = ""
            errorTvEditFirstName.text = ""
            errorTvEditContactNumber.text = ""
            errorTvEditPostCode.text = ""
            errorTvEditAddress.text = "*Please enter your address."
        }


    else{
        errorTvEditLastName.text = ""
        errorTvEditFirstName.text = ""
        errorTvEditContactNumber.text = ""
        errorTvEditPostCode.text = ""
        errorTvEditAddress.text = ""
    }
    }

//    fun ServiceProvider_fillform(
//        firstname: EditText,
//        first_nametv: TextView,
//        lastname: EditText,
//        lastname_tv: TextView,
//        emailaddress: EditText,
//        emailaddress_tv: TextView,
//        companyname: EditText,
//        company_name: TextView,
//        businessRegistration: EditText,
//        tv_businessregistration: TextView,
//        category: EditText,
//        category_tv: TextView,
//
//        website: EditText,
//        website_tv: TextView,
//        socialmedia: EditText,
//        tv_socialmedia: TextView,
//        bankname: EditText,
//        tv_bank_name: TextView,
//        branchname: EditText,
//        tv_branch_name: TextView,
//        branchcode: EditText,
//        tv_branch_code: TextView,
//        swiftcode: EditText,
//        tv_swiftcode: TextView,
//        accounttype: EditText,
//        tv_accounttype: TextView,
//        swiftcode: EditText,
//        tv_swiftcode: TextView,
//        accounttype: EditText,
//        tv_accounttype: TextView,
//
//        ){
//        if (first_name.text.isEmpty()){
//            first_name.requestFocus()
//            first_nametv.text = "*Enter first name."
//        }
//        else if(lastname.text.isEmpty()){
//            lastname.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = "*Enter last name."
//        }
//        else if(emailaddress.text.isEmpty()){
//            emailaddress.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = "*Enter email address."
//        }
//        else if(!emailaddress.text.matches(Regex(emailPattern))){
//            emailaddress.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = "*Enter valid email address."
//        }
//        else if(unique_product.text.isEmpty()){
//            unique_product.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = "*Enter number of unique products."
//        }
//        else if (BrandList.size==0){
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            list_brands_tv.visibility=View.VISIBLE
//        }
//
//        else if(companyname.text.isEmpty()){
//            companyname.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            companyname_tv.text = "*Enter company name."
//            list_brands_tv.visibility=View.GONE
//
//        }
//        else if(registration_number.text.isEmpty()){
//            registration_number.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            companyname_tv.text = ""
//            registration_tv.text = "*Enter business registration number."
//            list_brands_tv.visibility=View.GONE
//
//        }
//        else if(category.text.isEmpty()){
//            category.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            companyname_tv.text = ""
//            registration_tv.text = ""
//            category_tv.text = "*Enter Category."
//            list_brands_tv.visibility=View.GONE
//
//        }
//        else if(bankname.text.isEmpty()){
//            bankname.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            companyname_tv.text = ""
//            registration_tv.text = ""
//            category_tv.text = ""
//            bankname_tv.text = "*Enter Bank Name."
//            list_brands_tv.visibility=View.GONE
//
//        }
//        else if(brachname.text.isEmpty()){
//            brachname.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            companyname_tv.text = ""
//            registration_tv.text = ""
//            category_tv.text = ""
//            bankname_tv.text = ""
//            Branchname_tv.text = "*Enter Branch Name."
//            list_brands_tv.visibility=View.GONE
//
//        }
//        else if(branchcode.text.isEmpty()){
//            branchcode.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            companyname_tv.text = ""
//            registration_tv.text = ""
//            category_tv.text = ""
//            bankname_tv.text = ""
//            Branchname_tv.text = ""
//            Branchcode_tv.text = "*Enter Branch code"
//            list_brands_tv.visibility=View.GONE
//
//        }
//        else if(swiftcode.text.isEmpty()){
//            swiftcode.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            companyname_tv.text = ""
//            registration_tv.text = ""
//            category_tv.text = ""
//            bankname_tv.text = ""
//            Branchname_tv.text = ""
//            Branchcode_tv.text = ""
//            SWIFTcode_tv.text = "*Enter SWIFT code"
//            list_brands_tv.visibility=View.GONE
//
//        }
//        else if(accountType.text.isEmpty()){
//            accountType.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            companyname_tv.text = ""
//            registration_tv.text = ""
//            category_tv.text = ""
//            bankname_tv.text = ""
//            Branchname_tv.text = ""
//            Branchcode_tv.text = ""
//            SWIFTcode_tv.text = ""
//            accounttype_tv.text = "*Enter Account Type."
//            list_brands_tv.visibility=View.GONE
//
//        }
//        else if(accountname.text.isEmpty()){
//            accountname.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            companyname_tv.text = ""
//            registration_tv.text = ""
//            category_tv.text = ""
//            bankname_tv.text = ""
//            accounttype_tv.text = ""
//            Branchname_tv.text = ""
//            Branchcode_tv.text = ""
//            SWIFTcode_tv.text = ""
//            accountname_tv.text = "*Enter Account Name."
//            list_brands_tv.visibility=View.GONE
//
//        }
//        else if(accountnumber.text.isEmpty()){
//            accountnumber.requestFocus()
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            companyname_tv.text = ""
//            registration_tv.text = ""
//            category_tv.text = ""
//            bankname_tv.text = ""
//            accounttype_tv.text = ""
//            accountname_tv.text = ""
//            Branchname_tv.text = ""
//            Branchcode_tv.text = ""
//            SWIFTcode_tv.text = ""
//            list_brands_tv.visibility=View.GONE
//            accountnumber_tv.text = "*Enter Account Number."
//        }
//
//        else{
//            first_nametv.text = ""
//            lastname_tv.text = ""
//            email_tv.text = ""
//            uniqueproduct_tv.text = ""
//            companyname_tv.text = ""
//            registration_tv.text = ""
//            category_tv.text = ""
//            bankname_tv.text = ""
//            accounttype_tv.text = ""
//            accountname_tv.text = ""
//            Branchname_tv.text = ""
//            Branchcode_tv.text = ""
//            SWIFTcode_tv.text = ""
//            accountnumber_tv.text = ""
//            list_brands_tv.visibility=View.GONE
//        }
//    }





}





