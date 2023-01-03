package br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.view

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.adapter.CustomAdapter
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.databinding.FragmentMenuApontBinding
import br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.viewmodel.MenuApontFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.viewmodel.MenuApontViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuApontFragment : BaseFragment<FragmentMenuApontBinding>(
    R.layout.fragment_menu_apont,
    FragmentMenuApontBinding::bind
) {

    private val viewModel: MenuApontViewModel by viewModels()
    private val handler = Handler(Looper.getMainLooper())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        startEvents()
        viewMsg()

    }

    private fun viewMsg() {
        handler.postDelayed(updateTimerThread, 0);
    }

    private fun observe() {
        observeState()
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateFlow.collect { state ->
                    handleStateChange(state)
                }
            }
        }
    }

    private fun viewList(menuApontList: List<String>) {

        val listAdapter = CustomAdapter(menuApontList).apply {
            onItemClick = { _, pos ->
                viewModel.setOpcaoMenu(pos)
            }
        }
        binding.listMenuPrinc.run {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun handleStateChange(state: MenuApontFragmentState) {
        when (state) {
            is MenuApontFragmentState.Init -> Unit
            is MenuApontFragmentState.ListMenuApont -> opcaoMenu(state.menuApontList)
            is MenuApontFragmentState.SetApontTrab -> setApontTrab(state.apontTrab)
            is MenuApontFragmentState.GetStatusSend -> setProcesso(state.statusSend)
        }
    }

    private fun opcaoMenu(menuApontList: List<String>) {
        viewList(menuApontList)
    }

    private fun startEvents() {
        viewModel.recoverListMenuApont()
    }

    private fun setApontTrab(setApontTrab: Boolean) {
        if (setApontTrab) {
            findNavController().navigate(R.id.action_menuApontFragment_to_OSApontFragment)
        } else {
            showGenericAlertDialog(
                getString(R.string.texto_falha_acesso_processo, "TRABALHANDO"),
                requireContext()
            )
        }
    }

    private fun setProcesso(statusSend: StatusSend){
        when(statusSend){
            StatusSend.VAZIO -> statusVazio()
            StatusSend.ENVIADO -> statusEnviado()
            StatusSend.ENVIANDO -> statusEnviando()
            StatusSend.ENVIAR -> statusEnviar()
        }
    }

    private val updateTimerThread = object: Runnable {
        override fun run() {
            viewModel.checkStatusSend()
            handler.postDelayed(this, 10000)
        }
    }

    private fun statusVazio(){
        with(binding.textViewProcessoNormal){
            setTextColor(Color.RED)
            text = "Aparelho sem Equipamento"
        }
    }

    private fun statusEnviado(){
        with(binding.textViewProcessoNormal){
            setTextColor(Color.GREEN)
            text = "Todos os Dados já foram Enviados"
        }
    }

    private fun statusEnviando(){
        with(binding.textViewProcessoNormal){
            setTextColor(Color.YELLOW)
            text = "Enviando Dados..."
        }
    }

    private fun statusEnviar(){
        with(binding.textViewProcessoNormal){
            setTextColor(Color.RED)
            text = "Existem Dados para serem Enviados"
        }
    }

}