package com.anna.healthyeats

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.anna.healthyeats.ui.screens.ui.auth.signup.SignupScreen
import com.anna.healthyeats.ui.theme.HealthyEatsTheme
import org.junit.Rule
import org.junit.Test


class SignUpScreenComposeTest {
  @get:Rule
  val composeTestRule = createComposeRule()

  @Test
  fun signUpButtonClick_InitiallyDisplaysLoadingContent() {

    // Start the app
    composeTestRule.setContent {
      HealthyEatsTheme {
        SignupScreen()
      }
    }

    composeTestRule.onNodeWithText("Email").performTextInput("anna@gmail.com")
    composeTestRule.onNodeWithText("Password").performTextInput("testAnna09$")
    composeTestRule.onNodeWithText("Confirm password").performTextInput("testAnna09$")

    composeTestRule.onNodeWithText("Sign up").performClick()

    composeTestRule.onNodeWithText("Signing you up...").assertIsDisplayed()

  }
}