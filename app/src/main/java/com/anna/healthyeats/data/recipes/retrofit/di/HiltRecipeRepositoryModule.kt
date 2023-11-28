package com.anna.healthyeats.data.recipes.retrofit.di

import com.anna.healthyeats.data.recipes.retrofit.repository.RecipeRepository
import com.anna.healthyeats.data.recipes.retrofit.repository.RecipeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class HiltRecipeRepositoryModule {
  @ViewModelScoped
  @Binds
  abstract fun bindRecipeRepository(
    recipeRepositoryImpl: RecipeRepositoryImpl
  ): RecipeRepository
}