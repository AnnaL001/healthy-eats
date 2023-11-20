package com.anna.healthyeats.utils.firebase

import com.google.android.gms.tasks.Task
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resumeWithException

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun <T> Task<T>.await(): T {
  return suspendCancellableCoroutine { cancellableCont ->
    addOnCompleteListener { task ->
      if (task.exception != null) {
        cancellableCont.resumeWithException(task.exception!!)
      } else {
        cancellableCont.resume(task.result, null)
      }
    }
  }
}