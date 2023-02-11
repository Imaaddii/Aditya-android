package com.exobe.Adaptor.servicesAdaptor

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.exobe.Fragments.servicesfrag.CompletedServices
import com.exobe.Fragments.servicesfrag.PendingServices
import com.exobe.customClicks.ServicesClick
import com.exobe.customClicks.servicedeleteclick
import com.exobe.customClicks.viewserviceclick

class ServicesTabAdapter(
    private val myContext: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    var servicesClick: ServicesClick,
    var viewserviceclick: viewserviceclick,

    ) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 ->{ return PendingServices(servicesClick, viewserviceclick)
            }
            else -> {
                return CompletedServices(servicesClick)
            }

        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}


