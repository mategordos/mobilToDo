package com.example.myapplication.todocreator

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.database.ToDoDatabase
import com.example.myapplication.databinding.FragmentTodoCreatorBinding

class ToDoCreatorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTodoCreatorBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_todo_creator, container,false
        )
        val application = requireNotNull(this.activity).application

        val dataSource = ToDoDatabase.getInstance(application).todoDatabaseDao
        val viewModelFactory = ToDoCreatorViewModelFactory(dataSource, application)
        val toDoCreatorViewModel = ViewModelProvider(this, viewModelFactory).get(ToDoCreatorViewModel::class.java)
        binding.lifecycleOwner = this
        binding.todoCreatorViewModel = toDoCreatorViewModel

        toDoCreatorViewModel.navigateToToDoViewer.observe(viewLifecycleOwner) {
            if (it == true){
                this.findNavController().navigate(ToDoCreatorFragmentDirections.actionToDoCreatorFragmentToToDoViewerFragment())
            }
        }

        return binding.root
    }
}