package com.example.myapplication.todocreator

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.myapplication.database.ToDo
import com.example.myapplication.database.ToDoDatabaseDao
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class ToDoCreatorViewModel(
    val database: ToDoDatabaseDao,
    val application: Application
) : ViewModel() {
    val _navigateToToDoViewer = MutableLiveData<Boolean>()

    var setChecked = false
    val inputData = MutableLiveData<String>()




    val navigateToToDoViewer : LiveData<Boolean>
        get() =_navigateToToDoViewer

    fun onCancel() {
        viewModelScope.launch {
            _navigateToToDoViewer.value = true
        }
    }

    fun onOkButtonClicked(toDoName: String?) {
        if (toDoName.isNullOrEmpty()) {
            showToast("You have to set a ToDo name!")
            return
        } else {
            viewModelScope.launch {
                database.insert(ToDo(nameOfTodo = toDoName, prioOfTodo = setChecked, statusOfTodo = false, ))
                showToast("ToDo successfully added!")
                _navigateToToDoViewer.value = true
            }
        }
    }

    fun setImportantTrue() {
        viewModelScope.launch {
            setChecked = true
        }
    }


    fun setImportantFalse() {
        viewModelScope.launch {
            setChecked = false
            showToast("IMPORTANT IS FALSE")
        }
    }

     fun showToast(str: String) {
        Toast.makeText(this.application, str, Toast.LENGTH_SHORT).show()
    }
}