package com.example.myapplication.todoviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.database.ToDoDatabase
import com.example.myapplication.database.ToDoDatabaseDao
import com.example.myapplication.databinding.FragmentTodoViewerBinding
import com.example.myapplication.todocreator.ToDoCreatorFragment

class ToDoViewerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentTodoViewerBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_todo_viewer, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = ToDoDatabase.getInstance(application).todoDatabaseDao
        val viewModelFactory = ToDoViewerViewModelFactory(dataSource, application)
        val toDoViewerViewModel = ViewModelProvider(this, viewModelFactory).get(ToDoViewerViewModel::class.java)
        binding.lifecycleOwner = this
        binding.todoViewerViewModel = toDoViewerViewModel

        toDoViewerViewModel.navigateToToDoCreator.observe(viewLifecycleOwner) {
            if (it == true){
                this.findNavController().navigate(ToDoViewerFragmentDirections.actionToDoViewerFragmentToToDoCreatorFragment())
            }
        }

        return binding.root
    }

}