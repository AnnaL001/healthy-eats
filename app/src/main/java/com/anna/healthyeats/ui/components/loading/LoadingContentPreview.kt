package com.anna.healthyeats.ui.components.loading

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoadingContentPreview(){
  HealthyEatsTheme {
    LoadingContent(isSuccess = true, text = stringResource(id = R.string.sign_up_loading))
  }
}