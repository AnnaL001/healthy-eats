package com.anna.healthyeats.ui.screens.ui.user_details.components.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.components.forms.chip.HealthyInputsChip
import com.anna.healthyeats.ui.screens.ui.user_details.ui.UserDetailsScreenResources

@Composable
fun HealthPreferenceList(
  selectedHealthPref: MutableState<List<String>>
){
  val healthPreferenceList = stringArrayResource(id = R.array.health_preference)

  LazyRow(
    userScrollEnabled = true,
    horizontalArrangement = Arrangement.spacedBy(UserDetailsScreenResources.dimenResources()["xsmall_padding"]!!),
    modifier = Modifier.padding(
      start = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
      end = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
      bottom = UserDetailsScreenResources.dimenResources()["medium_padding"]!!
    )
  ){
    items(healthPreferenceList){ health ->
      val selected = rememberSaveable { mutableStateOf(false) }

      val onClick = {
        selected.value = !selected.value
        selectedHealthPref.value = selectedHealthPref.value.toMutableList().also {
          if(selected.value) it.add(health) else it.remove(health)
        }
      }

      HealthyInputsChip(selected = selected, label = health, onClick = onClick)
    }
  }
}