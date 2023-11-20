package com.anna.healthyeats.ui.screens.ui.auth.signup.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.anna.healthyeats.R

object SignupScreenResources {
  private val stringMap = hashMapOf<String, String>()
  private val dimenMap = hashMapOf<String, Dp>()
  private val errorMap = hashMapOf<String, String>()

  /**
   * Sign up screen texts
   */
  @Composable
  fun stringResources(): Map<String, String>{
    stringMap["signup_title"] = stringResource(id = R.string.signup_title)
    stringMap["signup_subtitle"] = stringResource(id = R.string.signup_subtitle)
    stringMap["email_placeholder"] = stringResource(id = R.string.email_placeholder)
    stringMap["password_placeholder"] = stringResource(id = R.string.password_placeholder)
    stringMap["confirm_password_placeholder"] = stringResource(id = R.string.confirm_password_placeholder)
    stringMap["btn_signup"] = stringResource(id = R.string.btn_signup)
    stringMap["login_redirect_link"] = stringResource(id = R.string.login_redirect_link)
    stringMap["sign_up_loading"] = stringResource(id = R.string.sign_up_loading)
    stringMap["sign_up_error"] = stringResource(id = R.string.sign_up_error)
    return stringMap
  }

  /**
   * Sign up screen dimensions
   */
  @Composable
  fun dimenResources(): Map<String, Dp>{
    dimenMap["small_padding"] = dimensionResource(id = R.dimen.small_padding)
    dimenMap["medium_padding"] = dimensionResource(id = R.dimen.medium_padding)
    dimenMap["large_padding"] = dimensionResource(id = R.dimen.large_padding)
    dimenMap["small_medium_padding"] = dimensionResource(id = R.dimen.small_medium_padding)
    dimenMap["screen_small_padding"] = dimensionResource(id = R.dimen.screen_small_padding)
    dimenMap["screen_medium_padding"] = dimensionResource(id = R.dimen.screen_medium_padding)
    return dimenMap
  }

  /**
   * Sign up screen email errors
   */
  @Composable
  fun signUpEmailErrors(): Map<String, String>{
    errorMap["email_required"] = stringResource(id = R.string.email_required_error)
    errorMap["email_invalid"] = stringResource(id = R.string.email_invalid_error)
    errorMap["email_lowercase"] = stringResource(id = R.string.email_lowercase_error)
    return errorMap
  }
  
  /**
   * Sign up screen password errors
   */
  @Composable
  fun signUpPasswordErrors(): Map<String, String>{
    errorMap["password_required"] = stringResource(id = R.string.password_required_error)
    errorMap["password_too_short"] = stringResource(id = R.string.password_short_error)
    errorMap["password_no_uppercase"] = stringResource(id = R.string.password_no_uppercase_error)
    errorMap["password_no_lowercase"] = stringResource(id = R.string.password_no_lowercase_error)
    errorMap["password_no_digits"] = stringResource(id = R.string.password_no_digit_error)
    errorMap["password_no_special_chars"] = stringResource(id = R.string.password_no_special_chars_error)
    return errorMap
  }
  
  /**
   * Sign up screen confirm password errors 
   */
  @Composable
  fun signUpConfirmPasswordErrors(): Map<String, String>{
    errorMap["confirm_password_required"] = stringResource(id = R.string.confirm_password_required_error)
    errorMap["confirm_password_match"] = stringResource(id = R.string.confirm_password_match_error)
    return errorMap
  }
}