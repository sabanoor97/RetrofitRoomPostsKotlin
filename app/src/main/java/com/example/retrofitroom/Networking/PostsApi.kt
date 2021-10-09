package com.example.retrofitroom.Networking

import com.example.retrofitroom.PostDataModel
import retrofit2.Call
import retrofit2.http.GET

interface PostsApi {

    @GET("posts/")
    fun getAllPosts(): Call<List<PostDataModel>>

    @GET("photos/")
    fun getAllPhotos(): Call<List<PostDataModel>>

}
