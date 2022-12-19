package com.example.myapplication.todoviewer

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.database.ToDoDatabaseDao
import com.example.myapplication.database.ToDoRepository

class ToDoViewerViewModelFactory(
        private val repository: ToDoRepository,
        private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ToDoViewerViewModel::class.java)) {
            return ToDoViewerViewModel(repository, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}