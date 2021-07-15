package com.dynnamicdevz.rxjavaassignment.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "git_alexis_cache")
data class AlexisCache(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "cache_id")
    val cacheID: Int,

    @ColumnInfo(name = "data")
    val data: String
)
