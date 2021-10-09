package com.example.retrofitroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostDataModel(

    @ColumnInfo
    var userId: Int,

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo
    var title: String,

    @ColumnInfo
    var body: String,
)