package com.exobe.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.exobe.R

class Privacy_Policy : Fragment() {

    lateinit var ivgroup: TextView
    lateinit var title: TextView
    lateinit var cart: ImageView
    lateinit var filter: ImageView
    lateinit var back: ImageView
    lateinit var ProductImageView: ImageView
    lateinit var DealsImageView: ImageView
    lateinit var greyBellImageView: ImageView
    lateinit var MenuClick: ImageView
    lateinit var mainHeader: RelativeLayout
    var flag = ""
    var url = "https://www.termsfeed.com/blog/privacy-policy-url-facebook-app/"
    lateinit var webView : WebView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_privacy_policy, container, false)
        if (requireArguments().getString("flag") != null) {
            flag = requireArguments().getString("flag").toString()

        }

        if (flag.equals("services")) {

            title = activity?.findViewById(R.id.title)!!
            back = activity?.findViewById(R.id.back)!!
            webView = view.findViewById(R.id.help_webview);
            webView.webViewClient = WebViewClient()
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
            title!!.setText("Privacy Policy")
            back!!.visibility = View.VISIBLE
            back!!.setOnClickListener {
                fragmentManager?.popBackStack()
            }

        } else {
            setToolbar()

            mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
            webView = view.findViewById(R.id.help_webview);
            webView.webViewClient = WebViewClient()
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
            mainHeader.visibility = View.VISIBLE

            back.setOnClickListener {
                fragmentManager?.popBackStack()
            }
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
        title.setText("Privacy Policy")
    }



}