package com.example.retrofitroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PostDataModel::class], version = 1, exportSchema = false)
abstract class PostDB : RoomDatabase() {
    abstract fun postDao(): PostDao

    companion object {
        private var instance: PostDB? = null

        @Synchronized
        fun getInstance(ctx: Context): PostDB {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext, PostDB::class.java,
                    "note_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

            return instance!!
        }
    }
}
