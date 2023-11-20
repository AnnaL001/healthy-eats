package com.anna.healthyeats.ui.components.layout.card

import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.theme.HealthyEatsGray2

@Composable
fun healthyEatsCardColor(): CardColors{
  return CardDefaults.elevatedCardColors(
    containerColor = HealthyEatsGray2 // TO DO: Check why material theme colors not working
  )
}

@Composable
fun healthyEatsCardElevation(): CardElevation{
  return CardDefaults.elevatedCardElevation(
    defaultElevation = dimensionResource(id = R.dimen.card_elevation),
    focusedElevation = dimensionResource(id = R.dimen.card_elevation),
    pressedElevation = dimensionResource(id = R.dimen.card_elevation),
    hoveredElevation = dimensionResource(id = R.dimen.card_elevation)
  )
}