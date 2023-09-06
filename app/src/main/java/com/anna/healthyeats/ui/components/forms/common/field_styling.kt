package com.anna.healthyeats.ui.components.forms.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import com.anna.healthyeats.R

fun Modifier.healthyEatsField(isError: Boolean?, errorMessage: String?, modifier: Modifier): Modifier {
  return this.then(
    modifier
      .semantics {
        if (isError == true) errorMessage?.let { e -> error(e) }
      }
      .fillMaxWidth())
}

@Composable
fun EmailLeadingIcon(){
  Icon(Icons.Rounded.Email, contentDescription = stringResource(id = R.string.email_icon))
}

@Composable
fun PasswordLeadingIcon(){
  Icon(Icons.Rounded.Lock, contentDescription = stringResource(id = R.string.password_icon))
}

@Composable
fun PasswordTrailingIcon(passwordHidden: Boolean){
  val visibilityIcon = if (passwordHidden) R.drawable.visibility_off else R.drawable.visibility
  val description = if(passwordHidden) R.string.show_password else R.string.hide_password
  Icon(painterResource(id = visibilityIcon), contentDescription = stringResource(id = description))
}



