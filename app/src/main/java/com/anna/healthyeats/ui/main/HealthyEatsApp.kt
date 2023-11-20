package com.anna.healthyeats.ui.main

import android.app.Application
import com.anna.healthyeats.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class HealthyEatsApp: Application(){
  override fun onCreate() {
    super.onCreate()

    if (BuildConfig.DEBUG){
      Timber.plant(Timber.DebugTree())
    }
  }
}