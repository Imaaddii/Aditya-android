package com.exobe.Activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.exobe.Activity.ViewServiceListActivity
import com.exobe.Fragments.*
import com.exobe.Fragments.servicesfrag.payment_description_sp
import com.exobe.ModelClass.response_modal_class
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.exobe.androidextention
import com.exobe.bottomsheet.CustomerBottomSheet
import com.exobe.customClicks.SetTitles
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Response.login_response
import com.exobe.entity.Service_Base.ApiResponseListener
import com.exobe.entity.Service_Base.ServiceManager
import com.exobe.extension.diasplay_toast
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity(), SetTitles ,ApiResponseListener<login_response>{

    lateinit var home_grey_LL: LinearLayout
    lateinit var service_grey_LL: LinearLayout
    lateinit var Category_grey_LL: LinearLayout
    lateinit var Wishlist_grey_LL: LinearLayout
    lateinit var home_grey_IV: ImageView
    lateinit var home_IV: ImageView
    lateinit var service_grey_IV: ImageView
    lateinit var Category_grey_IV: ImageView
    lateinit var Wishlist_grey_IV: ImageView

    lateinit var service_red_IV: ImageView
    lateinit var Category_red_IV: ImageView
    lateinit var Wishlist_redIV: ImageView
    lateinit var home_red_IV: ImageView
    lateinit var MenuClick: ImageView


    lateinit var greyBell_IV: ImageView

    lateinit var Home_RL: RelativeLayout
    lateinit var Logout_RL: RelativeLayout
    lateinit var Login_RL: RelativeLayout
    lateinit var MainTitle_TV: TextView
    lateinit var Deals_IV: ImageView
    lateinit var Product_IV: ImageView
    lateinit var greySetting_IV: ImageView
    lateinit var Setting_LL: LinearLayout
    lateinit var red_setting_IV: ImageView
    lateinit var menu: LinearLayout
    lateinit var Customer_LL: LinearLayout
    lateinit var Retailer_LL: LinearLayout
    lateinit var Serviseprovider_LL: LinearLayout
    lateinit var ll_deals_retailers: LinearLayout
    lateinit var rightarrowretailer: ImageView
    lateinit var downarrowretailer: ImageView


    lateinit var cart: ImageView
    lateinit var filter: ImageView

    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var mContext: Context

    lateinit var drawerlayout: DrawerLayout
    var flag = ""
    lateinit var email:String
    //====================customer=========================================
    lateinit var MyCart_RL_Customer: RelativeLayout
    lateinit var MyDeal_RL_Customer: RelativeLayout
    lateinit var Requestedservices_RL_Customer: RelativeLayout
    lateinit var ProductEnquiry_RL_Customer: RelativeLayout
    lateinit var Setting_RL_Customer: RelativeLayout

    //===========================Retailer========================================
//    lateinit var MyProduct_Retailer_RL: RelativeLayout
    lateinit var MyCart_Retailer_RL: RelativeLayout

    //    lateinit var RequestedProducts_Retailer_RL: RelativeLayout
    lateinit var MyDeals_Retailer_RL: RelativeLayout
    lateinit var PaymentHistory_Retailer_RL: RelativeLayout


    //    lateinit var RequestedServices_Retailer_RL: RelativeLayout
    lateinit var Settings_Retailer_RL: RelativeLayout

//===========================Service Provider================================

    lateinit var ServicesRequest_serviceprovider: RelativeLayout
    lateinit var Mydeals_RL_ServiceProvider: RelativeLayout
    lateinit var Paymenthistory_RL_ServiceProvider: RelativeLayout
    lateinit var Myorderhistory_RL_ServiceProvider: RelativeLayout
    lateinit var ProductEnquiry_RL_ServiceProvider: RelativeLayout
    lateinit var Requestedservices_RL_ServiceProvider: RelativeLayout
    lateinit var mainHeader: RelativeLayout
    lateinit var back: ImageView

    lateinit var textViewHome: TextView
    lateinit var textViewServices: TextView
    lateinit var textViewCategory: TextView
    lateinit var textViewWishlist: TextView
    lateinit var textViewSetting: TextView
    lateinit var textViewOrder: TextView
    lateinit var textViewProduct: TextView


    lateinit var ll_category_tab: LinearLayout
    lateinit var ll_service_tab: LinearLayout
    lateinit var ll_order_tab: LinearLayout
    lateinit var ll_product_tab: LinearLayout

    lateinit var order_red: ImageView
    lateinit var product_red: ImageView
    lateinit var ll_deals: LinearLayout
    lateinit var rightarrow: ImageView
    lateinit var downarrow: ImageView
    lateinit var Deals_Retailer_RelativeLayout: RelativeLayout
    lateinit var orders_RelativeLayout: RelativeLayout


    lateinit var dealsfromcustomer: LinearLayout
    lateinit var dealsfromwholesalers: LinearLayout

    lateinit var onproducts: LinearLayout
    lateinit var onservices: LinearLayout
    lateinit var PaymentHistory_Retailer_RelativeLayout: RelativeLayout
    lateinit var ll_paymenthistory: LinearLayout
    lateinit var downarrowretailer1: ImageView
    lateinit var rightarrowretailer1: ImageView
    lateinit var paymentfromcustomer: LinearLayout
    lateinit var paymenttowholesalers: LinearLayout


    var doubleBackToExitPressedOnce = false
    var Home = false
    var clickflag = false
    var dealflag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        mContext = this?.applicationContext!!

//        Dashboard_image = findViewById(R.id.Dashboard_icon)

        order_red = findViewById(R.id.order_red)
        product_red = findViewById(R.id.product_red)

        ll_category_tab = findViewById(R.id.ll_category_tab)
        ll_service_tab = findViewById(R.id.ll_service_tab)
        ll_order_tab = findViewById(R.id.ll_order_tab)
        ll_product_tab = findViewById(R.id.ll_product_tab)


        textViewHome = findViewById(R.id.TVhome)
        textViewServices = findViewById(R.id.TVservices)
        textViewCategory = findViewById(R.id.TVcategory)
        textViewWishlist = findViewById(R.id.TVwishlist)
        textViewSetting = findViewById(R.id.TVsettings)
        textViewOrder = findViewById(R.id.TVorder)
        textViewProduct = findViewById(R.id.TVproduct)


        drawerlayout = findViewById(R.id.drawer_layout)
        home_red_IV = findViewById(R.id.home)
        service_red_IV = findViewById(R.id.service_red)
        Category_red_IV = findViewById(R.id.Category_red)
        Wishlist_redIV = findViewById(R.id.Wishlist_red)


        home_grey_LL = findViewById(R.id.home_grey)
        service_grey_LL = findViewById(R.id.service_grey)
        Category_grey_LL = findViewById(R.id.Category_grey)
        Wishlist_grey_LL = findViewById(R.id.Wishlist_grey)
        greyBell_IV = findViewById(R.id.greyBell_ImageView)

        home_grey_IV = findViewById(R.id.home_grey_ImageView)
        home_IV = findViewById(R.id.home)
        service_grey_IV = findViewById(R.id.service_grey_ImageView)
        Category_grey_IV = findViewById(R.id.Category_grey_ImageView)
        Wishlist_grey_IV = findViewById(R.id.Wishlist_grey_ImageView)
        MenuClick = findViewById(R.id.MenuClick)

        Home_RL = findViewById(R.id.Home_RelativeLayout)
        Logout_RL = findViewById(R.id.Logout_RelativeLayout)
        Login_RL = findViewById(R.id.Login_RelativeLayout)
//        Header_RL = findViewById(R.id.Header)
        MainTitle_TV = findViewById(R.id.PreLoginTitle_TextView2)
        Deals_IV = findViewById(R.id.Deals_ImageView)
        Product_IV = findViewById(R.id.Product_ImageView)
        greySetting_IV = findViewById(R.id.greySetting_ImageView)
        Setting_LL = findViewById(R.id.Setting_LinearLayout)
        red_setting_IV = findViewById(R.id.red_setting_ImageView)
        menu = findViewById(R.id.Dashboard_menu)
        Customer_LL = findViewById(R.id.Customer_LL)
        Retailer_LL = findViewById(R.id.Retailer_LL)
        Serviseprovider_LL = findViewById(R.id.Serviseprovider_LL)

        //================customer===========================
        MyCart_RL_Customer = findViewById(R.id.MyCart_Customer)
        MyDeal_RL_Customer = findViewById(R.id.MyDeals_Customer)
        Requestedservices_RL_Customer = findViewById(R.id.RequestedServices_Customer)
        ProductEnquiry_RL_Customer = findViewById(R.id.ProductInquiry_Customer)
        Setting_RL_Customer = findViewById(R.id.Settings_Customer)

        //================Reatailer===========================
        MyCart_Retailer_RL = findViewById(R.id.MyCart_Retailer_RelativeLayout)
        PaymentHistory_Retailer_RL = findViewById(R.id.PaymentHistory_Retailer_RelativeLayout)
        Settings_Retailer_RL = findViewById(R.id.Settings_Retailer_RelativeLayout)

        //================Service Provider ====================================


        Mydeals_RL_ServiceProvider = findViewById(R.id.MyDeals_serviseprovider)
        Paymenthistory_RL_ServiceProvider = findViewById(R.id.PaymentHistory_serviseprovider)

        Requestedservices_RL_ServiceProvider = findViewById(R.id.RequestedServices_serviseprovider)
        ll_deals = findViewById(R.id.ll_dealscustomer)
        downarrow = findViewById(R.id.downarrow)
        rightarrow = findViewById(R.id.rightarrow)


        ll_deals_retailers = findViewById(R.id.ll_deals_retailers)
        rightarrowretailer = findViewById(R.id.rightarrowretailer)
        downarrowretailer = findViewById(R.id.downarrowretailer)
        Deals_Retailer_RelativeLayout = findViewById(R.id.Deals_Retailer_RelativeLayout)


        //
        dealsfromcustomer = findViewById(R.id.dealsfromcustomer)
        dealsfromwholesalers = findViewById(R.id.dealsfromwholesalers)
        onproducts = findViewById(R.id.onproducts)
        onservices = findViewById(R.id.onservices)
        PaymentHistory_Retailer_RelativeLayout =
            findViewById(R.id.PaymentHistory_Retailer_RelativeLayout)
        ll_paymenthistory = findViewById(R.id.ll_paymenthistory)
        downarrowretailer1 = findViewById(R.id.downarrowretailer1)
        rightarrowretailer1 = findViewById(R.id.rightarrowretailer1)
        orders_RelativeLayout = findViewById(R.id.orders_RelativeLayout)
        paymentfromcustomer = findViewById(R.id.paymentfromcustomer)
        paymenttowholesalers = findViewById(R.id.paymenttowholesalers)

        cart = findViewById(R.id.cart_icon)!!
        filter = findViewById(R.id.filter_icon)!!
        back = findViewById(R.id.imageView_back)!!
        DealsImageView = findViewById(R.id.Deals_ImageView)!!
        greyBellImageView = findViewById(R.id.greyBell_ImageView)!!
        mainHeader = findViewById(R.id.RelativeLayout)!!
        MenuClick.visibility = View.VISIBLE
        DealsImageView.visibility = View.VISIBLE
        greyBellImageView.visibility = View.VISIBLE
        cart.visibility = View.GONE
        filter.visibility = View.GONE
        back.visibility = View.GONE
        drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        iflogin()


        if (intent != null) {
            try {
                flag = intent.getStringExtra("flag").toString()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        supportFragmentManager.beginTransaction().replace(
            R.id.FrameLayout,
            RetailerHomepage(this, flag)
        ).commit()
        textViewHome.setTextColor(Color.parseColor("#BF1E2E"))
        MainTitle_TV.setText("Home")


        if (flag.equals("Customer")) {
            ll_category_tab.visibility = View.VISIBLE
            ll_service_tab.visibility = View.VISIBLE
            ll_order_tab.visibility = View.GONE
            ll_product_tab.visibility = View.GONE
            supportFragmentManager.beginTransaction().replace(
                R.id.FrameLayout,
                RetailerHomepage(this, flag)
            ).commit()
            Product_IV.visibility = View.GONE
            Customer_LL.visibility = View.VISIBLE
            OnClick_Customer()
        } else if (flag.equals("Retailer")) {
            ll_category_tab.visibility = View.GONE
            ll_service_tab.visibility = View.GONE
            ll_order_tab.visibility = View.VISIBLE
            ll_product_tab.visibility = View.VISIBLE
            OnClick_Retailer()
            Retailer_LL.visibility = View.VISIBLE

        } else if (flag.equals("Service_Provider")) {
            supportFragmentManager.beginTransaction().replace(
                R.id.FrameLayout,
                Service_homescreen()
            ).commit()
            Product_IV.visibility = View.GONE
            Serviseprovider_LL.visibility = View.VISIBLE

//            OnClick_Service_Provider()
        }

        MenuClick.setOnClickListener {
            drawerlayout.openDrawer(Gravity.LEFT)
        }


    }

    fun iflogin() {
        if (SavedPrefManager.getStringPreferences(this, SavedPrefManager.isLogin) == "false") {
            Logout_RL.visibility = View.GONE
            Login_RL.visibility = View.VISIBLE

        } else if (SavedPrefManager.getStringPreferences(
                this,
                SavedPrefManager.isLogin
            ) == "true"
        ) {
            Logout_RL.visibility = View.VISIBLE
            Login_RL.visibility = View.GONE
        }
    }


   fun user_type_login(flag: String) {


//        val dialog = BottomSheetDialog(this)
//        val view = layoutInflater.inflate(R.layout.login_bottom_sheet, null)
//        val metrics = DisplayMetrics()
//        windowManager?.defaultDisplay?.getMetrics(metrics)
//        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
//        dialog.behavior.peekHeight = metrics.heightPixels
//
//        var passwordNotVisible = 0
//
//        var customer = view.findViewById<LinearLayout>(R.id.Customer_login)
//        var retailer = view.findViewById<LinearLayout>(R.id.Retailer_login)
//        var register = view.findViewById<LinearLayout>(R.id.Register)
//        var forgotPassword = view.findViewById<TextView>(R.id.ForgotPassword)
//        var PasswordEditText = view.findViewById<EditText>(R.id.PasswordEditText)
//        var LogINClick = view.findViewById<Button>(R.id.LogINClick)
//        var cross_eye = view.findViewById<ImageView>(R.id.cross_eye_bottomsheet)
//        var cross = view.findViewById<LinearLayout>(R.id.cross)
//
//
////        CustomerIDs
//
//        var PhoneLinear = view.findViewById<LinearLayout>(R.id.PhoneLinear)
//        var PaswordLL = view.findViewById<LinearLayout>(R.id.PaswordLL)
//        var emailEditText = view.findViewById<EditText>(R.id.PhoneEditText)
//        var TV = view.findViewById<TextView>(R.id.TV)
//        var TVPassword = view.findViewById<TextView>(R.id.TVPassword)
//
//        cross.setOnClickListener {
//            dialog.dismiss()
//        }
//
//
//        cross_eye.setOnClickListener {
//            if (passwordNotVisible == 0) {
//                PasswordEditText.transformationMethod =
//                    HideReturnsTransformationMethod.getInstance()
//                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
//                PasswordEditText.setSelection(PasswordEditText.length())
//                passwordNotVisible = 1
//
//            } else if (passwordNotVisible == 1) {
//                PasswordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
//                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash_solid))
//                PasswordEditText.setSelection(PasswordEditText.length())
//                passwordNotVisible = 0
//            } else {
//                PasswordEditText.transformationMethod =
//                    HideReturnsTransformationMethod.getInstance()
//                cross_eye.setImageDrawable(resources.getDrawable(R.drawable.eye))
//                PasswordEditText.setSelection(PasswordEditText.length())
//                passwordNotVisible = 1
//            }
//        }
//
//
//        if (flag.equals("Customer")) {
//            customer.visibility = View.VISIBLE
//            retailer.visibility = View.GONE
//
//            LogINClick.setOnClickListener {
//                FormValidation.CustomerLogin(
//
//                    PasswordEditText,
//                    TVPassword,
//                    emailEditText,
//                    TV, PhoneLinear, PaswordLL
//                )
//                if (TVPassword.text.equals("") && TV.text.equals("")
//                ) {
//
//                    email=emailEditText.text.toString()
//                    var password=PasswordEditText.text.toString()
//                    LoginCustomerAPI(email,password)
//                }
//            }
//
//        } else if (flag.equals("Retailer")) {
//            customer.visibility = View.GONE
//            retailer.visibility = View.VISIBLE
//
//
//            LogINClick.setOnClickListener {
//                FormValidation.CustomerLogin(
//
//                    PasswordEditText,
//                    TVPassword,
//                    emailEditText,
//                    TV, PhoneLinear, PaswordLL
//                )
//                if (TVPassword.text.equals("") && TV.text.equals("")
//                ) {
//                    dialog.dismiss()
//                    val intent = Intent(this, MainActivity::class.java)
//                    SavedPrefManager.saveStringPreferences(this, SavedPrefManager.isLogin, "true")
//                    intent.putExtra("flag", "Retailer")
//                    startActivity(intent)
//
//                }
//            }
//
//        } else if (flag.equals("Service_Provider")) {
//            customer.visibility = View.GONE
//            retailer.visibility = View.GONE
//
//            LogINClick.setOnClickListener {
//                dialog.dismiss()
//                SavedPrefManager.saveStringPreferences(this, SavedPrefManager.isLogin, "true")
//            }
//        }
//        register.setOnClickListener {
//            if (flag.equals("Customer")) {
//                startActivity(Intent(this, RegisterActivity::class.java))
//
//            } else if (flag.equals("Retailer")) {
//                startActivity(Intent(this, Register_retailer::class.java))
//            }
//        }
//        forgotPassword.setOnClickListener {
//            startActivity(Intent(this, ForgotPassword::class.java))
//        }
//
//        dialog.setCancelable(true)
//
//        dialog.setContentView(view)
//
//        dialog.show()
    }

    private fun getWindowHeight(): Int {
        // Calculate window height for fullscreen use
        val displayMetrics = DisplayMetrics()
        (getContext() as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    fun OnClick_Customer() {

        MyCart_RL_Customer.setOnClickListener {

            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, MyCartActivity("SideMenu"), "addCart")
                ?.addToBackStack(null)
                ?.commit()
            drawerlayout.closeDrawer(Gravity.LEFT)

            ll_deals.visibility = View.GONE
            rightarrow.visibility = View.VISIBLE
            downarrow.visibility = View.GONE
        }
        MyDeal_RL_Customer.setOnClickListener {

            if (clickflag == false) {
                clickflag = true
                ll_deals.visibility = View.VISIBLE
                rightarrow.visibility = View.GONE
                downarrow.visibility = View.VISIBLE
            } else {
                clickflag = false
                ll_deals.visibility = View.GONE
                rightarrow.visibility = View.VISIBLE
                downarrow.visibility = View.GONE
            }

//            drawerlayout.closeDrawer(Gravity.LEFT)
//
//                supportFragmentManager?.beginTransaction()
//                    ?.replace(R.id.FrameLayout, Customers_Deals("Customer"), "customerDeals")?.addToBackStack(null)?.commit()

        }

        onproducts.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)

            supportFragmentManager?.beginTransaction()
                ?.replace(
                    R.id.FrameLayout, Customers_Deals(
                        "SideMenu",
                        "",
                        "",
                        "Deals on products",
                        "Deals to customer"
                    ), "CustomersDeals"
                )
                ?.addToBackStack(null)
                ?.commit()
            ll_deals.visibility = View.GONE
            rightarrow.visibility = View.VISIBLE
            downarrow.visibility = View.GONE


        }

        onservices.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)

            supportFragmentManager?.beginTransaction()
                ?.replace(
                    R.id.FrameLayout,
                    Customers_Deals(
                        "SideMenu",
                        "onService",
                        "",
                        "Deals on services",
                        "Deals to customer"
                    ),
                    "CustomersDeals"
                )
                ?.addToBackStack(null)
                ?.commit()
            ll_deals.visibility = View.GONE
            rightarrow.visibility = View.VISIBLE
            downarrow.visibility = View.GONE
        }



        Requestedservices_RL_Customer.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)

            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, ViewServiceListActivity("SideMenu"), "viewService")
                ?.addToBackStack(null)?.commit()
            ll_deals.visibility = View.GONE
            rightarrow.visibility = View.VISIBLE
            downarrow.visibility = View.GONE

        }

        ProductEnquiry_RL_Customer.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)


            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, ProductEnquiry("SideMenu"), "ProductEnquiry")
                ?.addToBackStack(null)
                ?.commit()
        }
        Setting_RL_Customer.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)

            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, SettingsFragment(), "settings")?.addToBackStack(null)
                ?.commit()
            drawerlayout.closeDrawer(Gravity.LEFT)

            MainTitle_TV.setText("Settings")

            greySetting_IV.visibility = View.GONE
            red_setting_IV.visibility = View.VISIBLE

            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE

        }
        Login_RL.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)

            CustomerBottomSheet("Customer", this).show(
                supportFragmentManager,
                "ModalBottomSheet")
