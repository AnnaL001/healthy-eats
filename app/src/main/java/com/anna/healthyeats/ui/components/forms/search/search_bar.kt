package com.anna.healthyeats.ui.components.forms.search

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthyEatsSearchBar(
  query: String,
  onQueryChange: (String) -> Unit,
  onSearch: (String) -> Unit,
  active: Boolean,
  onActiveChange: (Boolean) -> Unit,
  placeholder: String,
  modifier: Modifier = Modifier,
  content: @Composable (() -> Unit)
){
  SearchBar(
    query = query,
    modifier = Modifier.healthyEatsSearch(modifier),
    onQueryChange = onQueryChange,
    onSearch = onSearch ,
    active = active,
    onActiveChange = onActiveChange,
    colors = searchColorScheme(),
    placeholder = { Text(text = placeholder) },
    leadingIcon = { SearchLeadingIcon() },
    trailingIcon = { SearchTrailingIcon() }
    ) {
    content
  }
}


