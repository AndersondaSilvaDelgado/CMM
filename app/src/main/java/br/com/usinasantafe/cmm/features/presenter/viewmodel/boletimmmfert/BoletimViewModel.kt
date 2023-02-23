package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.entities.stable.Ativ
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckAbertoBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.StartBoletimMMFert
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.viewmodel.config.SenhaFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoletimViewModel @Inject constructor (
    private val checkAbertoBoletimMMFert: CheckAbertoBoletimMMFert,
    private val startBoletimMMFert: StartBoletimMMFert
): ViewModel(){

    private val _uiStateFlow = MutableStateFlow<BoletimViewState>(BoletimViewState.Init)
    val uiStateFlow: StateFlow<BoletimViewState> get() = _uiStateFlow

    fun checkBoletim() = viewModelScope.launch {
        if(!checkAbertoBoletimMMFert()) {
            startBoletimMMFert()
            _uiStateFlow.value = BoletimViewState.StartBoletim
        } else {
            _uiStateFlow.value = BoletimViewState.FinishBoletim
        }
    }

}

sealed class BoletimViewState {
    object Init : BoletimViewState()
    object StartBoletim : BoletimViewState()
    object FinishBoletim : BoletimViewState()
}