//            user_type_login()

        }

//////// ICON ///////////////

        greyBell_IV.setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, Notification(), "notification")
                ?.addToBackStack(null)
                ?.commit()
        }

        Deals_IV.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)

            supportFragmentManager?.beginTransaction()
                ?.replace(
                    R.id.FrameLayout, Customers_Deals(
                        "Customer",
                        "",
                        "",
                        "Deals on products",
                        "Deals to customer"
                    ), "customerDeals"
                )
                ?.addToBackStack(null)?.commit()
        }


//////////BOTTOM ICON//////////////////////

        home_grey_LL.setOnClickListener {
            textViewHome.setTextColor(Color.parseColor("#BF1E2E"))
            textViewSetting.setTextColor(Color.parseColor("#AAAAAA"))
            textViewWishlist.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#AAAAAA"))
            textViewServices.setTextColor(Color.parseColor("#AAAAAA"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, RetailerHomepage(this, flag), "home")
                ?.addToBackStack(null)?.commit()
            MainTitle_TV.setText("Home")

            home_grey_IV.visibility = View.GONE
            home_red_IV.visibility = View.VISIBLE


            Category_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE

            MenuClick.visibility = View.VISIBLE
            Deals_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE

        }
        ll_service_tab.setOnClickListener {

            textViewHome.setTextColor(Color.parseColor("#AAAAAA"))
            textViewSetting.setTextColor(Color.parseColor("#AAAAAA"))
            textViewWishlist.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#AAAAAA"))
            textViewServices.setTextColor(Color.parseColor("#BF1E2E"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))
            supportFragmentManager.beginTransaction().replace(
                R.id.FrameLayout, ServiceAvailable(
                    this
                ), "serviceAvailable"
            )?.addToBackStack(null)?.commit()
            MainTitle_TV.setText("Services")

            service_grey_IV.visibility = View.GONE
            service_red_IV.visibility = View.VISIBLE

            MenuClick.visibility = View.GONE
            Deals_IV.visibility = View.GONE
            greyBell_IV.visibility = View.GONE
            home_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE
            home_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE

        }
        ll_category_tab.setOnClickListener {
            textViewHome.setTextColor(Color.parseColor("#AAAAAA"))
            textViewSetting.setTextColor(Color.parseColor("#AAAAAA"))
            textViewWishlist.setTextColor(Color.parseColor("#AAAAAA"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))
            textViewServices.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#BF1E2E"))

            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, Category(this), "category")?.addToBackStack(null)
                ?.commit()
            MainTitle_TV.setText("Category")

            Category_grey_IV.visibility = View.GONE
            Category_red_IV.visibility = View.VISIBLE

            MenuClick.visibility = View.GONE
            greyBell_IV.visibility = View.GONE
            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE

        }
        Wishlist_grey_LL.setOnClickListener {
            textViewHome.setTextColor(Color.parseColor("#AAAAAA"))
            textViewSetting.setTextColor(Color.parseColor("#AAAAAA"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))
            textViewServices.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#AAAAAA"))
            textViewWishlist.setTextColor(Color.parseColor("#BF1E2E"))

            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, Wishlist("wishlist"), "wishlist")?.addToBackStack(null)
                ?.commit()
            MainTitle_TV.setText("Wishlist")

            Wishlist_grey_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.VISIBLE

            MenuClick.visibility = View.GONE
            Deals_IV.visibility = View.GONE
            greyBell_IV.visibility = View.GONE
            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE
            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE

        }
        Setting_LL.setOnClickListener {
            textViewHome.setTextColor(Color.parseColor("#AAAAAA"))
            textViewSetting.setTextColor(Color.parseColor("#BF1E2E"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))
            textViewServices.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#AAAAAA"))
            textViewWishlist.setTextColor(Color.parseColor("#AAAAAA"))
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, SettingsFragment(), "settings")?.addToBackStack(null)
                ?.commit()

            MainTitle_TV.setText("Settings")


            greySetting_IV.visibility = View.GONE
            red_setting_IV.visibility = View.VISIBLE

            MenuClick.visibility = View.GONE
            Deals_IV.visibility = View.GONE
            greyBell_IV.visibility = View.GONE
            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE

        }
        Home_RL.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, RetailerHomepage(this, flag), "home")
                ?.addToBackStack(null)?.commit()
            drawerlayout.closeDrawer(Gravity.LEFT)
            MainTitle_TV.setText("Home")
            ll_deals.visibility = View.GONE
            rightarrow.visibility = View.VISIBLE
            downarrow.visibility = View.GONE
        }
        Logout_RL.setOnClickListener {
            androidextention.logOutDialog(this)
            drawerlayout.closeDrawer(Gravity.LEFT)
            ll_deals.visibility = View.GONE
            rightarrow.visibility = View.VISIBLE
            downarrow.visibility = View.GONE
        }

    }


    fun OnClick_Retailer() {

        MyCart_Retailer_RL.setOnClickListener {
            if (SavedPrefManager.getStringPreferences(this, SavedPrefManager.isLogin) == "false") {
                user_type_login("Retailer")

            } else if (SavedPrefManager.getStringPreferences(
                    this,
                    SavedPrefManager.isLogin
                ) == "true"
            ) {
                supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.FrameLayout, MyCartActivity("SideMenu"), "addCart")
                    ?.addToBackStack(null)
                    ?.commit()
                drawerlayout.closeDrawer(Gravity.LEFT)

                ll_paymenthistory.visibility = View.GONE
                rightarrowretailer1.visibility = View.VISIBLE
                downarrowretailer1.visibility = View.GONE
                ll_deals_retailers.visibility = View.GONE
                rightarrowretailer.visibility = View.VISIBLE
                downarrowretailer.visibility = View.GONE

            }


        }



        PaymentHistory_Retailer_RL.setOnClickListener {

            if (SavedPrefManager.getStringPreferences(this, SavedPrefManager.isLogin) == "false") {
                user_type_login("Retailer")

            } else if (SavedPrefManager.getStringPreferences(
                    this,
                    SavedPrefManager.isLogin
                ) == "true"
            ) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.FrameLayout, PaymentDescription("SideMenu"), "payment")
                    ?.addToBackStack(null)
                    ?.commit()
                drawerlayout.closeDrawer(Gravity.LEFT)
                ll_paymenthistory.visibility = View.GONE
                rightarrowretailer1.visibility = View.VISIBLE
                downarrowretailer1.visibility = View.GONE
                ll_deals_retailers.visibility = View.GONE
                rightarrowretailer.visibility = View.VISIBLE
                downarrowretailer.visibility = View.GONE
            }
        }


        Settings_Retailer_RL.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, SettingsFragment(), "settings")?.addToBackStack(null)
                ?.commit()

            drawerlayout.closeDrawer(Gravity.LEFT)
            textViewHome.setTextColor(Color.parseColor("#AAAAAA"))
            textViewSetting.setTextColor(Color.parseColor("#BF1E2E"))
            textViewWishlist.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#AAAAAA"))
            textViewServices.setTextColor(Color.parseColor("#AAAAAA"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))

            MainTitle_TV.setText("Settings")
            greySetting_IV.visibility = View.GONE
            red_setting_IV.visibility = View.VISIBLE

            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE
            ll_paymenthistory.visibility = View.GONE
            rightarrowretailer1.visibility = View.VISIBLE
            downarrowretailer1.visibility = View.GONE
            ll_deals_retailers.visibility = View.GONE
            rightarrowretailer.visibility = View.VISIBLE
            downarrowretailer.visibility = View.GONE
        }

        Login_RL.setOnClickListener {
            user_type_login("Retailer")

        }

        greyBell_IV.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, Notification(), "notification")
                ?.addToBackStack(null)
                ?.commit()
            drawerlayout.closeDrawer(Gravity.LEFT)
            ll_paymenthistory.visibility = View.GONE
            rightarrowretailer1.visibility = View.VISIBLE
            downarrowretailer1.visibility = View.GONE

        }

        Deals_IV.setOnClickListener {
            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, Services_DealsScreen("SideMenu"), "serviceDeals")
                ?.addToBackStack(null)?.commit()
            drawerlayout.closeDrawer(Gravity.LEFT)
            ll_paymenthistory.visibility = View.GONE
            rightarrowretailer1.visibility = View.VISIBLE
            downarrowretailer1.visibility = View.GONE
            ll_deals_retailers.visibility = View.GONE
            rightarrowretailer.visibility = View.VISIBLE
            downarrowretailer.visibility = View.GONE
        }


        Product_IV.setOnClickListener {

            Category_red_IV.visibility = View.GONE
            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE

            home_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE



            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, My_Products())
                .commit()



            MainTitle_TV.setText("Products")


        }

