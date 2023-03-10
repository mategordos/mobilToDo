package com.example.myapplication.todocreator

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.database.ToDoDatabase
import com.example.myapplication.database.ToDoDatabaseDao
import com.example.myapplication.database.ToDoRepository
import com.example.myapplication.todoviewer.ToDoViewerViewModel

class ToDoCreatorViewModelFactory(
    private val repository: ToDoRepository,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ToDoCreatorViewModel::class.java)) {
            return ToDoCreatorViewModel(repository,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}