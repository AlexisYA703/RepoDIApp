package com.dynnamicdevz.rxjavaassignment

import android.app.Application
import com.dynnamicdevz.rxjavaassignment.di.component.AlexisComponent
import com.dynnamicdevz.rxjavaassignment.di.component.DaggerAlexisComponent
import com.dynnamicdevz.rxjavaassignment.model.db.GitAlexisDatabase
import com.dynnamicdevz.rxjavaassignment.util.AlexisSingleton

class AlexisApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        GitAlexisDatabase.initializeDatabase(this)
        AlexisSingleton.alexisComponent = DaggerAlexisComponent.create()
        //AlexisSingleton.alexisComponent = DaggerAlexisComponent.create()
    }
}