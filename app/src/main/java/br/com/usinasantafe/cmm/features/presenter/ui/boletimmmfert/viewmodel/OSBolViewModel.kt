package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetNroOSBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckNroOS
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverOS
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OSBolViewModel @Inject constructor(
    private val checkNroOS: CheckNroOS,
    private val recoverOS: RecoverOS,
    private val setNroOSBoletimMMFert: SetNroOSBoletimMMFert
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<OSBolFragmentState>(OSBolFragmentState.Init)
    val uiStateFlow: StateFlow<OSBolFragmentState> get() = _uiStateFlow

    private val _resultUpdateDataBase = MutableStateFlow<ResultUpdateDataBase?>(null)
    val resultUpdateDataBase: StateFlow<ResultUpdateDataBase?> get() = _resultUpdateDataBase

    private fun checkOS(checkNroOS: Boolean) {
        _uiStateFlow.value = OSBolFragmentState.CheckNroOS(checkNroOS)
    }

    private fun checkSetNroOS(checkSetNroOS: Boolean) {
        _uiStateFlow.value = OSBolFragmentState.CheckSetNroOS(checkSetNroOS)
    }

    fun checkDataNroOS(nroOS: String) = viewModelScope.launch {
        checkOS(checkNroOS(nroOS))
    }

    fun setNroOS(nroOS: String) = viewModelScope.launch {
        checkSetNroOS(setNroOSBoletimMMFert(nroOS))
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

sealed class OSBolFragmentState {
    object Init : OSBolFragmentState()
    data class CheckNroOS(val checkNroOS: Boolean) : OSBolFragmentState()
    data class CheckSetNroOS(val checkSetNroOS: Boolean) : OSBolFragmentState()
}