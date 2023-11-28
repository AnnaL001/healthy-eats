package com.anna.healthyeats.model.storage

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class User(
  var id: String = "",
  var name: String = "",
  var email: String = "",
  var profilePhoto: String = "",
  var dietPref: List<String> = listOf(),
  var healthPref: List<String> = listOf(),
  var cuisine: List<String> = listOf(),
  @ServerTimestamp
  var createdOn: Date
)