//////////BOTTOM ICON//////////////////////


        home_grey_LL.setOnClickListener {

            textViewHome.setTextColor(Color.parseColor("#BF1E2E"))
            textViewSetting.setTextColor(Color.parseColor("#AAAAAA"))
            textViewWishlist.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#AAAAAA"))
            textViewServices.setTextColor(Color.parseColor("#AAAAAA"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, RetailerHomepage(this, flag), "home")
                ?.addToBackStack(null)?.commit()
            MainTitle_TV.setText("Home")

            home_grey_IV.visibility = View.GONE
            home_red_IV.visibility = View.VISIBLE

            Category_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE

            order_red.visibility = View.GONE
            product_red.visibility = View.GONE
//            redBell_IV.visibility = View.GONE

            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE


        }

        ll_order_tab.setOnClickListener {
            textViewHome.setTextColor(Color.parseColor("#AAAAAA"))
            textViewOrder.setTextColor(Color.parseColor("#BF1E2E"))
            textViewSetting.setTextColor(Color.parseColor("#AAAAAA"))
            textViewWishlist.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))
            textViewServices.setTextColor(Color.parseColor("#AAAAAA"))

            supportFragmentManager.beginTransaction().replace(
                R.id.FrameLayout, OrderManagement(), "ordermanagement"
            )?.addToBackStack(null)?.commit()
            order_red.visibility = View.VISIBLE
            product_red.visibility = View.GONE

            service_grey_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE

            home_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE
