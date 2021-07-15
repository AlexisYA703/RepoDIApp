package com.dynnamicdevz.rxjavaassignment.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dynnamicdevz.rxjavaassignment.model.AlexisRepository
import com.dynnamicdevz.rxjavaassignment.model.data.AlexisResponseItem
import com.dynnamicdevz.rxjavaassignment.util.AlexisSingleton.Companion.alexisComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class alexisViewModel: ViewModel() {

    val alexisData = MutableLiveData<List<AlexisResponseItem>>()
    //private val repository = AlexisRepository()
    private val comDisposable = CompositeDisposable()

    init {
        comDisposable.add(
            alexisComponent.getRepository().readFromRemoteSource()
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .map{
                    alexisComponent.getRepository().saveToCache(it)
                    Log.d("TAG_X", "Saving to cache- on ${Thread.currentThread().name}")
                    it
                }
                .subscribe({
                    alexisData.postValue(it)

                },{throwable->
                    Log.d("TAG_X","Oops: ${throwable.localizedMessage}")
                    alexisData.postValue(alexisComponent.getRepository().readFromCache())
                })
        )
    }
    override fun onCleared(){
        super.onCleared()
        comDisposable.clear()
    }
}