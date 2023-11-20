package com.anna.healthyeats.data.auth.di

import com.anna.healthyeats.data.auth.AuthRepository
import com.anna.healthyeats.data.auth.FirebaseAuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthRepositoryModule {
  @Provides
  fun getFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

  @Provides
  fun bindAuthRepository(authRepositoryImpl: FirebaseAuthRepositoryImpl): AuthRepository = authRepositoryImpl
}


