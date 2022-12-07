package br.com.usinasantafe.cmm.features.presenter.ui.config.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.adapter.CustomAdapter
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.databinding.FragmentMenuInicialBinding
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.view.BoletimActivity
import br.com.usinasantafe.cmm.features.presenter.ui.config.viewmodel.MenuInicialFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.config.viewmodel.MenuInicialViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MenuInicialFragment: BaseFragment<FragmentMenuInicialBinding>(
    R.layout.fragment_menu_inicial,
    FragmentMenuInicialBinding::bind
) {

    private val viewModel: MenuInicialViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        viewList()

    }

    private fun observe() {
        observeState()
    }

    private fun observeState(){
        viewModel.uiStateFlow.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { state -> handleStateChange(state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun viewList() {

        val opcaoMenu = listOf(
            "BOLETIM",
            "CONFIGURAÇÃO",
            "SAIR",
            "REENVIO DE DADOS",
            "ATUALIZAR APLICATIVO",
            "LOG"
        )

        val listAdapter = CustomAdapter(opcaoMenu).apply {
            onItemClick = { text, pos ->
                when(text){
                    "BOLETIM" -> eventBoletim()
                    "CONFIGURAÇÃO" -> eventConfig()
                }
            }
        }
        binding.menuInicial.run {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun eventBoletim(){
        viewModel.checkAccessBoletim()
    }

    private fun eventConfig(){
        findNavController().navigate(R.id.action_menuInicialFragment_to_senhaFragment)
    }

    private fun handleStateChange(state: MenuInicialFragmentState){
        when(state){
            is MenuInicialFragmentState.Init -> Unit
            is MenuInicialFragmentState.HasConfig -> handleBoletim(state.hasConfig)
        }
    }

    private fun handleBoletim(hasConfig: Boolean){
        if(hasConfig){
            val intent = Intent(requireContext(), BoletimActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } else {
            showGenericAlertDialog(getString(R.string.texto_falha_acesso_boletim), requireContext())
        }
    }

}