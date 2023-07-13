package br.com.usinasantafe.cmm.features.presenter.viewmodel.checklist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ItemCheckListViewModel @Inject constructor (
): ViewModel(){

    private val _uiStateFlow = MutableStateFlow<ItemCheckListFragmentState>(ItemCheckListFragmentState.Init)
    val uiStateFlow: StateFlow<ItemCheckListFragmentState> get() = _uiStateFlow



    fun recoverItemCheckList(){

    }

}

sealed class ItemCheckListFragmentState {
    object Init : ItemCheckListFragmentState()
}