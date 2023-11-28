package com.anna.healthyeats.ui.screens.ui.user_details.components.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.anna.healthyeats.ui.components.forms.button.HealthyEatsButton
import com.anna.healthyeats.ui.components.forms.text.HealthyEatsTextField
import com.anna.healthyeats.ui.screens.ui.common.boldGreenStyling
import com.anna.healthyeats.ui.screens.ui.common.normalStyling
import com.anna.healthyeats.ui.screens.ui.user_details.components.list.CuisineList
import com.anna.healthyeats.ui.screens.ui.user_details.components.list.DietList
import com.anna.healthyeats.ui.screens.ui.user_details.components.list.HealthPreferenceList
import com.anna.healthyeats.ui.screens.ui.user_details.ui.UserDetailsScreenResources

@Composable
fun UserDetailsForm(
  name: MutableState<String>,
  selectedDiets: MutableState<List<String>>,
  selectedHealthPref: MutableState<List<String>>,
  selectedCuisine: MutableState<List<String>>,
  isNameError: Boolean = false,
  nameErrorMessage: String = "",
  onClick: () -> Unit
){
  Column(
    modifier = Modifier.padding(
      top = UserDetailsScreenResources.dimenResources()["small_padding"]!!,
      bottom = UserDetailsScreenResources.dimenResources()["medium_padding"]!!,
    ),
    horizontalAlignment = Alignment.CenterHorizontally) {

    Text(
      text = UserDetailsScreenResources.stringResources()["user_details_title"]!!,
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(
        start = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
        end = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
        bottom = UserDetailsScreenResources.dimenResources()["medium_padding"]!!),
      style = boldGreenStyling()
    )

    HealthyEatsTextField(
      inputState = name,
      placeholder = UserDetailsScreenResources.stringResources()["name_placeholder"]!!,
      isError = isNameError,
      errorMessage = nameErrorMessage,
      modifier = Modifier.padding(
        top = UserDetailsScreenResources.dimenResources()["small_padding"]!!,
        start = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
        end = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
        bottom = UserDetailsScreenResources.dimenResources()["medium_padding"]!!
      )
    )

    Text(
      text = UserDetailsScreenResources.stringResources()["select_diet"]!!,
      modifier = Modifier
        .padding(
          start = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
          end = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
          bottom = UserDetailsScreenResources.dimenResources()["xsmall_padding"]!!
        )
        .fillMaxWidth(),
      style = normalStyling()
    )

    DietList(selectedDiets = selectedDiets)

    Text(
      text = UserDetailsScreenResources.stringResources()["select_health_preference"]!!,
      modifier = Modifier
        .padding(
          start = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
          end = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
          bottom = UserDetailsScreenResources.dimenResources()["xsmall_padding"]!!
        )
        .fillMaxWidth(),
      style = normalStyling()
    )

    HealthPreferenceList(selectedHealthPref = selectedHealthPref)

    Text(
      text = UserDetailsScreenResources.stringResources()["select_cuisine"]!!,
      modifier = Modifier
        .padding(
          start = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
          end = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
          bottom = UserDetailsScreenResources.dimenResources()["xsmall_padding"]!!
        )
        .fillMaxWidth(),
      style = normalStyling()
    )

    CuisineList(selectedCuisine = selectedCuisine)

    HealthyEatsButton(
      modifier = Modifier.padding(
        start = UserDetailsScreenResources.dimenResources()["screen_small_padding"]!!,
        end = UserDetailsScreenResources.dimenResources()["screen_small_padding"]!!
      ),
      onClick = onClick,
      buttonText = "Next")
  }
}