package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetMatricFuncBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckMatricOperador
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateFunc
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OperadorBolViewModel @Inject constructor (
    private val checkMatricOperador: CheckMatricOperador,
    private val setMatricFuncBoletimMMFert: SetMatricFuncBoletimMMFert,
    private val updateFunc: UpdateFunc
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<OperadorBolFragmentState>(OperadorBolFragmentState.Init)
    val uiStateFlow: StateFlow<OperadorBolFragmentState> get() = _uiStateFlow

    private val _resultUpdateDataBase = MutableStateFlow<ResultUpdateDataBase?>(null)
    val resultUpdateDataBase : StateFlow<ResultUpdateDataBase?> get() = _resultUpdateDataBase

    private fun checkMatricOperador(checkMatricOperador: Boolean){
        _uiStateFlow.value = OperadorBolFragmentState.CheckMatricFunc(checkMatricOperador)
    }

    private fun checkSetMatricOperador(checkSetMatricOperador: Boolean){
        _uiStateFlow.value = OperadorBolFragmentState.CheckSetMatricFunc(checkSetMatricOperador)
    }

    private fun showUpdateFunc(){
        _uiStateFlow.value = OperadorBolFragmentState.IsUpdateFunc(true)
    }

    private fun hideUpdateFunc(){
        _uiStateFlow.value = OperadorBolFragmentState.IsUpdateFunc(false)
    }

    fun checkMatricFunc(matricOperador: String) = viewModelScope.launch {
        checkMatricOperador(checkMatricOperador(matricOperador))
    }

    fun setMatricFunc(matricOperador: String) = viewModelScope.launch {
        checkSetMatricOperador(setMatricFuncBoletimMMFert(matricOperador))
    }

    fun updateDataFunc() =
        viewModelScope.launch {
            updateFunc().
            onStart {
                showUpdateFunc()
            }
            .catch { catch ->
                _resultUpdateDataBase.value = ResultUpdateDataBase(1, "Erro: $catch", 100, 100)
            }
            .collect{ resultUpdateDataBase ->
                _resultUpdateDataBase.value = resultUpdateDataBase
                if(resultUpdateDataBase.percentage == 100){
                    hideUpdateFunc()
                }
            }
        }

}

sealed class OperadorBolFragmentState {
    object Init : OperadorBolFragmentState()
    data class CheckMatricFunc(val checkMatricOperador: Boolean) : OperadorBolFragmentState()
    data class CheckSetMatricFunc(val checkSetMatricOperador: Boolean): OperadorBolFragmentState()
    data class IsUpdateFunc(val isUpdateFunc: Boolean) : OperadorBolFragmentState()
}