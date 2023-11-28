package com.anna.healthyeats.model.storage

import com.anna.healthyeats.model.edamam_api.Recipe

data class CookedRecipe(
  val recipe: Recipe,
  val cooks: Int
)
