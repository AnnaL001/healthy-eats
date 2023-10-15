package com.anna.healthyeats.ui.screens.ui.auth.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoginScreenPreview() {
  val email = remember { mutableStateOf("") }
  val password = remember { mutableStateOf("") }
  val onClick = {}

  HealthyEatsTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
      LoginScreen(email, password, onClick)
    }
  }
}