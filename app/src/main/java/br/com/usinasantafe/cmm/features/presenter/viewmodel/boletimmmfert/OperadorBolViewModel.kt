package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetMatricFuncBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckMatricOperador
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateFunc
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.viewmodel.config.ConfigFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
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

    private fun setStatusUpdateFunc(statusUpdate: StatusUpdate) {
        _uiStateFlow.value = OperadorBolFragmentState.FeedbackUpdateFunc(statusUpdate)
    }

    private fun setResultUpdate(resultUpdateDataBase: ResultUpdateDataBase){
        _uiStateFlow.value = OperadorBolFragmentState.SetResultUpdate(resultUpdateDataBase)
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
                    setResultUpdate(ResultUpdateDataBase(1, "Erro: $catch", 100, 100))
                    setStatusUpdateFunc(StatusUpdate.FALHA)
                }
                .collect { resultUpdateDataBase ->
                    setResultUpdate(resultUpdateDataBase)
                    if (resultUpdateDataBase.percentage == 100) {
                        setStatusUpdateFunc(StatusUpdate.ATUALIZADO)
                    }
                }
        }

}

sealed class OperadorBolFragmentState {
    object Init : OperadorBolFragmentState()
    data class CheckMatricFunc(val checkMatricOperador: Boolean) : OperadorBolFragmentState()
    data class CheckSetMatricFunc(val checkSetMatricOperador: Boolean) : OperadorBolFragmentState()
    data class FeedbackUpdateFunc(val statusUpdate: StatusUpdate) : OperadorBolFragmentState()
    data class SetResultUpdate(val resultUpdateDataBase: ResultUpdateDataBase) : OperadorBolFragmentState()
}