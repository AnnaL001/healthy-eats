package com.anna.healthyeats.ui.components.forms.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.theme.HealthyEatsBlack
import com.anna.healthyeats.ui.theme.HealthyEatsBlack2
import com.anna.healthyeats.ui.theme.HealthyEatsGray
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
fun searchColorScheme(): SearchBarColors {
  return SearchBarDefaults.colors(
    containerColor = HealthyEatsGray2, // TO DO: Fix material colorscheme referencing default colors
    dividerColor = HealthyEatsBlack,
    inputFieldColors = searchInputColorScheme()
  )
}

/**
 * Add search bar's input field color scheme
 * @return Search bar's input field color scheme
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun searchInputColorScheme(): TextFieldColors {
  return SearchBarDefaults.inputFieldColors(
    focusedTextColor = HealthyEatsBlack, // TO DO: Fix material colorscheme referencing default colors
    unfocusedTextColor = HealthyEatsBlack2,
    focusedLeadingIconColor = HealthyEatsGreen,
    focusedTrailingIconColor = HealthyEatsGreen,
    focusedPlaceholderColor = HealthyEatsBlack2,
    cursorColor = HealthyEatsGreen,
    unfocusedLeadingIconColor = HealthyEatsBlack2,
    unfocusedTrailingIconColor = HealthyEatsBlack2,
    unfocusedPlaceholderColor = HealthyEatsBlack2,
    disabledLeadingIconColor = HealthyEatsGray,
    disabledPlaceholderColor = HealthyEatsGray,
    disabledTrailingIconColor = HealthyEatsGray
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