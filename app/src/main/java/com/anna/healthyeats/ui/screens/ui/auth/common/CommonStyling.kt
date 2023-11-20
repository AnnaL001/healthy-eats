package com.anna.healthyeats.ui.screens.ui.auth.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.anna.healthyeats.ui.theme.HealthyEatsBlack
import com.anna.healthyeats.ui.theme.HealthyEatsGreen


@Composable
fun boldGreenStyling(): TextStyle {
  return MaterialTheme.typography.headlineMedium.copy(
    fontWeight = FontWeight.Bold,
    color = HealthyEatsGreen  // TO DO: Check why material theme colors not working
  )
}

@Composable
fun normalStyling(): TextStyle{
  return MaterialTheme.typography.titleMedium.copy(
    color = HealthyEatsBlack // TO DO: Check why material theme colors not working
  )
}

@Composable
fun boldGreenTitleStyling(): TextStyle{
  return MaterialTheme.typography.headlineLarge.copy(
    color = HealthyEatsGreen, // TO DO: Check why material theme colors not working
  )
}

@Composable
fun subtitleStyling(): TextStyle{
  return MaterialTheme.typography.titleLarge.copy(
    fontWeight = FontWeight.Light
  )
}