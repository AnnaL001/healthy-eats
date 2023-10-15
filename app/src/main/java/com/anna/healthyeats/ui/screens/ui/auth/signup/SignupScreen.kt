package com.anna.healthyeats.ui.screens.ui.auth.signup

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
fun SignupScreen(
  email: MutableState<String>,
  password: MutableState<String>,
  confirmPassword: MutableState<String>,
  onClick: () -> Unit
) {
  val scaffoldState = rememberBottomSheetScaffoldState()

  HealthyEatsBottomSheet(
    scaffoldState = scaffoldState,
    sheetContent = { SignupForm(email, password, confirmPassword, onClick) }) {
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
private fun SignupForm(
  email: MutableState<String>,
  password: MutableState<String>,
  confirmPassword: MutableState<String>,
  onClick: () -> Unit
){
  Column(
    modifier = Modifier.padding(
      top = SignupScreenResources.dimenResources()["small_padding"]!!,
      bottom = SignupScreenResources.dimenResources()["medium_padding"]!!,
    ),
    horizontalAlignment = Alignment.CenterHorizontally) {

    Text(
      text = SignupScreenResources.stringResources()["signup_title"]!!,
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(bottom = SignupScreenResources.dimenResources()["medium_padding"]!!),
      style = boldGreenStyling()
    )

    Text(
      text = SignupScreenResources.stringResources()["signup_subtitle"]!!,
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(bottom = SignupScreenResources.dimenResources()["large_padding"]!!),
      style = normalStyling()
    )

    HealthyEatsEmailField(
      inputState = email,
      placeholder = SignupScreenResources.stringResources()["email_placeholder"]!!,
      modifier = Modifier.padding(
        start = SignupScreenResources.dimenResources()["screen_medium_padding"]!!,
        end = SignupScreenResources.dimenResources()["screen_medium_padding"]!!,
        bottom = SignupScreenResources.dimenResources()["medium_padding"]!!
      )
    )

    HealthyEatsPasswordField(
      inputState = password,
      placeholder = SignupScreenResources.stringResources()["password_placeholder"]!!,
      modifier = Modifier.padding(
        start = SignupScreenResources.dimenResources()["screen_medium_padding"]!!,
        end = SignupScreenResources.dimenResources()["screen_medium_padding"]!!,
        bottom = SignupScreenResources.dimenResources()["medium_padding"]!!
      )
    )

    HealthyEatsPasswordField(
      inputState = confirmPassword,
      placeholder = SignupScreenResources.stringResources()["confirm_password_placeholder"]!!,
      modifier = Modifier.padding(
        start = SignupScreenResources.dimenResources()["screen_medium_padding"]!!,
        end = SignupScreenResources.dimenResources()["screen_medium_padding"]!!
      )
    )

    HealthyEatsButton(
      buttonText = SignupScreenResources.stringResources()["btn_signup"]!!,
      modifier = Modifier.padding(
        top = SignupScreenResources.dimenResources()["medium_padding"]!!,
        start = SignupScreenResources.dimenResources()["screen_medium_padding"]!!,
        end = SignupScreenResources.dimenResources()["screen_small_padding"]!!
      )
    )

    Text(
      text = SignupScreenResources.stringResources()["login_redirect_link"]!!,
      textAlign = TextAlign.Center,
      textDecoration = TextDecoration.Underline,
      modifier = Modifier
        .padding(top = SignupScreenResources.dimenResources()["small_padding"]!!)
        .clickable { onClick() },
      style = normalStyling()
    )
  }

}