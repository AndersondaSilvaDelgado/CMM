package br.com.usinasantafe.cmm.features.presenter.checklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CheckUpdateCheckList
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.OpenCheckList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckListViewModel @Inject constructor (
    private val checkUpdateCheckList: CheckUpdateCheckList,
    private val openCheckList: OpenCheckList
): ViewModel(){

    private val _uiLiveData = MutableLiveData<CheckListViewState>()
    val uiLiveData: LiveData<CheckListViewState> = _uiLiveData

    private fun checkOpenCheckList(checkOpenCheckList: Boolean) {
        _uiLiveData.value = CheckListViewState.CheckOpenCheckList(checkOpenCheckList)
    }

    fun checkBoletim() = viewModelScope.launch {
        if(checkUpdateCheckList()) {
            _uiLiveData.value = CheckListViewState.PergAtualCheckList
        } else {
            _uiLiveData.value = CheckListViewState.OpenCheckList
        }
    }

    fun setOpenCheckList() = viewModelScope.launch {
        checkOpenCheckList(openCheckList())
    }

}

sealed class CheckListViewState {
    object PergAtualCheckList : CheckListViewState()
    object OpenCheckList : CheckListViewState()
    data class CheckOpenCheckList(val checkOpenCheckList: Boolean) : CheckListViewState()
}