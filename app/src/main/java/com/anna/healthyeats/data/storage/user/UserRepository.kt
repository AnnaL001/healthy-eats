package com.anna.healthyeats.data.storage.user

interface UserRepository {
  suspend fun add()
  suspend fun get()
}