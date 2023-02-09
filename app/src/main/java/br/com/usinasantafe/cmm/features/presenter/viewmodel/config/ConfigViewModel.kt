package br.com.usinasantafe.cmm.features.presenter.viewmodel.config

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusRecover
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.common.utils.WEB_RETURN_CLEAR_EQUIP
import br.com.usinasantafe.cmm.features.domain.entities.variable.Config
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.RecoverConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.SaveConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.UpdateAllDataBase
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfigViewModel @Inject constructor(
    private val recoverConfig: RecoverConfig,
    private val updateAllDataBase: UpdateAllDataBase,
    private val saveConfig: SaveConfig,
    private val checkUpdate: CheckUpdate
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<ConfigFragmentState>(ConfigFragmentState.Init)
    val uiStateFlow: StateFlow<ConfigFragmentState> get() = _uiStateFlow

    private fun setLoadingDataBase(statusUpdate: StatusUpdate) {
        _uiStateFlow.value = ConfigFragmentState.FeedbackLoadingDataBase(statusUpdate)
    }

    private fun setLoadingEquip(statusRecover: StatusRecover) {
        _uiStateFlow.value = ConfigFragmentState.FeedbackLoadingEquip(statusRecover)
    }

    private fun setCheckUpdate(isCheckUpdate: Boolean) {
        _uiStateFlow.value = ConfigFragmentState.IsCheckUpdate(isCheckUpdate)
    }

    private fun setConfig(config: Config) {
        _uiStateFlow.value = ConfigFragmentState.RecoverConfig(config)
    }

    private fun setResultUpdate(resultUpdateDataBase: ResultUpdateDataBase){
        _uiStateFlow.value = ConfigFragmentState.SetResultUpdate(resultUpdateDataBase)
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
            saveConfig(nroEquip, senha)
                .catch { catch ->
                    setResultUpdate(ResultUpdateDataBase(100, "Erro: $catch", 100))
                    setLoadingEquip(StatusRecover.FALHA)
                }
                .collect { resultUpdateDataBase ->
                    setResultUpdate(resultUpdateDataBase)
                    if (resultUpdateDataBase.percentage == 100) {
                        if (resultUpdateDataBase.describe == WEB_RETURN_CLEAR_EQUIP) {
                            setLoadingEquip(StatusRecover.VAZIO)
                        } else {
                            setLoadingEquip(StatusRecover.SUCESSO)
                        }
                    }
                }
        }

    fun updateDataBaseInitial() =
        viewModelScope.launch {
            updateAllDataBase()
                .catch { catch ->
                    setResultUpdate(ResultUpdateDataBase(100, "Erro: $catch", 100))
                    setLoadingDataBase(StatusUpdate.FALHA)
                }
                .collect { resultUpdateDataBase ->
                    setResultUpdate(resultUpdateDataBase)
                    if (resultUpdateDataBase.percentage == 100) {
                        setLoadingDataBase(StatusUpdate.ATUALIZADO)
                    }
                }
        }
}

sealed class ConfigFragmentState {
    object Init : ConfigFragmentState()
    data class RecoverConfig(val config: Config) : ConfigFragmentState()
    data class FeedbackLoadingDataBase(val statusUpdateDataBase: StatusUpdate) :
        ConfigFragmentState()
    data class FeedbackLoadingEquip(val statusUpdateEquip: StatusRecover) : ConfigFragmentState()
    data class IsCheckUpdate(val isCheckUpdate: Boolean) : ConfigFragmentState()
    data class SetResultUpdate(val resultUpdateDataBase: ResultUpdateDataBase) : ConfigFragmentState()
}