//            redBell_IV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE


        }

        ll_product_tab.setOnClickListener {
            textViewHome.setTextColor(Color.parseColor("#AAAAAA"))
            textViewSetting.setTextColor(Color.parseColor("#AAAAAA"))
            textViewWishlist.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#AAAAAA"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#BF1E2E"))
            textViewServices.setTextColor(Color.parseColor("#AAAAAA"))

            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, ProductManagement(), "productmanagement")
                ?.addToBackStack(null)?.commit()

            order_red.visibility = View.GONE
            product_red.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE

            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE
//            redBell_IV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE


        }

        Wishlist_grey_LL.setOnClickListener {

            textViewHome.setTextColor(Color.parseColor("#AAAAAA"))
            textViewSetting.setTextColor(Color.parseColor("#AAAAAA"))
            textViewWishlist.setTextColor(Color.parseColor("#BF1E2E"))
            textViewCategory.setTextColor(Color.parseColor("#AAAAAA"))
            textViewServices.setTextColor(Color.parseColor("#AAAAAA"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))

            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, Wishlist("wishlist"), "wishlist")?.addToBackStack(null)
                ?.commit()
            Wishlist_grey_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.VISIBLE
            order_red.visibility = View.GONE
            product_red.visibility = View.GONE
            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE


        }
        Setting_LL.setOnClickListener {
            textViewHome.setTextColor(Color.parseColor("#AAAAAA"))
            textViewSetting.setTextColor(Color.parseColor("#BF1E2E"))
            textViewWishlist.setTextColor(Color.parseColor("#AAAAAA"))
            textViewCategory.setTextColor(Color.parseColor("#AAAAAA"))
            textViewServices.setTextColor(Color.parseColor("#AAAAAA"))
            textViewOrder.setTextColor(Color.parseColor("#AAAAAA"))
            textViewProduct.setTextColor(Color.parseColor("#AAAAAA"))

            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, SettingsFragment(), "settings")?.addToBackStack(null)
                ?.commit()


            order_red.visibility = View.GONE
            product_red.visibility = View.GONE
            greySetting_IV.visibility = View.GONE
            red_setting_IV.visibility = View.VISIBLE

            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE

        }

        red_setting_IV.setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, SettingsFragment(), "settings")?.addToBackStack(null)
                ?.commit()


            greySetting_IV.visibility = View.VISIBLE
            red_setting_IV.visibility = View.GONE

            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE

        }
