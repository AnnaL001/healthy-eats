package com.anna.healthyeats.ui.screens.ui.user_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import cafe.adriel.voyager.hilt.getScreenModel
import com.anna.healthyeats.ui.main.voyager_screens.HealthyEatsScreen
import com.anna.healthyeats.ui.screens.ui.user_details.state.UserDetailsScreenModel
import com.anna.healthyeats.ui.screens.ui.user_details.ui.UserDetailsScreenUI
import com.anna.healthyeats.ui.theme.HealthyEatsTheme
import timber.log.Timber

class UserDetailsScreen(): HealthyEatsScreen<UserDetailsScreenModel>() {
  @Composable
  override fun Content() {
    // Screen state
    val screenModel = getScreenModel<UserDetailsScreenModel>()
    val userDetailsState by screenModel.state.collectAsState()
    
    // Screen content
    HealthyEatsTheme {
        ScreenContentWithState(screenModel = screenModel)
    }
  }

  @Composable
  override fun ScreenContentWithState(screenModel: UserDetailsScreenModel) {
    val name = rememberSaveable { mutableStateOf("") }
    val selectedDiets = rememberSaveable { mutableStateOf(listOf<String>()) }
    val selectedHealthPref = rememberSaveable { mutableStateOf(listOf<String>()) }
    val selectedCuisine = rememberSaveable { mutableStateOf(listOf<String>()) }

    val onClick = {
      Timber.d("${selectedDiets.value.size} selected diets")
      Timber.d("${selectedHealthPref.value.size} selected diets")
      Timber.d("${selectedCuisine.value.size} selected diets")
    }

    UserDetailsScreenUI(
      name = name,
      selectedDiets = selectedDiets,
      selectedHealthPref = selectedHealthPref,
      selectedCuisine = selectedCuisine,
      onClick = onClick)
  }
}