package com.example.firebaseintegrationapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class LogActivity : AppCompatActivity() {
    private val TAG = "MyActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)
        Log.i("data", "onCreate called")    //Log turns red -> Alt+Enter
    }

    override fun onStart() {
        super.onStart()
        Log.i("data", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("data", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("data", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("data", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("data", "onDestroy called")

        //log.i(tag,msg)
    }
}
