package com.anna.healthyeats.ui.screens.ui.auth.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.anna.healthyeats.ui.components.loading.LoadingContent
import com.anna.healthyeats.ui.main.voyager_screens.HealthyEatsScreen
import com.anna.healthyeats.ui.main.voyager_screens.HealthyEatsScreenModel
import com.anna.healthyeats.ui.screens.ui.auth.common.confirmPasswordValidationMsg
import com.anna.healthyeats.ui.screens.ui.auth.common.emailValidationMsg
import com.anna.healthyeats.ui.screens.ui.auth.common.passwordValidationMsg
import com.anna.healthyeats.ui.screens.ui.auth.login.LoginScreen
import com.anna.healthyeats.ui.screens.ui.auth.signup.state.SignUpScreenModel
import com.anna.healthyeats.ui.screens.ui.auth.signup.ui.SignupScreenResources
import com.anna.healthyeats.ui.screens.ui.auth.signup.ui.SignupScreenUI
import com.anna.healthyeats.ui.theme.HealthyEatsTheme
import com.anna.healthyeats.utils.notification.ToastService
import com.anna.healthyeats.utils.validation.error.ConfirmPassword
import com.anna.healthyeats.utils.validation.error.Email
import com.anna.healthyeats.utils.validation.error.Password

/**
 * The sign up screen with the sign up
 * i) Sign up UI
 * ii) Sign up UI state
 * */
class SignupScreen : HealthyEatsScreen<SignUpScreenModel>() {
  @Composable
  override fun Content() {
    // Screen navigation
    val navigator = LocalNavigator.currentOrThrow

    // Screen state
    val screenModel = getScreenModel<SignUpScreenModel>()
    val signUpState by screenModel.state.collectAsState()

    // Screen content
    HealthyEatsTheme {
      ScreenContentWithState(screenModel = screenModel)
    }

    // Perform actions based on resultant state
    when(signUpState){
      is HealthyEatsScreenModel.State.Initial -> SignupScreen()
      is HealthyEatsScreenModel.State.Loading -> LoadingContent(text = SignupScreenResources.stringResources()["sign_up_loading"]!! , isSuccess = true)
      is HealthyEatsScreenModel.State.Result<*> -> {
        val signUpResult = (signUpState as HealthyEatsScreenModel.State.Result<*>).result

        if (signUpResult != null){
          navigator.push(LoginScreen())
        } else {
          ToastService.showToast(LocalContext.current, SignupScreenResources.stringResources()["sign_up_error"]!!, true)
        }
      }
    }

  }

  @Composable
  override fun ScreenContentWithState(screenModel: SignUpScreenModel){
    // Email, Password & Confirm password field states
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val confirmPassword = rememberSaveable { mutableStateOf("") }

    // Email, Password & Confirm password validation states
    var emailValidation by rememberSaveable { mutableStateOf(Email.INITIAL) }
    var passwordValidation by rememberSaveable { mutableStateOf(Password.INITIAL) }
    var confirmPasswordValidation by rememberSaveable { mutableStateOf(ConfirmPassword.INITIAL) }

    // Remove whitespace
    val trimEmail = email.value.trim()
    val trimPassword = password.value.trim()
    val trimConfirmPassword = confirmPassword.value.trim()

    val handleButtonClick = {
      val isValidData = screenModel.performValidations(trimEmail, trimPassword, trimConfirmPassword )

      // Validation results
      emailValidation = screenModel.getEmailValidationResult(trimEmail)
      passwordValidation = screenModel.getPasswordValidationResult(trimPassword)
      confirmPasswordValidation = screenModel.getConfPasswordValidationResult(trimPassword, trimConfirmPassword)

      if(isValidData){
        screenModel.signUpUser(trimEmail, trimPassword)
      }
    }

    SignupScreenUI(
      email = email,
      password = password,
      confirmPassword = confirmPassword,
      isEmailError = (emailValidation != Email.INITIAL && emailValidation != Email.VALID_EMAIL),
      isPasswordError = (passwordValidation != Password.INITIAL && passwordValidation != Password.VALID_PASSWORD),
      isConfirmPasswordError = (confirmPasswordValidation != ConfirmPassword.INITIAL && confirmPasswordValidation != ConfirmPassword.VALID_CONFIRM_PASSWORD),
      emailErrorMessage = emailValidationMsg(errorType = emailValidation),
      passwordErrorMessage = passwordValidationMsg(errorType = passwordValidation),
      confirmPasswordErrorMessage = confirmPasswordValidationMsg(errorType = confirmPasswordValidation),
      onClick = handleButtonClick)
  }

}