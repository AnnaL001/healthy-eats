package com.anna.healthyeats.ui.screens.ui.auth.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
  val email = remember { mutableStateOf("") }
  val password = remember { mutableStateOf("") }
  val confirmPassword = remember { mutableStateOf("") }
  val onClick = {  }


  HealthyEatsTheme {
    SignupScreen(email, password, confirmPassword, onClick)
  }
}