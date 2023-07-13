package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusRecover
import br.com.usinasantafe.cmm.common.utils.WEB_RETURN_CLEAR_OS
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.RecoverNroOSBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetNroOSBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckNroOS
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OSBolViewModel @Inject constructor(
    private val checkNroOS: CheckNroOS,
    private val setNroOSBoletimMMFert: SetNroOSBoletimMMFert,
    private val recoverNroOSBoletimMMFert: RecoverNroOSBoletimMMFert
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<OSBolFragmentState>(OSBolFragmentState.Init)
    val uiStateFlow: StateFlow<OSBolFragmentState> get() = _uiStateFlow

    private fun checkOS(checkNroOS: Boolean) {
        _uiStateFlow.value = OSBolFragmentState.CheckNroOS(checkNroOS)
    }

    private fun checkSetNroOS(checkSetNroOS: Boolean) {
        _uiStateFlow.value = OSBolFragmentState.CheckSetNroOS(checkSetNroOS)
    }

    private fun setStatusRecoverOS(statusRecover: StatusRecover) {
        _uiStateFlow.value = OSBolFragmentState.FeedbackUpdateOS(statusRecover)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase){
        _uiStateFlow.value = OSBolFragmentState.SetResultUpdate(resultUpdateDatabase)
    }

    fun checkDataNroOS(nroOS: String) = viewModelScope.launch {
        checkOS(checkNroOS(nroOS))
    }

    fun setNroOS(nroOS: String) = viewModelScope.launch {
        checkSetNroOS(setNroOSBoletimMMFert(nroOS))
    }

    fun recoverDataOS(nroOS: String) =
        viewModelScope.launch {
            recoverNroOSBoletimMMFert(nroOS)
                .catch { catch ->
                    setResultUpdate(ResultUpdateDatabase(1, "Erro: $catch", 100, 100))
                    setStatusRecoverOS(StatusRecover.FALHA)
                }
                .collect { resultUpdateDatabase ->
                    setResultUpdate(resultUpdateDatabase)
                    if (resultUpdateDatabase.percentage == 100) {
                        if (resultUpdateDatabase.describe == WEB_RETURN_CLEAR_OS) {
                            setStatusRecoverOS(StatusRecover.VAZIO)
                        } else {
                            setStatusRecoverOS(StatusRecover.SUCESSO)
                        }
                    }
                }

        }
}

sealed class OSBolFragmentState {
    object Init : OSBolFragmentState()
    data class CheckNroOS(val checkNroOS: Boolean) : OSBolFragmentState()
    data class CheckSetNroOS(val checkSetNroOS: Boolean) : OSBolFragmentState()
    data class FeedbackUpdateOS(val statusRecover: StatusRecover) : OSBolFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) : OSBolFragmentState()
}