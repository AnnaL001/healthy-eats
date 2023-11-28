package com.anna.healthyeats.ui.screens.ui.user_details.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.anna.healthyeats.R

object UserDetailsScreenResources {
  private val stringMap = hashMapOf<String, String>()
  private val dimenMap = hashMapOf<String, Dp>()
  
  /**
   * Set & get user details screen texts
   * @return User details screen texts
   */
  @Composable
  fun stringResources(): Map<String, String>{
    stringMap["name_placeholder"] = stringResource(id = R.string.name_placeholder)
    stringMap["user_details_title"] = stringResource(id = R.string.user_details_title)
    stringMap["select_diet"] = stringResource(id = R.string.select_diet)
    stringMap["select_health_preference"] = stringResource(id = R.string.select_health_preference)
    stringMap["select_cuisine"] = stringResource(id = R.string.select_cuisine)
    return stringMap
  }

  /**
   * Set & get user details screen dimensions
   * @return User details screen dimensions
   */
  @Composable
  fun dimenResources(): Map<String, Dp>{
    dimenMap["small_padding"] = dimensionResource(id = R.dimen.small_padding)
    dimenMap["xsmall_padding"] = dimensionResource(id = R.dimen.xsmall_padding)
    dimenMap["medium_padding"] = dimensionResource(id = R.dimen.medium_padding)
    dimenMap["medium_large_padding"] = dimensionResource(id = R.dimen.medium_large_padding)
    dimenMap["screen_small_padding"] = dimensionResource(id = R.dimen.screen_small_padding)
    dimenMap["screen_medium_padding"] = dimensionResource(id = R.dimen.screen_medium_padding)
    return dimenMap
  }
}