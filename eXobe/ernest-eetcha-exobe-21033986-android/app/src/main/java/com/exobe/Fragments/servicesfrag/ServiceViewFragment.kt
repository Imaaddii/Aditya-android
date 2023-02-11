package com.exobe.Fragments.servicesfrag

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Activities.OtpVerification
import com.exobe.Adaptor.servicesAdaptor.CompletedServicesAdapter
import com.exobe.Adaptor.servicesAdaptor.ServiceListAdaptor
import com.exobe.R


class ServiceViewFragment : Fragment() {
    lateinit var title: TextView
    lateinit var status: TextView
    lateinit var back: ImageView
    lateinit var markAsDone: Button
    lateinit var recyclerView: RecyclerView
    lateinit var transaction: RelativeLayout
    var menuClick : ImageView? = null

    var flag = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_service_view, container, false)
        recyclerView = view.findViewById(R.id.services_rv)!!
        markAsDone = view.findViewById(R.id.markAsDone)!!
        status = view.findViewById(R.id.status)!!
        transaction = view.findViewById(R.id.transaction)!!
        title = activity?.findViewById(R.id.title)!!
        back = activity?.findViewById(R.id.back)!!
        menuClick = activity?.findViewById(R.id.MenuClick)!!
        title.text = "Service Details"
        back.visibility = View.VISIBLE
        menuClick!!.visibility = View.GONE

        if (requireArguments().getString("flag") != null) {
            flag = requireArguments().getString("flag").toString()

        }

        if(flag.equals("pending")) {
            transaction.visibility = View.GONE
//            markAsDone.visibility = View.VISIBLE
//            status.setText("7898585855")
        } else {
            markAsDone.visibility = View.GONE
            status.setText("7898585855")
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        var adapter = ServiceListAdaptor()
        recyclerView.adapter = adapter

        markAsDone.setOnClickListener{
            val intent = Intent(activity, OtpVerification::class.java)
            intent.putExtra("flag", "ServiceManagement")
            activity?.startActivity(intent)
        }

        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }


        return view
    }


}