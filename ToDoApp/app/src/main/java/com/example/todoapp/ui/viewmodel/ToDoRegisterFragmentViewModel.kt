package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.TasksDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToDoRegisterFragmentViewModel @Inject constructor(var trepo:TasksDaoRepository) : ViewModel() {
    fun save(task:String) {
        trepo.taskSave(task)
    }
}