package com.exobe.Fragments.servicesfrag

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.servicesAdaptor.PendingServicesAdapter
import com.exobe.R
import com.exobe.customClicks.ServicesClick
import com.exobe.customClicks.servicedeleteclick
import com.exobe.customClicks.serviceselectedclick
import com.exobe.customClicks.viewserviceclick
import com.exobe.dialogs.confirm_service


class PendingServices(
    var servicesClick: ServicesClick,
    var viewserviceclick: viewserviceclick,
) : Fragment(), serviceselectedclick ,
    servicedeleteclick {
    lateinit var recyclerView: RecyclerView
    var data = 10
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_pending_services, container, false)

        recyclerView = view.findViewById(R.id.PendingRecycler)
        setAdaptor()

        return view
    }



    override fun pendingclick(position: Int) {
        fragmentManager?.let { confirm_service(requireContext(), this, position,viewserviceclick).show(it, "MyCustomFragment")}

    }

    fun setAdaptor() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        var adapter = PendingServicesAdapter(activity as Context, this, data)
        recyclerView.adapter = adapter
    }

    override fun pendingdeleteclick(position: Int) {
        data--
        setAdaptor()    }


}