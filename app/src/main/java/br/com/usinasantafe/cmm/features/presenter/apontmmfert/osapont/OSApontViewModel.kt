package br.com.usinasantafe.cmm.features.presenter.apontmmfert.osapont

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusRecover
import br.com.usinasantafe.cmm.common.utils.WEB_RETURN_CLEAR_OS
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.RecoverNroOSApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetNroOSApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckNroOS
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OSApontViewModel @Inject constructor (
    private val checkNroOS: CheckNroOS,
    private val recoverNroOSApontMMFert: RecoverNroOSApontMMFert,
    private val setNroOSApontMMFert: SetNroOSApontMMFert
): ViewModel() {

    private val _uiLiveData = MutableLiveData<OSApontFragmentState>()
    val uiLiveData: LiveData<OSApontFragmentState> = _uiLiveData

    private fun checkOS(checkNroOS: Boolean) {
        _uiLiveData.value = OSApontFragmentState.CheckNroOS(checkNroOS)
    }

    private fun checkSetNroOS(checkSetNroOS: Boolean) {
        _uiLiveData.value = OSApontFragmentState.CheckSetNroOS(checkSetNroOS)
    }

    private fun setStatusRecoverOS(statusRecover: StatusRecover) {
        _uiLiveData.value = OSApontFragmentState.FeedbackUpdateOS(statusRecover)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase){
        _uiLiveData.value = OSApontFragmentState.SetResultUpdate(resultUpdateDatabase)
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
    data class CheckNroOS(val checkNroOS: Boolean) : OSApontFragmentState()
    data class CheckSetNroOS(val checkSetNroOS: Boolean) : OSApontFragmentState()
    data class FeedbackUpdateOS(val statusRecover: StatusRecover) : OSApontFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) : OSApontFragmentState()
}