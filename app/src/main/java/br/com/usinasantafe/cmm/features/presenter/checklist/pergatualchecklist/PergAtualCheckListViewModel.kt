package br.com.usinasantafe.cmm.features.presenter.checklist.pergatualchecklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverCheckList
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class PergAtualCheckListViewModel @Inject constructor (
    private val recoverCheckList: RecoverCheckList
): ViewModel(){

    private val _uiLiveData = MutableLiveData<PergAtualCheckListFragmentState>()
    val uiLiveData: LiveData<PergAtualCheckListFragmentState> = _uiLiveData

    private fun setStatusUpdate(statusUpdate: StatusUpdate) {
        _uiLiveData.value = PergAtualCheckListFragmentState.FeedbackUpdate(statusUpdate)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase){
        _uiLiveData.value = PergAtualCheckListFragmentState.SetResultUpdate(resultUpdateDatabase)
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
    data class FeedbackUpdate(val statusUpdate: StatusUpdate) : PergAtualCheckListFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) : PergAtualCheckListFragmentState()
}