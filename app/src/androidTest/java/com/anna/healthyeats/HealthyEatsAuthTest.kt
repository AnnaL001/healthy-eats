package com.anna.healthyeats

import com.anna.healthyeats.ui.screens.ui.auth.signup.state.SignUpScreenModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject


@HiltAndroidTest
@RunWith(MockitoJUnitRunner.class)
  class HealthyEatsAuthTest {
  @get:Rule
  var hiltRule = HiltAndroidRule(this)

  @Mock
  @Inject
  lateinit var signUpScreenModel: SignUpScreenModel

  @Before
  open fun setup() {
    hiltRule.inject()
  }

  @Test
  fun testUserSignUpWithExistingEmailAndPassword_DisplaysErrorToast(){
    val email = "anna@gmail.com"
    val password = "testAnna01W$"

    signUpScreenModel.signUpUser(email, password)
  }
}