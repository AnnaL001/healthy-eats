package com.anna.healthyeats.ui.screens.ui.user_details

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.anna.healthyeats.ui.screens.ui.user_details.ui.UserDetailsScreenUI
import com.anna.healthyeats.ui.theme.HealthyEatsTheme
import com.google.firebase.auth.FirebaseUser
import timber.log.Timber

data class UserDetailsScreen(val loggedInUser: FirebaseUser): Screen {
  @Composable
  override fun Content() {
    HealthyEatsTheme {
      Timber.d("User logged in: ${loggedInUser.email}")
      UserDetailsScreenUI()
    }
  }
}