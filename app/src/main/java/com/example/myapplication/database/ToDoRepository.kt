package com.example.myapplication.database

import androidx.lifecycle.LiveData


class ToDoRepository (private val toDoDatabaseDao: ToDoDatabaseDao) {

    suspend fun get(key: Long): ToDo? = toDoDatabaseDao.get(key)

    suspend fun insert(toDo: ToDo) = toDoDatabaseDao.insert(toDo)

    fun getAllTodos(): LiveData<List<ToDo>> = toDoDatabaseDao.getAllTodos()

    suspend fun deleteAllDone() = toDoDatabaseDao.deleteAllDone()

    suspend fun deleteToDo(key: Long) = toDoDatabaseDao.deleteToDo(key)

    suspend fun update(todo: ToDo) = toDoDatabaseDao.update(todo)
}