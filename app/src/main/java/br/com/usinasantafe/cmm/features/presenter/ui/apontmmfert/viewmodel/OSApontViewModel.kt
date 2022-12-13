package br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetNroOSApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckNroOS
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverOS
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.OSBolFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OSApontViewModel @Inject constructor (
    private val checkNroOS: CheckNroOS,
    private val recoverOS: RecoverOS,
    private val setNroOSApontMMFert: SetNroOSApontMMFert
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<OSApontFragmentState>(OSApontFragmentState.Init)
    val uiStateFlow: StateFlow<OSApontFragmentState> get() = _uiStateFlow

    private val _resultUpdateDataBase = MutableStateFlow<ResultUpdateDataBase?>(null)
    val resultUpdateDataBase: StateFlow<ResultUpdateDataBase?> get() = _resultUpdateDataBase

    private fun checkOS(checkNroOS: Boolean) {
        _uiStateFlow.value = OSApontFragmentState.CheckNroOS(checkNroOS)
    }

    private fun checkSetNroOS(checkSetNroOS: Boolean) {
        _uiStateFlow.value = OSApontFragmentState.CheckSetNroOS(checkSetNroOS)
    }

    fun checkDataNroOS(nroOS: String) = viewModelScope.launch {
        checkOS(checkNroOS(nroOS))
    }

    fun setNroOS(nroOS: String) = viewModelScope.launch {
        checkSetNroOS(setNroOSApontMMFert(nroOS))
    }

    fun recoverDataOS(nroOS: String) =
        viewModelScope.launch {
            recoverOS(nroOS)
                .catch { catch ->
                    _resultUpdateDataBase.value = ResultUpdateDataBase(1, "Erro: $catch", 100, 100)
                }
                .collect { resultUpdateDataBase ->
                    _resultUpdateDataBase.value = resultUpdateDataBase
                }

        }
}

sealed class OSApontFragmentState {
    object Init : OSApontFragmentState()
    data class CheckNroOS(val checkNroOS: Boolean) : OSApontFragmentState()
    data class CheckSetNroOS(val checkSetNroOS: Boolean) : OSApontFragmentState()
}