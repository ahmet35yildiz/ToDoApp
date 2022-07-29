package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.Tasks
import com.example.todoapp.data.repo.TasksDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomepageFragmentViewModel @Inject constructor(var trepo:TasksDaoRepository) : ViewModel() {
    var tasksList = MutableLiveData<List<Tasks>>()

    init {
        tasksInstall()
        tasksList = trepo.showTasks()
    }

    fun search(searchWord:String){
        trepo.taskSearch(searchWord)
    }

    fun delete(task_id:Int) {
        trepo.taskDelete(task_id)
    }

    fun tasksInstall(){
        trepo.allTasks()
    }
}