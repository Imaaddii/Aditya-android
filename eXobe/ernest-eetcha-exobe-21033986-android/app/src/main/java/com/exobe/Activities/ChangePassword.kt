package com.exobe.Activities

import android.content.Context
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.changepasswordresponse
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject

class ChangePassword : Fragment() ,ApiResponseListener<changepasswordresponse>{

    lateinit var cancel_button: Button
    lateinit var save_button: Button
    lateinit var ivgroup: TextView
    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var OldPasswordET:EditText
    lateinit var PasswordET:EditText
    lateinit var ConfirmPasswordET:EditText
    lateinit var ConfirmPasswordTv:TextView
    lateinit var OldPasswordTV:TextView
    lateinit var NewPasswordTV:TextView
    lateinit var OldPassword:LinearLayout
    lateinit var PasswordLL:LinearLayout
    lateinit var ConfirmPasswordLL:LinearLayout
    var flag = ""
    lateinit var oldcross_eye:ImageView
    lateinit var cross_eye:ImageView
    lateinit var cross_eye2:ImageView
    var oldpassword=""
    var newpassword=""
    var confirmpassword=""
    lateinit var mContext:Context
    private var passwordNotVisible = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_change_password, container, false)
        cancel_button = view.findViewById(R.id.cancel_button)
        save_button = view.findViewById(R.id.save_button)
        OldPasswordET = view.findViewById(R.id.OldPasswordET)
        PasswordET = view.findViewById(R.id.PasswordET)
        OldPasswordTV = view.findViewById(R.id.OldPasswordTV)
        NewPasswordTV = view.findViewById(R.id.NewPasswordTV)
        ConfirmPasswordET = view.findViewById(R.id.ConfirmPasswordET)
        ConfirmPasswordTv = view.findViewById(R.id.ConfirmPasswordTv)
        OldPassword = view.findViewById(R.id.OldPassword)
        PasswordLL = view.findViewById(R.id.PasswordLL)
        ConfirmPasswordLL = view.findViewById(R.id.ConfirmPasswordLL)
        oldcross_eye = view.findViewById(R.id.oldcross_eye)
        cross_eye = view.findViewById(R.id.cross_eye)
        cross_eye2 = view.findViewById(R.id.cross_eye2)
        mContext = activity?.applicationContext!!

        if (requireArguments().getString("flag") != null) {
            flag = requireArguments().getString("flag").toString()

        }
        if (flag.equals("services")) {

            title = activity?.findViewById(R.id.title)!!
            back = activity?.findViewById(R.id.back)!!
            title!!.setText("Change Password")
            back!!.visibility = View.VISIBLE
            back!!.setOnClickListener {
                fragmentManager?.popBackStack()
            }

        } else {
            setToolbar()
            mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
            mainHeader.visibility = View.VISIBLE

            back.setOnClickListener {
                fragmentManager?.popBackStack()
            }
        }

        cancel_button.setOnClickListener{
            fragmentManager?.popBackStack()
        }
        save_button.setOnClickListener {

            validatins()
        }

        passwordShow()




        return view
    }

    fun setToolbar() {
        title = activity?.findViewById(R.id.PreLoginTitle_TextView2)!!
        cart = activity?.findViewById(R.id.cart_icon)!!
        filter = activity?.findViewById(R.id.filter_icon)!!
        back = activity?.findViewById(R.id.imageView_back)!!
        MenuClick = activity?.findViewById(R.id.MenuClick)!!
        ProductImageView = activity?.findViewById(R.id.Product_ImageView)!!
        DealsImageView = activity?.findViewById(R.id.Deals_ImageView)!!
        greyBellImageView = activity?.findViewById(R.id.greyBell_ImageView)!!
        cart.visibility = View.GONE
        filter.visibility = View.GONE
        back.visibility = View.VISIBLE

        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("Change Password")
    }

    fun validatins(){

        clearFields()

        if(OldPasswordET.text.isEmpty()){
            OldPasswordTV.requestFocus()
            OldPasswordTV.visibility = View.VISIBLE
            OldPasswordTV.text="*Please enter your old password."
            OldPassword.setBackgroundResource(R.drawable.input_error)
        }else if (PasswordET.text.isEmpty()) {
            PasswordET.requestFocus()
            NewPasswordTV.visibility = View.VISIBLE
            NewPasswordTV.text="*Please enter new password."
            PasswordLL.setBackgroundResource(R.drawable.input_error)

        } else if (ConfirmPasswordET.text.isEmpty()) {
            ConfirmPasswordET.requestFocus()
            ConfirmPasswordTv.visibility = View.VISIBLE
            ConfirmPasswordTv.setText("*Please enter confirm password.")
            ConfirmPasswordLL.setBackgroundResource(R.drawable.input_error)

        } else if (!PasswordET.text.toString().equals(ConfirmPasswordET.text.toString())) {
            ConfirmPasswordET.requestFocus()
            ConfirmPasswordTv.visibility = View.VISIBLE
            ConfirmPasswordTv.setText("*Confirm password should be same with the password field.")
            ConfirmPasswordLL.setBackgroundResource(R.drawable.input_error)

        }else{

            oldpassword= OldPasswordET.text.toString()
           newpassword= PasswordET.text.toString()
           confirmpassword= ConfirmPasswordET.text.toString()
            changepassword(oldpassword,newpassword,confirmpassword)
        }

    }
    private fun clearFields() {


        OldPasswordTV.text=""
        OldPasswordTV.visibility = View.GONE
        OldPassword.setBackgroundResource(R.drawable.white_border)

        NewPasswordTV.text=""
        NewPasswordTV.visibility = View.GONE
        PasswordLL.setBackgroundResource(R.drawable.white_border)


        ConfirmPasswordTv.setText("")
        ConfirmPasswordTv.visibility = View.GONE
        ConfirmPasswordLL.setBackgroundResource(R.drawable.white_border)
    }


    private fun passwordShow() {
        oldcross_eye.setOnClickListener {
            if (passwordNotVisible == 0) {
                OldPasswordET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                oldcross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
                OldPasswordET.setSelection(OldPasswordET.length())
                passwordNotVisible = 1


            } else if (passwordNotVisible == 1) {
                OldPasswordET.transformationMethod = PasswordTransformationMethod.getInstance()
                oldcross_eye.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash_solid))
                OldPasswordET.setSelection(OldPasswordET.length())
                passwordNotVisible = 0
            } else {
                OldPasswordET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                oldcross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
                OldPasswordET.setSelection(OldPasswordET.length())
                passwordNotVisible = 1
            }
        }
        cross_eye.setOnClickListener {
            if (passwordNotVisible == 0) {
                PasswordET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
                PasswordET.setSelection(PasswordET.length())
                passwordNotVisible = 1


            } else if (passwordNotVisible == 1) {
                PasswordET.transformationMethod = PasswordTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash_solid))
                PasswordET.setSelection(PasswordET.length())
                passwordNotVisible = 0
            } else {
                PasswordET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
                PasswordET.setSelection(PasswordET.length())
                passwordNotVisible = 1
            }
        }
        cross_eye2.setOnClickListener {
            if (passwordNotVisible == 0) {
                ConfirmPasswordET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                cross_eye2.setImageDrawable(resources.getDrawable(R.drawable.eye))
                ConfirmPasswordET.setSelection(ConfirmPasswordET.length())
                passwordNotVisible = 1


            } else if (passwordNotVisible == 1) {
                ConfirmPasswordET.transformationMethod = PasswordTransformationMethod.getInstance()
                cross_eye2.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash_solid))
                ConfirmPasswordET.setSelection(ConfirmPasswordET.length())
                passwordNotVisible = 0
            } else {
                ConfirmPasswordET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                cross_eye2.setImageDrawable(resources.getDrawable(R.drawable.eye))
                ConfirmPasswordET.setSelection(ConfirmPasswordET.length())
                passwordNotVisible = 1
            }
        }
    }
    fun changepassword(password: String,newpassword :String,confirmpassword :String,) {

        if (androidextention.isOnline(mContext)) {
            androidextention.showProgressDialog(activity)
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<changepasswordresponse> =
                ApiCallBack<changepasswordresponse>(this, "changepassword", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("password", password)
            jsonObject.addProperty("newPassword", newpassword)
            jsonObject.addProperty("confirmPassword", confirmpassword)


            try {
                serviceManager.changepasswordApi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }
    override fun onApiSuccess(response: changepasswordresponse, apiName: String?) {
        androidextention.disMissProgressDialog(activity)
        if (response.responseCode==200){
            fragmentManager?.popBackStack()
            androidextention.alertBox("Password changed",requireContext())
        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
        androidextention.disMissProgressDialog(activity)
        val gson = GsonBuilder().create()
        var pojo = response_modal_class()

        try {
            pojo = gson.fromJson(response, pojo::class.java)
            androidextention.alertBox(pojo.responseMessage,requireContext())

        } catch (e: Exception) {
            // handle failure at error parse
        }
    }
    override fun onApiFailure(failureMessage: String?, apiName: String?) {
        androidextention.disMissProgressDialog(activity)
    }

}