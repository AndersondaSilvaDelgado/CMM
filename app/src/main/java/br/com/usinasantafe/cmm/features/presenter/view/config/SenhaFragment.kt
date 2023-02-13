package br.com.usinasantafe.cmm.features.presenter.view.config

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
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.databinding.FragmentSenhaBinding
import br.com.usinasantafe.cmm.features.presenter.viewmodel.config.SenhaFragmentState
import br.com.usinasantafe.cmm.features.presenter.viewmodel.config.SenhaViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SenhaFragment : BaseFragment<FragmentSenhaBinding>(
    R.layout.fragment_senha,
    FragmentSenhaBinding::bind
) {

    private val viewModel: SenhaViewModel by viewModels()
    private var fragmentAttachListenerConfig: FragmentAttachListenerConfig? = null

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
            fragmentAttachListenerConfig?.goMenuInicial()
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
        fragmentAttachListenerConfig?.goConfigFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerConfig){
            fragmentAttachListenerConfig = context
        }
        onBackPressed {
            fragmentAttachListenerConfig?.goMenuInicial()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerConfig = null
    }

}