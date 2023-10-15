package com.anna.healthyeats.ui.screens.ui.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.components.forms.button.HealthyEatsButton
import com.anna.healthyeats.ui.components.forms.email.HealthyEatsEmailField
import com.anna.healthyeats.ui.components.forms.password.HealthyEatsPasswordField
import com.anna.healthyeats.ui.components.layout.bottom_sheet.HealthyEatsBottomSheet
import com.anna.healthyeats.ui.screens.ui.auth.common.boldGreenStyling
import com.anna.healthyeats.ui.screens.ui.auth.common.normalStyling

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
  email: MutableState<String>,
  password: MutableState<String>,
  onClick: () -> Unit
) {
  val scaffoldState = rememberBottomSheetScaffoldState()

  HealthyEatsBottomSheet(
    scaffoldState = scaffoldState,
    sheetContent = { LoginForm(email, password, onClick) },
    sheetPeekHeight = LoginScreenResources.dimenResources()["login_sheet_peek_height"]
  ) {
    Column {
      Image(
        painter = painterResource(id = R.drawable.healthy_lifestyle),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight(0.45F))
    }
  }
}

@Composable
private fun LoginForm(
  email: MutableState<String>,
  password: MutableState<String>,
  onClick: () -> Unit
){
  Column(
    modifier = Modifier.padding(
      top = LoginScreenResources.dimenResources()["small_padding"]!!,
      bottom = LoginScreenResources.dimenResources()["medium_padding"]!!,
    ),
    horizontalAlignment = Alignment.CenterHorizontally) {

    Text(
      text = LoginScreenResources.stringResources()["login_title"]!!,
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(bottom = LoginScreenResources.dimenResources()["medium_padding"]!!),
      style = boldGreenStyling()
    )

    Text(
      text = LoginScreenResources.stringResources()["login_subtitle"]!!,
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(bottom = LoginScreenResources.dimenResources()["large_padding"]!!),
      style = normalStyling()
    )

    HealthyEatsEmailField(
      inputState = email,
      placeholder = LoginScreenResources.stringResources()["email_placeholder"]!!,
      modifier = Modifier.padding(
        start = LoginScreenResources.dimenResources()["screen_medium_padding"]!!,
        end = LoginScreenResources.dimenResources()["screen_medium_padding"]!!,
        bottom = LoginScreenResources.dimenResources()["medium_padding"]!!
      )
    )

    HealthyEatsPasswordField(
      inputState = password,
      placeholder = LoginScreenResources.stringResources()["password_placeholder"]!!,
      modifier = Modifier.padding(
        start = LoginScreenResources.dimenResources()["screen_medium_padding"]!!,
        end = LoginScreenResources.dimenResources()["screen_medium_padding"]!!
      )
    )

    HealthyEatsButton(
      buttonText = LoginScreenResources.stringResources()["btn_login"]!!,
      modifier = Modifier.padding(
        top = LoginScreenResources.dimenResources()["medium_padding"]!!,
        start = LoginScreenResources.dimenResources()["screen_small_padding"]!!,
        end = LoginScreenResources.dimenResources()["screen_small_padding"]!!
      )
    )

    Text(
      text = LoginScreenResources.stringResources()["signup_redirect_link"]!!,
      textAlign = TextAlign.Center,
      textDecoration = TextDecoration.Underline,
      modifier = Modifier
        .padding(top = LoginScreenResources.dimenResources()["small_padding"]!!)
        .clickable { onClick() },
      style = normalStyling()
    )
  }
}