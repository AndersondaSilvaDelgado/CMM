package br.com.usinasantafe.cmm.features.presenter.ui.config.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.CheckPasswordConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SenhaViewModel @Inject constructor (
    private val checkPasswordConfig: CheckPasswordConfig
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<SenhaFragmentState>(SenhaFragmentState.Init)
    val uiStateFlow: StateFlow<SenhaFragmentState> get() = _uiStateFlow

    fun verificarSenha(senha: String) = viewModelScope.launch {
        if(checkPasswordConfig.invoke(senha)){
            _uiStateFlow.value = SenhaFragmentState.Success
        } else {
            _uiStateFlow.value = SenhaFragmentState.Error
        }
    }

}

sealed class SenhaFragmentState  {
    object Init : SenhaFragmentState()
    object Success : SenhaFragmentState()
    object Error : SenhaFragmentState()
}