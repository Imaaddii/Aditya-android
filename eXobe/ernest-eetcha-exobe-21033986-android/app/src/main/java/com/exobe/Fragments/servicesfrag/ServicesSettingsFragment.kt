package com.exobe.Fragments.servicesfrag

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.exobe.Activities.*
import com.exobe.Fragments.LegalFragment
import com.exobe.R
import com.exobe.androidextention
import com.exobe.dialogs.RatingApp


class ServicesSettingsFragment : Fragment() {

    lateinit var llTerms: LinearLayout
    lateinit var llPrivacy: LinearLayout
    lateinit var llFaq: LinearLayout
    lateinit var llLegal: LinearLayout
    lateinit var llAbout: LinearLayout
    lateinit var Logout: LinearLayout
    lateinit var Reset_PasswordllTerms: LinearLayout
    lateinit var llMyProfile: LinearLayout
    lateinit var Feedback: LinearLayout
    var title: TextView? = null
    var back: ImageView? = null
     var MenuClick : ImageView? = null

    var url = "https://www.freeprivacypolicy.com/blog/privacy-policy-url/"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_services_settings, container, false)
        llTerms = view.findViewById(R.id.llTerms)
        llPrivacy = view.findViewById(R.id.llPrivacy)
        llFaq = view.findViewById(R.id.llFaq)
        Logout = view.findViewById(R.id.Logout)
        llAbout = view.findViewById(R.id.llAbout)
        Reset_PasswordllTerms = view.findViewById(R.id.Reset_PasswordllTerms)
        llMyProfile = view.findViewById(R.id.llMyProfile)
        Feedback = view.findViewById(R.id.Feedback)
        llLegal = view.findViewById(R.id.llLegal)
        title = activity?.findViewById(R.id.title)
        back = activity?.findViewById(R.id.back)
        MenuClick = activity?.findViewById(R.id.MenuClick)!!

        MenuClick!!.visibility = View.GONE

        title!!.setText("Settings")
        back!!.visibility = View.GONE
        llTerms.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "services")
            val fragobj = Terms_and_condition()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.service_main_container, fragobj,"Terms_and_condition")?.addToBackStack(null)?.commit()

        }

        llLegal.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "services")
            val fragobj = LegalFragment()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.service_main_container, fragobj,"legal")?.addToBackStack(null)?.commit()

        }

        llMyProfile.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "services")
            val fragobj = MyProfileActivity()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.service_main_container, fragobj,"MyProfileActivity")?.addToBackStack(null)?.commit()
        }

        llPrivacy.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "services")
            val fragobj = Privacy_Policy()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.service_main_container, fragobj,"Privacy_Policy")?.addToBackStack(null)?.commit()

        }
        Reset_PasswordllTerms.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "services")
            val fragobj = ChangePassword()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.service_main_container, fragobj,"ChangePassword")?.addToBackStack(null)?.commit()
        }

        llFaq.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "services")
            val fragobj = FAQs()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.service_main_container, fragobj,"FAQs")?.addToBackStack(null)?.commit()
        }

        llAbout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("flag", "services")
            val fragobj = About_Us()
            fragobj.setArguments(bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.service_main_container, fragobj,"aboutUs")?.addToBackStack(null)?.commit()
        }

        Feedback.setOnClickListener {

            RatingApp().show(childFragmentManager, "MyCustomFragment")
        }
        Logout.setOnClickListener {
            androidextention.logOutDialog(requireContext())
        }

        return view
    }
}