package com.dynnamicdevz.rxjavaassignment.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dynnamicdevz.rxjavaassignment.databinding.ListRepoFragmentLayoutBinding
import com.dynnamicdevz.rxjavaassignment.databinding.ListRepoItemLayoutBinding
import com.dynnamicdevz.rxjavaassignment.model.data.AlexisResponseItem
import com.dynnamicdevz.rxjavaassignment.util.ViewType
import com.dynnamicdevz.rxjavaassignment.view.activity.MainActivity
import com.dynnamicdevz.rxjavaassignment.view.adapter.AlexisAdapter
import com.dynnamicdevz.rxjavaassignment.viewmodel.alexisViewModel

class ListRepoFragment: Fragment(), AlexisAdapter.AlexisDelegate {

    private lateinit var binding: ListRepoFragmentLayoutBinding
    private val viewModel by activityViewModels<alexisViewModel>()
    private val adapter = AlexisAdapter(ViewType.lIST,this)

    private lateinit var alexisSelector: AlexisSelector

    override fun onAttach(context: Context) {
        super.onAttach(context)
        alexisSelector = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListRepoFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listRecyclerview.adapter = adapter
        viewModel.alexisData.observe(viewLifecycleOwner,{
            adapter.listResults = it
        })
    }

    override fun selectRepo(result: AlexisResponseItem) {
        alexisSelector.openDetailsFragment(result)
    }

}