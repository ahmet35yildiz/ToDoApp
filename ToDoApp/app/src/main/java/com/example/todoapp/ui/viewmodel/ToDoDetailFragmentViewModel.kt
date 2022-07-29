package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.TasksDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToDoDetailFragmentViewModel @Inject constructor(var trepo:TasksDaoRepository) : ViewModel() {
    fun update(task_id:Int,task_name:String){
        trepo.taskUpdate(task_id, task_name)
    }
}