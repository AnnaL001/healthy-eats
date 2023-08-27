package com.anna.healthyeats.data.recipes.repository

import com.anna.healthyeats.model.edamam_api.RecipeSearch
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
  suspend fun getRecipes(
    diet: List<String>,
    health: List<String>,
    cuisineType: List<String>,
    mealType: List<String>,
    dishType: List<String>
  ): Flow<RecipeSearch>
}