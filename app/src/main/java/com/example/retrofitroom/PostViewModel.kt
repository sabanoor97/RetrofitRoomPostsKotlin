package com.example.retrofitroom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitroom.Networking.PostRepository

class PostViewModel : ViewModel() {

    private var _localposts = MutableLiveData<List<PostDataModel>>()
    var localPosts: LiveData<List<PostDataModel>> = _localposts

    fun getUser() {
        PostRepository().getInstance()?.getUsers()
    }

    fun getLiveUsers(): LiveData<List<PostDataModel>>? {
        return PostRepository().getInstance()?.getAllUsersLive()
    }
}