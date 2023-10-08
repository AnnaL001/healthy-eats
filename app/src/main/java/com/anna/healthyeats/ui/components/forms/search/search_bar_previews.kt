package com.anna.healthyeats.ui.components.forms.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

@Preview(showBackground = true, showSystemUi = true, group = "empty")
@Composable
fun SearchBarPreview(){
  var input by remember { mutableStateOf("") }
  var active by remember { mutableStateOf(false) }

  HealthyEatsTheme {
    Column {
      HealthyEatsSearchBar(
        query = input,
        onQueryChange = {
          input = it
        },
        active = active,
        onSearch = { active = false },
        onActiveChange = {
          active = it
        },
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_small_padding)),
        placeholder = stringResource(id = R.string.search_recipes_placeholder)
      ){}
    }
  }
}

@Preview(showBackground = true, showSystemUi = true, group = "filled")
@Composable
fun SearchBarFilledPreview(){
  var input by remember { mutableStateOf("Chicken") }
  var active by remember { mutableStateOf(false) }

  HealthyEatsTheme {
    Column {
      HealthyEatsSearchBar(
        query = input,
        onQueryChange = {
          input = it
        },
        active = active,
        onSearch = { active = false },
        onActiveChange = {
          active = it
        },
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_small_padding)),
        placeholder = stringResource(id = R.string.search_recipes_placeholder)
      ){}
    }
  }
}