package br.com.usinasantafe.cmm.features.presenter.apontmmfert.menuapont

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.ListMenuPMM
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetApontParada
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetApontTrabalhando
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.HasConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.RecoverConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuApontViewModel @Inject constructor(
    private val listMenuPMM: ListMenuPMM,
    private val setApontTrabalhando: SetApontTrabalhando,
    private val setApontParada: SetApontParada,
    private val hasConfig: HasConfig,
    private val recoverConfig: RecoverConfig
) : ViewModel() {

    private val _uiLiveData = MutableLiveData<MenuApontFragmentState>()
    val uiLiveData: LiveData<MenuApontFragmentState> = _uiLiveData

    private fun setApontTrab(apontTrab: Boolean) {
        _uiLiveData.value = MenuApontFragmentState.SetApontTrab(apontTrab)
    }

    private fun setApontPar(apontPar: Boolean) {
        _uiLiveData.value = MenuApontFragmentState.SetApontPar(apontPar)
    }

    private fun setListMenuApont(menuApontList: List<String>) {
        _uiLiveData.value = MenuApontFragmentState.ListMenuApont(menuApontList)
    }

    private fun setStatusSend(statusSend: StatusSend) {
        _uiLiveData.value = MenuApontFragmentState.GetStatusSend(statusSend)
    }

    private fun finishBoletim(){
        _uiLiveData.value = MenuApontFragmentState.FinishBoletim
    }

    fun checkStatusSend() = viewModelScope.launch {
        if (hasConfig()) {
            setStatusSend(recoverConfig()!!.statusEnvio!!)
        } else {
            setStatusSend(StatusSend.VAZIO)
        }
    }

    fun recoverListMenuApontPMM() = viewModelScope.launch {
        setListMenuApont(listMenuPMM())
    }

    fun setOpcaoMenuPMM(pos: Int, menuApontList: List<String>) = viewModelScope.launch {
        when (menuApontList[pos]) {
            "TRABALHANDO" -> setApontTrab(setApontTrabalhando())
            "PARADO" -> setApontPar(setApontParada())
            "FINALIZAR BOLETIM" -> finishBoletim()
        }
    }

}

sealed class MenuApontFragmentState {
    data class ListMenuApont(val menuApontList: List<String>) : MenuApontFragmentState()
    data class SetApontTrab(val apontTrab: Boolean) : MenuApontFragmentState()
    data class SetApontPar(val apontPar: Boolean) : MenuApontFragmentState()
    data class GetStatusSend(val statusSend: StatusSend) : MenuApontFragmentState()
    object FinishBoletim : MenuApontFragmentState()
}