//        Profile_grey_LL.setOnClickListener {
//
//            if (SavedPrefManager.getStringPreferences(
//                    this,
//                    SavedPrefManager.isLogin
//                ) == "false"
//            ) {
//                user_type_login(flag)
//
//            } else if (SavedPrefManager.getStringPreferences(
//                    this,
//                    SavedPrefManager.isLogin
//                ) == "true"
//            ) {
//                val intent = Intent(this, MyProfileActivity::class.java)
//                startActivity(intent)
//
//            }
//
//            Profile_grey_IV.visibility = View.GONE
//            Profile_red_IV.visibility = View.VISIBLE
//
//            home_red_IV.visibility = View.GONE
//            service_red_IV.visibility = View.GONE
//            Category_red_IV.visibility = View.GONE
//            Wishlist_redIV.visibility = View.GONE
////            redBell_IV.visibility = View.GONE
//
//            home_grey_IV.visibility = View.VISIBLE
//            service_grey_IV.visibility = View.VISIBLE
//            Category_grey_IV.visibility = View.VISIBLE
//            Wishlist_grey_IV.visibility = View.VISIBLE
//            greyBell_IV.visibility = View.VISIBLE
//
//        }


//        LL_Limits.visibility = View.GONE
//        isOnDashboard = true


        Home_RL.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, RetailerHomepage(this, flag), "home")
                ?.addToBackStack(null)?.commit()
            drawerlayout.closeDrawer(Gravity.LEFT)
            MainTitle_TV.setText("Home")
            ll_paymenthistory.visibility = View.GONE
            rightarrowretailer1.visibility = View.VISIBLE
            downarrowretailer1.visibility = View.GONE
            ll_deals_retailers.visibility = View.GONE
            rightarrowretailer.visibility = View.VISIBLE
            downarrowretailer.visibility = View.GONE

