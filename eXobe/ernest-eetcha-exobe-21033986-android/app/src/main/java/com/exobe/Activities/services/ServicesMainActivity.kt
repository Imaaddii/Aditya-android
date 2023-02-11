package com.exobe.Activities.services

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.exobe.Activities.*
import com.exobe.Fragments.servicesfrag.ServicesManagement
import com.exobe.Fragments.servicesfrag.ServicesSettingsFragment
import com.exobe.Fragments.servicesfrag.payment_description_sp
import com.exobe.R

class ServicesMainActivity : AppCompatActivity() {
    lateinit var back : ImageView
    lateinit var title : TextView

    lateinit var home : ImageView
    lateinit var homeRed : ImageView
    lateinit var homeText : TextView
    lateinit var settings : ImageView
    lateinit var settingsRed : ImageView
    lateinit var MenuClick : ImageView
    lateinit var settingsText : TextView
    lateinit var drawerlayout: DrawerLayout

    lateinit var ll_home_tab : LinearLayout
    lateinit var ll_settings_tab : LinearLayout
    lateinit var Serviseprovider_LL : LinearLayout
//
//    lateinit var MyCart_RL_ServiceProvider: RelativeLayout
//    lateinit var ServicesRequest_serviceprovider: RelativeLayout
//    lateinit var Mydeals_RL_ServiceProvider: RelativeLayout
//    lateinit var Paymenthistory_RL_ServiceProvider: RelativeLayout
//    lateinit var ProductEnquiry_RL_ServiceProvider: RelativeLayout
//    lateinit var Requestedservices_RL_ServiceProvider: RelativeLayout
//    lateinit var Settings_RL_ServiceProvider: RelativeLayout
    lateinit var MyDeals_serviseprovider: RelativeLayout
    lateinit var ll_deals_sp: LinearLayout
    lateinit var PaymentHistory_serviseprovider: RelativeLayout
    lateinit var ll_paymenthistorysp: LinearLayout
    lateinit var downarrowsp1: ImageView
    lateinit var rightarrow_sp1: ImageView
    lateinit var rightarrow_sp: ImageView
    lateinit var downarrow_sp: ImageView
    lateinit var RequestedServices_serviseprovider: RelativeLayout
    lateinit var Home_RelativeLayout: RelativeLayout
    lateinit var Login_RelativeLayout: RelativeLayout
    lateinit var Logout_RelativeLayout: RelativeLayout
    lateinit var  paymenttowholesalerssp: LinearLayout
    lateinit var  paymentfromcustomersp: LinearLayout
    lateinit var  dealsfromcustomersp: LinearLayout
    lateinit var v: ImageView


    var paymentflag=false
    var dealsflag=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_services_main)
        back = findViewById(R.id.back)
        title = findViewById(R.id.title)

        dealsfromcustomersp = findViewById(R.id.dealsfromcustomersp)
        home = findViewById(R.id.home_grey_sp)
        homeRed = findViewById(R.id.home_sp)
        homeText = findViewById(R.id.TVhome_sp)
        settings = findViewById(R.id.setting_grey_sp)
        settingsRed = findViewById(R.id.setting_red_sp)
        settingsText = findViewById(R.id.TVsetting_sp)
        ll_home_tab = findViewById(R.id.ll_home_tab)
        ll_settings_tab = findViewById(R.id.ll_settings_tab)
        MenuClick = findViewById(R.id.MenuClick)
        drawerlayout = findViewById(R.id.drawer_layout)
        Serviseprovider_LL = findViewById(R.id.Serviseprovider_LL)
