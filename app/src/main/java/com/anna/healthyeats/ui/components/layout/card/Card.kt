package com.anna.healthyeats.ui.components.layout.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.anna.healthyeats.R

@Composable
fun HealthyEatsCard(
  modifier: Modifier = Modifier,
  elevation: CardElevation = healthyEatsCardElevation(),
  content: @Composable () -> Unit
){
  ElevatedCard(
    modifier = modifier,
    colors = healthyEatsCardColor(),
    elevation = elevation,
  ){
    Column(
      modifier = modifier.padding (dimensionResource(id = R.dimen.medium_padding)),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally) {
      content()
    }
  }
}