//            PreLoginTitle_TV.visibility = View.VISIBLE
//            Header_RL.visibility = View.GONE

        }

        Logout_RL.setOnClickListener {
            SavedPrefManager.saveStringPreferences(this, SavedPrefManager.isLogin, "false")
            androidextention.logOutDialog(this)
//            val intent = Intent(this, Services::class.java)
//            startActivity(intent)
            drawerlayout.closeDrawer(Gravity.LEFT)
            ll_paymenthistory.visibility = View.GONE
            rightarrowretailer1.visibility = View.VISIBLE
            downarrowretailer1.visibility = View.GONE
        }

        Deals_Retailer_RelativeLayout.setOnClickListener {
            if (clickflag == false) {
                clickflag = true
                dealflag = false
                ll_deals_retailers.visibility = View.VISIBLE
                rightarrowretailer.visibility = View.GONE
                downarrowretailer.visibility = View.VISIBLE
                ll_paymenthistory.visibility = View.GONE
                rightarrowretailer1.visibility = View.VISIBLE
                downarrowretailer1.visibility = View.GONE
            } else {
                clickflag = false
                dealflag = true
                ll_deals_retailers.visibility = View.GONE
                rightarrowretailer.visibility = View.VISIBLE
                downarrowretailer.visibility = View.GONE

            }


        }

        PaymentHistory_Retailer_RelativeLayout.setOnClickListener {

            if (dealflag == false) {
                dealflag = true
                clickflag = false
                ll_paymenthistory.visibility = View.VISIBLE
                downarrowretailer1.visibility = View.VISIBLE
                rightarrowretailer1.visibility = View.GONE
                ll_deals_retailers.visibility = View.GONE
                rightarrowretailer.visibility = View.VISIBLE
                downarrowretailer.visibility = View.GONE

            } else {
                clickflag = true
                dealflag = false
                ll_paymenthistory.visibility = View.GONE
                rightarrowretailer1.visibility = View.VISIBLE
                downarrowretailer1.visibility = View.GONE

            }


        }
        dealsfromcustomer.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)
            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, DealsManagement("SideMenu"), "serviceDeals")
                ?.addToBackStack(null)?.commit()
            ll_paymenthistory.visibility = View.GONE
            rightarrowretailer1.visibility = View.VISIBLE
            downarrowretailer1.visibility = View.GONE
            ll_deals_retailers.visibility = View.GONE
            rightarrowretailer.visibility = View.VISIBLE
            downarrowretailer.visibility = View.GONE
        }

        dealsfromwholesalers.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)
            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, Services_DealsScreen("SideMenu"), "serviceDeals")
                ?.addToBackStack(null)?.commit()
            ll_paymenthistory.visibility = View.GONE
            rightarrowretailer1.visibility = View.VISIBLE
            downarrowretailer1.visibility = View.GONE
            ll_deals_retailers.visibility = View.GONE
            rightarrowretailer.visibility = View.VISIBLE
            downarrowretailer.visibility = View.GONE
        }
        orders_RelativeLayout.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)
            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, OrderHistory("SideMenu"), "serviceDeals")
                ?.addToBackStack(null)?.commit()
            ll_paymenthistory.visibility = View.GONE
            rightarrowretailer1.visibility = View.VISIBLE
            downarrowretailer1.visibility = View.GONE
            ll_deals_retailers.visibility = View.GONE
            rightarrowretailer.visibility = View.VISIBLE
            downarrowretailer.visibility = View.GONE
        }

        paymentfromcustomer.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)

            val bundle = Bundle()
            bundle.putString("flagSide", "retailer")
            bundle.putString("paymentFlag", "PaymentFromCustomer")
            bundle.putString("title", "Payment From Customer")
            val fragobj = payment_description_sp()
            fragobj.setArguments(bundle)

            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, fragobj, "payment_description")
                ?.addToBackStack(null)?.commit()
            ll_paymenthistory.visibility = View.GONE
            rightarrowretailer1.visibility = View.VISIBLE
            downarrowretailer1.visibility = View.GONE
            ll_deals_retailers.visibility = View.GONE
            rightarrowretailer.visibility = View.VISIBLE
            downarrowretailer.visibility = View.GONE
        }

        paymenttowholesalers.setOnClickListener {

            drawerlayout.closeDrawer(Gravity.LEFT)


            val bundle = Bundle()
            bundle.putString("flagSide", "retailer")
            bundle.putString("paymentFlag", "PaymentFromWholesalers")
            bundle.putString("title", "Payment to Wholesalers")

            val fragobj = payment_description_sp()
            fragobj.setArguments(bundle)
            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, fragobj, "payment_description")
                ?.addToBackStack(null)?.commit()
            ll_paymenthistory.visibility = View.GONE
            rightarrowretailer1.visibility = View.VISIBLE
            downarrowretailer1.visibility = View.GONE
            ll_deals_retailers.visibility = View.GONE
            rightarrowretailer.visibility = View.VISIBLE
            downarrowretailer.visibility = View.GONE
        }

    }


    fun OnClick_Service_Provider() {


//            MyCart_RL_ServiceProvider.setOnClickListener {
//                if (SavedPrefManager.getStringPreferences(
//                        this,
//                        SavedPrefManager.isLogin
//                    ) == "false"
//                ) {
//                    user_type_login("Service_Provider")
//
//                } else if (SavedPrefManager.getStringPreferences(
//                        this,
//                        SavedPrefManager.isLogin
//                    ) == "true"
//                ) {
//                    supportFragmentManager?.beginTransaction()
//                        ?.replace(R.id.FrameLayout, MyCartActivity("SideMenu"))
//                        ?.commit()
//                }
//            }
        ServicesRequest_serviceprovider.setOnClickListener {

            startActivity(Intent(this, MyServiceRequest::class.java))
        }
        Mydeals_RL_ServiceProvider.setOnClickListener {
            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, Services_DealsScreen("SideMenu"), "serviceDeals")
                ?.addToBackStack(null)?.commit()
        }
        Paymenthistory_RL_ServiceProvider.setOnClickListener {
            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, Payment(), "payment")?.addToBackStack(null)
                ?.commit()

        }
        Myorderhistory_RL_ServiceProvider.setOnClickListener {
            if (SavedPrefManager.getStringPreferences(
                    this,
                    SavedPrefManager.isLogin
                ) == "false"
            ) {
                user_type_login("Service_Provider")

            } else if (SavedPrefManager.getStringPreferences(
                    this,
                    SavedPrefManager.isLogin
                ) == "true"
            ) {

                startActivity(Intent(this, OrderHistory::class.java))
            }
        }
        ProductEnquiry_RL_ServiceProvider.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, ProductEnquiry("SideMenu"), "ProductEnquiry")
                ?.addToBackStack(null)
                ?.commit()
        }
        Requestedservices_RL_ServiceProvider.setOnClickListener {
            startActivity(Intent(this, RequestedServiceList::class.java))
        }
