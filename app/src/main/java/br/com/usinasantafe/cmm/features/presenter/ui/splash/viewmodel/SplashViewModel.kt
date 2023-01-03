package br.com.usinasantafe.cmm.features.presenter.ui.splash.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckAbertoBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartSendData
import br.com.usinasantafe.cmm.features.presenter.ui.config.viewmodel.MenuInicialFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val startSendData: StartSendData,
    private val checkAbertoBoletimMMFert: CheckAbertoBoletimMMFert
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<SplashState>(SplashState.Init)
    val uiStateFlow: StateFlow<SplashState> get() = _uiStateFlow

    private fun checkData(checkData: Boolean) {
        _uiStateFlow.value = SplashState.CheckData(checkData)
    }

    fun startSent() = viewModelScope.launch {
        startSendData()
        checkData(checkAbertoBoletimMMFert())
    }

}

sealed class SplashState {
    object Init : SplashState()
    data class CheckData(val checkData: Boolean) : SplashState()
}