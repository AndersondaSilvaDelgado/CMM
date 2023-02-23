package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckAbertoBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetHorimetroFinalBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetHorimetroInicialBoletimMMFert
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HorimetroBolViewModel @Inject constructor (
    private val checkAbertoBoletimMMFert: CheckAbertoBoletimMMFert,
    private val setHorimetroInicialBoletimMMFert: SetHorimetroInicialBoletimMMFert,
    private val setHorimetroFinalBoletimMMFert: SetHorimetroFinalBoletimMMFert
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<HorimetroBolFragmentState>(HorimetroBolFragmentState.Init)
    val uiStateFlow: StateFlow<HorimetroBolFragmentState> get() = _uiStateFlow

    private fun checkSetHorimetroInicial(checkSetHorimetro: Boolean){
        _uiStateFlow.value = HorimetroBolFragmentState.CheckSetHorimetroInicial(checkSetHorimetro)
    }

    private fun checkSetHorimetroFinal(checkSetHorimetro: Boolean){
        _uiStateFlow.value = HorimetroBolFragmentState.CheckSetHorimetroFinal(checkSetHorimetro)
    }

    fun setHorimetro(horimetro: String) = viewModelScope.launch {
        if(!checkAbertoBoletimMMFert()) {
            checkSetHorimetroInicial(setHorimetroInicialBoletimMMFert(horimetro))
        } else {
            checkSetHorimetroFinal(setHorimetroFinalBoletimMMFert(horimetro))
        }
    }

    fun checkBoletim() = viewModelScope.launch {
        if(!checkAbertoBoletimMMFert()) {
            _uiStateFlow.value = HorimetroBolFragmentState.HorimetroInicial
        } else {
            _uiStateFlow.value = HorimetroBolFragmentState.HorimetroFinal
        }
    }

}

sealed class HorimetroBolFragmentState {
    object Init : HorimetroBolFragmentState()
    data class CheckSetHorimetroInicial(val checkSetHorimetroInicial: Boolean): HorimetroBolFragmentState()
    data class CheckSetHorimetroFinal(val checkSetHorimetroFinal: Boolean): HorimetroBolFragmentState()
    object HorimetroInicial : HorimetroBolFragmentState()
    object HorimetroFinal : HorimetroBolFragmentState()
}