package com.anna.healthyeats.ui.components.forms.email

import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.anna.healthyeats.ui.components.forms.common.EmailLeadingIcon
import com.anna.healthyeats.ui.components.forms.common.ErrorTrailingIcon
import com.anna.healthyeats.ui.components.forms.common.KeyOptions
import com.anna.healthyeats.ui.components.forms.common.fieldColorScheme
import com.anna.healthyeats.ui.components.forms.common.getKeyboard
import com.anna.healthyeats.ui.components.forms.common.healthyEatsField

/**
 * Email field
 * @param input Field value
 * @param placeholder Text to be displayed when no value is present
 * @param onInputChange Function/Method to run when the field value changes
 * @param modifier Modifier instance to add styling
 * @param isError Whether field validation has failed
 * @param errorMessage Error message to be displayed
 * @param onDone Function/method to run when field value has been input
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HealthyEatsEmailField(
  input: String,
  placeholder: String,
  onInputChange: (String) -> Unit,
  modifier: Modifier,
  isError: Boolean?= false,
  errorMessage: String?= "",
  onDone: (KeyboardActionScope.() -> Unit)?= null
){
  val keyboardController = LocalSoftwareKeyboardController.current

  OutlinedTextField(
    value = input,
    onValueChange = onInputChange,
    modifier = Modifier.healthyEatsField(isError, errorMessage, modifier),
    singleLine = true,
    textStyle = MaterialTheme.typography.bodyMedium,
    isError = isError as Boolean,
    placeholder = { Text(text = placeholder) },
    leadingIcon = { EmailLeadingIcon() },
    trailingIcon = {
        if(isError) ErrorTrailingIcon()
    },
    colors = fieldColorScheme(),
    keyboardOptions = getKeyboard(KeyOptions.EMAIL_INPUT),
    keyboardActions = KeyboardActions(
      onDone = {
        if(onDone is (KeyboardActionScope.() -> Unit)){
          onDone.invoke(this)
        } else {
          keyboardController?.hide()
        }
      }
    )
  )
}


