package com.anna.healthyeats.ui.components.forms.search

import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.TextFieldValue
import com.anna.healthyeats.ui.components.forms.common.getSearchKeyboard

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HealthyEatsSearchBar(
  input: TextFieldValue,
  onInputChange: (TextFieldValue) -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  placeholder: (@Composable () -> Unit)? = null,
  onDone: (KeyboardActionScope.() -> Unit)?= null
){
  val keyboardController = LocalSoftwareKeyboardController.current

  OutlinedTextField(
    value = input,
    onValueChange = onInputChange,
    modifier = Modifier.healthyEatsSearch(modifier),
    enabled = enabled,
    placeholder = placeholder,
    leadingIcon = { SearchLeadingIcon() },
    trailingIcon = { SearchTrailingIcon() },
    colors = searchColorScheme(),
    keyboardOptions = getSearchKeyboard(),
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


