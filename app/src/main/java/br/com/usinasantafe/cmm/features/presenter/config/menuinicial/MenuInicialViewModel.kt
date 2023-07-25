package br.com.usinasantafe.cmm.features.presenter.config.menuinicial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.HasConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.RecoverConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.UpdateAllDataBase
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuInicialViewModel @Inject constructor (
    private val hasConfig: HasConfig,
    private val recoverConfig: RecoverConfig,
    private val updateAllDataBase: UpdateAllDataBase,
): ViewModel() {

    private val _uiLiveData = MutableLiveData<MenuInicialFragmentState>()
    val uiLiveData: LiveData<MenuInicialFragmentState> = _uiLiveData

    private fun hasConfig(hasConfig: Boolean){
        _uiLiveData.value = MenuInicialFragmentState.HasConfig(hasConfig)
    }

    private fun setStatusSend(statusSend: StatusSend){
        _uiLiveData.value = MenuInicialFragmentState.GetStatusSend(statusSend)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase){
        _uiLiveData.value = MenuInicialFragmentState.SetResultUpdate(resultUpdateDatabase)
    }

    private fun setLoadingDataBase(statusUpdate: StatusUpdate) {
        _uiLiveData.value = MenuInicialFragmentState.FeedbackLoadingDataBase(statusUpdate)
    }

    fun checkAccessBoletim() = viewModelScope.launch {
        hasConfig(hasConfig())
    }

    fun checkStatusSend() = viewModelScope.launch {
        if(hasConfig()){
            setStatusSend(recoverConfig()!!.statusEnvio!!)
        } else {
            setStatusSend(StatusSend.VAZIO)
        }
    }

    fun updateDataBaseInitial() =
        viewModelScope.launch {
            updateAllDataBase()
                .catch { catch ->
                    setResultUpdate(ResultUpdateDatabase(100, "Erro: $catch", 100))
                    setLoadingDataBase(StatusUpdate.FALHA)
                }
                .collect { resultUpdateDatabase ->
                    setResultUpdate(resultUpdateDatabase)
                    if (resultUpdateDatabase.percentage == 100) {
                        setLoadingDataBase(StatusUpdate.ATUALIZADO)
                    }
                }
        }

}

sealed class MenuInicialFragmentState {
    data class HasConfig(val hasConfig: Boolean) : MenuInicialFragmentState()
    data class FeedbackLoadingDataBase(val statusUpdateDataBase: StatusUpdate) :
        MenuInicialFragmentState()
    data class GetStatusSend(val statusSend: StatusSend) : MenuInicialFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase) : MenuInicialFragmentState()
}