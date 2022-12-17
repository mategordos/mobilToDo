package com.example.myapplication.todoviewer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.database.ToDoDatabaseDao

class ToDoViewerViewModel(
//    dataSource: ToDoDatabaseDao,
    application: Application) : AndroidViewModel(application) {

    val _navigateToToDoCreator = MutableLiveData<Boolean>()

    val navigateToToDoCreator : LiveData<Boolean>
        get() =_navigateToToDoCreator

    fun onNewTodo() {
        _navigateToToDoCreator.value = true
    }

}