package com.anna.healthyeats.ui.screens.ui.auth.login.state

import cafe.adriel.voyager.core.model.screenModelScope
import com.anna.healthyeats.data.auth.AuthRepository
import com.anna.healthyeats.model.resource.Resource
import com.anna.healthyeats.ui.main.voyager_screens.HealthyEatsScreenModel
import com.anna.healthyeats.utils.validation.error.Email
import com.anna.healthyeats.utils.validation.error.Password
import com.anna.healthyeats.utils.validation.main.EmailValidations
import com.anna.healthyeats.utils.validation.main.PasswordValidations
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginScreenModel @Inject constructor(
  private val authRepository: AuthRepository
): HealthyEatsScreenModel<Resource<FirebaseUser>>() {
  val loggedInUser : FirebaseUser ? get() = authRepository.loggedInUser

  fun loginUser(email: String, password: String){
    screenModelScope.launch {
      mutableState.value = State.Loading
      mutableState.value = State.Result(result = authRepository.loginWithEmail(email, password))
    }
  }

  /**
   * Validate login form data
   * @param email Email input
   * @param password Password input
   * @return Whether login form data is valid
   */
  fun performValidations(email: String, password: String): Boolean {
    val isValidEmail = (getEmailValidationResult(email) == Email.VALID_EMAIL)
    val isValidPassword = (getPasswordValidationResult(password) == Password.VALID_PASSWORD)

    return isValidEmail && isValidPassword
  }

  /**
   * Get email validation results
   * @param email Email input
   * @return Email validation results
   */
  fun getEmailValidationResult(email: String): Email = EmailValidations.validate(email)

  /**
   * Get password validation results
   * @param password Password input
   * @return Password validation results
   */
  fun getPasswordValidationResult(password: String): Password = PasswordValidations.validate(password)
}