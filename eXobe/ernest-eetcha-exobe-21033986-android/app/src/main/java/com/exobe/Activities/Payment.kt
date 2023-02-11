package com.exobe.Activities
import android.app.ProgressDialog.show
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.exobe.R
import com.exobe.dialogs.DialogBoxPayment

class Payment : Fragment() {

    lateinit var title : TextView
    lateinit var cart : ImageView
    lateinit var filter : ImageView
    lateinit var back : ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    lateinit var services: LinearLayout
    lateinit var PaymentButton:Button
    var flag:String=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.activity_payment, container, false)
        setToolbar()
        if(requireArguments().getString("flag") != null) {
            flag = requireArguments().getString("flag").toString()

        }
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader!!.visibility = View.VISIBLE

        PaymentButton= view.findViewById(R.id.PaymentButton)

        back.setOnClickListener{
            fragmentManager?.popBackStack()
        }

        PaymentButton.setOnClickListener{
            if(flag.equals("servicerequest")){

            }
            else{
                fragmentManager?.let { DialogBoxPayment().show(it, "MyCustomFragment") }
            }
//            Toast.makeText(requireContext(),"Payment Done Successfully",Toast.LENGTH_SHORT)


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
        back.visibility = View.VISIBLE

        MenuClick.visibility = View.GONE
        ProductImageView.visibility = View.GONE
        DealsImageView.visibility = View.GONE
        greyBellImageView.visibility = View.GONE
        title.setText("Payment Details")

    }

}


