package com.dynnamicdevz.rxjavaassignment.di.component

import com.dynnamicdevz.rxjavaassignment.model.AlexisRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AlexisComponent {
    fun getRepository():AlexisRepository
}