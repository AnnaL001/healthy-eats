package com.anna.healthyeats.ui.components.forms.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.theme.HealthyEatsGreen

/**
 * Specify color scheme for form fields
 * @return Form field color scheme
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun fieldColorScheme(): TextFieldColors{
  return OutlinedTextFieldDefaults.colors(
    focusedBorderColor = HealthyEatsGreen, // TO DO: Fix material colorscheme referencing default colors
    errorBorderColor = MaterialTheme.colorScheme.error,
    errorLeadingIconColor = MaterialTheme.colorScheme.error,
    errorTrailingIconColor = MaterialTheme.colorScheme.error,
    focusedLabelColor = HealthyEatsGreen,
    errorLabelColor = MaterialTheme.colorScheme.error,
  )
}

/**
 * Form field styling
 * @param isError Whether validation has failed
 * @param errorMessage Error message to be displayed
 * @param modifier Modifier instance to add styling
 * @return Modifier instance with form field styling
 */
fun Modifier.healthyEatsField(isError: Boolean?, errorMessage: String?, modifier: Modifier): Modifier {
  return this.then(
    modifier
      .semantics {
        if (isError == true) errorMessage?.let { e -> error(e) }
      }
      .fillMaxWidth())
}

/**
 * Leading icon for the email field
 */
@Composable
fun EmailLeadingIcon(){
  Icon(Icons.Rounded.Email, contentDescription = stringResource(id = R.string.email_icon))
}

/**
 * Leading icon for the password field
 */
@Composable
fun PasswordLeadingIcon(){
  Icon(Icons.Rounded.Lock, contentDescription = stringResource(id = R.string.password_icon))
}

/**
 * Trailing icon for the password field
 * @param passwordHidden Whether password is to be hidden/shown in text format
 */
@Composable
fun PasswordTrailingIcon(passwordHidden: Boolean){
  val visibilityIcon = if (passwordHidden) R.drawable.visibility_off else R.drawable.visibility
  val description = if(passwordHidden) R.string.show_password else R.string.hide_password
  Icon(painterResource(id = visibilityIcon), contentDescription = stringResource(id = description))
}



