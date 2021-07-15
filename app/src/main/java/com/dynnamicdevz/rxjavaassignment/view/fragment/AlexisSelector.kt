package com.dynnamicdevz.rxjavaassignment.view.fragment

import com.dynnamicdevz.rxjavaassignment.model.data.AlexisResponseItem

interface AlexisSelector {
    fun openDetailsFragment(result: AlexisResponseItem)
}