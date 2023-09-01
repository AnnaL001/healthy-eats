package com.anna.healthyeats.ui.components.forms.common

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

enum class KeyOptions{
  TEXT_INPUT,
  EMAIL_INPUT,
  PASSWORD_INPUT
}

fun getKeyboard(keyOptions: KeyOptions): KeyboardOptions {
  return KeyboardOptions(
    keyboardType = when(keyOptions){
      KeyOptions.TEXT_INPUT -> KeyboardType.Text
      KeyOptions.EMAIL_INPUT -> KeyboardType.Email
      KeyOptions.PASSWORD_INPUT -> KeyboardType.Password
    },
    imeAction = ImeAction.Done
  )
}


