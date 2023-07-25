package br.com.usinasantafe.cmm.features.presenter.boletimmmfert.osbol

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusRecover
import br.com.usinasantafe.cmm.common.utils.WEB_RETURN_CLEAR_OS
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.RecoverNroOSBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetNroOSBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckNroOS
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OSBolViewModel @Inject constructor(
    private val checkNroOS: CheckNroOS,
    private val setNroOSBoletimMMFert: SetNroOSBoletimMMFert,
    private val recoverNroOSBoletimMMFert: RecoverNroOSBoletimMMFert
) : ViewModel() {

    private val _uiLiveData = MutableLiveData<OSBolFragmentState>()
    val uiLiveData: LiveData<OSBolFragmentState> = _uiLiveData

    private fun checkOS(checkNroOS: Boolean) {
        _uiLiveData.value = OSBolFragmentState.CheckNroOS(checkNroOS)
    }

    private fun checkSetNroOS(checkSetNroOS: Boolean) {
        _uiLiveData.value = OSBolFragmentState.CheckSetNroOS(checkSetNroOS)
    }

    private fun setStatusRecoverOS(statusRecover: StatusRecover) {
        _uiLiveData.value = OSBolFragmentState.FeedbackUpdateOS(statusRecover)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase){
        _uiLiveData.value = OSBolFragmentState.SetResultUpdate(resultUpdateDatabase)
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
    data class CheckNroOS(val checkNroOS: Boolean) : OSBolFragmentState()
    data class CheckSetNroOS(val checkSetNroOS: Boolean) : OSBolFragmentState()
    data class FeedbackUpdateOS(val statusRecover: StatusRecover) : OSBolFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) : OSBolFragmentState()
}