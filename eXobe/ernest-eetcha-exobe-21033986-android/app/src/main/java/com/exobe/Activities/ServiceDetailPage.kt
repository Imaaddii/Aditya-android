package com.exobe.Activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Adaptor.ServiceDetailsAdapter
import com.exobe.ModelClass.cat
import com.exobe.ModelClass.subCat
import com.exobe.R

class ServiceDetailPage(var flag : String) : Fragment() {

    lateinit var proceedtorequest : Button
    lateinit var backProductDesc : ImageView
    lateinit var serviceReview : LinearLayout
    lateinit var mainHeader: RelativeLayout
    lateinit var tv_selectservices: TextView

    lateinit var ServiceDetailsRecycler:RecyclerView
    var catData:ArrayList<cat> = ArrayList()
    var subArrayData = ArrayList<subCat>()
    var subArrayData1 = ArrayList<subCat>()

    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_retailer_homepage, container, false)

        var view = inflater.inflate(R.layout.activity_service_detail_page, container, false)
        proceedtorequest = view.findViewById(R.id.proceedtorequest)
        backProductDesc = view.findViewById(R.id.backProductDesc)
        ServiceDetailsRecycler = view.findViewById(R.id.ServiceDetailsRecycler)
        tv_selectservices = view.findViewById(R.id.tv_selectservices)
        serviceReview = view.findViewById(R.id.service_review)
        mainHeader = activity?.findViewById(R.id.RelativeLayout)!!
        mainHeader.visibility = View.GONE
        catData.clear()
        subArrayData.clear()
        subArrayData1.clear()
        subArrayData.add(subCat("Window AC Service","R299.00 /unit"))
        subArrayData.add(subCat("Split AC Service","R399.00 /unit"))
        subArrayData.add(subCat("Switch Repair","R199.00 /per switch"))
        subArrayData.add(subCat("Fan Replacement","R999.00 /unit"))

        catData.add(cat("Electrical",subArrayData))
        if(flag.equals("service")) {
        } else {
        }
        backProductDesc.setOnClickListener{
            fragmentManager?.popBackStack()
        }

        serviceReview.setOnClickListener{

            fragmentManager?.beginTransaction()?.replace(R.id.FrameLayout, Review(),"Review")?.addToBackStack(null)?.commit()

        }

        proceedtorequest.setOnClickListener {

             fragmentManager?.beginTransaction()
                    ?.replace(R.id.FrameLayout, Service_Request(), "serviceRequest")
                    ?.addToBackStack(null)?.commit()
            }



        ServiceDetailsRecycler.layoutManager = LinearLayoutManager(activity)
        ServiceDetailsRecycler.adapter = ServiceDetailsAdapter(requireContext(), catData)



        return view
    }

}