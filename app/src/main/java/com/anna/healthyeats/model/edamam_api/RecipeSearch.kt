package com.anna.healthyeats.model.edamam_api

import com.anna.healthyeats.model.api.Hits


data class RecipeSearch (
   var hits : ArrayList<Hits> = arrayListOf()
)