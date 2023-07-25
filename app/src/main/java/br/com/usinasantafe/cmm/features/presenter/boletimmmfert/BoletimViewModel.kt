package br.com.usinasantafe.cmm.features.presenter.boletimmmfert

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckAbertoBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.StartBoletimMMFert
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoletimViewModel @Inject constructor (
    private val checkAbertoBoletimMMFert: CheckAbertoBoletimMMFert,
    private val startBoletimMMFert: StartBoletimMMFert
): ViewModel(){

    private val _uiLiveData = MutableLiveData<BoletimViewState>()
    val uiLiveData: LiveData<BoletimViewState> = _uiLiveData

    fun checkBoletim() = viewModelScope.launch {
        if(!checkAbertoBoletimMMFert()) {
            startBoletimMMFert()
            _uiLiveData.value = BoletimViewState.StartBoletim
        } else {
            _uiLiveData.value = BoletimViewState.FinishBoletim
        }
    }

}

sealed class BoletimViewState {
    object StartBoletim : BoletimViewState()
    object FinishBoletim : BoletimViewState()
}