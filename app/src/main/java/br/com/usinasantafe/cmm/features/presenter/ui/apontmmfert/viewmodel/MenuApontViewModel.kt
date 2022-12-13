package br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.BuildConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.ListMenuPMM
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetApontTrabalhando
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuApontViewModel @Inject constructor (
    private val listMenuPMM: ListMenuPMM,
    private val setApontTrabalhando: SetApontTrabalhando
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<MenuApontFragmentState>(MenuApontFragmentState.Init)
    val uiStateFlow: StateFlow<MenuApontFragmentState> get() = _uiStateFlow

    private fun setListMenuApont(menuApontList: List<String>){
        _uiStateFlow.value = MenuApontFragmentState.ListMenuApont(menuApontList)
    }

    private fun setApontTrab(apontTrab: Boolean){
        _uiStateFlow.value = MenuApontFragmentState.SetApontTrab(apontTrab)
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
}