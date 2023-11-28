package com.anna.healthyeats.ui.components.forms.chip

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SelectableChipBorder
import androidx.compose.material3.SelectableChipColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.theme.HealthyEatsBlack
import com.anna.healthyeats.ui.theme.HealthyEatsGreen
import com.anna.healthyeats.ui.theme.HealthyEatsLightGreen
import com.anna.healthyeats.ui.theme.HealthyEatsWhite

@Composable
fun LeadingIcon(){
  Icon(
    painter = painterResource(id = R.drawable.nutrition),
    modifier = Modifier.size(20.dp),
    contentDescription = "")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun chipColors(): SelectableChipColors{
  return InputChipDefaults.inputChipColors(
    containerColor = HealthyEatsWhite,
    labelColor = HealthyEatsBlack,
    leadingIconColor = HealthyEatsBlack,
    trailingIconColor = HealthyEatsBlack,
    selectedContainerColor = HealthyEatsLightGreen
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun chipBorder() : SelectableChipBorder{
  return InputChipDefaults.inputChipBorder(
    borderColor = HealthyEatsGreen,
    selectedBorderColor = HealthyEatsGreen
  )
}