package br.com.usinasantafe.cmm.features.presenter.apontmmfert.ativapont

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.FlowNote
import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.entities.stable.Ativ
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetIdAtivApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.ListAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverAtividade
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AtivApontViewModel @Inject constructor(
    private val setIdAtivApontMMFert: SetIdAtivApontMMFert,
    private val listAtiv: ListAtiv,
    private val recoverAtividade: RecoverAtividade
) : ViewModel() {

    private val _uiLiveData = MutableLiveData<AtivApontFragmentState>()
    val uiLiveData: LiveData<AtivApontFragmentState> = _uiLiveData

    private fun setListAtiv(ativList: List<Ativ>) {
        _uiLiveData.value = AtivApontFragmentState.ListAtiv(ativList)
    }

    private fun checkSetAtivApont(typeNote: TypeNote) {
        _uiLiveData.value = AtivApontFragmentState.CheckSetAtivApont(typeNote)
    }

    private fun showUpdateAtiv() {
        _uiLiveData.value = AtivApontFragmentState.IsUpdateAtiv(true)
    }

    private fun hideUpdateAtiv() {
        _uiLiveData.value = AtivApontFragmentState.IsUpdateAtiv(false)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase) {
        _uiLiveData.value = AtivApontFragmentState.SetResultUpdate(resultUpdateDatabase)
    }

    fun recoverListAtiv() = viewModelScope.launch {
        setListAtiv(listAtiv(FlowNote.APONTAMENTO))
    }

    fun setIdAtiv(ativ: Ativ) = viewModelScope.launch {
        checkSetAtivApont(setIdAtivApontMMFert(ativ.idAtiv))
    }

    fun updateDataAtiv() =
        viewModelScope.launch {
            recoverAtividade(FlowNote.APONTAMENTO)
                .onStart {
                    showUpdateAtiv()
                }
                .catch { catch ->
                    setResultUpdate(ResultUpdateDatabase(1, "Erro: $catch", 100, 100))
                }
                .collect { resultUpdateDatabase ->
                    setResultUpdate(resultUpdateDatabase)
                    if (resultUpdateDatabase.percentage == 100) {
                        hideUpdateAtiv()
                    }
                }
        }

}

sealed class AtivApontFragmentState {
    data class ListAtiv(val ativList: List<Ativ>) : AtivApontFragmentState()
    data class IsUpdateAtiv(val isUpdateAtiv: Boolean) : AtivApontFragmentState()
    data class CheckSetAtivApont(val typeNote: TypeNote) : AtivApontFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) :
        AtivApontFragmentState()
}