package com.anna.healthyeats.network.api.service

import com.anna.healthyeats.model.edamam_api.RecipeSearch
import com.anna.healthyeats.network.constants.ApiConstants
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeSearchApi {
  @GET("")
  suspend fun getRecipes(
    @Query(ApiConstants.SEARCH_QUERY_DIET_PARAMETER) diet: Array<String>,
    @Query(ApiConstants.SEARCH_QUERY_HEALTH_PARAMETER) health: Array<String>,
    @Query(ApiConstants.SEARCH_QUERY_CUISINE_TYPE_PARAMETER) cuisineType: Array<String>,
    @Query(ApiConstants.SEARCH_QUERY_MEAL_TYPE_PARAMETER) mealType: Array<String>,
    @Query(ApiConstants.SEARCH_QUERY_DISH_TYPE_PARAMETER) dishType: Array<String>
  ): Flow<RecipeSearch>
}
