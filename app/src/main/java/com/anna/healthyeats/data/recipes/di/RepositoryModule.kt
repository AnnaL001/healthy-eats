package com.anna.healthyeats.data.recipes.di

import com.anna.healthyeats.data.recipes.repository.RecipeRepository
import com.anna.healthyeats.data.recipes.repository.RecipeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
  @ViewModelScoped
  @Binds
  abstract fun bindRecipeRepository(
    recipeRepositoryImpl: RecipeRepositoryImpl
  ): RecipeRepository
}