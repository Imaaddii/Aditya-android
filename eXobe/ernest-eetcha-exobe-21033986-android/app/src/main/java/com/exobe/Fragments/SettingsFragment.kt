package com.exobe.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.exobe.*
import com.exobe.Activities.*
import com.exobe.Utils.SavedPrefManager
import com.exobe.bottomsheet.CustomerBottomSheet
import com.exobe.dialogs.RatingApp


class SettingsFragment : Fragment() {

    lateinit var llTerms: LinearLayout
    lateinit var llPrivacy: LinearLayout
    lateinit var llFaq: LinearLayout
    lateinit var llAbout: LinearLayout
    lateinit var Reset_PasswordllTerms: LinearLayout
    lateinit var llProductEnquiry: LinearLayout
    lateinit var llOrderHistroy: LinearLayout
    lateinit var llMyProfile: LinearLayout
    lateinit var llLegal: LinearLayout
    lateinit var Feedback: LinearLayout
    lateinit var Mcontext: Context
    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var llAddress: LinearLayout

    var url = "https://www.freeprivacypolicy.com/blog/privacy-policy-url/"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_settings, container, false)
        Mcontext = activity?.applicationContext!!

        setToolbar()
        llTerms = view.findViewById(R.id.llTerms)
        llPrivacy = view.findViewById(R.id.llPrivacy)
        llFaq = view.findViewById(R.id.llFaq)
        llAbout = view.findViewById(R.id.llAbout)
        Reset_PasswordllTerms = view.findViewById(R.id.Reset_PasswordllTerms)
        llProductEnquiry = view.findViewById(R.id.llProductEnquiry)
        llOrderHistroy = view.findViewById(R.id.llOrderHistroy)
        llMyProfile = view.findViewById(R.id.llMyProfile)
        Feedback = view.findViewById(R.id.Feedback)
        llLegal = view.findViewById(R.id.llLegal)
        llAddress = view.findViewById(R.id.llAddress)

        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE

        llTerms.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "")
            val fragobj = Terms_and_condition()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, fragobj,"Terms_and_condition")?.addToBackStack(null)?.commit()

        }

        llLegal.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "")
            val fragobj = LegalFragment()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, fragobj,"legal")?.addToBackStack(null)?.commit()

        }

        llMyProfile.setOnClickListener {
            val check = SavedPrefManager.getStringPreferences(requireContext(), SavedPrefManager.isLogin)!!
//            var check =SavedPrefManager.saveStringPreferences(this, SavedPrefManager.isLogin, "true")
            if(check.equals("true")){
                val bundle = Bundle()
                bundle.putString("flag", "")
                val fragobj = MyProfileActivity()
                fragobj.setArguments(bundle)
                fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, fragobj,"MyProfileActivity")?.addToBackStack(null)?.commit()
            }
            else {

                if(SavedPrefManager.getStringPreferences(requireContext(), SavedPrefManager.USER_TYPE).equals("CUSTOMER")!!){
                    fragmentManager?.let { it1 ->
                        CustomerBottomSheet("Customer", requireContext()).show(
                            it1,
                            "ModalBottomSheet"
                        )
                    }
                } else {
                    fragmentManager?.let { it1 ->
                        CustomerBottomSheet("Retailer", requireContext()).show(
                            it1,
                            "ModalBottomSheet"
                        )
                    }
                }

            }
        }

        llProductEnquiry.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, ProductEnquiry("SideMenu"),"ProductEnquiry")?.addToBackStack(null)?.commit()
        }

        llOrderHistroy.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, OrderHistory("SideMenu"),"OrderHistory")?.addToBackStack(null)?.commit()
        }

        llPrivacy.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "")
            val fragobj = Privacy_Policy()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, fragobj,"Privacy_Policy")?.addToBackStack(null)?.commit()

        }
        Reset_PasswordllTerms.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "")
            val fragobj = ChangePassword()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, fragobj,"ChangePassword")?.addToBackStack(null)?.commit()
        }

        llFaq.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "")
            val fragobj = FAQs()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, fragobj,"FAQs")?.addToBackStack(null)?.commit()
        }

        llAbout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "")
            val fragobj = About_Us()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, fragobj,"aboutUs")?.addToBackStack(null)?.commit()
        }

        Feedback.setOnClickListener {
            RatingApp().show(childFragmentManager, "MyCustomFragment")
        }

        llAddress.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "setting_address")
            val fragobj = ChooseDeliveryAddress()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, fragobj,"ChooseDeliveryAddress")?.addToBackStack(null)?.commit()

        }


        return view
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
        back.visibility = View.GONE

        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("Settings")
    }



}