//            Settings_RL_ServiceProvider.setOnClickListener {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.FrameLayout, SettingsFragment())
//                    .commit()
////            Header_RL.visibility = View.VISIBLE
//                drawerlayout.closeDrawer(Gravity.LEFT)
//
////            PreLoginTitle_TV.visibility = View.GONE
////            MainTitle_TV.setText("Settings")
//                greySetting_IV.visibility = View.GONE
//                red_setting_IV.visibility = View.VISIBLE
//
//                home_red_IV.visibility = View.GONE
//                service_red_IV.visibility = View.GONE
//                Category_red_IV.visibility = View.GONE
//                Wishlist_redIV.visibility = View.GONE
////            redBell_IV.visibility = View.GONE
//
//                home_grey_IV.visibility = View.VISIBLE
//                service_grey_IV.visibility = View.VISIBLE
//                Category_grey_IV.visibility = View.VISIBLE
//                Wishlist_grey_IV.visibility = View.VISIBLE
//                greyBell_IV.visibility = View.VISIBLE
//            }
//            Login_RL.setOnClickListener {
//                user_type_login("Service_Provider")
//
//            }

////////ICON///////////////

        MenuClick.setOnClickListener {
            drawerlayout.openDrawer(Gravity.LEFT)
        }

        greyBell_IV.setOnClickListener {
            if (SavedPrefManager.getStringPreferences(
                    this,
                    SavedPrefManager.isLogin
                ) == "false"
            ) {
                user_type_login("Service_Provider")

            } else if (SavedPrefManager.getStringPreferences(
                    this,
                    SavedPrefManager.isLogin
                ) == "true"
            ) {
//                val intent = Intent(this, Notification::class.java)
//                SavedPrefManager.saveStringPreferences(this, SavedPrefManager.isLogin, "true")
//                startActivity(intent)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.FrameLayout, Notification(), "notification")
                    ?.addToBackStack(null)
                    ?.commit()
            }
        }

        Deals_IV.setOnClickListener {

            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayout, Services_DealsScreen("SideMenu"), "serviceDeals")
                ?.addToBackStack(null)?.commit()
        }

