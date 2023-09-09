package com.anna.healthyeats.ui.components.forms.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.anna.healthyeats.ui.theme.HealthyEatsBlack
import com.anna.healthyeats.ui.theme.HealthyEatsYellow

@Composable
fun HealthyEatsButton(
  buttonText: String,
  modifier: Modifier = Modifier,
  onClick: () -> Unit = {}
){
    Button(
      onClick = onClick,
      modifier = modifier
        .height(57.dp)
        .fillMaxWidth(),
      colors = ButtonDefaults.buttonColors(
        containerColor = HealthyEatsYellow, // TO DO: Fix material colorscheme referencing default colors
        contentColor = HealthyEatsBlack,
        disabledContainerColor = HealthyEatsYellow.copy(alpha = 0.5f),
        disabledContentColor = HealthyEatsBlack.copy(alpha = 0.5f)
      ),
      enabled = true ) {
      Text(
        text = buttonText,
        style = MaterialTheme.typography.displayMedium
      )
    }
}

@Composable
fun HealthyEatsButtonWithIcon(
  buttonText: String,
  @DrawableRes icon: Int,
  modifier: Modifier = Modifier,
  onClick: () -> Unit = {},
  contentDesc: String = "",
){
    Row(verticalAlignment = Alignment.CenterVertically,
      modifier = modifier.fillMaxWidth().background(
        color = HealthyEatsYellow,
        shape = CircleShape
      ).clickable { onClick() }
    ) {
      Icon(
        painter = painterResource(id = icon),
        contentDescription = contentDesc,
        modifier = Modifier
          .height(22.dp)
          .width(22.dp))
      Spacer(modifier = Modifier.padding(start = 48.dp, end = 48.dp))
      Text(
        text = buttonText,
        style = MaterialTheme.typography.displayMedium,
        color = HealthyEatsBlack
      )
      Spacer(modifier = Modifier.weight(1F).fillMaxWidth())
    }
}