package com.anna.healthyeats.ui.screens.ui.auth.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.anna.healthyeats.R

object SignupScreenResources {
  private val stringMap = hashMapOf<String, String>()
  private val dimenMap = hashMapOf<String, Dp>()

  @Composable
  fun stringResources(): Map<String, String>{
    stringMap["signup_title"] = stringResource(id = R.string.signup_title)
    stringMap["signup_subtitle"] = stringResource(id = R.string.signup_subtitle)
    stringMap["email_placeholder"] = stringResource(id = R.string.email_placeholder)
    stringMap["password_placeholder"] = stringResource(id = R.string.password_placeholder)
    stringMap["confirm_password_placeholder"] = stringResource(id = R.string.confirm_password_placeholder)
    stringMap["btn_signup"] = stringResource(id = R.string.btn_signup)
    stringMap["login_redirect_link"] = stringResource(id = R.string.login_redirect_link)
    return stringMap
  }

  @Composable
  fun dimenResources(): Map<String, Dp>{
    dimenMap["small_padding"] = dimensionResource(id = R.dimen.small_padding)
    dimenMap["medium_padding"] = dimensionResource(id = R.dimen.medium_padding)
    dimenMap["large_padding"] = dimensionResource(id = R.dimen.large_padding)
    dimenMap["screen_small_padding"] = dimensionResource(id = R.dimen.screen_small_padding)
    dimenMap["screen_medium_padding"] = dimensionResource(id = R.dimen.screen_medium_padding)
    return dimenMap
  }
}