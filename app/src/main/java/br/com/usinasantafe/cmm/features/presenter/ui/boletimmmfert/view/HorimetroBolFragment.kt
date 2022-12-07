package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGeneric
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.databinding.FragmentAtivBolBinding
import br.com.usinasantafe.cmm.databinding.FragmentHorimetroBolBinding
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.AtivBolViewModel
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.HorimetroBolViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HorimetroBolFragment : BaseFragment<FragmentHorimetroBolBinding>(
    R.layout.fragment_horimetro_bol,
    FragmentHorimetroBolBinding::bind
) {

    private val viewModel: HorimetroBolViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        setListener()

    }

    private fun observe() {
        observeState()
    }

    private fun observeState(){
//        viewModel.uiStateFlow.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
//            .onEach { state -> handleStateChange(state) }
//            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun setListener() {
//        with(binding){
//            setListenerButtonsGeneric(layoutBotoes, editTextPadrao)
//            layoutBotoes.buttonOkPadrao.setOnClickListener {
//                if(editTextPadrao.text.isNotEmpty()){
//                    viewModel.checkMatricFunc(editTextPadrao.text.toString())
//                } else {
//                    showGenericAlertDialog(getString(R.string.texto_campo_vazio, "MATRICULA DO OPERADOR"), requireContext())
//                }
//            }
//            layoutBotoes.buttonAtualPadrao.setOnClickListener {
//                viewModel.updateDataFunc()
//            }
//        }
    }

}