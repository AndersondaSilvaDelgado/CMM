package br.com.usinasantafe.cmm.features.presenter.boletimmmfert.horimetrobol

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.ChoiceHorimetro
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckAbertoBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckHorimetroBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetHorimetroFinalBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetHorimetroInicialBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.GetHorimetroEquip
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HorimetroBolViewModel @Inject constructor (
    private val checkAbertoBoletimMMFert: CheckAbertoBoletimMMFert,
    private val checkHorimetroBoletimMMFert: CheckHorimetroBoletimMMFert,
    private val getHorimetroEquip: GetHorimetroEquip,
    private val setHorimetroInicialBoletimMMFert: SetHorimetroInicialBoletimMMFert,
    private val setHorimetroFinalBoletimMMFert: SetHorimetroFinalBoletimMMFert,
): ViewModel() {

    private val _uiLiveData = MutableLiveData<HorimetroBolFragmentState>()
    val uiLiveData: LiveData<HorimetroBolFragmentState> = _uiLiveData

    private fun checkHorimetro(checkHorimetro: Boolean){
        _uiLiveData.value = HorimetroBolFragmentState.CheckHorimetro(checkHorimetro)
    }

    private fun checkSetHorimetroInicial(choiceHorimetro: ChoiceHorimetro){
        _uiLiveData.value = HorimetroBolFragmentState.CheckSetHorimetroInicial(choiceHorimetro)
    }

    private fun checkSetHorimetroFinal(checkSetHorimetro: Boolean){
        _uiLiveData.value = HorimetroBolFragmentState.CheckSetHorimetroFinal(checkSetHorimetro)
    }

    private fun getHorimetro(horimetro: String){
        _uiLiveData.value = HorimetroBolFragmentState.HorimetroNonCompliant(horimetro)
    }

    fun checkHorimetro(horimetro: String) = viewModelScope.launch {
        checkHorimetro(checkHorimetroBoletimMMFert(horimetro))
    }

    fun recoverHorimetro() = viewModelScope.launch {
        getHorimetro(getHorimetroEquip())
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
            _uiLiveData.value = HorimetroBolFragmentState.HorimetroInicial
        } else {
            _uiLiveData.value = HorimetroBolFragmentState.HorimetroFinal
        }
    }

}

sealed class HorimetroBolFragmentState {
    object Init : HorimetroBolFragmentState()
    data class CheckHorimetro(val checkHorimetro: Boolean): HorimetroBolFragmentState()
    data class CheckSetHorimetroInicial(val choiceHorimetro: ChoiceHorimetro): HorimetroBolFragmentState()
    data class CheckSetHorimetroFinal(val checkSetHorimetroFinal: Boolean): HorimetroBolFragmentState()
    object HorimetroInicial : HorimetroBolFragmentState()
    object HorimetroFinal : HorimetroBolFragmentState()
    data class HorimetroNonCompliant(val horimetro: String): HorimetroBolFragmentState()
}