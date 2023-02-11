package com.exobe.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.validationpractice.utlis.FormValidation
import com.exobe.Adaptor.BrandAdaptor
import com.exobe.Adaptor.SupplierAdaptor
import com.exobe.ModelClass.BrandList
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.androidextention
import com.exobe.customClicks.deleteBrand
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.RetailerFillformResponse
import com.exobe.entity.Response.update_profile_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject

class fillDetails_retailer : AppCompatActivity(), deleteBrand {
    lateinit var add_product: TextView
    lateinit var add_suppliers: TextView
    lateinit var title: TextView
    lateinit var back: ImageView
    lateinit var et_suppliers_name: EditText
    lateinit var business_form_submit: Button
    lateinit var brandAdaptor: BrandAdaptor
    lateinit var supplierAdaptor: SupplierAdaptor
    lateinit var rv_add_product_brand: RecyclerView
    lateinit var rv_add_suppliers: RecyclerView
    lateinit var ll_VAT: LinearLayout
    lateinit var RB_yes: RadioButton
    lateinit var RB_no: RadioButton
    lateinit var checkbox1: CheckBox
    lateinit var checkbox2: CheckBox
    lateinit var checkbox3: CheckBox
    lateinit var checkbox4: CheckBox
    lateinit var checkbox5: CheckBox
    lateinit var first_name: EditText
    lateinit var first_nametv: TextView
    lateinit var lastname: EditText
    lateinit var lastname_tv: TextView
    lateinit var emailaddress: EditText
    lateinit var email_tv: TextView
    lateinit var unique_product: EditText
    lateinit var uniqueproduct_tv: TextView
    lateinit var et_brand_name: EditText
    lateinit var list_brands_tv: TextView
    lateinit var companyname: EditText
    lateinit var companyname_tv: TextView
    lateinit var registration_number: EditText
    lateinit var registration_tv: TextView
    lateinit var category: EditText
    lateinit var category_tv: TextView
    lateinit var bankname: EditText
    lateinit var bankname_tv: TextView
    lateinit var accountType: EditText
    lateinit var accounttype_tv: TextView
    lateinit var accountname: EditText
    lateinit var accountname_tv: TextView
    lateinit var accountnumber: EditText
    lateinit var accountnumber_tv: TextView
    lateinit var brachname: EditText
    lateinit var Branchname_tv: TextView
    lateinit var branchcode: EditText
    lateinit var Branchcode_tv: TextView
    lateinit var swiftcode: EditText
    lateinit var SWIFTcode_tv: TextView
    lateinit var stock_yes: RadioButton
    lateinit var stock_no: RadioButton
    lateinit var physical_yes: RadioButton
    lateinit var physical_no: RadioButton
    lateinit var vat_edittext: EditText
    lateinit var mContext: Context
    var keepStockValue = true
    var PhysicalStore = true
    var VatNumber = ""
    var monthlyRevenue = ""


