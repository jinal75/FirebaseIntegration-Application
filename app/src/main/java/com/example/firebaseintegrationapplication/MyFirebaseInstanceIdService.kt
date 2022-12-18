package com.example.firebaseintegrationapplication


import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService



class MyFirebaseInstanceIdService : FirebaseMessagingService() {
    private val TAG = "FireBaseMessagingService"
  @SuppressLint("StringFormatInvalid", "LongLogTag")


      override fun onNewToken(token: String) {
      Log.d(TAG, "Refreshed token: $token")

      // If you want to send messages to this application instance or
      // manage this apps subscriptions on the server side, send the
      // FCM registration token to your app server.
      sendRegistrationToServer(token)
  }

     @SuppressLint("LongLogTag")
     private fun sendRegistrationToServer(token: String) {
         Log.d(TAG, "Reg token: $token")

     }


 }


