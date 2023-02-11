package com.fram.farmserv.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import com.fram.farmserv.Activities.BaseActivity.BaseActivity
import com.fram.farmserv.Fragments.Home.*
import com.fram.farmserv.R

class FragmentContainerActivity : BaseActivity(), View.OnClickListener {
    private lateinit var homeTab: RelativeLayout
    private lateinit var myOrderTab: RelativeLayout
    private lateinit var myEarningTab: RelativeLayout
    private lateinit var settingTab: RelativeLayout


    private lateinit var homeText: TextView
    private lateinit var orderText: TextView
    private lateinit var earningText: TextView
    private lateinit var settingText: TextView

    private lateinit var selectedHome: ImageView
    private lateinit var unselectedHome: ImageView
    private lateinit var lineHome: LinearLayout

    private lateinit var selectedOrder: ImageView
    private lateinit var unselectedOrder: ImageView
    private lateinit var lineOrder: LinearLayout

    private lateinit var selectedEarning: ImageView
    private lateinit var unselectedEarning: ImageView
    private lateinit var lineEarning: LinearLayout

    private lateinit var selectedSetting: ImageView
    private lateinit var unselectedSetting: ImageView
    private lateinit var lineSetting: LinearLayout

    private lateinit var sideMenuIcon: ImageView

    private lateinit var drawerLayout: DrawerLayout

