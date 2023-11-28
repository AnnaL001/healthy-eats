package com.anna.healthyeats.ui.screens.ui.user_details.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.anna.healthyeats.ui.theme.HealthyEatsTheme


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun UserDetailsScreenPreview(){
  val name = remember { mutableStateOf("") }
  val selectedDiets = remember { mutableStateOf(listOf<String>()) }
  val selectedHealthPref = remember { mutableStateOf(listOf<String>()) }
  val selectedCuisine = remember { mutableStateOf(listOf<String>()) }

  HealthyEatsTheme {
    UserDetailsScreenUI(
      name = name,
      selectedDiets = selectedDiets,
      selectedHealthPref = selectedHealthPref,
      selectedCuisine = selectedCuisine)
  }
}