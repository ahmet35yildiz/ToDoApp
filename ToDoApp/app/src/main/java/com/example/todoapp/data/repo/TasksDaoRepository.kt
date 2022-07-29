package com.example.todoapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.data.entity.Tasks
import com.example.todoapp.room.TasksDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TasksDaoRepository(var tdao:TasksDao) {
    var tasksList:MutableLiveData<List<Tasks>>

    init {
        tasksList = MutableLiveData()
    }

    fun showTasks() : MutableLiveData<List<Tasks>> {
        return tasksList
    }

    fun taskSave(task:String) {
        val job = CoroutineScope(Dispatchers.Main).launch() {
            val newTask = Tasks(0,task)
            tdao.addTask(newTask)
        }
    }

    fun taskUpdate(task_id:Int,task_name:String){
        val job = CoroutineScope(Dispatchers.Main).launch() {
            val updatedTask = Tasks(task_id,task_name)
            tdao.updateTask(updatedTask)
        }
    }

    fun taskSearch(searchWord:String){
        val job = CoroutineScope(Dispatchers.Main).launch() {
            tasksList.value = tdao.searchTask(searchWord)
        }
    }

    fun taskDelete(task_id:Int) {
        val job = CoroutineScope(Dispatchers.Main).launch() {
            val deletedTask = Tasks(task_id,"")
            tdao.deleteTask(deletedTask)
            allTasks()
        }
    }

    fun allTasks(){
        val job = CoroutineScope(Dispatchers.Main).launch() {
            tasksList.value = tdao.allTasks()
        }
    }
}