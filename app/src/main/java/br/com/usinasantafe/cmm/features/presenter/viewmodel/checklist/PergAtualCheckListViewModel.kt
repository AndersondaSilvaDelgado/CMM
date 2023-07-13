package br.com.usinasantafe.cmm.features.presenter.viewmodel.checklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverCheckList
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class PergAtualCheckListViewModel @Inject constructor (
    private val recoverCheckList: RecoverCheckList
): ViewModel(){

    private val _uiStateFlow = MutableStateFlow<PergAtualCheckListFragmentState>(PergAtualCheckListFragmentState.Init)
    val uiStateFlow: StateFlow<PergAtualCheckListFragmentState> get() = _uiStateFlow

    private fun setStatusUpdate(statusUpdate: StatusUpdate) {
        _uiStateFlow.value = PergAtualCheckListFragmentState.FeedbackUpdate(statusUpdate)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase){
        _uiStateFlow.value = PergAtualCheckListFragmentState.SetResultUpdate(resultUpdateDatabase)
    }

    fun updateDataCheckList() =
        viewModelScope.launch {
            recoverCheckList()
                .catch { catch ->
                    setResultUpdate(ResultUpdateDatabase(1, "Erro: $catch", 100, 100))
                    setStatusUpdate(StatusUpdate.FALHA)
                }
                .collect { resultUpdateDatabase ->
                    setResultUpdate(resultUpdateDatabase)
                    if (resultUpdateDatabase.percentage == 100) {
                        setStatusUpdate(StatusUpdate.ATUALIZADO)
                    }
                }
        }

}

sealed class PergAtualCheckListFragmentState {
    object Init : PergAtualCheckListFragmentState()
    data class FeedbackUpdate(val statusUpdate: StatusUpdate) : PergAtualCheckListFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) : PergAtualCheckListFragmentState()
}