package com.example.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.databinding.CardDesignBinding
import com.example.todoapp.data.entity.Tasks
import com.example.todoapp.ui.fragment.HomepageFragmentDirections
import com.example.todoapp.ui.viewmodel.HomepageFragmentViewModel
import com.example.todoapp.util.useTransition
import com.google.android.material.snackbar.Snackbar

class TasksAdapter(var mContext:Context,
                   var tasksList:List<Tasks>,
                   var viewModel: HomepageFragmentViewModel) : RecyclerView.Adapter<TasksAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(design:CardDesignBinding) : RecyclerView.ViewHolder(design.root) {
        var design:CardDesignBinding

        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design:CardDesignBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_design, parent , false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val task = tasksList.get(position)
        val d = holder.design
        d.taskObject = task

        d.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"'${task.task_name}' silinsin mi?",Snackbar.LENGTH_LONG).setAction("EVET"){
                viewModel.delete(task.task_id)
            }.show()
        }

        d.cardViewTask.setOnClickListener {
            val transition = HomepageFragmentDirections.detailTransition(task = task)
            Navigation.useTransition(it,transition)
        }
    }

    override fun getItemCount(): Int {
        return tasksList.size
    }

}