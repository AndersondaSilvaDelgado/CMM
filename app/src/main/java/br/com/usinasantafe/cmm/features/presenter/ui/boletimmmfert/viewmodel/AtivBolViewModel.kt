package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.entities.stable.Atividade
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetIdAtivBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.ListAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverAtividade
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AtivBolViewModel @Inject constructor (
    private val setIdAtivBoletimMMFert: SetIdAtivBoletimMMFert,
    private val listAtiv: ListAtiv,
    private val recoverAtividade: RecoverAtividade
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<AtivBolFragmentState>(AtivBolFragmentState.Init)
    val uiStateFlow: StateFlow<AtivBolFragmentState> get() = _uiStateFlow

    private val _resultUpdateDataBase = MutableStateFlow<ResultUpdateDataBase?>(null)
    val resultUpdateDataBase : StateFlow<ResultUpdateDataBase?> get() = _resultUpdateDataBase

    private fun setListAtiv(ativList: List<Atividade>){
        _uiStateFlow.value = AtivBolFragmentState.ListAtiv(ativList)
    }

    private fun showUpdateTurno(){
        _uiStateFlow.value = AtivBolFragmentState.IsUpdateAtiv(true)
    }

    private fun hideUpdateTurno(){
        _uiStateFlow.value = AtivBolFragmentState.IsUpdateAtiv(false)
    }

    fun recoverListAtiv() = viewModelScope.launch {
        setListAtiv(listAtiv())
    }

    fun setIdAtiv(atividade: Atividade) = viewModelScope.launch {
        setIdAtivBoletimMMFert(atividade.idAtiv)
    }

    fun updateDataAtiv() =
        viewModelScope.launch {
            recoverAtividade().
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

sealed class AtivBolFragmentState {
    object Init : AtivBolFragmentState()
    data class ListAtiv(val ativList: List<Atividade>) : AtivBolFragmentState()
    data class IsUpdateAtiv(val isUpdateAtiv: Boolean) : AtivBolFragmentState()
}
