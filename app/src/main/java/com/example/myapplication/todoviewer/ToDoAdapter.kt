package com.example.myapplication.todoviewer

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.example.myapplication.database.ToDo
import com.example.myapplication.databinding.SingleTodoItemBinding
import com.example.myapplication.generated.callback.OnClickListener
import kotlin.coroutines.coroutineContext

class ToDoAdapter(private val onClickListener: OnTodoClickListener) : ListAdapter<ToDo, ToDoAdapter.ViewHolder>(ToDoDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(getItem(position))
        }
        holder.bind(item)
    }


    class ViewHolder private constructor(val binding: SingleTodoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ToDo) {
//            val res = itemView.context.resources
            binding.testingtextviewhaha.text = item.nameOfTodo
            binding.importantIndicator.setImageResource(
                when(item.prioOfTodo){
                    true -> R.drawable.ic_baseline_important_36
                    else -> R.drawable.ic_baseline_important_invi_36
                }
            )
            if (item.statusOfTodo){
                binding.testingtextviewhaha.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                binding.testingtextviewhaha.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }


        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SingleTodoItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class ToDoDiffCallBack : DiffUtil.ItemCallback<ToDo>() {
    override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
        return oldItem.todoId == newItem.todoId
    }

    override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
        return oldItem == newItem
    }

}

class OnTodoClickListener(val clickListener: (todo: ToDo) -> Unit) {
    fun onClick(todo: ToDo) = clickListener(todo)
}