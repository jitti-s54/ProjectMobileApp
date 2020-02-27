package com.example.petlover.ui.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.petlover.R
import androidx.recyclerview.widget.RecyclerView
//import com.example.petlover.Chat


class ChatAdapter (private val modelChatModel: ArrayList<ChatModel>): RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_chat, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return modelChatModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ChatModel = modelChatModel[position]
        holder.username.text = model.username
        holder.message.text = model.msg
        holder.time.text = model.time
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        init {}
        val username = itemView.findViewById(R.id.username) as TextView
        val message = itemView.findViewById(R.id.message) as TextView
        val time = itemView.findViewById(R.id.time) as TextView
    }
}