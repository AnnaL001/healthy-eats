package com.anna.healthyeats.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.anna.healthyeats.ui.screens.ui.start.StartScreen
import com.anna.healthyeats.ui.theme.HealthyEatsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HealthyEatsTheme {
        Navigator(StartScreen()){ navigator ->
          SlideTransition (navigator)
        }
      }
    }
  }
}

@Preview(
  showBackground = true,
  showSystemUi = true)
@Composable
fun MainActivityPreview() {
  HealthyEatsTheme {
    Navigator(StartScreen())
  }
}