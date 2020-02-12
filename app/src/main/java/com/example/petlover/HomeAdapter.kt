package com.example.petlover

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.petlover.ui.animaldetail.Animaldetail
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
        holder.textViewAddress.text = user.address
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
                val intent = Intent(itemView.context, EditActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
        val textViewName = itemView.findViewById(R.id.text_name) as TextView
        val textViewAddress = itemView.findViewById(R.id.text_description) as TextView
        val imgIcon = itemView.findViewById(R.id.iconType) as ImageButton
        val imgStatus = itemView.findViewById(R.id.iconStatus) as ImageButton
    }
}
