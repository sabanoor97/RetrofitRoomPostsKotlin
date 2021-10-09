package com.example.retrofitroom

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitroom.Adapter.PostItemAdapter

class MainActivity : AppCompatActivity() {
    lateinit var postAdapter: PostItemAdapter
    private lateinit var postsRV: RecyclerView
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        postViewModel.getUser()
        postViewModel.getLiveUsers()?.observe(this, {

            it?.let {
                Log.e("all_users", "${it.size}")

                if (this::postAdapter.isInitialized) {
                    postAdapter.submitList(it)

                }
            }
        })
    }

    private fun initUI() {
        postsRV = findViewById(R.id.postsRV)
        postAdapter = PostItemAdapter(this)
        postsRV.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            itemAnimator = DefaultItemAnimator()
        }

    }
}