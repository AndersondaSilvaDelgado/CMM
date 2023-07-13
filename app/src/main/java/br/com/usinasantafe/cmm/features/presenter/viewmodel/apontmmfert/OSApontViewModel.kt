package br.com.usinasantafe.cmm.features.presenter.viewmodel.apontmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusRecover
import br.com.usinasantafe.cmm.common.utils.WEB_RETURN_CLEAR_OS
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.RecoverNroOSApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetNroOSApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckNroOS
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OSApontViewModel @Inject constructor (
    private val checkNroOS: CheckNroOS,
    private val recoverNroOSApontMMFert: RecoverNroOSApontMMFert,
    private val setNroOSApontMMFert: SetNroOSApontMMFert
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<OSApontFragmentState>(OSApontFragmentState.Init)
    val uiStateFlow: StateFlow<OSApontFragmentState> get() = _uiStateFlow

    private fun checkOS(checkNroOS: Boolean) {
        _uiStateFlow.value = OSApontFragmentState.CheckNroOS(checkNroOS)
    }

    private fun checkSetNroOS(checkSetNroOS: Boolean) {
        _uiStateFlow.value = OSApontFragmentState.CheckSetNroOS(checkSetNroOS)
    }

    private fun setStatusRecoverOS(statusRecover: StatusRecover) {
        _uiStateFlow.value = OSApontFragmentState.FeedbackUpdateOS(statusRecover)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase){
        _uiStateFlow.value = OSApontFragmentState.SetResultUpdate(resultUpdateDatabase)
    }

    fun checkDataNroOS(nroOS: String) = viewModelScope.launch {
        checkOS(checkNroOS(nroOS))
    }

    fun setNroOS(nroOS: String) = viewModelScope.launch {
        checkSetNroOS(setNroOSApontMMFert(nroOS))
    }

    fun recoverDataOS(nroOS: String) =
        viewModelScope.launch {
            recoverNroOSApontMMFert(nroOS)
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

sealed class OSApontFragmentState {
    object Init : OSApontFragmentState()
    data class CheckNroOS(val checkNroOS: Boolean) : OSApontFragmentState()
    data class CheckSetNroOS(val checkSetNroOS: Boolean) : OSApontFragmentState()
    data class FeedbackUpdateOS(val statusRecover: StatusRecover) : OSApontFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) : OSApontFragmentState()
}