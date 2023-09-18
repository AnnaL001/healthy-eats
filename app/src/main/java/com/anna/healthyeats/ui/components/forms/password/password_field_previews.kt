package com.anna.healthyeats.ui.components.forms.password

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
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.components.forms.common.HealthyEatsFieldError
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

/**====================================================================
 * Password field previews
 * ===================================================================*/
@Composable
@Preview(showBackground = true, showSystemUi = true, group = "filled")
fun HealthyEatsFilledPasswordFieldPreview(){
  var input by remember { mutableStateOf(TextFieldValue("12345678")) }

  HealthyEatsTheme {
    Column {
      HealthyEatsPasswordField(
        input = input,
        placeholder = stringResource(id = R.string.password_placeholder),
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
fun HealthyEatsEmptyPasswordFieldPreview(){
  var input by remember { mutableStateOf(TextFieldValue("")) }

  HealthyEatsTheme {
    Column {
      HealthyEatsPasswordField(
        input = input,
        placeholder = stringResource(id = R.string.password_placeholder),
        onInputChange = {
          input = it
        },
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_medium_padding)),
        isError = true,
        errorMessage = stringResource(id = R.string.password_placeholder)
      )

      HealthyEatsFieldError(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.screen_medium_padding)), errorMessage = stringResource(id = R.string.password_required_error))
    }
  }
}