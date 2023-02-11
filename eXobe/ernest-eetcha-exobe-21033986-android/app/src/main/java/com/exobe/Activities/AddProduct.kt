package com.exobe

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.CategoryList_response
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast

class AddProduct : AppCompatActivity() {

    lateinit var Add : Button
    lateinit var Back : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        Add = findViewById(R.id.addProduct)
        Back = findViewById(R.id.addProductsBack)

        Add.setOnClickListener {
            androidextention.productAddedCartDialog(resources.getString(R.string.cart1), this)
        }

        Back.setOnClickListener {
            onBackPressed()
        }



    }

    override fun onBackPressed() {
        finish()
    }


}