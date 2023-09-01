package com.anna.healthyeats.ui.components.forms.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics

fun Modifier.healthyEatsField(isError: Boolean?, errorMessage: String?, modifier: Modifier): Modifier {
  return this.then(
    modifier
      .semantics {
        if (isError == true) errorMessage?.let { e -> error(e) }
      }
      .fillMaxWidth())
}



