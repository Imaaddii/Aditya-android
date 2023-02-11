package com.exobe.Fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.complyany.SpinnerAdapter
import com.exobe.Activities.search_composer
import com.exobe.ModelClass.CategoryModel
import com.exobe.R
import com.exobe.androidextention
import java.text.SimpleDateFormat
import com.exobe.dialogs.productDialog
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.CategoryList_response
import com.exobe.entity.Response.SubCategoryResponse
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import java.util.*
import kotlin.collections.ArrayList


class add_products : Fragment() ,ApiResponseListener<CategoryList_response>{
    lateinit var image_1: ImageView
    lateinit var add_image_one: LinearLayout
    lateinit var image_2: ImageView
    lateinit var add_image_two: LinearLayout
    lateinit var image_3: ImageView
    lateinit var add_image_Three: LinearLayout
    lateinit var mContext: Context
    lateinit var tv_startdate: TextView
    lateinit var tv_end_date: TextView
    lateinit var start_time: TextView
    lateinit var end_time: TextView
    lateinit var productCategory_spinner: Spinner
    lateinit var Sub_Category_spinner: Spinner
    lateinit var search_button: Button
    var datePicker: DatePickerDialog? = null
    var yearset = 0
    var monthset = 0
    var day = 0
    var myHour = ""
    var latestProductList: ArrayList<String> = ArrayList()
    var CategoryModel = ArrayList<CategoryModel>()
    var subCategoryListModal = ArrayList<CategoryModel>()

    val c = Calendar.getInstance()

    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var addDealsField: LinearLayout
    lateinit var save: Button
    var flag = ""
    lateinit var ProductTitle: TextView

    var requestCategoryId = ""
    var requestSubCategoryId = ""

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_add_products, container, false)
        mContext = activity?.applicationContext!!

        image_1 = view.findViewById(R.id.image_1)
        add_image_one = view.findViewById(R.id.add_image_one)
        search_button = view.findViewById(R.id.search_button)
        tv_startdate = view.findViewById(R.id.tv_startdate)
        tv_end_date = view.findViewById(R.id.tv_end_date)
        image_2 = view.findViewById(R.id.image_2)
        add_image_two = view.findViewById(R.id.add_image_two)
        image_3 = view.findViewById(R.id.image_3)
        add_image_Three = view.findViewById(R.id.add_image_Three)
        start_time = view.findViewById(R.id.start_time)
        end_time = view.findViewById(R.id.end_time)
        addDealsField = view.findViewById(R.id.addDealsField)
        productCategory_spinner = view.findViewById(R.id.productCategory_spinner)
        save = view.findViewById(R.id.save)
        ProductTitle = view.findViewById(R.id.ProductTitle)
        Sub_Category_spinner = view.findViewById(R.id.SubCategory_spinner)





        CategoryListApi()

        productCategory_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, pos: Int, id: Long
            ) {
                var item = parent.getItemAtPosition(pos)
                for(i in 0 until CategoryModel.size) {
                    if (item.equals(CategoryModel.get(i).productName)) {
                        requestCategoryId = CategoryModel.get(i).id
                        subCategoryListApi(CategoryModel.get(i).id)
                    }
                }
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }

        Sub_Category_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, pos: Int, id: Long
            ) {
                var item = parent.getItemAtPosition(pos)
                for(i in 0 until subCategoryListModal.size) {
                    if (item.equals(subCategoryListModal.get(i).productName)) {
                        requestSubCategoryId = subCategoryListModal.get(i).id
                    }
                }
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }
        if(requireArguments().getString("flag") != null) {
            flag = requireArguments().getString("flag").toString()

        }

        if(flag.equals("Add Deal") || flag.equals("Edit Deal")) {
            addDealsField.visibility = View.VISIBLE
        } else {
            addDealsField.visibility = View.GONE
        }
        setToolbar()
        back.setOnClickListener{
            fragmentManager?.popBackStack()
        }

        save.setOnClickListener {

            fragmentManager?.let {
                productDialog("Product Added Successfully", "Product").show(
                    it,
                    "MyCustomFragment"
                )
            }
        }



        search_button.setOnClickListener {

            requireFragmentManager().beginTransaction()
                .replace(R.id.FrameLayout, search_composer(),"Search")?.addToBackStack("Search")
                .commit()
        }



//        val Product_category: ArrayAdapter<String> = ArrayAdapter<String>(
//            requireContext(), android.R.layout.simple_spinner_item,
//            resources.getStringArray(R.array.select_product_category)
//        )
//        Product_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        productCategory_spinner.setAdapter(Product_category)

        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val date = calendar.get(Calendar.DAY_OF_MONTH)

        datePicker = DatePickerDialog(mContext)
