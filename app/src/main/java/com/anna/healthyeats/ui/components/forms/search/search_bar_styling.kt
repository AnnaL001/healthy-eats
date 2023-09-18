package com.anna.healthyeats.ui.components.forms.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.theme.HealthyEatsBlack
import com.anna.healthyeats.ui.theme.HealthyEatsBlack2
import com.anna.healthyeats.ui.theme.HealthyEatsGray2
import com.anna.healthyeats.ui.theme.HealthyEatsGreen

/**
 * Add search bar styling
 * @return Modifier instance with search bar styling
 */
fun Modifier.healthyEatsSearch(modifier: Modifier): Modifier{
  return this.then(
    modifier.fillMaxWidth()
  )
}

/**
 * Add search bar color scheme
 * @return Search bar color scheme
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchColorScheme(): TextFieldColors{
  return TextFieldDefaults.outlinedTextFieldColors(
    textColor = HealthyEatsBlack, // TO DO: Fix material colorscheme referencing default colors
    containerColor = HealthyEatsGray2,
    focusedBorderColor = HealthyEatsGreen,
    focusedLabelColor = HealthyEatsGreen,
    focusedLeadingIconColor = HealthyEatsGreen,
    focusedTrailingIconColor = HealthyEatsGreen,
    placeholderColor = HealthyEatsBlack2,
    unfocusedLeadingIconColor = HealthyEatsBlack2,
    unfocusedTrailingIconColor = HealthyEatsBlack2,
    unfocusedBorderColor = HealthyEatsGray2
  )
}

/**
 * Search bar leading icon
 */
@Composable
fun SearchLeadingIcon(){
  Icon(
    painter = painterResource(id = R.drawable.search_list),
    contentDescription = stringResource(id = R.string.search_list_icon))
}

/**
 * Search bar trailing icon
 */
@Composable
fun SearchTrailingIcon(){
  Icon(
    painter = painterResource(id = R.drawable.search),
    contentDescription = stringResource(id = R.string.search_icon))
}