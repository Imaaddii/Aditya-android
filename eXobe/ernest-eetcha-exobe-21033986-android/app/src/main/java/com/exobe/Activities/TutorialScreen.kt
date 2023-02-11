package com.exobe.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.exobe.Activities.Services
import com.exobe.Adapter.HomeCategory
import com.exobe.Adaptor.FragAdaptor
import com.exobe.R
import com.exobe.Utils.SavedPrefManager
import com.google.android.material.tabs.TabLayout


class TutorialScreen : AppCompatActivity() {

    lateinit var mViewPager: ViewPager
    lateinit var mTabLayout: TabLayout
    lateinit var Skip: TextView
    lateinit var Next: TextView
    lateinit var GEtStarted: Button
    var count = 0
    var tutotailDataList = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_screen)


        mTabLayout = findViewById(R.id.tab_layout_onBoarding)
        mViewPager = findViewById(R.id.view_pager_frag)
        Skip = findViewById(R.id.Skip)
        Next = findViewById(R.id.NextButton)
        GEtStarted = findViewById(R.id.GetStarted)




        Next.setOnClickListener {
            NEXT()
        }

        Skip.setOnClickListener {
            val intent = Intent(this, Services::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        }


        GEtStarted.setOnClickListener {
            SavedPrefManager.savePreferenceBoolean(this, SavedPrefManager.TutorialFlag , true)
            var intent = Intent(this, Services::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        var mFragAdaptor = FragAdaptor(supportFragmentManager)
        mViewPager.adapter = mFragAdaptor
        mTabLayout.setupWithViewPager(mViewPager)


        mViewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                if (position == 2) {
                    GEtStarted.visibility = View.VISIBLE
                    Next.visibility = View.GONE
                    Skip.visibility = View.GONE



                } else {
                    GEtStarted.visibility = View.GONE
                    Next.visibility = View.VISIBLE
                    Skip.visibility = View.VISIBLE
                }
            }

            override fun onPageSelected(position: Int) {

            }

        })


    }


    fun NEXT() {
        try {
            mViewPager.setCurrentItem(mViewPager.currentItem + 1, true)
            count++
            if (count == tutotailDataList - 1) {

                Next.visibility = View.GONE
                GEtStarted.visibility = View.VISIBLE
                Skip.visibility = View.GONE




            }


        } catch (e: Exception) {
        }
    }


}