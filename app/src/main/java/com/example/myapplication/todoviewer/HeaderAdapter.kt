package com.example.myapplication.todoviewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val headerCountTextView: TextView = itemView
            .findViewById(R.id.todo_count_header_text)

        fun bind(todoCount: Int) {
            headerCountTextView.text = todoCount.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.header_layout, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 1
    }
}