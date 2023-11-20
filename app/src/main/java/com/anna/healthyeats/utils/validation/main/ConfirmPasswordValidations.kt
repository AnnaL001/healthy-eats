package com.anna.healthyeats.utils.validation.main

import com.anna.healthyeats.utils.validation.error.ConfirmPassword
import com.anna.healthyeats.utils.validation.pattern.CustomPatterns

/**
 * Confirm password field validation
 */
object ConfirmPasswordValidations {
  fun validate(password: String, confirmPassword: String): ConfirmPassword {
    val isEmpty = CustomPatterns.EMPTY.matcher(confirmPassword).matches()
    val isValidConfirmPassword = (password != confirmPassword)

    return when(true){
      isEmpty -> ConfirmPassword.REQUIRED
      isValidConfirmPassword -> ConfirmPassword.MATCHES_PASSWORD
      else -> ConfirmPassword.VALID_CONFIRM_PASSWORD
    }
  }
}