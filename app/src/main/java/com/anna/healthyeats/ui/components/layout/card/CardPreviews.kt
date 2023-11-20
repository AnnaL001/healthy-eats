package com.anna.healthyeats.ui.components.layout.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CardPreview(){
  HealthyEatsTheme {
    Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally) {
      HealthyEatsCard {
        Text(text = "Hey!!!")
      }
    }
  }
}