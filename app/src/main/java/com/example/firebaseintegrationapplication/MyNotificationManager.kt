package com.example.firebaseintegrationapplication


import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import androidx.core.app.NotificationCompat


class MyNotificationManager private constructor(context: Context) {
    private val mCtx: Context = context

    @SuppressLint("UnspecifiedImmutableFlag")
    fun displayNotification(title: String?, body: String?) {
        val mBuilder: NotificationCompat.Builder =
            NotificationCompat.Builder(mCtx, Constants.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(body)


        /*
        *  Clicking on the notification will take us to this intent
        *  Right now we are using the MainActivity as this is the only activity we have in our application
        *  But for your project you can customize it as you want
        * */
        val resultIntent = Intent(mCtx, MainActivity::class.java)

        /*
        *  Now we will create a pending intent
        *  The method getActivity is taking 4 parameters
        *  All parameter are describing themselves
        *  0 is the request code (the second parameter)
        *  We can detect this code in the activity that will open by this we can get
        *  Which notification opened the activity
        * */
        val pendingIntent =
            PendingIntent.getActivity(mCtx, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        /*
        *  Setting the pending intent to notification builder
        * */mBuilder.setContentIntent(pendingIntent)
        val mNotifyMgr = mCtx.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        /*
        * The first parameter is the notification id
        * better don't give a literal here (right now we are giving a int literal)
        * because using this id we can modify it later
        * */
        mNotifyMgr.notify(1, mBuilder.build())
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var mInstance: MyNotificationManager? = null
        @Synchronized
        fun getInstance(context: Context): MyNotificationManager? {
            if (mInstance == null) {
                mInstance = MyNotificationManager(context)
            }
            return mInstance
        }
    }

}

