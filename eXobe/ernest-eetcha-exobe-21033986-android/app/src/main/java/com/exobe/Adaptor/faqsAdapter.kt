package com.exobe.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exobe.Model.faqsModel
import com.exobe.R

class faqsAdapter(
    var context: Context,
    var data: ArrayList<faqsModel>
) : RecyclerView.Adapter<faqsAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_faqs, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userData = data[position]

        holder.titleTC.text = userData.titleTC
        holder.ll_faqs.visibility = if (userData.expand) View.VISIBLE else View.GONE
        holder.downarrow.setOnClickListener {
            userData.expand = !userData.expand
            notifyDataSetChanged()
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val titleTC = view.findViewById<TextView>(R.id.titleTC)
        val ll_faqs = view.findViewById<LinearLayout>(R.id.ll_faqs)
        val downarrow = view.findViewById<LinearLayout>(R.id.downarrow)


    }

}