package com.anna.healthyeats.ui.components.forms.chip

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthyInputsChip(
  selected: MutableState<Boolean>,
  label: String,
  modifier: Modifier = Modifier,
  leadingIcon:  @Composable() (() -> Unit) = { LeadingIcon() },
  enabled: Boolean = true,
  onClick: () -> Unit = {}
){
  InputChip(
    selected = selected.value, 
    onClick = onClick,
    leadingIcon = leadingIcon,
    label = { Text(text = label) },
    modifier = modifier,
    enabled = enabled,
    colors = chipColors(),
    border = chipBorder()
  )
}