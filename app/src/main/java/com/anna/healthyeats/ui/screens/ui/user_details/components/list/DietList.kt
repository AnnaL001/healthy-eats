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
fun DietList(
  selectedDiets: MutableState<List<String>>
){
  val dietList = stringArrayResource(id = R.array.diet)

  LazyRow(
    userScrollEnabled = true,
    horizontalArrangement = Arrangement.spacedBy(UserDetailsScreenResources.dimenResources()["xsmall_padding"]!!),
    modifier = Modifier.padding(
      start = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
      end = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
      bottom = UserDetailsScreenResources.dimenResources()["medium_padding"]!!
    )
  ){
    items(dietList){ diet ->
      val selected = rememberSaveable { mutableStateOf(false) }

      val onClick = {
        selected.value = !selected.value
        selectedDiets.value = selectedDiets.value.toMutableList().also {
          if(selected.value) it.add(diet) else it.remove(diet)
        }
      }

      HealthyInputsChip(
        selected = selected,
        label = diet,
        onClick = onClick)
    }
  }
}