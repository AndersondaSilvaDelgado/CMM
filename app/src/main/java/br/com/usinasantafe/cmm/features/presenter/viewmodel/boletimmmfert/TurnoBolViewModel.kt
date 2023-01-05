package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.entities.stable.Turno
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetIdTurnoBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.ListTurno
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateTurno
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TurnoBolViewModel @Inject constructor (
    private val setIdTurnoBoletimMMFert: SetIdTurnoBoletimMMFert,
    private val listTurno: ListTurno,
    private val updateTurno: UpdateTurno
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<TurnoBolFragmentState>(TurnoBolFragmentState.Init)
    val uiStateFlow: StateFlow<TurnoBolFragmentState> get() = _uiStateFlow

    private val _resultUpdateDataBase = MutableStateFlow<ResultUpdateDataBase?>(null)
    val resultUpdateDataBase : StateFlow<ResultUpdateDataBase?> get() = _resultUpdateDataBase

    private fun setListTurno(turnoList: List<Turno>){
        _uiStateFlow.value = TurnoBolFragmentState.ListTurno(turnoList)
    }

    private fun showUpdateTurno(){
        _uiStateFlow.value = TurnoBolFragmentState.IsUpdateTurno(true)
    }

    private fun hideUpdateTurno(){
        _uiStateFlow.value = TurnoBolFragmentState.IsUpdateTurno(false)
    }

    fun recoverListTurno() = viewModelScope.launch {
        setListTurno(listTurno())
    }

    fun setIdTurno(turno: Turno) = viewModelScope.launch {
        setIdTurnoBoletimMMFert(turno.idTurno)
    }

    fun updateDataTurno() =
        viewModelScope.launch {
            updateTurno().
            onStart {
                showUpdateTurno()
            }
            .catch { catch ->
                _resultUpdateDataBase.value = ResultUpdateDataBase(1, "Erro: $catch", 100, 100)
            }
            .collect{ resultUpdateDataBase ->
                _resultUpdateDataBase.value = resultUpdateDataBase
                if(resultUpdateDataBase.percentage == 100){
                    hideUpdateTurno()
                }
            }
        }

}

sealed class TurnoBolFragmentState {
    object Init : TurnoBolFragmentState()
    data class ListTurno(val turnoList: List<Turno>) : TurnoBolFragmentState()
    data class IsUpdateTurno(val isUpdateTurno: Boolean) : TurnoBolFragmentState()
}