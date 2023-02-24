package br.com.usinasantafe.cmm.features.presenter.viewmodel.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.PointerStart
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.StartApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val startAPP: StartApp
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<SplashState>(SplashState.Init)
    val uiStateFlow: StateFlow<SplashState> get() = _uiStateFlow

    private fun checkData(pointerStart: PointerStart) {
        _uiStateFlow.value = SplashState.CheckStartAPP(pointerStart)
    }

    fun startSent() = viewModelScope.launch {
        checkData(startAPP())
    }

}

sealed class SplashState {
    object Init : SplashState()
    data class CheckStartAPP(val pointerStart: PointerStart) : SplashState()
}