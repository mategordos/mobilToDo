package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoDatabaseDao {
    @Query("SELECT * FROM list_of_todos_table WHERE todoId = :key")
    suspend fun get(key: Long): ToDo?

    @Insert
    suspend fun insert(toDo: ToDo)

    @Query("SELECT * FROM list_of_todos_table ORDER BY todoId DESC")
    fun getAllTodos(): LiveData<List<ToDo>>

    @Query("DELETE FROM list_of_todos_table WHERE statusOfTodo = 1")
    suspend fun deleteAllDone()

    @Query("DELETE FROM list_of_todos_table WHERE todoId = :key")
    suspend fun deleteToDo(key: Long) : Unit

    @Update
    suspend fun update(todo: ToDo)

}