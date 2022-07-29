package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentToDoDetailBinding
import com.example.todoapp.ui.viewmodel.ToDoDetailFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoDetailFragment : Fragment() {
    private lateinit var design:FragmentToDoDetailBinding
    private lateinit var viewModel: ToDoDetailFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_to_do_detail, container, false)

        design.toDoDetailFragment = this
        design.toDoDetailToolbarTitle = "Task Detail"

        val bundle:ToDoDetailFragmentArgs by navArgs()
        val detailTask = bundle.task

        design.taskObject = detailTask

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:ToDoDetailFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonUpdateClick(task_id:Int,task_name:String){
        viewModel.update(task_id, task_name)
    }
}