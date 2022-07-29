package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.databinding.ActivityMainBinding.inflate
import com.example.todoapp.databinding.FragmentToDoRegisterBinding
import com.example.todoapp.ui.viewmodel.ToDoRegisterFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoRegisterFragment : Fragment() {
    private lateinit var design:FragmentToDoRegisterBinding
    private lateinit var viewModel:ToDoRegisterFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_to_do_register, container, false)

        design.toDoRegisterFragment = this
        design.toDoRegisterToolbarTitle = "New Task"

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:ToDoRegisterFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSaveClick(task:String) {
        viewModel.save(task)
    }
}