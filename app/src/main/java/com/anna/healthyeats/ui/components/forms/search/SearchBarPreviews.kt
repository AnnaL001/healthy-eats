package com.anna.healthyeats.ui.components.forms.search

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

@Preview(showBackground = true, showSystemUi = true, group = "empty")
@Composable
fun SearchBarPreview(){
  val input = remember { mutableStateOf("") }
  val active = remember { mutableStateOf(false) }

  HealthyEatsTheme {
    Column {
      HealthyEatsSearchBar(
        queryState = input,
        activeState = active,
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_small_padding)),
        placeholder = stringResource(id = R.string.search_recipes_placeholder)
      ){}
    }
  }
}

@Preview(showBackground = true, showSystemUi = true, group = "filled")
@Composable
fun SearchBarFilledPreview(){
  val input = remember { mutableStateOf("Chicken") }
  val active = remember { mutableStateOf(false) }

  HealthyEatsTheme {
    Column {
      HealthyEatsSearchBar(
        queryState = input,
        activeState = active,
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_small_padding)),
        placeholder = stringResource(id = R.string.search_recipes_placeholder)
      ){}
    }
  }
}