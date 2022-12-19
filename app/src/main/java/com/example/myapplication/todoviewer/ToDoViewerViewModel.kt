package com.example.myapplication.todoviewer

import android.app.Application
import androidx.lifecycle.*
import com.example.myapplication.database.ToDoDatabaseDao
import kotlinx.coroutines.launch

class ToDoViewerViewModel(
    private val dataSource: ToDoDatabaseDao,
    application: Application) : AndroidViewModel(application) {


    val allToDos = dataSource.getAllTodos()


    val _navigateToToDoCreator = MutableLiveData<Boolean>()

    val navigateToToDoCreator : LiveData<Boolean>
        get() =_navigateToToDoCreator

    fun onNewTodo() {
        _navigateToToDoCreator.value = true
    }

    fun onClearAll() {
        viewModelScope.launch {
            dataSource.deleteAll()
        }
    }

}