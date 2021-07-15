package com.dynnamicdevz.rxjavaassignment.util

import com.dynnamicdevz.rxjavaassignment.di.component.AlexisComponent
import com.dynnamicdevz.rxjavaassignment.network.AlexisRetrofit

class AlexisSingleton {
    companion object{
        lateinit var alexisComponent: AlexisComponent
        //lateinit var alexisComponent: AlexisComponent
    }
}