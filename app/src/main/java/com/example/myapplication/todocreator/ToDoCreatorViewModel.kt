package com.example.myapplication.todocreator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoCreatorViewModel : ViewModel() {
    val _navigateToToDoViewer = MutableLiveData<Boolean>()

    val navigateToToDoViewer : LiveData<Boolean>
        get() =_navigateToToDoViewer

    fun onCancel() {
        _navigateToToDoViewer.value = true
    }
}