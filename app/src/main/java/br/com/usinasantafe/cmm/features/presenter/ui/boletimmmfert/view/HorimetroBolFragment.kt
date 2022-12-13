package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGeneric
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGenericCVirgula
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.databinding.FragmentAtivBolBinding
import br.com.usinasantafe.cmm.databinding.FragmentHorimetroBolBinding
import br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.view.ApontActivity
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.AtivBolViewModel
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.HorimetroBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.HorimetroBolViewModel
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.OperadorBolFragmentState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

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
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiStateFlow.collect{
                    state -> handleStateChange(state)
                }
            }
        }
    }

    private fun setListener() {
        with(binding){
            setListenerButtonsGenericCVirgula(layoutBotoes, editTextPadrao)
            layoutBotoes.buttonOkPadrao.setOnClickListener {
                if(editTextPadrao.text.isNotEmpty()){
                    viewModel.setHorimetroInicial(editTextPadrao.text.toString())
                } else {
                    showGenericAlertDialog(getString(R.string.texto_campo_vazio, "HORIMETRO INICIAL"), requireContext())
                }
            }
        }
    }

    private fun handleStateChange(state: HorimetroBolFragmentState){
        when(state){
            is HorimetroBolFragmentState.Init -> Unit
            is HorimetroBolFragmentState.CheckSetHorimetro -> handleCheckSetMatricOperador(state.checkSetHorimetro)
        }
    }

    private fun handleCheckSetMatricOperador(checkSetHorimetro: Boolean) {
        if(checkSetHorimetro){
            val intent = Intent(requireContext(), ApontActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } else {
            showGenericAlertDialog(getString(R.string.texto_falha_insercao_campo, "HORIMETRO INICIAL"), requireContext())
        }
    }

}