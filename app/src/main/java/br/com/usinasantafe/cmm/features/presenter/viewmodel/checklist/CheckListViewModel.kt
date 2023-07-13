package br.com.usinasantafe.cmm.features.presenter.viewmodel.checklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CheckAtualCheckList
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.OpenCheckList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CheckListViewModel @Inject constructor (
    private val checkAtualCheckList: CheckAtualCheckList,
    private val openCheckList: OpenCheckList
): ViewModel(){

    private val _uiStateFlow = MutableStateFlow<CheckListViewState>(CheckListViewState.Init)
    val uiStateFlow: StateFlow<CheckListViewState> get() = _uiStateFlow

    fun checkBoletim() = viewModelScope.launch {
        if(checkAtualCheckList()) {
            _uiStateFlow.value = CheckListViewState.PergAtualCheckList
        } else {
            openCheckList()
            _uiStateFlow.value = CheckListViewState.ItemCheckList
        }
    }

}

sealed class CheckListViewState {
    object Init : CheckListViewState()
    object PergAtualCheckList : CheckListViewState()
    object ItemCheckList : CheckListViewState()
}