package com.anna.healthyeats.data.storage.user

import com.anna.healthyeats.data.storage.FirestoreRepository
import com.anna.healthyeats.model.resource.Resource
import com.anna.healthyeats.model.storage.User
import com.anna.healthyeats.utils.firebase.await
import com.google.firebase.firestore.ktx.toObject

class FirestoreUserRepositoryImpl : UserRepository, FirestoreRepository(COLLECTION_NAME) {
  override suspend fun add(user: User): Resource<Boolean> {
    return try {
      dbCollection.document(user.id).set(user).await()
      Resource.Success(true)
    } catch (e: Exception){
      Resource.Failure(e)
    }
  }

  override suspend fun get(userId: String): Resource<User> {
    return try {
      val result = dbCollection.document(userId).get().await()
      val userData = result.toObject<User>()!!
      Resource.Success(userData)
    } catch (e: Exception){
      Resource.Failure(e)
    }
  }

  companion object{
    const val COLLECTION_NAME = "users"
  }
}