//////////BOTTOM ICON//////////////////////

        home_grey_LL.setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, RetailerHomepage(this, flag))
                .commit()
            MainTitle_TV.setText("Home")

            home_grey_IV.visibility = View.GONE
            home_red_IV.visibility = View.VISIBLE

            Category_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE
//            redBell_IV.visibility = View.GONE

            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE

        }

        ll_service_tab.setOnClickListener {
            mainHeader.visibility = View.VISIBLE
            MenuClick.visibility = View.VISIBLE
//            ProductImageView.visibility = View.VISIBLE
            DealsImageView.visibility = View.VISIBLE
            greyBellImageView.visibility = View.VISIBLE
            cart.visibility = View.GONE
            filter.visibility = View.GONE
            back.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, ServicesFragment_SP())
                .commit()
            MainTitle_TV.setText("Services")

            service_grey_IV.visibility = View.GONE
            service_red_IV.visibility = View.VISIBLE

            home_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE
//            redBell_IV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE

        }

        ll_category_tab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, Category(this)).commit()
            MainTitle_TV.setText("Category")

            Category_grey_IV.visibility = View.GONE
            Category_red_IV.visibility = View.VISIBLE

            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE
//            redBell_IV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE

        }

        Wishlist_grey_LL.setOnClickListener {
//            if (SavedPrefManager.getStringPreferences(this, SavedPrefManager.isLogin) == "false") {
//                user_type_login("Service_Provider")
//
//            } else if (SavedPrefManager.getStringPreferences(
//                    this,
//                    SavedPrefManager.isLogin
//                ) == "true"
//            ) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, Wishlist("wishlist"))
                .commit()
            MainTitle_TV.setText("Wishlist")

            Wishlist_grey_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.VISIBLE

            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE
//            redBell_IV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE


        }

        Setting_LL.setOnClickListener {


            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, SettingsFragment())
                .commit()

            MainTitle_TV.setText("Settings")

            greySetting_IV.visibility = View.GONE
            red_setting_IV.visibility = View.VISIBLE

            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
//            redBell_IV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE

        }

        red_setting_IV.setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, SettingsFragment())
                .commit()
            MainTitle_TV.setText("Settings")

            greySetting_IV.visibility = View.VISIBLE
            red_setting_IV.visibility = View.GONE

            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE

        }


        Home_RL.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, RetailerHomepage(this, flag))
                .commit()
            drawerlayout.closeDrawer(Gravity.LEFT)
            MainTitle_TV.setText("Home")

//            Header_RL.visibility = View.GONE

        }

        Logout_RL.setOnClickListener {
            SavedPrefManager.saveStringPreferences(this, SavedPrefManager.isLogin, "false")
            androidextention.logOutDialog(this)

            drawerlayout.closeDrawer(Gravity.LEFT)
        }
        hideSystemUI()
    }


    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE
        val decorView = window.decorView
        decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_IMMERSIVE // Set the content to appear under the system bars so that the
                    // content doesn't resize when the system bars hide and show.
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN // Hide the nav bar and status bar
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    override fun title(s: String) {
        if (s.equals("Category")) {
            MainTitle_TV.setText("Category")
            Category_grey_IV.visibility = View.GONE
            Category_red_IV.visibility = View.VISIBLE

            home_red_IV.visibility = View.GONE
            service_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            service_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE
        } else if (s.equals("Services")) {

            MainTitle_TV.setText("Services")
            service_grey_IV.visibility = View.GONE
            service_red_IV.visibility = View.VISIBLE

            home_red_IV.visibility = View.GONE
            Category_red_IV.visibility = View.GONE
            Wishlist_redIV.visibility = View.GONE
            red_setting_IV.visibility = View.GONE

            home_grey_IV.visibility = View.VISIBLE
            Category_grey_IV.visibility = View.VISIBLE
            Wishlist_grey_IV.visibility = View.VISIBLE
            greySetting_IV.visibility = View.VISIBLE
            greyBell_IV.visibility = View.VISIBLE

        }
    }


    fun LoginCustomerAPI(email: String, password: String) {

        if (androidextention.isOnline(this)) {
            androidextention.showProgressDialog(this)

            val serviceManager = ServiceManager(this)
            val callBack: ApiCallBack<login_response> =
                ApiCallBack<login_response>(this, "LoginCustomer", mContext)

            var jsonObject = JsonObject()
            jsonObject.addProperty("emailNumberId",email)
            jsonObject.addProperty("password",password)
            jsonObject.addProperty("deviceType","gyugugu")
            jsonObject.addProperty("deviceToken","guug")

            try {
                serviceManager.LoginApi(callBack, jsonObject)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {

            diasplay_toast("Please check your internet connection!")
        }
    }

    override fun onApiSuccess(response: login_response, apiName: String?) {
        androidextention.disMissProgressDialog(this)
        if (response.responseCode==200){

            if(response.result!!.otpVerification == true) {
                SavedPrefManager.saveStringPreferences(
                    this,
                    SavedPrefManager.TOKEN,
                    response.result!!.token
                )
                SavedPrefManager.saveStringPreferences(
                    this,
                    SavedPrefManager.USER_TYPE,
                    response.result.userType
                )

                SavedPrefManager.saveStringPreferences(this, SavedPrefManager.isLogin, "true")
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("flag", "Customer")
                startActivity(intent)
            }
            else{
                val intent = Intent(this, OtpVerification::class.java)
                intent.putExtra("email", email)
                intent.putExtra("flag1", "login")
                startActivity(intent)

            }
        }
    }

    override fun onApiErrorBody(response: String, apiName: String?) {
        androidextention.disMissProgressDialog(this)

        val gson = GsonBuilder().create()
        var pojo = response_modal_class()

        try {
            pojo = gson.fromJson(response, pojo::class.java)
            androidextention.alertBox(pojo.responseMessage,this)

        } catch (e: Exception) {
            // handle failure at error parse
        }
    }

    override fun onApiFailure(failureMessage: String?, apiName: String?) {
        androidextention.disMissProgressDialog(this)
    }
    }

