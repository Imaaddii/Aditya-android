package com.exobe.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.exobe.R


class LegalFragment : Fragment() {
    lateinit var ivgroup: TextView
    var title: TextView? = null
    var cart: ImageView? = null
    var filter: ImageView? = null
    var back: ImageView? = null
    var ProductImageView: ImageView? = null
    var DealsImageView: ImageView? = null
    var greyBellImageView: ImageView? = null
    var MenuClick: ImageView? = null
    var mainHeader: RelativeLayout? = null
    var flag = ""
    var url = "https://www.termsfeed.com/blog/privacy-policy-url-facebook-app/"
    lateinit var webView : WebView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_legal, container, false)
        title = activity?.findViewById(R.id.title)
        back = activity?.findViewById(R.id.back)
        if (requireArguments().getString("flag") != null) {
            flag = requireArguments().getString("flag").toString()

        }

        if (flag.equals("services")) {
            back!!.visibility = View.VISIBLE
            title!!.setText("Legal")
            webView = view.findViewById(R.id.help_webview);
            webView.webViewClient = WebViewClient()
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
            back!!.setOnClickListener {
                fragmentManager?.popBackStack()
            }

        } else {
            setToolbar()
            mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
            mainHeader!!.visibility = View.VISIBLE
            back!!.visibility = View.VISIBLE
            webView = view.findViewById(R.id.help_webview);
            webView.webViewClient = WebViewClient()
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
            back!!.setOnClickListener {
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
        cart!!.visibility = View.GONE
        filter!!.visibility = View.GONE
        back!!.visibility = View.VISIBLE

        MenuClick!!.visibility = View.GONE
        ProductImageView!!.visibility = View.GONE
        DealsImageView!!.visibility = View.GONE
        greyBellImageView!!.visibility = View.GONE
        title!!.setText("Legal")
    }



}



