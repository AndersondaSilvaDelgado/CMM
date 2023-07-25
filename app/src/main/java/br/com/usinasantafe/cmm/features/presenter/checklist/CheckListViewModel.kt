package br.com.usinasantafe.cmm.features.presenter.checklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CheckAtualCheckList
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.OpenCheckList
import kotlinx.coroutines.launch
import javax.inject.Inject

class CheckListViewModel @Inject constructor (
    private val checkAtualCheckList: CheckAtualCheckList,
    private val openCheckList: OpenCheckList
): ViewModel(){

    private val _uiLiveData = MutableLiveData<CheckListViewState>()
    val uiLiveData: LiveData<CheckListViewState> = _uiLiveData

    fun checkBoletim() = viewModelScope.launch {
        if(checkAtualCheckList()) {
            _uiLiveData.value = CheckListViewState.PergAtualCheckList
        } else {
            openCheckList()
            _uiLiveData.value = CheckListViewState.ItemCheckList
        }
    }

}

sealed class CheckListViewState {
    object PergAtualCheckList : CheckListViewState()
    object ItemCheckList : CheckListViewState()
}