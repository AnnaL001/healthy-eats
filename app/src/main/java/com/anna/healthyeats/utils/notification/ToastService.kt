package com.anna.healthyeats.utils.notification

import android.content.Context
import android.widget.Toast

/**
 * Service to handle display of toasts
 */
object ToastService {

  /**
   * Display toast for a long/short period of time
   * @param context Screen context
   * @param message Message to be displayed
   * @param isShort True - Short period, False - Long period
   */
  fun showToast(context: Context, message: String, isShort: Boolean){
    val timeLength = if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG
    Toast.makeText(context, message, timeLength).show()
  }
}