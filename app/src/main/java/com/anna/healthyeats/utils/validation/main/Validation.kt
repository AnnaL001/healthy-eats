package com.anna.healthyeats.utils.validation.main

interface Validation<T>{
  fun validate(input: String): T
}