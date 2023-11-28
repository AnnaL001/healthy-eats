package com.anna.healthyeats.data.storage

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

abstract class FirestoreRepository(collectionName: String) {
  private val _db get() = Firebase.firestore
  val dbCollection = _db.collection(collectionName)
}