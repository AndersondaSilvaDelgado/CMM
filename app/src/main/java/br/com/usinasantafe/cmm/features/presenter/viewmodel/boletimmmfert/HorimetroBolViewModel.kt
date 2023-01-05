package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetHorimetroInicialBoletimMMFert
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HorimetroBolViewModel @Inject constructor (
    private val setHorimetroInicialBoletimMMFert: SetHorimetroInicialBoletimMMFert
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<HorimetroBolFragmentState>(HorimetroBolFragmentState.Init)
    val uiStateFlow: StateFlow<HorimetroBolFragmentState> get() = _uiStateFlow

    private fun checkSetHorimetro(checkSetHorimetro: Boolean){
        _uiStateFlow.value = HorimetroBolFragmentState.CheckSetHorimetro(checkSetHorimetro)
    }

    fun setHorimetroInicial(horimetro: String) = viewModelScope.launch {
        checkSetHorimetro(setHorimetroInicialBoletimMMFert(horimetro))
    }

}

sealed class HorimetroBolFragmentState {
    object Init : HorimetroBolFragmentState()
    data class CheckSetHorimetro(val checkSetHorimetro: Boolean): HorimetroBolFragmentState()
}