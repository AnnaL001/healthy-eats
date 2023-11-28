package com.anna.healthyeats.model.storage

import com.anna.healthyeats.model.edamam_api.Recipe

data class BookmarkedRecipe (
  val recipe: Recipe,
  val saves: Int
)