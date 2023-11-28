package com.anna.healthyeats

import com.anna.healthyeats.utils.validation.error.Password
import com.anna.healthyeats.utils.validation.main.PasswordValidations
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidationTest {

  @Test
  fun passwordValidator_correctPassword_ReturnsTrue(){
    assertTrue(PasswordValidations.validate("testUserB01$") == Password.VALID_PASSWORD)
  }

  @Test
  fun passwordValidator_noSpecialChars_ReturnsFalse(){
    assertTrue(PasswordValidations.validate("testUserBO1") == Password.NO_SPECIAL_CHARS)
  }

  @Test
  fun passwordValidator_noUppercase_ReturnsFalse(){
    assertTrue(PasswordValidations.validate("testuserb01$") == Password.NO_UPPERCASE)
  }

  @Test
  fun passwordValidator_noLowercase_ReturnsFalse(){
    assertTrue(PasswordValidations.validate("TESTUSER01$") == Password.NO_LOWERCASE)
  }

  @Test
  fun passwordValidator_noDigits_ReturnsFalse(){
    assertTrue(PasswordValidations.validate("testUserb$") == Password.NO_DIGITS)
  }
}