package com.example.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="list_of_todos_table")
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    var todoId: Long = 0L,
    @ColumnInfo(name = "nameOfTodo")
    var nameOfTodo: String,
    @ColumnInfo(name = "prioOfTodo")
    var prioOfTodo: Boolean = false,
    @ColumnInfo(name = "statusOfTodo")
    var statusOfTodo: Boolean = false
)