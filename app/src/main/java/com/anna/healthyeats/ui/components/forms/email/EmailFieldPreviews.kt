package com.anna.healthyeats.ui.components.forms.email

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
import com.anna.healthyeats.ui.components.forms.common.HealthyEatsFieldError
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

/**====================================================================
 * Email field previews
 * ===================================================================*/
@Composable
@Preview(showBackground = true, showSystemUi = true, group = "filled")
fun HealthyEatsFilledEmailFieldPreview(){
  val input = remember { mutableStateOf("") }

  HealthyEatsTheme {
    Column {
      HealthyEatsEmailField(
        inputState = input,
        placeholder = stringResource(id = R.string.email_placeholder),
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_medium_padding))
      )
    }
  }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, group = "empty")
fun HealthyEatsEmptyEmailFieldPreview(){
  val input = remember { mutableStateOf("") }

  HealthyEatsTheme {
    val errorMessage = stringResource(id = R.string.email_required_error)

    Column {
      HealthyEatsEmailField(
        inputState = input,
        placeholder = stringResource(id = R.string.email_placeholder),
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_medium_padding)),
        isError = true,
        errorMessage = errorMessage
      )

      HealthyEatsFieldError(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.screen_medium_padding)), errorMessage = errorMessage)
    }
  }
}