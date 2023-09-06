package com.anna.healthyeats.ui.components.forms.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.anna.healthyeats.R

@Composable
fun ErrorTrailingIcon(){
  Icon(
    painter = painterResource(id = R.drawable.error_icon),
    contentDescription = stringResource(id = R.string.error_icon)
  )
}

@Composable
fun HealthyEatsFieldError(modifier: Modifier, errorMessage: String){
  if (errorMessage.isNotBlank()) {
    Text(
      text = errorMessage,
      color = MaterialTheme.colorScheme.error,
      style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp),
      modifier = modifier.fillMaxWidth()
    )
  }
}