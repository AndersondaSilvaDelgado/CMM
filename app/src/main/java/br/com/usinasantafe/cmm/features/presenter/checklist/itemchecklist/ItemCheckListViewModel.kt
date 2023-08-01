package br.com.usinasantafe.cmm.features.presenter.checklist.itemchecklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.common.utils.ChoiceCheckList
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemCheckListViewModel @Inject constructor (
    private val addRespItemCheckList: AddRespItemCheckList,
    private val closeCheckList: CloseCheckList,
    private val deleteRespItemCheckList: DeleteRespItemCheckList,
    private val getDescrItemCheckList: GetDescrItemCheckList,
    private val checkLastItemCheckList: CheckLastItemCheckList
): ViewModel(){

    private val _uiLiveData = MutableLiveData<ItemCheckListFragmentState>()
    val uiLiveData: LiveData<ItemCheckListFragmentState> = _uiLiveData

    private fun checkAddItemCheckList(checkAddItemCheckList: Boolean){
        _uiLiveData.value = ItemCheckListFragmentState.CheckAddItemCheckList(checkAddItemCheckList)
    }

    private fun checkCloseCheckList(checkCloseCheckList: Boolean){
        _uiLiveData.value = ItemCheckListFragmentState.CheckCloseCheckList(checkCloseCheckList)
    }

    private fun checkDeleteItemCheckList(checkAddItemCheckList: Boolean){
        _uiLiveData.value = ItemCheckListFragmentState.CheckDeleteItemCheckList(checkAddItemCheckList)
    }

    private fun checkLastRespItemCheckList(checkLastItemCheckList: Boolean){
        _uiLiveData.value = ItemCheckListFragmentState.CheckLastItemCheckList(checkLastItemCheckList)
    }

    private fun getItemCheckList(descrItemCheckList: String){
        _uiLiveData.value = ItemCheckListFragmentState.GetItemCheckList(descrItemCheckList)
    }

    fun recoverItemCheckList(position: Int) = viewModelScope.launch {
        getItemCheckList(getDescrItemCheckList(position))
    }

    fun checkAddRespItemCheckList(choiceCheckList: ChoiceCheckList, position: Int) = viewModelScope.launch {
        checkAddItemCheckList(addRespItemCheckList(choiceCheckList, position))
    }

    fun checkCloseCheckList() = viewModelScope.launch {
        checkCloseCheckList(closeCheckList())
    }

    fun checkDeleteRespItemCheckList(position: Int) = viewModelScope.launch {
        checkDeleteItemCheckList(deleteRespItemCheckList(position))
    }

    fun checkLastRespItemCheckList() = viewModelScope.launch {
        checkLastRespItemCheckList(checkLastItemCheckList())
    }

}

sealed class ItemCheckListFragmentState {
    data class GetItemCheckList(val descrItemCheckList: String): ItemCheckListFragmentState()
    data class CheckAddItemCheckList(val checkAddItemCheckList: Boolean): ItemCheckListFragmentState()
    data class CheckCloseCheckList(val checkCloseCheckList: Boolean): ItemCheckListFragmentState()
    data class CheckDeleteItemCheckList(val checkDeleteItemCheckList: Boolean): ItemCheckListFragmentState()
    data class CheckLastItemCheckList(val checkLastItemCheckList: Boolean): ItemCheckListFragmentState()
}