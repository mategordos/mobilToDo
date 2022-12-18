package com.example.myapplication.todoviewer

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.database.ToDoDatabaseDao

class ToDoViewerViewModelFactory(
        private val dataSource: ToDoDatabaseDao,
        private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ToDoViewerViewModel::class.java)) {
            return ToDoViewerViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}