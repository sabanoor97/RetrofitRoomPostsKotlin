package com.example.retrofitroom

import android.app.Application

class MyApp : Application() {
    companion object {
        lateinit var application: MyApp
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}