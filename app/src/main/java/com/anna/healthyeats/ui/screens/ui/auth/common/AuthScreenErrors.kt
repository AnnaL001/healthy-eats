package com.anna.healthyeats.ui.screens.ui.auth.common

import androidx.compose.runtime.Composable
import com.anna.healthyeats.ui.screens.ui.auth.signup.ui.SignupScreenResources
import com.anna.healthyeats.utils.validation.error.ConfirmPassword
import com.anna.healthyeats.utils.validation.error.Email
import com.anna.healthyeats.utils.validation.error.Password
import timber.log.Timber

/**
 * Email validation messages options
 */
@Composable
fun emailValidationMsg(errorType: Email): String{
  return when(errorType){
    Email.INITIAL -> ""
    Email.REQUIRED -> SignupScreenResources.signUpEmailErrors()["email_required"]!!
    Email.INVALID_PATTERN -> SignupScreenResources.signUpEmailErrors()["email_invalid"]!!
    Email.NO_LOWERCASE -> SignupScreenResources.signUpEmailErrors()["email_lowercase"]!!
    Email.VALID_EMAIL -> {
      Timber.d("\uD83D\uDE03️SUCCESS: Email validation successful")
      ""
    }
  }
}

/**
 * Password validation message options
 */
@Composable
fun passwordValidationMsg(errorType: Password): String{
  return when(errorType){
    Password.INITIAL -> ""
    Password.REQUIRED -> SignupScreenResources.signUpPasswordErrors()["password_required"]!!
    Password.TOO_SHORT -> SignupScreenResources.signUpPasswordErrors()["password_too_short"]!!
    Password.NO_UPPERCASE -> SignupScreenResources.signUpPasswordErrors()["password_no_uppercase"]!!
    Password.NO_LOWERCASE -> SignupScreenResources.signUpPasswordErrors()["password_no_lowercase"]!!
    Password.NO_DIGITS -> SignupScreenResources.signUpPasswordErrors()["password_no_digits"]!!
    Password.NO_SPECIAL_CHARS -> SignupScreenResources.signUpPasswordErrors()["password_no_special_chars"]!!
    Password.VALID_PASSWORD -> {
      Timber.d("\uD83D\uDE03️SUCCESS: Password validation successful")
      ""
    }
  }
}

/**
 * Confirm password validation messages
 */
@Composable
fun confirmPasswordValidationMsg(errorType: ConfirmPassword): String{
  return when(errorType){
    ConfirmPassword.INITIAL -> ""
    ConfirmPassword.REQUIRED -> SignupScreenResources.signUpConfirmPasswordErrors()["confirm_password_required"]!!
    ConfirmPassword.MATCHES_PASSWORD -> SignupScreenResources.signUpConfirmPasswordErrors()["confirm_password_match"]!!
    ConfirmPassword.VALID_CONFIRM_PASSWORD -> {
      Timber.d("\uD83D\uDE03️SUCCESS: Confirm Password validation successful")
      ""
    }
  }
}