package com.anna.healthyeats.ui.screens.ui.start.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.anna.healthyeats.R

object StartScreenResources{
  private val stringMap = hashMapOf<String, String>()
  private val dimenMap = hashMapOf<String, Dp>()
  private val painterMap = hashMapOf<String, Painter>()
  
  @Composable
  fun stringResources(): Map<String, String>{
    stringMap["title"] = stringResource(id = R.string.title)
    stringMap["subtitle"] = stringResource(id = R.string.subtitle)
    stringMap["btn_start"] = stringResource(id = R.string.btn_start)
    return stringMap
  }
  
  @Composable
  fun dimenResources(): Map<String, Dp>{
    dimenMap["small_padding"] = dimensionResource(id = R.dimen.small_padding)
    dimenMap["medium_padding"] = dimensionResource(id = R.dimen.medium_padding)
    dimenMap["screen_small_padding"] = dimensionResource(id = R.dimen.screen_small_padding)
    dimenMap["screen_medium_padding"] = dimensionResource(id = R.dimen.screen_medium_padding)
    dimenMap["screen_large_padding"] = dimensionResource(id = R.dimen.screen_large_padding)
    return dimenMap
  }

  @Composable
  fun painterResources(): Map<String, Painter>{
    painterMap["healthy_eating"] = painterResource(id = R.drawable.healthy_eating)
    return painterMap
  }
}