package com.anna.healthyeats.ui.components.forms.password

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.components.forms.common.ErrorTrailingIcon
import com.anna.healthyeats.ui.components.forms.common.HealthyEatsFieldError
import com.anna.healthyeats.ui.components.forms.common.KeyOptions
import com.anna.healthyeats.ui.components.forms.common.PasswordLeadingIcon
import com.anna.healthyeats.ui.components.forms.common.PasswordTrailingIcon
import com.anna.healthyeats.ui.components.forms.common.fieldColorScheme
import com.anna.healthyeats.ui.components.forms.common.getKeyboard
import com.anna.healthyeats.ui.components.forms.common.healthyEatsField

/**
 * Password field
 * @param inputState Field state
 * @param placeholder Text to be displayed when no value is present
 * @param modifier Modifier instance to add styling
 * @param isError Whether field validation has failed
 * @param errorMessage Error message to be displayed
 * @param onDone Function/method to run when field value has been input
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HealthyEatsPasswordField(
  inputState: MutableState<String>,
  placeholder: String,
  modifier: Modifier,
  isError: Boolean = false,
  errorMessage: String = "",
  onDone: (KeyboardActionScope.() -> Unit)?= null,
){
  val keyboardController = LocalSoftwareKeyboardController.current
  var passwordHidden by rememberSaveable { mutableStateOf(true) }

  Column {
    OutlinedTextField(
      value = inputState.value,
      onValueChange = { newValue ->
        inputState.value = newValue
      },
      modifier = Modifier.healthyEatsField(isError, errorMessage, modifier),
      singleLine = true,
      textStyle = MaterialTheme.typography.bodyMedium,
      isError = isError,
      placeholder = { Text(text = placeholder) },
      leadingIcon = { PasswordLeadingIcon() },
      trailingIcon = {
        if (!isError) {
          IconButton(onClick = { passwordHidden = !passwordHidden }) {
            PasswordTrailingIcon(passwordHidden = passwordHidden)
          }
        } else {
          ErrorTrailingIcon()
        }
      },
      colors = fieldColorScheme(),
      keyboardOptions = getKeyboard(KeyOptions.PASSWORD_INPUT),
      keyboardActions = KeyboardActions(
        onDone = {
          if(onDone is (KeyboardActionScope.() -> Unit)){
            onDone.invoke(this)
          } else {
            keyboardController?.hide()
          }
        }
      ),
      visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None
    )

    if (isError && errorMessage.isNotBlank()){
      HealthyEatsFieldError(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.screen_xlarge_padding)), errorMessage = errorMessage)
    }
  }
}