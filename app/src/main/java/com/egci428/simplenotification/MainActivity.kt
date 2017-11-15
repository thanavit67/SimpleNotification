package com.egci428.simplenotification

import android.app.Activity
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendBtn.setOnClickListener(){
            var intent = Intent(this@MainActivity, ReceiverActivity::class.java)
            var pIntent = PendingIntent.getActivity(this@MainActivity,System.currentTimeMillis().toInt(), intent, 0)

            var intent2 = Intent(this@MainActivity, SettingActivity::class.java)
            var pIntent2 = PendingIntent.getActivity(this@MainActivity,System.currentTimeMillis().toInt(),intent2,0)

            var intent3 = Intent(this@MainActivity, WarningActivity::class.java)
            var pIntent3 = PendingIntent.getActivity(this@MainActivity,System.currentTimeMillis().toInt(),intent3,0)

            var callAction = NotificationCompat.Action.Builder(R.drawable.ic_launcher_background,"Call",pIntent).build()

            var SettingAction = NotificationCompat.Action.Builder(R.drawable.ic_launcher_background,"Setting",pIntent2).build()

            var WarningAction = NotificationCompat.Action.Builder(R.drawable.ic_launcher_background,"Warning",pIntent3).build()

            var builder = NotificationCompat.Builder(this@MainActivity)
            builder.setSmallIcon((R.drawable.abc_edit_text_material))
            builder.setContentTitle("Mail from egco428")
            builder.setContentText("Here is notification message")
            builder.addAction(callAction)
            builder.addAction(SettingAction)
            builder.addAction(WarningAction)
            builder.setWhen(System.currentTimeMillis()+10)

            var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(0,builder.build())
        }
    }
}