//
//        txtFromDate.text = "$date-${month + 1}-$year"
//
//        txtToDate.text = "$date-${month + 1}-$year"


        tv_startdate.setOnClickListener {

            val datePickerDialog = DatePickerDialog(requireContext(),
                R.style.DatePickerTheme,
                DatePickerDialog.OnDateSetListener
                { view, year, monthOfYear, dayOfMonth ->
                    c.set(year, monthOfYear + 1, dayOfMonth)

                    tv_startdate.text = "$dayOfMonth-${monthOfYear + 1}-$year"
                    yearset = year
                    monthset = monthOfYear + 1
                    day = dayOfMonth


                },
                year,
                month,
                date
            )

            datePickerDialog.show()
            getTime()

        }


        c.set(year, month + 1, date)

        tv_end_date.setOnClickListener {

            val datePickerDialog = DatePickerDialog(requireContext(),
                R.style.DatePickerTheme,
                DatePickerDialog.OnDateSetListener
                { view, year, monthOfYear, dayOfMonth ->

                    tv_end_date.text = "$dayOfMonth-${monthOfYear + 1}-$year"

                },
                year,
                month,
                date
            )

            datePickerDialog.getDatePicker().minDate = c.timeInMillis

            datePickerDialog.show()
            getendTime()

        }


//        lateinit var image_1: ImageView
//        lateinit var add_image_one: LinearLayout
//        lateinit var image_2: ImageView
//        lateinit var add_image_two: LinearLayout
//        lateinit var image_3: ImageView
//        lateinit var add_image_Three: LinearLayout
        add_image_one.setOnClickListener {

        }

        add_image_two.setOnClickListener {

        }

        add_image_Three.setOnClickListener {

        }

        return view

    }


    fun getTime() {

        val cal = Calendar.getInstance()

        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)

            start_time.text = SimpleDateFormat("HH:mm").format(cal.time)
        }

        start_time.setOnClickListener {
            TimePickerDialog(
                requireContext(),
                R.style.DatePickerTheme,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

    }

    fun getendTime() {

        val cal = Calendar.getInstance()

        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)

            end_time.text = SimpleDateFormat("HH:mm").format(cal.time)
        }

        end_time.setOnClickListener {
            TimePickerDialog(
                requireContext(),
                R.style.DatePickerTheme,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
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
        title.setText(flag)
    }

    fun CategoryListApi() {
        if (androidextention.isOnline(mContext)) {
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<CategoryList_response> =
                ApiCallBack<CategoryList_response>(this, "CategoryListApi", mContext)
            try {
                serviceManager.listCategoryApi(callBack)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }

    }

    override fun onApiSuccess(response: CategoryList_response, apiName: String?) {
//        mShimmerViewContainer.stopShimmerAnimation();
        if(response.responseCode==200){
            latestProductList.clear()
            latestProductList.add("Select")
            for(i in 0 until response.result!!.docs!!.size) {
                latestProductList.add(response.result!!.docs!!.get(i).categoryName.toString())
                CategoryModel(response.result!!.docs!!.get(i)._id.toString(),response.result!!.docs!!.get(i).categoryName.toString())
            }

            activity?.let {
                SpinnerAdapter().mySpinnerArray(
                    it,
                    productCategory_spinner,
                    latestProductList
                )
            }
//            val Product_category: ArrayAdapter<String> = ArrayAdapter<String>(
//                requireContext(), android.R.layout.simple_spinner_item,
//                latestProductList
//            )
//            Product_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            productCategory_spinner.setAdapter(Product_category)
//            setAdaptor(latestProductList)

        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
//        mShimmerViewContainer.stopShimmerAnimation();
    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
//        mShimmerViewContainer.stopShimmerAnimation();
    }



    fun subCategoryListApi(id: String) {
        if (androidextention.isOnline(mContext)) {
            val serviceManager = ServiceManager(mContext)
            val callBack: ApiCallBack<SubCategoryResponse> =
                ApiCallBack<SubCategoryResponse>(object : ApiResponseListener<SubCategoryResponse>{
                    override fun onApiSuccess(response: SubCategoryResponse, apiName: String?) {
                    var subCategoryList = ArrayList<String>()
                        for (i in 0 until response.result?.subCategory?.size!!){
                            subCategoryList.add(response.result?.subCategory.get(i).subCategoryName!!)
                            subCategoryListModal.add((com.exobe.ModelClass.CategoryModel(response.result?.subCategory.get(i)._id!!, response.result?.subCategory.get(i).subCategoryName!!)))

                            activity?.let {
                                SpinnerAdapter().mySpinnerArray(
                                    it,
                                    Sub_Category_spinner,
                                    subCategoryList
                                )
                            }
                        }
                    }

                    override fun onApiErrorBody(response: String, apiName: String?) {
                    }

                    override fun onApiFailure(failureMessage: String?, apiName: String?) {

                    }

                }, "SubCategoryListApi", mContext)
            try {
                serviceManager.listSubCategoryApi(callBack, id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }


//    fun addProductApi() {
//        if (androidextention.isOnline(mContext)) {
//            val serviceManager = ServiceManager(mContext)
//            val callBack: ApiCallBack<CategoryList_response> =
//                ApiCallBack<CategoryList_response>(object : ApiResponseListener<> {
//
//                }, "AddProductApi", mContext)
//            try {
//                serviceManager.listCategoryApi(callBack)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        } else {
//
//            diasplay_toast("Please check your internet connection!")
//        }
//    }
    fun createMultiImageLinkAPi() {

    }
}