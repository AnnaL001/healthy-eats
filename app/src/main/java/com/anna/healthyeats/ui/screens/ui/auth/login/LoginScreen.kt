package com.anna.healthyeats.ui.screens.ui.auth.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.anna.healthyeats.ui.components.loading.LoadingContent
import com.anna.healthyeats.ui.main.voyager_screens.HealthyEatsScreen
import com.anna.healthyeats.ui.main.voyager_screens.HealthyEatsScreenModel
import com.anna.healthyeats.ui.screens.ui.auth.common.emailValidationMsg
import com.anna.healthyeats.ui.screens.ui.auth.common.passwordValidationMsg
import com.anna.healthyeats.ui.screens.ui.auth.login.state.LoginScreenModel
import com.anna.healthyeats.ui.screens.ui.auth.login.ui.LoginScreenResources
import com.anna.healthyeats.ui.screens.ui.auth.login.ui.LoginScreenUI
import com.anna.healthyeats.ui.screens.ui.user_details.UserDetailsScreen
import com.anna.healthyeats.ui.theme.HealthyEatsTheme
import com.anna.healthyeats.utils.notification.ToastService
import com.anna.healthyeats.utils.validation.error.Email
import com.anna.healthyeats.utils.validation.error.Password

/**
 * The login screen with
 * i) Login screen UI
 * ii) Login screen state
 */
class LoginScreen : HealthyEatsScreen<LoginScreenModel>() {

  @Composable
  override fun Content() {
    // Screen navigation
    val navigator = LocalNavigator.currentOrThrow

    // Screen context
    val context = LocalContext.current

    // Screen state
    val screenModel = getScreenModel<LoginScreenModel>()
    val loginState by screenModel.state.collectAsState()

    // Screen content with state
    HealthyEatsTheme {
      ScreenContentWithState(screenModel = screenModel)
    }

    // Perform actions based on resultant state
    when(loginState){
      is HealthyEatsScreenModel.State.Initial -> LoginScreen()
      is HealthyEatsScreenModel.State.Loading -> LoadingContent(text = LoginScreenResources.stringResources()["login_loading"]!!, isSuccess = true)
      is HealthyEatsScreenModel.State.Result<*> -> {
        val loggedInUser = screenModel.loggedInUser

        when(true){
          (loggedInUser != null && loggedInUser.isEmailVerified) -> navigator.push(UserDetailsScreen(loggedInUser))
          (loggedInUser != null && !loggedInUser.isEmailVerified) -> {
            ToastService.showToast(context, LoginScreenResources.stringResources()["verification_error"]!!, true)
          }
          else -> ToastService.showToast(context, LoginScreenResources.stringResources()["login_error"]!!, true)
        }

      }
    }
  }

  @Composable
  override fun ScreenContentWithState(screenModel: LoginScreenModel) {
    // Email & Password field states
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }

    // Email & Password validation states
    var emailValidation by rememberSaveable { mutableStateOf(Email.INITIAL) }
    var passwordValidation by rememberSaveable { mutableStateOf(Password.INITIAL) }

    // Remove start and ending whitespaces
    val trimEmail = email.value.trim()
    val trimPassword = password.value.trim()

    // Perform log in
    val handleButtonClick = {
      val isValidData = screenModel.performValidations(trimEmail, trimPassword)

      // Validation results
      emailValidation = screenModel.getEmailValidationResult(trimEmail)
      passwordValidation = screenModel.getPasswordValidationResult(trimPassword)

      if(isValidData){
        screenModel.loginUser(trimEmail, trimPassword)
      }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
      LoginScreenUI(
        email = email,
        password = password,
        isEmailError = (emailValidation != Email.INITIAL && emailValidation != Email.VALID_EMAIL),
        isPasswordError = (passwordValidation != Password.INITIAL && passwordValidation != Password.VALID_PASSWORD),
        emailErrorMessage = emailValidationMsg(errorType = emailValidation),
        passwordErrorMessage = passwordValidationMsg(errorType = passwordValidation),
        onClick = handleButtonClick
      )
    }
  }
}