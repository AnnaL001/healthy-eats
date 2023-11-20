package com.anna.healthyeats.ui.screens.ui.auth.signup.state

import cafe.adriel.voyager.core.model.screenModelScope
import com.anna.healthyeats.data.auth.AuthRepository
import com.anna.healthyeats.model.resource.Resource
import com.anna.healthyeats.ui.main.voyager_screens.HealthyEatsScreenModel
import com.anna.healthyeats.utils.validation.error.ConfirmPassword
import com.anna.healthyeats.utils.validation.error.Email
import com.anna.healthyeats.utils.validation.error.Password
import com.anna.healthyeats.utils.validation.main.ConfirmPasswordValidations
import com.anna.healthyeats.utils.validation.main.EmailValidations
import com.anna.healthyeats.utils.validation.main.PasswordValidations
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Sign up screen state
 */
class SignUpScreenModel @Inject constructor(
  private val authRepository: AuthRepository
): HealthyEatsScreenModel<Resource<FirebaseUser>>() {

  /**
   * Sign up functionality
   * @param email User email
   * @param password User password
   */
  fun signUpUser(email: String, password: String){
    screenModelScope.launch {
      mutableState.value = State.Loading
      mutableState.value = State.Result(result = authRepository.signupWithEmail(email, password))
    }
  }

  /**
   * Perform sign up form data validation
   * @param email Email input
   * @param password Password input
   * @param confirmPassword Confirm password input
   * @return Whether sign up data is valid
   */
  fun performValidations(email: String, password: String, confirmPassword: String): Boolean {
    val validEmail = (getEmailValidationResult(email) == Email.VALID_EMAIL)
    val validPassword = (getPasswordValidationResult(password) == Password.VALID_PASSWORD)
    val validConfirmPassword = (getConfPasswordValidationResult(password, confirmPassword) == ConfirmPassword.VALID_CONFIRM_PASSWORD)

    return validEmail && validPassword && validConfirmPassword
  }

  /**
   * Retrieve email validation results
   * @param email Email input
   */
  fun getEmailValidationResult(email: String): Email = EmailValidations.validate(email)

  /**
   * Retrieve password validation results
   * @param password Password
   */
  fun getPasswordValidationResult(password: String): Password = PasswordValidations.validate(password)

  /**
   * Retrieve confirm password validation results
   * @param password Password input
   * @param confirmPassword Confirm password input
   */
  fun getConfPasswordValidationResult(password: String, confirmPassword: String) = ConfirmPasswordValidations.validate(password, confirmPassword)

}