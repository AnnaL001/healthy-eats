package com.anna.healthyeats.ui.screens.ui.user_details.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.components.layout.bottom_sheet.HealthyEatsBottomSheet
import com.anna.healthyeats.ui.screens.ui.user_details.components.form.UserDetailsForm

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailsScreenUI(
  name: MutableState<String>,
  selectedDiets: MutableState<List<String>>,
  selectedHealthPref: MutableState<List<String>>,
  selectedCuisine: MutableState<List<String>>,
  isNameError: Boolean = false,
  nameErrorMessage: String = "",
  onClick: () -> Unit = {}
){
  val scaffoldState = rememberBottomSheetScaffoldState()

  HealthyEatsBottomSheet(
    scaffoldState = scaffoldState,
    sheetContent = { UserDetailsForm(name, selectedDiets, selectedHealthPref, selectedCuisine, isNameError, nameErrorMessage, onClick) })
  {
    Column {
      Image(
        painter = painterResource(id = R.drawable.healthy_cooking),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight(0.45F))
    }
}

}


