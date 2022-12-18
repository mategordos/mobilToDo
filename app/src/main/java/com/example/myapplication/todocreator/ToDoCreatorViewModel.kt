package com.example.myapplication.todocreator

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ToDoCreatorViewModel : ViewModel() {
    val _navigateToToDoViewer = MutableLiveData<Boolean>()

    val navigateToToDoViewer : LiveData<Boolean>
        get() =_navigateToToDoViewer

    fun onCancel() {
        viewModelScope.launch {
        _navigateToToDoViewer.value = true
        }
    }
    fun onOkButtonClicked(toDoName: String) {
        if (toDoName.isEmpty())
        {
            return
        }

        viewModelScope.launch {
            _navigateToToDoViewer.value = true
        }

    }

}