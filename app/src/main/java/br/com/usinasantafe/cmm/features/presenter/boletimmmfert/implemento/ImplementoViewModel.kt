package br.com.usinasantafe.cmm.features.presenter.boletimmmfert.implemento

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.AddImplementoBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckImplemento
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.PositionImplemento
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateEquipSeg
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ImplementoViewModel @Inject constructor(
    private val positionImplemento: PositionImplemento,
    private val checkImplemento: CheckImplemento,
    private val addImplementoBoletimMMFert: AddImplementoBoletimMMFert,
    private val updateEquipSeg: UpdateEquipSeg,
) : ViewModel() {

    private val _uiLiveData =
        MutableLiveData<ImplementoFragmentState>()
    val uiLiveData: LiveData<ImplementoFragmentState> = _uiLiveData

    private fun checkImplemento(checkImplemento: Boolean) {
        _uiLiveData.value = ImplementoFragmentState.CheckImplemento(checkImplemento)
    }

    private fun checkAddImplemento(checkAddImplemento: Boolean) {
        _uiLiveData.value = ImplementoFragmentState.CheckAddImplemento(checkAddImplemento)
    }

    private fun setPosition(position: Int){
        _uiLiveData.value = ImplementoFragmentState.CheckPositionImplemento(position)
    }

    private fun setStatusUpdate(statusUpdate: StatusUpdate) {
        _uiLiveData.value = ImplementoFragmentState.FeedbackUpdate(statusUpdate)
    }

    private fun setResultUpdate(resultUpdateDatabase: ResultUpdateDatabase){
        _uiLiveData.value = ImplementoFragmentState.SetResultUpdate(resultUpdateDatabase)
    }

    fun addImplemento(nroEquip: String) = viewModelScope.launch {
        checkAddImplemento(addImplementoBoletimMMFert(nroEquip))
    }

    fun checkPositionImplemento() = viewModelScope.launch {
        setPosition(positionImplemento())
    }

    fun checkEquipImplemento(nroEquip: String) = viewModelScope.launch {
        checkImplemento(checkImplemento(nroEquip))
    }

    fun updateDataEquipSeg() =
        viewModelScope.launch {
            updateEquipSeg()
                .catch { catch ->
                    setResultUpdate(ResultUpdateDatabase(1, "Erro: $catch", 100, 100))
                    setStatusUpdate(StatusUpdate.FALHA)
                }
                .collect { resultUpdateDatabase ->
                    setResultUpdate(resultUpdateDatabase)
                    if (resultUpdateDatabase.percentage == 100) {
                        setStatusUpdate(StatusUpdate.ATUALIZADO)
                    }
                }
        }

}

sealed class ImplementoFragmentState {
    object Init : ImplementoFragmentState()
    data class CheckImplemento(val checkImplemento: Boolean): ImplementoFragmentState()
    data class CheckPositionImplemento(val position: Int): ImplementoFragmentState()
    data class CheckAddImplemento(val checkAddImplemento: Boolean): ImplementoFragmentState()
    data class FeedbackUpdate(val statusUpdate: StatusUpdate) : ImplementoFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase): ImplementoFragmentState()
}