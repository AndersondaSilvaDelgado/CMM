package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetMatricFuncBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckMatricOperador
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateFunc
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OperadorBolViewModel @Inject constructor(
    private val checkMatricOperador: CheckMatricOperador,
    private val setMatricFuncBoletimMMFert: SetMatricFuncBoletimMMFert,
    private val updateFunc: UpdateFunc
) : ViewModel() {

    private val _uiStateFlow =
        MutableStateFlow<OperadorBolFragmentState>(OperadorBolFragmentState.Init)
    val uiStateFlow: StateFlow<OperadorBolFragmentState> get() = _uiStateFlow

    private fun checkMatricOperador(checkMatricOperador: Boolean) {
        _uiStateFlow.value = OperadorBolFragmentState.CheckMatricFunc(checkMatricOperador)
    }

    private fun checkSetMatricOperador(checkSetMatricOperador: Boolean) {
        _uiStateFlow.value = OperadorBolFragmentState.CheckSetMatricFunc(checkSetMatricOperador)
    }

    private fun setStatusUpdate(statusUpdate: StatusUpdate) {
        _uiStateFlow.value = OperadorBolFragmentState.FeedbackUpdate(statusUpdate)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase){
        _uiStateFlow.value = OperadorBolFragmentState.SetResultUpdate(resultUpdateDatabase)
    }

    fun checkMatricFunc(matricOperador: String) = viewModelScope.launch {
        checkMatricOperador(checkMatricOperador(matricOperador))
    }

    fun setMatricFunc(matricOperador: String) = viewModelScope.launch {
        checkSetMatricOperador(setMatricFuncBoletimMMFert(matricOperador))
    }

    fun updateDataFunc() =
        viewModelScope.launch {
            updateFunc()
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

sealed class OperadorBolFragmentState {
    object Init : OperadorBolFragmentState()
    data class CheckMatricFunc(val checkMatricOperador: Boolean) : OperadorBolFragmentState()
    data class CheckSetMatricFunc(val checkSetMatricOperador: Boolean) : OperadorBolFragmentState()
    data class FeedbackUpdate(val statusUpdate: StatusUpdate) : OperadorBolFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) : OperadorBolFragmentState()
}