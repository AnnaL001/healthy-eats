package com.anna.healthyeats.ui.screens.ui.user_details.state

import cafe.adriel.voyager.core.model.screenModelScope
import com.anna.healthyeats.data.auth.AuthRepository
import com.anna.healthyeats.data.storage.user.UserRepository
import com.anna.healthyeats.model.resource.Resource
import com.anna.healthyeats.model.storage.User
import com.anna.healthyeats.ui.main.voyager_screens.HealthyEatsScreenModel
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserDetailsScreenModel @Inject constructor(
  private val authRepository: AuthRepository,
  private val userRepository: UserRepository
): HealthyEatsScreenModel<Resource<FirebaseUser>>() {

  private val currentUser = authRepository.loggedInUser!!

  fun addUserData(user: User){
    val finalUserData = addInitialUserData(user = user)

    screenModelScope.launch {
      mutableState.value = State.Loading
      mutableState.value = State.Result(result = userRepository.add(finalUserData))
    }
  }

  private fun addInitialUserData(user: User): User {
    user.id = currentUser.uid
    user.email = currentUser.email as String
    return user
  }
}

