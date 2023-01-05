package br.com.usinasantafe.cmm.features.presenter.viewmodel.config

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.HasConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.RecoverConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuInicialViewModel @Inject constructor (
    private val hasConfig: HasConfig,
    private val recoverConfig: RecoverConfig
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<MenuInicialFragmentState>(MenuInicialFragmentState.Init)
    val uiStateFlow: StateFlow<MenuInicialFragmentState> get() = _uiStateFlow

    private fun hasConfig(hasConfig: Boolean){
        _uiStateFlow.value = MenuInicialFragmentState.HasConfig(hasConfig)
    }

    private fun setStatusSend(statusSend: StatusSend){
        _uiStateFlow.value = MenuInicialFragmentState.GetStatusSend(statusSend)
    }

    fun checkAccessBoletim() = viewModelScope.launch {
        hasConfig(hasConfig())
    }

    fun checkStatusSend() = viewModelScope.launch {
        if(hasConfig()){
            setStatusSend(recoverConfig()!!.statusEnvio)
        } else {
            setStatusSend(StatusSend.VAZIO)
        }
    }

}

sealed class MenuInicialFragmentState {
    object Init : MenuInicialFragmentState()
    data class HasConfig(val hasConfig: Boolean) : MenuInicialFragmentState()
    data class GetStatusSend(val statusSend: StatusSend) : MenuInicialFragmentState()
}