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
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.example.complyany.entity.permission.RequestPermission
import com.example.validationpractice.utlis.FormValidation
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.exobe.androidextention
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.getprofile_response
import com.exobe.entity.Response.login_response
import com.exobe.entity.Response.update_profile_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class EditProfileActivity : AppCompatActivity(), ApiResponseListener<getprofile_response> {

    lateinit var backButtonEditProfile: ImageView
    lateinit var btnSave: Button
    lateinit var mContext: Context
    lateinit var errorTvEditFirstName: TextView
    lateinit var errorTvEditLastName: TextView
    lateinit var errorTvEditContactNumber: TextView
    lateinit var errorTvEditPostCode: TextView
    lateinit var errorTvEditAddress: TextView
    lateinit var select_Image: ImageView
    lateinit var firstname: EditText
    lateinit var lastname: EditText
    lateinit var MobileNumber_EditText: EditText
    lateinit var postalcode: EditText
    lateinit var address: EditText
    val CAMERA_PERM_CODE = 101
    var imageFile: File? = null
    var photoURI: Uri? = null
    private var CAMERA: Int = 2
    var imagePath = ""
    private val GALLERY = 1
    lateinit var image: Uri
    lateinit var profile_image: CircleImageView
    var USER_IMAGE_UPLOADED = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        backButtonEditProfile = findViewById(R.id.backButtonEditProfile)
        btnSave = findViewById(R.id.btnSave)
        mContext = this?.applicationContext!!

        errorTvEditFirstName = findViewById(R.id.errorTvEditFirstName)
        errorTvEditLastName = findViewById(R.id.errorTvEditLastName)
        errorTvEditContactNumber = findViewById(R.id.errorTvEditContactNumber)
        errorTvEditPostCode = findViewById(R.id.errorTvEditPostCode)
        errorTvEditAddress = findViewById(R.id.errorTvEditAddress)
        select_Image = findViewById(R.id.select_Image)
        profile_image = findViewById(R.id.profile_image)
        firstname = findViewById(R.id.firstname)
        lastname = findViewById(R.id.lastname)
        MobileNumber_EditText = findViewById(R.id.MobileNumber_EditText)
        postalcode = findViewById(R.id.postalcode)
        address = findViewById(R.id.address)


        backButtonEditProfile.setOnClickListener {
            onBackPressed()
        }

        btnSave.setOnClickListener {
            FormValidation.editprofile(
                firstname, errorTvEditFirstName,
                lastname, errorTvEditLastName,
                MobileNumber_EditText, errorTvEditContactNumber,
                postalcode, errorTvEditPostCode,
                address, errorTvEditAddress
            )
            if (errorTvEditFirstName.text.equals("") && errorTvEditLastName.text.equals("") && errorTvEditContactNumber.text.equals(
                    ""
                ) && errorTvEditPostCode.text.equals("") && errorTvEditAddress.text.equals("")
            ) {
                var firstname = firstname.text.toString()
                var lastname = lastname.text.toString()
                var mobilenumber = MobileNumber_EditText.text.toString()
                var postalcode = postalcode.text.toString()
                var address = address.text.toString()
                UpdateProfileAPI(firstname, lastname, mobilenumber, postalcode, address)

            }
        }

        select_Image.setOnClickListener {
            RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERM_CODE
                )
            } else {
                selectImage()
            }
        }

        mygetprofileApi()
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
                }

            }
        } else if (requestCode == CAMERA) {
            if (resultCode == RESULT_OK) {

                try {

                    imageFile = File(imagePath)
                    Glide.with(this).load(imageFile).into(profile_image)

                    USER_IMAGE_UPLOADED = true
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


    override fun onBackPressed() {
        finish()
    }

    fun mygetprofileApi() {
        if (androidextention.isOnline(mContext)) {
            androidextention.showProgressDialog(this)
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<getprofile_response> =
                ApiCallBack<getprofile_response>(this, "mygetprofileApi", mContext)
            try {
                serviceManager.profileApi(callBack)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }

    }

    override fun onApiSuccess(response: getprofile_response, apiName: String?) {
        androidextention.disMissProgressDialog(this)

        if (response.responseCode == 200) {
            firstname.setText(response.result?.firstName)
            lastname.setText(response.result?.lastName)
            MobileNumber_EditText.setText(response.result?.mobileNumber)
            postalcode.setText(response.result?.zipCode)
            address.setText(response.result?.address)


        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
        androidextention.disMissProgressDialog(this)

    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
        androidextention.disMissProgressDialog(this)

    }

    fun UpdateProfileAPI(
        firstname: String,
        lastname: String,
        mobilenumber: String,
        postalcode: String,
        address: String
    ) {

        if (androidextention.isOnline(this)) {
            androidextention.showProgressDialog(this)
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<update_profile_response> =
                ApiCallBack<update_profile_response>(object :
                    ApiResponseListener<update_profile_response> {
                    override fun onApiSuccess(response: update_profile_response, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)
                        if (response.responseCode == 200) {
                            finish()
                        }

                    }

                    override fun onApiErrorBody(response: String, apiName: String?) {
                        androidextention.disMissProgressDialog(this@EditProfileActivity)

                        val gson = GsonBuilder().create()
                        var pojo = response_modal_class()

                        try {
                            pojo = gson.fromJson(response, pojo::class.java)
                            androidextention.alertBox(pojo.responseMessage, mContext)

                        } catch (e: Exception) {
                            // handle failure at error parse
                        }
                    }
                    override fun onApiFailure(failureMessage: String?, apiName: String?) {
                        androidextention.disMissProgressDialog(this@EditProfileActivity)
                    }

                }, "UpdateProfileAPI", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("firstName", firstname)
            jsonObject.addProperty("lastName", lastname)
            jsonObject.addProperty("mobileNumber", mobilenumber)
            jsonObject.addProperty("zipCode", postalcode)
            jsonObject.addProperty("address", address)
            try {
                serviceManager.Updateprofileapi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }


}