package com.anna.healthyeats.ui.screens.ui.user_details.components.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.components.forms.chip.HealthyInputsChip
import com.anna.healthyeats.ui.screens.ui.user_details.ui.UserDetailsScreenResources

@Composable
fun CuisineList(
  selectedCuisine: MutableState<List<String>>
){
  val cuisineList = stringArrayResource(id = R.array.cuisine)

  LazyRow(
    userScrollEnabled = true,
    horizontalArrangement = Arrangement.spacedBy(UserDetailsScreenResources.dimenResources()["xsmall_padding"]!!),
    modifier = Modifier.padding(
      start = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
      end = UserDetailsScreenResources.dimenResources()["screen_medium_padding"]!!,
      bottom = UserDetailsScreenResources.dimenResources()["medium_large_padding"]!!
    )
  ){
    items(cuisineList){ cuisine ->
      val selected = rememberSaveable { mutableStateOf(false) }

      val onClick = {
        selected.value = !selected.value
        selectedCuisine.value = selectedCuisine.value.toMutableList().also {
          if(selected.value) it.add(cuisine) else it.remove(cuisine)
        }
      }

      HealthyInputsChip(
        selected = selected,
        label = cuisine,
        leadingIcon = {
          Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.global),
            contentDescription = "")
        },
        onClick = onClick)
    }
  }
}