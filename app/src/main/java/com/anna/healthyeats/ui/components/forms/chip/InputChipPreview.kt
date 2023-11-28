package com.anna.healthyeats.ui.components.forms.chip

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InputChipPreview(){
  val selected = remember { mutableStateOf(false) }
  val onClick = { selected.value = !selected.value}
  
  HealthyEatsTheme {
    Column(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.screen_small_padding))) {
      HealthyInputsChip(selected = selected, label = stringResource(id = R.string.keto_diet), onClick = onClick)
    }
  }
}