package com.anna.healthyeats.ui.components.loading

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.anna.healthyeats.R

object LoadingContentResources {
  private val dimenMap = hashMapOf<String, Dp>()
  private val painterMap = hashMapOf<String, Painter>()

  @Composable
  fun dimenResources(): Map<String, Dp>{
    dimenMap["medium_padding"] = dimensionResource(R.dimen.medium_padding)
    dimenMap["loading_img_size"] = dimensionResource(id = R.dimen.loading_img_size)
    return dimenMap
  }

  @Composable
  fun painterResources(): Map<String, Painter>{
    painterMap["loading_img"] = painterResource(id = R.drawable.loading_img)
    return painterMap
  }

}