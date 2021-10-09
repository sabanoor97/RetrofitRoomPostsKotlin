package com.example.retrofitroom.Networking

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.retrofitroom.MyApp
import com.example.retrofitroom.PostDB
import com.example.retrofitroom.PostDataModel
import com.example.retrofitroom.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {
    //val allWords: LiveData<List<PostDataModel>> = postDao!!.getData()
    private var postRepository: PostRepository? = null
    private var db: PostDB? = null
    private var postsApi: PostsApi? = null

    fun getInstance(): PostRepository? {
        if (postRepository == null) {
            postRepository = PostRepository()
            postRepository?.db = PostDB.getInstance(MyApp.application.applicationContext)
            postRepository?.postsApi = RetrofitService.postApi
        }
        return postRepository
    }

    fun getUsers() {
        postsApi?.getAllPosts()?.enqueue(object : Callback<List<PostDataModel>> {
            override fun onResponse(
                call: Call<List<PostDataModel>>,
                response: Response<List<PostDataModel>>
            ) {
                //this is used as another thread
                GlobalScope.launch(Dispatchers.IO) {
                    val mList = response.body()!!
                    db?.postDao()?.saveAllUsers(mList)
                }
            }

            override fun onFailure(call: Call<List<PostDataModel>>, t: Throwable) {
                Log.d("Failed", "Call failed")
            }
        })
    }

    fun getAllUsersLive(): LiveData<List<PostDataModel>>? {
        return db?.postDao()?.getData()
    }
}