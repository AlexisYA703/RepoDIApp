package com.dynnamicdevz.rxjavaassignment.model

import com.dynnamicdevz.rxjavaassignment.model.data.AlexisCache
import com.dynnamicdevz.rxjavaassignment.model.data.AlexisResponse
import com.dynnamicdevz.rxjavaassignment.model.db.GitAlexisDatabase.Companion.getDao
import com.dynnamicdevz.rxjavaassignment.network.AlexisRetrofit
import com.dynnamicdevz.rxjavaassignment.util.Constants.Companion.CACHE_KEY
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlexisRepository @Inject constructor(private val alexisRetrofit: AlexisRetrofit) {

    //Reading from online repo
    fun readFromRemoteSource(): Single<AlexisResponse> = alexisRetrofit.getRepositoriesRemote()

    //Reading from cache
    fun readFromCache(): AlexisResponse{
        val cache = getDao().readFromCache()
        val data = Gson().fromJson(cache.data, AlexisResponse::class.java)
        return data
    }

    fun saveToCache(response: AlexisResponse){
        val gson = Gson()
        val json = gson.toJson(response)
        getDao().cacheData(AlexisCache(CACHE_KEY, json))
    }
}