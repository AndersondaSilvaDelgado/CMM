package br.com.usinasantafe.cmm.features.presenter.ui.config.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.entities.Config
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.RecoverConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.SaveConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.manipulationdata.UpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfigViewModel @Inject constructor (
    private val recoverConfig: RecoverConfig,
    private val updateDataBase: UpdateDataBase,
    private val saveConfig: SaveConfig,
    private val checkUpdate: CheckUpdate
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<ConfigFragmentState>(ConfigFragmentState.Init)
    val uiStateFlow: StateFlow<ConfigFragmentState> get() = _uiStateFlow

    private val _resultUpdateDataBase = MutableStateFlow<ResultUpdateDataBase?>(null)
    val resultUpdateDataBase : StateFlow<ResultUpdateDataBase?> get() = _resultUpdateDataBase

    private fun setLoadingDataBase(){
        _uiStateFlow.value = ConfigFragmentState.IsLoadingDataBase(true)
    }

    private fun hideLoadingDataBase(){
        _uiStateFlow.value = ConfigFragmentState.IsLoadingDataBase(false)
    }

    private fun setLoadingEquip(){
        _uiStateFlow.value = ConfigFragmentState.IsLoadingEquip(true)
    }

    private fun hideLoadingEquip(){
        _uiStateFlow.value = ConfigFragmentState.IsLoadingEquip(false)
    }

    private fun setCheckUpdate(isCheckUpdate: Boolean){
        _uiStateFlow.value = ConfigFragmentState.IsCheckUpdate(isCheckUpdate)
    }

    private fun setConfig(config: Config){
        _uiStateFlow.value = ConfigFragmentState.RecoverConfig(config)
    }

    fun recoverDataConfig() = viewModelScope.launch {
        var config = recoverConfig()
        config?.let { setConfig(it) }
    }

    fun checkUpdateData() = viewModelScope.launch {
        setCheckUpdate(checkUpdate())
    }

    fun saveDataConfig(nroEquip: String, senha: String) =
        viewModelScope.launch {
            saveConfig(nroEquip, senha).
                onStart {
                    setLoadingEquip()
                }
                .catch { catch ->
                    _resultUpdateDataBase.value = ResultUpdateDataBase(100, "Erro: $catch", 100)
                }
                . collect { resultUpdateDataBase ->
                    _resultUpdateDataBase.value = resultUpdateDataBase
                    if(resultUpdateDataBase.percentage == 100){
                        hideLoadingEquip()
                    }
                }
        }

    fun updateDados() =
        viewModelScope.launch {
            updateDataBase().
                onStart {
                    setLoadingDataBase()
                }
                .catch { catch ->
                    _resultUpdateDataBase.value = ResultUpdateDataBase(100, "Erro: $catch", 100)
                }
                .collect{ resultUpdateDataBase ->
                    _resultUpdateDataBase.value = resultUpdateDataBase
                    if(resultUpdateDataBase.percentage == 100){
                        hideLoadingDataBase()
                    }
                }
        }
}

sealed class ConfigFragmentState {
    object Init : ConfigFragmentState()
    data class RecoverConfig(val config: Config) : ConfigFragmentState()
    data class IsLoadingDataBase(val isLoadingDataBase: Boolean) : ConfigFragmentState()
    data class IsLoadingEquip(val isLoadingEquip: Boolean) : ConfigFragmentState()
    data class IsCheckUpdate(val isCheckUpdate: Boolean) : ConfigFragmentState()
}