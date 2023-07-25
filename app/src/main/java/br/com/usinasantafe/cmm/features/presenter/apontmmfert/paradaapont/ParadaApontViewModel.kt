package br.com.usinasantafe.cmm.features.presenter.apontmmfert.paradaapont

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.entities.stable.Parada
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.ListParada
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetIdParadaApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverParada
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
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

    private val _uiLiveData = MutableLiveData<ParadaApontFragmentState>()
    val uiLiveData: LiveData<ParadaApontFragmentState> = _uiLiveData

    private fun setListParada(paradaList: List<Parada>) {
        _uiLiveData.value = ParadaApontFragmentState.ListParada(paradaList)
    }

    private fun checkSetParadaApont(check: Boolean) {
        _uiLiveData.value = ParadaApontFragmentState.CheckSetParadaApont(check)
    }

    private fun showUpdateParada() {
        _uiLiveData.value = ParadaApontFragmentState.IsUpdateParada(true)
    }

    private fun hideUpdateParada() {
        _uiLiveData.value = ParadaApontFragmentState.IsUpdateParada(false)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase) {
        _uiLiveData.value = ParadaApontFragmentState.SetResultUpdate(resultUpdateDatabase)
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
                    setResultUpdate(ResultUpdateDatabase(1, "Erro: $catch", 100, 100))
                }
                .collect { resultUpdateDatabase ->
                    setResultUpdate(resultUpdateDatabase)
                    if (resultUpdateDatabase.percentage == 100) {
                        hideUpdateParada()
                    }
                }
        }

}

sealed class ParadaApontFragmentState {
    data class ListParada(val paradaList: List<Parada>) : ParadaApontFragmentState()
    data class IsUpdateParada(val isUpdateParada: Boolean) : ParadaApontFragmentState()
    data class CheckSetParadaApont(val check: Boolean) : ParadaApontFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) :
        ParadaApontFragmentState()
}