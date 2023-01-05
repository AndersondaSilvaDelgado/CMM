package br.com.usinasantafe.cmm.features.presenter.viewmodel.apontmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.BuildConfig
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.ListMenuPMM
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetApontTrabalhando
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.HasConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.RecoverConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuApontViewModel @Inject constructor (
    private val listMenuPMM: ListMenuPMM,
    private val setApontTrabalhando: SetApontTrabalhando,
    private val hasConfig: HasConfig,
    private val recoverConfig: RecoverConfig
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<MenuApontFragmentState>(MenuApontFragmentState.Init)
    val uiStateFlow: StateFlow<MenuApontFragmentState> get() = _uiStateFlow

    private fun setApontTrab(apontTrab: Boolean){
        _uiStateFlow.value = MenuApontFragmentState.SetApontTrab(apontTrab)
    }

    private fun setListMenuApont(menuApontList: List<String>){
        _uiStateFlow.value = MenuApontFragmentState.ListMenuApont(menuApontList)
    }

    private fun setStatusSend(statusSend: StatusSend){
        _uiStateFlow.value = MenuApontFragmentState.GetStatusSend(statusSend)
    }

    fun checkStatusSend() = viewModelScope.launch {
        if(hasConfig()){
            setStatusSend(recoverConfig()!!.statusEnvio)
        } else {
            setStatusSend(StatusSend.VAZIO)
        }
    }

    fun recoverListMenuApont() = viewModelScope.launch {
        if(BuildConfig.FLAVOR == "pmm"){
            setListMenuApont(listMenuPMM())
        }
    }

    fun setOpcaoMenu(pos: Int) = viewModelScope.launch {
        if(BuildConfig.FLAVOR == "pmm"){
            val listOpcaoMenu = listMenuPMM()
            when(listOpcaoMenu[pos]){
                "TRABALHANDO" -> setApontTrab(setApontTrabalhando())
            }
        }
    }

}

sealed class MenuApontFragmentState {
    object Init : MenuApontFragmentState()
    data class ListMenuApont(val menuApontList: List<String>) : MenuApontFragmentState()
    data class SetApontTrab(val apontTrab: Boolean) : MenuApontFragmentState()
    data class GetStatusSend(val statusSend: StatusSend) : MenuApontFragmentState()
}