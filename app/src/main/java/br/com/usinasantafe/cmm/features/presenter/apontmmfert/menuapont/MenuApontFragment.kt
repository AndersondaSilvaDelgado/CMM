package br.com.usinasantafe.cmm.features.presenter.apontmmfert.menuapont

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.viewModels
import br.com.usinasantafe.cmm.BuildConfig
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.adapter.CustomAdapter
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.onBackPressed
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.databinding.FragmentMenuApontBinding
import br.com.usinasantafe.cmm.features.presenter.apontmmfert.FragmentAttachListenerApont
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuApontFragment : BaseFragment<FragmentMenuApontBinding>(
    R.layout.fragment_menu_apont,
    FragmentMenuApontBinding::bind
) {

    private val viewModel: MenuApontViewModel by viewModels()
    private val handler = Handler(Looper.getMainLooper())
    private var fragmentAttachListenerApont: FragmentAttachListenerApont? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState()
        startEvents()
        viewMsg()

    }

    private fun viewMsg() {
        handler.postDelayed(updateTimerThread, 0);
    }

    private fun observeState() {
        viewModel.uiLiveData.observe(viewLifecycleOwner) {
            state -> handleStateChange(state)
        }
    }

    private fun viewList(menuApontList: List<String>) {
        val listAdapter = CustomAdapter(menuApontList).apply {
            onItemClick = { _, pos ->
                setOpcaoMenu(pos, menuApontList)
            }
        }
        binding.listMenuPrinc.run {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun handleStateChange(state: MenuApontFragmentState) {
        when (state) {
            is MenuApontFragmentState.ListMenuApont -> opcaoMenu(state.menuApontList)
            is MenuApontFragmentState.SetApontPar -> setApontPar(state.apontPar)
            is MenuApontFragmentState.SetApontTrab -> setApontTrab(state.apontTrab)
            is MenuApontFragmentState.GetStatusSend -> setProcesso(state.statusSend)
            is MenuApontFragmentState.FinishBoletim -> handleClosedBoletim()
        }
    }

    private fun handleClosedBoletim() {
        fragmentAttachListenerApont?.goBoletimMMFert()
    }

    private fun setOpcaoMenu(pos: Int, menuApontList: List<String>){
        if(BuildConfig.FLAVOR == "pmm"){
            viewModel.setOpcaoMenuPMM(pos, menuApontList)
        }
    }

    private fun opcaoMenu(menuApontList: List<String>) {
        viewList(menuApontList)
    }

    private fun startEvents() {
        if(BuildConfig.FLAVOR == "pmm") {
            viewModel.recoverListMenuApontPMM()
        }
    }

    private fun setApontPar(setApontPar: Boolean) {
        if (setApontPar) {
            fragmentAttachListenerApont?.goOSApontFragment()
        } else {
            showGenericAlertDialog(
                getString(R.string.texto_falha_acesso_processo, "TRABALHANDO"),
                requireContext()
            )
        }
    }
    private fun setApontTrab(setApontTrab: Boolean) {
        if (setApontTrab) {
            fragmentAttachListenerApont?.goOSApontFragment()
        } else {
            showGenericAlertDialog(
                getString(R.string.texto_falha_acesso_processo, "TRABALHANDO"),
                requireContext()
            )
        }
    }

    private fun setProcesso(statusSend: StatusSend){
        when(statusSend){
            StatusSend.EMPTY -> statusVazio()
            StatusSend.SENT -> statusEnviado()
            StatusSend.SENDING -> statusEnviando()
            StatusSend.SEND -> statusEnviar()
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerApont){
            fragmentAttachListenerApont = context
        }
        onBackPressed {}
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerApont = null
    }

}