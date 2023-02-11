package com.exobe.Activities

import android.Manifest
import android.app.Activity
import android.app.DatePickerDialog
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.transition.CircularPropagation
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.exobe.Activities.services.ServicesMainActivity
import com.exobe.R
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File
import java.util.*

class Registration_serviceprovider : AppCompatActivity() {
    lateinit var title: TextView
    lateinit var back: ImageView
    lateinit var register: Button
    lateinit var mContext: Context
    var datePicker: DatePickerDialog? = null
    var yearset = 0
    var monthset = 0
    var day = 0
    val CAMERA_PERM_CODE = 101
    val c = Calendar.getInstance()
    var imageFile: File? = null
    var imagePath = ""
    var photoURI: Uri? = null
    private val GALLERY = 1
    private var CAMERA: Int = 2
    lateinit var image: Uri


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_serviceprovider)

        register = findViewById(R.id.register)
        title = findViewById(R.id.title)
        back = findViewById(R.id.back)
        mContext = this?.applicationContext!!
        back.visibility = View.VISIBLE
        title.setText("Register")
        back.setOnClickListener {
            finish()
        }
        register.setOnClickListener {
            finish()
        }
    }

}