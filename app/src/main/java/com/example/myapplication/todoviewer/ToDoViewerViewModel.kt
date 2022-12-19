package com.example.myapplication.todoviewer

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import com.example.myapplication.database.ToDo
import com.example.myapplication.database.ToDoDatabaseDao
import kotlinx.coroutines.launch

class ToDoViewerViewModel(
    private val dataSource: ToDoDatabaseDao,
    private val application: Application) : ViewModel() {


    val allToDos = dataSource.getAllTodos()

    private var status = false

    private val _navigateToToDoCreator = MutableLiveData<Boolean>()

    val navigateToToDoCreator : LiveData<Boolean>
        get() =_navigateToToDoCreator

    fun onNewTodo() {
        _navigateToToDoCreator.value = true
    }

    fun onClearAll() {
        viewModelScope.launch {
            dataSource.deleteAllDone()
            showToast("Deleted completed ToDos :)")
        }
    }

    fun onClickTodo(todo: ToDo) {
        status = todo.statusOfTodo
        status =! status
        viewModelScope.launch {
            dataSource.update(ToDo(todoId = todo.todoId, nameOfTodo = todo.nameOfTodo,
                prioOfTodo = todo.prioOfTodo, statusOfTodo = status))
        }
    }


    private fun showToast(str: String) {
        Toast.makeText(this.application, str, Toast.LENGTH_SHORT).show()
    }

}