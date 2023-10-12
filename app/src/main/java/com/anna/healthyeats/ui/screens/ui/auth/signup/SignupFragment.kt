package com.anna.healthyeats.ui.screens.ui.auth.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.components.forms.button.HealthyEatsButton
import com.anna.healthyeats.ui.components.forms.email.HealthyEatsEmailField
import com.anna.healthyeats.ui.components.forms.password.HealthyEatsPasswordField
import com.anna.healthyeats.ui.components.layout.bottom_sheet.HealthyEatsBottomSheet
import com.anna.healthyeats.ui.theme.HealthyEatsBlack
import com.anna.healthyeats.ui.theme.HealthyEatsGreen
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

class SignupFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext()).apply {
      setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
      setContent {
        HealthyEatsTheme {

        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen() {
  val scaffoldState = rememberBottomSheetScaffoldState()

  HealthyEatsBottomSheet(
    scaffoldState = scaffoldState,
    sheetContent = { SignupForm() }) {
    Column(modifier = Modifier.fillMaxSize()) {
      Image(
        painter = painterResource(id = R.drawable.healthy_lifestyle),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize())
    }
  }
}

@Composable
fun SignupForm(){
  var email by rememberSaveable { mutableStateOf("") }
  var password by rememberSaveable { mutableStateOf("") }
  var confirmPassword by rememberSaveable { mutableStateOf("") }

  Column(
    modifier = Modifier.padding(
      top = dimensionResource(id = R.dimen.small_padding),
      bottom = dimensionResource(id = R.dimen.medium_padding),
    ),
    horizontalAlignment = Alignment.CenterHorizontally) {

    Text(
      text = stringResource(id = R.string.signup_title),
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.medium_padding)),
      style = MaterialTheme.typography.headlineMedium.copy(
        fontWeight = FontWeight.Bold,
        color = HealthyEatsGreen  // TO DO: Check why material theme colors not working
      )
    )

    Text(
      text = stringResource(id = R.string.signup_subtitle),
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.large_padding)),
      style = MaterialTheme.typography.titleMedium.copy(
        color = HealthyEatsBlack
      )
    )

    HealthyEatsEmailField(
      input = email,
      placeholder = stringResource(id = R.string.email_placeholder),
      onInputChange = { newEmail ->
        email = newEmail
      },
      modifier = Modifier.padding(
        start = dimensionResource(id = R.dimen.screen_medium_padding),
        end = dimensionResource(id = R.dimen.screen_medium_padding),
        bottom = dimensionResource(id = R.dimen.medium_padding)
      )
    )

    HealthyEatsPasswordField(
      input = password,
      placeholder = stringResource(id = R.string.password_placeholder),
      onInputChange = { newPassword ->
        password = newPassword
      },
      modifier = Modifier.padding(
        start = dimensionResource(id = R.dimen.screen_medium_padding),
        end = dimensionResource(id = R.dimen.screen_medium_padding),
        bottom = dimensionResource(id = R.dimen.medium_padding)
      )
    )

    HealthyEatsPasswordField(
      input = confirmPassword,
      placeholder = stringResource(id = R.string.confirm_password_placeholder),
      onInputChange = { newPassword ->
        confirmPassword = newPassword
      },
      modifier = Modifier.padding(
        start = dimensionResource(id = R.dimen.screen_medium_padding),
        end = dimensionResource(id = R.dimen.screen_medium_padding)
      )
    )

    HealthyEatsButton(
      buttonText = stringResource(id = R.string.btn_signup),
      modifier = Modifier.padding(
        top = dimensionResource(id = R.dimen.medium_padding),
        start = dimensionResource(id = R.dimen.screen_small_padding),
        end = dimensionResource(id = R.dimen.screen_small_padding)
      )
    )

    Text(
      text = stringResource(id = R.string.login_redirect_link),
      textAlign = TextAlign.Center,
      textDecoration = TextDecoration.Underline,
      modifier = Modifier
        .padding(top = dimensionResource(id = R.dimen.small_padding))
        .clickable {},
      style = MaterialTheme.typography.titleMedium.copy(
        color = HealthyEatsBlack
      )
    )
  }

}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
  HealthyEatsTheme {
    SignupScreen()
  }
}