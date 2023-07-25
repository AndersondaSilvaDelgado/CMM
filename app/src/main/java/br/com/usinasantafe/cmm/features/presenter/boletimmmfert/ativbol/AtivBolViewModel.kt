package br.com.usinasantafe.cmm.features.presenter.boletimmmfert.ativbol

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.FlowNote
import br.com.usinasantafe.cmm.features.domain.entities.stable.Ativ
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetIdAtivBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.ListAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverAtividade
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
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

    private val _uiLiveData = MutableLiveData<AtivBolFragmentState>()
    val uiLiveData: LiveData<AtivBolFragmentState> = _uiLiveData

    private fun setListAtiv(ativList: List<Ativ>) {
        _uiLiveData.value = AtivBolFragmentState.ListAtiv(ativList)
    }

    private fun showUpdateTurno() {
        _uiLiveData.value = AtivBolFragmentState.IsUpdateAtiv(true)
    }

    private fun hideUpdateTurno() {
        _uiLiveData.value = AtivBolFragmentState.IsUpdateAtiv(false)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase) {
        _uiLiveData.value = AtivBolFragmentState.SetResultUpdate(resultUpdateDatabase)
    }

    private fun checkSetAtiv(checkSetAtiv: Boolean){
        _uiLiveData.value = AtivBolFragmentState.CheckSetAtiv(checkSetAtiv)
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
    data class CheckSetAtiv(val check: Boolean) : AtivBolFragmentState()
    data class ListAtiv(val ativList: List<Ativ>) : AtivBolFragmentState()
    data class IsUpdateAtiv(val isUpdateAtiv: Boolean) : AtivBolFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) : AtivBolFragmentState()
}