package com.anna.healthyeats.data.storage.user

import com.anna.healthyeats.model.resource.Resource
import com.anna.healthyeats.model.storage.User

interface UserRepository {
  suspend fun add(user: User): Resource<Boolean>
  suspend fun get(userId: String): Resource<User>
}