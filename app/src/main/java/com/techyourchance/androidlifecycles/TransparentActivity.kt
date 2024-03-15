package com.techyourchance.androidlifecycles

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import timber.log.Timber

class TransparentActivity : AppCompatActivity() {

    private lateinit var backgroundDetector: BackgroundDetector
    override fun onCreate(savedInstanceState: Bundle?) {

        Timber.i("onCreate()")

        val application = this.application

        super.onCreate(savedInstanceState)

        backgroundDetector = (application as CustomApplication).backgroundDetector

        setContentView(R.layout.activity_transparent)
    }

    override fun onDestroy() {
        Timber.i("onDestroy")
        super.onDestroy()
    }

    override fun onStart() {
        Timber.i("onStart")
        super.onStart()
        backgroundDetector.activityStarted()
    }

    override fun onStop() {
        Timber.i("onStop")
        super.onStop()
        backgroundDetector.activityStopped()
    }

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, TransparentActivity::class.java)
            context.startActivity(intent)
        }
    }
}
