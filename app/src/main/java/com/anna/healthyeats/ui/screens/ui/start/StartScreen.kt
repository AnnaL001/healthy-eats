package com.anna.healthyeats.ui.screens.ui.start

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.anna.healthyeats.ui.screens.ui.auth.login.LoginScreen
import com.anna.healthyeats.ui.screens.ui.start.ui.StartScreenUI
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

class StartScreen: AndroidScreen() {
  @Composable
  override fun Content() {
    val navigator = LocalNavigator.currentOrThrow

    // Navigation to login
    val onClick = { navigator.push(LoginScreen()) }

    HealthyEatsTheme {
      Surface(modifier = Modifier.fillMaxSize()) {
        StartScreenUI {
          onClick()
        }
      }
    }
  }

}