package com.anna.healthyeats.ui.components.layout.bottom_sheet

import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import com.anna.healthyeats.R
import com.anna.healthyeats.ui.theme.HealthyEatsGray2
import com.anna.healthyeats.ui.theme.HealthyEatsGreen
import com.anna.healthyeats.ui.theme.HealthyEatsWhite

/**
 * Bottom sheet drag handle styling
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthyEatsBottomSheetDragHandle(){
  BottomSheetDefaults.DragHandle(
    color = HealthyEatsGreen
  )
}
/**
 * Defaults for the bottom sheet
 */
@Composable
fun bottomSheetDefaults(): HealthyEatsBottomSheetDefaults {
  return HealthyEatsBottomSheetDefaults(
    containerColor = HealthyEatsGray2,
    sheetContainerColor = HealthyEatsWhite,
    sheetPeekHeight = dimensionResource(id = R.dimen.default_sheet_peek_height))
}







