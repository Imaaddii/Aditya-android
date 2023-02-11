package com.exobe.Activities

import android.content.Intent
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.exobe.R
import com.exobe.dialogs.productDialog
import java.util.*


class ProductEnquiry(var flagSide: String) : Fragment() {

    lateinit var btnSave : Button
    lateinit var backPE: ImageView
    lateinit var EmailTV: TextView
    lateinit var PhoneTV: TextView
    lateinit var ivgroup: TextView
    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var SubjectET:EditText
    lateinit var Description:EditText
    lateinit var SubjectST:TextView
    lateinit var DescrTV:TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_product_enquiry, container, false)


        EmailTV = view.findViewById(R.id.EmailTV)
        PhoneTV = view.findViewById(R.id.PhoneTV)
        btnSave = view.findViewById(R.id.btnSave)
        SubjectET = view.findViewById(R.id.SubjectET)
        SubjectST = view.findViewById(R.id.Subject)
        Description = view.findViewById(R.id.Description)
        DescrTV = view.findViewById(R.id.DescrTV)
        setToolbar()
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.VISIBLE

        EmailTV.setOnClickListener {
            shareToGMail()

        }

        PhoneTV.setOnClickListener {
            var number= PhoneTV.text.toString()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:" + number))
            startActivity(intent)
        }
        back.setOnClickListener{
            fragmentManager?.popBackStack()
        }

        btnSave.setOnClickListener{
            validations()

        }




        if (flagSide.equals("SideMenu")) {
            MenuClick.visibility = View.GONE
            back.visibility = View.VISIBLE

        } else {
            back.visibility = View.GONE
            MenuClick.visibility = View.VISIBLE
        }

        return view
    }

    private fun validations() {

        SubjectST.text=""
        DescrTV.text=""
        SubjectST.visibility= View.VISIBLE
        DescrTV.visibility= View.GONE

        if(SubjectET.text.isEmpty()){
            SubjectET.requestFocus()
            SubjectST.visibility= View.VISIBLE
            SubjectST.text= "*Please enter subject."
        }else if(Description.text.isEmpty()){
            Description.requestFocus()
            DescrTV.visibility= View.VISIBLE
            DescrTV.text= "*Enter description."
        }else{
            fragmentManager?.let { productDialog("","Enquiry").show(it, "MyCustomFragment") }

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
        title.setText("Product Enquiry")
    }


    fun shareToGMail() {

        val emailIntent = Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:R{EmailTV.text.toString()}"))
        requireActivity()!!.startActivity(emailIntent)
    }
}


