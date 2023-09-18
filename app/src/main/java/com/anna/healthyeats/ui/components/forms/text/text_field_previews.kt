package com.anna.healthyeats.ui.components.forms.text

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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.components.forms.common.HealthyEatsFieldError
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

/**====================================================================
 * Text field Previews
 * ===================================================================*/
@Composable
@Preview(showBackground = true, showSystemUi = true, group = "filled")
fun HealthyEatsFilledTextFieldPreview(){
  var input by remember { mutableStateOf(TextFieldValue("Anna")) }

  HealthyEatsTheme {
    Column {
      HealthyEatsTextField(
        input = input,
        placeholder = stringResource(id = R.string.name_placeholder),
        onInputChange = {
          input = it
        },
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_medium_padding))
      )
    }
  }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, group = "empty")
fun HealthyEatsEmptyTextFieldPreview(){
  var input by remember { mutableStateOf(TextFieldValue("")) }

  HealthyEatsTheme {
    Column {
      HealthyEatsTextField(
        input = input,
        placeholder = stringResource(id = R.string.name_placeholder),
        onInputChange = {
          input = it
        },
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_medium_padding)),
        isError = true,
        errorMessage = stringResource(id = R.string.name_required_error)
      )

      HealthyEatsFieldError(modifier = Modifier.padding(start = 16.dp), errorMessage = stringResource(id = R.string.name_required_error))
    }
  }
}