package br.com.usinasantafe.cmm.features.presenter.viewmodel.apontmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.FlowNote
import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.entities.stable.Atividade
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetIdAtivApontMMFert
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
class AtivApontViewModel @Inject constructor (
    private val setIdAtivApontMMFert: SetIdAtivApontMMFert,
    private val listAtiv: ListAtiv,
    private val recoverAtividade: RecoverAtividade
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<AtivApontFragmentState>(AtivApontFragmentState.Init)
    val uiStateFlow: StateFlow<AtivApontFragmentState> get() = _uiStateFlow

    private val _resultUpdateDataBase = MutableStateFlow<ResultUpdateDataBase?>(null)
    val resultUpdateDataBase : StateFlow<ResultUpdateDataBase?> get() = _resultUpdateDataBase

    private fun setListAtiv(ativList: List<Atividade>){
        _uiStateFlow.value = AtivApontFragmentState.ListAtiv(ativList)
    }

    private fun showUpdateTurno(){
        _uiStateFlow.value = AtivApontFragmentState.IsUpdateAtiv(true)
    }

    private fun hideUpdateTurno(){
        _uiStateFlow.value = AtivApontFragmentState.IsUpdateAtiv(false)
    }

    private fun checkSetAtivApont(typeNote: TypeNote){
        _uiStateFlow.value = AtivApontFragmentState.CheckSetAtivApont(typeNote)
    }

    fun recoverListAtiv() = viewModelScope.launch {
        setListAtiv(listAtiv(FlowNote.APONTAMENTO))
    }

    fun setIdAtiv(atividade: Atividade) = viewModelScope.launch {
        checkSetAtivApont(setIdAtivApontMMFert(atividade.idAtiv))
    }

    fun updateDataAtiv() =
        viewModelScope.launch {
            recoverAtividade(FlowNote.APONTAMENTO).
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

sealed class AtivApontFragmentState {
    object Init : AtivApontFragmentState()
    data class ListAtiv(val ativList: List<Atividade>) : AtivApontFragmentState()
    data class IsUpdateAtiv(val isUpdateAtiv: Boolean) : AtivApontFragmentState()
    data class CheckSetAtivApont(val typeNote: TypeNote): AtivApontFragmentState()
}