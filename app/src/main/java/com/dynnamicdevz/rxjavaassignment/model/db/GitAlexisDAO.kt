package com.dynnamicdevz.rxjavaassignment.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.dynnamicdevz.rxjavaassignment.model.data.AlexisCache
import com.dynnamicdevz.rxjavaassignment.util.Constants.Companion.CACHE_KEY

@Dao
interface GitAlexisDAO {

    @Insert(onConflict = REPLACE)
    fun cacheData(data: AlexisCache)

    @Query("SELECT * FROM git_alexis_cache WHERE cache_id = $CACHE_KEY")
    fun readFromCache(): AlexisCache

}