//        MyCart_RL_ServiceProvider = findViewById(R.id.MyCart_serviseprovider)
//        Mydeals_RL_ServiceProvider = findViewById(R.id.MyDeals_serviseprovider)
//        Paymenthistory_RL_ServiceProvider = findViewById(R.id.PaymentHistory_serviseprovider)
//        Requestedservices_RL_ServiceProvider = findViewById(R.id.RequestedServices_serviseprovider)
//        Settings_RL_ServiceProvider = findViewById(R.id.Settings_serviseprovider)
        MyDeals_serviseprovider = findViewById(R.id.MyDeals_serviseprovider)
        ll_deals_sp = findViewById(R.id.ll_deals_sp)
        PaymentHistory_serviseprovider = findViewById(R.id.PaymentHistory_serviseprovider)
        ll_paymenthistorysp = findViewById(R.id.ll_paymenthistorysp)
        downarrowsp1 = findViewById(R.id.downarrowsp1)
        rightarrow_sp1 = findViewById(R.id.rightarrow_sp1)
        rightarrow_sp = findViewById(R.id.rightarrow_sp)
        downarrow_sp = findViewById(R.id.downarrow_sp)

        paymentfromcustomersp=findViewById(R.id.paymentfromcustomersp)
        paymenttowholesalerssp=findViewById(R.id.paymenttowholesalerssp)

        RequestedServices_serviseprovider = findViewById(R.id.RequestedServices_serviseprovider)
        Home_RelativeLayout = findViewById(R.id.Home_RelativeLayout)
        Login_RelativeLayout = findViewById(R.id.Login_RelativeLayout)
        Logout_RelativeLayout = findViewById(R.id.Logout_RelativeLayout)
        drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        back.visibility = View.GONE
        MenuClick.visibility = View.VISIBLE
        title.setText("Services")
        supportFragmentManager.beginTransaction().replace(R.id.service_main_container, ServicesManagement())?.commit()

        dealsfromcustomersp.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)
            home.visibility = View.GONE
            homeRed.visibility = View.VISIBLE
            homeText.setTextColor(Color.parseColor("#AAAAAA"))
            settings.visibility = View.VISIBLE
            settingsRed.visibility = View.GONE
            settingsText.setTextColor(Color.parseColor("#AAAAAA"))

            title.setText("Deals to customers")
            ll_paymenthistorysp.visibility = View.GONE
            downarrowsp1.visibility = View.GONE
            rightarrow_sp1.visibility = View.VISIBLE
            ll_deals_sp.visibility = View.GONE
            downarrow_sp.visibility = View.GONE
            rightarrow_sp.visibility = View.VISIBLE
            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.service_main_container, Customers_Deals(
                    "SideMenu",
                    "onService",
                    "service",
                    "headertitle","Deals to customer"
                ), "CustomersDeals")
                ?.addToBackStack(null)
                ?.commit()
        }


        Home_RelativeLayout.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)
            supportFragmentManager.beginTransaction().replace(R.id.service_main_container, ServicesManagement(),"servicemanagement")?.addToBackStack(null)?.commit()
        }

        ll_home_tab.setOnClickListener{
            title.setText("Services")
            home.visibility = View.VISIBLE
            homeRed.visibility = View.GONE
            homeText.setTextColor(Color.parseColor("#BF1E2E"))

            settings.visibility = View.VISIBLE
            settingsRed.visibility = View.GONE
            settingsText.setTextColor(Color.parseColor("#AAAAAA"))
            supportFragmentManager.beginTransaction().replace(R.id.service_main_container, ServicesManagement(),"servicemanagement")?.addToBackStack(null)?.commit()
        }

        ll_settings_tab.setOnClickListener{
//            title.setText("Settings")
            home.visibility = View.GONE
            homeRed.visibility = View.VISIBLE
            homeText.setTextColor(Color.parseColor("#AAAAAA"))

            settings.visibility = View.GONE
            settingsRed.visibility = View.VISIBLE
            settingsText.setTextColor(Color.parseColor("#BF1E2E"))
            supportFragmentManager.beginTransaction().replace(R.id.service_main_container, ServicesSettingsFragment(),"servicesettingmanagement")?.addToBackStack(null)?.commit()

        }
