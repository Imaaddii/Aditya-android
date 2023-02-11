package com.exobe.Activities

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.example.complyany.entity.permission.RequestPermission
import com.exobe.Activities.services.ServicesMainActivity
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class uploadDocumentation_retailer : AppCompatActivity() {
    lateinit var back:ImageView
    lateinit var title:TextView
    lateinit var upload_document_button:Button
    var flag:String=""
    val CAMERA_PERM_CODE = 101
    var imageFile: File?= null
    var photoURI: Uri? = null
    private var CAMERA: Int = 2
    var imagePath=""
    private val GALLERY = 1
    lateinit var image: Uri
    lateinit var upload_pic1: ImageView
    lateinit var rl_pic1: RelativeLayout
    lateinit var upload_pic2: ImageView
    lateinit var rl_pic2: RelativeLayout
    lateinit var upload_pic3: ImageView
    lateinit var rl_pic3: RelativeLayout
    lateinit var upload_pic4: ImageView
    lateinit var rl_pic4: RelativeLayout
    lateinit var upload_pic5: ImageView
    lateinit var rl_pic5: RelativeLayout
    lateinit var rl_pic6: RelativeLayout
    lateinit var upload_pic6: ImageView
    lateinit var rl_pic7: RelativeLayout
    lateinit var upload_pic7: ImageView
    lateinit var rl_pic8: RelativeLayout
    lateinit var upload_pic8: ImageView
    lateinit var rl_pic9: RelativeLayout
    lateinit var upload_pic9: ImageView
    lateinit var rl_pic10: RelativeLayout
    lateinit var upload_pic10: ImageView
    var cameraflag= ""




    var USER_IMAGE_UPLOADED= false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_documentation_retailer)
        back=findViewById(R.id.back)
        title=findViewById(R.id.title)
        upload_document_button=findViewById(R.id.upload_document_button)
        upload_pic1=findViewById(R.id.upload_pic1)
        rl_pic1=findViewById(R.id.rl_pic1)
        upload_pic2=findViewById(R.id.upload_pic2)
        rl_pic2=findViewById(R.id.rl_pic2)
        upload_pic3=findViewById(R.id.upload_pic3)
        rl_pic3=findViewById(R.id.rl_pic3)
        upload_pic4=findViewById(R.id.upload_pic4)
        rl_pic4=findViewById(R.id.rl_pic4)
        upload_pic5=findViewById(R.id.upload_pic5)
        upload_pic6=findViewById(R.id.upload_pic6)
        rl_pic5=findViewById(R.id.rl_pic5)
        rl_pic6=findViewById(R.id.rl_pic6)
        rl_pic7=findViewById(R.id.rl_pic7)
        upload_pic7=findViewById(R.id.upload_pic7)
        upload_pic8=findViewById(R.id.upload_pic8)
        rl_pic8=findViewById(R.id.rl_pic8)
        rl_pic9=findViewById(R.id.rl_pic9)
        upload_pic9=findViewById(R.id.upload_pic9)
        rl_pic10=findViewById(R.id.rl_pic10)
        upload_pic10=findViewById(R.id.upload_pic10)

        if(intent!=null){
            flag=intent.getStringExtra("flag")!!
        }
        title.setText("Upload Documentation")
        upload_document_button.setOnClickListener {
            if(flag.equals("services")){
                var alertDialog: AlertDialog? = null
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Your documents have been uploaded. You’ll receive an email for further instruction after verification")
                builder.setPositiveButton("ok") { dialogInterface, which ->
                    alertDialog!!.dismiss()
                    SavedPrefManager.saveStringPreferences(this, SavedPrefManager.isLogin, "true")
                    val intent = Intent(this, ServicesMainActivity::class.java)
                    startActivity(intent)

                    finish()
                }
                alertDialog = builder.create()
                alertDialog!!.setCancelable(false)
                alertDialog!!.show()


            }

            else{
                var alertDialog: AlertDialog? = null
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Your documents have been uploaded. You will receive an email for further instruction after verification")
                builder.setPositiveButton("ok") { dialogInterface, which ->
                    alertDialog!!.dismiss()
                    SavedPrefManager.saveStringPreferences(this, SavedPrefManager.isLogin, "true")

                    val intent = Intent(this, MainActivity::class.java)

                    intent.putExtra("flag", "Retailer")

                    startActivity(intent)

                    finish()
                }
                alertDialog = builder.create()
                alertDialog!!.setCancelable(false)
                alertDialog!!.show()


            }

        }
        rl_pic1.setOnClickListener {
            cameraflag = "rl_pic1"
            RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),CAMERA_PERM_CODE)
            } else {
                selectImage()
            }
        }

        rl_pic2.setOnClickListener {
            cameraflag="rl_pic2"
            RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),CAMERA_PERM_CODE)
            } else {
                selectImage()
            }
        }
            rl_pic3.setOnClickListener {
                cameraflag="rl_pic3"
            RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),CAMERA_PERM_CODE)
            } else {
                selectImage()
            }
        }
            rl_pic4.setOnClickListener {
                cameraflag="rl_pic4"

                RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),CAMERA_PERM_CODE)
            } else {
                selectImage()
            }
        }
            rl_pic5.setOnClickListener {
                cameraflag="rl_pic5"
                RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),CAMERA_PERM_CODE)
            } else {
                selectImage()
            }
        }
            rl_pic6.setOnClickListener {
                cameraflag="rl_pic6"
                RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),CAMERA_PERM_CODE)
            } else {
                selectImage()
            }
        }
            rl_pic7.setOnClickListener {
                cameraflag="rl_pic7"
                RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),CAMERA_PERM_CODE)
            } else {
                selectImage()
            }
        }
            rl_pic8.setOnClickListener {
                cameraflag="rl_pic8"
                RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),CAMERA_PERM_CODE)
            } else {
                selectImage()
            }
        }
            rl_pic9.setOnClickListener {
                cameraflag="rl_pic9"
                RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),CAMERA_PERM_CODE)
            } else {
                selectImage()
            }
        }
            rl_pic10.setOnClickListener {
                cameraflag="rl_pic10"
                RequestPermission.requestMultiplePermissions(this)
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),CAMERA_PERM_CODE)
            } else {
                selectImage()
            }
        }



        back.setOnClickListener {
            finish()
        }
    }
    private fun selectImage() {
        val dialog = BottomSheetDialog(this)

        val view = layoutInflater.inflate(R.layout.choose_camera_bottom_sheet, null)
        dialog.setCancelable(true)

        val camera = view.findViewById<ImageView>(R.id.choose_from_camera)
        camera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(this.getPackageManager()) != null) {
                try {
                    imageFile = createImageFile()!!
                } catch (ex: IOException) {
                }
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

        dialog.setContentView(view)
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
                        if (cameraflag.equals("rl_pic1")) {
                            Glide.with(this).load(imageFile).into(upload_pic1)
                        }else if(cameraflag.equals("rl_pic2")){
                            Glide.with(this).load(imageFile).into(upload_pic2)

                        }else if(cameraflag.equals("rl_pic3")) {
                            Glide.with(this).load(imageFile).into(upload_pic3)

                        }else if(cameraflag.equals("rl_pic4")) {
                            Glide.with(this).load(imageFile).into(upload_pic4)

                        }else if(cameraflag.equals("rl_pic5")) {
                            Glide.with(this).load(imageFile).into(upload_pic5)

                        }else if(cameraflag.equals("rl_pic6")) {
                            Glide.with(this).load(imageFile).into(upload_pic6)

                        }else if(cameraflag.equals("rl_pic7")) {
                            Glide.with(this).load(imageFile).into(upload_pic7)

                        }else if(cameraflag.equals("rl_pic8")) {
                            Glide.with(this).load(imageFile).into(upload_pic8)

                        }else if(cameraflag.equals("rl_pic9")) {
                            Glide.with(this).load(imageFile).into(upload_pic9)

                        }else if(cameraflag.equals("rl_pic10")) {
                            Glide.with(this).load(imageFile).into(upload_pic10)

                        }
                    }



                    USER_IMAGE_UPLOADED = true
                }

            }
        } else if (requestCode == CAMERA) {
            if (resultCode == RESULT_OK) {

                try {

                    imageFile = File(imagePath)

                    if (cameraflag.equals("rl_pic1")) {
                        Glide.with(this).load(imageFile).into(upload_pic1)
                    }else if(cameraflag.equals("rl_pic2")){
                        Glide.with(this).load(imageFile).into(upload_pic2)

                    }else if(cameraflag.equals("rl_pic3")) {
                        Glide.with(this).load(imageFile).into(upload_pic3)

                    }else if(cameraflag.equals("rl_pic4")) {
                        Glide.with(this).load(imageFile).into(upload_pic4)

                    }else if(cameraflag.equals("rl_pic5")) {
                        Glide.with(this).load(imageFile).into(upload_pic5)

                    }else if(cameraflag.equals("rl_pic6")) {
                        Glide.with(this).load(imageFile).into(upload_pic6)

                    }else if(cameraflag.equals("rl_pic7")) {
                        Glide.with(this).load(imageFile).into(upload_pic7)

                    }else if(cameraflag.equals("rl_pic8")) {
                        Glide.with(this).load(imageFile).into(upload_pic8)

                    }else if(cameraflag.equals("rl_pic9")) {
                        Glide.with(this).load(imageFile).into(upload_pic9)

                    }else if(cameraflag.equals("rl_pic10")) {
                        Glide.with(this).load(imageFile).into(upload_pic10)

                    }
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
}