package br.com.usinasantafe.cmm.features.presenter.view.boletimmmfert

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.onBackPressed
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGenericCVirgula
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.databinding.FragmentHorimetroBolBinding
import br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert.HorimetroBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert.HorimetroBolViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HorimetroBolFragment : BaseFragment<FragmentHorimetroBolBinding>(
    R.layout.fragment_horimetro_bol,
    FragmentHorimetroBolBinding::bind
) {

    private val viewModel: HorimetroBolViewModel by viewModels()
    private var fragmentAttachListenerBoletim: FragmentAttachListenerBoletim? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        startEvents()
        setListener()
    }

    private fun observe() {
        observeState()
    }

    private fun observeState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiStateFlow.collect{
                    state -> handleStateChange(state)
                }
            }
        }
    }

    private fun startEvents() {
        viewModel.checkBoletim()
    }

    private fun setListener() {
        with(binding){
            setListenerButtonsGenericCVirgula(layoutBotoes, editTextPadrao)
            layoutBotoes.buttonOkPadrao.setOnClickListener {
                if(editTextPadrao.text.isNotEmpty()){
                    viewModel.setHorimetro(editTextPadrao.text.toString())
                } else {
                    showGenericAlertDialog(getString(R.string.texto_campo_vazio, "HORIMETRO INICIAL"), requireContext())
                }
            }
        }
    }

    private fun handleStateChange(state: HorimetroBolFragmentState){
        when(state){
            is HorimetroBolFragmentState.Init -> Unit
            is HorimetroBolFragmentState.CheckSetHorimetroInicial -> handleCheckSetHorimetroInicial(state.checkSetHorimetroInicial)
            is HorimetroBolFragmentState.CheckSetHorimetroFinal -> handleCheckSetHorimetroFinal(state.checkSetHorimetroFinal)
            is HorimetroBolFragmentState.HorimetroInicial -> handleSetTitle("INICIAL")
            is HorimetroBolFragmentState.HorimetroFinal -> handleSetTitle("FINAL")
        }
    }

    private fun handleSetTitle(title: String){
        binding.textViewPadrao.text = getString(R.string.texto_horimetro, title)
    }

    private fun handleCheckSetHorimetroInicial(checkSetHorimetro: Boolean) {
        if(checkSetHorimetro){
            fragmentAttachListenerBoletim?.goAtivMMFert()
        } else {
            showGenericAlertDialog(getString(R.string.texto_falha_insercao_campo, "HORIMETRO INICIAL"), requireContext())
        }
    }

    private fun handleCheckSetHorimetroFinal(checkSetHorimetro: Boolean) {
        if(checkSetHorimetro){
            fragmentAttachListenerBoletim?.goConfig()
        } else {
            showGenericAlertDialog(getString(R.string.texto_falha_insercao_campo, "HORIMETRO FINAL"), requireContext())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerBoletim){
            fragmentAttachListenerBoletim = context
        }
        onBackPressed {
            fragmentAttachListenerBoletim?.goAtivBolFragment()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerBoletim = null
    }

}