package com.exobe.Activities

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.example.complyany.entity.permission.RequestPermission
import com.example.validationpractice.utlis.FormValidation
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Request.SignupRequest
import com.exobe.entity.Response.SignupResponse
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.GsonBuilder
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity : AppCompatActivity(),ApiResponseListener<SignupResponse> {

    lateinit var LogIN:LinearLayout
    lateinit var FirstNameET: EditText
    lateinit var LastNameET: EditText
    lateinit var PhoneET: EditText
    lateinit var EmailEt: EditText
    lateinit var NewPasswordEt: EditText
    lateinit var ConfirmPasswordET: EditText
    lateinit var FirstNameTV: TextView
    lateinit var LastNameTV: TextView
    lateinit var PhoneTV: TextView
    lateinit var EmailAddressTV: TextView
    lateinit var PasswordTV: TextView
    lateinit var ConfirmPasswordTV: TextView
    lateinit var TermTV: TextView
    lateinit var SignUp: Button
    lateinit var checkBox: CheckBox
    lateinit var FirstNameLL:LinearLayout
    lateinit var LastNameLL:LinearLayout
    lateinit var PhoneLL:LinearLayout
    lateinit var EmailAddress:LinearLayout
    lateinit var Password:LinearLayout
    lateinit var ConfirmPassword:LinearLayout
    lateinit var cross_eye: ImageView
    lateinit var cross_eye2: ImageView
    private var passwordNotVisible = 0
    lateinit var select_Image:ImageView
    val CAMERA_PERM_CODE = 101
    var imageFile: File?= null
    var photoURI: Uri? = null
    private var CAMERA: Int = 2
     var imagePath=""
    private val GALLERY = 1
    lateinit var image: Uri
    lateinit var profile_image:CircleImageView
    var USER_IMAGE_UPLOADED= false
    var mContext: Context = this
    var type = ""
    lateinit var email:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mContext = this?.applicationContext!!

        LogIN=findViewById(R.id.LogIN)
        FirstNameET=findViewById(R.id.FirstNameET)
        LastNameET=findViewById(R.id.LastNameET)
        PhoneET=findViewById(R.id.PhoneET)
        EmailEt=findViewById(R.id.EmailEt)
        NewPasswordEt=findViewById(R.id.NewPasswordEt)
        ConfirmPasswordET=findViewById(R.id.ConfirmPasswordET)
        FirstNameTV=findViewById(R.id.FirstNameTV)
        LastNameTV=findViewById(R.id.LastNameTV)
        PhoneTV=findViewById(R.id.PhoneTV)
        EmailAddressTV=findViewById(R.id.EmailAddressTV)
        PasswordTV=findViewById(R.id.PasswordTV)
        ConfirmPasswordTV=findViewById(R.id.ConfirmPasswordTV)
        TermTV=findViewById(R.id.TermTV)
        SignUp=findViewById(R.id.SignUp)
        checkBox=findViewById(R.id.CheckBox)
        FirstNameLL=findViewById(R.id.FirstNameLL)
        LastNameLL=findViewById(R.id.LastNameLL)
        PhoneLL=findViewById(R.id.PhoneLL)
        EmailAddress=findViewById(R.id.EmailAddress)
        Password=findViewById(R.id.Password)
        ConfirmPassword=findViewById(R.id.ConfirmPassword)
        cross_eye=findViewById(R.id.cross_eye)
        cross_eye2=findViewById(R.id.cross_eye2)
        select_Image=findViewById(R.id.select_Image)
        profile_image=findViewById(R.id.profile_image)
        type = "CUSTOMER"

        LogIN.setOnClickListener {
            finish()
        }

        SignUp.setOnClickListener {


            if(FormValidation.customerRegistser(
                    FirstNameET,
                    FirstNameTV,
                    LastNameET,
                    LastNameTV,
                    PhoneET,
                    PhoneTV,
                    EmailEt,
                    EmailAddressTV,
                    NewPasswordEt,
                    PasswordTV,
                    ConfirmPasswordET,
                    ConfirmPasswordTV,
                    checkBox,
                    TermTV ,
                    FirstNameLL,
                    LastNameLL,
                    PhoneLL,
                    EmailAddress,
                    Password,
                    ConfirmPassword
                )){
                email=EmailEt.text.toString()

                signupCustomer(email)

            }
            else{
            }
        }
        passwordShow()


        select_Image.setOnClickListener{
            RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),CAMERA_PERM_CODE)
            } else {
                selectImage()
            }
        }






    }


    //     ShowPassword
    fun passwordShow() {
        cross_eye.setOnClickListener {
            if (passwordNotVisible == 0) {
                NewPasswordEt.transformationMethod = HideReturnsTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
                passwordNotVisible = 1


            } else if (passwordNotVisible == 1) {
                NewPasswordEt.transformationMethod = PasswordTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash_solid))
                passwordNotVisible = 0
            } else {
                NewPasswordEt.transformationMethod = HideReturnsTransformationMethod.getInstance()
                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
                passwordNotVisible = 1
            }
        }
        cross_eye2.setOnClickListener {
            if (passwordNotVisible == 0) {
                ConfirmPasswordET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                cross_eye2.setImageDrawable(resources.getDrawable(R.drawable.eye))
                passwordNotVisible = 1


            } else if (passwordNotVisible == 1) {
                ConfirmPasswordET.transformationMethod = PasswordTransformationMethod.getInstance()
                cross_eye2.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash_solid))
                passwordNotVisible = 0
            } else {
                ConfirmPasswordET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                cross_eye2.setImageDrawable(resources.getDrawable(R.drawable.eye))
                passwordNotVisible = 1
            }
        }
    }


    private fun selectImage() {
        // on below line we are creating a new bottom sheet dialog.
        val dialog = BottomSheetDialog(this)

        // on below line we are inflating a layout file which we have created.
        val view = layoutInflater.inflate(R.layout.choose_camera_bottom_sheet, null)

        // below line is use to set cancelable to avoid
        // closing of dialog box when clicking on the screen.
        dialog.setCancelable(true)

        val CameraButton = view.findViewById<ImageView>(R.id.choose_from_camera)
        CameraButton.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(this.getPackageManager()) != null) {
                try {
                    imageFile = createImageFile()!!
                } catch (ex: IOException) {
                }
                // Continue only if the File was successfully created
                if (imageFile != null) {
                    photoURI = FileProvider.getUriForFile(
                        this,
                        "com.exobe.fileprovider",
                        imageFile!!
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, CAMERA)
                    dialog.dismiss()
                }
            }
        }

        val GalleryButton = view.findViewById<ImageView>(R.id.choose_from_gallery)
        GalleryButton.setOnClickListener {
            val intent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            startActivityForResult(intent, GALLERY)
            dialog.dismiss()
        }

        // on below line we are setting
        // content view to our view.
        dialog.setContentView(view)

        // on below line we are calling
        // a show method to display a dialog.
        dialog.show()
    }




    @Throws(IOException::class)
    private fun createImageFile(): File? {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            imageFileName,
            ".jpg",
            storageDir
        )

        imagePath = image.absolutePath
        return image
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_CANCELED) {
            return
        }
        if (requestCode == GALLERY) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    image = data.data!!
                    val path = getPathFromURI(image)

                    if (path != null) {
                        imageFile = File(path)
                        Glide.with(this).load(imageFile).into(profile_image)

                    }

                    USER_IMAGE_UPLOADED = true
