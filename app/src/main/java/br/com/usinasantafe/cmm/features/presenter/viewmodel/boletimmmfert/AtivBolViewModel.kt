package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.FlowNote
import br.com.usinasantafe.cmm.features.domain.entities.stable.Ativ
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetIdAtivBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.ListAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverAtividade
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AtivBolViewModel @Inject constructor(
    private val setIdAtivBoletimMMFert: SetIdAtivBoletimMMFert,
    private val listAtiv: ListAtiv,
    private val recoverAtividade: RecoverAtividade
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<AtivBolFragmentState>(AtivBolFragmentState.Init)
    val uiStateFlow: StateFlow<AtivBolFragmentState> get() = _uiStateFlow

    private fun setListAtiv(ativList: List<Ativ>) {
        _uiStateFlow.value = AtivBolFragmentState.ListAtiv(ativList)
    }

    private fun showUpdateTurno() {
        _uiStateFlow.value = AtivBolFragmentState.IsUpdateAtiv(true)
    }

    private fun hideUpdateTurno() {
        _uiStateFlow.value = AtivBolFragmentState.IsUpdateAtiv(false)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase) {
        _uiStateFlow.value = AtivBolFragmentState.SetResultUpdate(resultUpdateDatabase)
    }

    private fun checkSetAtiv(checkSetAtiv: Boolean){
        _uiStateFlow.value = AtivBolFragmentState.CheckSetAtiv(checkSetAtiv)
    }

    fun recoverListAtiv() = viewModelScope.launch {
        setListAtiv(listAtiv(FlowNote.BOLETIM))
    }

    fun setIdAtiv(ativ: Ativ) = viewModelScope.launch {
        checkSetAtiv(setIdAtivBoletimMMFert(ativ.idAtiv))
    }

    fun updateDataAtiv() =
        viewModelScope.launch {
            recoverAtividade(FlowNote.BOLETIM)
                .onStart {
                    showUpdateTurno()
                }
                .catch { catch ->
                    setResultUpdate(ResultUpdateDatabase(1, "Erro: $catch", 100, 100))
                }
                .collect { resultUpdateDatabase ->
                    setResultUpdate(resultUpdateDatabase)
                    if (resultUpdateDatabase.percentage == 100) {
                        hideUpdateTurno()
                    }
                }
        }

}

sealed class AtivBolFragmentState {
    object Init : AtivBolFragmentState()
    data class CheckSetAtiv(val check: Boolean) : AtivBolFragmentState()
    data class ListAtiv(val ativList: List<Ativ>) : AtivBolFragmentState()
    data class IsUpdateAtiv(val isUpdateAtiv: Boolean) : AtivBolFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) : AtivBolFragmentState()
}