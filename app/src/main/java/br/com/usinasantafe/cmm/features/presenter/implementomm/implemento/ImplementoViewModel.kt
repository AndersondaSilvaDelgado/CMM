package br.com.usinasantafe.cmm.features.presenter.implementomm.implemento

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import br.com.usinasantafe.cmm.common.utils.StatusImplemento
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert.AddImplemento
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert.CheckImplemento
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert.ClearDataImplemento
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert.PositionImplemento
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateEquipSeg
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ImplementoViewModel @Inject constructor(
    private val positionImplemento: PositionImplemento,
    private val checkImplemento: CheckImplemento,
    private val addImplemento: AddImplemento,
    private val updateEquipSeg: UpdateEquipSeg,
    private val clearDataImplemento: ClearDataImplemento,
) : ViewModel() {

    private val _uiLiveData =
        MutableLiveData<ImplementoFragmentState>()
    val uiLiveData: LiveData<ImplementoFragmentState> = _uiLiveData

    private fun checkImplemento(checkImplemento: StatusImplemento) {
        _uiLiveData.value = ImplementoFragmentState.CheckImplemento(checkImplemento)
    }

    private fun checkAddImplemento(checkAddImplemento: Boolean) {
        _uiLiveData.value = ImplementoFragmentState.CheckAddImplemento(checkAddImplemento)
    }

    private fun clearImplemento(clearImplemento: Boolean) {
        _uiLiveData.value = ImplementoFragmentState.ReturnImplemento(clearImplemento)
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

    fun checkAddImplemento(nroEquip: String) = viewModelScope.launch {
        checkAddImplemento(addImplemento(nroEquip))
    }

    fun checkPositionImplemento() = viewModelScope.launch {
        setPosition(positionImplemento())
    }

    fun checkEquipImplemento(nroEquip: String) = viewModelScope.launch {
        checkImplemento(checkImplemento(nroEquip))
    }

    fun returnImplemento() = viewModelScope.launch {
        clearImplemento(clearDataImplemento())
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
    data class ReturnImplemento(val returnImplemento: Boolean): ImplementoFragmentState()
    data class CheckImplemento(val checkImplemento: StatusImplemento): ImplementoFragmentState()
    data class CheckPositionImplemento(val position: Int): ImplementoFragmentState()
    data class CheckAddImplemento(val checkAddImplemento: Boolean): ImplementoFragmentState()
    data class FeedbackUpdate(val statusUpdate: StatusUpdate) : ImplementoFragmentState()
    data class SetResultUpdate(val resultUpdateDatabase: ResultUpdateDatabase): ImplementoFragmentState()
}
