package com.anna.healthyeats.ui.components.forms.email

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
import com.anna.healthyeats.ui.components.forms.text.HealthyEatsTextField
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

/**====================================================================
 * Email field previews
 * ===================================================================*/
@Composable
@Preview(showBackground = true, showSystemUi = true, group = "filled")
fun HealthyEatsFilledEmailFieldPreview(){
  var input by remember { mutableStateOf(TextFieldValue("anna@gmail.com")) }

  HealthyEatsTheme {
    Column {
      HealthyEatsTextField(
        input = input,
        placeholder = stringResource(id = R.string.email_placeholder),
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
fun HealthyEatsEmptyEmailFieldPreview(){
  var input by remember { mutableStateOf(TextFieldValue("")) }

  HealthyEatsTheme {
    val errorMessage = stringResource(id = R.string.email_required_error)

    Column {
      HealthyEatsEmailField(
        input = input,
        placeholder = stringResource(id = R.string.email_placeholder),
        onInputChange = {
          input = it
        },
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_medium_padding)),
        isError = true,
        errorMessage = errorMessage
      )

      HealthyEatsFieldError(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.screen_medium_padding)), errorMessage = errorMessage)
    }
  }
}