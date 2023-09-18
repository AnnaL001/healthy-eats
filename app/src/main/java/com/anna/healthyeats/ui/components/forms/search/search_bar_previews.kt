package com.anna.healthyeats.ui.components.forms.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

@Preview(showBackground = true, showSystemUi = true, group = "empty")
@Composable
fun SearchBarPreview(){
  var input by remember { mutableStateOf(TextFieldValue("")) }

  HealthyEatsTheme {
    Column {
      HealthyEatsSearchBar(
        input = input,
        onInputChange = {
          input = it
        },
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_small_padding)),
        placeholder = { Text(text = "Search recipes")}
      )
    }
  }
}

@Preview(showBackground = true, showSystemUi = true, group = "filled")
@Composable
fun SearchBarFilledPreview(){
  var input by remember { mutableStateOf(TextFieldValue("Chicken")) }

  HealthyEatsTheme {
    Column {
      HealthyEatsSearchBar(
        input = input,
        onInputChange = {
          input = it
        },
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_small_padding)),
        placeholder = { Text(text = "Search recipes")}
      )
    }
  }
}