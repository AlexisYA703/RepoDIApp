package com.dynnamicdevz.rxjavaassignment.network
import com.dynnamicdevz.rxjavaassignment.model.data.AlexisResponse
import com.dynnamicdevz.rxjavaassignment.util.Constants.Companion.BASE_URL
import com.dynnamicdevz.rxjavaassignment.util.Constants.Companion.END_POINT
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlexisRetrofit @Inject constructor() {

    private val gitAlexisService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(GitAlexisService::class.java)

    fun getRepositoriesRemote() = gitAlexisService.getAllRepositories()

    interface GitAlexisService {
        @GET(END_POINT)
        fun getAllRepositories(): Single<AlexisResponse>
    }
}