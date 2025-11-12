package com.example.countdownactivity

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.*




class CountdownService : Service() {

    companion object{
        const val TAG = "Countdown"
        const val EXTRA_TIME = "extra_seconds"

    }

    private val serviceJob = SupervisorJob()
    private val serviceScope = CoroutineScope(Dispatchers.Default + serviceJob)
    private var currentCountdown:Job?=null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    val seconds = intent?.getIntExtra(EXTRA_TIME,0) ?: 0
    Log.i("CountDown","Start")

    if(seconds <=0){
        Log.i("CountDown","Stoppped")
        stopSelfResult(startId)
        return START_NOT_STICKY

    }
     currentCountdown?.cancel()
     currentCountdown = serviceScope.launch{
         try{
             for(t in seconds downTo 0){
                 Log.i("CountDown","Countdown$t")
                 delay(1000L)
             }
             Log.i("CountDown","Finished")
         }catch(_: CancellationException){
             Log.i("CountDown","Cancelled")
         }
         finally{
             stopSelfResult(startId)

             }
         }
    return START_NOT_STICKY
     }
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy(){
    currentCountdown?.cancel()
    serviceJob.cancel()
    Log.i("CountDown","Service Destroyed")
    super.onDestroy()
    }
}