    var BrandList = ArrayList<BrandList>()
    var RetailerList = ArrayList<BrandList>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_details_retailer)
        vat_edittext = findViewById(R.id.vat_edittext)
        stock_yes = findViewById(R.id.stock_yes)
        stock_no = findViewById(R.id.stock_no)
        physical_yes = findViewById(R.id.physical_yes)
        physical_no = findViewById(R.id.physical_no)
        add_product = findViewById(R.id.add_product)
        title = findViewById(R.id.title)
        mContext=this.applicationContext!!
        business_form_submit = findViewById(R.id.business_form_submit)
        et_suppliers_name = findViewById(R.id.et_suppliers_name)
        et_brand_name = findViewById(R.id.et_brand_name)
        rv_add_product_brand = findViewById(R.id.rv_add_product_brand)
        rv_add_suppliers = findViewById(R.id.rv_add_suppliers)
        add_suppliers = findViewById(R.id.add_suppliers)
        back = findViewById(R.id.back)
        ll_VAT = findViewById(R.id.ll_VAT)
        RB_yes = findViewById(R.id.RB_yes)
        RB_no = findViewById(R.id.RB_no)
        checkbox1 = findViewById(R.id.checkbox1)
        checkbox2 = findViewById(R.id.checkbox2)
        checkbox3 = findViewById(R.id.checkbox3)
        checkbox4 = findViewById(R.id.checkbox4)
        checkbox5 = findViewById(R.id.checkbox5)
        first_name = findViewById(R.id.first_name)
        first_nametv = findViewById(R.id.first_nametv)
        lastname = findViewById(R.id.lastname)
        lastname_tv = findViewById(R.id.lastname_tv)
        emailaddress = findViewById(R.id.emailaddress)
        email_tv = findViewById(R.id.email_tv)
        unique_product = findViewById(R.id.unique_product)
        uniqueproduct_tv = findViewById(R.id.uniqueproduct_tv)
        et_brand_name = findViewById(R.id.et_brand_name)
        list_brands_tv = findViewById(R.id.list_brands_tv)
        companyname = findViewById(R.id.companyname)
        companyname_tv = findViewById(R.id.companyname_tv)
        registration_number = findViewById(R.id.registration_number)
        registration_tv = findViewById(R.id.registration_tv)
        category = findViewById(R.id.category)
        category_tv = findViewById(R.id.category_tv)
        bankname = findViewById(R.id.bankname)
        bankname_tv = findViewById(R.id.bankname_tv)
        accountType = findViewById(R.id.accountType)
        accounttype_tv = findViewById(R.id.accounttype_tv)
        accountname = findViewById(R.id.accountname)
        accountname_tv = findViewById(R.id.accountname_tv)
        accountnumber = findViewById(R.id.accountnumber)
        accountnumber_tv = findViewById(R.id.accountnumber_tv)
        brachname = findViewById(R.id.brachname)
        Branchname_tv = findViewById(R.id.Branchname_tv)
        branchcode = findViewById(R.id.branchcode)
        swiftcode = findViewById(R.id.swiftcode)
        SWIFTcode_tv = findViewById(R.id.SWIFTcode_tv)
        Branchcode_tv = findViewById(R.id.Branchcode_tv)

        rv_add_product_brand = findViewById(R.id.rv_add_product_brand)
        rv_add_product_brand.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        brandAdaptor = BrandAdaptor(this, BrandList, this)
        rv_add_product_brand.adapter = brandAdaptor

        rv_add_suppliers.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        supplierAdaptor = SupplierAdaptor(this, RetailerList, this)
        rv_add_suppliers.adapter = supplierAdaptor

        physical_yes.setOnClickListener {
            PhysicalStore = true
        }

        physical_no.setOnClickListener {
            PhysicalStore = false
        }
        stock_yes.setOnClickListener {
            keepStockValue = true
        }
        stock_no.setOnClickListener {
            keepStockValue = false
        }

        title.setText("Business Details")
        RB_yes.setOnClickListener {
            ll_VAT.visibility = View.VISIBLE

        }
        RB_no.setOnClickListener {
            ll_VAT.visibility = View.GONE

        }

        checkbox1.setOnClickListener {
            monthlyRevenue = "Less than R20K"
            checkbox2.isChecked = false
            checkbox3.isChecked = false
            checkbox4.isChecked = false
            checkbox5.isChecked = false
        }
        checkbox2.setOnClickListener {
            monthlyRevenue = "R20K-R50K"
            checkbox1.isChecked = false
            checkbox3.isChecked = false
            checkbox4.isChecked = false
            checkbox5.isChecked = false
        }
        checkbox3.setOnClickListener {
            monthlyRevenue = "R50K-R100K"
            checkbox2.isChecked = false
            checkbox1.isChecked = false
            checkbox4.isChecked = false
            checkbox5.isChecked = false
        }
        checkbox4.setOnClickListener {
            monthlyRevenue = "R100K-R500K"
            checkbox2.isChecked = false
            checkbox3.isChecked = false
            checkbox1.isChecked = false
            checkbox5.isChecked = false
        }
        checkbox5.setOnClickListener {
            monthlyRevenue = "More than R500K"
            checkbox2.isChecked = false
            checkbox3.isChecked = false
            checkbox4.isChecked = false
            checkbox1.isChecked = false
        }

        back.setOnClickListener {
            finish()
        }
        business_form_submit.setOnClickListener {
            FormValidation.Retailer_fillform(
                first_name, first_nametv,
                lastname, lastname_tv,
                emailaddress, email_tv,
                unique_product, uniqueproduct_tv,
                BrandList, list_brands_tv,
                companyname, companyname_tv,
                registration_number, registration_tv,
                category, category_tv,
                bankname, bankname_tv,
                brachname, Branchname_tv,
                branchcode, Branchcode_tv,
                swiftcode, SWIFTcode_tv,
                accountType, accounttype_tv,
                accountname, accountname_tv,
                accountnumber, accountnumber_tv
            )
            if (!first_name.text.isEmpty() && !lastname.text.isEmpty() && !emailaddress.text.isEmpty() && !unique_product.text.isEmpty()
                && !companyname.text.isEmpty() && !registration_number.text.isEmpty() && !category.text.isEmpty() && !bankname.text.isEmpty()
                && !brachname.text.isEmpty() && !branchcode.text.isEmpty() && !swiftcode.text.isEmpty() && !accountType.text.isEmpty() && !accountname.text.isEmpty() && !accountnumber.text.isEmpty()
            ) {

                var intent = Intent(applicationContext, uploadDocumentation_retailer::class.java)
                intent.putExtra("flag", "retailer")
                startActivity(intent)
                finish()

//                fillformAPI(firstname,lastname,email,uniqueproduct,companyname,businessRegistrationnumber,BankName,branchname,branchcode,swiftcode,accounttype,accountname,accountNumber,)

            }

        }

        add_product.setOnClickListener {

            val brand = et_brand_name.text.toString()
            if (!brand.isEmpty()) {
                BrandList.add(BrandList(brand))
                brandAdaptor.notifyDataSetChanged()
                et_brand_name.text.clear()
            }

        }

        add_suppliers.setOnClickListener {

            val suppliers = et_suppliers_name.text.toString()
            if (!suppliers.isEmpty()) {
                RetailerList.add(BrandList(suppliers))
                supplierAdaptor.notifyDataSetChanged()
                et_suppliers_name.text.clear()
            }

        }
    }

    override fun deleteItem(position: Int) {
        BrandList.removeAt(position)
        brandAdaptor.notifyDataSetChanged()
    }

    override fun deleteRetailer(position: Int) {
        RetailerList.removeAt(position)
        supplierAdaptor.notifyDataSetChanged()
    }


    fun fillformAPI(
        firstname: String,
        lastname: String,
        email: String,
        uniqueproduct: Int,
//        listofbrands: String,
        companyname: String,
        businessRegistrationnumber:String,
        BankName:String,
        branchname:String,
        swiftcode:String,
        branchCode:String,
        accounttype:String,
        accountname:String,
        accountNumber:String
    ) {

        if (androidextention.isOnline(this)) {
            androidextention.showProgressDialog(this)
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<RetailerFillformResponse> =
                ApiCallBack<RetailerFillformResponse>(object :
                    ApiResponseListener<RetailerFillformResponse> {
                    override fun onApiSuccess(response: RetailerFillformResponse, apiName: String?) {
                        androidextention.disMissProgressDialog(mContext)
                        if (response.responseCode == 200) {
                            var intent = Intent(applicationContext, uploadDocumentation_retailer::class.java)
                            intent.putExtra("flag", "retailer")
                            startActivity(intent)
                            finish()
                        }

                    }

                    override fun onApiErrorBody(response: String, apiName: String?) {
                        androidextention.disMissProgressDialog(this@fillDetails_retailer)

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
                        androidextention.disMissProgressDialog(this@fillDetails_retailer)
                    }

                }, "fillformAPI", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("ownerFirstName", firstname)
            jsonObject.addProperty("ownerLastName", lastname)
            jsonObject.addProperty("ownerEmail", email)
            jsonObject.addProperty("noOfUniqueProducts", uniqueproduct)
//            jsonObject.addProperty("listOfBrandOrProducts", listofbrands)
            jsonObject.addProperty("keepStock", keepStockValue)
            jsonObject.addProperty("isPhysicalStore", PhysicalStore)
            jsonObject.addProperty("companyName", companyname)
            jsonObject.addProperty("businessRegNumber", businessRegistrationnumber)
            jsonObject.addProperty("vatNumber", vat_edittext.text.toString())
            jsonObject.addProperty("monthlyRevenue", monthlyRevenue)
            jsonObject.addProperty("bankName", BankName)
            jsonObject.addProperty("branchName", branchname)
            jsonObject.addProperty("branchCode", branchCode)
            jsonObject.addProperty("swiftCode", swiftcode)
            jsonObject.addProperty("accountType", accounttype)
            jsonObject.addProperty("accountName", accountname)
            jsonObject.addProperty("accountNumber", accountNumber)

            try {
                serviceManager.fillformapi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }
}