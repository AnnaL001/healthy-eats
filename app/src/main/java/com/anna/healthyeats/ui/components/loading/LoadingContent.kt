package com.anna.healthyeats.ui.components.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anna.healthyeats.ui.components.layout.card.HealthyEatsCard
import com.anna.healthyeats.ui.theme.HealthyEatsError
import com.anna.healthyeats.ui.theme.HealthyEatsGreen
import com.anna.healthyeats.ui.theme.HealthyEatsYellow

@Composable
fun LoadingContent(
  text: String,
  isSuccess: Boolean,
  modifier: Modifier = Modifier){
  Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
      HealthyEatsCard {
        Image(
          painter = LoadingContentResources.painterResources()["loading_img"]!!,
          contentDescription = "",
          modifier = Modifier.size(80.dp))

        LinearProgressIndicator(modifier =
        modifier
          .fillMaxWidth(fraction = 0.40F)
          .padding(top = LoadingContentResources.dimenResources()["medium_padding"]!!),
          color = HealthyEatsYellow
        )

        Text(
          text = text,
          color = if (isSuccess) HealthyEatsGreen else HealthyEatsError,
          modifier = Modifier.padding(top = LoadingContentResources.dimenResources()["medium_padding"]!!))
      }
  }
  
}