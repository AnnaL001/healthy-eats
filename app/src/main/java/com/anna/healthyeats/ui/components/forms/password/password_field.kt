package com.anna.healthyeats.ui.components.forms.password

import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.anna.healthyeats.ui.components.forms.common.ErrorTrailingIcon
import com.anna.healthyeats.ui.components.forms.common.KeyOptions
import com.anna.healthyeats.ui.components.forms.common.PasswordLeadingIcon
import com.anna.healthyeats.ui.components.forms.common.PasswordTrailingIcon
import com.anna.healthyeats.ui.components.forms.common.getKeyboard
import com.anna.healthyeats.ui.components.forms.common.healthyEatsField


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HealthyEatsPasswordField(
  input: TextFieldValue,
  placeholder: String,
  onInputChange: (TextFieldValue) -> Unit,
  modifier: Modifier,
  isError: Boolean?= false,
  errorMessage: String?= "",
  onDone: (KeyboardActionScope.() -> Unit)?= null,
){
  val keyboardController = LocalSoftwareKeyboardController.current
  var passwordHidden by rememberSaveable { mutableStateOf(true) }

  OutlinedTextField(
    value = input,
    onValueChange = onInputChange,
    modifier = Modifier.healthyEatsField(isError, errorMessage, modifier),
    singleLine = true,
    textStyle = MaterialTheme.typography.bodyMedium,
    isError = isError as Boolean,
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
    colors = TextFieldDefaults.outlinedTextFieldColors(
      focusedBorderColor = MaterialTheme.colorScheme.primary,
      focusedLabelColor = MaterialTheme.colorScheme.primary,
      errorBorderColor = MaterialTheme.colorScheme.error,
      errorLabelColor = MaterialTheme.colorScheme.error,
      errorLeadingIconColor = MaterialTheme.colorScheme.error,
      errorTrailingIconColor = MaterialTheme.colorScheme.error
    ),
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
}