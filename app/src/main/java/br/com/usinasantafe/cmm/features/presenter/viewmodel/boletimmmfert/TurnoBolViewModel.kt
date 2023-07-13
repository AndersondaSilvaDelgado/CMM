package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.features.domain.entities.stable.Turno
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetIdTurnoBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.ListTurno
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateTurno
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TurnoBolViewModel @Inject constructor(
    private val setIdTurnoBoletimMMFert: SetIdTurnoBoletimMMFert,
    private val listTurno: ListTurno,
    private val updateTurno: UpdateTurno
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<TurnoBolFragmentState>(TurnoBolFragmentState.Init)
    val uiStateFlow: StateFlow<TurnoBolFragmentState> get() = _uiStateFlow

    private fun setListTurno(turnoList: List<Turno>) {
        _uiStateFlow.value = TurnoBolFragmentState.ListTurno(turnoList)
    }

    private fun setStatusUpdateTurno(statusUpdate: StatusUpdate) {
        _uiStateFlow.value = TurnoBolFragmentState.FeedbackUpdateTurno(statusUpdate)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase){
        _uiStateFlow.value = TurnoBolFragmentState.SetResultUpdate(resultUpdateDatabase)
    }

    private fun checkSetTurno(checkSetTurno: Boolean){
        _uiStateFlow.value = TurnoBolFragmentState.CheckSetTurno(checkSetTurno)
    }

    fun recoverListTurno() = viewModelScope.launch {
        setListTurno(listTurno())
    }

    fun setIdTurno(turno: Turno) = viewModelScope.launch {
        checkSetTurno(setIdTurnoBoletimMMFert(turno.idTurno))
    }

    fun updateDataTurno() =
        viewModelScope.launch {
            updateTurno()
                .catch { catch ->
                    setResultUpdate(ResultUpdateDatabase(1, "Erro: $catch", 100, 100))
                    setStatusUpdateTurno(StatusUpdate.FALHA)
                }
                .collect { resultUpdateDatabase ->
                    setResultUpdate(resultUpdateDatabase)
                    if (resultUpdateDatabase.percentage == 100) {
                        setStatusUpdateTurno(StatusUpdate.ATUALIZADO)
                    }
                }
        }

}

sealed class TurnoBolFragmentState {
    object Init : TurnoBolFragmentState()
    data class CheckSetTurno(val check: Boolean) : TurnoBolFragmentState()
    data class ListTurno(val turnoList: List<Turno>) : TurnoBolFragmentState()
    data class FeedbackUpdateTurno(val statusUpdate: StatusUpdate) : TurnoBolFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) : TurnoBolFragmentState()
}