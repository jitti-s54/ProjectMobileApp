package com.example.petlover.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.petlover.Bottomnavigation
import com.example.petlover.EditActivity
import com.example.petlover.R
import com.example.petlover.User
import com.example.petlover.ui.user.UserFragment
import kotlinx.android.synthetic.main.layout_list_item.view.*

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
        holder.textGender.setImageResource(user.gender)
//        holder.textDate.text = user.date
        holder.textContact.text = user.contact
        holder.textViewAddress.text = user.place
        holder.imgIcon.setImageResource(user.icon)
        holder.imgStatus.setImageResource(user.status)
        holder.itemView.setOnClickListener { View.OnClickListener {
//            Toast.makeText(parent.context, "Click: "+ user.name , Toast.LENGTH_LONG).show()
        } }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.cardView.setOnClickListener {
                Toast.makeText(itemView.context,"Click",Toast.LENGTH_SHORT).show()
                val intent = Intent(itemView.context, UserFragment::class.java)
                itemView.context.startActivity(intent)
            }
        }
        val textViewName = itemView.findViewById(R.id.text_name) as TextView
        val textGender = itemView.findViewById(R.id.gender) as ImageButton
        val textViewAddress = itemView.findViewById(R.id.place) as TextView
        val textContact = itemView.findViewById(R.id.contact) as TextView
        val imgIcon = itemView.findViewById(R.id.iconType) as ImageButton
        val imgStatus = itemView.findViewById(R.id.iconStatus) as ImageButton

    }
}
