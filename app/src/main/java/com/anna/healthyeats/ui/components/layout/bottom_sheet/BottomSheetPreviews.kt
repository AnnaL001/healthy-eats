package com.anna.healthyeats.ui.components.layout.bottom_sheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anna.healthyeats.ui.theme.HealthyEatsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HealthyEatsBottomSheetPreview(){
  HealthyEatsTheme {
    val scaffoldState = rememberBottomSheetScaffoldState()

    HealthyEatsBottomSheet(
      scaffoldState = scaffoldState,
      sheetContent = { BottomSheetContent() }
    ){
      Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Image content")
      }
    }
  }
}

@Composable
fun BottomSheetContent(){
  Column(
    Modifier
      .fillMaxWidth()
      .padding(64.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text("Sheet content")
  }
}