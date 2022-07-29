package com.example.todoapp.room

import androidx.room.*
import com.example.todoapp.data.entity.Tasks

@Dao
interface TasksDao {
    @Query("SELECT * FROM tasks")
    suspend fun allTasks() : List<Tasks>

    @Insert
    suspend fun addTask(task:Tasks)

    @Update
    suspend fun updateTask(task: Tasks)

    @Delete
    suspend fun deleteTask(task: Tasks)

    @Query("SELECT * FROM tasks WHERE task_name like '%' || :searchWord || '%'")
    suspend fun searchTask(searchWord : String) : List<Tasks>
}