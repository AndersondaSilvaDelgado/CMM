package br.com.usinasantafe.cmm.features.presenter.ui.config.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.HasConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuInicialViewModel @Inject constructor (
    private val hasConfig: HasConfig
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<MenuInicialFragmentState>(MenuInicialFragmentState.Init)
    val uiStateFlow: StateFlow<MenuInicialFragmentState> get() = _uiStateFlow

    private fun hasConfig(hasConfig: Boolean){
        _uiStateFlow.value = MenuInicialFragmentState.HasConfig(hasConfig)
    }

    fun checkAccessBoletim() = viewModelScope.launch {
        hasConfig(hasConfig())
    }

}

sealed class MenuInicialFragmentState {
    object Init : MenuInicialFragmentState()
    data class HasConfig(val hasConfig: Boolean) : MenuInicialFragmentState()
}