    //delivery partner
    private lateinit var switch_role: RelativeLayout
    private lateinit var order_history: RelativeLayout
    private lateinit var my_earning: RelativeLayout
    private lateinit var my_purchase_history: RelativeLayout
    private lateinit var latest_communication: RelativeLayout
    private lateinit var farmer_list: RelativeLayout
    private lateinit var add_a_farmer: RelativeLayout
    private lateinit var delivery_partner_details: RelativeLayout
    private lateinit var location_settings: RelativeLayout
    private lateinit var language_settings: RelativeLayout
    private lateinit var my_address: RelativeLayout
    private lateinit var help: RelativeLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setcontent_View())
        Initialize_id()
        initializedControl()
        setOnClickListener()
    }

    override fun setcontent_View(): Int {
        return R.layout.activity_fragment_container
    }

    override fun setOnClickListener() {
        homeTab.setOnClickListener(this)
        myOrderTab.setOnClickListener(this)
        myEarningTab.setOnClickListener(this)
        settingTab.setOnClickListener(this)
        sideMenuIcon.setOnClickListener(this)
    }

    override fun Initialize_id() {
        homeTab = findViewById(R.id.home_tab)
        myOrderTab = findViewById(R.id.my_order_tab)
        myEarningTab = findViewById(R.id.my_earning_tab)
        settingTab = findViewById(R.id.setting_tab)

        selectedHome = findViewById(R.id.selected_home)
        unselectedHome = findViewById(R.id.unselected_home)
        lineHome = findViewById(R.id.home_line)

        selectedOrder = findViewById(R.id.selected_order_history)
        unselectedOrder = findViewById(R.id.unselected_order_history)
        lineOrder = findViewById(R.id.order_history_line)

        selectedEarning = findViewById(R.id.selected_my_earning)
        unselectedEarning = findViewById(R.id.unselected_my_earning)
        lineEarning = findViewById(R.id.my_earning_line)

        selectedSetting = findViewById(R.id.selected_settings)
        unselectedSetting = findViewById(R.id.unselected_settings)
        lineSetting = findViewById(R.id.settings_line)

        homeText = findViewById(R.id.home_text)
        orderText = findViewById(R.id.order_history_text)
        earningText = findViewById(R.id.my_earning_text)
        settingText = findViewById(R.id.settings_text)

        sideMenuIcon = findViewById(R.id.side_menu_icon)
        drawerLayout = findViewById(R.id.drawer_layout)

    }

    override fun initializedControl() {
        selectedHome.visibility = View.VISIBLE
        unselectedHome.visibility = View.GONE
        lineHome.visibility = View.VISIBLE
        homeText.setTextColor(resources.getColor(R.color.selected_text_color))
        supportFragmentManager.beginTransaction().replace(R.id.home_container, HomeFragment()).commit()

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.home_tab -> {
                selectedHome.visibility = View.VISIBLE
                unselectedHome.visibility = View.GONE
                lineHome.visibility = View.VISIBLE

                selectedOrder.visibility = View.GONE
                unselectedOrder.visibility = View.VISIBLE
                lineOrder.visibility = View.GONE

                selectedEarning.visibility = View.GONE
                unselectedEarning.visibility = View.VISIBLE
                lineEarning.visibility = View.GONE

                selectedSetting.visibility = View.GONE
                unselectedSetting.visibility = View.VISIBLE
                lineSetting.visibility = View.GONE

                homeText.setTextColor(resources.getColor(R.color.selected_text_color))
                orderText.setTextColor(resources.getColor(R.color.unselected_text_color))
                earningText.setTextColor(resources.getColor(R.color.unselected_text_color))
                settingText.setTextColor(resources.getColor(R.color.unselected_text_color))

                supportFragmentManager.beginTransaction().replace(R.id.home_container, HomeFragment()).commit()

            }

            R.id.my_order_tab -> {
                selectedHome.visibility = View.GONE
                unselectedHome.visibility = View.VISIBLE
                lineHome.visibility = View.GONE

                selectedOrder.visibility = View.VISIBLE
                unselectedOrder.visibility = View.GONE
                lineOrder.visibility = View.VISIBLE

                selectedEarning.visibility = View.GONE
                unselectedEarning.visibility = View.VISIBLE
                lineEarning.visibility = View.GONE

                selectedSetting.visibility = View.GONE
                unselectedSetting.visibility = View.VISIBLE
                lineSetting.visibility = View.GONE

                homeText.setTextColor(resources.getColor(R.color.unselected_text_color))
                orderText.setTextColor(resources.getColor(R.color.selected_text_color))
                earningText.setTextColor(resources.getColor(R.color.unselected_text_color))
                settingText.setTextColor(resources.getColor(R.color.unselected_text_color))

                supportFragmentManager.beginTransaction().replace(R.id.home_container, MandiPriceFragment()).commit()
            }

            R.id.my_earning_tab -> {
                selectedHome.visibility = View.GONE
                unselectedHome.visibility = View.VISIBLE
                lineHome.visibility = View.GONE

                selectedOrder.visibility = View.GONE
                unselectedOrder.visibility = View.VISIBLE
                lineOrder.visibility = View.GONE

                selectedEarning.visibility = View.VISIBLE
                unselectedEarning.visibility = View.GONE
                lineEarning.visibility = View.VISIBLE

                selectedSetting.visibility = View.GONE
                unselectedSetting.visibility = View.VISIBLE
                lineSetting.visibility = View.GONE

                homeText.setTextColor(resources.getColor(R.color.unselected_text_color))
                orderText.setTextColor(resources.getColor(R.color.unselected_text_color))
                earningText.setTextColor(resources.getColor(R.color.selected_text_color))
                settingText.setTextColor(resources.getColor(R.color.unselected_text_color))
                supportFragmentManager.beginTransaction().replace(R.id.home_container, MyEarningFragment()).commit()

            }

            R.id.setting_tab -> {
                selectedHome.visibility = View.GONE
                unselectedHome.visibility = View.VISIBLE
                lineHome.visibility = View.GONE

                selectedOrder.visibility = View.GONE
                unselectedOrder.visibility = View.VISIBLE
                lineOrder.visibility = View.GONE

                selectedEarning.visibility = View.GONE
                unselectedEarning.visibility = View.VISIBLE
                lineEarning.visibility = View.GONE

                selectedSetting.visibility = View.VISIBLE
                unselectedSetting.visibility = View.GONE
                lineSetting.visibility = View.VISIBLE

                homeText.setTextColor(resources.getColor(R.color.unselected_text_color))
                orderText.setTextColor(resources.getColor(R.color.unselected_text_color))
                earningText.setTextColor(resources.getColor(R.color.unselected_text_color))
                settingText.setTextColor(resources.getColor(R.color.selected_text_color))
                supportFragmentManager.beginTransaction().replace(R.id.home_container, SettingsFragment()).commit()
            }

            R.id.side_menu_icon -> {
                drawerLayout.openDrawer(Gravity.LEFT)
            }
        }
    }

}