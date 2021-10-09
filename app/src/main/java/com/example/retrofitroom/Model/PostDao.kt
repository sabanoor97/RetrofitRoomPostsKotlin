package com.example.retrofitroom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDao {

    @Query("Select * From PostDataModel")
    fun getData(): LiveData<List<PostDataModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllUsers(users: List<PostDataModel>)


}