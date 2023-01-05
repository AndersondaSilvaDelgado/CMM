package br.com.usinasantafe.cmm.features.presenter.view.config

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.adapter.CustomAdapter
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.databinding.FragmentMenuInicialBinding
import br.com.usinasantafe.cmm.features.presenter.viewmodel.config.MenuInicialFragmentState
import br.com.usinasantafe.cmm.features.presenter.viewmodel.config.MenuInicialViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuInicialFragment: BaseFragment<FragmentMenuInicialBinding>(
    R.layout.fragment_menu_inicial,
    FragmentMenuInicialBinding::bind,
) {

    private val viewModel: MenuInicialViewModel by viewModels()
    private val handler = Handler(Looper.getMainLooper())
    private var fragmentAttachListenerConfig: FragmentAttachListenerConfig? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        viewList()
        viewMsg()

    }

    private fun viewMsg() {
        handler.postDelayed(updateTimerThread, 0);
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
            onItemClick = { text, _ ->
                when(text){
                    "BOLETIM" -> eventBoletim()
                    "CONFIGURAÇÃO" -> eventConfig()
                    "SAIR" -> eventSair()
                }
            }
        }
        binding.listMenuInicial.run {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun eventBoletim(){
        viewModel.checkAccessBoletim()
    }

    private fun eventConfig(){
        fragmentAttachListenerConfig?.goSenhaFragment()
    }

    private fun eventSair(){
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private fun handleStateChange(state: MenuInicialFragmentState){
        when(state){
            is MenuInicialFragmentState.Init -> Unit
            is MenuInicialFragmentState.HasConfig -> handleBoletim(state.hasConfig)
            is MenuInicialFragmentState.GetStatusSend -> setProcesso(state.statusSend)
        }
    }

    private fun handleBoletim(hasConfig: Boolean){
        if(hasConfig){
            fragmentAttachListenerConfig?.goBoletimMMFert()
        } else {
            showGenericAlertDialog(getString(R.string.texto_falha_acesso_boletim), requireContext())
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
        with(binding.textViewProcesso){
            setTextColor(Color.RED)
            text = "Aparelho sem Equipamento"
        }
    }

    private fun statusEnviado(){
        with(binding.textViewProcesso){
            setTextColor(Color.GREEN)
            text = "Todos os Dados já foram Enviados"
        }
    }

    private fun statusEnviando(){
        with(binding.textViewProcesso){
            setTextColor(Color.YELLOW)
            text = "Enviando Dados..."
        }
    }

    private fun statusEnviar(){
        with(binding.textViewProcesso){
            setTextColor(Color.RED)
            text = "Existem Dados para serem Enviados"
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerConfig){
            fragmentAttachListenerConfig = context
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerConfig = null
    }

}