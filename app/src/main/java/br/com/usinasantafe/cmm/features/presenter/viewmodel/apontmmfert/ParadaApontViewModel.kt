package br.com.usinasantafe.cmm.features.presenter.viewmodel.apontmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.FlowNote
import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.entities.stable.Parada
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.ListParada
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetIdParadaApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ParadaApontViewModel @Inject constructor (
    private val listParada: ListParada,
    private val setIdParadaApontMMFert: SetIdParadaApontMMFert,
    private val recoverParada: RecoverParada
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<ParadaApontFragmentState>(ParadaApontFragmentState.Init)
    val uiStateFlow: StateFlow<ParadaApontFragmentState> get() = _uiStateFlow

    private fun setListParada(paradaList: List<Parada>) {
        _uiStateFlow.value = ParadaApontFragmentState.ListParada(paradaList)
    }

    private fun checkSetParadaApont(check: Boolean) {
        _uiStateFlow.value = ParadaApontFragmentState.CheckSetParadaApont(check)
    }

    private fun showUpdateParada() {
        _uiStateFlow.value = ParadaApontFragmentState.IsUpdateParada(true)
    }

    private fun hideUpdateParada() {
        _uiStateFlow.value = ParadaApontFragmentState.IsUpdateParada(false)
    }

    private fun setResultUpdate(resultUpdateDataBase: ResultUpdateDataBase) {
        _uiStateFlow.value = ParadaApontFragmentState.SetResultUpdate(resultUpdateDataBase)
    }

    fun setIdParada(parada: Parada) = viewModelScope.launch {
        checkSetParadaApont(setIdParadaApontMMFert(parada.idParada))
    }

    fun recoverListParada() = viewModelScope.launch {
        setListParada(listParada())
    }
    fun updateDataParada() =
        viewModelScope.launch {
            recoverParada()
                .onStart {
                    showUpdateParada()
                }
                .catch { catch ->
                    setResultUpdate(ResultUpdateDataBase(1, "Erro: $catch", 100, 100))
                }
                .collect { resultUpdateDataBase ->
                    setResultUpdate(resultUpdateDataBase)
                    if (resultUpdateDataBase.percentage == 100) {
                        hideUpdateParada()
                    }
                }
        }

}

sealed class ParadaApontFragmentState {
    object Init : ParadaApontFragmentState()
    data class ListParada(val paradaList: List<Parada>) : ParadaApontFragmentState()
    data class IsUpdateParada(val isUpdateParada: Boolean) : ParadaApontFragmentState()
    data class CheckSetParadaApont(val check: Boolean) : ParadaApontFragmentState()
    data class SetResultUpdate(val resultUpdateDataBase: ResultUpdateDataBase) :
        ParadaApontFragmentState()
}