//
        MenuClick.setOnClickListener {
            drawerlayout.openDrawer(Gravity.LEFT)
            Serviseprovider_LL.visibility=View.VISIBLE
            Logout_RelativeLayout.visibility=View.VISIBLE
            Login_RelativeLayout.visibility=View.GONE

        }
        paymentfromcustomersp.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)
            home.visibility = View.GONE
            homeRed.visibility = View.VISIBLE
            homeText.setTextColor(Color.parseColor("#AAAAAA"))
            settings.visibility = View.VISIBLE
            settingsRed.visibility = View.GONE
            settingsText.setTextColor(Color.parseColor("#AAAAAA"))

            title.setText("Payment from customers")
            ll_paymenthistorysp.visibility = View.GONE
            downarrowsp1.visibility = View.GONE
            rightarrow_sp1.visibility = View.VISIBLE
            ll_deals_sp.visibility = View.GONE
            downarrow_sp.visibility = View.GONE
            rightarrow_sp.visibility = View.VISIBLE
            val bundle = Bundle()
            bundle.putString("flagSide", "SideMenu")
            bundle.putString("paymentFlag", "PaymentFromCustomerService")
            bundle.putString("title", "Payment From Customer")
            val fragobj = payment_description_sp()
            fragobj.setArguments(bundle)
            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.service_main_container, fragobj, "payment_description")
                ?.addToBackStack(null)?.commit()
//            supportFragmentManager.beginTransaction().replace(R.id.service_main_container, fragobj,"payment_description")?.addToBackStack(null)?.commit()

        }
        paymenttowholesalerssp.setOnClickListener {

            drawerlayout.closeDrawer(Gravity.LEFT)
            home.visibility = View.GONE
            homeRed.visibility = View.VISIBLE
            homeText.setTextColor(Color.parseColor("#AAAAAA"))
            settings.visibility = View.VISIBLE
            settingsRed.visibility = View.GONE
            settingsText.setTextColor(Color.parseColor("#AAAAAA"))
            title.setText("Payment to wholesalers")

            ll_paymenthistorysp.visibility = View.GONE
            downarrowsp1.visibility = View.GONE
            rightarrow_sp1.visibility = View.VISIBLE
            ll_deals_sp.visibility = View.GONE
            downarrow_sp.visibility = View.GONE
            rightarrow_sp.visibility = View.VISIBLE
            val bundle = Bundle()
            bundle.putString("flagSide", "service")
            bundle.putString("paymentFlag", "PaymentFromWholesalersService")
            bundle.putString("title", "Payment to Wholesalers")

            val fragobj = payment_description_sp()
            fragobj.setArguments(bundle)
            supportFragmentManager?.beginTransaction()
                ?.replace(R.id.service_main_container, fragobj, "payment_description")
                ?.addToBackStack(null)?.commit()
//            supportFragmentManager.beginTransaction().replace(R.id.service_main_container, fragobj,"payment_description")?.addToBackStack(null)?.commit()

        }


//        ProductEnquiry_RL_ServiceProvider.setOnClickListener {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.service_main_container, ProductEnquiry("SideMenu"), "ProductEnquiry")
//                ?.addToBackStack(null)
//                ?.commit()
//        }
        RequestedServices_serviseprovider.setOnClickListener {
            drawerlayout.closeDrawer(Gravity.LEFT)
            supportFragmentManager.beginTransaction().replace(R.id.service_main_container, ServicesManagement(),"servicemanagement")?.addToBackStack(null)?.commit()

        }



        MyDeals_serviseprovider.setOnClickListener{
            if (dealsflag == false) {
                dealsflag = true
                paymentflag=false
                ll_deals_sp.visibility = View.VISIBLE
                downarrow_sp.visibility = View.VISIBLE
                rightarrow_sp.visibility = View.GONE
                ll_paymenthistorysp.visibility = View.GONE
                downarrowsp1.visibility = View.GONE
                rightarrow_sp1.visibility = View.VISIBLE

            } else {
                paymentflag=true
                dealsflag = false
                ll_deals_sp.visibility = View.GONE
                downarrow_sp.visibility = View.GONE
                rightarrow_sp.visibility = View.VISIBLE

            }

        }

        PaymentHistory_serviseprovider.setOnClickListener {
            if (paymentflag == false) {
                paymentflag = true
                dealsflag=false
                ll_paymenthistorysp.visibility = View.VISIBLE
                downarrowsp1.visibility = View.VISIBLE
                rightarrow_sp1.visibility = View.GONE
                ll_deals_sp.visibility = View.GONE
                downarrow_sp.visibility = View.GONE
                rightarrow_sp.visibility = View.VISIBLE

            } else {
                dealsflag=true
                paymentflag = false
                ll_paymenthistorysp.visibility = View.GONE
                downarrowsp1.visibility = View.GONE
                rightarrow_sp1.visibility = View.VISIBLE

            }
        }




    }


}