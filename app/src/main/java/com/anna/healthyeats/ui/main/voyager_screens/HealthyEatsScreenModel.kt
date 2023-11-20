package com.anna.healthyeats.ui.main.voyager_screens

import cafe.adriel.voyager.core.model.StateScreenModel
import com.anna.healthyeats.model.resource.AsyncResource

interface AppStateScreenModel{}

abstract class HealthyEatsScreenModel<R: AsyncResource>: StateScreenModel<HealthyEatsScreenModel.State>(
  State.Initial
), AppStateScreenModel {
  sealed class State {
    data object Initial : State()
    data object Loading : State()
    data class Result<R>(val result: R) : State()
  }
}
