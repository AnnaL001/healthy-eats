package com.anna.healthyeats.ui.screens.ui.start

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun StartScreenPreview() {
  val onClick = {}

  HealthyEatsTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
      StartScreen {
        onClick()
      }
    }
  }
}