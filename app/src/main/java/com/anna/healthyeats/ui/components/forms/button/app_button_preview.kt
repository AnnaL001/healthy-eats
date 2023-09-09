package com.anna.healthyeats.ui.components.forms.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

@Preview  (showSystemUi = true, showBackground = true, group = "without icon")
@Composable
fun AppButtonWithoutIcon(){
  HealthyEatsTheme{
    Column {
      HealthyEatsButton(
        buttonText = "Click me!",
        modifier = Modifier.padding(16.dp)
      )
    }
  }
}

@Preview  (showSystemUi = true, showBackground = true, group = "with icon")
@Composable
fun AppButtonWithIcon(){
  HealthyEatsTheme{
    Column {
      HealthyEatsButtonWithIcon(
        buttonText = "Click me!",
        modifier = Modifier.padding(16.dp),
        icon = R.drawable.bookmark_add,
        contentDesc = stringResource(id = R.string.show_password)
      )
    }
  }
}
