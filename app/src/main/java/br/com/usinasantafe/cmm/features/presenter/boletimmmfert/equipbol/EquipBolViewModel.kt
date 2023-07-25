package br.com.usinasantafe.cmm.features.presenter.boletimmmfert.equipbol

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.entities.stable.Equip
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.GetEquipConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EquipBolViewModel @Inject constructor (
    private val getEquipConfig: GetEquipConfig
): ViewModel() {

    private val _uiLiveData = MutableLiveData<EquipBolFragmentState>()
    val uiLiveData: LiveData<EquipBolFragmentState> = _uiLiveData

    private fun getEquipNro(equip: Equip){
        _uiLiveData.value = EquipBolFragmentState.GetNroEquip(equip)
    }

    fun recoverNroEquip() = viewModelScope.launch {
        getEquipNro(getEquipConfig())
    }

}

sealed class EquipBolFragmentState {
    data class GetNroEquip(val equip: Equip) : EquipBolFragmentState()
}