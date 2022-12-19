package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ToDoDatabaseDao {
    @Query("SELECT * FROM list_of_todos_table WHERE todoId = :key")
    suspend fun get(key: Long): ToDo?

    @Insert
    suspend fun insert(toDo: ToDo)

    @Query("SELECT * FROM list_of_todos_table ORDER BY todoId DESC")
    fun getAllTodos(): LiveData<List<ToDo>>

    @Query("DELETE FROM list_of_todos_table")
    suspend fun deleteAll()

    @Query("DELETE FROM list_of_todos_table WHERE todoId = :key")
    suspend fun deleteToDo(key: Long) : Unit
}