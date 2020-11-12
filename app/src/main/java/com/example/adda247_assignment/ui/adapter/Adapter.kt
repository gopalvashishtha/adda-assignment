package com.example.adda247_assignment.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adda247_assignment.R

class Adapter(private var names:List<String>,
              private var emails:List<String>,
              private var genders:List<String>,
              private var statuses:List<String>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val name:TextView=itemView.findViewById(R.id.tv_name)
        val email:TextView=itemView.findViewById(R.id.tv_email)
        val gender:TextView=itemView.findViewById(R.id.tv_gender)
        val status:TextView=itemView.findViewById(R.id.tv_status)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
   val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = names[position]
        holder.email.text = emails[position]
        holder.gender.text = genders[position]
        holder.status.text = statuses[position]
    }
}