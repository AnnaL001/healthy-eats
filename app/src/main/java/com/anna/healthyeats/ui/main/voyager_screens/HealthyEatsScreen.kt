package com.anna.healthyeats.ui.main.voyager_screens

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.androidx.AndroidScreen

abstract class HealthyEatsScreen<S: AppStateScreenModel>: AndroidScreen() {
  @Composable
  abstract fun ScreenContentWithState(screenModel: S)
}