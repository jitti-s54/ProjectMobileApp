package com.example.petlover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter (private val userItems: ArrayList<User>): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: User = userItems[position]
        holder.textViewName.text = user.name
        holder.textViewAddress.text = user.address
        holder.imgIcon.setImageResource(user.icon)
        holder.imgStatus.setImageResource(user.status)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewName = itemView.findViewById(R.id.text_name) as TextView
        val textViewAddress = itemView.findViewById(R.id.text_description) as TextView
        val imgIcon = itemView.findViewById(R.id.iconType) as ImageButton
        val imgStatus = itemView.findViewById(R.id.iconStatus) as ImageButton
    }
}