//                    if(USER_IMAGE_UPLOADED) {
//                        uploadUserImageApi()
//                    }
                }

            }
        } else if (requestCode == CAMERA) {
            if (resultCode == RESULT_OK) {

                try {

                    imageFile = File(imagePath)
                    Glide.with(this).load(imageFile).into(profile_image)
//                        ProfileImage.setImageURI(Uri.fromFile(imageFile))

                    USER_IMAGE_UPLOADED = true
//                    if(USER_IMAGE_UPLOADED) {
//                        uploadUserImageApi()
//                    }
                } catch (e: java.lang.Exception) {

                }


            }
        }
    }


    fun getPathFromURI(contentUri: Uri?): String? {
        var res: String? = null
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor: Cursor? = contentResolver.query(contentUri!!, proj, null, null, null)
        if (cursor!!.moveToFirst()) {
            val column_index: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            res = cursor.getString(column_index)
        }
        cursor.close()
        return res
    }

    fun signupCustomer(email: String) {
        if (androidextention.isOnline(this)) {
            androidextention.showProgressDialog(this)
            val serviceManager = ServiceManager(this)
            val callBack: ApiCallBack<SignupResponse> =
                ApiCallBack<SignupResponse>(this, "signupCustomer", mContext)

            val RegisterRequest = SignupRequest()
            RegisterRequest.userType = type
            RegisterRequest.firstName =FirstNameET.text.toString()
            RegisterRequest.lastName=LastNameET.text.toString()
            RegisterRequest.email=EmailEt.text.toString()
            RegisterRequest.countryCode="+27"
            RegisterRequest.mobileNumber=PhoneET.text.toString()
            RegisterRequest.password=NewPasswordEt.text.toString()
//            if(!.equals("")) {
//                RegisterRequest.profile_pic = "data:image/png;base64," + base64
//            }
//            RegisterRequest.confirmPassword=ConfirmPasswordET.toString()

            try {
                serviceManager.SignupApi(callBack, RegisterRequest)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }

    override fun onApiSuccess(response: SignupResponse, apiName: String?) {
        androidextention.disMissProgressDialog(this)
        if (response!!.responseCode == 200) {
            val intent = Intent(this, OtpVerification::class.java)
            intent.putExtra("email", email)
            intent.putExtra("flag1", "register")
            startActivity(intent)
        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
        androidextention.disMissProgressDialog(this)
        val gson = GsonBuilder().create()
        var pojo = response_modal_class()

        try {
            pojo = gson.fromJson(response, pojo::class.java)
            androidextention.alertBox(pojo.responseMessage, this)

        } catch (e: Exception) {
            // handle failure at error parse
        }
    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
        androidextention.disMissProgressDialog(this)

    }
}