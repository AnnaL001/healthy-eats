package com.anna.healthyeats.ui.screens.ui.auth.signup.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.anna.healthyeats.ui.theme.HealthyEatsTheme
import timber.log.Timber

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignupScreenPreview() {
  val email = remember { mutableStateOf("") }
  val password = remember { mutableStateOf("") }
  val confirmPassword = remember { mutableStateOf("") }
  val onClick = { Timber.d("I've been clicked!") }


  HealthyEatsTheme {
    SignupScreenUI(
      email = email,
      password = password,
      confirmPassword = confirmPassword,
      onClick = onClick
    )
  }
}