package com.internshala.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        println("onCreate method called!")
    }

    override fun onStart() {
        super.onStart()
        println("onStart method called!")
    }

    override fun onResume() {
        super.onResume()
        println("onResume method called!")
    }

    override fun onPause() {
        super.onPause()
        println("onPause method called!")
    }

    override fun onStop() {
        super.onStop()
        println("onStop method called!")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart method called!")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy method called!")
    }
}