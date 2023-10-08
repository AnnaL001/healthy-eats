package com.anna.healthyeats.ui.components.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthyEatsBottomSheet(
  scaffoldState: BottomSheetScaffoldState,
  sheetContent: @Composable (ColumnScope.() -> Unit),
  modifier: Modifier = Modifier,
  sheetPeekHeight: Dp ?= null,
  content: @Composable (() -> Unit)
){
  BottomSheetScaffold(
    scaffoldState = scaffoldState,
    sheetPeekHeight = sheetPeekHeight ?: bottomSheetDefaults().sheetPeekHeight,
    sheetContent = sheetContent,
    sheetContainerColor = bottomSheetDefaults().sheetContainerColor,
    containerColor = bottomSheetDefaults().containerColor,
    sheetDragHandle = { HealthyEatsBottomSheetDragHandle() }) { innerPadding ->
    Box(modifier.padding(innerPadding)) {
      content
    }
   }
}