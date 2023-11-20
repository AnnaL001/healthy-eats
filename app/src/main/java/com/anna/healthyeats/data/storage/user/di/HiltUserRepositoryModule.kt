package com.anna.healthyeats.data.storage.user.di

import com.anna.healthyeats.data.storage.user.FirestoreUserRepositoryImpl
import com.anna.healthyeats.data.storage.user.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class HiltUserRepositoryModule {
  @ViewModelScoped
  @Binds
  abstract fun bindUserRepository(
    userRepositoryImpl: FirestoreUserRepositoryImpl
  ): UserRepository
}