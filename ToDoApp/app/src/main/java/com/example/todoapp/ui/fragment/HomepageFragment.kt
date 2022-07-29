package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.ui.adapter.TasksAdapter
import com.example.todoapp.databinding.FragmentHomepageBinding
import com.example.todoapp.data.entity.Tasks
import com.example.todoapp.ui.viewmodel.HomepageFragmentViewModel
import com.example.todoapp.util.useTransition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var design:FragmentHomepageBinding
    private lateinit var viewModel: HomepageFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_homepage, container, false)

        design.homepageFragment = this
        design.homepageToolbarTitle = "To Do List"
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarHomepage)


        viewModel.tasksList.observe(viewLifecycleOwner){
            val adapter = TasksAdapter(requireContext(),it,viewModel)
            design.tasksAdapter = adapter
        }
        return design.root
    }

    fun fabClick(v:View) {
        Navigation.useTransition(v,R.id.registerTransition)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:HomepageFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.tasksInstall()
    }

}