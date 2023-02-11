package com.exobe.Adaptor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.exobe.Fragments.OnBoardingFragment1
import com.exobe.Fragments.OnBoardingFragment2
import com.exobe.Fragments.onBoardFragment3


class FragAdaptor(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private var fragmentList: ArrayList<Fragment> = ArrayList()
    private var titleList: ArrayList<String> = ArrayList()

    fun add(fragment: Fragment, title: String) {
        titleList.add(title)
        fragmentList.add(fragment)
    }

    override fun getItem(position: Int): Fragment {

        when(position){
            0->{return OnBoardingFragment1()
            }
            1->{ return OnBoardingFragment2()
            }
            else->{return onBoardFragment3()
            }
//            0->{return OnBoardingFragment2()
//            }
//            else->{return OnBoardingFragment3()
//            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    }