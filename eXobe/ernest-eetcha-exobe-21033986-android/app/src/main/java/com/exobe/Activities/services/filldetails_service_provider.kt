package com.exobe.Activities.services

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Activities.uploadDocumentation_retailer
import com.exobe.Adaptor.*
import com.exobe.Model.ServicesList
import com.exobe.ModelClass.BrandList
import com.exobe.ModelClass.myModel
import com.exobe.R
import com.exobe.customClicks.GetValue
import com.exobe.customClicks.deleteBrand
import com.exobe.customClicks.popupItemClickListner
import com.exobe.validations.DialogUtils
import java.lang.Exception


class filldetails_service_provider : AppCompatActivity(), deleteBrand, popupItemClickListner,
    GetValue {
    lateinit var add_product: TextView
    lateinit var add_suppliers: TextView
    lateinit var title: TextView
    lateinit var back: ImageView
    lateinit var et_brand_name: TextView
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
    var BrandList = ArrayList<BrandList>()
    var RetailerList = ArrayList<BrandList>()
    var array: ArrayList<ServicesList> = ArrayList()
    lateinit var adapter: PopupStateDialogRecyclerViewAdapter
    var flag = ""
    lateinit var dialog: Dialog
    lateinit var SubCategoryName: TextView


    lateinit var ShowUpDialog: Dialog
    lateinit var SubCategoryRecyclerView: RecyclerView
    lateinit var SelectedSubCategoryRecyclerView: RecyclerView
    lateinit var selectAllCheckBox: CheckBox
    var isCheckBoxSelected: Boolean = false
    var SubCategoryListArray: ArrayList<myModel> = ArrayList()
    var selectedSubCategoryListArray: ArrayList<myModel> = ArrayList()
    lateinit var SearchEditText: EditText
    lateinit var SubCategoryAdapter: OperationalSubCategoryRecycler
    lateinit var selectedSubCategoryAdapter: GetValueSubCategoryRecycler


    var array1: ArrayList<ServicesList> = ArrayList()





    var selectedCountryString = ""
    lateinit var operationalCountryAdapter: OperationalSubCategoryRecycler
    lateinit var selectedOperationalCountryAdapter: GetValueSubCategoryRecycler
    var arrayList: ArrayList<String> = ArrayList()
    lateinit var globalCompanyId: String
    lateinit var operationalCountryDialog: Dialog
    var countryListArray: ArrayList<myModel> = ArrayList()
    var selectedCountryListArray: ArrayList<myModel> = ArrayList()
    lateinit var selectedCountryRecycler: RecyclerView
    lateinit var operationalRecyclerView: RecyclerView




    var countryCode: String =""
    var state: String =""
    var city: String =""
    var stateName: String = ""
    var countryName: String = ""
    lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filldetails_service_provider)
        add_product = findViewById(R.id.add_product)
        title = findViewById(R.id.title)
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
        SubCategoryName = findViewById(R.id.SubCategoryName)

        rv_add_product_brand = findViewById(R.id.rv_add_product_brand)
        rv_add_product_brand.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        brandAdaptor = BrandAdaptor(this, BrandList, this)
        rv_add_product_brand.adapter = brandAdaptor

        rv_add_suppliers.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        supplierAdaptor = SupplierAdaptor(this, RetailerList, this)
        rv_add_suppliers.adapter = supplierAdaptor

        title.setText("Business Details")
        RB_yes.setOnClickListener {

            ll_VAT.visibility = View.VISIBLE

        }
        RB_no.setOnClickListener {
            ll_VAT.visibility = View.GONE

        }
        checkbox1.setOnClickListener {
            checkbox2.isChecked = false
            checkbox3.isChecked = false
            checkbox4.isChecked = false
            checkbox5.isChecked = false
        }
        checkbox2.setOnClickListener {
            checkbox1.isChecked = false
            checkbox3.isChecked = false
            checkbox4.isChecked = false
            checkbox5.isChecked = false
        }
        checkbox3.setOnClickListener {
            checkbox2.isChecked = false
            checkbox1.isChecked = false
            checkbox4.isChecked = false
            checkbox5.isChecked = false
        }
        checkbox4.setOnClickListener {
            checkbox2.isChecked = false
            checkbox3.isChecked = false
            checkbox1.isChecked = false
            checkbox5.isChecked = false
        }
        checkbox5.setOnClickListener {
            checkbox2.isChecked = false
            checkbox3.isChecked = false
            checkbox4.isChecked = false
            checkbox1.isChecked = false
        }


        array.add(ServicesList("Electrician"))
        array.add(ServicesList("Plumber"))
        array.add(ServicesList("Mechanic"))
        array.add(ServicesList("Beauty"))
        array.add(ServicesList("Electrician"))
        array.add(ServicesList("Plumber"))
        array.add(ServicesList("Mechanic"))
        array.add(ServicesList("Beauty"))



        array1.add(ServicesList("Fan Repairing"))
        array1.add(ServicesList("AC"))
        array1.add(ServicesList("Fan Repairing"))
        array1.add(ServicesList("Electrician"))
        array1.add(ServicesList("AC"))
        array1.add(ServicesList("Fan Repairing"))
        array1.add(ServicesList("AC"))

        countryListArray.add(myModel("","Beauty",0, false))
        countryListArray.add(myModel("","Mechanic",1, false))
        countryListArray.add(myModel("","Plumber",2, false))
        countryListArray.add(myModel("","Mechanic",3, false))
        countryListArray.add(myModel("","Electrician",4, false))
        countryListArray.add(myModel("","Beauty",5, false))



        back.setOnClickListener {
            finish()
        }
        business_form_submit.setOnClickListener {
            var intent = Intent(applicationContext, uploadDocumentation_retailer::class.java)
            intent.putExtra("flag", "services")
            startActivity(intent)
        }


        et_brand_name.setOnClickListener {
            flag = "Service"
            showPopup(array, flag)
        }


        SubCategoryName.setOnClickListener {
            flag = "SubCategory"
            showPopup(array1, flag)
        }

        add_product.setOnClickListener {

            val brand = et_brand_name.text.toString()
            val sub = SubCategoryName.text.toString()
            if (!brand.isEmpty()) {
                BrandList.add(BrandList(brand))
                brandAdaptor.notifyDataSetChanged()
                et_brand_name.text = ""
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


    fun showPopup(array: ArrayList<ServicesList>, flag: String) {


        val binding = LayoutInflater.from(this).inflate(R.layout.popup_lists, null)
        dialog = DialogUtils().createDialog(this, binding.rootView, 0)!!;
        dialog!!.show()


        val recyclerView: RecyclerView = binding.findViewById(R.id.popup_recyclerView)



        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PopupStateDialogRecyclerViewAdapter(this, array, dialog, flag, this)
        recyclerView.adapter = adapter


        var dialougTitle = binding.findViewById<TextView>(R.id.popupTitle)
        dialougTitle.text = "Services"
        var dialougbackButton = binding.findViewById<ImageView>(R.id.back)
        dialougbackButton.setOnClickListener { dialog.dismiss() }


//        SearchEditText.addTextChangedListener(textWatcher)
    }

    override fun getData(data: String, flag: String) {
        if (flag == "Service") {
            et_brand_name.text = data
            dialog.dismiss()

        }else if (flag == "SubCategory") {
            SubCategoryName.text = data
            dialog.dismiss()

        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun operationalCountryPopUp() {



        try {

            val binding = LayoutInflater.from(this).inflate(R.layout.subcategory_popup, null)
            operationalCountryDialog = DialogUtils().createDialog(this, binding.rootView, 0)!!
            operationalRecyclerView = binding.findViewById<RecyclerView>(R.id.operational_country_recyclerview)
            operationalRecyclerView.layoutManager = LinearLayoutManager(this)

//            OperationalCountryApi()
            operationalCountryAdapter = OperationalSubCategoryRecycler(this,countryListArray,this)
            operationalRecyclerView.adapter = operationalCountryAdapter


            selectedCountryRecycler = binding.findViewById(R.id.operationalCountry)

            selectAllCheckBox = binding.findViewById(R.id.select_all_checkBox)

            adddata();

//            selectedCountryListArray.clear()

            if (isCheckBoxSelected){
                selectAllCheckBox.isChecked = true
            }

            selectAllCheckBox.setOnClickListener {

                if (selectAllCheckBox.isChecked){
                    for (i in 0 until countryListArray.size){

                        countryListArray[i].flag = true
                        selectedCountryListArray.add(countryListArray[i])
                    }
                    operationalCountryAdapter.notifyDataSetChanged()
                    selectedOperationalCountryAdapter.notifyDataSetChanged()

                    isCheckBoxSelected = true

                } else {
                    for (i in 0 until countryListArray.size){

                        countryListArray[i].flag = false
                        selectedCountryListArray.clear()

                    }
                    operationalCountryAdapter.notifyDataSetChanged()
                    selectedOperationalCountryAdapter.notifyDataSetChanged()
                    isCheckBoxSelected = false
                }
            }




            val dialougbackButton = binding.findViewById<TextView>(R.id.back)
            dialougbackButton.setOnClickListener {

                operationalCountryDialog.dismiss()
            }


            var Save = binding.findViewById<ImageView>(R.id.SaveButons)
            Save.setOnClickListener {
                operationalCountryDialog.dismiss()


                var selectedCountryString = ""

                if (selectedCountryListArray.size < 4){
                    for (i in 0 until selectedCountryListArray.size){

                        selectedCountryString = selectedCountryString + selectedCountryListArray[i].country + ", "

                    }
                } else {

                    selectedCountryString = selectedCountryListArray[0].country + ", " + selectedCountryListArray[1].country + ", " + selectedCountryListArray[2].country + " +" + ((selectedCountryListArray.size) - 3).toString()

                }

                SubCategoryName.text = selectedCountryString


            }
//            SearchEditText.addTextChangedListener(textWatcher)





            var dialougTitle = binding.findViewById<TextView>(R.id.popupTitle)
            dialougTitle.setText("Sub Category")
            operationalCountryDialog.dismiss()




        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    private fun adddata() {
        selectedCountryRecycler.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        selectedOperationalCountryAdapter = GetValueSubCategoryRecycler(this,selectedCountryListArray,this)

        selectedCountryRecycler.adapter = selectedOperationalCountryAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun Names(Country: Int, b: Boolean, country: String?) {
        for (i in countryListArray.indices) {
            if (countryListArray.get(i).country.equals(selectedCountryListArray.get(Country).country)) {
                countryListArray.get(i).flag=false
                operationalCountryAdapter.notifyItemChanged(i)
                break
            }
        }
        selectedCountryListArray.removeAt(Country)
        selectedOperationalCountryAdapter.notifyDataSetChanged()
    }

    override fun Addlist(Country: Int, b: Boolean, country: String?) {
        if (countryListArray.get(Country).flag == true)
        {
            for (i in selectedCountryListArray.indices) {
                if (selectedCountryListArray.get(i).country
                        .equals(countryListArray.get(Country).country)
                ) {
                    selectedCountryListArray.removeAt(i)
                    selectedOperationalCountryAdapter.notifyDataSetChanged()
                    break
                }
            }
            countryListArray.get(Country).flag=false
        } else{
            selectedCountryListArray.add(countryListArray.get(Country))
            selectedOperationalCountryAdapter.notifyDataSetChanged()
            countryListArray.get(Country).flag=true
        }
        operationalCountryAdapter.notifyItemChanged(Country)
    }

    override fun FilterArrayList(position: Int, b: Boolean, country: String?, countryCode: String?) {}



}