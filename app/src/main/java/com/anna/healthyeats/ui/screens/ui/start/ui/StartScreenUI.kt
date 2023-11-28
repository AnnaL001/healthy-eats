package com.anna.healthyeats.ui.screens.ui.start.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import com.anna.healthyeats.ui.components.forms.button.HealthyEatsButton
import com.anna.healthyeats.ui.screens.ui.common.boldGreenTitleStyling
import com.anna.healthyeats.ui.screens.ui.common.subtitleStyling

@Composable
fun StartScreenUI(
  onClick: () -> Unit
){
  Column(
    modifier = Modifier.padding(
      top = StartScreenResources.dimenResources()["screen_large_padding"]!!,
      bottom = StartScreenResources.dimenResources()["screen_large_padding"]!!,
    ),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Image(
      painter = StartScreenResources.painterResources()["healthy_eating"]!!,
      contentDescription = "",
      contentScale = ContentScale.FillWidth,
      modifier = Modifier
        .padding(
          start = StartScreenResources.dimenResources()["screen_medium_padding"]!!,
          end = StartScreenResources.dimenResources()["screen_medium_padding"]!!
        )
        .fillMaxHeight(0.6F))

    Text(
      text = StartScreenResources.stringResources()["title"]!!,
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(
        top = StartScreenResources.dimenResources()["small_padding"]!!,
        start = StartScreenResources.dimenResources()["screen_medium_padding"]!!,
        end = StartScreenResources.dimenResources()["screen_medium_padding"]!!
      ),
      style = boldGreenTitleStyling()
    )

    Text(
      text = StartScreenResources.stringResources()["subtitle"]!!,
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(
        top = StartScreenResources.dimenResources()["medium_padding"]!!,
        start = StartScreenResources.dimenResources()["screen_medium_padding"]!!,
        end = StartScreenResources.dimenResources()["screen_medium_padding"]!!
      ),
      style = subtitleStyling()
      )

    HealthyEatsButton(
      buttonText = StartScreenResources.stringResources()["btn_start"]!!,
      onClick = onClick,
      modifier = Modifier.padding(
        top = StartScreenResources.dimenResources()["medium_padding"]!!,
        start = StartScreenResources.dimenResources()["screen_small_padding"]!!,
        end = StartScreenResources.dimenResources()["screen_small_padding"]!!
      ))

  }
}