package com.anna.healthyeats.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

//private val DarkColorScheme = darkColorScheme(
//  primary = HealthyFoodsGreen,
//  secondary = HealthyFoodsYellow,
//  background = Color.Black
//) -- Dark theme support to be added later

val LightColorScheme = lightColorScheme(
  primary = HealthyEatsGreen,
  secondary = HealthyEatsYellow,
  surface = HealthyEatsWhite,
  onSurface = HealthyEatsBlack,
  background = HealthyEatsWhite,
  onPrimary = HealthyEatsWhite,
  onSecondary = HealthyEatsBlack,
  error = HealthyEatsError
)

@Composable
fun HealthyEatsTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = true,
  content: @Composable () -> Unit
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      dynamicLightColorScheme(context)
//      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context) -- Dark theme support to be added later
    }

//    darkTheme -> DarkColorScheme -- Dark theme support to be added later
    else -> LightColorScheme
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = colorScheme.background.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    shapes = shapes,
    content = content
  )
}