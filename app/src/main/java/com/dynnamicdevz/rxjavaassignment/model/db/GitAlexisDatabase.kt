package com.dynnamicdevz.rxjavaassignment.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dynnamicdevz.rxjavaassignment.model.data.AlexisCache
import com.dynnamicdevz.rxjavaassignment.util.Constants.Companion.DATABASE_NAME

@Database(version = 1,entities = [AlexisCache::class])
abstract class GitAlexisDatabase: RoomDatabase() {

    abstract fun getDAO():GitAlexisDAO
    companion object{
        lateinit var gitAlexisDatabase: GitAlexisDatabase
        fun initializeDatabase(context: Context){
            gitAlexisDatabase = Room.databaseBuilder(
                context,
                GitAlexisDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
        fun getDao() = gitAlexisDatabase.getDAO()
    }
}