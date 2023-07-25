package br.com.usinasantafe.cmm.features.presenter.checklist.itemchecklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ItemCheckListViewModel @Inject constructor (
): ViewModel(){

    private val _uiLiveData = MutableLiveData<ItemCheckListFragmentState>()
    val uiLiveData: LiveData<ItemCheckListFragmentState> = _uiLiveData



    fun recoverItemCheckList(){

    }

}

sealed class ItemCheckListFragmentState {
}