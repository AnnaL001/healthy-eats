package com.anna.healthyeats.ui.screens.ui.auth.di

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.hilt.ScreenModelKey
import com.anna.healthyeats.ui.screens.ui.auth.login.state.LoginScreenModel
import com.anna.healthyeats.ui.screens.ui.auth.signup.state.SignUpScreenModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ActivityComponent::class)
abstract class HiltAuthModule {
  @Binds
  @IntoMap
  @ScreenModelKey(SignUpScreenModel::class)
  abstract fun bindSignUpScreenModel(signUpScreenModel: SignUpScreenModel): ScreenModel

  @Binds
  @IntoMap
  @ScreenModelKey(LoginScreenModel::class)
  abstract fun bindLoginScreenModel(loginScreenModel: LoginScreenModel): ScreenModel
}