package com.exobe.Adaptor

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.exobe.Fragments.DeleveredOrder
import com.exobe.Fragments.PendingOrder
import com.exobe.customClicks.CustomeClick

class MyAdapter(
    private val myContext: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    var customeClick: CustomeClick
) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 ->{ return PendingOrder(customeClick)
            }
            else -> {
                return DeleveredOrder(customeClick)
            }

        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}


