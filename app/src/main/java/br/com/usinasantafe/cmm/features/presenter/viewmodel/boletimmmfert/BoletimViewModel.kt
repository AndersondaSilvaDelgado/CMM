package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.StartBoletimMMFert
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoletimViewModel @Inject constructor (
    private val startBoletimMMFert: StartBoletimMMFert
): ViewModel(){

    fun startBoletim() = viewModelScope.launch {
        startBoletimMMFert()
    }

}
