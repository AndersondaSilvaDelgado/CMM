package br.com.usinasantafe.cmm.features.presenter.ui.config.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.databinding.FragmentSenhaBinding
import br.com.usinasantafe.cmm.features.presenter.ui.config.viewmodel.SenhaFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.config.viewmodel.SenhaViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SenhaFragment : BaseFragment<FragmentSenhaBinding>(
    R.layout.fragment_senha,
    FragmentSenhaBinding::bind
) {

    private val viewModel: SenhaViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        observeState()
    }

    private fun setListener() {
        binding.buttonOkSenha.setOnClickListener {
            viewModel.verificarSenha(binding.editTextSenha.text.toString())
        }
        binding.buttonCancSenha.setOnClickListener {
            findNavController().navigate(R.id.action_senhaFragment_to_menuInicialFragment)
        }
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

    private fun handleStateChange(state: SenhaFragmentState){
        when(state){
            is SenhaFragmentState.Init -> Unit
            is SenhaFragmentState.Error -> handleErrorLogin()
            is SenhaFragmentState.Success -> handleSuccessLogin()
        }
    }

    private fun handleErrorLogin() {
        showGenericAlertDialog(getString(R.string.texto_senha_invalida), requireContext())
    }

    private fun handleSuccessLogin() {
        findNavController().navigate(R.id.action_senhaFragment_to_configFragment)
    }

}